package com.examples.DesignPatterns.Behavioral.Command;

public class AddTextCommand extends AbstractCommand {

    private String undoText;

    private String textToBeAdded;

    public AddTextCommand(TextEditor textEditor, String textToBeAdded) {
        super(textEditor);
        this.textToBeAdded = textToBeAdded;
    }

    public void action() {
        undoText = getTextEditor().getText();
        getTextEditor().setText(getTextEditor().getText()+textToBeAdded);
    }

    public void undo() {
        getTextEditor().setText(undoText);
    }
}
