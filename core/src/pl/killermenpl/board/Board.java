package pl.killermenpl.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Color;


public class Board {

	public BoardQuarter tl, tr, bl, br;

	public Vector2 center;

	public Board(Vector2 center) {
		this.center = center;

		float offset = Gdx.graphics.getHeight() / 4;
		BoardQuarter.offset = offset / 2;
		Piece.r = offset / 5;

		tl = new BoardQuarter(new Vector2(center).add(-offset, offset));
		tr = new BoardQuarter(new Vector2(center).add(offset, offset));
		bl = new BoardQuarter(new Vector2(center).add(-offset, -offset));
		br = new BoardQuarter(new Vector2(center).add(offset, -offset));
	}

	public void draw(Graphics g) {
		tl.draw(g);
		tr.draw(g);
		bl.draw(g);
		br.draw(g);
	}

	public BoardQuarter[] getQuarters() {
		return new BoardQuarter[]{tl, tr, bl, br};
	}

	public boolean checkWin() {
		return checkDown(0, 0) ||
				checkDown(1, 0) ||
				checkDown(2, 0) ||
				checkDown(3, 0) ||
				checkDown(4, 0) ||
				checkDown(5, 0) ||
				checkDown(0, 1) ||
				checkDown(1, 1) ||
				checkDown(2, 1) ||
				checkDown(3, 1) ||
				checkDown(4, 1) ||
				checkDown(5, 1) ||
				checkRight(0, 0) ||
				checkRight(0, 1) ||
				checkRight(0, 2) ||
				checkRight(0, 3) ||
				checkRight(0, 4) ||
				checkRight(0, 5) ||
				checkRight(1, 0) ||
				checkRight(1, 1) ||
				checkRight(1, 2) ||
				checkRight(1, 3) ||
				checkRight(1, 4) ||
				checkRight(1, 5);
	}

	public boolean checkDown(int x, int y) {
		Piece[] ps = null;
		if (x < 3) {
			if (y == 0) {
				ps = new Piece[]{
						tl.pieces[x][y],
						tl.pieces[x][y + 1],
						tl.pieces[x][y + 2],
						bl.pieces[x][y + 0],
						bl.pieces[x][y + 1]
				};
			} else {

				ps = new Piece[]{
						tl.pieces[x][y],
						tl.pieces[x][y + 1],
						bl.pieces[x][y-1],
						bl.pieces[x][y],
						bl.pieces[x][y + 1]
				};
			}
		} else {
			x -= 3;
			if (y == 0) {
				ps = new Piece[]{
						tr.pieces[x][y],
						tr.pieces[x][y + 1],
						tr.pieces[x][y + 2],
						br.pieces[x][y + 0],
						br.pieces[x][y + 1]
				};

			} else {
				ps = new Piece[]{
						tr.pieces[x][y],
						tr.pieces[x][y + 1],
						br.pieces[x][y -1],
						br.pieces[x][y ],
						br.pieces[x][y + 1]
				};
			}

		}
		Color c = ps[0].c;
		for (int i = 1; i < 5; i++) {
			if (ps[i].c != c || ps[i].c == Color.WHITE)
				return false;
		}
		return true;
	}

	public boolean checkDiagLeft(int x, int y){
		Piece[] ps = null;
		if(x==0 && y==0){
			ps = new Piece[]{
					tr.pieces[0][0],
					tr.pieces[1][1],
					tr.pieces[2][2],
					br.pieces[0][0],
					br.pieces[1][1]
			};
		}else if(x==1 && y==0){
			ps = new Piece[]{
					tr.pieces[1][0],
					tr.pieces[2][1],
					tl.pieces[2][0],
					br.pieces[1][0],
					br.pieces[2][1]
			};
		}else if(x==0 && y==1){
			ps = new Piece[]{
					tr.pieces[0][0],
					tr.pieces[1][1],
					tr.pieces[2][2],
					br.pieces[0][0],
					br.pieces[1][1]
			};
		}else if(x==1 && y==1){
			ps = new Piece[]{
					tr.pieces[0][0],
					tr.pieces[1][1],
					tr.pieces[2][2],
					br.pieces[0][0],
					br.pieces[1][1]
			};
		}
		Color c = ps[0].c;
		for (int i = 1; i < 5; i++) {
			if (ps[i].c != c || ps[i].c == Color.WHITE)
				return false;
		}

		return true;
	}

	public boolean checkRight(int x, int y) {
		Piece[] ps = null;
		if (y < 3) {
			if (x == 0) {
				ps = new Piece[]{
						tl.pieces[x][y],
						tl.pieces[x+1][y],
						tl.pieces[x+2][y],
						tr.pieces[x][y],
						tr.pieces[x+1][y]
				};

			} else {
				ps = new Piece[]{
						tl.pieces[x][y],
						tl.pieces[x+1][y],
						tr.pieces[x-1][y],
						tr.pieces[x][y],
						tr.pieces[x+1][y]
				};

			}
		} else {
			y -= 3;
			if (x == 0) {
				ps = new Piece[]{
						br.pieces[x][y],
						br.pieces[x+1][y],
						br.pieces[x+2][y],
						bl.pieces[x][y],
						bl.pieces[x+1][y]
				};

			} else {
				ps = new Piece[]{
						br.pieces[x][y],
						br.pieces[x+1][y],
						bl.pieces[x-1][y],
						bl.pieces[x][y],
						bl.pieces[x+1][y]
				};

			}

		}
		Color c = ps[0].c;
		for (int i = 1; i < 5; i++) {
			if (ps[i].c != c || ps[i].c == Color.WHITE)
				return false;
		}
		return true;
	}
}
