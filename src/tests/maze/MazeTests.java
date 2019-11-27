package tests.maze;

import game.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MazeTests {

    @Test
    void constructorNullArgsNoExceptionsTest() {

        assertThrows(RuntimeException.class, () -> {
            Maze m = new Maze(null, null, 0, 0);
        });

    }

}
