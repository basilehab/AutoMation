package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;


public class Main {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start !");
        openDriver();
        closeSession();
        System.out.println("close !");

    }
    public static void openDriver () throws InterruptedException {
        String URL = "https://automationexercise.com/";
        driver.get(URL);
        Thread.sleep(2000);
    }
    public static void  closeSession()
            {
        driver.quit();
    }
}