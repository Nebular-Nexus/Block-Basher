package org.example;

import java.awt.Color;
import java.util.Hashtable;

public class Brick {
    private int durability;
    private Color color;
    private Double x; // X-coordinate position
    private Double y; // Y-coordinate position
    public static Hashtable<Integer,Color> brickDurability;

    static {
        brickDurability = new Hashtable<>();
        brickDurability.put(1, new Color(157, 178, 191));
        brickDurability.put(2,new Color(82, 109, 130));
        brickDurability.put(3,new Color(39, 55, 77));
    }
    
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
    public void updateBrick(int value){
        this.setDurability(value);
        this.setColor(brickDurability.get(value));
    }
}

