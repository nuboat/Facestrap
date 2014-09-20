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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nuboat
 */
public abstract class UIBootstrapForm extends UIBootstrap {

	@Override
	protected List<Attribute> getUIAttribute() {
		return Arrays.asList(Attribute.id, Attribute.style, Attribute.type, Attribute.value);
	}

}
