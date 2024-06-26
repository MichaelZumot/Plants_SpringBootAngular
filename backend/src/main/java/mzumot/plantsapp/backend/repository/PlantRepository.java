package mzumot.plantsapp.backend.repository;

import mzumot.plantsapp.backend.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {


    @Modifying
    @Query("UPDATE Plant p SET p.lastWatered = :lastWatered WHERE p.id = :plantId")
    void updateLastWatered(@Param("plantId") Long plantId, @Param("lastWatered") Date lastWatered);
}
