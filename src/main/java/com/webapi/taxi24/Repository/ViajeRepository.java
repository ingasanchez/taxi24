package com.webapi.taxi24.Repository;

import com.webapi.taxi24.Models.ViajeModel;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADISON
 */
@Repository
public interface ViajeRepository extends CrudRepository<ViajeModel, Long> {

    @Query("Select v from ViajeModel v Where v.estado = 'P'") // Viajes en proceso
    ArrayList<ViajeModel> getViajesActivos();
}
