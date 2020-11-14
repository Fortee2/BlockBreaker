package com.mygame.breaker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Breaker extends ApplicationAdapter {

	ShapeRenderer shapeRenderer;
	Integer ballX = 51, xDir = 1, ballY = 50, yDir = 1, xSpeed = 5, ySpeed = 2 ;

	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 01, 01, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(0,0,1,1);
		shapeRenderer.circle(ballX, ballY,50);
		shapeRenderer.end();

		if(ballX + 50 > Gdx.graphics.getWidth()  || ballX - 50 < 0){
			xDir = xDir * -1;
		}

		if(ballY + 50 > Gdx.graphics.getHeight() || ballY < 50){
			yDir = yDir * -1;
		}

		ballX = ballX + (xSpeed * xDir);
		ballY = ballY + (ySpeed * yDir);
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}
