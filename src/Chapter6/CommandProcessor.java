package Chapter6;

import java.util.List;
import java.util.ArrayList;

public class CommandProcessor {
    // Build a CommandProcessor that is an abstraction that allows clients to
    // execute commands, store executed commands, and undo the last executed
    // command. Ensure your design respects the Law of Demeter.
    private final List<Command> aCommands = new ArrayList<>();

    public void consume(Command pCommand){
        pCommand.execute();
        aCommands.add(pCommand);
    }
    public void undoLast(){
        assert !aCommands.isEmpty();
        Command command = aCommands.remove(aCommands.size()-1); //remove returns the command
        command.undo();
    }

}
