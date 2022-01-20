package com.demo.pageEvents;

import com.demo.pageObjects.AWPageElements;
import com.demo.utils.ElementsFetch;
import org.openqa.selenium.Keys;
import org.testng.Assert;


/**
 * class for querying AW home page web Elements
 */
public class AWPageEvents {
    public void enterTextOnSearchTextBox(String loc) {
        ElementsFetch elementFetch = new ElementsFetch();
        elementFetch.getWebElement("XPATH" , AWPageElements.searchTextBox).sendKeys(loc);
        elementFetch.getWebElement("XPATH" , AWPageElements.searchTextBox).sendKeys(Keys.ENTER);
        elementFetch.getWebElement("XPATH" , AWPageElements.temp).getText();
    }

    public void verifyTemperature() {
        ElementsFetch elementFetch = new ElementsFetch();
        elementFetch.getWebElement("XPATH" , AWPageElements.temp).getText();
        Assert.assertFalse( elementFetch.getWebElement("XPATH" , AWPageElements.temp).getText().isBlank());

    }
    public void verifyAirQuality() {
        ElementsFetch elementFetch = new ElementsFetch();
        elementFetch.getWebElement("XPATH" , AWPageElements.airQualityLabel).getText();
        elementFetch.getWebElement("XPATH" , AWPageElements.airQualityValue).getText();
        Assert.assertFalse( elementFetch.getWebElement("XPATH" , AWPageElements.airQualityValue).getText().isBlank());

    }

    public void verifyWind() {
        ElementsFetch elementFetch = new ElementsFetch();
        elementFetch.getWebElement("XPATH" , AWPageElements.windLabel).getText();
        elementFetch.getWebElement("XPATH" , AWPageElements.windValue).getText();
        Assert.assertFalse( elementFetch.getWebElement("XPATH" , AWPageElements.windValue).getText().isBlank());

    }
    public void verifyWindGusts() {
        ElementsFetch elementFetch = new ElementsFetch();
        elementFetch.getWebElement("XPATH" , AWPageElements.windGustsLabel).getText();
        elementFetch.getWebElement("XPATH" , AWPageElements.windGustsValue).getText();
        Assert.assertFalse( elementFetch.getWebElement("XPATH" , AWPageElements.windGustsValue).getText().isBlank());

    }
    public Double getTemperatureValue(String loc) {
        ElementsFetch elementFetch = new ElementsFetch();
        elementFetch.getWebElement("XPATH" , AWPageElements.searchTextBox).sendKeys(loc);
        elementFetch.getWebElement("XPATH" , AWPageElements.searchTextBox).sendKeys(Keys.ENTER);
        String tempValue = elementFetch.getWebElement("XPATH" , AWPageElements.temp).getText();
        tempValue = tempValue.replaceAll("°C","");
       return Double.valueOf(tempValue);
    }

}
