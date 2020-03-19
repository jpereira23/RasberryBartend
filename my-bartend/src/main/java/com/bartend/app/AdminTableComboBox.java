import java.awt.*; 
import java.awt.event.*; 
import java.util.List;
import java.util.ArrayList; 
import javax.swing.*; 
import javax.swing.border.*;
import javax.swing.table.*;

public class AdminTableComboBox extends JTable
{
  private List<TableCellEditor> editors = new ArrayList<TableCellEditor>(15);
  public AdminTableComboBox(String[] items)
  {
    setLayout( new BorderLayout() );
    
  
    for(int i = 0; i < 15; i++)
    {
      JComboBox<String> comboBox1 = new JComboBox<String>( items ); 
      DefaultCellEditor dce = new DefaultCellEditor( comboBox1 );
      editors.add( dce );
    }
  }

  
}
