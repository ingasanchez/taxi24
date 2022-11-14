/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapi.taxi24.Controllers;

import static ch.qos.logback.core.util.AggregationType.NOT_FOUND;
import com.webapi.taxi24.Helpers.Constantes;
import com.webapi.taxi24.Helpers.ResponseHelper;
import com.webapi.taxi24.Helpers.UtilitiesHelper;
import com.webapi.taxi24.Models.FacturaModel;
import com.webapi.taxi24.Models.ViajeModel;
import com.webapi.taxi24.Services.FacturaService;
import com.webapi.taxi24.Services.ViajeService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADISON
 */
@RestController
@RequestMapping("/viaje")
public class ViajeController {

    @Autowired
    ViajeService viajeService;
    @Autowired
    FacturaService facturaService;

    @GetMapping("/obtenerTodos")
    public ArrayList<ViajeModel> obtenerViajes() {
        return viajeService.obtenerViajes();
    }

    @GetMapping("/obtenerViajesActivos")
    public ArrayList<ViajeModel> obtenerViajesActivos() {
        return viajeService.obtenerViajesActivos();
    }

    @GetMapping(path = "/{id}")
    public ViajeModel obtenerViajeById(@PathVariable("id") long id) {
        return viajeService.obtenerViajeById(id);
    }

    @PostMapping(path = "/crearViaje")
    public ResponseHelper<ViajeModel> crearViaje(@RequestBody ViajeModel viaje) {
        try {
             ViajeModel viajeResp = viajeService.GuardarViaje(viaje);
             ResponseHelper<ViajeModel> response = new ResponseHelper<>("OK", "", viajeResp);
             return response;
        } catch (Exception ex) {
            ResponseHelper<ViajeModel> response = new ResponseHelper<>("ERROR: " + ex.getMessage(), "", new ViajeModel());
            return response;
        }
    }

    @PutMapping(path = "/completarViaje/{id}/{coordenada}")
    public ResponseHelper<ViajeModel> CompletarViaje(@PathVariable("id") long id, @PathVariable("coordenada") String coordenada) {
        ViajeModel viaje = viajeService.obtenerViajeById(id);

        if (viaje == null) {
            return null;
        }
        // Asignando estado "C" al viaje que equivale a Completado.
        viaje.setEstado("C");
        viaje.setDestino(coordenada);

        // Crear factura al completar el viaje
        // Calcular el monto a cobrar multiplicando distancia recorrida por valor KM.
        double dist = UtilitiesHelper.distanciaCoord(viaje.getOrigen(), coordenada);
        try {
            FacturaModel factura = new FacturaModel();
            factura.setViaje(viaje);
            factura.setDistancia(dist);
            factura.setMonto(dist > 0 ? dist * Constantes.PrecioPorKm : 0);
            facturaService.GuardarFactura(factura);
            ViajeModel viajeResp = viajeService.GuardarViaje(viaje);
            ResponseHelper<ViajeModel> response = new ResponseHelper<>("OK", "", viajeResp);
            return response;
        } catch (Exception e) {
            ResponseHelper<ViajeModel> response = new ResponseHelper<>("ERROR: " + e.getMessage(), "", new ViajeModel());
            return response;
        }
    }

}
