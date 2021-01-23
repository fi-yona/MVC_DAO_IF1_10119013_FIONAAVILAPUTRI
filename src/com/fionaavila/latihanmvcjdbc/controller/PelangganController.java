/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */



package com.fionaavila.latihanmvcjdbc.controller;

import com.fionaavila.latihanmvcjdbc.model.PelangganModel;
import com.fionaavila.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 *
 * @author Fiona Avila
 */



public class PelangganController {
    
    private PelangganModel model ;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(PelangganView view){
        model.resetPelanggan();
    }
    
    public void insertPelanggan(PelangganView view){
        String nama = view.getNamaField().getText();
        String alamat = view.getAlamatField().getText();
        String telepon = view.getTeleponField().getText();
        String email = view.getEmailField().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Anda belum menuliskan nama!");
        }else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama yang anda tulis terlalu panjang!");
        }else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Nomor telepon yang anda masukkan lebih dari 12 angka!");
        }else if(!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email anda harus mengandung '@' dan '.'");
        }else{
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try{
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil terdaftar!");
                model.resetPelanggan();
            }catch (Throwable throwable){
                JOptionPane.showMessageDialog(view, ("Terjadi error pada database dengan pesan " + throwable.getMessage()));
            }
        }
    }
    
    public void updatePelanggan(PelangganView view){
        
        if(view.getPelangganTable().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan pilih baris data yang akan diubah!");
            return;
        }
        
        Integer id = Integer.parseInt(view.getIdField().getText());
        String nama = view.getNamaField().getText();
        String alamat = view.getAlamatField().getText();
        String telepon = view.getTeleponField().getText();
        String email = view.getEmailField().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Anda belum menuliskan nama!");
        }else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama yang anda tulis terlalu panjang!");
        }else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Nomor telepon yang anda masukkan lebih dari 12 angka!");
        }else if(!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email anda harus mengandung '@' dan '.'");
        }else{
            
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try{
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil diubah!");
                model.resetPelanggan();
            }catch (Throwable throwable){
                JOptionPane.showMessageDialog(view, ("Terjadi error pada database dengan pesan " + throwable.getMessage()));
            }
        }
    }
    
    public void deletePelanggan(PelangganView view){
        
        if(view.getPelangganTable().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "Silahkan pilih baris data yang akan dihapus!");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus data?")==JOptionPane.OK_OPTION){
            Integer id = Integer.parseInt(view.getIdField().getText());
            model.setId(id);
            
            try{
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Data pelanggan berhasil dihapus!");
                model.resetPelanggan();
            }catch(Throwable throwable){
                JOptionPane.showMessageDialog(view, ("Terjadi error pada database dengan pesan " + throwable.getMessage()));
            }
        }
    }
}
