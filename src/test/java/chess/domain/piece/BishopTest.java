package chess.domain.piece;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BishopTest {
	@DisplayName("Bishop 말이 source 위치에서 target 위치로 갈 수 있는지 확인")
	@ParameterizedTest
	@CsvSource({"a1, b2, true", "a1, h8, true", "d1, e2, true", "d1, a4, true", "a1, b1, false", "e5, h2, true",
		"e5, e4, false"})
	void isMovableToTargetTest(String source, String target, boolean expected) {
		Bishop bishop = new Bishop("white", "bishop");
		assertThat(bishop.isMovableToTarget(source, target)).isEqualTo(expected);
	}
}
