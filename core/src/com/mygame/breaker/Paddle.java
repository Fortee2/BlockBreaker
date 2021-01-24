package com.mygame.breaker;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    private Point position;
    private int width, height;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(ShapeRenderer renderer){
        renderer.setColor(1,0,0,1);
        renderer.rect(position.getX(),position.getY(),width,height);

        position.setX(position.getX() );
    }

    public void checkWalls(float screenWidth){
        if(position.getX() + width >  screenWidth)
        {
            position.setX( (int) screenWidth - width);
        }
        else if (position.getX() < 0){
            position.setX(0);
        }
    }

}
