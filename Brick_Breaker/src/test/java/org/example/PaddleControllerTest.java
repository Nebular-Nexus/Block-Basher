
package org.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class PaddleControllerTest {
    private PaddleController paddleController;
    private InputConnector inputConnector;

    @BeforeEach
    public void setUp() {
        InputHandler inputHandler = new InputHandler();
        inputConnector = new InputConnector(inputHandler);
        paddleController = new PaddleController(inputConnector, 50, 100, 5);
    }

    @Test
    public void testMoveLeftWhenLeftKeyPressed() {
        KeyEvent mockedKeyEvent = mock(KeyEvent.class);
        when(mockedKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        paddleController.handleInput(mockedKeyEvent);
        Assertions.assertEquals(95, paddleController.getPaddlePosition());
    }

//    @Test
//    @DisplayName("ActionListener test")
//    void testActionListener(){
//        HelpWindow helpWindow = new HelpWindow("menu");
//        helpWindow.setHelpWindow();
//
//        assertDoesNotThrow(() -> helpWindow.getReturnButton().doClick());
//    }
}