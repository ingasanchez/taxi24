/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapi.taxi24.Helpers;

import com.webapi.taxi24.Models.ViajeModel;

/**
 *
 * @author ADISON
 * @param <T>
 */
public class ResponseHelper <T> {
    private  String respuesta;
    private  String excepcion;
    private  T model;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public ResponseHelper(String respuesta, String excepcion, T model) {
        this.respuesta = respuesta;
        this.excepcion = excepcion;
        this.model = model;
    }
    
    
    
}
