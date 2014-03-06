package com.trivadis.boot.batch.cityimport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class CityImportSummary implements Tasklet {

	private static final String COUNTY_CITIES = "select count(*) from city";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CityImportSummary.class);

	private final JdbcTemplate jdbc;

	public CityImportSummary(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		LOGGER.info("number of cities registered: {}",
				jdbc.queryForObject(COUNTY_CITIES, Integer.class));

		return RepeatStatus.FINISHED;
	}
}
