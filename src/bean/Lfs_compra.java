/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author u10918857104
 */
public class Lfs_compra {
    private int lfs_idCompra;
    private Date lfs_dataCompra;
    private double lfs_total;
    private int lfs_fk_fornecedor;
    private int lfs_fk_usuarios;

    /**
     * @return the lfs_idCompra
     */
    public int getLfs_idCompra() {
        return lfs_idCompra;
    }

    /**
     * @param lfs_idCompra the lfs_idCompra to set
     */
    public void setLfs_idCompra(int lfs_idCompra) {
        this.lfs_idCompra = lfs_idCompra;
    }

    /**
     * @return the lfs_dataCompra
     */
    public Date getLfs_dataCompra() {
        return lfs_dataCompra;
    }

    /**
     * @param lfs_dataCompra the lfs_dataCompra to set
     */
    public void setLfs_dataCompra(Date lfs_dataCompra) {
        this.lfs_dataCompra = lfs_dataCompra;
    }

    /**
     * @return the lfs_total
     */
    public double getLfs_total() {
        return lfs_total;
    }

    /**
     * @param lfs_total the lfs_total to set
     */
    public void setLfs_total(double lfs_total) {
        this.lfs_total = lfs_total;
    }

    /**
     * @return the lfs_fk_fornecedor
     */
    public int getLfs_fk_fornecedor() {
        return lfs_fk_fornecedor;
    }

    /**
     * @param lfs_fk_fornecedor the lfs_fk_fornecedor to set
     */
    public void setLfs_fk_fornecedor(int lfs_fk_fornecedor) {
        this.lfs_fk_fornecedor = lfs_fk_fornecedor;
    }

    /**
     * @return the lfs_fk_usuarios
     */
    public int getLfs_fk_usuarios() {
        return lfs_fk_usuarios;
    }

    /**
     * @param lfs_fk_usuarios the lfs_fk_usuarios to set
     */
    public void setLfs_fk_usuarios(int lfs_fk_usuarios) {
        this.lfs_fk_usuarios = lfs_fk_usuarios;
    }

}