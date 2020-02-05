package UI.GUI;

import UI.Messages;
import core.Player;
import javafx.scene.control.Alert;

public class GUIMessageWriter {
            public static void notifyPass() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pass Rule Information");
                alert.setHeaderText(null);
                alert.setContentText(Messages.pass);
                alert.showAndWait();
    }

    public static void notifyEndGame(Player player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("End Game Information");
        alert.setHeaderText(null);
        alert.setContentText(String.format(Messages.endGame, player.getName(), player.getColor()));
        alert.showAndWait();
    }

    public static void notifyInvalidMove() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Move Information");
        alert.setHeaderText(null);
        alert.setContentText(Messages.invalidMove);
        alert.showAndWait();
    }
}