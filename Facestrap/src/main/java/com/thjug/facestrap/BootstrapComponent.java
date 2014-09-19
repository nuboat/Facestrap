/**
 * <pre>
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 * </pre>
 */
package com.thjug.facestrap;

import java.io.IOException;
import java.io.UncheckedIOException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author nuboat
 */
public abstract class BootstrapComponent extends UIComponentBase {

	protected void addChild(final ResponseWriter writer, final UIComponent c)
			throws UncheckedIOException {
		try {
			writer.write(c.toString());
		} catch (final IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	protected void addElement(final ResponseWriter writer, final String name, final Object value)
			throws UncheckedIOException {
		if (value == null || value.toString().isEmpty()) {
			return;
		}
		try {
			writer.writeAttribute(name, value.toString(), null);
		} catch (final IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
