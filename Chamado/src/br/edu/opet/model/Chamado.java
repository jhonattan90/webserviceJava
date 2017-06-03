package br.edu.opet.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Chamado")
public class Chamado implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 2179092916642396463L;
	
	/* Métodos de Acesso */
	private int 		idChamado;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column (name = "id_chamado")
	public int getId_chamado() {		return idChamado;	}
	public void setId_chamado(int id_chamado) {		this.idChamado = id_chamado;	}
	
	private String 		tituloChamado;
	@Column (name = "tituloChamado")
	public String getTituloChamado() {return tituloChamado;	}
	public void setTituloChamado(String tituloChamado) {this.tituloChamado = tituloChamado;	}
	
	private String 		obsChamado;
	@Column (name = "obsChamado")
	public String getObsChamado() {	return obsChamado;	}
	public void setObsChamado(String obsChamado) {this.obsChamado = obsChamado;	}
	
	private String		status;
	@Column (name = "status")
	public String getStatus() {	return status;}
	public void setStatus(String status) {	this.status = status;}
	
	private String		dtChamado;
	@Column (name = "dtChamado")
	public String getDtChamado() {return dtChamado;	}
	public void setDtChamado(String dtChamado) {this.dtChamado = dtChamado;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtChamado == null) ? 0 : dtChamado.hashCode());
		result = prime * result + idChamado;
		result = prime * result + ((obsChamado == null) ? 0 : obsChamado.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tituloChamado == null) ? 0 : tituloChamado.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (dtChamado == null) {
			if (other.dtChamado != null)
				return false;
		} else if (!dtChamado.equals(other.dtChamado))
			return false;
		if (idChamado != other.idChamado)
			return false;
		if (obsChamado == null) {
			if (other.obsChamado != null)
				return false;
		} else if (!obsChamado.equals(other.obsChamado))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tituloChamado == null) {
			if (other.tituloChamado != null)
				return false;
		} else if (!tituloChamado.equals(other.tituloChamado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chamado [idChamado=" + idChamado + ", tituloChamado=" + tituloChamado + ", obsChamado=" + obsChamado
				+ ", status=" + status + ", dtChamado=" + dtChamado + "]";
	}

	
	
}
