package com.example.evaluacion;

public class ListaPlantilla {
    private String Nombre, Materia, Codigo;
    private Double promedio, parcial1, parcial2, parcial3; Integer correlativo;

    public void setNombre(String value){this.Nombre=value;}
    public String getNombre(){return this.Nombre;}
    public void setMateria(String value){this.Materia=value;}
    public String getMateria(){return this.Materia;}
    public void setCodigo(String value){this.Codigo=value;}
    public String getCodigo(){return this.Codigo;}
    public void setPromedio(Double value){this.promedio=value;}
    public Double getPromedio(){return this.promedio;}
    public void setParcial1(Double value){this.parcial1=value;}
    public Double getParcial1(){return this.parcial1;}
    public void setParcial2(Double value){this.parcial2=value;}
    public Double getParcial2(){return this.parcial2;}
    public void setParcial3(Double value){this.parcial3=value;}
    public Double getParcial3(){return this.parcial3;}
    public void setCorrelativo(Integer value){this.correlativo=value;}
    public Integer getCorrelativo(){return this.correlativo;}
}
