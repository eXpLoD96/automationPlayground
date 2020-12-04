import AutomationStore.Utils.DriverFactory;
import AutomationStore.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Contact {

    WebDriver driver = DriverFactory.getChromeDriver();
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @Test
    public void successfullySendMessage() {
        contactUsPage
                .populateEmail("hello@world.com")
                .messageBox("test")
                .populateOrderReference("123456789")
                .attachFile("\\main\\java\\AutomationStore\\Utils\\hello.txt")
                .submit();
        Assert.assertEquals(contactUsPage.successfullySentGetText(), "Your message has been successfully sent to our team.");
    }
}
