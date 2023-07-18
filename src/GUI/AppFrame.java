package GUI;
import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame(){
        JPanel btnPanel = new JPanel(new GridLayout(2, 1, 10, 5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("Select file to compress");
//        compressButton.setBounds(20,10,100,30);
        compressButton.addActionListener(this::actionPerformed);


        decompressButton = new JButton("Select file to decompress");
//        decompressButton.setBounds(40,10,100,30);
        decompressButton.addActionListener(this::actionPerformed);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));

        btnPanel.add(compressButton);
        btnPanel.add(decompressButton);
        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);

        this.add(panel);
        this.setSize(500,400);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==compressButton){
           System.out.println(e.getSource());
           JFileChooser filechooser = new JFileChooser();
           int response= filechooser.showSaveDialog(null);

           if(response==JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);

               try{
                   compressor.method(file);
               }
               catch(Exception ee){
                   JOptionPane.showMessageDialog(null,ee.toString());
               }
           }
       }

       if(e.getSource()==decompressButton){
           JFileChooser filechooser = new JFileChooser();
           int response= filechooser.showSaveDialog(null);

           if(response==JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);

               try{
                   decompressor.method(file);
               }
               catch(Exception ee){
                   JOptionPane.showMessageDialog(null,ee.toString());
               }
           }
       }
    }
}
