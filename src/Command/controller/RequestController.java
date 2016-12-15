package Command.controller;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Class for control dispatch.
 *
 * RequestController, accepts input and converts it to commands for the Calculator or to response for the output.
 */
public class RequestController {

    /* initialize controller for contact with user by console */
    private final StreamController streamController = new StreamController(System.in, System.out);

    /**
     * Executes user's command.
     *
     * @throws Exception if something is wrong with execution
     */
    public void run() throws Exception {
        streamController.sendResponse("Hello!");

        while (true) {
            /* request user for expression */
            streamController.sendResponse("Input expression to calculate \n"+
                    "OR 'HISTORY' / 'UNIQUE HISTORY' to see history of results \nOR 'EXIT' to quit program .");
            String expression = streamController.getRequest();
            expression = expression.trim();
            System.out.println("expression = "+expression);
            String commandName = expression.toUpperCase().replace("UNIQUE HISTORY", "UNIQUE_HISTORY");
            System.out.println("commandName = "+commandName);
            boolean isCommand = false;

                try {
                    for (RequestCommand command : RequestCommand.values()) {
                        if (!commandName.contains(command.name())) {
                            continue;
                        } else {
                            isCommand = true;
                            commandName = command.name();
                            break;
                        }
                    }
                    if (isCommand){
                        RequestCommand command2 = RequestCommand.valueOf(commandName);
                        command2.apply(streamController);
                    } else {
                        String result = String.valueOf(9999.0);
                        streamController.sendResponse(result);
                    }

                } /*catch (InputExpressionException | NumberFormatException | ArithmeticException e) {
                    *//* send error message if some calculator exception has been caught *//*
                    streamController.sendResponse("Incorrect expression. "+e.getMessage()+" Try again.\nIf you have negative number then you should use brackets. \nExample: (-2) + 3*4 - 7/(-5^(-2))\n");
                } catch (InputCommandException e){
                    *//* send error message if some command exception has been caught *//*
                    streamController.sendResponse("Incorrect command. "+e.getMessage());
                } */catch (NoSuchElementException | StringIndexOutOfBoundsException e){
                    /* send error message if some calculator exception has been caught */
                    streamController.sendResponse("Нет операндов ");
                } catch (Exception e){
                    streamController.sendResponse(e.getMessage()+" <- RequestController cath Exception "+e.getClass());
                }
        }
    }
}
