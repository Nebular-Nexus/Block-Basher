import java.awt.Color;

public class Brick {
    private int durability;
    private Color color;
    private Double x; // X-coordinate position
    private Double y; // Y-coordinate position
    public Brick(int durability, Color color, Double x, Double y) {
        this.durability = durability;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public Double getX() {
        return this.x;
    }
    public void setX(Double x) {
        this.x = x;
    }
    public Double getY() {
        return y;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}

