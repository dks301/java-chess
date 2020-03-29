package chess.domain.piece;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.domain.board.Position;
import chess.domain.piece.state.Captured;
import chess.domain.piece.state.Initial;

/**
 *    class description
 *
 *    @author AnHyungJu
 */
class KingTest {
	@DisplayName("말이 죽어있을 때 movingTrace를 호출하면 예외처리")
	@Test
	void movingTraceTest() {
		King king = new King(new Captured(), "k");

		Position source = Position.of("a1");
		Position target = Position.of("a1");

		assertThatThrownBy(() -> king.movingTrace(source, target))
			.isInstanceOf(UnsupportedOperationException.class)
			.hasMessageContaining("죽은 말은");
	}

	@DisplayName("왕이 source에서 target으로 갈 수 없는 경우 예외처리")
	@Test
	void movingTraceTest2() {
		King king = new King(new Initial(), "k");

		Position source = Position.of("a1");
		Position target = Position.of("c1");

		assertThatThrownBy(() -> king.movingTrace(source, target))
			.isInstanceOf(UnsupportedOperationException.class)
			.hasMessageContaining("갈 수 없는");
	}
}