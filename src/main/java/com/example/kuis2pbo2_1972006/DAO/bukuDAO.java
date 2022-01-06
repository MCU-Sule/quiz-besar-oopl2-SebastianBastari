package com.example.kuis2pbo2_1972006.DAO;

import com.example.kuis2pbo2_1972006.Utility.HibernateUtil;
import com.example.kuis2pbo2_1972006.entity.Anggota;
import com.example.kuis2pbo2_1972006.entity.Buku;
import com.example.kuis2pbo2_1972006.entity.Peminjaman;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class bukuDAO implements DAOinterface<Buku>{
    @Override
    public int addData(Buku data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int delData(Buku data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.delete(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int updateData(Buku data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public List<Buku> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Buku.class);

        query.from(Buku.class);

        List<Buku> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
