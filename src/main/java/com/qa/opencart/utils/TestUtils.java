package com.qa.opencart.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtils {
	
	public void getScreenshot() throws IOException
	{
		Date currentDate = new Date();
		String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
		TakesScreenshot driver = null;
		File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(".//screenshot//" + screenShotFileName + ".png"));
	}

}
