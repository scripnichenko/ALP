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
package com.lohika.alp.log4j.attributes;

import org.testng.ITestResult;

import com.lohika.alp.log4j.Appenders;


/**
 * The Class AppendersAttribute.
 */
public class AppendersAttribute {

	/** The Constant NAME. */
	public static final String NAME = "log4j.appenders";

	/**
	 * Gets the appenders.
	 *
	 * @param tr the ITestResult
	 * @return the appenders
	 */
	public static Appenders getAppenders(ITestResult tr) {
		Appenders appenders = (Appenders) tr.getAttribute(NAME);
		return appenders;
	}

	/**
	 * Sets the appenders.
	 *
	 * @param tr the ITestresult
	 * @param appenders the appenders
	 */
	public static void setAppenders(ITestResult tr, Appenders appenders) {
		tr.setAttribute(NAME, appenders);
	}

}
