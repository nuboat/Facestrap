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
package com.thjug.facestrap.helper;

import java.io.IOException;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
public class IncludeResource {

	private static final Logger LOG = LoggerFactory.getLogger(IncludeResource.class);

	public static void includeCSS(final FacesContext context) throws IOException {
		includeCSS(context, "css/bootstrap.min.css", "bootstrap");
	}

	public static void includeJS(final FacesContext context) throws IOException {
		includeJS(context, "js/bootstrap.min.js", "bootstrap");
	}

	private static void includeCSS(final FacesContext context, final String resource, final String library)
			throws IOException {

		if (isResourceIncluded(context, resource)) {
			return;
		}

		final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		request.setAttribute(resource, Boolean.TRUE);

		final ResourceHandler rh = context.getApplication().getResourceHandler();
		final Resource r = rh.createResource(resource, library);
		final ResponseWriter w = context.getResponseWriter();
		w.write('\n');
		w.startElement("link", null);
		w.writeAttribute("type", "text/css", null);
		w.writeAttribute("rel", "stylesheet", null);
		w.writeAttribute("href", r.getRequestPath(), null);
		w.endElement("link");
		w.append('\n');
	}

	private static void includeJS(final FacesContext context, final String resource, final String library)
			throws IOException {

		if (isResourceIncluded(context, resource)) {
			return;
		}

		final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		request.setAttribute(resource, Boolean.TRUE);

		final ResourceHandler rh = context.getApplication().getResourceHandler();
		final Resource r = rh.createResource(resource, library);
		final ResponseWriter w = context.getResponseWriter();
		w.write('\n');
		w.startElement("script", null);
		w.writeAttribute("type", "text/javascript", null);
		w.writeAttribute("href", r.getRequestPath(), null);
		w.endElement("script");
		w.append('\n');
	}

	private static boolean isResourceIncluded(final FacesContext context, final String resource)
			throws IOException {

		final HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		return request.getAttribute(resource) != null;
	}

}
