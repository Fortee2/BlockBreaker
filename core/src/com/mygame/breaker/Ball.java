package com.mygame.breaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private Point position;
    private int radius;
    private int speedX;
    private int speedY;
    private int xDir = 1,  yDir =1;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void draw(ShapeRenderer renderer){
        renderer.setColor(0,0,1,1);
        renderer.circle(position.getX(),position.getY(),radius);

        position.setX(position.getX() + (speedX * xDir));
        position.setY(position.getY() + (speedY * yDir));
    }

    public void collisionX(Point collisionPoint, int objectWidth){
        if(position.getX() + radius > collisionPoint.getX() + objectWidth  || position.getX() - radius < collisionPoint.getX()){
            xDir = xDir * -1;
        }
    }

    public void collisionY(Point collisionPoint, int objectHeight){
        if(position.getY() + radius > objectHeight + collisionPoint.getY() || position.getY() - radius < collisionPoint.getY()){
            yDir = yDir * -1;
        }
    }
}
