package pl.killermenpl.board;

import com.badlogic.gdx.math.Vector2;

public class BoardQuarter {

	public Piece[][] pieces;

	public Vector2 center;
	public static float offset = 21;
	public BoardQuarter(Vector2 center) {
		pieces = new Piece[3][3];
		for(int x = -1; x < 2; x++){
			for(int y = -1; y < 2; y++){
				Piece p = new Piece(new Vector2(center.x + (x*offset), center.y+(y*offset)));
				RotateGame.pieces.add(p);
				pieces[x+1][y+1] = p;
			}
		}
		
		this.center = center;
	}

	
	public void draw(Graphics g) {
		for(int x = -1; x < 2; x++){
			for(int y = -1; y < 2; y++){
				Piece p = pieces[x+1][y+1];
				
				p.draw(g);
			}
		}
	}

	/**
	 * 
	 * @param dir
	 *            > 0 rotates to the left, < - rotates to the right
	 */
	public void rotate(int dir) {
		Piece[][] tmp = new Piece[3][3];
		if (dir > 0) {
			tmp[0][0] = pieces[2][0];
			tmp[0][1] = pieces[2][1];
			tmp[0][2] = pieces[2][2];

			tmp[1][0] = pieces[1][0];
//			tmp[1][1] = pieces[0][0];
			tmp[1][2] = pieces[1][2];

			tmp[2][0] = pieces[0][0];
			tmp[2][1] = pieces[0][1];
			tmp[2][2] = pieces[0][2];

		}
		if (dir < 0) {
			tmp[0][0] = pieces[0][2];
			tmp[0][1] = pieces[1][2];
			tmp[0][2] = pieces[2][2];

			tmp[1][0] = pieces[0][1];
//			tmp[1][1] = pieces[0][0];
			tmp[1][2] = pieces[2][1];

			tmp[2][0] = pieces[2][0];
			tmp[2][1] = pieces[2][1];
			tmp[2][2] = pieces[2][2];
		}
		pieces = tmp;
	}

}
