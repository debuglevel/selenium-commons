package de.debuglevel.selenium.screenshot

import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.nio.file.Path
import javax.imageio.ImageIO

private val logger = KotlinLogging.logger {}

/**
 * Takes a screenshot of the entire page and writes it as PNG to an OutputStream.
 */
fun WebDriver.takeScreenshot(outputStream: OutputStream) {
    logger.debug { "Taking screenshot into OutputStream $outputStream..." }

    val screenshot = AShot()
        .shootingStrategy(ShootingStrategies.viewportPasting(100))
        .takeScreenshot(this)

    val image = screenshot.image

    val imageFormat = "png"
    val success = ImageIO.write(image, imageFormat, outputStream)
    if (!success) {
        // this should not happen unless the writer for "png" goes missing somehow.
        throw WriterNotFoundException(imageFormat)
    }


    logger.debug { "Took screenshot into OutputStream $outputStream" }
}

class WriterNotFoundException(imageFormat: String) : Exception("No appropriate image writer for $imageFormat was found")

/**
 * Takes a screenshot of the entire page and returns it as a PNG ByteArray.
 */
fun WebDriver.takeScreenshot(): ByteArray {
    logger.debug { "Taking screenshot as ByteArray..." }

    val imageBytes = ByteArrayOutputStream().use { byteArrayOutputStream ->
        this.takeScreenshot(byteArrayOutputStream)
        byteArrayOutputStream.toByteArray()
    }

    logger.debug { "Took screenshot as ByteArray with ${imageBytes.size} bytes" }
    return imageBytes
}

/**
 * Takes a screenshot of the entire page, saves it as PNG in the working directory and returns the Path.
 */
fun WebDriver.takeScreenshot(screenshotPath: Path) {
    logger.debug { "Taking screenshot in Path $screenshotPath..." }

    screenshotPath.toFile().outputStream().use { fileOutputStream ->
        this.takeScreenshot(fileOutputStream)
    }

    logger.debug { "Took screenshot in Path $screenshotPath" }
}