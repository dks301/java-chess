package chess.domain.piece;

import chess.domain.board.DirectionType;
import chess.domain.board.PlayerType;
import chess.domain.board.Point;

public class King extends Piece {

    public King(PlayerType playerType) {
        super(playerType);
    }

    @Override
    public boolean isMovable(Point prev, Point next) {
        DirectionType directionType;
        try {
            directionType = DirectionType.valueOf(prev, next);
        } catch (IllegalArgumentException e) {
            return false;
        }

        int distanceSum = Math.abs(next.xDistance(prev)) + Math.abs(next.yDistance(prev));
        if (isMovedDiagonalDirection(directionType, distanceSum)) {
            return true;
        }
        return isMovedLinearDirection(directionType, distanceSum);
    }

    private boolean isMovedLinearDirection(DirectionType directionType, int distanceSum) {
        return DirectionType.isLinearDirection(directionType) && distanceSum == 1;
    }

    private boolean isMovedDiagonalDirection(DirectionType directionType, int distanceSum) {
        return DirectionType.isDiagonalDirection(directionType) && distanceSum == 2;
    }

    @Override
    public String pieceToString() {
        return isWhite() ? "k" : "K";
    }
}