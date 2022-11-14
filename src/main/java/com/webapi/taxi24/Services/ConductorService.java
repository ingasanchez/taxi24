package com.webapi.taxi24.Services;

import com.webapi.taxi24.Models.ConductorModel;
import com.webapi.taxi24.Repository.ConductorRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADISON
 */
@Service
public class ConductorService {

    @Autowired
    ConductorRepository conductorRepository;

    public ArrayList<ConductorModel> obtenerConductores() {
        return (ArrayList<ConductorModel>) conductorRepository.findAll();
    }

    public ConductorModel obtenerConductorById(long id) {
        return (ConductorModel) conductorRepository.findById(id).get();
    }

    public ArrayList<ConductorModel> obtenerConductoresDisponibles() {
        return (ArrayList<ConductorModel>) conductorRepository.findConductoresDisponibles();
    }

    public ArrayList<ConductorModel> obtenerConductoresCercanos() {
        return (ArrayList<ConductorModel>) conductorRepository.findConductores();
    }

    public ConductorModel GuardarConductor(ConductorModel conductor) {
        return conductorRepository.save(conductor);
    }
}
