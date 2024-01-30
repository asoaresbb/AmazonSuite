import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import pages.PracticePagePO
import java.time.Duration.ofSeconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PracticeSelectorsTest {

    private val driver = WebDriverManager.chromedriver().create()

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(ofSeconds(5))
    }

    @Test
    fun `select by cssSelector`() {
        PracticePagePO(driver).navigateLogin()
            .`select by css - placeholder`()
    }

    @Test
    fun `select by xpath - visible text`() {
        PracticePagePO(driver).navigateLogin()
            .`select by xpath with visible text`()
    }

    @Test
    fun `select by xpath - attribute`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`select by relative xpath`()
    }

    @Test
    fun `select login page - linkText`() {
        PracticePagePO(driver).navigatePracticeSelectors()
            .`select by linkText`()

    }



    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}