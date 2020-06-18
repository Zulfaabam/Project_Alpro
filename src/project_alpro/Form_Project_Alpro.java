/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_alpro;

import java.util.Arrays;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Zulfa Fatah Akbar A
 */
public class Form_Project_Alpro extends javax.swing.JFrame {

    /**
     * Creates new form Form_Project_Alpro
     */
    public Form_Project_Alpro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minField = new javax.swing.JTextField();
        maxField = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        inputLabel = new javax.swing.JLabel();
        sortLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        sortField = new javax.swing.JTextArea();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penyortir Angka");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        minField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nilai Minimum", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        minField.setPreferredSize(new java.awt.Dimension(150, 60));
        getContentPane().add(minField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        maxField.setEditable(false);
        maxField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maxField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nilai Maksimum", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        maxField.setPreferredSize(new java.awt.Dimension(150, 60));
        getContentPane().add(maxField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        cariButton.setText("Cari");
        cariButton.setPreferredSize(new java.awt.Dimension(66, 32));
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cariButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        getContentPane().add(hapusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        inputLabel.setBackground(new java.awt.Color(0, 0, 0));
        inputLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inputLabel.setForeground(new java.awt.Color(255, 255, 255));
        inputLabel.setText("Input Angka :");
        getContentPane().add(inputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        sortLabel.setBackground(new java.awt.Color(0, 0, 0));
        sortLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sortLabel.setForeground(new java.awt.Color(255, 255, 255));
        sortLabel.setText("Urutan :");
        getContentPane().add(sortLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        inputField.setColumns(20);
        inputField.setLineWrap(true);
        inputField.setRows(5);
        inputField.setPreferredSize(new java.awt.Dimension(350, 100));
        jScrollPane1.setViewportView(inputField);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 350, 80));

        sortField.setEditable(false);
        sortField.setColumns(20);
        sortField.setLineWrap(true);
        sortField.setRows(5);
        sortField.setPreferredSize(new java.awt.Dimension(350, 100));
        jScrollPane2.setViewportView(sortField);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 350, 80));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zulfa Fatah Akbar A\\Pictures\\Ingredients\\Valorant3-resized.jpg")); // NOI18N
        background.setText("jLabel1");
        background.setToolTipText("");
        background.setAlignmentY(0.0F);
        background.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    void filterhuruf(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Hanya boleh input angka");
        }
    }
    
    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        inputField.setText("");
        minField.setText("");
        maxField.setText("");
        sortField.setText("");
    }//GEN-LAST:event_hapusButtonActionPerformed

    public class DivideConquer {
        public int[] sort(int[] arrayAngka){
            int panjang = arrayAngka.length;
            if (panjang < 2){
                return arrayAngka;
            }
            
            int[] bagKiri = Arrays.copyOfRange(arrayAngka, 0, panjang/2);
            int[] bagKanan = Arrays.copyOfRange(arrayAngka, panjang/2, panjang);
            
            int[] sortedKiri = sort(bagKiri);
            int[] sortedKanan = sort(bagKanan);
            
            return merge(sortedKiri, sortedKanan, panjang);
        }

        private int[] merge(int[] bagKiri, int[] bagKanan, int panjang) {
            int[] hasil = new int[panjang];
            int ki = 0;
            int ka = 0;
            
            for (int i = 0; i < panjang; i++){
                if (ki < bagKiri.length && (ka >= bagKanan.length || bagKiri[ki] < bagKanan[ka])){
                hasil[i] = bagKiri[ki];
                ki++;
                } else{
                    hasil[i] = bagKanan[ka];
                    ka++;
                }
            }
            
            return hasil;
        }
    
    }
    
    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        String inputAngka = inputField.getText();
        int[] arrIA = Arrays.stream(inputAngka.split(",")).mapToInt(Integer::parseInt).toArray();  
        arrIA = new DivideConquer().sort(arrIA);
        
        String[] strArr = new String[arrIA.length];
        for (int i = 0;i < arrIA.length;i++){
            strArr[i] = String.valueOf(arrIA[i]);
        }
            
        String strSort = Arrays.toString(strArr);
        sortField.setText(strSort);
        
        int nilaiMin = Integer.MAX_VALUE;
        for (int i = 0; i < arrIA.length;i++){
            if (arrIA[i] < nilaiMin){
                nilaiMin = arrIA[i];
            }
        }
        
        String strMin = String.valueOf(nilaiMin);
        minField.setText(strMin);
        
        int nilaiMax = Integer.MIN_VALUE;
        for (int i = 0; i < arrIA.length;i++){
            if (arrIA[i] > nilaiMax){
                nilaiMax = arrIA[i];
            }
        }
        
        String strMax = String.valueOf(nilaiMax);
        maxField.setText(strMax);
        
        
    }//GEN-LAST:event_cariButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Project_Alpro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Project_Alpro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Project_Alpro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Project_Alpro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Project_Alpro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cariButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextArea inputField;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maxField;
    private javax.swing.JTextField minField;
    private javax.swing.JTextArea sortField;
    private javax.swing.JLabel sortLabel;
    // End of variables declaration//GEN-END:variables
}
