package chess.domain.board;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
	private final File file;
	private final Rank rank;

	private Position(final File file, final Rank rank) {
		this.file = file;
		this.rank = rank;
	}

	public static Position of(String position) {
		validate(position);
		return PositionCache.BOARD.get(position);
	}

	public int getRankNumber() {
		return rank.getRank();
	}

	public int getFileColumnNumber() {
		return file.getColumnNumber();
	}

	private static void validate(String input) {
		if (Objects.isNull(PositionCache.BOARD.get(input))) {
			throw new IllegalArgumentException("Position 값을 잘못입력하셨습니다!");
		}
	}

	private static class PositionCache {
		private static final Map<String, Position> BOARD = new HashMap<>();

		static {
			makeBoard();
		}

		private PositionCache() {
		}

		private static void makeBoard() {
			for (File file : File.values()) {
				makeBoardBy(file);
			}
		}

		private static void makeBoardBy(File file) {
			for (Rank rank : Rank.values()) {
				BOARD.put(createKey(file, rank), new Position(file, rank));
			}
		}

		private static String createKey(File file, Rank rank) {
			return file.getFile() + rank.getRank();
		}
	}

}
