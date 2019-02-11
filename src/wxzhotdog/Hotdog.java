/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxzhotdog;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author jiach
 */
public class Hotdog{
    private Image hotdogImage;
    private ImageView hotdogImageView;
    private boolean dead;
    
    public Hotdog(){
        hotdogImage=new Image("hotdog.png");
        hotdogImageView=new ImageView(hotdogImage);
        hotdogImageView.setFitHeight(100);
        hotdogImageView.setFitWidth(60);
        dead=false;
    }
    public Hotdog(int x, int y){
        hotdogImage=new Image("hotdog.png");
        hotdogImageView=new ImageView(hotdogImage);
        hotdogImageView.setFitHeight(100);
        hotdogImageView.setFitWidth(60);
        hotdogImageView.setX(x);
        hotdogImageView.setY(y);
        dead=false;
        
    }
    
    public ImageView getHotdogImageView(){
        return hotdogImageView;
    }
    
    public boolean isDead(){
        return dead;
    }
    public void setDead(boolean bool){
        dead=bool;
    }
}
