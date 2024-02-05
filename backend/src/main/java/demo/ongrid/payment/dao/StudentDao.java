package demo.ongrid.payment.dao;

import demo.ongrid.payment.model.entity.Student;

public interface StudentDao {
    Student findByRollNumber(String RollNumber);

}
