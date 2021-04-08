package de.debuglevel.selenium.webdriver

import org.openqa.selenium.WebDriver

interface WebDriverService {
    /**
     * Gets the underlying WebDriver
     */
    fun get(): WebDriver
}