package com.calculator;

import java.sql.SQLException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.util.MySQL;

@Controller

public class ResultController
{
	// inject via application.properties
	//@Value("${welcome.message:test}")
	private String message = "Hola Mundo";

	@RequestMapping("/result")
	public String result(Map<String, Object> model) 
	{
		model.put("message", this.message);
				
		return "result";
	}
	
	
	public double getTotal(String termType, String location, String instanceType, String quantity)
	{
		double total = 0;
		try
    	{
						
    		MySQL db = new MySQL();
    		db.MySQLConnect();

    		String NombreDB = "Registro";
           
    		String Query = "SELECT "
    					 + "	PricePerUnit "
    					 + "FROM prices "
    					 + "where  TermType = '"+termType+"' "
    					 + "and Location = '"+location+"' "
    					 + "and Instance_Type = '"+ instanceType+"' ";
    		

           System.out.println(Query);

    		db.comando = db.conexion.createStatement();
    		db.registro = db.comando.executeQuery(Query);

    		int records = 0;
    		
    		while (db.registro.next()) 
    		{
    			records ++;
        		total = total + db.registro.getDouble(1);
    		}
    		
    		total = total * Integer.parseInt(quantity);
    		System.out.println(records);

    		System.out.println(total);
    		
    		
    	} 
    	catch (SQLException ex) 
    	{
           ex.printStackTrace();
    	}
		return total;
	}
}