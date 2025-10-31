package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MineSweeperPane extends GridPane {

    private ArrayList<MineSweeperSquare> allCells;

    public MineSweeperPane(){
        allCells = new ArrayList<MineSweeperSquare>();
        this.setHgap(8);
        this.setVgap(8);
        this.setPadding(new Insets(8));
        this.setPrefWidth(500);
        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border( new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        for(int x = 0; x < 5; x++){
            for(int y = 0; y < 5; y++){
                MineSweeperSquare gridBlock = new MineSweeperSquare(x, y);
                allCells.add(gridBlock);
                this.add(gridBlock, x, y);
            }
        }
    }

    public ArrayList<MineSweeperSquare> getAllCells() {
        return allCells;
    }
}
