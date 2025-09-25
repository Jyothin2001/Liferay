package Bank_Portlet.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import BankDB.model.BankTable;
import BankDB.service.BankTableLocalServiceUtil;

//checking git desktop

@Component
(
	 immediate = true,
			    property = {
			        "javax.portlet.name=Bank_Portlet_Bank_Portlet",           // <-- Change this to your portlet name (from portlet.xml or @Component name)
			        "mvc.command.name=/save"                 // <-- This matches your <portlet:actionURL name="updateStudent">
			    },
			    service = MVCActionCommand.class
)

public class SaveActionCmd implements MVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(SaveActionCmd.class);
	
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
log.info("bank Save method before: ");
       ThemeDisplay themeDisplay=(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
       
		Long account_Number =ParamUtil.getLong(actionRequest, "account_Number");
		String account_Typ=ParamUtil.getString(actionRequest, "account_Type");
		
		String account_Status=ParamUtil.getString(actionRequest, "account_Status");
		int status=ParamUtil.getInteger(actionRequest, "status");
		
		 // BankTable bank=  BankTableLocalServiceUtil.getInstance();
		
		long bankId = CounterLocalServiceUtil.increment(BankTable.class.getName());
		BankTable bank = BankTableLocalServiceUtil.createBankTable(bankId);

		
		bank.setAccount_Number(account_Number);
		bank.setAccount_Type(account_Typ);
		
		bank.setAccount_Status(account_Status);
bank.setStatus(status);
		
		BankTableLocalServiceUtil.addBankTable(bank);
		ServiceContext serviceContext;
		try {
		    serviceContext = ServiceContextFactory.getInstance(BankTable.class.getName(), actionRequest);

		    AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(
		        themeDisplay.getUserId(),                       // userId
		        themeDisplay.getScopeGroupId(),                 // groupId
		        bank.getCreateDate(),                           // createDate
		        bank.getModifiedDate(),                         // modifiedDate
		        BankTable.class.getName(),                      // className
		        bank.getPrimaryKey(),                           // classPK
		        bank.getUuid(),                                 // classUuid
		        0,                                              // classTypeId
		        null,                                           // categoryIds
		        null,                                           // tagNames
		        true,                                           // visible
		        false,                                          // listable
		        new Date(),                                     // startDate
		        null,                                           // endDate
		        new Date(),                                     // publishDate
		        null,                                           // expirationDate
		        ContentTypes.TEXT_HTML,                         // contentType
		        bank.getAccount_Type(),                         // title
		        bank.getAccount_Status(),                       // description
		        null,                                           // summary
		        null,                                           // url
		        null,                                           // layoutUuid
		        0,                                              // height
		        0,                                              // width
		        null                                            // priority
		    );

		    // Reindex the BankTable entity
		    Indexer<BankTable> indexer = IndexerRegistryUtil.nullSafeGetIndexer(BankTable.class);
		    indexer.reindex(bank);

		    // Start workflow
		    WorkflowHandlerRegistryUtil.startWorkflowInstance(
		        themeDisplay.getCompanyId(),
		        themeDisplay.getScopeGroupId(),
		        themeDisplay.getUserId(),
		        BankTable.class.getName(),
		        bank.getPrimaryKey(),
		        bank,
		        serviceContext
		    );

		} catch (PortalException e) {
		    log.error("Error while saving BankTable entry: ", e);
		}

		/*
		 * ServiceContext serviceContext; try { serviceContext =
		 * ServiceContextFactory.getInstance(BankTable.class.getName(), actionRequest);
		 * 
		 * AssetEntry assetEntry =
		 * AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(),
		 * serviceContext.getScopeGroupId(), new Date(), new Date(),
		 * BankTable.class.getName(), bank.getUuid(), bank.getUuid(), 0, null, null,
		 * true, false, new Date(), null, new Date(), null, ContentTypes.TEXT_HTML,
		 * "Student", "Student", null, null, 0, 0, null);
		 * 
		 * Indexer<BankTable> indexer =
		 * IndexerRegistryUtil.nullSafeGetIndexer(BankTable.class);
		 * indexer.reindex(bank);
		 * 
		 * WorkflowHandlerRegistryUtil.startWorkflowInstance(themeDisplay.getCompanyId()
		 * , themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
		 * BankTable.class.getName(), bank.getPrimaryKey(), bank, serviceContext); }
		 * catch (PortalException e) { e.printStackTrace(); }
		 */
		return true;
	}


}
