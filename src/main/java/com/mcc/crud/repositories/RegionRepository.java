/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.repositories;

import com.mcc.crud.entities.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

	@Query (value = "SELECT r FROM Region r WHERE UPPER (r.name) LIKE CONCAT ('%', UPPER(:name),'%')", nativeQuery = false)
	   List<Region> cariBasednama(String keyword);
    
}
