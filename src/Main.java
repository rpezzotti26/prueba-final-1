import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private ArrayList<Colmena> colmenas;
    private ArrayList<Apicultor> apicultores;

    public Main() {
        colmenas = new ArrayList<>();
        apicultores = new ArrayList<>();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean enFuncionamiento = true;

        while (enFuncionamiento) {
            System.out.println("\nMenú de Gestión de Colmenas:");
            System.out.println("1. Añadir Colmena");
            System.out.println("2. Registrar Inspección");
            System.out.println("3. Mostrar Colmenas");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarColmena(scanner);
                    break;
                case 2:
                    registrarInspeccion(scanner);
                    break;
                case 3:
                    mostrarColmenas();
                    break;
                case 4:
                    enFuncionamiento = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private void agregarColmena(Scanner scanner) {
        System.out.println("Añadir nueva colmena:");
        System.out.print("ID: ");
        String id = scanner.next();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.next();
        System.out.print("Estado de Salud: ");
        String estadoSalud = scanner.next();
        System.out.print("Cantidad de Abejas: ");
        int cantidadAbejas = scanner.nextInt();
        System.out.print("Producción de Miel: ");
        double produccionMiel = scanner.nextDouble();
        System.out.print("Edad de la Abeja Reina: ");
        int edadReina = scanner.nextInt();
        System.out.print("Productividad de la Abeja Reina: ");
        double productividadReina = scanner.nextDouble();
        System.out.print("Estado de Salud de la Abeja Reina: ");
        String estadoSaludReina = scanner.next();

        AbejaReina abejaReina = new AbejaReina(edadReina, productividadReina, estadoSaludReina);
        Colmena colmena = new Colmena(id, ubicacion, estadoSalud, cantidadAbejas, produccionMiel, abejaReina);
        colmenas.add(colmena);

        System.out.println("Colmena añadida exitosamente.");
    }

    private void registrarInspeccion(Scanner scanner) {
        System.out.print("Ingrese el ID de la colmena a inspeccionar: ");
        String id = scanner.next();
        Colmena colmena = buscarColmenaPorId(id);

        if (colmena != null) {
            System.out.print("Fecha de la inspección (yyyy-MM-dd): ");
            String fechaStr = scanner.next();
            Date fecha = null;
            try {
                fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido.");
                return;
            }
            System.out.print("Resultado de la inspección: ");
            String resultado = scanner.next();
            System.out.print("Acciones tomadas: ");
            String acciones = scanner.next();
            Inspeccion inspeccion = new Inspeccion(fecha, resultado, acciones);
            colmena.agregarInspeccion(inspeccion);
            colmena.actualizarEstadoSalud(resultado);

            System.out.println("Inspección registrada exitosamente.");
        } else {
            System.out.println("Colmena no encontrada.");
        }
    }

    private void mostrarColmenas() {
        if (colmenas.isEmpty()) {
            System.out.println("No hay colmenas registradas.");
        } else {
            for (Colmena colmena : colmenas) {
                System.out.println(colmena);
            }
        }
    }

    private Colmena buscarColmenaPorId(String id) {
        for (Colmena colmena : colmenas) {
            if (colmena.getId().equals(id)) {
                return colmena;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.iniciar();
    }
}
