/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.services;

import com.mcc.crud.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcc.crud.repositories.RegionRepository;
import java.util.List;

/**
 *
 * @author User
 */
@Service
public class RegionService {
    
    @Autowired
    RegionRepository regionRepositories;
    
    public List<Region> getAll(){
        return regionRepositories.findAll();
    } 
    
    public void save(Region region){
        regionRepositories.save(region);
    }
    
    public void delete (Integer id){
        regionRepositories.delete(new Region(id));
    }

    public Region getById(Integer id) {
        return regionRepositories.findById(id).get();
        }

    public List<Region> searchByKeyword(String keyword) {
        return regionRepositories.cariBasednama(keyword); //To change body of generated methods, choose Tools | Templates.
    }
}
