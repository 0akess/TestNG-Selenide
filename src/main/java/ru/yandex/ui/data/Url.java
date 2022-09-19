package ru.yandex.ui.data;

import static ru.yandex.utils.Properties.loadProperty;

public enum Url {

    Yandex(loadProperty("Yandex")),
    MainPage(loadProperty("MainPage")),
    OrderPage(loadProperty("OrderPage")),
    TrackPage(loadProperty("TrackPage"));

    private String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
