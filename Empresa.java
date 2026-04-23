import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> listaEmpleados;

    public Empresa() {
        this.listaEmpleados = new ArrayList<>();
    }

    public Empleado buscarEmpleado(int id) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void liquidarNomina(List<Empleado> lista) {
        System.out.println("===== LIQUIDACIÓN DE NÓMINA =====");
        System.out.printf("%-5s %-20s %-15s %-12s %-12s %-12s%n",
                "ID", "Nombre", "Tipo", "Salario Base", "Descuentos", "Pago Neto");
        System.out.println("-".repeat(80));

        for (Empleado emp : lista) {
            double pagoMensual = emp.calcularPagoMensual(emp);
            int bonificacion = emp.calcularBonificacion(emp);

            String tipo = emp instanceof Vendedor ? "Vendedor" : "Repartidor";
            System.out.printf("%-5d %-20s %-15s %-12.2f %-12.2f %-12.2f%n",
                    emp.getId(), emp.getNombre(), tipo,
                    emp.getSalarioBase(), emp.getDescuentos(), emp.getPagoNeto());
            System.out.printf("      Bonificación por antigüedad: $%d%n", bonificacion);
        }

        System.out.println("-".repeat(80));
        double totalNomina = lista.stream().mapToDouble(Empleado::getPagoNeto).sum();
        System.out.printf("TOTAL NÓMINA: $%.2f%n", totalNomina);
    }

    public void agregarEmpleado(Empleado emp) {
        listaEmpleados.add(emp);
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        // Crear empleados de prueba
        Vendedor v1 = new Vendedor(1, "Ana García", 2018, 3000000, 50000000);
        Vendedor v2 = new Vendedor(2, "Carlos López", 2020, 2800000, 35000000);
        Repartidor r1 = new Repartidor(3, "Luis Martínez", 2015, 2500000, 120, Zona.A);
        Repartidor r2 = new Repartidor(4, "María Torres", 2021, 2300000, 95, Zona.C);

        empresa.agregarEmpleado(v1);
        empresa.agregarEmpleado(v2);
        empresa.agregarEmpleado(r1);
        empresa.agregarEmpleado(r2);

        // Liquidar nómina
        empresa.liquidarNomina(empresa.getListaEmpleados());

        // Buscar un empleado
        System.out.println("\n===== BÚSQUEDA DE EMPLEADO =====");
        Empleado encontrado = empresa.buscarEmpleado(3);
        if (encontrado != null) {
            System.out.println("Empleado encontrado: " + encontrado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}
