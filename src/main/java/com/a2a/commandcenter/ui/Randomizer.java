package com.a2a.commandcenter.ui;

import com.a2a.commandcenter.model.data.UIInstruction.Rectangle;

public class Randomizer {

    public static Point getRandomPoint(Rectangle rectangle) {
        int x = (int) (rectangle.getX() + Math.random() * rectangle.getWidth());
        int y = (int) (rectangle.getY() + Math.random() * rectangle.getHeight());
        return new Point(x, y);
    }

}
