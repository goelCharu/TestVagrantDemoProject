package com.demo;

import com.demo.constants.AWConstants;
import com.demo.restAPI.CityTempTests;
import org.testng.annotations.Test;
import com.demo.pageEvents.AWPageEvents;
import com.demo.utils.CustomComparator;
import com.demo.utils.accuWeather.GetWeatherOfCity;
import com.demo.utils.accuWeather.deserializer.Deserializer;

/**
 * TestNG class containing demo tests
 * verifyWeatherInformationForCity - passes
 * verifyWeatherInformationForCityWithInRange - passes
 * verifyWeatherInformationForCityWithInRange - fails throwing exception
 */

public class TempTest extends BaseTest {
    Deserializer deserializerObj = new Deserializer();
    CustomComparator customComparator = new CustomComparator();
    GetWeatherOfCity cityWeather = new GetWeatherOfCity();
    AWPageEvents awPageEvents = new AWPageEvents();
    CityTempTests cityTempTests = new CityTempTests(deserializerObj, customComparator, cityWeather, AWConstants.LOCATION);


    //This testcase check current weather information of the selected city
    @Test
    public void verifyWeatherInformationForCity(){
        awPageEvents.enterTextOnSearchTextBox(AWConstants.LOCATION);
        awPageEvents.verifyWind();
        awPageEvents.verifyWindGusts();
        awPageEvents.verifyTemperature();
        awPageEvents.verifyAirQuality();
    }

    //This testcase matches  the data from two different sources i.e API and UI
    //This testcase should pass with the provided precision range
    @Test
    public void verifyWeatherInformationForCityWithInRange(){
          cityTempTests.compareTempOfTwoSource_WithinRange(awPageEvents.getTemperatureValue(AWConstants.LOCATION));
    }

    //This testcase matches  the data from two different sources i.e API and UI
    //This testcase should fail with the provided precision range and throws an exception
    @Test
    public void verifyWeatherInformationForCityOutOfRange(){
        cityTempTests.compareTempOfTwoSource_OutOfRange(awPageEvents.getTemperatureValue(AWConstants.LOCATION));

    }

}
