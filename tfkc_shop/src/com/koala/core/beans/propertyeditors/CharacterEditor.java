/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koala.core.beans.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.koala.core.tools.StringUtils;

public class CharacterEditor extends PropertyEditorSupport {

	/**
	 * The prefix that identifies a string as being a Unicode character
	 * sequence.
	 */
	private static final String UNICODE_PREFIX = "\\u";

	/**
	 * The length of a Unicode character sequence.
	 */
	private static final int UNICODE_LENGTH = 6;

	private final boolean allowEmpty;

	/**
	 * Create a new CharacterEditor instance.
	 * <p>
	 * The "allowEmpty" parameter controls whether an empty String is to be
	 * allowed in parsing, i.e. be interpreted as the <code>null</code> value
	 * when {@link #setAsText(String) text is being converted}. If
	 * <code>false</code>, an {@link IllegalArgumentException} will be thrown at
	 * that time.
	 * 
	 * @param allowEmpty
	 *            if empty strings are to be allowed
	 */
	public CharacterEditor(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		} else if (text == null) {
			throw new IllegalArgumentException(
					"null String cannot be converted to char type");
		} else if (isUnicodeCharacterSequence(text)) {
			setAsUnicode(text);
		} else if (text.length() != 1) {
			throw new IllegalArgumentException("String [" + text
					+ "] with length " + text.length()
					+ " cannot be converted to char type");
		} else {
			setValue(new Character(text.charAt(0)));
		}
	}

	public String getAsText() {
		Object value = getValue();
		return (value != null ? value.toString() : "");
	}

	private void setAsUnicode(String text) {
		int code = Integer
				.parseInt(text.substring(UNICODE_PREFIX.length()), 16);
		setValue(new Character((char) code));
	}

	private static boolean isUnicodeCharacterSequence(String sequence) {
		return sequence.startsWith(UNICODE_PREFIX)
				&& sequence.length() == UNICODE_LENGTH;
	}

}
