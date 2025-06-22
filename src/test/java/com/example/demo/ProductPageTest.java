package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPageTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
    }

    @Test
    @DisplayName("Проверка основных элементов карточки товара")
    public void testProductCardElements() {
        // Проверяем основные элементы карточки товара
        $(".MarketItemCard__itemName").shouldBe(visible).shouldHave(text("Перо"));
        $(".MarketItemCard__itemPrice").shouldBe(visible);
        $(".MarketItemCard__itemDescription").shouldBe(visible);
        $(".MarketItemCard__itemImg").shouldBe(visible);
        $(".MarketItemCard__btnWrap").shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка кнопки 'Написать'")
    public void testWriteButton() {
        $(".MarketItemCard__btnWrap").shouldBe(visible).click();
        $(".WriteButton__writeBox").shouldBe(visible);
    }
}