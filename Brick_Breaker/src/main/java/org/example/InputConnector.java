package org.example;

import java.awt.event.KeyEvent;

public class InputConnector {
    private InputHandler inputHandler;

    public InputConnector(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public String keyPressed(KeyEvent e){
        return inputHandler.keyPressed(e);
    }
}
