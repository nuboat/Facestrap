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
import static com.thjug.facestrap.define.Attribute.css;
import static com.thjug.facestrap.define.Attribute.id;
import static com.thjug.facestrap.define.Attribute.inverse;
import static com.thjug.facestrap.define.Attribute.mode;
import static com.thjug.facestrap.define.Attribute.rendered;
import static com.thjug.facestrap.define.Attribute.responsive;
import static com.thjug.facestrap.define.Attribute.role;
import static com.thjug.facestrap.define.Attribute.style;
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
@FacesComponent("UINavbar")
public class UINavbar extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UINavbar.class);

	@Override
	protected List<Attribute> getUIAttribute() {
		return Arrays.asList(id, style, role);
	}

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().getOrDefault(rendered.toString(), true) == false) {
			return;
		}

		if (!getAttributes().containsKey(inverse.toString())) {
			getAttributes().put(inverse.toString(), Boolean.FALSE);
		}

		if (!getAttributes().containsKey(responsive.toString())) {
			getAttributes().put(responsive.toString(), Boolean.FALSE);
		}

		if (!getAttributes().containsKey(role.toString())) {
			getAttributes().put(role.toString(), "navigation");
		}

		getAttributes().put(css.toString(), "navbar " +
				(((Boolean)getAttributes().get(inverse.toString())) ? "navbar-inverse " : "navbar-default ") +
				getAttributes().getOrDefault(mode.toString(), "") +
				getAttributes().getOrDefault(css.toString(), "") );

		super.encodeBegin(context);

		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", this);
		addElement(writer, "class", ((Boolean)getAttributes().get(responsive.toString())) ? "container-fluid" : "container");
	}

	@Override
	public void encodeEnd(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().get(rendered.toString()) == false) {
			return;
		}

		context.getResponseWriter().endElement("div");
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
