package com.demo.pageObjects;

/**
 * locators
 */
public interface AWPageElements {
    String searchTextBox = "//input[@class='search-input']" ;
    String temp = "(//DIV[@class='temp'])[1]";
    String airQualityLabel = "//div[@class='spaced-content detail'][1]/span[@class='label']";
    String airQualityValue = "//div[@class='spaced-content detail'][1]/span[@class='value']";
    String windLabel = "//div[@class='spaced-content detail'][2]/span[@class='label']";
    String windValue = "//div[@class='spaced-content detail'][2]/span[@class='value']";
    String windGustsLabel = "//div[@class='spaced-content detail'][3]/span[@class='label']";
    String windGustsValue = "//div[@class='spaced-content detail'][3]/span[@class='value']";

}
