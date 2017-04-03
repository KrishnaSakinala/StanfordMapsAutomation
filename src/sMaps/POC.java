package sMaps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class POC {

	static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
    ExtentTest test;

	public static WebDriverWait wait;

	String RpPath=System.getProperty("user.dir");

	String menuIcon = "//*[@id='openerMain']";

	String pointOfInterestCheckbox = "//*[@id='poi']";

	String closeIcon = "//*[@id='closeButton2']";

	String mapCanvas = "//*[@id='map_canvas']/div/div/div[1]/div[3]";

	String stanfordTab = "//div[@title='Stanford Map']";

	String campusshuttletab="//div[@title='Free Marguerite Shuttle']";

	String sattelitetab="//div[@title='Show satellite imagery']";

	String traffictab="//div[12]/div[4]/div";

	String serachicon="//button[@id='searchButton']";

	String leftmenuicon="//button[@id='openerMain']";

	String searchtext="//input[@id='search_address']";

	String relatedwebsite="//img[@title='Related Websites']";

	String mapplegend="//img[@title='Map Legend']";

	String infoicon="//img[@alt='Information']";

	String qustnbankicon="//a[@id='questionsBlock']/img";

	String imghomeicon="//img[@src='images/new/home_g2.png']";

	String imgprinticon="//img[@src='images/new/print_g2.png']";

	String imgemailicon="//img[@src='images/new/email_g2.png']";

	String imgshreicon="//img[@src='images/new/share_g2.png']";

	String zoominicon="//div[@id='map_canvas']/div/div/div[10]/div/div/div/div/img";

	String zoomouticon="//div[@id='map_canvas']/div/div/div[10]/div/div/div[3]/div/img";

	String scouticon="//div[2]/div[3]/img";

	String visitingcampu="//div[@title='Visiting Campus']";

	String lifeoncampus="//div[@title='Life on Campus']";

	String parkTrans="//div[@title='Parking & Transportation']";

	String saftySecu="//div[@title='Safety & Security']";

	String openexplore="//img[@id='openerExploreSU']";

	String openDir="//img[@id='openerDirection2']";

	String srchtexttype="340 bonair siding";


	String buildinginfo="//h4[@id='myModalLabel']";

	String buildingname="//div[@id='buildingInfo']/div/div/div[2]/span";

	String closesearchresults="//button[@class='close']";
	
	String timelimitparking="//div[@id='collapse_30']/div/p/label";
	
	String loadingzone="//label[@id='load']";
	
	String Mstop="//label[@id='m_stop']";
	
	String permitparkA="//label[@id='park-a']";




	@BeforeClass

	public void init() throws InterruptedException

	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/StanfordAutomationReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

		System.setProperty("webdriver.gecko.driver", RpPath+"\\lib\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().setSize(new Dimension(1382, 744));

		driver.manage().deleteAllCookies();

		driver.get("https://campus-map.stanford.edu/");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		wait= new WebDriverWait(driver, 30);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(stanfordTab)));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

	@Test(priority=1, enabled=true)	
	public void assertions()
	{
		test = extent.createTest("Map Fields Assertion");
		
		verifyElementPresent(serachicon, "searchicon");
		verifyElementPresent(leftmenuicon, "leftmenuicon");
		verifyElementPresent(searchtext, "searchtext");
		verifyElementPresent(relatedwebsite, "relatedwebsite");
		verifyElementPresent(mapplegend, "mapplegend");
		verifyElementPresent(infoicon, "infoicon");
		verifyElementPresent(qustnbankicon, "qustnbankicon");
		verifyElementPresent(imghomeicon, "imghomeicon");
		verifyElementPresent(imgemailicon, "imgemailicon");
		verifyElementPresent(imgprinticon, "imgprinticon");
		verifyElementPresent(imgshreicon,"imgshreicon");
		verifyElementPresent(campusshuttletab, "campusshuttletab");
		verifyElementPresent(sattelitetab, "sattelitetab");
		verifyElementPresent(traffictab, "traffictab");


	}
	
	@Test(priority=2, enabled=true)
	public void menuAssertions()
	{
		test = extent.createTest("Menu Assertion");
		driver.findElement(By.xpath(menuIcon)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(visitingcampu)));
		verifyElementPresent(visitingcampu, "visitingcampu");
		driver.findElement(By.xpath(visitingcampu)).click();
		verifyElementPresent(lifeoncampus, "lifeoncampus");
		verifyElementPresent(parkTrans, "parkTrans");
		verifyElementPresent(saftySecu, "saftySecu");
		verifyElementPresent(openexplore, "openexplore");
		verifyElementPresent(openDir, "openDir");
		verifyElementPresent(closeIcon, "closeIcon");
		driver.findElement(By.xpath(closeIcon)).click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(stanfordTab)));	
	}

	@Test(priority=3, enabled=true)
	public void search()throws Exception
	{
		test = extent.createTest("Search Functionality");
		driver.findElement(By.xpath(searchtext)).sendKeys(srchtexttype);
		Thread.sleep(2000);
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText(srchtexttype))).build().perform();
		driver.findElement(By.linkText(srchtexttype)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buildinginfo)));
		driver.findElement(By.xpath(buildinginfo)).getText().contains("Building Information");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buildingname)));
		driver.findElement(By.xpath(buildingname)).getText().contains(srchtexttype);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(closesearchresults)));
		Thread.sleep(2000);
		driver.findElement(By.xpath(closesearchresults)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeIcon)));
		driver.findElement(By.xpath(closeIcon)).click();
		Screen s=new Screen();
		Pattern BonaairBallon=new Pattern(RpPath+"\\screenshots\\304 Bonair.PNG");
        s.find(BonaairBallon);
		s.hover(BonaairBallon);
		s.click(BonaairBallon);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buildinginfo)));
		driver.findElement(By.xpath(buildinginfo)).getText().contains("Building Information");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(buildingname)));
		driver.findElement(By.xpath(buildingname)).getText().contains(srchtexttype);
		Thread.sleep(2000);
		driver.findElement(By.xpath(closesearchresults)).click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(stanfordTab)));	
		
	}


	@Test(priority=4,enabled=true)
	public void verifyPointsOfInterestPass() throws Exception

	{

		test = extent.createTest("VerifyPointsOfInterest Positive Scenario Assertion");
		driver.findElement(By.xpath(menuIcon)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(visitingcampu)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pointOfInterestCheckbox)));
		driver.findElement(By.xpath(pointOfInterestCheckbox)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeIcon)));
		driver.findElement(By.xpath(closeIcon)).click();
		Thread.sleep(4000);

		WebElement map = driver.findElement(By.xpath(mapCanvas));
		Screenshot mapWithPointsFirst = new AShot().takeScreenshot(driver, map);
		BufferedImage actualImage = mapWithPointsFirst.getImage();
		/*Screenshot screenshot = new AShot().takeScreenshot(driver,map);
	    ImageIO.write(screenshot.getImage(),"PNG",new File(RpPath +"\\screenshots\\Maps-poi.png"));*/
	 
	    Thread.sleep(4000);
		BufferedImage expectedImage = ImageIO.read(new File(RpPath +"\\screenshots\\Maps-poi.png"));
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		//backToNormal(pointOfInterestCheckbox);
		Thread.sleep(2000);
		Assert.assertFalse(diff.hasDiff(),"Images are Same");
		Thread.sleep(2000);
		Screen s=new Screen();
		Pattern mainquad_poi=new Pattern(RpPath+"\\screenshots\\mainquad.PNG");
        s.find(mainquad_poi);
		s.hover(mainquad_poi);
		s.click(mainquad_poi);
		String currentWindow = driver.getWindowHandle();
	    Set<String> availableWindows = driver.getWindowHandles();
	    
	    for (String windowId : availableWindows)
	    {
		    driver.switchTo().window(windowId);
		    Thread.sleep(2000);
	    }
	    String secondwindow=driver.getTitle();
	    System.out.println(secondwindow);
	    
	    driver.switchTo().window(currentWindow);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(stanfordTab)));	
	   
	    driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(stanfordTab)));	
	 

	}


	@Test(priority=5, enabled=true)
	public void verifyPointsOfInterestFail() throws Exception

	{
		test = extent.createTest("VerifyPointsOfInterest Negative Scenario Assertion");
		driver.findElement(By.xpath(menuIcon)).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pointOfInterestCheckbox))));
		driver.findElement(By.xpath(pointOfInterestCheckbox)).click();
		driver.findElement(By.xpath(closeIcon)).click();
		Thread.sleep(4000);

		WebElement map = driver.findElement(By.xpath(mapCanvas));
		Screenshot mapWithPointsFirst = new AShot().takeScreenshot(driver, map);
		BufferedImage actualImage = mapWithPointsFirst.getImage();
		Thread.sleep(5000);
		BufferedImage expectedImage = ImageIO.read(new File(RpPath +"\\screenshots\\Maps-poi-dotadded.png"));
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		Thread.sleep(5000);
		
		Assert.assertTrue(diff.hasDiff(),"Images are Same");
		Thread.sleep(2000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(stanfordTab)));	

	}
	
	@AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
	
	@AfterClass
	public void tearDown()

	{
		extent.flush();
		driver.quit();
	}


	public void backToNormal(String locator)

	{

		driver.findElement(By.xpath(menuIcon)).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		driver.findElement(By.xpath(locator)).click();
		driver.findElement(By.xpath(closeIcon)).click();

	}
	public static boolean verifyElementPresent(String locator,String desc)
	{
		try{

			wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());
			System.out.println(desc+": Is Present");
			return true;
		}
		catch(Exception e){
			// e.printStackTrace();				
			System.out.println(desc+":Is not displayed");
			return false;
		}
	}

}
