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
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

/**
 *
 * @author nuboat
 */
@FacesComponent("UIBootstrapCSS")
public class UIBootstrapCSS extends UIComponentBase {

	@Override
	public void encodeBegin(final FacesContext context) throws IOException {
		IncludeResource.includeCSS(context);
		super.encodeBegin(context);
	}

	@Override
	public String getFamily() {
		return "com.thjug.facestrap";
	}

}
