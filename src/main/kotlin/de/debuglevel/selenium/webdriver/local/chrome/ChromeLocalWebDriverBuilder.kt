package de.debuglevel.selenium.webdriver.local.chrome

import de.debuglevel.selenium.webdriver.WebDriverBuilder
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class ChromeLocalWebDriverBuilder(
    private val chromeWebDriverProperties: ChromeLocalWebDriverProperties
) : WebDriverBuilder {
    private val logger = KotlinLogging.logger {}

    override fun build(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        System.setProperty("webdriver.chrome.driver", chromeWebDriverProperties.driverBinaryPath.toString())
        val chromeDriver = ChromeDriver()

        logger.debug { "Got WebDriver: $chromeDriver" }
        return chromeDriver
    }
}