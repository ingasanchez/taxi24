/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapi.taxi24.Controllers;


import com.webapi.taxi24.Helpers.UtilitiesHelper;
import com.webapi.taxi24.Models.FacturaModel;
import com.webapi.taxi24.Services.FacturaService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADISON
 */
@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    FacturaService facturaService;
    
    @GetMapping("/obtenerTodas")
    public ArrayList<FacturaModel> obtenerFacturaes(){
        return facturaService.obtenerFacturas();
    }
    
    @GetMapping(path = "/{id}")
    public FacturaModel obtenerFacturaById( @PathVariable("id") long id){
        return facturaService.obtenerFacturaById(id);
    }
   
   
}
