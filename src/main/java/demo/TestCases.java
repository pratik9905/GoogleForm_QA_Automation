package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException{

        System.out.println("Start Test case: testCase02");
        Thread.sleep(2000);
        WebElement inputName = driver.findElement(By.xpath("//div[@id='i1']/ancestor::div[3]//input[@type='text']"));
        inputName.sendKeys("Pratik Kumar Sharma");
        Thread.sleep(2000);
        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        WebElement whyPracticeAutomation = driver.findElement(By.xpath("//div[@id='i5']/ancestor::div[3]//textarea"));
        long epoch = System.currentTimeMillis()/1000;
        Thread.sleep(2000);
        whyPracticeAutomation.sendKeys("I want to be the best QA Engineer! "+epoch);
        Thread.sleep(2000);
        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        WebElement experienceRadio = driver.findElement(By.xpath("//div[@role='radiogroup']//label//child::div[@id='i13']"));
        experienceRadio.click();
        Thread.sleep(3000);
        System.out.println("end Test case: testCase04");
    }

    public void testCase05(){
        System.out.println("Start Test case: testCase05");
        WebElement javaCheckbox = driver.findElement(By.xpath("//span[text()='Java']/ancestor::div/../div[@id='i30']"));
        WebElement seleniumCheckbox = driver.findElement(By.xpath("//span[text()='Selenium']/ancestor::div/../div[@id='i33']"));
        WebElement testNGChekbox = driver.findElement(By.xpath("//div[@role='listitem']//child::div[@id='i39']/following::div[2]/span[text()='TestNG']"));

        javaCheckbox.click();
        seleniumCheckbox.click();
        testNGChekbox.click();
        System.out.println("end Test case: testCase05");
    }

    public void testCase06() throws InterruptedException{
        System.out.println("Start Test case: testCase06");
        WebElement dropDoWebElement = driver.findElement(By.xpath("//div[@role='listbox']"));
        dropDoWebElement.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@role='presentation']//div//child::span[text()='Mr'])[2]")).click();
        System.out.println("end Test case: testCase06");
    }

    public void testCase07() throws InterruptedException{
        System.out.println("Start Test case: testCase07");
            LocalDate currentDate = LocalDate.now();
            LocalDate dateSevenDaysAgo = currentDate.minusDays(7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = dateSevenDaysAgo.format(formatter);

            WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
            dateField.sendKeys(formattedDate);
            Thread.sleep(3000);
            System.out.println("end Test case: testCase07");
    }

    public void testCase08() throws InterruptedException{
        System.out.println("Start Test case: testCase08");
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(timeFormatter);
        String[] timeParts = formattedTime.split(":");
        String hour = timeParts[0];
        String minute = timeParts[1];

        WebElement hourFiled = driver.findElement(By.xpath("//div[contains(text(),'Time')]/..//child::input[@type='text']"));
        WebElement minFiled = driver.findElement(By.xpath("(//div[contains(text(),'Time')]/..//following::input[@type='text'])[2]"));

        hourFiled.sendKeys(hour);
        Thread.sleep(3000);
        minFiled.sendKeys(minute);
        Thread.sleep(3000);
        System.out.println("end Test case: testCase08");
    }

    // public void testCase09() throws InterruptedException{
    //     System.out.println("Start Test case: testCase09");
    //     Thread.sleep(4000);
    //     driver.get("https://www.amazon.in/");
    //     Thread.sleep(4000);

    //     System.out.println("end Test case: testCase09");
    // }

    public void testCase10() throws InterruptedException{
        System.out.println("Start Test case: testCase10");
        WebElement submitBtn = driver.findElement(By.xpath("//span[text()='Submit']"));
        submitBtn.click();
        System.out.println("end Test case: testCase10");
    }

    public void testCase11() throws InterruptedException{
        System.out.println("Start Test case: testCase11");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement thnxMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thanks')]")));
        String msgString = thnxMsg.getText();
        System.out.println(msgString);
        System.out.println("end Test case: testCase11");
    }

}
