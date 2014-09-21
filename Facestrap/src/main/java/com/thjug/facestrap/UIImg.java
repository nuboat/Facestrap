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
import static com.thjug.facestrap.define.Attribute.alt;
import static com.thjug.facestrap.define.Attribute.css;
import static com.thjug.facestrap.define.Attribute.id;
import static com.thjug.facestrap.define.Attribute.rendered;
import static com.thjug.facestrap.define.Attribute.responsive;
import static com.thjug.facestrap.define.Attribute.shape;
import static com.thjug.facestrap.define.Attribute.src;
import static com.thjug.facestrap.define.Attribute.style;
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
@FacesComponent("UIImg")
public class UIImg extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UIImg.class);

	@Override
	protected List<Attribute> getUIAttribute() {
		return Arrays.asList(id, src, alt, style);
	}

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		if ((Boolean) getAttributes().getOrDefault(rendered.toString(), true) == false) {
			return;
		}

		if ((Boolean) getAttributes().getOrDefault(responsive.toString(), false)) {
			getAttributes().put(css.toString(), getAttributes().getOrDefault(css.toString(), "") + "img-responsive");
		}

		if (getAttributes().containsKey(shape.toString())) {
			getAttributes().put(css.toString(), getAttributes().getOrDefault(css.toString(), "") + " " + getAttributes().get(shape.toString()).toString());
		}

		if (getAttributes().containsKey(src.toString())) {
			final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			getAttributes().put(src.toString(), request.getContextPath() + getAttributes().get(src.toString()));
		}
		super.encodeBegin(context);
	}

	@Override
	protected String getRootElement() {
		return "img";
	}

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

}
