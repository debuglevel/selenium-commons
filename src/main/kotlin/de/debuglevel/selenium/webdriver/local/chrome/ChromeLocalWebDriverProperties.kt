package de.debuglevel.selenium.webdriver.local.chrome

import de.debuglevel.selenium.webdriver.local.LocalWebDriverProperties
import java.nio.file.Path

/**
 * Properties to configure a local Chrome WebDriver
 * @param driverBinaryPath Path to the driver binary
 */
class ChromeLocalWebDriverProperties(
    driverBinaryPath: Path
) : LocalWebDriverProperties(driverBinaryPath)
