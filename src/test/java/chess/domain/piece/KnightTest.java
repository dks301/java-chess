package chess.domain.piece;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import chess.domain.board.File;
import chess.domain.board.Rank;

public class KnightTest {
	@DisplayName("Knight 말이 source 위치에서 target 위치로 갈 수 있는지 확인")
	@ParameterizedTest
	@CsvSource({"e5, f7, true", "e5, g6, true", "e5, g4, true", "e5, f3, true", "e5, d3, true", "e5, c4, true",
		"e5, c6, true", "e5, d7, true", "e5, a1, false"})
	void isMovableToTargetTest(String source, String target, boolean expected) {
		Knight knight = new Knight("white", "knight");
		assertThat(knight.isMovableToTarget(source, target)).isEqualTo(expected);
	}

	@Test
	void name() {

		for (Rank rank : Rank.values()) {
			for (File file : File.values()) {
				System.out.print(file.getFile() + rank.getRank() + " ");
			}
			System.out.println();
		}
	}
}
