/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */



package com.fionaavila.latihanmvcjdbc.model;

import com.fionaavila.latihanmvcjdbc.entity.Pelanggan;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fiona Avila
 */



public class TablePelangganModel extends AbstractTableModel{
    
    private List<Pelanggan> list = new ArrayList<Pelanggan>();

    public void setList(List<Pelanggan> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(Pelanggan e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Pelanggan get(int index) {
        return list.get(index);
    }

    public Pelanggan set(int index, Pelanggan element) {
        try{
           return list.set(index, element); 
        }finally{
            fireTableRowsUpdated(index, index);
        }
    }

    public Pelanggan remove(int index) {
        try{
            return list.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : 
                return "ID";
            case 1 :
                return "NAMA";
            case 2 : 
                return "ALAMAT";
            case 3 : 
                return "TELEPON";
            case 4 : 
                return "EMAIL";
            default :
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :
                return list.get(rowIndex).getId();
            case 1 :
                return list.get(rowIndex).getNama();
            case 2 :
                return list.get(rowIndex).getAlamat();
            case 3 :
                return list.get(rowIndex).getTelepon();
            case 4 :
                return list.get(rowIndex).getEmail();
            default :
                return null;
        }
    }
    
}
