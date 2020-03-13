import java.util.Collections;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush
 */
public class Player extends BorderPane
{
    Media media;
    MediaPlayer player;
    MediaView view;
    Pane mpane;
    MediaBar bar;
    
            
    public Player(String file){
        media = new Media(file);
        player = new MediaPlayer(media);
        view = new MediaView(player);
        mpane = new Pane();
        
        mpane.getChildren().add(view);
        
        DoubleProperty width = view.fitWidthProperty();
        DoubleProperty height = view.fitHeightProperty();
        width.bind(Bindings.selectDouble(view.sceneProperty(),"width"));
        height.bind(Bindings.selectDouble(view.sceneProperty(),"height"));
        setCenter(mpane);
       
       
       mpane.setBackground(
            new Background(
                    Collections.singletonList(new BackgroundFill(
                            Color.BLACK, 
                            new CornerRadii(0), 
                            new Insets(0))),
                    Collections.singletonList(new BackgroundImage(
                            new Image("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/LOGO4.png", 100, 100, true, true),
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER,
                            BackgroundSize.DEFAULT))));
        
        
        
        bar = new MediaBar(player);
        setBottom(bar);
        
        bar.setStyle("-fx-background-color: black");
       
        player.play();
    
}


}













































