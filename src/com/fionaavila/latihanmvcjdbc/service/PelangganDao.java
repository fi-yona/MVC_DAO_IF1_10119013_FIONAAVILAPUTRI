/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */



package com.fionaavila.latihanmvcjdbc.service;

/**
 *
 * @author Fiona Avila
 */


import com.fionaavila.latihanmvcjdbc.entity.Pelanggan;
import com.fionaavila.latihanmvcjdbc.error.PelangganException;
import java.util.List;


public interface PelangganDao {
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void deletePelanggan(Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan(Integer id) throws PelangganException;
    
    //unique
    public Pelanggan getPelanggan(String email) throws PelangganException;
    
    //load semua data
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
}
