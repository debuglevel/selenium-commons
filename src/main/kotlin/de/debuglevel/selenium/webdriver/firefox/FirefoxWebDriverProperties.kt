package de.debuglevel.selenium.webdriver.firefox

import de.debuglevel.selenium.webdriver.WebDriverProperties
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("app.ptk-automation.webdrivers.firefox")
class FirefoxWebDriverProperties : WebDriverProperties() {
    override var enabled = false
    override var binarypath = ""
}
