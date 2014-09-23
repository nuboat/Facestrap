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
import static com.thjug.facestrap.define.Attribute.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@FacesComponent("UIDropdown")
public class UIDropdown extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UIDropdown.class);

	@Override
	protected List<String> getUIAttributes() {
		return Arrays.asList(id, style, role);
	}

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().getOrDefault(rendered, true) == false) {
			return;
		}

		if (!getAttributes().containsKey(responsive)) {
			getAttributes().put(responsive, Boolean.FALSE);
		}

		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement(getRootElement(), this);
		addElement(writer, "class", "dropdown " + getAttributes().getOrDefault(css, ""));
		getUIAttributes()
				.stream()
				.forEach(k -> addElement(writer, k, getAttributes().get(k)));

		writer.startElement("a", this);
		addElement(writer, href, "#");
		addElement(writer, "data-toggle", "dropdown");
		addElement(writer, "class", "dropdown-toggle");
		writer.write(getAttributes().get(value).toString());
		writer.startElement("span", this);
		addElement(writer, "class", "caret");
		writer.endElement("span");
		writer.endElement("a");
	}

	@Override
	public void encodeEnd(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().get(rendered) == false) {
			return;
		}

		super.encodeEnd(context);
	}

	@Override
	protected String getRootElement() {
		return "li";
	}

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

}
