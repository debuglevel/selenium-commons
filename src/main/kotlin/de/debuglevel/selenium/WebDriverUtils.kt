package de.debuglevel.selenium

import mu.KotlinLogging
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

private val logger = KotlinLogging.logger {}

/**
 * Validates whether the given elements exist.
 */
fun WebDriver.validateElementsExist(elementBys: List<By>) {
    elementBys.forEach { elementBy ->
        logger.trace { "Validating whether element '$elementBy' exists..." }
        val element = validateElementExists(elementBy)
    }
}

/**
 * Validates whether the given element exists.
 */
fun WebDriver.validateElementExists(elementBy: By): WebElement {
    logger.trace { "Validating whether element '$elementBy' exists..." }
    val element = try {
        this.findElement(elementBy)
    } catch (e: NoSuchElementException) {
        throw MissingElementException(elementBy)
    }
    logger.trace { "Validated whether element '$elementBy' exist: $element" }
    return element
}

/**
 * Validates whether the given elements are displayed.
 */
// TODO: does this works as intended? (untested)
fun WebDriver.validateElementsDisplayed(elementBys: List<By>) {
    elementBys.forEach { elementBy ->
        validateElementDisplayed(elementBy)
    }
}

/**
 * Validates whether the given element is displayed.
 */
// TODO: does this works as intended? (untested)
private fun WebDriver.validateElementDisplayed(elementBy: By) {
    val element = validateElementExists(elementBy)

    logger.trace { "Validating whether element '$elementBy' is displayed..." }
    if (!element.isDisplayed) {
        throw NotDisplayedElementException(element)
    }
}

/**
 * Sends/Writes the given Integer as String to the Element defined by By
 */
fun WebDriver.sendKeysTo(by: By, keys: Int?) {
    this.sendKeysTo(by, keys.toString())
}

/**
 * Sends/Writes the given String to the Element defined by By
 */
fun WebDriver.sendKeysTo(by: By, keys: String?) {
    if (keys.isNullOrEmpty()) {
        logger.debug { "Skip sending keys '$keys' to element '$by' as they are empty..." }
    } else {
        logger.debug { "Sending keys '$keys' to element '$by'..." }
        try {
            val element = this.findElement(by)

            element.sendKeys(keys)
            Thread.sleep(100) // TODO: only for development

            // TODO: element.text is always empty string
            logger.debug { "Checking if content now is same as sent keys..." }
            if (element.getAttribute("value") != keys) {
                throw SendKeysFailedException(element.text, keys)
            }
        } catch (e: NoSuchElementException) {
            logger.error { "Did not found element $by to send keys to" }
            throw e
        }
    }
}