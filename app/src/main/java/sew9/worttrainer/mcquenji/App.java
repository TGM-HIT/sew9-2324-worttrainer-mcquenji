package sew9.worttrainer.mcquenji;

import sew9.worttrainer.mcquenji.controller.Controller;
import sew9.worttrainer.mcquenji.models.*;
import sew9.worttrainer.mcquenji.serde.*;

public class App {

    static Trainer initDefaultTrainer() {
        WordEntry[] entries = {
                new WordEntry("Apple",
                        "https://www.macwelt.de/wp-content/uploads/2023/04/4331547_original.jpg?quality=50&strip=all"),
                new WordEntry("Banana",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Banana-Single.jpg/800px-Banana-Single.jpg")
        };

        return new Trainer(entries);
    }

    public static void main(String[] args) {

        ISerde serde = ISerde.INSTANCE;

        Trainer trainer = null;

        try {
            trainer = serde.deserialize(Controller.SAVE_FILE, Trainer.class);
        } catch (Exception e) {
            trainer = null;

            System.out.println("No save file found. Using default.");
        }

        if (trainer == null) {
            trainer = initDefaultTrainer();
        }

        Controller controller = new Controller(trainer);

        controller.show();
    }
}
