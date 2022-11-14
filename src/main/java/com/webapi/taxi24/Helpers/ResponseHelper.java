package com.webapi.taxi24.Helpers;

/**
 *
 * @author ADISON
 * @param <T>
 */
public class ResponseHelper<T> {

    private String respuesta;
    private String excepcion;
    private T model;

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
