/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxzhotdog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

/**
 *
 * @author jiach
 */
public class GamePane extends Pane {
    private WXZ wxz;
    private Label scoreLabel;
    private List<Hotdog> hotdogList;
    private int score;
    
    public GamePane(){
        wxz=new WXZ();
        hotdogList=new ArrayList<Hotdog>();
        
        score=0;
        scoreLabel=new Label("Score: " + score);
        
        this.getChildren().addAll(wxz.getWXZImageView(),scoreLabel);
        
        AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                 onUpdate();
            }
        };
        timer.start();
        
    }
    
    private void addHotdog(){
        Random rand = new Random();
        int x = rand.nextInt(400) + 50;
        Hotdog hotdog=new Hotdog(x,0);
        hotdogList.add(hotdog);
        this.getChildren().add(hotdog.getHotdogImageView());
    }
    
    private void onUpdate(){
        for(Hotdog hotdog : hotdogList){
            if(isColliding(hotdog)){
                this.getChildren().remove(hotdog.getHotdogImageView());
                score++;
                scoreLabel.setText("Score: " + score);
                hotdog.setDead(true);
            }
            else{
                if(hotdog.getHotdogImageView().getY()>600){
                    this.getChildren().remove(hotdog.getHotdogImageView());
                    hotdog.setDead(true);
                }
                else{
                    hotdog.getHotdogImageView().setY(hotdog.getHotdogImageView().getY()+5);
                }
            }
        }
        hotdogList.removeIf(Hotdog::isDead);
        
        if(Math.random() < 0.01){
            addHotdog();
        }
    }
    
    public boolean isColliding(Hotdog hotdog){
        if(hotdog.getHotdogImageView().getX()>=wxz.getWXZImageView().getX() 
        && hotdog.getHotdogImageView().getX()<=wxz.getWXZImageView().getX()+100 
        && hotdog.getHotdogImageView().getY()<=470 
        && hotdog.getHotdogImageView().getY()>=460)
            return true;
        return false;
    }
    
    public WXZ getWXZ(){
        return wxz;
    }
    public Hotdog getHotdog(int index){
        return (Hotdog)hotdogList.get(index);
    }
    public int getTotalHotdog(){
        return hotdogList.size();
    }
}
