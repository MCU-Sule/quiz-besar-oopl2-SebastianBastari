package com.example.kuis2pbo2_1972006.DAO;

import com.example.kuis2pbo2_1972006.Utility.HibernateUtil;
import com.example.kuis2pbo2_1972006.entity.Anggota;
import com.example.kuis2pbo2_1972006.entity.Peminjaman;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class anggotaDAO implements DAOinterface<Anggota> {

    @Override
    public int addData(Anggota data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int delData(Anggota data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.delete(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public int updateData(Anggota data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);
        t.commit();
        s.close();

        return 0 ;
    }

    @Override
    public List<Anggota> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Anggota.class);

        query.from(Anggota.class);

        List<Anggota> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
