package com.scaler.splitwise.commands;

//step-1 an abstraction over all commands
public interface Comand {
      //It needs to check if it can execute against a particular user input
      public boolean matches(String input);//to check "split register" command string matches
      public void execute(String input);
}
