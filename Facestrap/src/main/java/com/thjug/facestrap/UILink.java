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
import static com.thjug.facestrap.define.Attribute.href;
import static com.thjug.facestrap.define.Attribute.rel;
import static com.thjug.facestrap.define.Attribute.rendered;
import static com.thjug.facestrap.define.Attribute.type;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@FacesComponent("UILink")
public class UILink extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UILink.class);

	@Override
	protected List<Attribute> getUIAttribute() {
		return Arrays.asList(type, rel, href);
	}

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().get(rendered.toString()) == false) {
			return;
		}

		if (!getAttributes().containsKey(type.toString())) {
			getAttributes().put(type.toString(), "text/css");
		}
		if (!getAttributes().containsKey(rel.toString())) {
			getAttributes().put(rel.toString(), "stylesheet");
		}

		if (getAttributes().containsKey(href.toString())) {
			final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			getAttributes().put(href.toString(), request.getContextPath() + getAttributes().get(href.toString()));
		}
		super.encodeBegin(context);
	}

	@Override
	protected String getRootElement() {
		return "link";
	}

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

}
