package chess.domain.piece;

import java.util.Arrays;
import java.util.List;

public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1),

	NNE(1, 2),
	NNW(-1, 2),
	SSE(1, -2),
	SSW(-1, -2),
	EEN(2, 1),
	EES(2, -1),
	WWN(-2, 1),
	WWS(-2, -1);

	private int x;
	private int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static List linearDirection() {
		return Arrays.asList(NORTH, EAST, SOUTH, WEST);
	}

	public static List diagonalDirection() {
		return Arrays.asList(NORTHEAST, SOUTHEAST, NORTHWEST, SOUTHWEST);
	}

	public static List everyDirection() {
		return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
	}

	public static List knightDirection() {
		return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
	}

	public static List whitePawnDirection() {
		return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
	}

	public static List blackPawnDirection() {
		return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
	}
}
