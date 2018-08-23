/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeattendance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Daisy N
 */
public class ParticulaAttendanceAdmin extends JPanel {

    private static JPanel panel;
    private static JButton button;
    private static JScrollPane scrollPane;
    private static JTable table;
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public ParticulaAttendanceAdmin() {
        con = Connector.ConnecrDB();
        setLayout(null);
        setSize(800, 600);
        setLocation(0, 0);

        panel = new JPanel();
        panel.setBounds(50, 30, 700, 450);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        button = new JButton("print");
        button.setBackground(Color.decode("#1E90FF"));
        button.setBorder(new LineBorder(Color.decode("#1E90FF")));
        button.setForeground(Color.WHITE);
        button.setBounds(310, 405, 80, 30);
        panel.add(button);
        table = new JTable();
       // String query = "select checkin.EmpId,checkin.checkinDate as Date,checkin.checkinTime,checkout.checkOutTime from checkin join checkout on checkin.EmpId=checkout.empId";

 String query ="select checkin.EmpId,checkin.checkinDate,checkin.checkinTime,checkout.checkOutTime from checkin,checkout where checkin.EmpId=checkout.EmpId and checkout.EmpId='"+ParticulaAdmin.jTextField1.getText()+"'";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
           // Logger.getLogger(AllROutesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setModel(DbUtils.resultSetToTableModel(rs));

        scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBounds(0, 0, 700, 390);
        panel.add(scrollPane);

        button.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MessageFormat header = new MessageFormat("List of All Members");
                    MessageFormat footer = new MessageFormat(" we like you");
                    table.print(PrintMode.NORMAL, header, footer);
                    JOptionPane.showMessageDialog(null,"printer error","print",JOptionPane.ERROR_MESSAGE );
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(null,"printer error"+ex.getMessage(),"print",JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        );

        add(panel);
        repaint();
        setVisible(true);
    }

}
