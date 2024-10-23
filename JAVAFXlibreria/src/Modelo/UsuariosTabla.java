/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 20041
 */
public class UsuariosTabla {
    private Integer idUsuarios;
    private String nombreUsuarios;
    private String cargoUsuarios;
    private String contraseniaUsuarios;

    public UsuariosTabla(Integer idUsuarios, String nombreUsuarios, String cargoUsuarios, String contraseniaUsuarios) {
        this.idUsuarios = idUsuarios;
        this.nombreUsuarios = nombreUsuarios;
        this.cargoUsuarios = cargoUsuarios;
        this.contraseniaUsuarios = contraseniaUsuarios;
    }

    
    /**
     * @return the idUsuarios
     */
    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    /**
     * @param idUsuarios the idUsuarios to set
     */
    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    /**
     * @return the nombreUsuarios
     */
    public String getNombreUsuarios() {
        return nombreUsuarios;
    }

    /**
     * @param nombreUsuarios the nombreUsuarios to set
     */
    public void setNombreUsuarios(String nombreUsuarios) {
        this.nombreUsuarios = nombreUsuarios;
    }

    /**
     * @return the cargoUsuarios
     */
    public String getCargoUsuarios() {
        return cargoUsuarios;
    }

    /**
     * @param cargoUsuarios the cargoUsuarios to set
     */
    public void setCargoUsuarios(String cargoUsuarios) {
        this.cargoUsuarios = cargoUsuarios;
    }

    /**
     * @return the contraseniaUsuarios
     */
    public String getContraseniaUsuarios() {
        return contraseniaUsuarios;
    }

    /**
     * @param contraseniaUsuarios the contraseniaUsuarios to set
     */
    public void setContraseniaUsuarios(String contraseniaUsuarios) {
        this.contraseniaUsuarios = contraseniaUsuarios;
    }
    
    
}
