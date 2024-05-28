package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    
    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    // Clicks on the element identified by the given locator
    private void clickElement(By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Enters the given keys into the element identified by the given locator
    private void sendKeys(By locator, String keys) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(keys);
    }


    // Test case to navigate to a specific URL
    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        System.out.println("end Test case: testCase01");
    }

    // Test case 02: Enter name in the input field
    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        // Wait for 2 seconds
        Thread.sleep(2000);
        // Find the input field for name and enter the text
        sendKeys(By.xpath("//div[@id='i1']/ancestor::div[3]//input[@type='text']"), "Pratik Kumar Sharma");
        // Wait for 2 seconds
        Thread.sleep(2000);
        System.out.println("End Test case: testCase02");
    }

    // Test case 03: Enter reason in the textarea with the current epoch time
    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        // Get current time in seconds since epoch
        long epoch = System.currentTimeMillis() / 1000;
        // Wait for 2 seconds
        Thread.sleep(2000);
        // Find the textarea for reason and enter the text
        sendKeys(By.xpath("//div[@id='i5']/ancestor::div[3]//textarea"), "I want to be the best QA Engineer! " + epoch);
        // Wait for 2 seconds
        Thread.sleep(2000);
        System.out.println("End Test case: testCase03");
    }

    // Test case 04: Click the radio button for experience
    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        // Find and click the radio button for experience
        clickElement(By.xpath("//div[@role='radiogroup']//label//child::div[@id='i13']"));
        // Wait for 3 seconds
        Thread.sleep(3000);
        System.out.println("End Test case: testCase04");
    }

    // Test case 05: Select multiple checkboxes
    public void testCase05() {
        System.out.println("Start Test case: testCase05");
        // Find and click the checkbox for Java
        clickElement(By.xpath("//span[text()='Java']/ancestor::div/../div[@id='i30']"));
        // Find and click the checkbox for Selenium
        clickElement(By.xpath("//span[text()='Selenium']/ancestor::div/../div[@id='i33']"));
        // Find and click the checkbox for TestNG
        clickElement(By.xpath("//div[@role='listitem']//child::div[@id='i39']/following::div[2]/span[text()='TestNG']"));
        System.out.println("End Test case: testCase05");
    }

    // Test case 06: Select an option from a dropdown
    public void testCase06() throws InterruptedException {
        System.out.println("Start Test case: testCase06");
        // Find and click the dropdown listbox
        clickElement(By.xpath("//div[@role='listbox']"));
        // Wait for 3 seconds
        Thread.sleep(5000);
        // Select "Mr" from the dropdown
        clickElement(By.xpath("(//div[@role='presentation']//div//child::span[text()='Mr'])[2]"));
        System.out.println("End Test case: testCase06");
    }

    // Test case 07: Enter a date in the date input field
    public void testCase07() throws InterruptedException {
        System.out.println("Start Test case: testCase07");
        // Get current date and date seven days ago
        LocalDate currentDate = LocalDate.now();
        LocalDate dateSevenDaysAgo = currentDate.minusDays(7);
        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = dateSevenDaysAgo.format(formatter);
        // Enter the formatted date into the date input field
        sendKeys(By.xpath("//input[@type='date']"), formattedDate);
        // Wait for 3 seconds
        Thread.sleep(3000);
        System.out.println("End Test case: testCase07");
    }

    // Test case 08: Enter the current time in the time input fields
    public void testCase08() throws InterruptedException {
        System.out.println("Start Test case: testCase08");
        // Get the current time
        LocalTime currentTime = LocalTime.now();
        // Format the time
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(timeFormatter);
        String[] timeParts = formattedTime.split(":");
        String hour = timeParts[0];
        String minute = timeParts[1];
        // Enter the hour into the time input field
        sendKeys(By.xpath("//div[contains(text(),'Time')]/..//child::input[@type='text']"), hour);
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Enter the minute into the time input field
        sendKeys(By.xpath("(//div[contains(text(),'Time')]/..//following::input[@type='text'])[2]"), minute);
        // Wait for 3 seconds
        Thread.sleep(3000);
        System.out.println("End Test case: testCase08");
    }

    // public void testCase09() throws InterruptedException {
    //     System.out.println("Start Test case: testCase09");
    //     // Wait for 4 seconds
    //     Thread.sleep(4000);
    //     // Navigate to Amazon URL
    //     driver.get("https://www.amazon.in/");
    //     // Dismiss any alert that appears
    //     driver.switchTo().alert().dismiss();
    //     System.out.println("End Test case: testCase09");
    // }

    // Test case 10: Click the submit button
    public void testCase10() {
        System.out.println("Start Test case: testCase10");
        // Find and click the submit button
        clickElement(By.xpath("//span[text()='Submit']"));
        System.out.println("End Test case: testCase10");
    }

    // Test case 11: Wait for the "Thanks" message to be visible and print it
    public void testCase11() {
        System.out.println("Start Test case: testCase11");
        // Wait for the "Thanks" message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement thnxMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thanks')]")));
        // Get and print the text of the "Thanks" message
        String msgString = thnxMsg.getText();
        System.out.println(msgString);
        System.out.println("End Test case: testCase11");
    }
}
