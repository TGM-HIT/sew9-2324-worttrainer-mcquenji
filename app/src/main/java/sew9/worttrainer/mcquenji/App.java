package sew9.worttrainer.mcquenji;

import sew9.worttrainer.mcquenji.controller.Controller;
import sew9.worttrainer.mcquenji.models.*;

public class App {

    public static void main(String[] args) {
        // Sample entries for testing
        WordEntry[] entries = {
                new WordEntry("apple", "https://example.com/apple.jpg"),
                new WordEntry("banana", "https://example.com/banana.jpg")
        };
        Trainer trainer = new Trainer(entries);
        Controller controller = new Controller(trainer);

        controller.show();
    }
}
