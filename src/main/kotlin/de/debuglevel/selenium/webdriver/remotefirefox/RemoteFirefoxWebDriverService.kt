package de.debuglevel.selenium.webdriver.remotefirefox

import de.debuglevel.selenium.webdriver.WebDriverService
import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL
import javax.inject.Singleton


@Singleton
@Requires(property = "app.ptk-automation.webdrivers.remotefirefox.enabled", value = "true")
class RemoteFirefoxWebDriverService(
    private val remoteFirefoxWebDriverProperties: RemoteFirefoxWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        val firefoxOptions = FirefoxOptions()
        val remoteDriver = RemoteWebDriver(URL(remoteFirefoxWebDriverProperties.url), firefoxOptions)
        remoteDriver.fileDetector = LocalFileDetector()

        return remoteDriver
    }
}