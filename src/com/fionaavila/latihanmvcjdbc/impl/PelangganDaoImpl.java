/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */
package com.fionaavila.latihanmvcjdbc.impl;

import com.fionaavila.latihanmvcjdbc.entity.Pelanggan;
import com.fionaavila.latihanmvcjdbc.error.PelangganException;
import com.fionaavila.latihanmvcjdbc.service.PelangganDao;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fiona Avila
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN"
            + "(NAMA, ALAMAT, TELEPON, EMAIL) VALUES"
            + "(?,?,?,?)";
    
    private final String updatePelanggan = "UPDATE INTO PELANGGAN"
            + "SET NAMA=?, ALAMAT=?, TELEPON=?, EMAIL=?"
            + "WHERE ID=?";
    
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    
    private final String getById = " SELECT * FROM PELANGGAN WHERE ID=?";
    
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";
    
    private final String selectAll = "SELECT * FROM PELANGGAN";
    
    public PelangganDaoImpl(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        /*
        *Jika ketika di proses dalam try terjadi error
        *otomatis akan menempatkan statement ke dalam catch tanpa di close.
        *jadi kita pasang finally dan
        */
        
        PreparedStatement statement = null;
        
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if(result.next()){
                pelanggan.setId(result.getInt(1));
            }
            connection.commit();
        }catch(SQLException exception){
            try{
                connection.rollback();
            }catch(SQLException ex){
            }
            throw new PelangganException(exception.getMessage());   
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException ex){
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                }
            }
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
        /*
        *Jika ketika di proses dalam try terjadi error
        *otomatis akan menempatkan statement ke dalam catch tanpa di close.
        *jadi kita pasang finally dan
        */
        
        PreparedStatement statement = null;
        
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.setInt(5, pelanggan.getId());
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException exception){
            try{
                connection.rollback();
            }catch(SQLException ex){
            }
            throw new PelangganException(exception.getMessage());   
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException ex){
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                }
            }
        }
    }

    @Override
    public void deletePelanggan(Integer id) throws PelangganException {
        /*
        *Jika ketika di proses dalam try terjadi error
        *otomatis akan menempatkan statement ke dalam catch tanpa di close.
        *jadi kita pasang finally dan
        */
        
        PreparedStatement statement = null;
        
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePelanggan);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException exception){
            try{
                connection.rollback();
            }catch(SQLException ex){
            }
            throw new PelangganException(exception.getMessage());   
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException ex){
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer id) throws PelangganException {
        PreparedStatement statement = null;
        
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            
            ResultSet result =  statement.executeQuery();
            Pelanggan pelanggan = null;
            
            if(result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("Alamat"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            }else{
                throw new PelangganException("Pelanggan dengan id "
                                                + id + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        }catch(SQLException exception){
            try{
                connection.rollback();
            }catch(SQLException ex){
            }
            throw new PelangganException(exception.getMessage());   
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException ex){
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
        PreparedStatement statement = null;
        
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmail);
            statement.setString(1, email);
            
            ResultSet result =  statement.executeQuery();
            Pelanggan pelanggan = null;
            
            if(result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("Alamat"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            }else{
                throw new PelangganException("Pelanggan dengan id "
                                                + email + " tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        }catch(SQLException exception){
            try{
                connection.rollback();
            }catch(SQLException ex){
            }
            throw new PelangganException(exception.getMessage());   
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException ex){
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                }
            }
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        
        try{
            connection.setAutoCommit(false);
            statement = (Statement) connection.createStatement();
            ResultSet result =  statement.executeQuery(selectAll);
            while(result.next()){
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("Alamat"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                list.add(pelanggan);
            }
            connection.commit();
            return list;
        }catch(SQLException exception){
            try{
                connection.rollback();
            }catch(SQLException ex){
            }
            throw new PelangganException(exception.getMessage());   
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch(SQLException ex){
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException exception){
                }
            }
        }
    }
}
