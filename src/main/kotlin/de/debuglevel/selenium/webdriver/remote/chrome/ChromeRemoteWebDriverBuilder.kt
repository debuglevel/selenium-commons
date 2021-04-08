package de.debuglevel.selenium.webdriver.remote.chrome

import de.debuglevel.selenium.webdriver.WebDriverBuilder
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver

class ChromeRemoteWebDriverBuilder(
    private val chromeRemoteWebDriverProperties: ChromeRemoteWebDriverProperties
) : WebDriverBuilder {
    private val logger = KotlinLogging.logger {}

    override fun build(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        val chromeOptions = ChromeOptions()
        val remoteDriver = RemoteWebDriver(chromeRemoteWebDriverProperties.url, chromeOptions)
        remoteDriver.fileDetector = LocalFileDetector()

        logger.debug { "Got WebDriver: $remoteDriver" }
        return remoteDriver
    }
}