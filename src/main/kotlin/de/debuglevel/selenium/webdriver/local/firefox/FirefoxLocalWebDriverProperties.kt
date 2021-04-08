package de.debuglevel.selenium.webdriver.local.firefox

import de.debuglevel.selenium.webdriver.local.LocalWebDriverProperties
import java.nio.file.Path

/**
 * Properties to configure a local Firefox WebDriver
 * @param driverBinaryPath Path to the driver binary
 */
class FirefoxLocalWebDriverProperties(
    driverBinaryPath: Path
) : LocalWebDriverProperties(driverBinaryPath)