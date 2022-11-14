package com.webapi.taxi24.Repository;

import com.webapi.taxi24.Models.FacturaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADISON
 */
@Repository
public interface FacturaRepository extends CrudRepository<FacturaModel, Long> {

}
