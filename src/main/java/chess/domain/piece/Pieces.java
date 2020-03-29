package chess.domain.piece;

import java.util.List;

import chess.domain.board.Position;

public class Pieces {
	private final WhitePieces whitePieces;
	private final BlackPieces blackPieces;
	private boolean turnFlag;

	public Pieces(final WhitePieces whitePieces, final BlackPieces blackPieces) {
		this.whitePieces = whitePieces;
		this.blackPieces = blackPieces;
		this.turnFlag = true;
	}

	public List<Position> movingTrace(Position source, Position target) {
		List<Position> trace;

		if (turnFlag) {
			trace = whitePieces.findTrace(source, target);
			return trace;
		}
		trace = blackPieces.findTrace(source, target);
		return trace;
	}

	public void move(Position source, Position target) {
		if (turnFlag) {
			whitePieces.moveFromTo(source, target);
			blackPieces.kill(target);
			turnFlag = false;
		} else {
			blackPieces.moveFromTo(source, target);
			whitePieces.kill(target);
			turnFlag = true;
		}
	}

	public boolean canMove(Position source, Position target) {
		return (whitePieces.hasPiece(source) && blackPieces.hasPiece(target))
			|| (whitePieces.hasPiece(target) && blackPieces.hasPiece(source))
			|| (whitePieces.hasPiece(source) && !blackPieces.hasPiece(target) && !whitePieces.hasPiece(target))
			|| (!whitePieces.hasPiece(target) && !blackPieces.hasPiece(target) && blackPieces.hasPiece(source));
	}
}
