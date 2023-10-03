package sew9.worttrainer.mcquenji;

import sew9.worttrainer.mcquenji.controller.Controller;
import sew9.worttrainer.mcquenji.models.*;
import sew9.worttrainer.mcquenji.serialization.*;
import sew9.worttrainer.mcquenji.serialization.json.*;

public class App {

    public static void main(String[] args) {
        // Sample entries for testing
        WordEntry[] entries = {
                new WordEntry("Apple",
                        "https://www.macwelt.de/wp-content/uploads/2023/04/4331547_original.jpg?quality=50&strip=all"),
                new WordEntry("Banana",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Banana-Single.jpg/800px-Banana-Single.jpg")
        };
        Trainer trainer = new Trainer(entries);
        Controller controller = new Controller(trainer);

        controller.show();
    }
}
