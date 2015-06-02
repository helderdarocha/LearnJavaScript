import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Formulario extends Applet implements ActionListener {

   private TextField nome, endereco, cep, fone, cidade;
   private Choice uf, transporte;
   private Button enviar;
   private String[] estados = {"Acre", "Alagoas", "Amazonas", "Amapá", "Bahia", "Ceará", 
                               "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", 
                               "Minas Gerais", "Mato Grosso do Sul", "Mato Grosso", "Pará" , 
                               "Paraíba", "Pernambuco", "Piauí", "Paraná", "Rio Grande do Norte", 
                               "Rio de Janeiro", "Rondônia", "Roraima", "Rio Grande do Sul", 
                               "Sergipe", "São Paulo", "Santa Catarina", "Tocantins"}, 
                    ufs = {"AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG","MS",
                           "MT","PA","PB","PE","PI","PR","RN","RJ","RO","RR","RS","SE",
                           "SP","SC","TO"};       
   private String[] transportes = {"Escolha um veículo","Porsche 911","Fusca 1300","BMW 360i",
                                   "Trabant 1987","Jegue e carroça"};
                               
   public void init() {        
      new Formulario();        
   }                           
                               
   public Formulario() {       
      
      setBackground(new Color(222,222,255));
                               
      enviar = new Button("Enviar");
      enviar.addActionListener(this);
                               
      nome = new TextField(32);
      endereco = new TextField(32);
      cep = new TextField(10); 
      fone = new TextField(10);
      cidade = new TextField(10);
                               
      uf = new Choice();   
      for (int i = 0; i < ufs.length; i++) {
         uf.add(ufs[i]);
      }    
      transporte = new Choice();
      for (int i = 0; i < transportes.length; i++) {
         transporte.add(transportes[i]);
      } 
      
      Panel nomeP = new Panel(new FlowLayout(FlowLayout.LEFT));
      nomeP.add(new Label("Nome"));
      nomeP.add(nome);
      
      Panel endP = new Panel(new FlowLayout(FlowLayout.LEFT));
      endP.add(new Label("Endereço"));
      endP.add(endereco);
      
      Panel cepP = new Panel(new FlowLayout(FlowLayout.LEFT));
      cepP.add(new Label("CEP"));
      cepP.add(cep);
      cepP.add(new Label("Telefone"));
      cepP.add(fone);
      
      Panel cidP = new Panel(new FlowLayout(FlowLayout.LEFT));
      cidP.add(new Label("Cidade"));
      cidP.add(cidade);
      cidP.add(new Label("Estado"));
      cidP.add(uf);
      
      Panel trspP = new Panel(new FlowLayout(FlowLayout.LEFT));
      trspP.add(new Label("Meio de transporte"));
      trspP.add(transporte);
      
      Panel envP = new Panel(new FlowLayout());
      envP.add(enviar);
      
      setLayout(new GridLayout(6,1));
      add(nomeP);
      add(endP);
      add(cepP);
      add(cidP);
      add(trspP);
      add(envP);
                               
   }       
   
   public void actionPerformed(ActionEvent e) {
   
      // implemente aqui o código relativo ao evento Action
   
   }                    
                               
                          
}       
        
