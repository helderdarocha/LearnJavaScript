import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Desenha2 extends Applet implements MouseMotionListener, MouseListener {

   private Dimension dim;
   private int x, y, oldx, oldy;
   private boolean clearAll = false;
   private Color cor = Color.black;

   public void init() {
      dim = getSize();
      this.addMouseMotionListener(this);
      this.addMouseListener(this);
   }

   public void mouseDragged(MouseEvent e) {
      if ((x == 0) && (y == 0)) {
        x = e.getX();
        y = e.getY();
      }         
      oldx = x;
      oldy = y;
      x = e.getX();
      y = e.getY();
      repaint();
   }
   
   public void clear() {
      clearAll = true;
      repaint();
   }
   
   public void mudaCor(int r, int g, int b) {
      cor = new Color(r, g, b);   
   }
   
   public void mouseReleased(MouseEvent e) {
      x = y = oldx = oldy = 0;
   }
   
   public void mouseMoved(MouseEvent e) {
 
   }
   
   public void paint(Graphics g) {
      if (!clearAll) {
         g.setColor(cor);
         g.drawLine(oldx, oldy, x, y);
      } else {
         g.setColor(Color.white);
         g.fillRect(0,0,dim.width, dim.height);  
         clearAll = false;  
      }
   }
   
   public void update(Graphics g) {
      paint(g);
   }
   
   public void mouseClicked(MouseEvent e) {}
   public void mousePressed(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}


}
