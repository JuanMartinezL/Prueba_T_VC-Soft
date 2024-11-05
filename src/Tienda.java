import java.util.ArrayList;
import java.util.List;

public class Tienda {
    // Lista para almacenar los productos disponibles en la tienda
    private List<Producto> productos = new ArrayList<>();

    /**
     * Agregamos un nuevo producto a la tienda.
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    /**
     * Obtenemos un producto por su ID.
     * @param id .
     * @return El producto con el ID especificado, o null si no se encuentra.
     */
    public Producto obtenerProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Retorna null si no encuentra el producto
    }

    /**
     * Actualiza un producto existente en la tienda.
     * @param id
     * @param nuevoProducto El producto con los nuevos datos a actualizar.
     */
    public void actualizarProducto(int id, Producto nuevoProducto) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(nuevoProducto.getNombre());
                producto.setDescripcion(nuevoProducto.getDescripcion());
                producto.setPrecio(nuevoProducto.getPrecio());
                producto.setCantidad(nuevoProducto.getCantidad());
                System.out.println("Producto actualizado: " + nuevoProducto.getNombre());
                return;
            }
        }
        System.out.println("Producto no encontrado con ID: " + id);
    }

    /**
     * Eliminamos un producto de la tienda por su ID.
     * @param id El ID del producto a eliminar.
     */
    public void eliminarProducto(int id) {
        boolean eliminado = productos.removeIf(producto -> producto.getId() == id);
        if (eliminado) {
            System.out.println("Producto eliminado con ID: " + id);
        } else {
            System.out.println("Producto no encontrado con ID: " + id);
        }
    }

    /**
     * Obtenemos el producto cuyo nombre tiene la menor cantidad de consonantes.
     * @return El producto con el menor número de consonantes en su nombre, o null si la lista está vacía.
     */
    public Producto obtenerProductoConMenosConsonantes() {
        Producto productoConMenosConsonantes = null;
        int menorCantidad = Integer.MAX_VALUE; // Inicializamos con un valor alto para encontrar el mínimo
        for (Producto producto : productos) {
            int consonantes = contarConsonantes(producto.getNombre());
            if (consonantes < menorCantidad) {
                menorCantidad = consonantes;
                productoConMenosConsonantes = producto;
            }
        }
        return productoConMenosConsonantes;
    }

    /**
     * Contamos la cantidad de consonantes en el nombre del producto.
     * @param nombre  nombre del producto.
     * @return La cantidad de consonantes en el nombre.
     */
    private int contarConsonantes(String nombre) {
        return nombre.replaceAll("(?i)[^bcdfghjklmnpqrstvwxyz]", "").length(); // Elimina caracteres no consonantes
    }

    /**
     * Encontramos el número primo más cercano al precio mínimo de los productos en la tienda.
     * @return El número primo más cercano al precio mínimo.
     */
    public int encontrarPrimoMasCercanoAlPrecioMinimo() {
        double precioMinimo = Double.MAX_VALUE;
        for (Producto producto : productos) {
            if (producto.getPrecio() < precioMinimo) {
                precioMinimo = producto.getPrecio();
            }
        }
        return encontrarPrimoMasCercano((int) Math.floor(precioMinimo));
    }

    /**
     * Encontramos el número primo más cercano a un número dado.
     * Si existen dos números primos a la misma distancia, elige el menor.
     * @param num El número base para encontrar el primo más cercano.
     * @return El número primo más cercano.
     */
    private int encontrarPrimoMasCercano(int num) {
        int menor = num, mayor = num;
        while (!esPrimo(menor) && menor > 1) { // Busca hacia abajo
            menor--;
        }
        while (!esPrimo(mayor)) { // Buscara hacia arriba
            mayor++;
        }
        return (num - menor <= mayor - num) ? menor : mayor; // Retorna el primo más cercano
    }

    /**
     * Verificamos si un número es primo.
     * @param num  número a verificar.
     * @return true si el número es primo, false en caso contrario.
     */
    private boolean esPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Sumamos la cantidad total de todos los productos en la tienda de forma recursiva.
     * @param index El índice inicial para comenzar la suma.
     * @return La suma total de la cantidad de todos los productos.
     */
    public int sumarCantidadTotalProductos(int index) {
        if (index >= productos.size()) {
            return 0; // Caso base: no quedan productos por sumar
        }
        return productos.get(index).getCantidad() + sumarCantidadTotalProductos(index + 1); // Llamada recursiva
    }
}
