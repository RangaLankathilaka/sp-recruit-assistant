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
public class CustomRepository<T, ID extends Serializable> implements GenericRepository<T, ID> {

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

        Query query = entityManager
                .createNativeQuery(" select candidateNic,sum(period) as period from experience group by candidateNic having period>"+candidateExperiance)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                ExperiancePeriodDTO.class.getConstructors()[1]
                        )
                );

        List<ExperiancePeriodDTO> result = query.getResultList();

        return result;
    }

    @Transactional(readOnly = true)
    public List<ExperiancePeriodDTO> fetchExperiencePeriodandCoreLanguage(double candidateExperiance,String coreLanguage) {

        Query query = entityManager
                .createNativeQuery(" select c.candidateNic,sum(e.period) as period from candidate c,experience e where c.candidateNic=e.candidateNic && c.corelanguage=\""+coreLanguage+"\" group by c.candidateNic having period>"+candidateExperiance)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                ExperiancePeriodDTO.class.getConstructors()[1]
                        )
                );

        List<ExperiancePeriodDTO> result = query.getResultList();

        return result;
    }


    @Transactional(readOnly = true)
    public List<ExperiancePeriodDTO> fetchExperiencePeriodanddevelopField(double candidateExperiance,String developField) {

        Query query = entityManager
                .createNativeQuery(" select c.candidateNic,sum(e.period) as period from candidate c,experience e where c.candidateNic=e.candidateNic && c.developField=\""+developField+"\" group by c.candidateNic having period>"+candidateExperiance)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                ExperiancePeriodDTO.class.getConstructors()[1]
                        )
                );

        List<ExperiancePeriodDTO> result = query.getResultList();

        return result;
    }


    @Transactional(readOnly = true)
    public List<ExperiancePeriodDTO> fetchExperienceLanguageField(double candidateExperiance,String coreLanguage,String developField) {

        Query query = entityManager
                .createNativeQuery(" select c.candidateNic,sum(e.period) as period from candidate c,experience e where c.candidateNic=e.candidateNic && c.coreLanguage=\""+coreLanguage+"\" && c.developField=\""+developField+"\" group by c.candidateNic having period>"+candidateExperiance)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                ExperiancePeriodDTO.class.getConstructors()[1]
                        )
                );

        List<ExperiancePeriodDTO> result = query.getResultList();

        return result;
    }

    //select c.candidateNic,sum(e.period) as period from candidate c,experience e where c.candidateNic=e.candidateNic && c.corelanguage="java" group by c.candidateNic having period>2.5;

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}