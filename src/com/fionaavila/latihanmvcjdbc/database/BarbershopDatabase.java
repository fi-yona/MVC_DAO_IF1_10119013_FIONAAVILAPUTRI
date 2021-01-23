/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020 (PBO1)
 */



package com.fionaavila.latihanmvcjdbc.database;

/**
 *
 * @author Fiona Avila
 */


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.fionaavila.latihanmvcjdbc.impl.PelangganDaoImpl;
import com.fionaavila.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;

public class BarbershopDatabase {
    
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if(connection == null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/barbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    private static PelangganDao pelangganDao;
    
    public static PelangganDao getPelangganDao() throws SQLException{
        if(pelangganDao == null){
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        return pelangganDao;
    }
}
