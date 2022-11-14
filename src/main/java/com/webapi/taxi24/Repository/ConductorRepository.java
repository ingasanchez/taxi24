package com.webapi.taxi24.Repository;

import com.webapi.taxi24.Models.ConductorModel;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADISON
 */
@Repository
public interface ConductorRepository extends CrudRepository<ConductorModel, Long> {

    @Query("Select c from ConductorModel c Where c.estado = 'D'")
    ArrayList<ConductorModel> findConductoresDisponibles();
    
    @Query("Select c from ConductorModel c Where c.estado <> 'N'")
    ArrayList<ConductorModel> findConductores();
}
