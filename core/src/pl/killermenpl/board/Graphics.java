package pl.killermenpl.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Graphics {
	
	public SpriteBatch batch;
	public ShapeRenderer sr;
	
	public Graphics(){
		sr = new ShapeRenderer();
		batch = new SpriteBatch();
	}
	
	public void begin(){
		batch.begin();
		sr.begin(ShapeType.Filled);
	}
	
	
	public void end(){
		batch.end();
		sr.end();
	}
	
}
