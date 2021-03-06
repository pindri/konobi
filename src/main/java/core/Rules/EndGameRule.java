package core.Rules;

import core.Entities.*;

import java.util.ArrayList;
import java.util.HashSet;


public class EndGameRule implements Rule {

    private final HashSet<Cell> visitedCells;
    private final ArrayList<Cell> endingCells;

    public EndGameRule(){
        visitedCells = new HashSet<>();
        endingCells = new ArrayList<>();
    }

    @Override
    public boolean isValid(StatusSupervisor supervisor) {
        return isValid(supervisor.getBoard(), supervisor.getLastPlayer().getColour());
    }

    public boolean isValid(Board board, Colour colour) {
        board.getStartingCellsForColour(colour).forEach(x -> searchForEndingEdge(x, board, colour));
        return !endingCells.isEmpty();
    }

    public void searchForEndingEdge(Cell current, Board board, Colour colour) {
        if (board.isOnEndingEdgeForColour(current.getCoordinates(), colour)) {
            endingCells.add(current);
            return;
        }
        visitedCells.add(current);
        for (Cell neighbour : Neighbourhood.getNeighboursByColour(board, current.getCoordinates(), colour).toArray(Cell[]::new)) {
            if (!visitedCells.contains(neighbour)) {
                searchForEndingEdge(neighbour, board, colour);
            }
        }
    }

}
