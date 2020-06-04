/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Antoine
 */
//Sources : openclassroom https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/25335-gerez-les-interfaces-de-tableaux
class ZModel extends AbstractTableModel{
    private Object[][] data;
    private String[] title;

    //Constructeur
    public ZModel(Object[][] data, String[] title){
      this.data = data;
      this.title = title;
    }

    //Retourne le nombre de colonnes
    public int getColumnCount() {
      return this.title.length;
    }

    //Retourne le nombre de lignes
    public int getRowCount() {
      return this.data.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    public Object getValueAt(int row, int col) {
      return this.data[row][col];
    }
    
    public String getColumnName(int col) {
        return this.title[col];
}
    public void setValueAt(Object aValue, int row, int col) {
            data[row][col] = aValue;
            fireTableCellUpdated(row, col);
        }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }
    public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }
}