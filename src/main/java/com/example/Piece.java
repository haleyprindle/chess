package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
//Piece type: Swapper - can move one space in any direction. Can attack from any direction.
//When it "attacks" another piece, it swaps squares with that piece
//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    //precondition: the board is 8 x 8.
    //postcondition:returns a list of squares that the the piece can capturn into legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controlledSquares = new ArrayList<>();

    	if(start.getCol()<7){
        Square right =board[start.getRow()][start.getCol()+1];
        Square rightUp =board[start.getRow()-1][start.getCol()+1];
        Square rightDown =board[start.getRow()+1][start.getCol()+1];
    
                controlledSquares.add(right);

                if (start.getRow()>0){
                controlledSquares.add(rightUp);
                }
    
                if (start.getRow()<7){
                controlledSquares.add(rightDown);
                }
        }

        if(start.getCol()>0){
        Square left =board[start.getRow()][start.getCol()-1];
        Square leftUp =board[start.getRow()-1][start.getCol()-1];
        Square leftDown =board[start.getRow()+1][start.getCol()-1];

                controlledSquares.add(left);

                if (start.getRow()>0){
                controlledSquares.add(leftUp);
                }
            
                if (start.getRow()<7){
                controlledSquares.add(leftDown);
                }
            
        }

        if(start.getRow()>0){
            Square up =board[start.getRow()-1][start.getCol()];
            
                controlledSquares.add(up);
        }

            
        if(start.getRow()<7){
            Square down =board[start.getRow()+1][start.getCol()];

            
            
                controlledSquares.add(down);
        
        }
    return controlledSquares;
      
}
        

     
    
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    //precondition: the board is 8 x 8.
    //postcondition: returns a list of all legal moves for my piece. 
    //moves in any direction one space
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> ret = new ArrayList<>();
    	if(start.getCol()<7){
        Square right =b.getSquareArray()[start.getRow()][start.getCol()+1];
       
        
            if(right.isOccupied()==false || right.getOccupyingPiece().getColor()!=color )
            {
                ret.add(right);
            }
            if (start.getRow()>0){
                Square rightUp =b.getSquareArray()[start.getRow()-1][start.getCol()+1];
            if(rightUp.isOccupied()==false || rightUp.getOccupyingPiece().getColor()!=color ){

                
                ret.add(rightUp);
                
            }
         }
            if (start.getRow()<7){
                Square rightDown =b.getSquareArray()[start.getRow()+1][start.getCol()+1];
            if(rightDown.isOccupied()==false || rightDown.getOccupyingPiece().getColor()!=color ){

                ret.add(rightDown);
               
                   }  
            }

        }
        

        if(start.getCol()>0){
        Square left =b.getSquareArray()[start.getRow()][start.getCol()-1];
       
      

        
            if( left.isOccupied()==false || left.getOccupyingPiece().getColor()!=color)
            {
                ret.add(left);
            }
            if (start.getRow()>0){
                 Square leftUp =b.getSquareArray()[start.getRow()-1][start.getCol()-1];
            if(leftUp.isOccupied()==false || leftUp.getOccupyingPiece().getColor()!=color){
                
                ret.add(leftUp);
                }
            }
             
            if (start.getRow()<7){
                  Square leftDown =b.getSquareArray()[start.getRow()+1][start.getCol()-1];
            if(leftDown.isOccupied()==false || leftDown.getOccupyingPiece().getColor()!=color){
                
                ret.add(leftDown);
                }
            }
            
        }
            
        

        if(start.getRow()>0){
            Square up =b.getSquareArray()[start.getRow()-1][start.getCol()];

            if(up.isOccupied()==false || up.getOccupyingPiece().getColor()!=color){
            
                ret.add(up);

            }
        }
        
        if(start.getRow()<7){
            Square down =b.getSquareArray()[start.getRow()+1][start.getCol()];

            if(down.isOccupied()==false || down.getOccupyingPiece().getColor()!=color){
            
                ret.add(down);

            }
        
        }

    return ret;
    }
    //need to access board array: for loop
    // put all available legal moves
    //
}