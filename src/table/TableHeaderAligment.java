package table;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


public class TableHeaderAligment implements TableCellRenderer{
    private final TableCellRenderer oldHeaderRenderer;
    private final TableCellRenderer oldCellRenderer;

    public TableHeaderAligment(JTable table) {
        this.oldHeaderRenderer = table.getTableHeader().getDefaultRenderer();
        this.oldCellRenderer = table.getDefaultRenderer(Object.class);
        table.setDefaultRenderer(Object.class, new TableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label =  (JLabel) oldCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setHorizontalAlignment(getAlignment(column));
                return label;
            }
            
        }
        );
    
        
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) oldHeaderRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return label;
    }
    
    protected int getAlignment(int column){
        if(column ==1){
            return SwingConstants.CENTER;
        }
        return SwingConstants.LEADING;
    }
    
    
    
    
}
