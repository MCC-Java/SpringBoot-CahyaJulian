/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.controllers;

import com.mcc.crud.entities.Region;
import com.mcc.crud.services.RegionService;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
public class BaseMVCController {

    @Autowired
    RegionService regionService;

    @GetMapping("/")
    public String index(Model model, @Param("keyword") String keyword) {
        model.addAttribute("region", new Region());
        model.addAttribute("regions", regionService.getAll());
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @PostMapping("/save")
    public String save(@Valid Region region) {
        regionService.save(region);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        regionService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("editRegion");
        Region region = regionService.getById(id);
        mav.addObject("region", region);
        return mav;
    }

}
