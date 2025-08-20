package ClgPortlet.portlet;

import ClgPortlet.constants.ClgPortletKeys;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import ClgDB.model.Clg_Table;
import ClgDB.service.Clg_TableLocalServiceUtil;

/**
 * @author Jyothi
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Clg",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ClgPortletKeys.CLG,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ClgPortlet extends MVCPortlet {
	
	private static final Log log = LogFactoryUtil.getLog(ClgPortlet.class);
	
	 
	 //save
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException
	{
		log.info("addStudent method is calling: ");
	
		String name=ParamUtil.getString(actionRequest,"name");
		String address=ParamUtil.getString(actionRequest, "address");
		int age=ParamUtil.getInteger(actionRequest,"age");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=(Date) ParamUtil.getDate(actionRequest,"dob",sdf);
	
     	//getting table instance/object
		//Clg_Table student=Clg_TableLocalServiceUtil.getInstance();
       
       // Generate new primary key for studentTable
        long studentId = CounterLocalServiceUtil.increment();
		Clg_Table student = Clg_TableLocalServiceUtil.createClg_Table(studentId);
		
       student.setAddress(address);
       student.setAge(age);
       student.setDob(date);
       student.setName(name);
       
       //add to object to table
      Clg_Table studentDetails=Clg_TableLocalServiceUtil.addClg_Table(student);
        System.out.println("student data: "+ studentDetails);
       
        
	} 
	//view
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException, java.io.IOException {
		
		log.info("view before");
		
            List<Clg_Table>  studentList=Clg_TableLocalServiceUtil.getClg_Tables(-1, -1);
            renderRequest.setAttribute("StudentsList", studentList);
		super.render(renderRequest, renderResponse);
		log.info("view after");
	}
	//edit
	public void updateStudent(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {

	    long studentId = ParamUtil.getLong(actionRequest, "ClgId");
	    String name = ParamUtil.getString(actionRequest, "name");
	    String address = ParamUtil.getString(actionRequest, "address");
	    int age = ParamUtil.getInteger(actionRequest, "age");

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dob = (Date) ParamUtil.getDate(actionRequest, "dob", sdf);

	    Clg_Table student = Clg_TableLocalServiceUtil.fetchClg_Table(studentId);
	    if (student != null) {
	        student.setName(name);
	        student.setAddress(address);
	        student.setAge(age);
	        student.setDob(dob);

	        Clg_TableLocalServiceUtil.updateClg_Table(student);  
	        log.info("Student updated: " + student.getName());
	    }

	    // Redirect back to student list
	    actionResponse.getRenderParameters().setValue("mvcPath", "/view.jsp");
	}

	//delete
	public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, java.io.IOException {
	Long stuId=ParamUtil.getLong(actionRequest, "ClgId");
	
	 Clg_Table studentId=Clg_TableLocalServiceUtil.fetchClg_Table(stuId);
	 
	 if(studentId!=null)
	 {
		 Clg_TableLocalServiceUtil.deleteClg_Table(studentId);
	 }
	 actionResponse.getRenderParameters().setValue("mvcPath", "/Viewstudents.jsp");
		super.processAction(actionRequest, actionResponse);
	}
}