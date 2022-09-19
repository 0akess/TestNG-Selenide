package test.suite;

import org.testng.annotations.Test;
import ru.yandex.ui.data.Url;
import ru.yandex.ui.po.pages.CreateOrderPage;

import static com.codeborne.selenide.Selenide.page;

public class CreateOrderTest{

    private CreateOrderPage createOrderPage = page(CreateOrderPage.class);

    @Test
    public void createOrderFromTheHeaderPositive() {

        createOrderPage
                .open(Url.MainPage)

                // Шаг 1 - Открывается страница создания заказа
                .clickButtonOrderScooter(0)

                // Шаг 2 - заполняются все доступные поля на странице
                .setValueFirstNameInput("Иван")
                .setValueLastNameInput("Иванович")
                .setValueAddressInput("Георгич")
                .setValueMetroInput("Сокольники")
                .setValueNumberPhoneInput("89107521707")

                // Шаг 3 - происходит нажатие на кнопку подтвердить.
                // Открывается страница с новыми полями для аренды.
                .clickButtonNextStep()

                // Шаг 4 - заполняются все доступные поля на странице
                .selectOtherDateDelivery("10.03.2022")
                .selectorRentalPeriod(6)
                .clickSelectColorForScooterBlack()
                .setValueInInputCommentForDelivery("гугл пусти")

                // Шаг 5 - нажимает кнопку "Заказать" и создание заказа
                .clickCompleteOrder()
                .clickButtonYesPlaceAnOrder()

                // Шаг 6 - проверяется, что заказ сделан
                .checkOrderCreatedSuccessful();
    }

    @Test
    public void createOrderFromTheMidlOfPagePositive() {

        createOrderPage.
                open(Url.MainPage)

                // Шаг 1 - Открывается страница создания заказа
                .clickButtonOrderScooter(1)

                // Шаг 2 - заполняются все доступные поля на странице
                .setValueFirstNameInput("Артем")
                .setValueLastNameInput("Дудник")
                .setValueAddressInput("Игоревич")
                .setValueMetroInput("Технопарк")
                .setValueNumberPhoneInput("89172057433")

                // Шаг 3 - происходит нажатие на кнопку подтвердить.
                // Открывается страница с новыми полями для аренды.
                .clickButtonNextStep()

                // Шаг 4 - заполняются все доступные поля на странице
                .selectOtherDateDelivery("02.02.2022")
                .selectorRentalPeriod(3)
                .clickSelectColorForScooterGrey()
                .setValueInInputCommentForDelivery("Пажалуйста")

                // Шаг 5 - нажимает кнопку "Заказать" и создание заказа
                .clickCompleteOrder()
                .clickButtonNoPlaceAnOrder()
                .clickCompleteOrder()
                .clickButtonYesPlaceAnOrder()

                // Шаг 6 - проверяется, что заказ сделан
                .checkOrderCreatedSuccessful();
    }

    //Тест проверяет, что если не заполнить поле Имя, и нажать "Далее" появиться варнинг
    @Test
    public void checkErrorMassageForInputFirstNameNoData() {

        createOrderPage.
                open(Url.OrderPage)
                .clickButtonNextStep()
                .checkErrorFirstName();
    }

    // Тест проверяет, что если заполнить поле Имя символами не из кириллицы, и нажать "Далее"
    // появиться варнинг
    @Test
    public void checkErrorMassageForInputFirstNameInvalidValue() {

        createOrderPage.
                open(Url.OrderPage)
                .setValueFirstNameInput("ndsd123s")
                .clickButtonNextStep()
                .checkErrorFirstName();
    }

    // Тест проверяет, что если не заполнить поле Фамилия, и нажать "Далее"
    // появиться варнинг
    @Test
    public void checkErrorMassageForInputLastNameNoData() {

        createOrderPage.
                open(Url.OrderPage)
                .clickButtonNextStep()
                .checkErrorLastName();
    }

    // Тест проверяет, что если заполнить поле Фамилия символами не из кириллицы, и нажать "Далее"
    // появиться варнинг
    @Test
    public void checkErrorMassageForInputLastNameInvalidValue() {

        createOrderPage.
                open(Url.OrderPage)
                .setValueLastNameInput("ndsd123s")
                .clickButtonNextStep()
                .checkErrorLastName();
    }

    // Тест проверяет, что если заполнить поле Адрес символами не из кириллицы, и нажать "Далее"
    // появиться варнинг
    @Test
    public void checkErrorMassageForInputAddressInvalidValue() {

        createOrderPage.
                open(Url.OrderPage)
                .setValueAddressInput("ndsd123s")
                .clickButtonNextStep()
                .checkErrorAddress();
    }

    // Тест проверяет, что если не заполнить поле Фамилия, и нажать "Далее" появиться варнинг
    @Test
    public void checkErrorMassageForInputMetroStationNoData() {

        createOrderPage.
                open(Url.OrderPage)
                .clickButtonNextStep()
                .checkErrorMetroStation();
    }

    // Тест проверяет, что если не заполнить поле Фамилия, и нажать "Далее" появиться варнинг
    @Test
    public void checkErrorMassageForInputNumberPhoneNoData() {

        createOrderPage.
                open(Url.OrderPage)
                .clickButtonNextStep()
                .checkErrorNumberPhone();
    }

    // Тест проверяет, что если заполнить поле Фамилия символами не из кириллицы, и нажать "Далее"
    //появиться варнинг
    @Test
    public void checkErrorMassageForInputNumberPhoneInvalidValue() {

        createOrderPage.
                open(Url.OrderPage)
                .setValueNumberPhoneInput("ndsd123s")
                .clickButtonNextStep()
                .checkErrorNumberPhone();
    }

    // Тест проверяет, что находясь на странице создания заказа
    // и кликая на кнопку "Скутер", пользователь переходит на главную
    @Test
    public void checkButtonScooterInPageCheckOrder() {

        createOrderPage.
                open(Url.MainPage)
                .clickButtonScooter()
                .isManeScooter();
    }

    //Тест проверяет, что находясь на странице оформления заказа и кликая на
    // кнопку "Яндекс", у пользователя открывается страница с Яндексом
    @Test
    public void checkButtonYandexInOrderCreatePage() {

        createOrderPage.
                open(Url.MainPage)
                .clickButtonYandex()
                .isYandex();

    }
}