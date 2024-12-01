package view.componentes_personalizados;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
    public MyTableModel (Object[][] data, Object[] columnName){
        super(data,columnName);
    }
}
