package BankDB.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import BankDB.model.BankTable;
import BankDB.model.impl.BankTableImpl;
import BankDB.service.persistence.BankTableFinder;

@Component(service=BankTableFinder.class)
public class BankTableFinderImpl extends BankTableFinderBaseImpl implements BankTableFinder{

    @Reference
	private CustomSQL customSQL;
    
    public List<BankTable> getAllAccountType(String AccStatus)
    {
    	System.out.println(" finder before AccStatus: "+AccStatus);
    	List<BankTable> bankTableArray =new ArrayList<BankTable>();
    	Session session=null;
    	
    	try {
    		
    		
    		//open ORM Session
    		session= openSession();
    		
    		//get sql query return in default.xml
    		String sql=customSQL.get(getClass(), "getAllAccountStatus");
    		System.out.println("sql== "+sql);
    		
    		SQLQuery sqlquery=session.createSQLQuery(sql);
    		sqlquery.setCacheable(false);
    		
    		//add entity to be searched
    		sqlquery.addEntity("BankTable",BankTableImpl.class);
    		
    		
    		//replace positional parameter in the query
    		QueryPos queryPos=QueryPos.getInstance(sqlquery);
    		queryPos.add(AccStatus + "%");
    		
    		//Execute query and return result
    		bankTableArray=(List<BankTable>)sqlquery.list();
    		System.out.println(" Finder  AccStatus: "+bankTableArray);
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	finally {
    		closeSession(session);
    	}
    	
    	return bankTableArray;
    	
    }
}
