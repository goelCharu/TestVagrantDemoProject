package com.demo.utils.accuWeather;

import com.demo.constants.AWConstants;
import com.demo.restAssured.request.GetRequestAW;
import io.restassured.response.Response;

import java.util.Map;

/**
 * wrapper class containing different get methods depending on needs
 */
public class GetWeatherOfCity {
    final String baseUrl = AWConstants.BASE_URL;
    final String basePath = AWConstants.BASE_PATH;
    final String apiKey = AWConstants.API_KEY;

    /**
     * Get response by passing city name
     * @param city
     * @return
     */
    public Response getWeatherofCityResponse(String city){
        GetRequestAW weatherObj = new GetRequestAW(baseUrl);
        weatherObj.setBasePath(basePath);
        weatherObj.setQueryParameter("appid", apiKey);
        weatherObj.setQueryParameter("q", city);
        Response response = weatherObj.get();
        return response;
    }

    /**
     * overloaded method to pass as much as query parameters into argument
     * @param queryParams
     * @param <T>
     * @return
     */
    public <T> Response getWeatherofCityResponse(Map<String, T> queryParams){
        GetRequestAW weatherObj = new GetRequestAW(baseUrl);
        weatherObj.setBasePath(basePath);
        weatherObj.setQueryParameter("appid", apiKey);

        for (Map.Entry<String, T> entry :  queryParams.entrySet()){
            weatherObj.setQueryParameter(entry.getKey(), entry.getValue());
        }

        Response response = weatherObj.get();
        return response;
    }

}
