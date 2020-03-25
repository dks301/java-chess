package chess.domain.piece;

import java.util.List;

import chess.domain.board.Position;

public class Knight extends Piece {
	public Knight(String color, String name) {
		super(color, name);
	}

	// TODO : target 위치가 상대팀 말인지, 우리팀 말인지 확인안함
	// TODO : 그리고 Knight이 아닌 경우, 가다가 막힐 수 있음
	public boolean isMovableToTarget(String source, String target) {
		List<Direction> knightDirections = Direction.knightDirection();

		return knightDirections.stream()
			.anyMatch(direction -> isTarget(direction, source, target));
	}

	private boolean isTarget(Direction direction, String source, String target) {
		int locationOfX = Position.of(source).getFileColumnNumber();
		int locationOfY = Position.of(source).getRankNumber();

		int afterMoveOfX = locationOfX + direction.getX();
		int afterMoveOfY = locationOfY + direction.getY();

		if (isOutOfBoundary(afterMoveOfX) || isOutOfBoundary(afterMoveOfY)) {
			return false;
		}

		int targetOfX = Position.of(target).getFileColumnNumber();
		int targetOfY = Position.of(target).getRankNumber();

		if (afterMoveOfX == targetOfX && afterMoveOfY == targetOfY) {
			return true;
		}
		return false;
	}

	private boolean isOutOfBoundary(int location) {
		if (location < 1 || location > 8) {
			return true;
		}
		return false;
	}
}
