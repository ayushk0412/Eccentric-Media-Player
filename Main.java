/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 *@author Ayush
 */
 
public class Main extends Application {
    
    Player player;
    FileChooser fileChooser;
    
    @Override
    public void start(final Stage primaryStage) throws FileNotFoundException 
    {
        
        MenuItem open = new MenuItem("Open");
        MenuItem ss = new MenuItem("Screen Shot");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();
        
        MenuItem help = new MenuItem("Help");
        MenuItem updates = new MenuItem("Check for Updates");
        Menu help2 = new Menu("Help");
        
        MenuItem full = new MenuItem("Full Screen");
        MenuItem minimize = new MenuItem("Minimize");
        MenuItem close = new MenuItem("Close");
        Menu MpControls = new Menu("Utility Controls");
        
        MenuItem  play = new MenuItem("Play         "); 
        MenuItem  stop = new MenuItem("Stop         "); 
        MenuItem  slow = new MenuItem("Slow         "); 
        MenuItem  normal = new MenuItem("Normal     "); 
        MenuItem  fast = new MenuItem("Fast         ");
        MenuItem mute = new MenuItem("Mute          ");
        Menu playback = new Menu("Playback Controls");
        
        
        /*==SHOTCUT KEYS==*/
        /* ==============================================================================================================================================================================================================*/
       
        full.setAccelerator(new KeyCodeCombination(KeyCode.F11));
        minimize.setAccelerator(new KeyCodeCombination(KeyCode.F12));
        close.setAccelerator(new KeyCodeCombination(KeyCode.F4,KeyCombination.ALT_DOWN));
        open.setAccelerator(new KeyCodeCombination(KeyCode.O,KeyCombination.ALT_DOWN));
        ss.setAccelerator(new KeyCodeCombination(KeyCode.P,KeyCombination.ALT_DOWN));
        play.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
        stop.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        slow.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        normal.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        fast.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
        mute.setAccelerator(new KeyCodeCombination(KeyCode.M,KeyCombination.CONTROL_DOWN));
        help.setAccelerator(new KeyCodeCombination(KeyCode.H,KeyCombination.ALT_DOWN));
        updates.setAccelerator(new KeyCodeCombination(KeyCode.U,KeyCombination.ALT_DOWN));
        
        /* ==============================================================================================================================================================================================================*/
        
        
        menu.setStyle("-fx-background-color: gold; ");
        file.setStyle("-fx-background-color: gold; ");
        open.setStyle("-fx-text-fill: gold;");
        ss.setStyle("-fx-text-fill: gold;");
        help2.setStyle("-fx-background-color: gold; ");
        playback.setStyle("-fx-background-color: gold; ");
        help.setStyle("-fx-text-fill: gold;");
        MpControls.setStyle("-fx-background-color: gold; ");
        full.setStyle("-fx-text-fill: gold;");
        minimize.setStyle("-fx-text-fill: gold");
        close.setStyle("-fx-text-fill: gold");
        play.setStyle("-fx-text-fill: gold");
        stop.setStyle("-fx-text-fill: gold");
        slow.setStyle("-fx-text-fill: gold");
        mute.setStyle("-fx-text-fill: gold");
        normal.setStyle("-fx-text-fill: gold");
        fast.setStyle("-fx-text-fill: gold");
        updates.setStyle("-fx-text-fill: gold");
        
        file.getItems().add(ss);
        file.getItems().add(open);
        menu.getMenus().add(file);
        
       
        
        playback.getItems().add(play);
        playback.getItems().add(stop);
        playback.getItems().add(mute);
        playback.getItems().add(slow);
        playback.getItems().add(normal);
        playback.getItems().add(fast);
        menu.getMenus().add(playback);
        
        
        
        
        MpControls.getItems().add(minimize);
        MpControls.getItems().add(full);
        MpControls.getItems().add(close);
        menu.getMenus().add(MpControls);
        
        help2.getItems().add(updates);
        help2.getItems().add(help);
        menu.getMenus().add(help2);
        
        fileChooser = new FileChooser();
        
        open.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
            player.player.pause();
            File file = fileChooser.showOpenDialog(primaryStage);
            if(file != null){
                try {
                    player = new Player(file.toURI().toURL().toExternalForm());
                    player.setTop(menu);
                    Scene scene = new Scene (player, 860, 580, Color.BLACK);
                    
                    scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
    
                      //TO GET THE FULL CODE, SEND ME A MAIL AT ayushk0412@gmail.com, WITH THE SUBJECT "CODE REQUIRED"

    
}
