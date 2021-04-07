package de.debuglevel.selenium.screenshot

import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import java.io.ByteArrayOutputStream
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.imageio.ImageIO

private val logger = KotlinLogging.logger {}

/**
 * Takes a screenshot of the entire page and returns it as a PNG ByteArray.
 */
fun WebDriver.takeScreenshotAsBytes(): ByteArray {
    logger.debug { "Taking screenshot as ByteArray..." }

    val screenshot = AShot()
        .shootingStrategy(ShootingStrategies.viewportPasting(100))
        .takeScreenshot(this)

    val image = screenshot.image

    val imageBytes = ByteArrayOutputStream().use { byteArrayOutputStream ->
        ImageIO.write(image, "png", byteArrayOutputStream)
        byteArrayOutputStream.flush()
        byteArrayOutputStream.toByteArray()
    }

    logger.debug { "Took screenshot as ByteArray (${imageBytes.size} bytes)" }
    return imageBytes
}

/**
 * Takes a screenshot of the entire page, saves it as PNG in the working directory and returns the file.
 */
fun WebDriver.takeScreenshotAsFile(): File {
    logger.debug { "Taking screenshot as File..." }

    val screenshotBytes = this.takeScreenshotAsBytes()
    val datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"))
    val screenshotFile = File("screenshot $datetime.png")
    screenshotFile.writeBytes(screenshotBytes)

    logger.debug { "Took screenshot as File (${screenshotFile.name})" }
    return screenshotFile
}
