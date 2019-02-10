package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Document;
import lk.home.kulunu.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Integer> {
}
