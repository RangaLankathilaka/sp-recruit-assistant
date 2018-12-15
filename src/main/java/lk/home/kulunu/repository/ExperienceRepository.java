package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Document;
import lk.home.kulunu.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
}
