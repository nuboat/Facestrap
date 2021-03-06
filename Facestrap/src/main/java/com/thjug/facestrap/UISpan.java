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

import static com.thjug.facestrap.define.Attribute.*;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.FacesComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@FacesComponent("UISpan")
public class UISpan extends UIBootstrap {

	private static final Logger LOG = LoggerFactory.getLogger(UISpan.class);

	@Override
	protected List<String> getUIAttributes() {
		return Arrays.asList(id, style);
	}

	@Override
	protected String getRootElement() {
		return "span";
	}

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

}
