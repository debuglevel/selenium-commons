package de.debuglevel.selenium

class InvalidPageTitleException(actualPageTitle: String, assumedPageTitle: String) :
    InvalidPageException("Page title is '$actualPageTitle' although it was assumed to be '$assumedPageTitle'")