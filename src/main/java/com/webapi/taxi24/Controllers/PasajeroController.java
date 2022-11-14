/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapi.taxi24.Controllers;

import com.webapi.taxi24.Helpers.UtilitiesHelper;
import com.webapi.taxi24.Models.ConductorModel;
import com.webapi.taxi24.Models.PasajeroModel;
import com.webapi.taxi24.Services.ConductorService;
import com.webapi.taxi24.Services.PasajeroService;
import java.util.ArrayList;
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
@RequestMapping("/pasajero")
public class PasajeroController {

    @Autowired
    PasajeroService pasajeroService;
    @Autowired
    ConductorService conductorService;

    @GetMapping("/obtenerTodos")
    public ArrayList<PasajeroModel> obtenerPasajeros() {
        return pasajeroService.obtenerPasajeros();
    }

    @GetMapping(path = "/{id}")
    public PasajeroModel obtenerPasajeroById(@PathVariable("id") long id) {
        return pasajeroService.obtenerPasajeroById(id);
    }


    @GetMapping(path = "obtenerConductoresCercanos/{coordenada}/{cantidad}")
    public List<ConductorModel> obtenerConductoresCercanos(@PathVariable("coordenada") String coordenada, @PathVariable("cantidad") Double cant) {

        Map<Double, ConductorModel> conductoresByDistance = new TreeMap<>();
        List<ConductorModel> conductoresDisponibles = conductorService.obtenerConductoresCercanos();
        for (ConductorModel conductor : conductoresDisponibles) {
            double dist = UtilitiesHelper.distanciaCoord(coordenada, conductor.getUbicacionActual());
            conductoresByDistance.put((Double) dist, conductor);
        }

        List<ConductorModel> conductoresDisponiblesEnArea = new ArrayList<>();
        int contador = 1;
        for (Double dist : conductoresByDistance.keySet()) {

            if (contador <= cant) {
                conductoresDisponiblesEnArea.add(conductoresByDistance.get(dist));
                contador++;
            }
        }

        return conductoresDisponiblesEnArea;
    }

}
