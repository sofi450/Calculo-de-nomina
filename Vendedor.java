public class Vendedor extends Empleado {
    private int totalVentas;
    private long valorComision;

    public Vendedor(int id, String nombre, int anioIngreso, double salarioBase, int totalVentas) {
        super(id, nombre, anioIngreso, salarioBase);
        this.totalVentas = totalVentas;
        this.valorComision = calcularComision(totalVentas);
    }

    public long calcularComision(int totalVentas) {
        // Comisión del 5% sobre el total de ventas
        return (long)(totalVentas * 0.05);
    }

    @Override
    public double calcularPagoMensual(Empleado e) {
        Vendedor v = (Vendedor) e;
        double descuento = calcularDescuento(v.getSalarioBase());
        v.setDescuentos(descuento);
        double pago = v.getSalarioBase() + v.calcularComision(v.getTotalVentas()) - descuento;
        v.setPagoNeto(pago);
        return pago;
    }

    @Override
    public int calcularBonificacion(Empleado e) {
        int aniosServicio = ConstantesNomina.ANIO_ACTUAL - e.getAnioIngreso();
        return aniosServicio * 100; // $100 por año de servicio
    }

    // Getters y Setters
    public int getTotalVentas() { return totalVentas; }
    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
        this.valorComision = calcularComision(totalVentas);
    }

    public long getValorComision() { return valorComision; }

    @Override
    public String toString() {
        return "Vendedor{id=" + id + ", nombre='" + nombre + "', totalVentas=" + totalVentas
                + ", valorComision=" + valorComision + ", pagoNeto=" + pagoNeto + "}";
    }
}
