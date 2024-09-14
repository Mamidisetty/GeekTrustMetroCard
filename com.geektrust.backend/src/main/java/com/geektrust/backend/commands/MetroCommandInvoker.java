package com.geektrust.backend.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.backend.exception.CommandNotFoundException;

public class MetroCommandInvoker {
	
	private static final Map<String,MetroICommand> commandMap= new HashMap<>();
	
	public void register(String commandName,MetroICommand iCommand) {
		commandMap.put(commandName, iCommand);
		
	}
	
	private MetroICommand getCommand(String commandName)
	{
		return commandMap.get(commandName);
	}
	
	public void excuteCommand(String commandName,List<String> tokens) throws CommandNotFoundException{
		
		MetroICommand command= getCommand(commandName);
		
		if(command == null) {
			throw new CommandNotFoundException(commandName+"not found");
		}else {
			command.excute(tokens);
		}
	}

}
