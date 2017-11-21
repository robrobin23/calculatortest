package com.example.demo;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import com.example.util.*;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class CalculatorApplication 
{
    @RequestMapping("/")
    @ResponseBody
    String home() 
    {
    	try
    	{
    	
    		MySQL db = new MySQL();
    		db.MySQLConnect();

    		String NombreDB = "Registro";
           
    		String Query = "SELECT count(*) FROM prices";
           

    		db.comando = db.conexion.createStatement();
    		db.registro = db.comando.executeQuery(Query);


    		while (db.registro.next()) 
    		{
               
               System.out.println("Nombre: " + db.registro.getInt(1));

         
    		}
    	} 
    	catch (SQLException ex) 
    	{
           ex.printStackTrace();
    	}
    	
        return "Hola Mundisimo";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}