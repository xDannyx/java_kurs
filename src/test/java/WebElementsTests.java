import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
public class WebElementsTests {

    private WebDriver driver;

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");
        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @Test
    public void filePickingTest() {
        sleep();
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\Users\\daniel.maciejewski\\Documents\\chromests.png");
        sleep();
    }

    @Test
    public void typingAndClearingValueInsideWebElementTest() {

        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();

        assertEquals(typeUserNameValue, "Selenium Start");

        userNameField.clear();
        sleep();

        String epmtyUserNameField = userNameField.getAttribute("value");
        assertEquals(epmtyUserNameField, "");
    }

    @Test
    public void checkRadioButtonTest(){
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());

        femaleRadioButton.click();
        sleep();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void checkboxButtonTest(){
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());

        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());

        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        sleep();

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}