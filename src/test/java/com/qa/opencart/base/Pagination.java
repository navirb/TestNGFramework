package com.qa.opencart.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	@Test
	public void paginationUsingForLoop() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		int paginationSize = driver.findElements(By.cssSelector("#example_paginate>span>a")).size();
		List<String> names = new ArrayList<String>();
		for (int i = 1; i <= paginationSize; i++) {
			String paginationSelector = "#example_paginate>span>a:nth-child(" + i + ")";
			driver.findElement(By.cssSelector(paginationSelector)).click();
			Thread.sleep(5000);
			List<WebElement> namesElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			for (WebElement namesElement : namesElements) {
				names.add(namesElement.getText());
			}
		}
		for (String name : names) {
			System.out.println(name);
		}
		int totalNames = names.size();
		System.out.println("Total number of Names :" + totalNames);

		String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];

		System.out.println("Total Number of Displayed Names count:" + displayedCount);
		// Compare 2 strings- Convert int to String
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		Thread.sleep(5000);
		driver.quit();
	}

}
