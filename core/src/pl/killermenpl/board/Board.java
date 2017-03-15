package pl.killermenpl.board;

import com.badlogic.gdx.math.Vector2;

public class Board {

	public BoardQuarter tl,tr,bl,br;
	
	public Vector2 center;
	
	public Board(Vector2 center){
		this.center = center;
		tl = new BoardQuarter(new Vector2(center).add(-100, -100));
		tr = new BoardQuarter(new Vector2(center).add(100, -100));
		bl = new BoardQuarter(new Vector2(center).add(-100, 100));
		br = new BoardQuarter(new Vector2(center).add(100, 100));
	}
	
	public void draw(Graphics g){
		tl.draw(g);
		tr.draw(g);
		bl.draw(g);
		br.draw(g);
	}

	public BoardQuarter[] getQuarters() {
		return new BoardQuarter[]{tl,tr,bl,br};
	}
	
}
