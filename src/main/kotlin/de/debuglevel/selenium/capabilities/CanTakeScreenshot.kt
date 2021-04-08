package de.debuglevel.selenium.capabilities

import java.io.File

/**
 * A screenshot can be took of the page
 */
interface CanTakeScreenshot {
    /**
     * Takes a screenshot of the whole page and saves it to the returned file.
     */
    fun takeScreenshot(): File
}
