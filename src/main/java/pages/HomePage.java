package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  private final By shopBtn = By.id("menu-item-40");
  private final By sliderElements = By.xpath("//div[@data-slide-duration='0']");
  private final By arrivalsElements = By.className("woocommerce");
  private final By arrivalLink = By.className("woocommerce-LoopProduct-link");
  private final By cartContents = By.className("cartcontents");
  private final By myAccount = By.id("menu-item-50");
  private final By cart = By.className("wpmenucart-contents");

  public HomePage clickShopBtn() {
    WebElement shopBtnFind = driver.findElement(shopBtn);
    waitElementIsVisible(shopBtnFind).click();
    return this;
  }

  public HomePage verifyCountSlide(int count) {
    int slides = driver.findElements(sliderElements).size();
    Assert.assertEquals(slides, count);
    return this;
  }

  public HomePage verifyCountArrival(int count) {
    int arrivals = driver.findElements(arrivalsElements).size();
    Assert.assertEquals(arrivals, count);
    return this;
  }

  public HomePage clickArrivalLink() {
    WebElement linkArrival = driver.findElement(arrivalLink);
    waitElementIsVisible(linkArrival).click();
    return this;
  }

  public HomePage clickLastArrivalLink() {
    List<WebElement> allArrivalsLinks = driver.findElements(arrivalsElements);
    WebElement lastArrivals = allArrivalsLinks.get(allArrivalsLinks.size() -1);
    waitElementIsVisible(lastArrivals).click();
    return this;
  }

  public HomePage verifyCartContentsNotEquals(String count) {
    WebElement countItem = driver.findElement(cartContents);
    String textCountItem = countItem.getText();
    String firstCount = textCountItem.substring(0, 1);
    Assert.assertNotEquals(firstCount, count);
    return this;
  }

  public HomePage verifyCartContentsEquals(String count) {
    WebElement countItem = driver.findElement(cartContents);
    String textCountItem = countItem.getText();
    String firstCount = textCountItem.substring(0, 1);
    Assert.assertEquals(firstCount, count);
    return this;
  }

  public HomePage clickToCart() {
    try {
      Thread.sleep(2000);
      WebElement cartLink = driver.findElement(cartContents);
      cartLink.click();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return this;
  }

  public HomePage clickMyAccount() {
    WebElement myAccountLink = driver.findElement(myAccount);
    waitElementIsVisible(myAccountLink).click();
    return this;
  }

  public HomePage clickCartLink() {
    WebElement cartLink = driver.findElement(cart);
    waitElementIsVisible(cartLink).click();
    return this;
  }
}
