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
public class RamaBO {
    private int nroRama;
    private String nombreRama;
    
    public RamaBO(){
        
    }

    public RamaBO(int nroRama, String nombreRama) {
        this.nroRama = nroRama;
        this.nombreRama = nombreRama;
    }
    
    public int getNroRama() {
        return nroRama;
    }

    public void setNroRama(int nroRama) {
        this.nroRama = nroRama;
    }

    public String getNombreRama() {
        return nombreRama;
    }

    public void setNombreRama(String nombreRama) {
        this.nombreRama = nombreRama;
    }
    
    @Override
    public String toString(){
        return nroRama+" "+nombreRama;
    }
    
}
