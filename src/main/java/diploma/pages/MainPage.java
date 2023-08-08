package diploma.pages;

import com.codeborne.selenide.SelenideDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static com.codeborne.selenide.Condition.*;

public class MainPage {

    protected SelenideDriver driver;

    public MainPage(SelenideDriver driver) {
        this.driver = driver;
    }

    private static final By BUY_BUTTON = new By.ByXPath("//span[text()='Купить']");
    private static final By CREDIT_BUY_BUTTON = new By.ByXPath("//span[text()='Купить в кредит']");
    private static final By BUY_FORM_HEADER = new By.ByXPath("(//h3)[last()]");

    private static final By CARD_NUMBER_FORM = new By.ByXPath("//input[@placeholder='0000 0000 0000 0000']/ancestor::span[@class='input__inner']");
    private static final By CARD_NUMBER_ERROR = new ByChained(CARD_NUMBER_FORM, new By.ByXPath(".//span[@class='input__sub']"));
    private static final By CARD_NUMBER_PLACEHOLDER = new ByChained(CARD_NUMBER_FORM, new By.ByXPath(".//span[@class='input__top']"));
    private static final By CARD_NUMBER_INPUT = new ByChained(CARD_NUMBER_FORM, new By.ByXPath(".//*[@class='input__control']"));

    private static final By CARD_MONTH_FORM = new By.ByXPath("//input[@placeholder='08']/ancestor::span[@class='input__inner']");
    private static final By CARD_MONTH_ERROR = new ByChained(CARD_MONTH_FORM, new By.ByXPath(".//span[@class='input__sub']"));
    private static final By CARD_MONTH_PLACEHOLDER = new ByChained(CARD_MONTH_FORM, new By.ByXPath(".//span[@class='input__top']"));
    private static final By CARD_MONTH_INPUT = new ByChained(CARD_MONTH_FORM, new By.ByXPath(".//*[@class='input__control']"));

    private static final By CARD_YEAR_FORM = new By.ByXPath("//input[@placeholder='22']/ancestor::span[@class='input__inner']");
    private static final By CARD_YEAR_ERROR = new ByChained(CARD_YEAR_FORM, new By.ByXPath(".//span[@class='input__sub']"));
    private static final By CARD_YEAR_PLACEHOLDER = new ByChained(CARD_YEAR_FORM, new By.ByXPath(".//span[@class='input__top']"));
    private static final By CARD_YEAR_INPUT = new ByChained(CARD_YEAR_FORM, new By.ByXPath(".//*[@class='input__control']"));

    private static final By CARD_HOLDER_FORM = new By.ByXPath("//input[not(@placeholder)]/ancestor::span[@class='input__inner']");
    private static final By CARD_HOLDER_ERROR = new ByChained(CARD_HOLDER_FORM, new By.ByXPath(".//span[@class='input__sub']"));
    private static final By CARD_HOLDER_PLACEHOLDER = new ByChained(CARD_HOLDER_FORM, new By.ByXPath(".//span[@class='input__top']"));
    private static final By CARD_HOLDER_INPUT = new ByChained(CARD_HOLDER_FORM, new By.ByXPath(".//*[@class='input__control']"));

    private static final By CARD_CVV_FORM = new By.ByXPath("//input[@placeholder='999']/ancestor::span[@class='input__inner']");
    private static final By CARD_CVV_ERROR = new ByChained(CARD_CVV_FORM, new By.ByXPath(".//span[@class='input__sub']"));
    private static final By CARD_CVV_PLACEHOLDER = new ByChained(CARD_CVV_FORM, new By.ByXPath(".//span[@class='input__top']"));
    private static final By CARD_CVV_INPUT = new ByChained(CARD_CVV_FORM, new By.ByXPath(".//*[@class='input__control']"));

    private static final By SUBMIT_BUTTON_FORM = new By.ByXPath("//div[contains(@class, 'form')][last()]");
    private static final By SUBMIT_BUTTON = new ByChained(SUBMIT_BUTTON_FORM, new By.ByXPath(".//button"));
    private static final By SUBMIT_BUTTON_LOADER = new ByChained(SUBMIT_BUTTON_FORM, new By.ByXPath(".//span[contains(@class, 'spin')]"));

    private static final By NOTIFICATION_ERROR = new By.ByXPath("//div[contains(@class, 'error')]");
    private static final By NOTIFICATION_OK = new By.ByXPath("//div[contains(@class, 'ok')]");


    @Step("Нажать на кнопку 'Купить'")
    public MainPage clickBuyButton() {
        this.driver.$(BUY_BUTTON)
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Нажать на кнопку 'Купить в кредит'")
    public MainPage clickCreditBuyButton() {
        this.driver.$(CREDIT_BUY_BUTTON)
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Ввести номер карты '{cardNumber}'")
    public MainPage fillCardNumber(String cardNumber) {
        this.driver.$(CARD_NUMBER_INPUT)
                .shouldBe(visible)
                .append(cardNumber);
        return this;
    }

    @Step("Ввести месяц '{cardMonth}'")
    public MainPage fillCardMonth(String cardMonth) {
        this.driver.$(CARD_MONTH_INPUT)
                .shouldBe(visible)
                .append(cardMonth);
        return this;
    }

    @Step("Ввести год '{cardYear}'")
    public MainPage fillCardYear(String cardYear) {
        this.driver.$(CARD_YEAR_INPUT)
                .shouldBe(visible)
                .append(cardYear);
        return this;
    }

    @Step("Ввести имя '{cardHolder}'")
    public MainPage fillCardHolder(String cardHolder) {
        this.driver.$(CARD_HOLDER_INPUT)
                .shouldBe(visible)
                .append(cardHolder);
        return this;
    }

    @Step("Ввести CVV '{cardCVV}'")
    public MainPage fillCardCVV(String cardCVV) {
        this.driver.$(CARD_CVV_INPUT)
                .shouldBe(visible)
                .append(cardCVV);
        return this;
    }

    @Step("Проверка видимости ошибки номера карты")
    public MainPage cardNumberErrorIsVisible() {
        this.driver.$(CARD_NUMBER_ERROR)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости ошибки месяца")
    public MainPage cardMonthErrorIsVisible() {
        this.driver.$(CARD_MONTH_ERROR)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости ошибки года")
    public MainPage cardYearErrorIsVisible() {
        this.driver.$(CARD_YEAR_ERROR)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости ошибки имени")
    public MainPage cardHolderErrorIsVisible() {
        this.driver.$(CARD_HOLDER_ERROR)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости ошибки CVV")
    public MainPage cardCVVErrorIsVisible() {
        this.driver.$(CARD_CVV_ERROR)
                .shouldBe(visible);
        return this;
    }

    @Step("Нажатие на кнопку создания заказа")
    public MainPage clickSubmitButton() {
        this.driver.$(SUBMIT_BUTTON)
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Проверка видимости лоадера")
    public MainPage submitButtonLoaderIsVisible() {
        this.driver.$(SUBMIT_BUTTON_LOADER)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка сокрытия лоадера")
    public MainPage submitButtonLoaderIsInvisible() {
        this.driver.$(SUBMIT_BUTTON_LOADER)
                .shouldBe(hidden);
        return this;
    }

    @Step("Проверка видимости сообщения об ошибке заказа")
    public MainPage notificationErrorIsVisible() {
        this.driver.$(SUBMIT_BUTTON_LOADER)
                .shouldBe(disappear);
        submitButtonLoaderIsInvisible();
        this.driver.$(NOTIFICATION_ERROR)
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка видимости сообщения об успешности заказа")
    public MainPage notificationOkIsVisible() {
        this.driver.$(SUBMIT_BUTTON_LOADER)
                .shouldBe(disappear);
        this.driver.$(NOTIFICATION_OK)
                .shouldBe(visible);
        return this;
    }

}