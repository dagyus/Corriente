/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

/**
 *
 * @author sept
 */
public class ActividadBO {
    private int idActividad, idRamaProyecto;
    private String nombreActividad;
    
    public ActividadBO(){
        
    }

    public ActividadBO(int idActividad, int idRamaProyecto, String nombreActividad) {
        this.idActividad = idActividad;
        this.idRamaProyecto = idRamaProyecto;
        this.nombreActividad = nombreActividad;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdRamaProyecto() {
        return idRamaProyecto;
    }

    public void setIdRamaProyecto(int idRamaProyecto) {
        this.idRamaProyecto = idRamaProyecto;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
    
    
}
