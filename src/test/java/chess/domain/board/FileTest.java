package chess.domain.board;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *    class description
 *
 *    @author AnHyungJu
 */
class FileTest {
	@DisplayName("of로 생성할 때 유효하지 않은 file이 들어오면 예외처리")
	@ParameterizedTest
	@ValueSource(ints = {0, 9})
	void of(int value) {
		assertThatThrownBy(() -> File.of(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("유효하지");
	}
}