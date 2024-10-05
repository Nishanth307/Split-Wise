package com.scaler.splitwise;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.scaler.splitwise.commands.CommandExecutor;
import com.scaler.splitwise.commands.CreateUserCommand;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner{
	private Scanner scanner;
	private CommandExecutor commandExecutor;
	public SplitwiseApplication(CommandExecutor commandExecutor,CreateUserCommand command){
		this.scanner = new Scanner(System.in);
		this.commandExecutor = commandExecutor;
		this.commandExecutor.addCommand(command);
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			System.out.println("Enter CLI Input: ");
			String input = scanner.nextLine();
			System.out.println("User entered: "+input);
			commandExecutor.execute(input);
		}
	}
}
