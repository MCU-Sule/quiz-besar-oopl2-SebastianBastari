module com.example.kuis2pbo2_1972006 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.example.kuis2pbo2_1972006 to javafx.fxml;
    exports com.example.kuis2pbo2_1972006;
    exports com.example.kuis2pbo2_1972006.entity;



}