package ru.yandex.api.models.request.builder;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import ru.yandex.api.models.request.OrderModel;

import java.time.LocalDateTime;

public class OrderBuilder {

    public OrderModel getJsonOrder() {

        String firstName = RandomStringUtils.randomAlphabetic(6);
        String lastName = RandomStringUtils.randomAlphabetic(6);
        String address = RandomStringUtils.randomAlphabetic(10);

        int metroStation = RandomUtils.nextInt(1, 15);
        String phone = RandomStringUtils.randomNumeric(11);
        int rentTime = RandomUtils.nextInt(1, 7);
        String deliveryDate = String.valueOf(LocalDateTime.now().toLocalDate());
        String comment = RandomStringUtils.randomAlphabetic(10);
        String[] color = {"GREY"};

        OrderModel order = new OrderModel(firstName, lastName, address,
                metroStation, phone, rentTime, deliveryDate, comment, color);

        return order;
    }
}