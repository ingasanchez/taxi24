/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapi.taxi24.Controllers;


import com.webapi.taxi24.Helpers.UtilitiesHelper;
import com.webapi.taxi24.Models.ConductorModel;
import com.webapi.taxi24.Services.ConductorService;
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
@RequestMapping("/conductor")
public class ConductorController {
    @Autowired
    ConductorService conductorService;
    
    @GetMapping("/obtenerTodos")
    public ArrayList<ConductorModel> obtenerConductores(){
        return conductorService.obtenerConductores();
    }
    
     @GetMapping("/obtenerDisponibles")
    public ArrayList<ConductorModel> obtenerConductoresDisponibles(){
        return conductorService.obtenerConductoresDisponibles();
    }
    
    @GetMapping(path = "/{id}")
    public ConductorModel obtenerConductorById( @PathVariable("id") long id){
        return conductorService.obtenerConductorById(id);
    }
    
     @GetMapping("obtenerConductorByDistance/{coordenada}/{distancia}")
    public List<ConductorModel> obtenerConductorByDistance( @PathVariable("coordenada") String coordenada, @PathVariable("distancia") Double distancia ){
        
        Map <Double,ConductorModel> conductoresByDistance = new TreeMap<>();
        List <ConductorModel> conductoresDisponibles = conductorService.obtenerConductoresDisponibles();
        for (ConductorModel conductor : conductoresDisponibles){
            double dist = UtilitiesHelper.distanciaCoord(coordenada,conductor.getUbicacionActual());
            conductoresByDistance.put((Double)dist, conductor);
        }
        
         List <ConductorModel> conductoresDisponiblesEnArea = new ArrayList<>();
        for (Double dist:conductoresByDistance.keySet()){
            if (dist <= distancia ){
                conductoresDisponiblesEnArea.add(conductoresByDistance.get(dist));
            }
        }
        
        return conductoresDisponiblesEnArea;
    }
   
}
