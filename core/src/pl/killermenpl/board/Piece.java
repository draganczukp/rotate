package pl.killermenpl.board;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Piece {

	public Color c = Color.WHITE;
	
	public Vector2 pos;
	
	public Circle circle;

	public boolean placed;
	
	public Piece(Vector2 pos){
		this.pos = pos;
		circle = new Circle(pos, 20);
	}
	
	public void draw(Graphics g){
		g.sr.setColor(c);
		g.sr.circle(pos.x, pos.y, 20);
	}
	
	public void place(){
		this.c = RotateGame.currentPlayer.c;
		placed = true;
	}
}
