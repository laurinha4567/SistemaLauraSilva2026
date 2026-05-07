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
public class Lfs_venda {
    int lfs_idVenda;
    Date lfs_dataVenda;
    double lfs_total;
    int lfs_fk_vendedor;
    int lfs_fk_cliente;

    public Lfs_venda() {
    }

    public int getLfs_idVenda() {
        return lfs_idVenda;
    }

    public void setLfs_idVenda(int lfs_idVenda) {
        this.lfs_idVenda = lfs_idVenda;
    }

    public Date getLfs_dataVenda() {
        return lfs_dataVenda;
    }

    public void setLfs_dataVenda(Date lfs_dataVenda) {
        this.lfs_dataVenda = lfs_dataVenda;
    }

    public double getLfs_total() {
        return lfs_total;
    }

    public void setLfs_total(double lfs_total) {
        this.lfs_total = lfs_total;
    }

  
    public int getLfs_fk_vendedor() {
        return lfs_fk_vendedor;
    }

    public void setLfs_fk_vendedor(int lfs_fk_vendedor) {
        this.lfs_fk_vendedor = lfs_fk_vendedor;
    }

    public int getLfs_fk_cliente() {
        return lfs_fk_cliente;
    }

    public void setLfs_fk_cliente(int lfs_fk_cliente) {
        this.lfs_fk_cliente = lfs_fk_cliente;
    }

    
    
}
