import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Actionwords {
	
	public WebDriver driver;
	public WebElement element;
	public generalFunctions g1=new generalFunctions();
	
	//public static WebDriver driver1;
	public WebDriver getDriver() {
		return driver;
	}
//-------------------------------------------------------------	
    public void setBrowswerType(String browserType) {    	             			
    	driver=new ChromeDriver();    	
    }

    public void loginStormport(String emailAddress, String password) {
    	
    	driver.findElement(By.name("email_address")).sendKeys(emailAddress);
    	driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.xpath("//*[@id=\"login_box\"]/div[2]/form/div[6]/div/button")).submit();        
    }    

    public void verifyAsUsername(String userName) {
    	g1.waitpageloaded(driver);
    	
    	System.out.println(userName);
    	if (g1.IsTextExisting(driver, userName)) {
    		g1.showInfo(driver, "verifying logined username as < "+userName+ " > is successful", 4000);
    		System.out.println("verifying logined username as < "+userName+ " > is successful"); 
    		driver.quit();
    	} else {
    		driver.quit();
    		fail("verifying logined username as < "+userName+ " > failed£¡");
    	}
    }

    public void verifyAsErrorMessage(String expectedMessage) {
    	g1.waitpageloaded(driver);
    	
    	System.out.println(expectedMessage);
    	if (g1.IsTextExisting(driver, expectedMessage)) {
    		String info="verifying ErrorMessage < "+expectedMessage + " > is successful";
    		g1.showInfo(driver, info, 4000);
    		System.out.println("verifying ErrorMessage '"+expectedMessage + "' is successful");
    		driver.quit();
    	} else {
    		driver.quit();
    		fail("verifying ErrorMessage < "+expectedMessage + " > failed£¡");
    	} 
    }

    public void changePassword(String emailAddress, String password, String newPassword) {
    	
    	driver.findElement(By.linkText("Change Password")).click();
    	g1.isElementPresent(driver, By.name("password"), 6000);

    	driver.findElement(By.name("password")).click();
    	driver.findElement(By.name("password")).sendKeys(password);
    	driver.findElement(By.xpath("//*[@id=\"password_new\"]")).sendKeys(newPassword);
    	driver.findElement(By.xpath("//*[@id=\"password_conf\"]")).sendKeys(newPassword);
    	driver.findElement(By.name("password_conf")).submit(); //equal driver.findElement(By.c=rf45-*sSelector(".modal-footer > .btn-primary")).click();
    	//assertThat(driver.switchTo().alert().getText(), is("The current password you entered was incorrect."));
    }

    public void setTargetUrl(String targetUrl) {
    	driver.manage().window().maximize();
    	driver.get(targetUrl);    	
    	g1.waitpageloaded(driver);    
    }

    public void logoutStormport() {
    	driver.findElement(By.xpath("//*[@id=\"page_header\"]/nav/div/div/div[2]/ul[2]/li[3]/a")).click();    	
    }
    public void filterOrderByType(String type) {
    	
    	driver.findElement(By.id("activity_type")).click();
        element=driver.findElement(By.id("activity_type"));
        Select s1=new Select(element);
        s1.selectByValue(type);
        g1.waiting(2000);
        
        driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[2]/button[1]/b")).click();     
        g1.waiting(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;        
        js.executeScript("window.scrollTo(100,900)");
    }

    public void verifyAsReceivedOrderType(String type) {
        g1.SnapshotSingleWindow(driver);
        g1.waiting(1000); //atter scroll, give 1 seconds to make smooth look;
      	String info="The case of verifyAsReceivedOrderType as < "+type+" > is snapshotted now and need to be verified by manual.";
      	g1.showInfo(driver, info, 5000);
      	System.out.println("The case of verifyAsReceivedOrderType as < "+type+" > is snapshotted now and need to be verified by manual.");
        driver.quit();      
    }

    public void setOrderStatusToFiler(String orderStatus) {
    	//element=driver.findElement(By.name("statuses[]"));    
    	//element=driver.findElement(By.className("label.checkbox-inline"));
    	//element=driver.findElement(By.name("statuses[]"));
    	//driver.findElement(By.linkText("APPROVED")).click();
    	switch (orderStatus) {
    		case "APPROVED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[1]/label/input")).click();
    			break;
    		case "COMPLETED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[2]/label/input")).click();
    			break;
    		case "DUPLICATE WORK ORDER":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[3]/label/input")).click();
    			break;
    		case "INCORRECTLY ASSIGNED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[4]/label/input")).click();
    			break;
    		case "NO LONGER REQUIRED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[5]/label/input")).click();
    			break;
    		case "PHYSICALLY COMPLETED":
     			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[6]/label/input")).click();
    			break;
    		case "ENTERED IN ERROR":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[7]/label/input")).click();
    			break;
    		case "STARTED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[8]/label/input")).click();
    			break;
    		case "UPDATED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[9]/label/input")).click();
    			break;
    		case "NO BILLING REQUIRED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[10]/label/input")).click();
    			break;			
    		case "BILLING APPROVAL REQUIRED": 
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[11]/label/input")).click();
    			break;
    		case "DISPUTED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[12]/label/input")).click();
    			break;
    		case "BILLING APPROVED": 
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[13]/label/input")).click();
    			break;
    		case "BILLING COMPLETED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[14]/label/input")).click();
    			break;
    		case "DATE CHANGE REQUESTED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[15]/label/input")).click();
    			break;
    		case "DATE CHANGE APPROVED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[16]/label/input")).click();
    			break;
    		case "DATE CHANGE DECLINED":
    			driver.findElement(By.xpath("//*[@id=\"orders_index_filters\"]/div/div[1]/div/div[1]/div/div[2]/div/div/ul/li[17]/label/input")).click();
    			break;   		
    	} 
    	g1.waiting(1500);
    }

    public void verifyAsReceivedOrderTypeAndStatus(String orderType, String orderStatus) {
        g1.SnapshotSingleWindow(driver);
        g1.waiting(1000); //atter scroll, give 1 seconds to make smooth look;
      	String info="The case of verifyAsReceivedOrderTypeAndStatus as < orderType="+orderType+" > AND  < orderStatus="+orderStatus+" > is snapshotted now and need to be verified by manual.";
      	g1.showInfo(driver, info, 7000);
      	System.out.println("The case of verifyAsReceivedOrderTypeAndStatus as < orderType="+orderType+" > AND < orderStatus="+orderStatus+" > is snapshotted now and need to be verified by manual.");
        driver.quit();      
    }

    public void setOrderDueDateOfStartAndEnd(String dueDateOfStart, String dueDateOfEnd) {
    	driver.findElement(By.id("start_date")).clear();
    	driver.findElement(By.id("start_date")).sendKeys(dueDateOfStart);
    	driver.findElement(By.id("end_date")).clear();
    	driver.findElement(By.id("end_date")).sendKeys(dueDateOfEnd);
        g1.waiting(1500);        
    }

    public void verifyAsReceivedOrderTypeAndDueDate(String orderType, String orderDueDateOfStart, String orderDueDateOfEnd) {
        g1.SnapshotSingleWindow(driver);
        g1.waiting(1000); //atter scroll, give 1 seconds to make smooth look;
      	String info="The case of verifyAsReceivedOrderTypeAndDueDate as < orderType="+orderType+" > AND orderDueDate from < "+orderDueDateOfStart+" to "+orderDueDateOfEnd+" > is snapshotted now and need to be verified by manual.";
      	g1.showInfo(driver, info, 7000);
      	System.out.println("The case of verifyAsReceivedOrderTypeAndDueDate as < orderType="+orderType+" > AND orderDueDate from < "+orderDueDateOfStart+" to "+orderDueDateOfEnd+" > is snapshotted now and need to be verified by manual.");
        driver.quit();   
    }
}