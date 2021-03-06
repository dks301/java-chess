package chess.domain.piece;

import java.util.List;
import java.util.Map;

import chess.domain.board.Position;
import chess.domain.piece.state.Moved;

public class Pieces {
	private Map<Position, Piece> pieces;

	public Pieces(Map<Position, Piece> pieces) {
		this.pieces = pieces;
	}

	public List<Position> findTrace(Position source, Position target) {
		if (!pieces.containsKey(source)) {
			throw new UnsupportedOperationException("움직일 수 있는 말이 아닙니다.");
		}

		Piece piece = pieces.get(source);
		return piece.movingTrace(source, target);
	}

	public boolean hasPiece(Position source) {
		return pieces.containsKey(source);
	}

	public boolean isKingDie() {
		return pieces.keySet().stream()
			.noneMatch(position -> pieces.get(position).isKing());
	}

	public void moveFromTo(Position source, Position target) {
		Piece piece = pieces.remove(source);
		piece.state = new Moved();
		pieces.put(target, piece);
	}

	public void kill(Position target) {
		pieces.remove(target);
	}

	public double score() {
		return Score.calculateTotalScore(pieces);
	}

	public Piece getPiece(Position position) {
		return pieces.get(position);
	}
}
