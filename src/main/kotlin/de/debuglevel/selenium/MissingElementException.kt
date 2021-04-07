package de.debuglevel.selenium

import org.openqa.selenium.By

class MissingElementException(by: By) :
    InvalidPageException("No matching element for '$by' could be found, although it should exist.")