package de.debuglevel.selenium.webdriver.remote

import de.debuglevel.selenium.webdriver.WebDriverProperties

abstract class RemoteWebDriverProperties : WebDriverProperties() {
    abstract var url: String
}