package pl.killermenpl.board;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class RotateGame extends ApplicationAdapter implements InputProcessor {
	public Board board;
	public Graphics g;

	public static Player currentPlayer;

	public Player[] players;

	public static Array<Piece> pieces;
	public int playerIndex = 1;

	//TODO: Add rotation and board borders
	
	@Override
	public void create() {
		pieces = new Array<Piece>();

		board = new Board(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
		g = new Graphics();
		players = new Player[2];
		players[0] = new Player(Color.GREEN);
		players[1] = new Player(Color.RED);
		currentPlayer = players[0];

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(.2f, .2f, .2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		g.begin();

		board.draw(g);

		g.end();
	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		float x = screenX;
		float y = Gdx.graphics.getHeight() - screenY;
		Vector2 point = Vector2.X;
		point.set(x, y);
		for (Piece p : pieces) {
			if (p.placed)
				continue;
			if (p.circle.contains(point)) {
				// System.out.println(p);
				p.place();
				currentPlayer = players[playerIndex];
				if (playerIndex == 1)
					playerIndex = 0;
				else
					playerIndex = 1;
			}
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
