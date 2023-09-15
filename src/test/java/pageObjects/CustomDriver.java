package pageObjects;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.Response;

public class CustomDriver extends ChromeDriver {

    protected Response execute(String commandName, Command command) {
        System.out.println("1");
        if (commandName.equals(DriverCommand.SEND_KEYS_TO_ELEMENT)) {
            currentTestOutcome = "passed";
            try {
                return super.execute(commandName);
            } catch (Exception e) {
                currentTestOutcome = "failed";
                throw e;
            }
        } else {
            return super.execute(commandName);
        }
    }

    protected void startSession(CommandExecutor executor, Capabilities capabilities) {
        System.out.println("2");
        super.startSession(capabilities);
        currentTestOutcome = null;
    }

    protected void afterCommand(Command command) {
        System.out.println("3");
        if (currentTestOutcome != null && currentTestOutcome.equals("failed")) {
            runScriptOnFailure();
        }
    }

    private void runScriptOnFailure() {
        System.out.println("4");
        if (currentTestOutcome.equals("failed")) {
            // Call your custom script here with the relevant information
            System.out.println("Test has failed. Running custom script...");
            // Example: ProcessBuilder processBuilder = new ProcessBuilder("path_to_custom_script.bat");
            // processBuilder.start();
        }
    }

    private String currentTestOutcome;
}