package otp.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;


import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import otp.portlet.constants.OtpPortletKeys;

@Component(
    property = {
    		"javax.portlet.name=" + OtpPortletKeys.OTP,
        "mvc.command.name=/verify/otp"
    },
    service = MVCRenderCommand.class
)
public class OtpRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        return "/otp.jsp"; // JSP inside OTP portlet
    }

	
}
