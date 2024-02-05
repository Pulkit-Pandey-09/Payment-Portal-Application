package demo.ongrid.payment.dao.Impl;


import demo.ongrid.payment.dao.StudentDao;
import demo.ongrid.payment.model.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public Student findByRollNumber(String RollNumber) {
        return entityManager.find(Student.class, RollNumber);
    }


}
