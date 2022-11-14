/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapi.taxi24.Services;

import com.webapi.taxi24.Models.FacturaModel;
import com.webapi.taxi24.Repository.FacturaRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADISON
 */
@Service
public class FacturaService {
    @Autowired
    FacturaRepository facturaRepository;
    
     public ArrayList<FacturaModel> obtenerFacturas (){
          return (ArrayList<FacturaModel>) facturaRepository.findAll();
    }
    
     public FacturaModel obtenerFacturaById ( long id){
          return (FacturaModel)facturaRepository.findById(id).get();
    }
     
     public FacturaModel GuardarFactura ( FacturaModel factura){
          return facturaRepository.save(factura);
    }
     
}
