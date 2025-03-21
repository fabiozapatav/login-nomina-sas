package com.example.demo.models;

public class User {
    private Long id;
    private String name;
    private String area;
    private String cargo;
    private String cedula;
    private double salary;

    public User() {}

    public User(Long id, String name, String area, String cargo, String cedula, double salary) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cargo = cargo;
        this.cedula = cedula;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // Método para calcular la prima de servicios
    public double getPrima() {
        return salary / 2; // Se asume que la prima es el 50% del salario mensual
    }
}