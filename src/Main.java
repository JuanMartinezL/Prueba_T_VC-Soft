import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        inicializarDatos(tienda);

        // Crear productos
        Producto producto1 = new Producto(1, "Laptop", "Laptop de alta gama", 1200.00, 5);
        Producto producto2 = new Producto(2, "Mouse", "Mouse óptico", 20.00, 15);
        Producto producto3 = new Producto(3, "Teclado", "Teclado mecanico", 50.00, 2);

        // Agregar productos a la tienda
        for (Producto producto : Arrays.asList(producto1, producto2, producto3)) {
            tienda.agregarProducto(producto);
        }

        // Obtener y mostrar un producto específico
        mostrarProducto(tienda, 1);

        // Actualizar un producto existente
        tienda.actualizarProducto(1, new Producto(1, "Laptop Pro", "Laptop mejorada", 1300.00, 4));
        System.out.println("Producto actualizado.");

        // Eliminar un producto
        tienda.eliminarProducto(2);
        System.out.println("Producto eliminado.");

        // Calcular y mostrar cantidad total de productos (usando método recursivo)
        int cantidadTotal = tienda.sumarCantidadTotalProductos(0);
        System.out.println("Cantidad total de productos en inventario: " + cantidadTotal);

        // Obtener y mostrar el producto con menos consonantes
        Producto menosConsonantes = tienda.obtenerProductoConMenosConsonantes();
        System.out.println("Producto con menos consonantes en su nombre: " +
                (menosConsonantes != null ? menosConsonantes.getNombre() : "No encontrado"));

        // Calcular y mostrar el número primo más cercano al precio más bajo
        int primoMasCercano = tienda.encontrarPrimoMasCercanoAlPrecioMinimo();
        System.out.println("Primo más cercano al precio más bajo: " + primoMasCercano);
    }

    private static void inicializarDatos(Tienda tienda) {
        Producto producto1 = new Producto(1, "Laptop", "Laptop de alta gama", 1200.00, 5);
        Producto producto2 = new Producto(2, "Mouse", "Mouse óptico", 20.00, 15);
        Producto producto3 = new Producto(3, "Teclado", "Teclado mecanico Razer5 ", 40.00, 19);

        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);

        System.out.println("Datos iniciales cargados.");
    }

    private static void mostrarProducto(Tienda tienda, int idProducto) {
        Producto obtenido = tienda.obtenerProducto(idProducto);
        if (obtenido != null) {
            System.out.println("Producto obtenido: " + obtenido.getNombre() +
                    " | Descripción: " + obtenido.getDescripcion() +
                    " | Precio: $" + obtenido.getPrecio() +
                    " | Cantidad: " + obtenido.getCantidad());
        } else {
            System.out.println("Producto con ID " + idProducto + " no encontrado.");
        }
    }
}
