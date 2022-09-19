package ru.yandex.ui.po.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.api.models.request.OrderModel;
import ru.yandex.ui.po.BasePage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TrackOrderPage extends BasePage<TrackOrderPage> {

    @FindBy(how = How.XPATH, using = "//input[@class='Input_Input__1iN_Z Track_Input__1g7lq Input_Responsible__1jDKN']")
    private SelenideElement inputSearchNumberOrderInOrderStatusPage;

    @FindBy(how = How.XPATH, using = "//button[text()='Посмотреть']")
    private SelenideElement buttonWatchSearchNumberOrder;

    @FindBy(how = How.XPATH, using = "//img[@src='/assets/not-found.png']")
    private SelenideElement imgNotFound;

    @FindBy(how = How.XPATH, using = "//*[text()='Отменить заказ']")
    private SelenideElement buttonCancelOrder;

    @FindBy(how = How.XPATH, using = "//*[text()='Имя']/following-sibling::*")
    private SelenideElement inputLastName;

    @FindBy(how = How.XPATH, using = "//*[text()='Адрес']/following-sibling::*")
    private SelenideElement inputAddress;

    @FindBy(how = How.XPATH, using = "//*[text()='Телефон']/following-sibling::*")
    private SelenideElement inputPhone;


    // Метод позволяет заполнить поле поиска заказа на странице статуса заказа
    public TrackOrderPage setValueInputSearchNumberOrderInOrderStatusPage(String valueForSearchOrder) {

        inputSearchNumberOrderInOrderStatusPage.scrollTo().shouldHave
                (Condition.visible).setValue(valueForSearchOrder);
        return this;
    }

    // Метод позволяет на кнопку "Посмотреть", кнопка находиться непосредственно на странице поиска заказа
    public TrackOrderPage clickButtonWatchSearchNumberOrder() {
        buttonWatchSearchNumberOrder.click();
        return this;
    }

    // Метод проверяет, что по-указанному номеру заказа, заказа нет
    public TrackOrderPage isDisplayedImgNotFoundOrder() {
        imgNotFound.shouldHave(Condition.visible, Duration.ofMillis(1500));
        return this;
    }

    // Метод проверяет, что заказ найден по его номеру и важные поля отобразились
    public TrackOrderPage isOrderFound(){

        buttonCancelOrder.shouldBe(Condition.visible);
        return this;
    }

    public void isPhoneFound(OrderModel orderBuild) {

        assertEquals(orderBuild.getPhone(),
                inputPhone.shouldBe(Condition.visible).getText(),
                "Не отобразился номер телефона в найденном заказе");
    }

    public void isLastNameFound(OrderModel orderBuild) {

        assertEquals(orderBuild.getFirstName(),
                inputLastName.shouldBe(Condition.visible).getText(),
                "Не отобразилось имя в найденном заказе");
    }

    public void isAddressFound(OrderModel orderBuild) {

        assertEquals(orderBuild.getAddress(),
                inputAddress.shouldBe(Condition.visible).getText(),
                "Не отобразился адрес для доставки в найденном заказе");
    }
}