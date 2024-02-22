package runner;

import controller.TodoControllerGUI;


import javax.swing.*;

public class GUIRunner {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoControllerGUI::new);
    }

}
