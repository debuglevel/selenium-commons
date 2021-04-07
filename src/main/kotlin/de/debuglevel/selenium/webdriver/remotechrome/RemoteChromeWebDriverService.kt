package de.debuglevel.selenium.webdriver.remotechrome

import de.debuglevel.selenium.webdriver.WebDriverService
import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL
import javax.inject.Singleton


@Singleton
@Requires(property = "app.ptk-automation.webdrivers.remotechrome.enabled", value = "true")
class RemoteChromeWebDriverService(
    private val remoteChromeWebDriverProperties: RemoteChromeWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        val chromeOptions = ChromeOptions()
        val remoteDriver = RemoteWebDriver(URL(remoteChromeWebDriverProperties.url), chromeOptions)
        remoteDriver.fileDetector = LocalFileDetector()

        return remoteDriver
    }
}