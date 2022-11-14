package com.webapi.taxi24.Repository;

import com.webapi.taxi24.Models.PasajeroModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADISON
 */
@Repository
public interface PasajeroRepository extends CrudRepository<PasajeroModel, Long> {

}
