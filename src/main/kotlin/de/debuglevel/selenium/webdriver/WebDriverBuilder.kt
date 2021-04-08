package de.debuglevel.selenium.webdriver

import org.openqa.selenium.WebDriver

interface WebDriverBuilder {
    /**
     * Builds the WebDriver
     */
    fun build(): WebDriver
}