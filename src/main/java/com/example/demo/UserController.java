package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<User> users = new ArrayList<>(); // Almacena usuarios como objetos

    @GetMapping
    public List<User> getUsers() {
        return users;
    }



    @PostMapping
    public String createUser(@RequestBody List<User> newUsers) {
        newUsers.forEach(user -> {
            users.add(user); // Agrega los usuarios a la lista
            System.out.println("Usuario creado: " + user.getName());
        });
        return "Usuarios creados correctamente";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return "Usuario con ID " + id + " eliminado correctamente";
            }
        }
        return "Usuario con ID " + id + " no encontrado";
    }
}

// Definimos la clase User con los campos que faltaban
class User {
    private int id;
    private String name;
    private double salary; // ✅ Campo existente
    private String area;   // ✅ Nuevo campo agregado
    private String cargo;  // ✅ Nuevo campo agregado
    private String cedula; // ✅ Nuevo campo agregado

    // Constructor vacío necesario para Spring
    public User() {}

    public User(int id, String name, double salary, String area, String cargo, String cedula) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.area = area;
        this.cargo = cargo;
        this.cedula = cedula;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    // Método para calcular la prima
    public double getPrima() {
        return salary / 2; // La prima equivale a medio salario mensual
    }
}