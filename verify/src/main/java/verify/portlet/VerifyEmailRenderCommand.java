package verify.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


import verify.constants.VerifyPortletKeys;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + VerifyPortletKeys.VERIFY,
	        "mvc.command.name=/verify/email1"
	    },
	    service = MVCRenderCommand.class
	)
	public class VerifyEmailRenderCommand implements MVCRenderCommand {

	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) 
	            throws PortletException {

	        long userId = ParamUtil.getLong(renderRequest, "userId");
	        String token = ParamUtil.getString(renderRequest, "token");

	        renderRequest.setAttribute("userId", userId);
	        renderRequest.setAttribute("token", token);

	        return "/verify.jsp";  // JSP inside src/main/resources/META-INF/resources/
	    }
	}
