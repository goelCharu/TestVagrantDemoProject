package com.demo.restAPI;

import com.demo.constants.AWConstants;
import com.demo.customedExceptions.OutOfPermissibleRange;
import io.restassured.response.Response;
import org.apache.juneau.parser.ParseException;
import org.testng.Assert;
import com.demo.accuweather.pojo.api.queryparam.city.CityResponse;
import com.demo.utils.CustomComparator;
import com.demo.utils.accuWeather.GetWeatherOfCity;
import com.demo.utils.accuWeather.deserializer.Deserializer;

/**
 * TEST class for weather comparison for two different sources API and UI
 */

public class CityTempTests {

    Deserializer deserializerObj ;
    CustomComparator customComparator ;
    GetWeatherOfCity cityWeather ;

    public CityTempTests(Deserializer deserializerObj, CustomComparator customComparator, GetWeatherOfCity cityWeather, String location) {
        this.deserializerObj = deserializerObj;
        this.customComparator = customComparator;
        this.cityWeather = cityWeather;
    }

    /**
     *
     * @param UiTemp
     */
    public void compareTempOfTwoSource_WithinRange(double UiTemp) {
        try{
            Double permissibleRange = 5.0;
            UiTemp = UiTemp + AWConstants.KELVIN;
            String city = AWConstants.LOCATION;
            compareTempOfTwoSource(UiTemp, UiTemp , city);
        }catch(ParseException parseExcep){
            parseExcep.printStackTrace();
            Assert.fail();
        } catch (OutOfPermissibleRange outOfPermissibleRange) {
            outOfPermissibleRange.printStackTrace();
            Assert.fail();
        } finally{

        }
    }



    /**
     *
     * @param UiTemp
     */
   
    public void compareTempOfTwoSource_OutOfRange(double UiTemp) {
        try{
            String city = AWConstants.LOCATION;

            UiTemp = UiTemp+ AWConstants.KELVIN;
            Double permissibleRange = 0.1;
            compareTempOfTwoSource(UiTemp, permissibleRange , city);

        }catch(ParseException parseExcep){
            Assert.fail();
        } catch (OutOfPermissibleRange outOfPermissibleRange) {
            outOfPermissibleRange.printStackTrace();
            Assert.fail();
        } finally{

        }


    }

    /**
     *
     * @param UiTemp
     * @param permissibleRange
     * @param city
     * @throws ParseException
     * @throws OutOfPermissibleRange
     */
    private void compareTempOfTwoSource(double UiTemp, Double permissibleRange, String city ) throws ParseException, OutOfPermissibleRange {

        System.out.println(String.format("Getting temperature for %s city", city));
        Response res = cityWeather.getWeatherofCityResponse(city);
        Assert.assertEquals(res.getStatusCode(), 200,
                "Status code mismatch for 1st request.");
        CityResponse cityWeatherObj = deserializerObj.getDeserializedObj(res.getBody().asString(),
                CityResponse.class);

        System.out.println("Temperature for "+city +" from API "+ cityWeatherObj.getMain().getTemp());
        System.out.println("Temperature for "+city +" from UI "+ UiTemp);
        boolean isPermissible = customComparator.comparePermissibleRange(cityWeatherObj.getMain().getTemp(),
                UiTemp, permissibleRange);

        System.out.println("Is temp(Kelvin) within " + permissibleRange + " permissible range - " + isPermissible);
        if (!isPermissible){
            throw new OutOfPermissibleRange("Permissible temp out of range among different call" +
                    "temperatures = [" + UiTemp + "," +
                    cityWeatherObj.getMain().getTemp()+ "]");
        }
    }

}
