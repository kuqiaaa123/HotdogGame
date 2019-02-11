/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxzhotdog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jiach
 */
public class WXZHotdog extends Application {
    public static final int GAMEPANE_WIDTH = 500;
    public static final int GAMEPANE_HEIGTH = 600;
    
    public static final int STARTPANE_WIDTH = 300;
    public static final int STARTPANE_HEIGTH = 260;
    
    @Override
    public void start(Stage primaryStage) {
        StartPane startPane=new StartPane();
        GamePane gamePane=new GamePane();
        Scene startScene,gameScene;
        
        startScene = new Scene(startPane, STARTPANE_WIDTH, STARTPANE_HEIGTH);
        gameScene =new Scene(gamePane, GAMEPANE_WIDTH, GAMEPANE_HEIGTH);
        
        startPane.getStartBtn().setOnAction(e->{
            primaryStage.setScene(gameScene);
        });
        
        gameScene.setOnKeyPressed((e) -> {
            if (e.getCode() == KeyCode.LEFT) {
                if(gamePane.getWXZ().getWXZImageView().getX()>=10)
                    gamePane.getWXZ().getWXZImageView().setX(gamePane.getWXZ().getWXZImageView().getX()-10);
            }
            else if(e.getCode()==KeyCode.RIGHT){
                if(gamePane.getWXZ().getWXZImageView().getX()<=390)
                    gamePane.getWXZ().getWXZImageView().setX(gamePane.getWXZ().getWXZImageView().getX()+10);
            }
        });
        
        primaryStage.setTitle("王校长热狗大战");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
