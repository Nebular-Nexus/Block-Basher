// CustomizationManager.java

import java.awt.Color;

public class CustomizationManager {
    private String paddleDesign;
    private Color ballColor;
    private Color backgroundTheme;

    public String getPaddleDesign() {
        return paddleDesign;
    }

    public void setPaddleDesign(String paddleDesign) {
        this.paddleDesign = paddleDesign;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    public Color getBackgroundTheme() {
        return backgroundTheme;
    }

    public void setBackgroundTheme(Color backgroundTheme) {
        this.backgroundTheme = backgroundTheme;
    }
}
