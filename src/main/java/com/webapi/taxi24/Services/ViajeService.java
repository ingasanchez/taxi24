package com.webapi.taxi24.Services;

import com.webapi.taxi24.Models.ViajeModel;
import com.webapi.taxi24.Repository.ViajeRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADISON
 */
@Service
public class ViajeService {

    @Autowired
    ViajeRepository viajeRepository;

    public ArrayList<ViajeModel> obtenerViajes() {
        return (ArrayList<ViajeModel>) viajeRepository.findAll();
    }

    public ViajeModel obtenerViajeById(long id) {
        return (ViajeModel) viajeRepository.findById(id).get();
    }

    public ArrayList<ViajeModel> obtenerViajesActivos() {
        return viajeRepository.getViajesActivos();
    }

    public ViajeModel GuardarViaje(ViajeModel viaje) {
        return viajeRepository.save(viaje);
    }

}
