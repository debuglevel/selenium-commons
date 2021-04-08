package de.debuglevel.selenium

import de.debuglevel.selenium.validation.ElementNotDisplayedException
import de.debuglevel.selenium.validation.MissingElementException
import mu.KotlinLogging
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

private val logger = KotlinLogging.logger {}

/**
 * Validates whether the given elements exist.
 * @param elementBys Bys of the elements which should be validated.
 */
fun WebDriver.validateElementsExist(elementBys: List<By>) {
    logger.trace { "Validating whether ${elementBys.count()} elements exist..." }

    elementBys.forEach { elementBy ->
        validateElementExists(elementBy)
    }

    logger.trace { "Validated whether ${elementBys.count()} elements exist" }
}

/**
 * Validates whether the given element exists.
 * @param elementBy By of the element which should be validated.
 */
fun WebDriver.validateElementExists(elementBy: By): WebElement {
    logger.trace { "Validating whether element '$elementBy' exists..." }
    val element = try {
        this.findElement(elementBy)
    } catch (e: NoSuchElementException) {
        throw MissingElementException(elementBy, e)
    }
    logger.trace { "Validated whether element '$elementBy' exist: $element" }
    return element
}

/**
 * Validates whether the given elements are displayed.
 * @param elementBys Bys of the elements which should be validated.
 */
fun WebDriver.validateElementsDisplayed(elementBys: List<By>) {
    logger.trace { "Validating whether ${elementBys.count()} elements are displayed..." }

    elementBys.forEach { elementBy ->
        validateElementDisplayed(elementBy)
    }

    logger.trace { "Validated whether ${elementBys.count()} elements are displayed" }
}

/**
 * Validates whether the given element is displayed.
 * @param elementBy By of the element which should be validated.
 */
private fun WebDriver.validateElementDisplayed(elementBy: By) {
    logger.trace { "Validating whether element '$elementBy' is displayed..." }

    val element = validateElementExists(elementBy)
    if (!element.isDisplayed) {
        throw ElementNotDisplayedException(element)
    }

    logger.trace { "Validated whether element '$elementBy' is displayed: $element" }
}

/**
 * Sends the given Number as String to the Element defined by By.
 * @param number The Number to send to the Element. Will not do anything if null.
 */
fun WebDriver.sendKeysTo(by: By, number: Number?) {
    val keys = number?.toString()
    this.sendKeysTo(by, keys)
}

/**
 * Sends the given String to the Element defined by By.
 * @param keys The String to send to the Element. Will not do anything if null or empty.
 */
fun WebDriver.sendKeysTo(by: By, keys: String?) {
    if (keys.isNullOrEmpty()) {
        logger.debug { "Not sending keys '$keys' to element '$by' as they are null or empty..." }
    } else {
        logger.debug { "Sending keys '$keys' to element '$by'..." }
        try {
            val element = this.findElement(by)

            element.sendKeys(keys)
            //Thread.sleep(100) // TODO: only for development

            logger.debug { "Checking if content is now the same as the sent keys..." }
            val content = element.getAttribute("value")
            if (content != keys) {
                throw SendingKeysFailedException(content, keys)
            }
        } catch (e: NoSuchElementException) {
            logger.error { "Did not found element $by to send keys to" }
            throw e
        }
    }
}