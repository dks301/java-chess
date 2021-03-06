package chess.domain.piece;

import java.util.List;

import chess.domain.board.Position;
import chess.domain.piece.state.State;

/**
 *    체스 기물을 의미하는 클래스입니다.
 *
 *    @author AnHyungJu, LeeHoBin
 */
public abstract class Piece {
	protected State state;
	protected String symbol;

	public Piece(State state, String symbol) {
		this.state = state;
		this.symbol = symbol;
	}

	public abstract List<Position> movingTrace(Position source, Position target);

	protected abstract List<Position> findRoute(Position source, Position target);

	public boolean isPawn() {
		return false;
	}

	public boolean isKing() {
		return false;
	}

	public double score() {
		return Score.DEFAULT.getScore();
	}

	public String getSymbol() {
		return symbol;
	}
}
