package org.example;

import java.awt.event.KeyEvent;
public class InputHandler {

    public String keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           return "left";
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            return "right";
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            return "enter";
        }
        return "none";
    }
}
