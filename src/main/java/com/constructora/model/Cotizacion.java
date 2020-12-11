package com.constructora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Información de cotizaciones de proyectos")
@Entity
@Table(name = "cotizacion")
public class Cotizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCotizacion;

	@ManyToOne
	@JoinColumn(name = "idMaterial", nullable = false, foreignKey = @ForeignKey(name = "FK_cotizacion_material"))
	private Material material;

	@ApiModelProperty(notes = "Fecha automatica de cotizacion de materiales")
	@Column(name = "fechaCotizacion", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaCotizacion;

	@ApiModelProperty(notes = "Precio cotizado, solo numeros")
	@Column(name = "precioCotizado", nullable = false, length = 50)
	private Integer precioCotizado;

	@ApiModelProperty(notes = "Nombre tienda cotizada")
	@Column(name = "tiendaCotizada", nullable = false, length = 50)
	private String tiendaCotizada;
	
	@ApiModelProperty(notes = "Cantidad cotizada")
	@Column(name = "cantidad", nullable = false, length = 50)
	private Integer cantidad;

	public Integer getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Date getFechaCotizacion() {
		return fechaCotizacion;
	}

	public void setFechaCotizacion(Date fechaCotizacion) {
		this.fechaCotizacion = fechaCotizacion;
	}

	public Integer getPrecioCotizado() {
		return precioCotizado;
	}

	public void setPrecioCotizado(Integer precioCotizado) {
		this.precioCotizado = precioCotizado;
	}

	public String getTiendaCotizada() {
		return tiendaCotizada;
	}

	public void setTiendaCotizada(String tiendaCotizada) {
		this.tiendaCotizada = tiendaCotizada;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
