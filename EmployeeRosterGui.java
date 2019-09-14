import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class EmployeeRosterGui implements ActionListener, ItemListener, KeyListener{
   //JLabel
   JLabel fname = new JLabel("First Name:");
   JLabel lname = new JLabel("Last Name:");
   JLabel idnum = new JLabel("ID Number:");
   JLabel gender = new JLabel("Gender");
   JLabel department = new JLabel("Department");
   JLabel work = new JLabel("Type of Work:");
   JLabel birth = new JLabel("Birthdate (mm/dd/yy):");
   JLabel num = new JLabel("Number of Items:");
   JLabel rpi = new JLabel("Rate per Item:");
   JLabel hw = new JLabel("Hours Worked:");
   JLabel rph = new JLabel("Rate per Hour:");
   JLabel bs = new JLabel("Base Salary:");
   JLabel poi = new JLabel("Price of Item:");
   JLabel cr = new JLabel("Commission Rate:");
   JLabel noi = new JLabel("Number of Items");
   
   //JTextField
   JTextField first = new JTextField(10);
   JTextField last = new JTextField(10);
   JTextField id = new JTextField(10);
   JTextField gen = new JTextField(10);
   JTextField dep = new JTextField(10);
   JTextField works = new JTextField(10);
   JTextField birthdate = new JTextField(10);
   JTextField numm = new JTextField();
   JTextField rpii = new JTextField(); 
   JTextField hww = new JTextField();
   JTextField rphh = new JTextField();
   JTextField bss = new JTextField();
   JTextField poii = new JTextField();
   JTextField crr = new JTextField();
   JTextField noii = new JTextField();
   
   //JButton
   JButton btnSearch = new JButton("Search Employee");
   JButton btnAdd = new JButton("Add Employee");
   JButton btnDisplay = new JButton("Display Workers");
   JButton btnRemove = new JButton("Remove");
   JButton btnExit = new JButton("Exit");
   
   //String for button
   String[] g = {"Male","Female"};
   String[] working = {"Commission Worker","Piece Worker","Hourly Worker"};
   String[] mon = {"January","February","March","April","May","June","July","August","September","October","November","December"};
   String[] day = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21",
                   "22","23","24","25","26","27","28","29","30","31"};
   String[] yr = {"0000","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002",
                  "2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
                  "2016","2017","2018","2019"};
   
   //JComboBox
   JComboBox mf = new JComboBox(g);
   JComboBox wo = new JComboBox(working);
   JComboBox mo = new JComboBox(mon);
   JComboBox d = new JComboBox(day);
   JComboBox y = new JComboBox(yr);
   
   //JFrame
   EmployeeRosterGui (){
      JFrame frame;
      JFrame frame2;
      
      frame = new JFrame("Employee Registration Form");
      frame2 = new JFrame("DISPLAY");
      
      //JPanel
      JPanel p1 = new JPanel(null);
      JPanel p2 = new JPanel(null);
      JPanel p3 = new JPanel(null);
      JPanel p4 = new JPanel(null);
      JPanel p5 = new JPanel(null);
      
      frame.setLayout(new BorderLayout());
      p1.setLayout(new GridLayout(8,2));
      p2.setLayout(new GridLayout(0,3));
      p3.setLayout(new GridLayout(5,0));
      p4.setLayout(new GridLayout(8,2));
      p5.setLayout(new FlowLayout());
      
      
      frame.add(p1);
      frame.add(p3, BorderLayout.EAST);
      frame.add(p4, BorderLayout.SOUTH);
      frame2.add(p5);
      
      TitledBorder b1 = BorderFactory.createTitledBorder("Registration Form");
      b1.setTitleJustification(TitledBorder.CENTER);
      p1.setBorder(b1);
      
      TitledBorder b2 = BorderFactory.createTitledBorder("Main Menu");
      b1.setTitleJustification(TitledBorder.CENTER);
      p3.setBorder(b2);
      
      TitledBorder b3 = BorderFactory.createTitledBorder("Work Requirements");
      b1.setTitleJustification(TitledBorder.CENTER);
      p4.setBorder(b3);
      
      
      p1.add(fname);
      p1.add(first);
      p1.add(lname);
      p1.add(last);
      p1.add(idnum);
      p1.add(id);
      p1.add(gender);
      p1.add(mf);
      p1.add(department);
      p1.add(dep);
      p1.add(work);
      p1.add(wo);
      p1.add(birth);
      p1.add(p2);
      p2.add(mo);
      p2.add(d);
      p2.add(y);
      p3.add(btnSearch);
      p3.add(btnAdd);
      p3.add(btnRemove);
      p3.add(btnDisplay);
      p3.add(btnExit);
      p4.add(num);
      p4.add(numm);
      p4.add(hw);
      p4.add(hww);
      p4.add(rph);
      p4.add(rphh);
      p4.add(bs);
      p4.add(bss);
      p4.add(poi);
      p4.add(poii);
      p4.add(cr);
      p4.add(crr);
      p4.add(noi);
      p4.add(noii);
     
      
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setSize(900,500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Listener
      wo.addItemListener(this);
      numm.addKeyListener(this);
      rpii.addKeyListener(this); 
      hww.addKeyListener(this); 
      rphh.addKeyListener(this); 
      bss.addKeyListener(this);
      poii.addKeyListener(this); 
      crr.addKeyListener(this); 
      noii.addKeyListener(this); 
      
      @Override
      public void itemStateChanged(ItemEvent e){
      Object item = e.getSource();
            
      if (item == wo) {
         if (wo.getSelectedItem().equals("Piece worker")){
            numm.setEnabled(true);
            rpii.setEnabled(true);
            hww.setEnabled(false);
            rphh.setEnabled(false);
            bss.setEnabled(false);
            poii.setEnabled(false);
            crr.setEnabled(false);
            noii.setEnabled(false);
         }
         else if (wo.getSelectedItem().equals("Hourly worker")){
            numm.setEnabled(false);
            rpii.setEnabled(false);
            hww.setEnabled(true);
            rphh.setEnabled(true);
            bss.setEnabled(false);
            poii.setEnabled(false);
            crr.setEnabled(false);
            noii.setEnabled(false);
         }  
         else if (wo.getSelectedItem().equals("Commission worker")){
            numm.setEnabled(false);
            rpii.setEnabled(false);
            hww.setEnabled(false);
            rphh.setEnabled(false);
            bss.setEnabled(true);
            poii.setEnabled(true);
            crr.setEnabled(true);
            noii.setEnabled(true);     
         }
      }
   }
   @Override
   public void actionPerformed(ActionEvent action) {
      Object item = action.getSource();
   }
   
   public void keyReleased(KeyEvent e){}
   public void keyPressed(KeyEvent e){}
      
      btnExit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
         System.exit(0);
         }
      });
   }
   public void actionPerformed(ActionEvent e){}
   public static void main(String[] args){
      try{
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         new EmployeeRosterGui();
      }
      catch(Exception e){}
   }
}