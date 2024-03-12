import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.RegisterExtension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver
import pages.PracticePageTestingLibraryPO
import utils.ScreenshotOnError
import java.time.Duration.ofSeconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PracticeTestingLibraryTest {

    private val driver = ChromeDriver()

    @RegisterExtension
    private val screenshotOnError = ScreenshotOnError.ScreenshotOnError(driver as RemoteWebDriver)

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(ofSeconds(5))
    }

    @Test
    fun `select by role`() {
        PracticePageTestingLibraryPO(driver).navigatePracticeSelectors()
            .`select by role`()
    }

    @Test
    fun `select by placeholderText`() {
        PracticePageTestingLibraryPO(driver).navigateECommerce()
            .`select by placeholderText`("emailTest@email.com")
    }

    @Test
    fun `select by text`() {
        PracticePageTestingLibraryPO(driver).navigateECommerce()
            .`select by text`()
    }

    @Test
    fun `select by alternative text`() {
        PracticePageTestingLibraryPO(driver).navigateECommerce()
            .`select by alternative text`()
    }

    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}