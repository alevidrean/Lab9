package com.exemplu.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masini")
public class Masina {
	@Id
	private String nr;
	private String marca;
	private int anul;
	private String culoarea;
	private int kilometri;

	public Masina() {}

	public Masina(String nr,String marca,int anul,String culoarea,int kilometri)
	{
		this.nr=nr;
		this.marca=marca;
		this.anul=anul;
		this.culoarea=culoarea;
		this.kilometri=kilometri;
	}

	public String getNr()
	{
		return nr;
	}
	public void setNr(String nr)
	{
		this.nr=nr;
	}
	public String getMarca()
	{
		return marca;
	}
	public int getAnul()
	{
		return anul;
	}
	public String getCuloarea()
	{
		return culoarea;
	}
	public int getKilometri()
	{
		return kilometri;
	}

	@Override
	public String toString() {
	    return "Masina{" +
	            "nr inmatriculare='" + nr + '\'' +
	            ", marca='" + marca + '\'' +
	            ", anul=" + anul +
	            ", culoarea='" + culoarea + '\'' +
	            ", kilometri=" + kilometri +
	            '}';
	}

}
