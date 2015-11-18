package htwg.se.model;

import htwg.util.Point;

public class GameField {
	
	private Pawn blackPawns[];
	private Pawn whitePawns[];
	private Tower blackTowers[];
	private Tower whiteTowers[];
	private Knight blackKnights[];
	private Knight whiteKnights[];
	private Bishop blackBishops[];
	private Bishop whiteBishops[];
	private Queen blackQueen;
	private Queen whiteQueen;
	private King blackKing;
	private King whiteKing;
	
	private Field field[][];
	
	public GameField() {
		field = new Field[8][8];
		initField();
		blackPawns = new Pawn[8];
		whitePawns = new Pawn[8];
		blackTowers = new Tower[2];
		whiteTowers = new Tower[2];
		blackKnights = new Knight[2];
		whiteKnights = new Knight[2];
		blackBishops = new Bishop[2];
		whiteBishops = new Bishop[2];
		initWhitePawns();
		initBlackPawns();
		initTowers();
		initKnights();
		initBishops();
		intiKings();
		initQueens();
	}
		
	private void initField() {
		for(int x = 0; x < 8; ++x) {
			for(int y = 0; y < 8; ++y) {
				field[x][y] = new Field(new Point(x,y));
			}
		}
	}
	

	
	private void initWhitePawns() {
		int x = 0;
		int y = 1;
		for ( Pawn pawn : whitePawns) {
			pawn = new Pawn(x,y,'w');
			field[x][y] = new Field(new Point(x,y), pawn);
			x++;
		}
	}
	
	private void initBlackPawns() {
		int x = 0;
		int y = 6;
		for (Pawn pawn : blackPawns) {
			pawn = new Pawn(x,y,'b');
			field[x][y] = new Field(new Point(x,y), pawn);
			x++;
		}
	}
		
	private void initTowers(){
		whiteTowers[0] = new Tower(0,0,'w');
		field[0][0] = new Field(new Point(0,0), whiteTowers[0]);
		whiteTowers[1] = new Tower(7,0,'w');
		field[7][0] = new Field(new Point(7,0), whiteTowers[1]);
		blackTowers[0] = new Tower(0,7,'b');
		field[0][7] = new Field(new Point(0,7), blackTowers[0]);
		blackTowers[1] = new Tower(7,7,'b');
		field[7][7] = new Field(new Point(7,7), blackTowers[1]);
	}
		
	private void initKnights(){
		whiteKnights[0] = new Knight(1,0,'w');
		field[1][0] = new Field(new Point(1,0), whiteKnights[0]);
		whiteKnights[1] = new Knight(6,0,'w');
		field[6][0] = new Field(new Point(6,0), whiteKnights[1]);
		blackKnights[0] = new Knight(1,7,'b');
		field[1][7] = new Field(new Point(1,7), blackKnights[0]);
		blackKnights[1] = new Knight(6,7,'b');
		field[6][7] = new Field(new Point(6,7), blackKnights[1]);
	}
		
	private void initBishops(){
		whiteBishops[0] = new Bishop(2,0,'w');	
		field[2][0] = new Field(new Point(2,0),whiteBishops[0]);
		whiteBishops[1] = new Bishop(5,0,'w');	
		field[5][0] = new Field(new Point(5,0),whiteBishops[1]);
		blackBishops[0] = new Bishop(2,7,'b');	
		field[2][7] = new Field(new Point(2,7),blackBishops[0]);
		blackBishops[1] = new Bishop(5,7,'b');	
		field[5][7] = new Field(new Point(5,7),blackBishops[1]);
	}
		
	private void initQueens(){
		whiteQueen = new Queen(3,0,'w');
		field[3][0] = new Field(new Point(3,0), whiteQueen);
		blackQueen = new Queen(3,7,'b');
		field[3][7] = new Field(new Point(3,7), blackQueen);
	}
		
	private void intiKings(){
		whiteKing = new King(4,0,'w');
		field[4][0] = new Field(new Point(4,0), whiteKing);
		blackKing = new King(4,7,'b');
		field[4][7] = new Field(new Point(4,7), blackKing);
	}
	
	public Field[][] getField() {
		return this.field;
	}
	
	public boolean moveCheck (Point from, Point to) {
		Chesspiece figure = field[from.getX()][from.getY()].getChessPiece();
		if(figure == null) 
			return false;
		return checkPawn(figure,to);
		
	}
	
	private boolean checkPawn(Piece figure, Point to) {
		if(figure.toChar() == 'P') {
			return pawnColorRoutine(figure,to);
		}
		return checkValid(figure,to);
	}
	
	private boolean pawnColorRoutine(Piece p, Point to) {
		if(p.getcolor() == 'w')
			return whitepawnRoutine(p, to);
		return blackpawnRoutine(p,to);
	}
	
	private boolean blackpawnRoutine(Piece p, Point to) {
		if((to.getX() + 1 == p.getPosition().getX()) &&
				(to.getY() == p.getPosition().getY() - 1)) {
			return pawnDiagonal(p, to);
		}
		if((to.getX() - 1 == p.getPosition().getX()) &&
				(to.getY() == p.getPosition().getY() - 1)) {
			return pawnDiagonal(p, to);
		}
		if(to.getX() == p.getPosition().getX())
			return blackPawnMoveFront(p,to);
		
		return false;
		
	}
	
	private boolean blackPawnMoveFront(Piece p, Point to) {
		if((to.getY() >= p.getPosition().getY() - 2) && (to.getY() < p.getPosition().getY())) {
			return blackPawnOneOrTwo(p,to);
		}
		return false;
	}
	
	private boolean blackPawnOneOrTwo(Piece p,Point to) {
		if(p.getPosition().getY() - 2 == to.getY())
			return blackPawnTwo(p,to);
		return blackPawnOne(p,to);
	}
	
	private boolean blackPawnOne(Piece p, Point to) {
		return field[to.getX()][to.getY()].getChessPiece() == null;
	}

	private boolean blackPawnTwo(Piece p,Point to) {
		if(p.getMoved() == true)
			return false;
		else 
			return blackPawnPathTwo(p, to);
	}
	
	private boolean blackPawnPathTwo(Piece p, Point to) {
		Field stepOne = field[to.getX()][to.getY() + 1];
		Field stepTwo = field[to.getX()][to.getY()];
		return (stepTwo.getChessPiece() == null) && (stepOne.getChessPiece() == null);
	}
	
	private boolean whitepawnRoutine(Piece p, Point to) {
		if((to.getX() + 1 == p.getPosition().getX() )&&
				(to.getY() ==  p.getPosition().getY() + 1)) {
			return pawnDiagonal(p,to);
		}
		if((to.getX() -1 == p.getPosition().getX() )&&
				(to.getY() ==  p.getPosition().getY() + 1)) {
			return pawnDiagonal(p,to);
		}
		if(to.getX() == p.getPosition().getX())
			return pawnMoveFront(p,to);
		
		return false;
	}
	
	private boolean pawnDiagonal(Piece p, Point to) {
		if(field[to.getX()][to.getY()].getChessPiece() != null) {
			return pawnColorCheck(p.getcolor(),field[to.getX()][to.getY()].getChessPiece().getcolor());
		}
		return false;
	}
	
	private boolean pawnMoveFront(Piece p, Point to) {
		if((to.getY() <= p.getPosition().getY() + 2) && (to.getY() > p.getPosition().getY()) ){
			return pawnOneOrTwoSteps(p,to);
		}
		return false;
	}
	
	private boolean pawnOneOrTwoSteps(Piece p, Point to) {
		if(p.getPosition().getY() + 1 == to.getY()) {
			return pawnOneStep(p,to);
		} else {
			return pawnTwoStep(p,to);
		}
	}
	
	private boolean pawnOneStep(Piece p, Point to) {
		return field[to.getX()][to.getY()].getChessPiece() == null;
	}
	
	private boolean pawnTwoStep(Piece p, Point to) {
		if(p.getMoved() == true)
			return false;
		return pawnClearPath(p,to);
			
	}
	
	private boolean pawnClearPath(Piece p, Point to) {
		Field stepOne = field[p.getPosition().getX()][p.getPosition().getY() + 1];
		Field stepTwo = field[p.getPosition().getX()][p.getPosition().getY() + 2];
		return (stepOne.getChessPiece() == null) && (stepTwo.getChessPiece() == null);
	}
	
	private boolean pawnColorCheck(char piece, char target) {
		return piece != target;
	}
	private boolean checkValid(Piece figure, Point to) {
		Point[] path = figure.validMove(to.getX(), to.getY());
		if(path == null)
			return false;
		return checkPath(figure, path);
		
	}
	
	private boolean checkPath(Piece figure, Point[] path) {
		int index = -1;
		for(int i = 0; i < path.length -2; ++i) {
			index = i;
			if(field[path[i].getX()][path[i].getY()].getChessPiece() != null) {
				return false;
			}
		}
		return checkGoal(path[index + 1], figure);
		
	}
	
	private boolean checkGoal(Point goal, Piece figure) {
	Field goalfield = field[goal.getX()][goal.getY()];
		if(goalfield.getChessPiece() ==  null)
			return true;
		return beatable(goalfield.getChessPiece(),figure);
	}
	
	public boolean beatable(Piece target, Piece figure) {
		return target.getcolor() != figure.getcolor();
	}

	
	public boolean whiteWon() {
		if(blackKing.alive)
			return false;
		return true;
	}
	
	public boolean blackWon() {
		if(whiteKing.alive)
			return false;
		return true;
	}
	
	public void  moveAfterCheck(Point from, Point to) {
		Field targetField = field[to.getX()][to.getY()];
		Field fromField = field[from.getX()][from.getY()];
		Chesspiece cp = fromField.getChessPiece();
		if(targetField.getChessPiece() != null)
			targetField.getChessPiece().kill();
		cp.setPosition(to);
		cp.setmovedTrue();
		targetField.setChessPiece(cp);
		fromField.setChessPiece(null);
	}
}
