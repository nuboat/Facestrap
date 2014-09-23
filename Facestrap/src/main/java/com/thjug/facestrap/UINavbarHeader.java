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
import static com.thjug.facestrap.define.Attribute.responsive;
import java.io.IOException;
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
@FacesComponent("UINavbarHeader")
public class UINavbarHeader extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UINavbarHeader.class);

	@Override
	protected List<String> getUIAttributes() {
		return null;
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
		addElement(writer, "class", "navbar-header");
		writer.startElement("button", this);
		addElement(writer, "type", "button");
		addElement(writer, "class", "collapsed navbar-toggle");
		addElement(writer, "data-toggle", "collapse");
		addElement(writer, "data-target", ".navbar-collapse");
		writer.startElement("span", this);
		addElement(writer, "class", "sr-only");
		writer.write("Toggle navigation");
		writer.endElement("span");
		writer.startElement("span", this);
		addElement(writer, "class", "icon-bar");
		writer.endElement("span");
		writer.startElement("span", this);
		addElement(writer, "class", "icon-bar");
		writer.endElement("span");
		writer.startElement("span", this);
		addElement(writer, "class", "icon-bar");
		writer.endElement("span");
		writer.endElement("button");
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
		return "div";
	}

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

}
