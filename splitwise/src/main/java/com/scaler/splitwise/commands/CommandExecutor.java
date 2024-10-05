package com.scaler.splitwise.commands;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {
      private List<Comand> commands = new ArrayList<>();
      public void addCommand(Comand comand){
            commands.add(comand);
      }
      public void removeCommand(Comand comand){
            if (commands.contains(comand)){
                  commands.remove(comand);
            }
      }

      public void execute(String input){ 
            for (Comand comand:commands){
                  if(comand.matches(input)){
                        comand.execute(input);
                        break;
                  }
            }
      }
}
