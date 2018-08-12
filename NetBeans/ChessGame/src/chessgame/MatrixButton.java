/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import javax.swing.JButton;

/**
 *
 * @author Modified from https://stackoverflow.com/questions/41047424/how-to-get-the-indexes-of-the-clicked-jbutton
 */
public class MatrixButton extends JButton {
    //private static final long serialVersionUID = -8557137756382038055L;
    private final Location btnLocation;

    public MatrixButton(int col, int row) {
    super();
    btnLocation = new Location(col, row);
    }
    
    public Location getBtnLocation() {
    return btnLocation;
    }
}
