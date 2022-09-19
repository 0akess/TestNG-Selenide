package ru.yandex.ui.po;

import com.codeborne.selenide.Selenide;
import ru.yandex.ui.po.components.HeadersComponents;
import ru.yandex.ui.data.Url;

public abstract class BasePage<T> extends HeadersComponents<T> {

    public T open(Url url) {
        Selenide.open(url.getUrl());
        return (T) this;
    }
}
