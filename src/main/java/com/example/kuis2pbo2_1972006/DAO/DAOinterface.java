package com.example.kuis2pbo2_1972006.DAO;

import java.util.List;
import java.sql.SQLException;
public interface DAOinterface<E> {
    public int addData(E data) ;

    public int delData(E data) ;

    public int updateData(E data);

    public List<E> showData();
}
