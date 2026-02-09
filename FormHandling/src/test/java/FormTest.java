
import base.BaseTest;
import config.ConfigData;
import driver.DriverManage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormTest extends BaseTest {

    private FormPage formPage;

    @BeforeMethod
    public void setup() {
        formPage = new FormPage(DriverManage.getDriver());
    }

    @Test
    public void testFillCompleteForm() {
        formPage.enterName()
                .enterEmail()
                .selectGender(ConfigData.GENDER)
                .enterMobile()
                .selectDateOfBirth(ConfigData.DATE_OF_BIRTH)
                .enterSubjects(ConfigData.SUBJECTS)
                .selectHobbies(ConfigData.HOBBIES)
                .setAddress()
                .selectState(ConfigData.STATE)
                .selectCity(ConfigData.CITY)
                .submitForm();

        assertTrue(formPage.isModalDisplayed());
        assertEquals(formPage.getModalTitle(), ConfigData.MODEL_MESSAGE);
    }


}