package test.suite.track;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.api.http.client.requests.OrdersRequest;
import ru.yandex.api.models.request.OrderModel;
import ru.yandex.api.models.request.builder.OrderBuilder;
import ru.yandex.ui.data.Url;
import ru.yandex.ui.po.pages.TrackOrderPage;

import static com.codeborne.selenide.Selenide.page;

public class OrderTrackSuccessFindTest {

    private TrackOrderPage trackOrderPage = page(TrackOrderPage.class);
    private String trackOrder;
    private OrderModel orderBuild;

    @BeforeTest
    public void getTrackNumber(){

        orderBuild = new OrderBuilder().getJsonOrder();
        int track = new OrdersRequest()
                .createOrder(orderBuild)
                .extract().path("track");
        trackOrder = String.valueOf(track);
    }

    // Тест проверяет, что поиск заказа, через поле "Поиск заказа" в хедере, с невалидным номером - провалится
    @Test
    public void searchOrderInHeader_ValidTrack_OrderFound() {

        trackOrderPage
                .open(Url.MainPage)
                .clickButtonOrderStatus()
                .setValueInputSearchNumberOrderInHeader(trackOrder)
                .clickButtonGoSearchNumberOrder()
                .isOrderFound();
    }

    // Тест проверяет, что поиск заказа, через поле "Поиск заказа" на странице статус заказа,
    // с невалидным номером - провалится
    @Test
    public void searchOrderOnStatusOrderPage_ValidTrack_OrderFound() {

        trackOrderPage
                .open(Url.TrackPage)
                .setValueInputSearchNumberOrderInOrderStatusPage(trackOrder)
                .clickButtonWatchSearchNumberOrder()
                .isOrderFound();
    }

    @Test
    public void searchOrder_PhoneVisible(){

        trackOrderPage
                .open(Url.TrackPage)
                .setValueInputSearchNumberOrderInOrderStatusPage(trackOrder)
                .clickButtonWatchSearchNumberOrder()
                .isPhoneFound(orderBuild);
    }

    @Test
    public void searchOrder_LastNameVisible(){

        trackOrderPage
                .open(Url.TrackPage)
                .setValueInputSearchNumberOrderInOrderStatusPage(trackOrder)
                .clickButtonWatchSearchNumberOrder()
                .isLastNameFound(orderBuild);
    }

    @Test
    public void searchOrder_AddressVisible(){

        trackOrderPage
                .open(Url.TrackPage)
                .setValueInputSearchNumberOrderInOrderStatusPage(trackOrder)
                .clickButtonWatchSearchNumberOrder()
                .isAddressFound(orderBuild);
    }
}
