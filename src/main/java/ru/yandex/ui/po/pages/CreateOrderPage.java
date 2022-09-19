package ru.yandex.ui.po.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.ui.po.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CreateOrderPage extends BasePage<CreateOrderPage> {

    @FindBy(how = How.XPATH, using = "//button[text()='Заказать']")
    private ElementsCollection buttonOrderScooter;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='* Имя']")
    private SelenideElement inputFirstName;

    @FindBy(how = How.XPATH, using = "//div[text()='Введите корректное имя']")
    private SelenideElement errorMassageFirstName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='* Фамилия']")
    private SelenideElement inputLastName;

    @FindBy(how = How.XPATH, using = "//div[text()='Введите корректную фамилию']")
    private SelenideElement errorMassageLastName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='* Адрес: куда привезти заказ']")
    private SelenideElement inputAddress;

    @FindBy(how = How.XPATH, using = "//div[text()='Введите корректный адрес']")
    private SelenideElement errorMassageAddress;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='* Станция метро']")
    private SelenideElement inputMetro;

    @FindBy(how = How.XPATH, using = "//div[text()='Выберите станцию']")
    private SelenideElement errorMassageMetro;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='* Телефон: на него позвонит курьер']")
    private SelenideElement inputNumberPhone;

    @FindBy(how = How.XPATH, using = "//div[text()='Введите корректный номер']")
    private SelenideElement errorMassageNumberPhone;

    @FindBy(how = How.XPATH, using = "//button[text()='Далее']")
    private SelenideElement buttonNextStep;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='* Когда привезти самокат']")
    private SelenideElement inputDateForDelivery;

    @FindBy(how = How.XPATH, using = "//div[text()='* Срок аренды']")
    private SelenideElement selectorRentalPeriod;

    @FindBy(how = How.XPATH, using = "//div[@class='Dropdown-option']")
    private ElementsCollection dropDawnSelectDayForRent;

    @FindBy(how = How.XPATH, using = "//input[@id='black']")
    private SelenideElement chooseColorForScooterBlack;

    @FindBy(how = How.XPATH, using = "//input[@id='grey']")
    private SelenideElement chooseColorForScooterGrey;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Комментарий для курьера']")
    private SelenideElement inputCommentForDelivery;

    @FindBy(how = How.XPATH, using = "//button[text()='Назад']")
    private SelenideElement buttonStepBack;

    @FindBy(how = How.XPATH, using = "//*[text()='Нет']")
    private SelenideElement buttonNoPlaceAnOrder;

    @FindBy(how = How.XPATH, using = "//div[@class='Order_Buttons__1xGrp']/child::button[text()='Да']")
    private SelenideElement buttonYesPlaceAnOrder;

    @FindBy(how = How.XPATH, using = "//*[text()='Заказ оформлен']")
    private SelenideElement orderCreatedSuccessful;


    // Метод кликает на кнопку заказа. Их чаще всего две на странице.
    // Используйте 0, если нужна первая кнопка Заказать, 1, если вторая
    public CreateOrderPage clickButtonOrderScooter(int numberOrderButton) {
        buttonOrderScooter.get(numberOrderButton).click();
        return this;
    }

    // Поле Имя, нужно передать строку состоящую из кириллицы
    public CreateOrderPage setValueFirstNameInput(String firstName) {
        inputFirstName.setValue(firstName);
        return this;
    }

    // Метод проверяет, что в случае некорректного взаимодействия с полем Имя, появляется ошибка
    public CreateOrderPage checkErrorFirstName() {
        errorMassageFirstName.shouldHave(visible);
        return this;
    }

    // Поле Фамилия, нужно передать строку состоящую из кириллицы
    public CreateOrderPage setValueLastNameInput(String lastName) {
        inputLastName.setValue(lastName);
        return this;
    }

    //Метод проверяет, что в случае некорректного взаимодействия с полем Фамилия появляется ошибка
    public CreateOrderPage checkErrorLastName() {
        errorMassageLastName.shouldBe(visible);
        return this;
    }

    // Поле Адрес, нужно передать строку состоящую из кириллицы
    public CreateOrderPage setValueAddressInput(String address) {
        inputAddress.setValue(address);
        return this;
    }

    // Метод проверяет, что в случае некорректного взаимодействия с полем Адрес, появляется ошибка
    public CreateOrderPage checkErrorAddress() {
        errorMassageAddress.shouldHave(visible);
        return this;
    }

    // Используйте nameMetroStation, чтобы передавать значение метро в метод
    public CreateOrderPage setValueMetroInput(String nameMetroStation) {
        inputMetro.click();
        $(byXpath(("//*[text()='" + nameMetroStation + "']"))).click();
        return this;
    }

    //Метод проверяет, что в случае некорректного взаимодействия с полем Метро, появляется ошибка
    public CreateOrderPage checkErrorMetroStation() {
        errorMassageMetro.shouldHave(visible);
        return this;
    }

    // Поле Телефон, нужно передать строку состоящую из цифр
    public CreateOrderPage setValueNumberPhoneInput(String phoneNumber) {
        inputNumberPhone.setValue(phoneNumber);
        return this;
    }

    // Метод проверяет, что в случае некорректного взаимодействия с полем Телефон, появляется ошибка
    public CreateOrderPage checkErrorNumberPhone() {
        errorMassageNumberPhone.shouldHave(visible, Duration.ofMillis(500));
        return this;
    }

    // Позволяет перейти на следующий шаг оформления Заказа
    public CreateOrderPage clickButtonNextStep() {
        buttonNextStep.click();
        return this;
    }

    // Строка, по клику на которую открывается дата пикер. Метод за счет
    // использования get позволяет выбрать нужную дату.
    // Всего дата пикер содержит от 0 до 33 элементов, можно выбрать любой
    // От выбора любого из элементов кейс не упадет
    public CreateOrderPage selectOtherDateDelivery(String dateForDelivery) {
        inputDateForDelivery.setValue(dateForDelivery).pressEnter();
        return this;
    }

    // Позволяет выбрать на какое количество дней нужна аренда самоката
    //Переменная selectDayForRentalScooter требуется для выбора дня
    //Логика следующая: 1 - аренда на 1 день; 2 - аренда на 2 дня и тд
    // Диапазон от 1 до 7
    public CreateOrderPage selectorRentalPeriod(int selectDayForRentalScooter) {
        selectorRentalPeriod.click();
        dropDawnSelectDayForRent.get(selectDayForRentalScooter - 1).click();
        return this;
    }

    // Позволяет выбрать серый цвет для арендуемого скутера
    public CreateOrderPage clickSelectColorForScooterBlack() {
        chooseColorForScooterBlack.click();
        return this;
    }

    // Позволяет выбрать черный цвет для арендуемого скутера
    public CreateOrderPage clickSelectColorForScooterGrey() {
        chooseColorForScooterGrey.click();
        return this;
    }

    // Поле Комментарий для курьера, нужно передать строку состоящую из кириллицы
    public CreateOrderPage setValueInInputCommentForDelivery(String commentForDelivery) {
        inputCommentForDelivery.setValue(commentForDelivery);
        return this;
    }

    // Возвращает со второго шага оформления заказа, на первый
    public CreateOrderPage clickButtonStepBack() {
        buttonStepBack.click();
        return this;
    }

    // Кнопка Заказать, находиться под формой заполнения
    public CreateOrderPage clickCompleteOrder() {
        clickButtonOrderScooter(1);
        return this;
    }

    // Кнопка доступна после нажатия кнопки - Заказать
    public CreateOrderPage clickButtonNoPlaceAnOrder() {
        buttonNoPlaceAnOrder.click();
        return this;
    }

    // Кнопка доступна после нажатия кнопки - Заказать
    public CreateOrderPage clickButtonYesPlaceAnOrder() {
        buttonYesPlaceAnOrder.click();
        return this;
    }

    // Метод проверяет, что появляется элемент "Заказ Оформлен"
    public CreateOrderPage checkOrderCreatedSuccessful() {
        orderCreatedSuccessful.shouldHave(visible, (Duration.ofMillis(1000)));
        return this;
    }
}