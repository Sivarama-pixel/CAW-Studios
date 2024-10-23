package HerokuApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import PageObjects.HomePage;

public class LaunchingURL extends BaseClass{

	@Test
	
	 public void cawStudios() {
		
		//Import Homepage Class from POM Clasess
		HomePage hp = new HomePage(driver);
		hp.performclick();
		String json = "[\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"Bob\",\r\n"
				+ "    \"age\": 20,\r\n"
				+ "    \"gender\": \"male\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"George\",\r\n"
				+ "    \"age\": 42,\r\n"
				+ "    \"gender\": \"male\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"Sara\",\r\n"
				+ "    \"age\": 42,\r\n"
				+ "    \"gender\": \"female\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"Conor\",\r\n"
				+ "    \"age\": 40,\r\n"
				+ "    \"gender\": \"male\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"Jennifer\",\r\n"
				+ "    \"age\": 42,\r\n"
				+ "    \"gender\": \"female\"\r\n"
				+ "  }\r\n"
				+ "]";
		
		hp.jsontextBox(json);
		
		hp.refreshbtn();
		
		String expectedName1 = "Bob";
        String expectedAge1 = "20";
        String expectedGender1 = "male";
        
        WebElement table = driver.findElement(By.xpath("//table[@id='dynamictable']"));

        // Extract the table rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Validate first row
        List<WebElement> firstRowCells = rows.get(1).findElements(By.tagName("td"));
        Assert.assertEquals(expectedName1, firstRowCells.get(0).getText());
        Assert.assertEquals(expectedAge1, firstRowCells.get(1).getText());
        Assert.assertEquals(expectedGender1, firstRowCells.get(2).getText());


        
      
		
		
	}

}
