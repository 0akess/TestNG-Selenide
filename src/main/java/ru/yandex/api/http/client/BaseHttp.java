package ru.yandex.api.http.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.yandex.ui.data.Url;

public class BaseHttp {

    protected RequestSpecification baseSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(Url.MainPage.getUrl())
                .build();
    }
}
