package core.Rules;

import core.Entities.Board;
import core.Entities.Color;
import core.Entities.Supervisor;
import core.Rules.ValidPositionRule;
import org.junit.Test;
import java.awt.Point;

import static org.junit.Assert.*;

public class validPositionRuleTest {
    private Supervisor supervisor = new Supervisor(11);
    private ValidPositionRule validPositionRule = new ValidPositionRule();

    private void setTestBoard(Board board) {
        board.setCell(new Point(0, 0), Color.black);
        board.setCell(new Point(2, 1), Color.black);
        board.setCell(new Point(0, 1), Color.white);
        board.setCell(new Point(2, 2), Color.white);
    }

    @Test
    public void testValidPositionRule() {
        setTestBoard(supervisor.getBoard());
        supervisor.setCurrentPoint(new Point(1, 1));
        assertTrue(validPositionRule.isValid(supervisor));
    }

    @Test
    public void testValidPositionRuleAgain() {
        setTestBoard(supervisor.getBoard());
        supervisor.setCurrentPoint(new Point(1, 0));
        assertFalse(validPositionRule.isValid(supervisor));
    }

}