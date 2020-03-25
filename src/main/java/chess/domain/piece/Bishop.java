package chess.domain.piece;

import java.util.List;

import chess.domain.board.Position;

public class Bishop extends Piece {
	public Bishop(String color, String name) {
		super(color, name);
	}

	public boolean isMovableToTarget(String source, String target) {
		List<Direction> bishopDirections = Direction.diagonalDirection();

		return bishopDirections.stream()
			.anyMatch(direction -> isTarget(direction, source, target));

	}

	private boolean isTarget(Direction direction, String source, String target) {

		int locationOfX = Position.of(source).getFileColumnNumber();
		int locationOfY = Position.of(source).getRankNumber();

		int afterMoveOfX = locationOfX + direction.getX();
		int afterMoveOfY = locationOfY + direction.getY();

		while (true) {
			if (isOutOfBoundary(afterMoveOfX) || isOutOfBoundary(afterMoveOfY)) {
				return false;
			}

			int targetOfX = Position.of(target).getFileColumnNumber();
			int targetOfY = Position.of(target).getRankNumber();

			if (afterMoveOfX == targetOfX && afterMoveOfY == targetOfY) {
				return true;
			}

			afterMoveOfX += direction.getX();
			afterMoveOfY += direction.getY();
		}
	}

	private boolean isOutOfBoundary(int location) {
		if (location < 1 || location > 8) {
			return true;
		}
		return false;
	}
}
