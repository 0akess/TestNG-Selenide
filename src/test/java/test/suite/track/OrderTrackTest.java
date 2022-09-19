package test.suite.track;

import org.testng.annotations.Test;
import ru.yandex.ui.po.pages.TrackOrderPage;
import ru.yandex.ui.data.Url;

import static com.codeborne.selenide.Selenide.page;

public class OrderTrackTest   {

    private final TrackOrderPage trackOrderPage = page(TrackOrderPage.class);

    // Тест проверяет, что поиск заказа, через поле "Поиск заказа" в хедере, с невалидным номером - провалится
    @Test
    public void searchOrderInHeader_InvalidTrack_NotFound() {

        trackOrderPage
                .open(Url.MainPage)
                .clickButtonOrderStatus()
                .setValueInputSearchNumberOrderInHeader("123")
                .clickButtonGoSearchNumberOrder()
                .isDisplayedImgNotFoundOrder();
    }

    // Тест проверяет, что поиск заказа, через поле "Поиск заказа" на странице статус заказа,
    // с невалидным номером - провалится
    @Test
    public void searchOrderOnStatusOrderPage_InvalidTrack_NotFound() {

        trackOrderPage
                .open(Url.TrackPage)
                .setValueInputSearchNumberOrderInOrderStatusPage("1234")
                .clickButtonWatchSearchNumberOrder()
                .isDisplayedImgNotFoundOrder();
    }

    // Тест проверяет, что поиск заказа, через поле "Поиск заказа" на странице статус заказа,
    //с использованием букв, вместо цифр - провалится
    @Test
    public void searchStatusOrderByLetters() {

        trackOrderPage
                .open(Url.TrackPage)
                .setValueInputSearchNumberOrderInOrderStatusPage("sdfsdf")
                .clickButtonWatchSearchNumberOrder()
                .isDisplayedImgNotFoundOrder();
    }

    // Тест проверяет, что находясь на странице оформления заказа
    //и кликая на кнопку "Скутер", пользователь остается на главной
    @Test
    public void checkButtonScooterInPageOrderCreate() {

        trackOrderPage
                .open(Url.TrackPage)
                .clickButtonScooter()
                .isManeScooter();
    }

    // Тест проверяет, что находясь на странице оформления заказа и кликая на
    // кнопку "Яндекс", у пользователя открывается страница с Яндексом
    @Test
    public void checkButtonYandexInOrderStatusPage() {

        trackOrderPage
                .open(Url.TrackPage)
                .clickButtonYandex()
                .isYandex();
    }
}