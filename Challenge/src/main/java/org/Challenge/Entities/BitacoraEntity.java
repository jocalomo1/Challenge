package org.Challenge.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "bitacora")
public class BitacoraEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBitacora;
    @Column
    private String ip_origen;
    @Column
    private Timestamp fecha_movimiento;
    @Column
    private String accion;

    public BitacoraEntity() {

    }

    public BitacoraEntity(int idBitacora, String ip_origen, Timestamp fecha_movimiento, String accion) {
        this.idBitacora = idBitacora;
        this.ip_origen = ip_origen;
        this.fecha_movimiento = fecha_movimiento;
        this.accion = accion;
    }

    public int getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(int idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getIp_origen() {
        return ip_origen;
    }

    public void setIp_origen(String ip_origen) {
        this.ip_origen = ip_origen;
    }

    public Timestamp getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(Timestamp fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
