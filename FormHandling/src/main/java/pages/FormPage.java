package pages;

import config.ConfigData;
import locators.FormLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormPage {

    private WebDriver driver;
    protected Actions action;
    private WebDriverWait wait;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }


    public FormPage enterName() {
        WebElement firstName = getElement(FormLocator.FIRST_NAME);
        WebElement lastName = getElement(FormLocator.LAST_NAME);

        action.click(firstName)
                .sendKeys(ConfigData.FIRST_NAME)
                .click(lastName)
                .sendKeys(ConfigData.LAST_NAME)
                .perform();

        return this;
    }

    public FormPage enterEmail() {
        WebElement email = getElement(FormLocator.EMAIL);
        action.click(email)
                .sendKeys(ConfigData.EMAIL)
                .perform();
        return this;
    }

    public FormPage selectGender(String value) {
        List<WebElement> genderLabels = driver.findElements(FormLocator.GENDER_LABELS);

        for (WebElement label : genderLabels) {
            if (label.getText().equalsIgnoreCase(value)) {
                action.click(label).perform();
                break;
            }
        }

        return this;
    }

    public FormPage enterMobile() {
        WebElement mobile = getElement(FormLocator.MOBILE);
        action.click(mobile)
                .sendKeys(ConfigData.MOBILE)
                .perform();
        return this;
    }

    public FormPage selectDateOfBirth(String dateOfBirth) {

        scrollToElement(FormLocator.DATE_OF_BIRTH);

        String[] parts = dateOfBirth.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        WebElement dateInput = getElement(FormLocator.DATE_OF_BIRTH);
        dateInput.click();

        WebElement monthDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(FormLocator.DATE_PICKER_MONTH)
        );

        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        WebElement yearDropdown = driver.findElement(FormLocator.DATE_PICKER_YEAR);
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        By dayLocator = By.xpath("//div[contains(@class, 'react-datepicker__day') and " +
                "not(contains(@class, 'outside-month')) and text()='" + day + "']");

        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(dayLocator));
        dayElement.click();

        return this;
    }

    public FormPage enterSubjects(String subjects) {

        scrollToElement(FormLocator.SUBJECTS);

        String[] subjectArray = subjects.split(",");
        WebElement subjectsInput = getElement(FormLocator.SUBJECTS);

        for (String subject : subjectArray) {
            subject = subject.trim();
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(Keys.ENTER);
        }

        return this;
    }

    public FormPage selectHobbies(String hobbies) {
        scrollToElement(FormLocator.HOBBIES_LABELS);

        String[] hobbyArray = hobbies.split(",");
        List<WebElement> hobbyLabels = driver.findElements(FormLocator.HOBBIES_LABELS);

        for (String hobby : hobbyArray) {
            hobby = hobby.trim();

            for (WebElement label : hobbyLabels) {
                if (label.getText().equalsIgnoreCase(hobby)) {
                    action.click(label).perform();
                    break;
                }
            }
        }

        return this;
    }

    public FormPage setAddress() {
        scrollToElement(FormLocator.ADDRESS);

        WebElement address = getElement(FormLocator.ADDRESS);
        action.click(address)
                .sendKeys(ConfigData.CURRENT_ADDRESS)
                .perform();
        return this;
    }

    public FormPage selectState(String value) {
        scrollToElement(FormLocator.STATE_DROPDOWN);

        WebElement stateDropdown = getElement(FormLocator.STATE_DROPDOWN);
        action.click(stateDropdown).perform();

        WebElement stateInput = getElement(FormLocator.STATE_INPUT);
        stateInput.sendKeys(value);
        stateInput.sendKeys(Keys.ENTER);

        return this;
    }

    public FormPage selectCity(String value) {
        scrollToElement(FormLocator.CITY_DROPDOWN);

        WebElement cityDropdown = getElement(FormLocator.CITY_DROPDOWN);
        action.click(cityDropdown).perform();

        WebElement cityInput = getElement(FormLocator.CITY_INPUT);
        cityInput.sendKeys(value);
        cityInput.sendKeys(Keys.ENTER);

        return this;
    }

    public FormPage submitForm() {
        scrollToElement(FormLocator.SUBMIT);

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(FormLocator.SUBMIT));
        action
                .click(submitBtn)
                .perform();
        return this;
    }

    public boolean isModalDisplayed() {
        try {
            return getElement(FormLocator.MODAL_TITLE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getModalTitle() {
        return getElement(FormLocator.MODAL_TITLE).getText();
    }
}