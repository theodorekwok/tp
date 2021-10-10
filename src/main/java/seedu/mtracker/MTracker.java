package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.util.Scanner;

public class MTracker {

    private InstrumentManager instrumentManager;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
    }

    public void run() {
        TextUi.greetAtStartUp();

        String userInput = InputParser.getUserInput();
        String[] inputComponents = InputParser.getCommandComponents(userInput);
        try {
            Command c = InputParser.filterByCommandType(inputComponents);
            while (!c.execute().equals(ExitCommand.COMMAND_WORD)) {
                c.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main entry-point for the mTracker application.
     */
    public static void main(String[] args) {
        new MTracker().run();
        //command.setData(instrumentManager, ui); uncomment after initialising ui and command
    }

}
