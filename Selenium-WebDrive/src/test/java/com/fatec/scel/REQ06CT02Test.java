package com.fatec.scel;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class REQ06CT02Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void rEQ06CT02() {
    driver.get("https://ts-scel.herokuapp.com/");
    driver.manage().window().setSize(new Dimension(865, 693));
    driver.findElement(By.linkText("Livros")).click();
    driver.findElement(By.linkText("Lista de Livros")).click();
    driver.findElement(By.linkText("Empréstimo")).click();
    driver.findElement(By.id("isbn")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    vars.put("win8284", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win8284").toString());
    driver.findElement(By.cssSelector("tr:nth-child(6) .btn")).click();
    driver.switchTo().window(vars.get("root").toString());
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).sendKeys("1001");
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1111");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).sendKeys("1002");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
    driver.close();
    driver.switchTo().window(vars.get("win8284").toString());
    driver.close();
    driver.switchTo().window(vars.get("undefined").toString());
  }
}

