package de.debuglevel.selenium.webdriver.chrome

import de.debuglevel.selenium.webdriver.WebDriverProperties
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("app.ptk-automation.webdrivers.chrome")
class ChromeWebDriverProperties : WebDriverProperties() {
    override var enabled = false
    override var binarypath = ""
}
