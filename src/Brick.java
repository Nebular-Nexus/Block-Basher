public class Brick {
    private int durability;
    private String color;
    private Double x; // X-coordinate position
    private Double y; // Y-coordinate position
    public Brick(int durability, String color, Double x, Double y) {
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
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

