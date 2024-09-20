package com.geektrust.backend.commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyList;

import java.util.ArrayList;

import com.geektrust.backend.exception.CommandNotFoundException;

@DisplayName("MetroCommand Invoker test")
@ExtendWith(MockitoExtension.class)
public class MetroCommandInvokerTest {

	
	private MetroCommandInvoker commandInvoker;
	
	@Mock
	private MetroBalanceCommand balanceCommand;
	
	@Mock
	private MetroCheckInCommand checkInCommand;
	
	@Mock
	private MetroPrintSummary printSummary;
	
	@BeforeEach
	public void setUp(){
		
		commandInvoker=new MetroCommandInvoker();
		commandInvoker.register("BALANCE", balanceCommand);
		commandInvoker.register("CHECK_IN", checkInCommand);
		commandInvoker.register("PRINT_SUMMARY", balanceCommand);
		
		}
	@Test
	@DisplayName("All the Known Commands should invoke sucessfully")
	public void excuteAnyGivenCommand() throws CommandNotFoundException{
		commandInvoker.excuteCommand("BALANCE",anyList());
		commandInvoker.excuteCommand("CHECK_IN", anyList());
		commandInvoker.excuteCommand("PRINT_SUMMARY",anyList());
	}
	@Test
	@DisplayName("any invalid command should be handled by exception handler")
	public void testExceptionForInvalidCommands() {
		
		Assertions.assertThrows(CommandNotFoundException.class,() -> commandInvoker.excuteCommand("Random_Command", new ArrayList<String>()));
		
	}
}
