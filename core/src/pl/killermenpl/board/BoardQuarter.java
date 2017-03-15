package pl.killermenpl.board;

import java.util.Arrays;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BoardQuarter {

	public Piece[][] pieces;

	public Vector2 center;
	public static float offset = 50;
	public boolean selected = false;
	public Rectangle box;

	public BoardQuarter(Vector2 center) {
		pieces = new Piece[3][3];
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				Piece p = new Piece(new Vector2(center.x + (x * offset), center.y - (y * offset)));
				RotateGame.pieces.add(p);
				pieces[x + 1][y + 1] = p;
			}
		}
		box = new Rectangle(center.x - 2 * offset + 5, center.y - 2 * offset + 5, 4 * offset - 10, 4 * offset - 10);

		
		this.center = center;
	}

	public void draw(Graphics g) {
		if (selected)
			g.sr.setColor(.1f, .7f, .1f, .4f);
		else
			g.sr.setColor(.4f, .4f, .4f, .4f);
		// g.sr.box(center.x - 2 * offset + 5, center.y - 2 * offset + 5, 0, 4 *
		// offset - 10, 4 * offset - 10, 0);
		g.sr.rect(box.x, box.y, box.width, box.height);
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				Piece p = pieces[x + 1][y + 1];
				if (p != null)
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
		System.out.println(dir);
		Piece[][] tmp = new Piece[3][3];
		if (dir > 0) {
			tmp[0][0] = pieces[2][0];
			tmp[0][1] = pieces[2][1];
			tmp[0][2] = pieces[2][2];

			tmp[1][0] = pieces[1][0];
			tmp[1][1] = pieces[1][1];
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
			tmp[1][1] = pieces[1][1];
			tmp[1][2] = pieces[2][1];

			tmp[2][0] = pieces[0][0];
			tmp[2][1] = pieces[1][0];
			tmp[2][2] = pieces[2][0];
		}
		tmp[0][0].c = Color.CYAN;
//		System.out.println(Arrays.deepEquals(pieces, tmp));
		pieces = tmp;
//		System.out.println(Arrays.deepEquals(pieces, tmp));

		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				Piece p = pieces[x+1][y+1];
				p.pos.set(center.x + (x * offset), center.y - (y * offset));
			}
		}
		selected = false;
	}

}
