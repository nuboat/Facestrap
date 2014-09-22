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
@FacesComponent("UINavbarBody")
public class UINavbarBody extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UINavbarBody.class);

	@Override
	protected List<Attribute> getUIAttribute() {
		return null;
	}

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().getOrDefault(rendered.toString(), true) == false) {
			return;
		}

		if (!getAttributes().containsKey(responsive.toString())) {
			getAttributes().put(responsive.toString(), Boolean.FALSE);
		}

		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement(getRootElement(), this);
		addElement(writer, "class", "collapse navbar-collapse");
		writer.startElement("ul", this);
		addElement(writer, "class", "nav navbar-nav");
	}

	@Override
	public void encodeChildren(final FacesContext context) throws IOException {

	}

	@Override
	public void encodeEnd(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().get(rendered.toString()) == false) {
			return;
		}

		final ResponseWriter writer = context.getResponseWriter();
		writer.endElement("ul");
		writer.endElement(getRootElement());
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
