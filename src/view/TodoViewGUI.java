package view;

import model.data.Task;
import model.data.TaskStatus;

import javax.swing.*;
import java.awt.*;

public class TodoViewGUI extends JFrame {

    private final JList<Task> taskList = new JList<>();
    private final JTextField taskInput = new JTextField();
    private final JButton addButton = new JButton("Add Task");
    private final JButton deleteButton = new JButton("Delete Task");
    private final JButton changeStatusButton = new JButton("Update Status");

    public TodoViewGUI() {
        super("To-Do List");
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        taskList.setCellRenderer(new TaskRenderer());

        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        JPanel bottomPanel = createBottomPanel();
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(taskInput);

        taskInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, taskInput.getPreferredSize().height));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(changeStatusButton);

        bottomPanel.add(buttonPanel);

        return bottomPanel;
    }

    public JList<Task> getTaskList() {
        return taskList;
    }

    public JTextField getTaskInput() {
        return taskInput;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getChangeStatusButton() {
        return changeStatusButton;
    }

    private static class TaskRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof Task task) {
                setText(task.toString());

                if (task.getStatus() == TaskStatus.DONE) {
                    setBackground(new Color(1, 169, 0));
                } else if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                    setBackground(new Color(231, 181, 4));
                } else {
                    setBackground(new Color(191, 22, 23));
                }
            }
            return c;
        }
    }
}
