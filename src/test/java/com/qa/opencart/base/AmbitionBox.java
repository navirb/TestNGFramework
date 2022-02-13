package com.qa.opencart.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmbitionBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ambitionbox.com/reviews/tcs-reviews");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(1000);
		String link = "(//p[@class='body-medium fresher'])[4]";
		driver.findElement(By.xpath(link)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[text()='Rate the company you interned with']")).click();
		Thread.sleep(4000);
		String parentHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's
													// your newly opened window)
		}
		Thread.sleep(4000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.switchTo().window(parentHandle);
		driver.quit();
	}
}
