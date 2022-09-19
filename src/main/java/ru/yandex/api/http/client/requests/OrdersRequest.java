package ru.yandex.api.http.client.requests;

import io.restassured.response.ValidatableResponse;
import ru.yandex.api.http.client.BaseHttp;
import ru.yandex.api.models.request.OrderModel;

import static io.restassured.RestAssured.given;

public class OrdersRequest extends BaseHttp {

    public ValidatableResponse createOrder (OrderModel orderModel){

        return given()
                .spec(baseSpec())
                .and()
                .body(orderModel)
                .when()
                .post("/api/v1/orders")
                .then();
    }
}


