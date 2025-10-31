package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControlGridPane extends VBox {

    private final String miningImageURL = "bitcoin.png";
    private ControlPane controlPane;

    public ControlGridPane(ControlPane controlPane){
        ImageView imageView = new ImageView(new Image(miningImageURL));
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefHeight(200);
        borderPane.setPrefWidth(150);
        borderPane.setCenter(imageView);
        this.getChildren().add(borderPane);
        this.getChildren().add(controlPane);
    }
}
