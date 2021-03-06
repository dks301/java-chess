package chess.domain.piece;

import java.util.LinkedList;
import java.util.List;

import chess.domain.board.Position;
import chess.domain.piece.state.State;

/**
 *    나이트를 의미하는 클래스입니다.
 *
 *    @author AnHyungJu, LeeHoBin
 */
public class Knight extends Piece {
	public Knight(State state, String symbol) {
		super(state, symbol);
	}

	@Override
	public List<Position> movingTrace(Position source, Position target) {
		if (state.isCaptured()) {
			throw new UnsupportedOperationException("죽은 말은 움직일 수 없습니다.");
		}

		return findRoute(source, target);
	}

	protected List<Position> findRoute(Position source, Position target) {
		List<Position> route = new LinkedList<>();
		List<Position> possiblePosition = source.nextPosition(Direction.KNIGHT_DIRECTION);

		possiblePosition.stream()
			.filter(position -> position.equals(target))
			.findFirst()
			.orElseThrow(() -> new UnsupportedOperationException("갈 수 없는 target입니다."));
		route.add(source);
		route.add(target);
		return route;
	}

	@Override
	public double score() {
		return Score.KNIGHT.getScore();
	}
}
