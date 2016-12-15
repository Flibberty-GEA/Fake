package Command.controller;


import Command.exceptions.StreamException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public enum RequestCommand {

    /**
     * Exit command
     */
    EXIT{
        void apply(final StreamController streamController) throws IOException {
            streamController.sendResponse("Good bye!");
            streamController.getWriter().close();
            return;
        }
    },
    UNIQUE_HISTORY{
        void apply(final StreamController streamController) throws IOException {
            streamController.sendResponse("УНИКАЛЬНАЯ ИСТОРИЯ");
        }
    },
    HISTORY{
        void apply(final StreamController streamController) throws IOException {
            streamController.sendResponse("ВСЯ ИСТОРИЯ");
        }
    },
    HELP{
        void apply(final StreamController streamController) throws IOException {
            BufferedReader in = new BufferedReader(new FileReader("src/Command/controller/resources/help.txt"));
            StringBuilder sb = new StringBuilder();
            String lineText;
            while ((lineText = in.readLine()) != null) {
                sb.append(lineText+"\n");
            }
            streamController.sendResponse(sb.toString());
        }
    };


    public final String getName(){
        return name().replace("_", " ");
    }

    /**
     *
     */
    abstract void apply(final StreamController streamController) throws IOException;

}