/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */



package com.fionaavila.latihanmvcjdbc.event;

import com.fionaavila.latihanmvcjdbc.entity.Pelanggan;
import com.fionaavila.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author Fiona Avila
 */



public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    
    public void onInsert(Pelanggan pelanggan);
    
    public void onDelete();
    
    public void onUpdate(Pelanggan pelanggan);
    
}
