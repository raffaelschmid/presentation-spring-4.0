package com.trivadis.boot.batch.cityimport;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trivadis.boot.batch.City;

@Configuration
public class BatchJob {

	private static final String STEP = "step.city-import.partitioned-read-write";
	private static final String STEP_SUMMARY = "step.city-import.summary";

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	private DataSource dataSource;

	@Bean
	public Job job() throws Exception {
		return this.jobs.get("job.city-import").start(partitionedReadWrite())
				.next(summary()).build();
	}

	private Step summary() {
		return this.steps.get(STEP_SUMMARY)
				.tasklet(new CityImportSummary(new JdbcTemplate(dataSource)))
				.build();
	}

	@Bean
	protected Step partitionedReadWrite() throws Exception {

		StepBuilder step = this.steps.get(STEP);

		SimpleStepBuilder<City, City> chunk = step.chunk(100);
		chunk.reader(cityReader());
		chunk.writer(new CityImportWriter(new JdbcTemplate(dataSource)));

		return chunk.build();
	}

	private ItemReader<? extends City> cityReader() {
		FlatFileItemReader<City> itemReader = new FlatFileItemReader<>();
		itemReader.setLinesToSkip(1);
		itemReader.setResource(new ClassPathResource("cities.txt"));
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

	private LineMapper<City> lineMapper() {
		DefaultLineMapper<City> lineMapper = new DefaultLineMapper<City>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "countryCode", "cityName" });
		lineTokenizer.setIncludedFields(new int[] { 0, 2 });
		BeanWrapperFieldSetMapper<City> fieldSetMapper = new BeanWrapperFieldSetMapper<City>();
		fieldSetMapper.setTargetType(City.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}

}