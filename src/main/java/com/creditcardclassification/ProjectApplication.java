package com.creditcardclassification;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class ProjectApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		//String csvFile = "C:/Users/Checkout/Downloads/data.csv";
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter an input filename. if file is in the same project directory provide a filename else provide a file path with forward slash'/'(Eg: 'C:/Users/Checkout/Downloads/data.csv')");  
		String inputfilename= sc.nextLine();   
		System.out.println("Enter an ouput filename to save the result. If you want to save file in the same project directory provide a name else provide a file path with forward slash'/'(Eg: 'C:/Users/Checkout/Downloads/data.csv')");
		String outputfilename=sc.nextLine();
		//String filename= "jsondata.json";
		//String filename="xmldata.xml";
		Client client=new Client();
		client.read(inputfilename,outputfilename);
		
	
	 }


}
 
    
 


