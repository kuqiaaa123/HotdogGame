/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wxzhotdog;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author jiach
 */
public class WXZ {
    private Image wxzImage;
    private ImageView wxzImageView;
    
    public WXZ(){
        wxzImage=new Image("wxz.png");
        
        wxzImageView=new ImageView(wxzImage);
        
        wxzImageView.setFitHeight(100);
        wxzImageView.setFitWidth(100);
        wxzImageView.setRotate(270);
        wxzImageView.setY(530);
    }
    
    public ImageView getWXZImageView(){
        return wxzImageView;
    }
}
