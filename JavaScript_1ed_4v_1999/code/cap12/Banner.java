// Applet

import java.awt.*;
import java.applet.Applet;

public class Banner extends Applet implements Runnable {
  
   // Métodos públicos accessíveis via JavaScript

   public void corDeFundo(int r, int g, int b) {
      bgColor = new Color(r, g, b);
   }
   
   public void corDoTexto(int r, int g, int b) {
      fgColor = new Color(r, g, b);
   }
   
   public void mensagem(String msg) {
      texto = msg;
      largura = getFontMetrics(fonte).stringWidth(texto);
   }
   
   public void esquerda() {
      direcao--;
      stop();
      start();
   }
   
   public void direita() {
      direcao++;
      stop();
      start();
   }
   
   public void para() {
      direcao = 0;
      stop();
   }
   
   // Variáveis do objeto (inaccessíveis por JavaScript)

   private String texto = "Escolha uma Mensagem";
   private Color bgColor = Color.blue;
   private Color fgColor = Color.yellow;
   private int direcao = 0;
   private Image bufimg = null;
   private Thread runner = null;
   private Dimension dim;
   private int x = 0;
   private Font fonte = new Font("SansSerif", Font.BOLD, 14);
   private int largura = getFontMetrics(fonte).stringWidth(texto);

   // Métodos não utilizados por JavaScript
   
   public void init() {
      dim = this.getSize();
      direcao = -1;
      
      String htmlMsg = getParameter("MSG");
      if (htmlMsg != null) 
         mensagem(htmlMsg);
   }

   public void update(Graphics g) {
      paint(g);
   }
   
   public void paint(Graphics g) {
      setBackground(bgColor);
      bufimg = this.createImage(dim.width, dim.height);
      Graphics bg = bufimg.getGraphics();
      bg.setColor(fgColor);
      bg.setFont(fonte);
      bg.drawString(texto, x, 14);
      g.drawImage(bufimg, 0, 0, this);
   }
   
   public void start() {
      if (runner == null) {
         runner = new Thread(this);
         runner.start();
      }
   }
   
   public void stop() {
      if (runner != null) {
         runner = null;
      }
   }
   
   public void run() {
      while (Thread.currentThread() == runner) {
         x = x + direcao;
         if (x < -largura || x > dim.width) {
            if (direcao > 0) x = -largura;
            else x = dim.width;
         }
         repaint();
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {}
      }
   }

}


