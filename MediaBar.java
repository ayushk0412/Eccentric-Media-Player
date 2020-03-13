
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayush
 * 
 * 
 * 
 */



public class MediaBar extends HBox{
    
    Slider time = new Slider();
    Slider vol = new Slider();
     
    
    
    Button playButton = new Button();
    Button stop = new Button();
    Button fast = new Button();
    Button slow = new Button();
    Button normal = new Button("NORMAL");
    
    Button mute = new Button();  
    Button repeat = new Button();
    

    

Label volume = new Label(" Volume: ");
Label space1 = new Label("    ");
Label space2 = new Label("    ");
Label space3 = new Label("    ");
Label space4 = new Label("    ");
Label space5 = new Label("    ");
Label space6 = new Label("    ");
Label space7 = new Label("    ");
Label TIME = new Label("TIME: ");
MediaPlayer player;
    public MediaBar(MediaPlayer play)
    {
        player = play;
        
        setAlignment(Pos.CENTER);
        setPadding(new Insets(20,25,20,25));
        
        vol.setPrefWidth(60);
        vol.setMinWidth(30);
        vol.setValue(100);
        
     
        
        HBox.setHgrow(time, Priority.ALWAYS);
        fast.setPrefWidth(40);
        slow.setPrefWidth(40);
        playButton.setPrefWidth(40);
        stop.setPrefWidth(40);
        mute.setPrefWidth(40);
        repeat.setPrefWidth(40);
        playButton.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
        stop.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
        fast.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
        slow.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
        normal.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
        volume.setStyle("-fx-text-fill: gold;");
        TIME.setStyle("-fx-text-fill: gold;");
        repeat.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
        mute.setStyle("-fx-background-color: gold; -fx-text-fill: black;");
       
     playButton.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/pause.png"));
     stop.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/stop.png"));
     fast.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/fast5.png"));
     slow.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/slow5.png"));
     mute.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/unmute.png"));  
     repeat.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/repeat5.png"));
     
     
             
        getChildren().add(playButton);
        getChildren().add(space1);
        getChildren().add(stop);
        getChildren().add(space2);
        getChildren().add(repeat);
        getChildren().add(space7);
        getChildren().add(time);
        getChildren().add(volume);
        getChildren().add(vol);
        getChildren().add(space6);
        getChildren().add(mute);
        getChildren().add(space4);
        getChildren().add(slow);
        getChildren().add(space3);
        getChildren().add(normal);
        getChildren().add(space5);
        getChildren().add(fast);
        
            mute.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            if(player.getVolume()==0){
            player.setVolume(100);
            mute.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/unmute.png"));
             }
            else
            {
            player.setVolume(0);
             mute.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/mute.png"));
            }
            
            
    
       }
    });
        
         slow.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            
            if(status==Status.PLAYING)
                player.setRate(0.5);
            
    
       }
    });
        normal.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            
            if(status==Status.PLAYING)
                player.setRate(1);
            
    
       }
    });
       fast.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            
           
                player.setRate(2);
            
    
       }
    });
       
       
       repeat.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            
            
                player.setCycleCount(player.INDEFINITE);
                
                
                
    
       }
    });
       
       
       
        stop.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            
            if(status==Status.PLAYING)
            {
                if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                player.seek(player.getStartTime());
                player.stop();
                }
                else {
                player.stop();
                
                
                }
            }
        if(status == Status.PAUSED || status == Status.HALTED || status == Status.STOPPED){
        player.stop();
        
        }
       }
    });
        
        
        playButton.setOnAction(new EventHandler<ActionEvent>(){
       
        public void handle(ActionEvent e){
            Status status = player.getStatus();
            
            if(status==Status.PLAYING)
            {
                if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                player.seek(player.getStartTime());
                player.play();
                }
                else {
                player.pause();
                playButton.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/play.png"));
                }
            }
        if(status == Status.PAUSED || status == Status.HALTED || status == Status.STOPPED){
        player.play();
        playButton.setGraphic(new ImageView("file:///C:/Users/Acer/Documents/Eclipse-Workspace/Media%20player/images/pause.png"));
        }
       }
    });

   
        
    player.currentTimeProperty().addListener(new InvalidationListener(){
    public void invalidated(Observable ov)
    {
       updateValues();
    }
    });
    
    time.valueProperty().addListener(new InvalidationListener(){
        
            public void invalidated(Observable ov) {
                if(time.isPressed()){
                player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
                
                }
            } 
    
    });
    
    
    
    
    
    
    vol.valueProperty().addListener(new InvalidationListener(){
        
            public void invalidated(Observable ov) {
                if(vol.isPressed()){
                player.setVolume(vol.getValue()/100);
                }
            }
      });
    
    
    
    }
    protected void updateValues(){
    Platform.runLater(new Runnable(){
    public void run(){
    time.setValue(player.getCurrentTime().toMillis()/player.getTotalDuration().toMillis()*100);
    }
    });
    }
    
}
