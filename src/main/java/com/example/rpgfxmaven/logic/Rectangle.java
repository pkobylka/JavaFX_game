package com.example.rpgfxmaven.logic;


public class Rectangle {

    public double x;
    public double y;
    public double width;
    public double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(Rectangle other) {
        boolean noOverlap = (this.x < other.x + other.width) && (this.x + this.width > other.x) && (this.y < other.y + other.height/2) && (this.y + this.height/2 > other.y);
        return noOverlap;
    }
}