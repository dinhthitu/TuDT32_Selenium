package pom.FileOperators;

import locator.PageLocator;
import org.openqa.selenium.WebDriver;

public class FilePage extends BasePage {

    public FilePage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String filePath) {
        sendKeys(PageLocator.FILE_UPLOAD, filePath);
    }

    public boolean isUploadSuccess(String fileName) {
        return getElement(PageLocator.UPLOADED_FILE_PATH)
                .getText()
                .contains(fileName);
    }

    public void downloadFile() {
        click(PageLocator.FILE_DOWNLOAD);
    }
}
