package com.demo.restAssured.request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Request for Get verb
 */
public class GetRequestAW extends BaseRequest {

    public GetRequestAW(String baseUrl){
        super(baseUrl);
    }

    public <T> void setQueryParameter(String key, T value){
        getRequestSpecification().queryParam(key, value);
    }

    public void setBasePath(String basePath){
        getRequestSpecification().basePath(basePath);
    }

    /**
     *
     * @return response of Get verb request
     */
    public Response get(){
        Response response = given().relaxedHTTPSValidation().spec(getRequestSpecification()).get().then().extract().response();
        return response;
    }
}
