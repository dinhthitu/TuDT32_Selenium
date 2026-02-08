import base.BaseTest;
import config.ConfigData;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.FilePage;
import utils.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadTest extends BaseTest {

    private FilePage filePage;

    @BeforeMethod
    public void setUp() {
        filePage = new FilePage(DriverManager.getDriver());
    }

    // TEST
    @Test
    public void uploadAndDownloadFile_Normal() throws Exception {

        String fileName = ConfigData.fileName;

        Path uploadFile = Paths.get(
                "src", "test", "resources", "upload", fileName
        ).toAbsolutePath();

        filePage.uploadFile(uploadFile.toString());

        Assert.assertTrue(
                filePage.isUploadSuccess(fileName));


        filePage.downloadFile();

        Path downloadedFile = Paths.get(
                "test-output", "downloads", "sampleFile.jpeg"
        );

        FileUtils.waitUntilFileExists(downloadedFile, 10);

        Assert.assertTrue(Files.exists(downloadedFile));
        Assert.assertTrue(Files.size(downloadedFile) > 0);
    }

    // ADVANCED TEST
    @Test
    public void uploadAndDownloadFile_Advanced() {

        Path uploadFile = FileUtils.createTempTxtFile("dynamic-upload.txt");

        filePage.uploadFile(uploadFile.toString());

        Assert.assertTrue(
                filePage.isUploadSuccess(uploadFile.getFileName().toString())
        );

        // DOWNLOAD
        filePage.downloadFile();

        Path downloadedFile = Paths.get(
                "test-output", "downloads", "sampleFile.jpeg"
        );

        FileUtils.waitUntilFileExists(downloadedFile, 10);

        Assert.assertTrue(
                FileUtils.isFileValid(downloadedFile)
        );
    }
}
