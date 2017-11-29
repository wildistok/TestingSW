package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class testSearch {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/istokolyas/Documents/Uni/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://www.banki.ru/";
    }

    @Test
    public void testSearch() throws Exception {
        driver.get(baseUrl + "/");

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());

        driver.findElement(By.xpath("//input[@name='q']")).clear();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Ипотека");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);


        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.getTitle().equals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру")) {

                } else {
                    assertEquals("Поиск | Банки.ру", driver.getTitle());
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("Найдено 86 905 результатов", driver.findElement(By.xpath("//h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testSearch2() throws Exception {
        driver.get(baseUrl + "/");

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());

        driver.findElement(By.xpath("//input[@name='q']")).clear();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("qweadfqierk;aldfk");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);


        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.getTitle().equals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру")) {
                } else {
                    assertEquals("Поиск | Банки.ру", driver.getTitle());
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("К сожалению, по вашему поисковому запросу ничего не найдено.", driver.findElement(By.xpath("//main/div[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
