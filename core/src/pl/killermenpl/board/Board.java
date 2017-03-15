package pl.killermenpl.board;

import com.badlogic.gdx.math.Vector2;

public class Board {

	public BoardQuarter tl,tr,bl,br;
	
	public Vector2 center;
	
	public Board(Vector2 center){
		this.center = center;
		tl = new BoardQuarter(new Vector2(center).add(-40, -40));
		tr = new BoardQuarter(new Vector2(center).add(40, -40));
		bl = new BoardQuarter(new Vector2(center).add(-40, 40));
		br = new BoardQuarter(new Vector2(center).add(40, 40));
	}
	
	public void draw(Graphics g){
		tl.draw(g);
		tr.draw(g);
		bl.draw(g);
		br.draw(g);
	}
	
}
