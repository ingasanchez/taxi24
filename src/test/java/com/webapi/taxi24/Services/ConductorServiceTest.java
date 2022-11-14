package com.webapi.taxi24.Services;

import com.webapi.taxi24.Models.ConductorModel;
import com.webapi.taxi24.Repository.ConductorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author ADISON
 */
@SpringBootTest
public class ConductorServiceTest {
    
    @Mock
    private ConductorRepository conductorRepository;
    @InjectMocks
    private ConductorService conductorService;
    private ConductorModel conductor;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        
        conductor = new ConductorModel();
        conductor.setId(1L);
        conductor.setNombre("JUAN PEREZ");
        conductor.setTelefono("809-612-3003");
        conductor.setCorreo("correo@hotmail.com");
    }
    
    @Test
    void test_obtenerConductores() {
        
        List<ConductorModel> lst = new ArrayList<>();
        lst.add(conductor);
        when(conductorRepository.findAll()).thenReturn(lst);
        assertNotNull(conductorService.obtenerConductores());
    }
    
    @Test
    void test_obtenerConductorById() {
        
        when(conductorRepository.findById(1L)).thenReturn(Optional.of(conductor));
        assertNotNull(conductorService.obtenerConductorById(1L));
    }
    
    @Test
    void test_obtenerConductoresDisponibles() {
        
        List<ConductorModel> lst = new ArrayList<ConductorModel>();
        lst.add(conductor);
        when(conductorRepository.findConductoresDisponibles()).thenReturn((ArrayList<ConductorModel>) lst);
        assertNotNull(conductorService.obtenerConductoresDisponibles());
    }
    
    @Test
    void test_GuardarConductor() {
        
        when(conductorRepository.save(any(ConductorModel.class))).thenReturn(conductor);
        assertNotNull(conductorService.GuardarConductor(new ConductorModel()));
    }
    
}
