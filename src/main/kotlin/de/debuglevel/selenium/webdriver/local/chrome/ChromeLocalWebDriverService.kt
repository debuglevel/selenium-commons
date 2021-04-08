package de.debuglevel.selenium.webdriver.local.chrome

import de.debuglevel.selenium.webdriver.WebDriverService
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class ChromeLocalWebDriverService(
    private val chromeWebDriverProperties: ChromeLocalWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        System.setProperty("webdriver.chrome.driver", chromeWebDriverProperties.driverBinaryPath.toString())
        val chromeDriver = ChromeDriver()

        logger.debug { "Got WebDriver: $chromeDriver" }
        return chromeDriver
    }
}