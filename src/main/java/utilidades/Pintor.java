package utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Pintor extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        try {
            
            double stockActual = Double.parseDouble(table.getValueAt(row, 4).toString());
            double stockMinimo = Double.parseDouble(table.getValueAt(row, 5).toString());
            
           
            if (stockActual <= stockMinimo) {
                
                c.setBackground(new Color(255, 102, 102)); 
                c.setForeground(Color.WHITE);
            } else {
               
                c.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                c.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
            }
        } catch (Exception e) {
        }
        
        return c;
    }
}