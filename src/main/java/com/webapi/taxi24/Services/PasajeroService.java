
package com.webapi.taxi24.Services;

import com.webapi.taxi24.Models.PasajeroModel;
import com.webapi.taxi24.Repository.PasajeroRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADISON
 */
@Service
public class PasajeroService {
    @Autowired
    PasajeroRepository pasajeroRepository;
    
     public ArrayList<PasajeroModel> obtenerPasajeros (){
          return (ArrayList<PasajeroModel>) pasajeroRepository.findAll();
    }
    
     public PasajeroModel obtenerPasajeroById ( long id){
          return (PasajeroModel)pasajeroRepository.findById(id).get();
    }
     
}
