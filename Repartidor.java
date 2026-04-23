public class Repartidor extends Empleado {
    private int numeroRepartos;
    private long valorRepartosPagados;
    private Zona zona;

    public Repartidor(int id, String nombre, int anioIngreso, double salarioBase,
                      int numeroRepartos, Zona zona) {
        super(id, nombre, anioIngreso, salarioBase);
        this.numeroRepartos = numeroRepartos;
        this.zona = zona;
        this.valorRepartosPagados = calcularValorRepartos(numeroRepartos);
    }

    public long calcularValorRepartos(int numeroRepartos) {
        // Valor por reparto según zona
        long valorPorReparto;
        switch (zona) {
            case A: valorPorReparto = 5000; break;
            case B: valorPorReparto = 4000; break;
            case C: valorPorReparto = 3000; break;
            case D: valorPorReparto = 2000; break;
            default: valorPorReparto = 2000;
        }
        return numeroRepartos * valorPorReparto;
    }

    public void validarZona() {
        if (zona == null) {
            throw new IllegalStateException("La zona del repartidor no puede ser nula.");
        }
        System.out.println("Zona válida: " + zona);
    }

    @Override
    public double calcularPagoMensual(Empleado e) {
        Repartidor r = (Repartidor) e;
        double descuento = calcularDescuento(r.getSalarioBase());
        r.setDescuentos(descuento);
        double pago = r.getSalarioBase() + r.calcularValorRepartos(r.getNumeroRepartos()) - descuento;
        r.setPagoNeto(pago);
        return pago;
    }

    @Override
    public int calcularBonificacion(Empleado e) {
        int aniosServicio = ConstantesNomina.ANIO_ACTUAL - e.getAnioIngreso();
        return aniosServicio * 80; // $80 por año de servicio
    }

    // Getters y Setters
    public int getNumeroRepartos() { return numeroRepartos; }
    public void setNumeroRepartos(int numeroRepartos) {
        this.numeroRepartos = numeroRepartos;
        this.valorRepartosPagados = calcularValorRepartos(numeroRepartos);
    }

    public long getValorRepartosPagados() { return valorRepartosPagados; }

    public Zona getZona() { return zona; }
    public void setZona(Zona zona) { this.zona = zona; }

    @Override
    public String toString() {
        return "Repartidor{id=" + id + ", nombre='" + nombre + "', zona=" + zona
                + ", numeroRepartos=" + numeroRepartos + ", pagoNeto=" + pagoNeto + "}";
    }
}
