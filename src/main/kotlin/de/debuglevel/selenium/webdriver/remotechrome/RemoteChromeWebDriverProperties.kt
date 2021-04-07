package de.debuglevel.selenium.webdriver.remotechrome

import de.debuglevel.selenium.webdriver.RemoteWebDriverProperties
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("app.ptk-automation.webdrivers.remotechrome")
class RemoteChromeWebDriverProperties : RemoteWebDriverProperties() {
    override var enabled = false
    override var url = ""
}
