package de.debuglevel.selenium.webdriver.remotefirefox

import de.debuglevel.selenium.webdriver.RemoteWebDriverProperties
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("app.ptk-automation.webdrivers.remotefirefox")
class RemoteFirefoxWebDriverProperties : RemoteWebDriverProperties() {
    override var enabled = false
    override var url = ""
}
