package de.debuglevel.selenium.webdriver.remote.chrome

import de.debuglevel.selenium.webdriver.WebDriverService
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class ChromeRemoteWebDriverService(
    private val chromeRemoteWebDriverProperties: ChromeRemoteWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        val chromeOptions = ChromeOptions()
        val remoteDriver = RemoteWebDriver(URL(chromeRemoteWebDriverProperties.url), chromeOptions)
        remoteDriver.fileDetector = LocalFileDetector()

        return remoteDriver
    }
}