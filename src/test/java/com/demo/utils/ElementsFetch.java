package com.demo.utils;


import com.demo.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * this class contains query by ID, CSS, TAGNAME, XPATH to page /web element
 */
public class ElementsFetch {
    /**
     *
     * @param identifierType
     * @param identifierValue
     * @return
     */
    public WebElement getWebElement(String identifierType,String identifierValue){
        switch(identifierType){
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            default:
                return null;

        }

    }

}
