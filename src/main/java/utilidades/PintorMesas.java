package utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PintorMesas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        try {
            String estado = table.getValueAt(row, 2).toString();
            
            if (!isSelected) {
                if (estado.equals("LIBRE")) {
                    c.setBackground(new Color(180, 235, 180)); 
                    c.setForeground(Color.BLACK);
                } else if (estado.equals("OCUPADA")) {
                    c.setBackground(new Color(255, 102, 102)); 
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(table.getBackground());
                    c.setForeground(table.getForeground());
                }
            } else {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }
        } catch (Exception e) {
        }
        return c;
    }
}