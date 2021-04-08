package de.debuglevel.selenium.webdriver.local

import de.debuglevel.selenium.webdriver.WebDriverProperties
import java.nio.file.Path

/**
 * Properties to configure a local WebDriver
 * @param driverBinaryPath Path to the driver binary
 */
abstract class LocalWebDriverProperties(
    val driverBinaryPath: Path
) : WebDriverProperties()