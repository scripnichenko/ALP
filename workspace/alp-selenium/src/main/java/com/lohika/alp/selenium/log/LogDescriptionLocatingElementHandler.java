//Copyright 2011-2012 Lohika .  This file is part of ALP.
//
//    ALP is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    ALP is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with ALP.  If not, see <http://www.gnu.org/licenses/>.
package com.lohika.alp.selenium.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;


/**
 * The Class LogDescriptionLocatingElementHandler.
 */
public class LogDescriptionLocatingElementHandler implements InvocationHandler {
	
	/** The element locator. */
	private final ElementLocator locator;

	/**
	 * Instantiates a new log description locating element handler.
	 *
	 * @param locator the locator
	 */
	public LogDescriptionLocatingElementHandler(ElementLocator locator) {
		this.locator = locator;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object object, Method method, Object[] objects)
			throws Throwable {
		WebElement element = locator.findElement();

		if ("getWrappedElement".equals(method.getName())) {
			return element;
		}

		try {
			return method.invoke(element, objects);
		} catch (InvocationTargetException e) {
			// Unwrap the underlying exception
			Throwable t = e.getCause();

			// TODO add utility to unwrap LoggingWebElement
			if (element instanceof LoggingWebElement) {
				if (t instanceof ElementNotVisibleException)
					throw new com.lohika.alp.selenium.ElementNotVisibleException(
							(LoggingWebElement) element,
							(ElementNotVisibleException) t);
			}

			throw t;
		}
	}

}
