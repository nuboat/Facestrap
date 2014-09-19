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

import com.thjug.facestrap.helper.IncludeResource;
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
@FacesComponent("Div")
public class Div extends BootstrapComponent {

	private static final Logger LOG = LoggerFactory.getLogger(Div.class);

	private static final String[] keys = {"id", "style"};

	private static final List<String> attributes = Arrays.asList(keys);

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		IncludeResource.includeCss(context, "css/bootstrap.min.css", "bootstrap");

		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", this);
		attributes.stream().forEach(k -> addElement(writer, k, getAttributes().get(k)));
		if (getAttributes().get("css") != null) {
			addElement(writer, "class", getAttributes().get("css"));
		}
		super.encodeBegin(context);
	}

	@Override
	public void encodeChildren(final FacesContext context) throws IOException {
		super.encodeChildren(context);
	}

	@Override
	public void encodeEnd(final FacesContext context) throws IOException {
		context.getResponseWriter().endElement("div");
		super.encodeEnd(context);
	}

}
