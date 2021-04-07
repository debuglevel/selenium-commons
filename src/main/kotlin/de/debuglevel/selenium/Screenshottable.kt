package de.debuglevel.selenium

import java.io.File

/**
 * A screenshot can be took of the page
 */
interface Screenshottable {
    fun takeScreenshot(): File
}
