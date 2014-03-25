package com.trivadis.boot.batch;

public class City {

	private String countryCode, cityName;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [countryCode=" + countryCode + ", cityName=" + cityName
				+ "]";
	}

}
