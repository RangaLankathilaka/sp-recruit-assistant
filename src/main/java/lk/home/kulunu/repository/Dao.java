package lk.home.kulunu.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lk.home.kulunu.dto.ExperiancePeriodDTO;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends T> S persist(S entity) {

        Objects.requireNonNull(entity, "Cannot persist a null entity");

        entityManager.persist(entity);

        return entity;
    }
 

    @Transactional(readOnly = true)
    public List<ExperiancePeriodDTO> fetchExperiencePeriod(double candidateExperiance) {
        double checkPeriod=candidateExperiance;
        Query query = entityManager
                .createNativeQuery(" select candidateNic,sum(period) as period from experience group by candidateNic having period>"+checkPeriod)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                ExperiancePeriodDTO.class.getConstructors()[1]
                        )
                );

        List<ExperiancePeriodDTO> result = query.getResultList();

        return result;
    }


    protected EntityManager getEntityManager() {
        return entityManager;
    }
}