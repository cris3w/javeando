package com.examples.DesignPatterns.Behavioral.Command;

import java.util.LinkedList;
import java.util.Queue;

public class TextEditor {

    private String text;

    private Queue<Command> queue = new LinkedList<Command>();

    private void executeAction(Command command) {
        command.action();
        queue.add(command);
    }

    private void undo() {
        Command command = queue.poll();
        if (command != null) {
            command.undo();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Queue<Command> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Command> queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setText("1234");
        ClearTextCommand command = new ClearTextCommand(editor);
        editor.executeAction(command);
        System.out.println(String.format("Text is: %s", editor.getText()));
        editor.undo();
        System.out.println(String.format("Text is: %s", editor.getText()));
        AddTextCommand addTextCommand = new AddTextCommand(editor," fun text");
        editor.executeAction(addTextCommand);
        System.out.println(String.format("Text is: %s", editor.getText()));
    }
}
