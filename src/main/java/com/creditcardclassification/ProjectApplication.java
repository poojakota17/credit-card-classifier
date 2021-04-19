package com.creditcardclassification;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import java.io.*;

@SpringBootApplication
public class ProjectApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		//String csvFile = "C:/Users/Checkout/Downloads/data.csv";
		
		
		String filename= "data.csv";
		Client client=new Client();
		client.read(filename);
		
	
	 }


}
 
    
 


