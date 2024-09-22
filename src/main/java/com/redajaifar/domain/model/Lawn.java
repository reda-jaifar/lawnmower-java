package com.redajaifar.domain.model;

public class Lawn {
    private int x;
    private int y;

    public Lawn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


