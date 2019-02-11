/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxzhotdog;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author jiach
 */
public class StartPane extends BorderPane{
    private Button startBtn;
    private Button exitBtn;
    private VBox vbox;
    private Image image;
    private ImageView imageView;
    
    public StartPane(){
        startBtn=new Button("Start");
        startBtn.setMinSize(100, 20);
        
        exitBtn=new Button("Exit");
        exitBtn.setMinSize(100, 20);
        
        vbox=new VBox();
        vbox.getChildren().addAll(startBtn,exitBtn);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        
        image=new Image("timg.jpg");
        imageView=new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        this.setBackground(new Background(new BackgroundImage(image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize)));
        
        this.setCenter(vbox);
        
        exitBtn.setOnAction((e) -> {
           Platform.exit();
        });
    }
    
    public Button getStartBtn(){ 
        return startBtn;
    }
    
    public Button getExitBtn(){ 
        return exitBtn;
    }
}
