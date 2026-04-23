public abstract class Empleado {
    protected int id;
    protected String nombre;
    protected int anioIngreso;
    protected double salarioBase;
    protected double descuentos;
    protected double pagoNeto;

    public Empleado(int id, String nombre, int anioIngreso, double salarioBase) {
        this.id = id;
        this.nombre = nombre;
        this.anioIngreso = anioIngreso;
        this.salarioBase = salarioBase;
        this.descuentos = 0;
        this.pagoNeto = 0;
    }

    public abstract double calcularPagoMensual(Empleado e);

    public double calcularDescuento(double salarioBase) {
        return salarioBase * ConstantesNomina.TASA_PRESTACIONES;
    }

    public abstract int calcularBonificacion(Empleado e);

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAnioIngreso() { return anioIngreso; }
    public void setAnioIngreso(int anioIngreso) { this.anioIngreso = anioIngreso; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public double getDescuentos() { return descuentos; }
    public void setDescuentos(double descuentos) { this.descuentos = descuentos; }

    public double getPagoNeto() { return pagoNeto; }
    public void setPagoNeto(double pagoNeto) { this.pagoNeto = pagoNeto; }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "', salarioBase=" + salarioBase + "}";
    }
}
