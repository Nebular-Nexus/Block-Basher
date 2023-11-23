public class Brick {
    private int durability;
    private String color;
    private int x; // X-coordinate position
    private int y; // Y-coordinate position
    public Brick(int durability, String color, int x, int y) {
        this.durability = durability;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

