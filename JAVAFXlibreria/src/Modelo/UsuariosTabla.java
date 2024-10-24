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
    private Integer idUsuario;
    private String nombreUsuario;
    private String cargoUsuario;
    private String contraseniaUsuario;

    public UsuariosTabla(Integer idUsuario, String nombreUsuario, String cargoUsuario, String contraseniaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.cargoUsuario = cargoUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
    }

    
    /**
     * @return the idUsuarios
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuarios the idUsuarios to set
     */
    public void setIdUsuario(Integer idUsuarios) {
        this.idUsuario = idUsuarios;
    }

    /**
     * @return the nombreUsuarios
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuarios the nombreUsuarios to set
     */
    public void setNombreUsuario(String nombreUsuarios) {
        this.nombreUsuario = nombreUsuarios;
    }

    /**
     * @return the cargoUsuarios
     */
    public String getCargoUsuario() {
        return cargoUsuario;
    }

    /**
     * @param cargoUsuarios the cargoUsuarios to set
     */
    public void setCargoUsuario(String cargoUsuarios) {
        this.cargoUsuario = cargoUsuarios;
    }

    /**
     * @return the contraseniaUsuarios
     */
    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    /**
     * @param contraseniaUsuarios the contraseniaUsuarios to set
     */
    public void setContraseniaUsuario(String contraseniaUsuarios) {
        this.contraseniaUsuario = contraseniaUsuarios;
    }
    
    
}
