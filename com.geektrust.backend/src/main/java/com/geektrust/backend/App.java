package com.geektrust.backend;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.geektrust.backend.appConfig.MetroApplicationConfig;
import com.geektrust.backend.commands.MetroCommandInvoker;
import com.geektrust.backend.exception.CommandNotFoundException;

public class App {
	
	public static void main(String[] args) throws CommandNotFoundException {
		
		//System.out.println("Welcome to GeektrustBackend Challenge!");
        /*Sample code to read from file passed as command line argument*/
		List<String> inputCommands=new ArrayList<String>();
		
		try {
			//the file is open for reading
			FileInputStream file=new FileInputStream(args[0]);
			Scanner sc=new Scanner(file);// file is scanned 
			//returns true if there is another line to read
			while(sc.hasNextLine()) {
				
				String line=sc.nextLine();
				inputCommands.add(line);
			}
			sc.close(); //close the scanner
		} catch (Exception e) {
			
		}
		
		run(inputCommands);
		
		
		
	}
	//respective commands are invoked by command invoker
	public static void run(List<String> inputCommands) throws CommandNotFoundException {
		MetroApplicationConfig applicationConfig=new MetroApplicationConfig();
		MetroCommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
		
		for(String singleCommands:inputCommands) {
			
			List<String> tokens=Arrays.asList(singleCommands.split(" "));
			commandInvoker.excuteCommand(tokens.get(0), tokens);
		}
		
	}

}
