package com.calculator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.util.MySQL;

@Controller
public class WelcomeController
{
	public ArrayList<String> termTypeArrayList = new ArrayList<String>();

	// inject via application.properties
	//@Value("${welcome.message:test}")
	private String message = "Hola Mundo";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) 
	{
		model.put("message", this.message);
				
		return "welcome";
	}
	
	public ArrayList<String> getTermType(ArrayList<String> lista)
	{
		try
    	{
						
    		MySQL db = new MySQL();
    		db.MySQLConnect();

    		String NombreDB = "Registro";
           
    		String Query = "SELECT distinct(TermType) FROM prices";
           

    		db.comando = db.conexion.createStatement();
    		db.registro = db.comando.executeQuery(Query);


    		while (db.registro.next()) 
    		{
    			lista.add(db.registro.getString(1));
               
    		}
    		
    		System.out.println(lista.size()); 
    		
    	} 
    	catch (SQLException ex) 
    	{
           ex.printStackTrace();
    	}
		return lista;
	}
	
	public ArrayList<String> getLocation(ArrayList<String> lista)
	{
		try
    	{
						
    		MySQL db = new MySQL();
    		db.MySQLConnect();

    		String NombreDB = "Registro";
           
    		String Query = "SELECT distinct(Location) FROM prices";
           

    		db.comando = db.conexion.createStatement();
    		db.registro = db.comando.executeQuery(Query);


    		while (db.registro.next()) 
    		{
    			lista.add(db.registro.getString(1));
               
    		}
    		
    		System.out.println(lista.size()); 
    		
    	} 
    	catch (SQLException ex) 
    	{
           ex.printStackTrace();
    	}
		return lista;
	}
	
	public ArrayList<String> getInstanceType(ArrayList<String> lista)
	{
		try
    	{
						
    		MySQL db = new MySQL();
    		db.MySQLConnect();

    		String NombreDB = "Registro";
           
    		String Query = "SELECT distinct(Instance_Type) FROM prices";
           

    		db.comando = db.conexion.createStatement();
    		db.registro = db.comando.executeQuery(Query);


    		while (db.registro.next()) 
    		{
    			lista.add(db.registro.getString(1));
               
    		}
    		
    		System.out.println(lista.size()); 
    		
    	} 
    	catch (SQLException ex) 
    	{
           ex.printStackTrace();
    	}
		return lista;
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