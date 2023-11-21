package main;

import lexer.LexInter;

import java.awt.Color;
import java.io.*;
import lexer.*;
import parser.*;
import asm.*;
import javax.swing.JFileChooser;

public class Main_G extends javax.swing.JFrame {

    public Main_G() {
        initComponents();

        Color co = new Color(240, 250, 246);
        getContentPane().setBackground(co);
        setBounds(70, 60, 870, 400);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        samplecodeText = new javax.swing.JTextArea();
        File = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");
        jMenuItem2.setText("jMenuItem2");
        jMenuItem3.setText("jMenuItem3");
        jMenu1.setText("jMenu1");
        jMenu2.setText("jMenu2");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.lightGray);

        jButton1.setText("CONVERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TextField.setColumns(20);
        TextField.setRows(5);
        TextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TextFieldPropertyChange(evt);
            }
        });
        Color te = new Color(253, 254, 251);

        TextField.setBackground(te);
        jScrollPane1.setViewportView(TextField);

        samplecodeText.setColumns(20);
        samplecodeText.setRows(5);
        samplecodeText.setBackground(te);
        jScrollPane2.setViewportView(samplecodeText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                // .addComponent(File)
                                .addGap(77, 77, 77)
                                .addComponent(jButton1)
                                .addGap(5, 5, 5)
                                .addGap(58, 58, 58))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10,
                                        Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332,
                                                Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1))
                                // .addComponent(File))
                                .addGap(15, 15, 15)));
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Action();
        } catch (IOException e) {
        }
    }

    private void FileActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser jFileChooser1 = new JFileChooser();
        int i = jFileChooser1.showOpenDialog(this);
    }

    private void TextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {
    }

    public void Action() throws IOException {
        String inputCode = samplecodeText.getText();
        try {
            FileWriter f = new FileWriter("test.txt");
            BufferedWriter b = new BufferedWriter(f);
            b.write(inputCode);
            b.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        LexInter li = new LexInter();
        Assembly assemb = new Assembly(li);
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex, assemb);

        System.out.println("<Intermediate code>");
        parse.program();
        System.out.println("<Assembly code>");
        String Display = assemb.program();

        TextField.setText(Display);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_G.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_G.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_G.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_G.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_G().setVisible(true);
            }
        });
    }

    private javax.swing.JButton File;
    private javax.swing.JTextArea TextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea samplecodeText;
}
