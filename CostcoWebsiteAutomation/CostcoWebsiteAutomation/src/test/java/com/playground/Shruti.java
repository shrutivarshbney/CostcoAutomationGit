/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playground;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itexps.costco.FileUtil;
import com.itexps.costco.LoginVO;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gregshadd
 */
public class Shruti {

    private WebDriver driver;
    private String baseURL;
    private static LoginVO login = null;

    public Shruti() {
    }

    @BeforeClass
    public static void setUpClass() {
        login = FileUtil.getLoginData();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\QA\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        baseURL = "https://www.costco.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Test
    public void testAddItemNotLoggedIn15() throws Exception {
        driver.get("https://www.costco.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Frito Lay Classic Mix, Variety Pack, 30-count")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@id='costcoModalText']/div[2]/div[2]/a/button")).click();
        Thread.sleep(15000);
        driver.findElement(By.id("shopCartCheckoutSubmitButton")).click();
        assertEquals("Sign in to access your Costco.com account.", driver.findElement(By.xpath("//form[@id='LogonForm']/fieldset/div/span")).getText());
    }
}
