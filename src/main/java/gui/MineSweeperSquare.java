package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane{
	
	private boolean isDrawn;
	private Color baseColor;
	private int xPosition;
	private int yPosition;
	private final String oURL = "o.png";
	private final String oneURL = "one.png";
	private final String mineURL = "mine.png";
	private final String flagURL = "flag.png";

	public MineSweeperSquare(int x, int y){
		setxPosition(x);
		setyPosition(y);

		this.setPrefSize(100, 100);
		this.setMinSize(100, 100);

		setBaseColor(Color.MOCCASIN);
		initializeCellColor();

		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				onClickHandler();
			}
		});
	}

	private void onClickHandler(){
		if(!GameLogic.getInstance().isGameEnd()){
			if(GameLogic.getInstance().getBoardState()[getxPosition()][getyPosition()] != SquareState.REVEALED && !GameLogic.getInstance().isSecureMode()){
				if(GameLogic.getInstance().getBoardMark()[getxPosition()][getyPosition()] == SquareMark.ONE){
					draw(new Image(oneURL), Color.ORANGE);
				}
				else if(GameLogic.getInstance().getBoardMark()[getxPosition()][getyPosition()] == SquareMark.NOTHING){
					draw(new Image(oURL), Color.YELLOW);
				}
				else if(GameLogic.getInstance().getBoardMark()[getxPosition()][getyPosition()] == SquareMark.MINE){
					draw(new Image(mineURL), Color.RED);
				}
				GameLogic.getInstance().updateState(getxPosition(), getyPosition(), SquareState.REVEALED);
			}
			else if(GameLogic.getInstance().isSecureMode() && !isDrawn()){
				draw(new Image(flagURL), Color.GREEN);
				GameLogic.getInstance().updateState(getxPosition(), getyPosition(), SquareState.SECURED);
			}
		}
	}

	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		setDrawn(true);
	}

	public void initializeCellColor(){
		BackgroundFill bgFill = new BackgroundFill(getBaseColor(), CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		this.setBackground(new Background(bgFillA));
		setDrawn(false);
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean drawn) {
		isDrawn = drawn;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}
