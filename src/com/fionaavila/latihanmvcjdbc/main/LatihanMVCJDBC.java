/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */


package com.fionaavila.latihanmvcjdbc.main;

/**
 *
 * @author Fiona Avila
 */


import com.fionaavila.latihanmvcjdbc.database.BarbershopDatabase;
import com.fionaavila.latihanmvcjdbc.entity.Pelanggan;
import com.fionaavila.latihanmvcjdbc.error.PelangganException;
import com.fionaavila.latihanmvcjdbc.service.PelangganDao;
import com.fionaavila.latihanmvcjdbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class LatihanMVCJDBC{
    public static void main(String[] args) throws SQLException, PelangganException{
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                MainViewPelanggan pelanggan = new MainViewPelanggan();
                try {
                    pelanggan.loadDatabase();
                } catch (SQLException ex) {
                    Logger.getLogger(LatihanMVCJDBC.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PelangganException ex) {
                    Logger.getLogger(LatihanMVCJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
                pelanggan.setVisible(true);
            }
        });
        
    }
}
