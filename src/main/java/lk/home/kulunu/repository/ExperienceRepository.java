package lk.home.kulunu.repository;


import lk.home.kulunu.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Integer> {

//    @Query("SELECT c.candidate,sum(c.period) FROM Experience c WHERE c.period  >=:candidateExperiance group by c.candidate")
@Query("SELECT c.period,c.companyName FROM Experience c WHERE c.period  >=:candidateExperiance group by c.candidate")
    List<Experience> candidateExperiance(@Param("candidateExperiance") double candidateExperiance);


//    select act.ActivityId, act.Title, count( elements(act.Reports) )
//    from Activity act
//    group by act.ActivityId, act.Title



//if c.candidate List<Candidate>
    //c.pesriod and sum(c.period) List<Experience>





//    List postDTOs = entityManager
//            .createNativeQuery(
//                    "select " +
//                            "       p.id as \"id\", " +
//                            "       p.title as \"title\" " +
//                            "from Post p " +
//                            "where p.created_on > :fromTimestamp")
//            .setParameter( "fromTimestamp", Timestamp.from(
//                    LocalDateTime.of( 2016, 1, 1, 0, 0, 0 ).toInstant( ZoneOffset.UTC ) ))
//            .unwrap( org.hibernate.query.NativeQuery.class )
//            .setResultTransformer( Transformers.aliasToBean( PostDTO.class ) )
//            .getResultList();




//    List<Tuple> postDTOs = entityManager
//            .createNativeQuery(
//                    "SELECT " +
//                            "       p.id AS id, " +
//                            "       p.title AS title " +
//                            "FROM Post p " +
//                            "WHERE p.created_on > :fromTimestamp", Tuple.class)
//            .setParameter( "fromTimestamp", Timestamp.from(
//                    LocalDateTime.of( 2016, 1, 1, 0, 0, 0 )
//                            .toInstant( ZoneOffset.UTC ) ))
//            .getResultList();
//
//    assertFalse( postDTOs.isEmpty() );
//
//    Tuple postDTO = postDTOs.get( 0 );
//    assertEquals(
//    1L,
//            ((Number) postDTO.get( "id" )).longValue()
//);
//
//    assertEquals(
//    "High-Performance Java Persistence",
//    postDTO.get( "title" )
//);



}
