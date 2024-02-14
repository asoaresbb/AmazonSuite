import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import pages.PracticePagePO
import java.time.Duration.ofSeconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PracticeInteractionsTest {

    private val driver = WebDriverManager.chromedriver().create()

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(ofSeconds(5))
    }

    @Test
    fun `input text and clear it`() {
        PracticePagePO(driver).navigateLogin()
            .`clear text`("letskodeit@gmail.com")
    }

    @Test
    fun `get title`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`get and print the title`()
    }

    @Test
    fun `get url`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`get and print the url`()
    }

    @Test
    fun `back and forward browser`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`navigate back and forward on browser`()
    }

    @Test
    fun `refresh page`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`refresh current page`()
    }

    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}