public class Producto {
    // Atributos de los productos
    private final int id;  // Lo defino como final ya que el ID no  debemos modificarlo
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    /**
     * Constructor para inicializar todos los atributos de un producto.
     * incluyo validación en los setters para asegurar que los  valores sean válidos.
     *
     * @param id El identificador único del producto.
     * @param nombre El nombre del producto.
     * @param descripcion La descripción del producto.
     * @param precio El precio del producto.
     * @param cantidad La cantidad disponible en inventario.
     */
    public Producto(int id, String nombre, String descripcion, double precio, int cantidad) {
        this.id = id;  // ID es final y no se puede modificar después de que lo  asignemos
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCantidad(cantidad);
    }

    // Getters para acceder a los atributos del producto
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    // Setters con validación para garantizar que los valores sean consistentes y válidos

    /**
     * Establesco el nombre del producto, asegurándome de que no esté vacío ni nulo.
     * @param nombre El nombre del producto.
     * @throws IllegalArgumentException si el nombre es nulo o está vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Establesco la descripción del producto, asegurándome de que no esté vacía ni nula.
     * @param descripcion  descripción del producto.
     * @throws IllegalArgumentException si la descripción es nula o está vacía.
     */
    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    /**
     * Establesco el precio del producto, asegurándome de que no sea negativo.
     * @param precio precio del producto.
     * @throws IllegalArgumentException si el precio es negativo.
     */
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Estableci la cantidad disponible en inventario del producto, asegurándome de que no sea negativa.
     * @param cantidad La cantidad del producto.
     * @throws IllegalArgumentException si la cantidad es negativa.
     */
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    /**
     * Método toString que devuelve una representación en cadena de un producto.
     * Incluye todos los atributos del producto para una salida detallada.
     *
     * @return Una cadena que representa al producto.
     */
    @Override
    public String toString() {
        return "Producto [ID=" + id + ", Nombre=" + nombre + ", Descripción=" + descripcion +
                ", Precio=$" + precio + ", Cantidad=" + cantidad + "]";
    }
}
