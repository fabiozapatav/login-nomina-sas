package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void testControllerNotNull() {
        UserController controller = new UserController();
        assertNotNull(controller, "El controlador no debería ser nulo");
    }

    @Test
    void testCreateUser() {
        UserController controller = new UserController();
        List<User> newUsers = List.of(new User(1, "Juan", 2000.0, "TI", "Dev", "123456"));
        String response = controller.createUser(newUsers);

        assertEquals("Usuarios creados correctamente", response);
        assertFalse(controller.getUsers().isEmpty(), "La lista de usuarios no debería estar vacía");
    }

    @Test
    void testDeleteUser() {
        UserController controller = new UserController();
        controller.createUser(List.of(new User(1, "Juan", 2000.0, "TI", "Dev", "123456")));
        String response = controller.deleteUser(1);

        assertEquals("Usuario con ID 1 eliminado correctamente", response);
        assertTrue(controller.getUsers().isEmpty(), "La lista de usuarios debería estar vacía");
    }
}