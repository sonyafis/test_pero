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

public class CommunityPageTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
    }

    @Test
    @DisplayName("Проверка основных элементов главной страницы сообщества")
    public void testCommunityPageElements() {
        // Проверяем заголовок сообщества
        $(".page_name").shouldBe(visible).shouldHave(text("Перо"));
        
        // Проверяем разделы меню
        $(".ui_tab[href='/club225299895']").shouldBe(visible); // Главная
        $(".ui_tab[href*='wall']").shouldBe(visible);           // Стена
        $(".ui_tab[href*='market']").shouldBe(visible);         // Товары
        
        // Проверяем наличие аватарки сообщества
        $(".page_avatar_img").shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка перехода в раздел товаров")
    public void testMarketSection() {
        $(".ui_tab[href*='market']").click();
        $(".market_header").shouldBe(visible).shouldHave(text("Товары"));
    }
}