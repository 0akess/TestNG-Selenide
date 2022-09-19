package test.suite;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.ui.data.Url;
import ru.yandex.ui.po.pages.MainePage;
import test.BaseTest;


import static com.codeborne.selenide.Selenide.page;

public class ScooterMainTest extends BaseTest {

    private MainePage mainPage = page(MainePage.class);

    @BeforeClass
    public void startTest() {
        mainPage
                .open(Url.MainPage)
                .clickButtonAcceptCookie();
    }

    @DataProvider(name = "answersToQuestions")
    public static Object[][] primeNumbers() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите " +
                        "покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку " +
                        "по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже " +
                        "если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже " +
                        "не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    // Проверка ответов на вопросы
    @Test(dataProvider = "answersToQuestions")
    public void answersToQuestions(int numberQuestion, String answers) {

        mainPage
                .open(Url.MainPage)
                .openQuestionAndCheckingAnswer(numberQuestion, answers);
    }

    // Тест проверяет, что находясь на главной странице
    // и кликая на кнопку "Скутер", пользователь остается на главной
    @Test
    public void buttonScooterInManePage() {

        mainPage
                .open(Url.MainPage)
                .clickButtonScooter()
                .isManeScooter();
    }

    // Тест проверяет, что находясь на главной странице и кликая на
    // кнопку "Яндекс", у пользователя открывается страница с Яндексом
    @Test
    public void buttonYandexInManePage() {

        mainPage
                .open(Url.MainPage)
                .clickButtonYandex()
                .isYandex();
    }
}