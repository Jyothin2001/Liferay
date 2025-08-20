package BankModule;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import BankDB.model.BankTable;
import BankDB.service.BankTableLocalServiceUtil;

@Component(
	    property = {
	        "model.class.name=BankDB.model.BankTable"
	    },
	    service = WorkflowHandler.class
	)

public class handler extends BaseWorkflowHandler<BankTable>{

	@Override
	public String getClassName() {
		
		return BankTable.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		
		return "Bank_workflow";
	}

	@Override
	public BankTable updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		 long bankId = GetterUtil.getLong(
			        (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK)
			    );

			    BankTable bankflowObj = BankTableLocalServiceUtil.updateWorkFlow(bankId, status);

			    return bankflowObj;
		
	}

}
