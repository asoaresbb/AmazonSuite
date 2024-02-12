import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import pages.AutoDocDetailPO
import pages.IkeaShelfDetailPO
import pages.MediumPO
import java.time.Duration.ofSeconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PracticeConditionsTest {

    private val driver = WebDriverManager.chromedriver().create()

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(ofSeconds(5))
    }

    @Test
    fun `if stock buy it`() {
        IkeaShelfDetailPO(driver).navigateProduct()
            .`accept cookies`()
            .`check stock`()
    }

    @Test
    fun `click on first of the group`() {
        IkeaShelfDetailPO(driver).navigateAvailableColors()
            .`accept cookies`()
            .`first or null`()
    }

    @Test
    fun `choose a vehicle`() {
        AutoDocDetailPO(driver).navigate()
            .`accept cookies`()
            .`select elements from dropdown`()
    }

    @Test
    fun `my custom selector`() {
        MediumPO(driver).navigateToMedium()
            .`write an article`()
    }

    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}