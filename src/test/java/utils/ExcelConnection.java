package utils;

import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import stepDefinition.Hooks;
import utils.SessionVariables;

public class ExcelConnection {
	static Fillo dbfillo;
	  static Connection connection;
	  static HashMap<String,String> hm;
	 
	public static void GetExcelConnection()
	{
		 dbfillo=new Fillo();
	//	String strExcelpath="src/test/resources/resourcesfiles/paraBank_data.xls";
		 System.out.println(Config.getProperty("Testdatafilepath"));
		 String strExcelpath=Config.getProperty("Testdatafilepath");
		try {
			connection=dbfillo.getConnection(strExcelpath);
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to connect to Excel");
			e.printStackTrace();
		} 
	}
	
	public static void queryData(String strTCid)
	{
		String query="Select * from Data where TC_ID='"+strTCid+"'";
		Recordset rs=null;
		hm=new HashMap();
		try {
			rs=connection.executeQuery(query);
			int count=rs.getFieldNames().size();
			if(rs.next())
			{
				for(int i=0;i<count;i++)
				{
					SessionVariables.hm.put(rs.getFieldNames().get(i),rs.getField(i).value());
				}
			}
			
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
