package com.mygame.breaker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Breaker extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	Ball gameBall = new Ball();
	OrthographicCamera camera;
	Viewport viewport;
	private final float wwidth = 1920f, wheight = 1080f;

	@Override
	public void create () {
		gameBall.setPosition(new Point(51, 50));
		gameBall.setSpeedX(5);
		gameBall.setSpeedY(2);
		gameBall.setRadius(20);

		shapeRenderer = new ShapeRenderer();

		setupCamera();
	}

	@Override
	public void render () {
		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);

		Gdx.gl.glClearColor(1, 01, 01, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		gameBall.draw(shapeRenderer);
		shapeRenderer.end();

		Point screenPoint = new Point(0,0);

		gameBall.collisionX(screenPoint, (int) wwidth);
		gameBall.collisionY(screenPoint, (int) wheight);
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
	}

	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}

	private void setupCamera(){
		camera = new OrthographicCamera();  //We are going to use the game world diminsions.   The camera an the view port will allow the game to scale
		viewport = new StretchViewport(wwidth,wheight,camera);
		camera.position.set(wwidth/2, wheight/2,0);
		viewport.apply();
	}
}
