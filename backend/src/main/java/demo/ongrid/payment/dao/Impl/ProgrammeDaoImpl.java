package demo.ongrid.payment.dao.Impl;

import demo.ongrid.payment.dao.ProgrammeDao;
import demo.ongrid.payment.model.entity.Programme;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProgrammeDaoImpl implements ProgrammeDao {

    private EntityManager entityManager;
    @Autowired
    public ProgrammeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Programme getProgrammeById(Integer Id) {
        return entityManager.find(Programme.class, Id);
    }
}
