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

import com.thjug.facestrap.define.Attribute;
import static com.thjug.facestrap.define.Attribute.rendered;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author nuboat
 */
public abstract class UIBootstrap extends UIComponentBase {

	protected abstract String getRootElement();

	protected abstract List<Attribute> getUIAttribute();

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().get(rendered.toString()) == false) {
			return;
		}

		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement(getRootElement(), this);
		Arrays.asList(getUIAttribute()).stream().
				forEach(k -> addElement(writer, k.toString(), getAttributes().get(k.toString())));
		if (getAttributes().get("css") != null) {
			addElement(writer, "class", getAttributes().get("css"));
		}
		super.encodeBegin(context);
	}

	@Override
	public void encodeEnd(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().get(rendered.toString()) == false) {
			return;
		}

		context.getResponseWriter().endElement(getRootElement());
		super.encodeEnd(context);
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
