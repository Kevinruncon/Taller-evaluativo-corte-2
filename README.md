# Taller-evaluativo-corte-2
# Gestión de Reservas de Hotel

Este proyecto es una aplicación de escritorio desarrollada en Java para gestionar las reservas de un hotel. Implementa un enfoque modular usando el patrón MVC (Modelo-Vista-Controlador), y se apoya en clases DAO, DTO y control de excepciones personalizadas.

## 🧱 Estructura del Proyecto

- **Modelo**: Clases que representan entidades del sistema (`Habitacion`, `Huesped`, `Reserva`, etc.).
- **Vista**: Interfaces gráficas (`VentanaPrincipal`, `VentanaRegistro`) para interacción con el usuario.
- **Controlador**: Lógica que conecta modelo y vista (`ControladorReserva`, `ControladorHuesped`, etc.).
- **DAO & DTO**: Acceso y transporte de datos entre capas.
- **Excepciones**: Clases para manejar errores específicos (como `ReservaException`, `IdentificadorException`).
