
//import java.awt.Color;
//import java.awt.Graphics;
//import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LogiRavi
 */
//public class GameField {
//    
//}


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class GameField extends JPanel {
    
char[][] gameData = new char[8][8];

char [][] level1 = {{'w','w','w','w','w','w','w','w'},
                    {'w','k','t','t','t','t','t','w'},
                    {'w','t','t','t','t','t','t','w'},
                    {'w','t','t','t','d','t','t','w'},
                    {'w','t','t','t','t','t','t','w'},
                    {'w','t','c','t','t','t','t','w'},
                    {'w','t','t','t','t','t','t','w'},
                    {'w','w','w','w','w','w','w','w'}
                    };

char [][] level2 = {{'w','w','w','w','w','w','w','w'},
                    {'w','k','t','t','t','t','t','w'},
                    {'w','t','t','t','c','t','t','w'},
                    {'w','d','t','t','t','t','t','w'},
                    {'w','t','t','t','t','t','t','w'},
                    {'w','t','c','t','d','t','t','w'},
                    {'w','t','t','t','t','t','t','w'},
                    {'w','w','w','w','w','w','w','w'}
                    };

char [][] level3 = {{'w','w','w','w','w','w','w','w'},
                    {'w','k','t','t','t','t','t','w'},
                    {'w','t','c','t','t','t','t','w'},
                    {'w','d','t','t','t','t','d','w'},
                    {'w','t','t','t','t','c','t','w'},
                    {'w','t','c','t','d','t','t','w'},
                    {'w','t','t','t','t','t','t','w'},
                    {'w','w','w','w','w','w','w','w'}
                    };

int wk_y = 1;
int wk_x = 1;
int crateCount = 0;
int level  = 1;

public GameField()
{
    gameData = level1;
    setSize(600,600);
    // showMessageDialog(null, "crate count is"+crateCount);
    // showMessageDialog(null, "Level 1 win");
    // if (crateCount == 1){
    //     // System.out.println("Level 1 completed");
    //     showMessageDialog(null, "Level 1 win");
    // }

}
public void win () {
    if (crateCount==1 && level ==1){ 
        showMessageDialog(null, "Congratulations, You won Level 1");
        gameData = level2;
        level =2;
        crateCount=0;
        wk_y = 1;
        wk_x = 1;
    }
    if (crateCount==2 && level ==2){ 
        showMessageDialog(null, "Congratulations, You won Level 2");
        gameData = level3;
        level =3;
        crateCount=0;
        wk_y = 1;
        wk_x = 1;
    }
    if (crateCount==3 && level ==3){ 
        showMessageDialog(null, "Congratulations, You won the Game!");
        crateCount=0;
    }
}
public void moveRight()
{
    if (gameData[wk_y][wk_x+1] == 't')
    {
        // can move
        gameData[wk_y][wk_x] = 't';
        gameData[wk_y][wk_x+1] = 'k';
        wk_x=wk_x+1;
        wk_y=wk_y;
        // gameData[wk_y][wk_x+1] = 'd';
    }
    else
    {
       
        if (gameData[wk_y][wk_x+1] == 'c') {
            if (gameData[wk_y][wk_x+2] == 't')
            {
                // move the crate one location right
                gameData[wk_y][wk_x+2] = 'c';
                gameData[wk_y][wk_x+1] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x+1;
                wk_y=wk_y;
            }
            if (gameData[wk_y][wk_x+2] == 'd')
            {
                // move the crate on to the diamond
                gameData[wk_y][wk_x+2] = 't';
                gameData[wk_y][wk_x+1] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x+1;
                wk_y=wk_y;
                crateCount= crateCount + 1;
                // showMessageDialog(null, "Level 1 win");
            }
        }
    }
    
}
public void moveLeft()
{
    if (gameData[wk_y][wk_x-1] == 't')
    {
        // can move
        gameData[wk_y][wk_x] = 't';
        gameData[wk_y][wk_x-1] = 'k';
        wk_x=wk_x-1;
        wk_y=wk_y;
    }
    else
    {
        if (gameData[wk_y][wk_x-1] == 'c') {
            if (gameData[wk_y][wk_x-2] == 't')
            {
                // move the crate one location right
                gameData[wk_y][wk_x-2] = 'c';
                gameData[wk_y][wk_x-1] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x-1;
                wk_y=wk_y;
            }
            if (gameData[wk_y][wk_x-2] == 'd')
            {
                // move the crate on to the diamond
                gameData[wk_y][wk_x-2] = 't';
                gameData[wk_y][wk_x-1] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x-1;
                wk_y=wk_y;
                crateCount= crateCount + 1;
                // showMessageDialog(null, "Level 1 win");
            }
        }
            
    }
    
}
public void moveUp()
{
    if (gameData[wk_y+1][wk_x] == 't')
    {
        // can move
        gameData[wk_y][wk_x] = 't';
        gameData[wk_y+1][wk_x] = 'k';
        wk_x=wk_x;
        wk_y=wk_y+1;
    }
    else
    {
        if (gameData[wk_y+1][wk_x] == 'c') {
            if (gameData[wk_y+2][wk_x] == 't')
            {
                // move the crate one location right
                gameData[wk_y+2][wk_x] = 'c';
                gameData[wk_y+1][wk_x] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x;
                wk_y=wk_y+1;
            }
            if (gameData[wk_y+2][wk_x] == 'd')
            {
                // move the crate on to the diamond
                gameData[wk_y+2][wk_x] = 't';
                gameData[wk_y+1][wk_x] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x;
                wk_y=wk_y+1;
                crateCount= crateCount + 1;
                // showMessageDialog(null, "Level 1 win");
            }
        }
    }
    
}
public void moveDown()
{
    if (gameData[wk_y-1][wk_x] == 't')
    {
        // can move
        gameData[wk_y][wk_x] = 't';
        gameData[wk_y-1][wk_x] = 'k';
        wk_x=wk_x;
        wk_y=wk_y-1;
    }
    else
    {
        if (gameData[wk_y-1][wk_x] == 'c') {
            if (gameData[wk_y-2][wk_x] == 't')
            {
                // move the crate one location right
                gameData[wk_y-2][wk_x] = 'c';
                gameData[wk_y-1][wk_x] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x;
                wk_y=wk_y-1;
            }
            if (gameData[wk_y-2][wk_x] == 'd')
            {
                // move the crate on to the diamond
                gameData[wk_y-2][wk_x] = 't';
                gameData[wk_y-1][wk_x] = 'k';
                gameData[wk_y][wk_x] = 't';
                wk_x=wk_x;
                wk_y=wk_y-1;
                crateCount= crateCount + 1;
                // showMessageDialog(null, "Level 1 win");
            }
    }
    }
    
}

@Override
public void paint(Graphics g)
{   
//     BufferedImage image=null;
//    try{
//    image = ImageIO.read(new File("C:\\Users\\LOGI\\Music\\man.png"));
//    } catch(IOException e) {
//  e.printStackTrace();
// }
    BufferedImage imageMan = null;
    BufferedImage imageBlock = null;
    BufferedImage imageCrate = null;
    BufferedImage imageCross = null;


try {
    imageMan = ImageIO.read(new File("man.png"));
    imageBlock = ImageIO.read(new File("block.png"));
    imageCrate = ImageIO.read(new File("crate.png"));
    imageCross = ImageIO.read(new File("cross.png"));


} catch (IOException e) {
    e.printStackTrace();
}

    for (int x=0; x< 8 ; x++)
    {
        for (int y=0 ; y <8 ; y++)
        {
            if (gameData[y][x] == 'k')
            {
                g.setColor(Color.BLUE);
            //    g.fillOval(x*30+20,y*30+20,30,30);
                g.drawImage(imageMan, x*30+20,y*30+20,30,30, null);
            }
            if (gameData[y][x] == 't')
            {
                g.setColor(Color.BLUE);
                g.fillRect(x*30+20,y*30+20,5,5);
            }
            if (gameData[y][x] == 'c')
            {
                g.setColor(Color.ORANGE);
                // g.fillRect(x*30+20,y*30+20,30,30);
                g.drawImage(imageCrate, x*30+20,y*30+20,30,30, null);
            }
            if (gameData[y][x] == 'w')
            {
                g.setColor(Color.GREEN);
                // g.fillRect(x*30+20,y*30+20,30,30);
                g.drawImage(imageBlock, x*30+20,y*30+20,30,40, null);
            }
            if (gameData[y][x] == 'd')
            {
                g.setColor(Color.YELLOW);
                g.fillRect(x*30+20,y*30+20,30,30);
                g.drawImage(imageCross, x*30+20,y*30+20,30,35, null);

            }
        }
    }
}
}