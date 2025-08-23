package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver , Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id , String  licenseNumber);

    @Query(nativeQuery = true , value = "SELECT * FROM Driver WHERE id = :id AND license_number =:license")  //Raw Mysql Query : error is thrown at runtime is queried
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id , String license);


    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.licenseNumber = :ln")
    Optional<Driver> hblFindByIdAndLicenseNumber(@Param("id") Long id, @Param("ln") String ln);



    List<Driver> findAllByIdIn(List<Long> driverIds);
}
