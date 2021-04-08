package de.debuglevel.selenium.webdriver.remote.firefox

import de.debuglevel.selenium.webdriver.remote.RemoteWebDriverProperties
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("app.ptk-automation.webdrivers.remotefirefox")
class FirefoxRemoteWebDriverProperties : RemoteWebDriverProperties() {
    override var enabled = false
    override var url = ""
}
