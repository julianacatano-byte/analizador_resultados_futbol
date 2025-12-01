import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorResultados gestor = new GestorResultados();
        Scanner sc = new Scanner(System.in);

        gestor.cargarCSV("results.csv");

        System.out.print("Ingrese el nombre del equipo: ");
        String equipo = sc.nextLine();

        EstadisticasEquipo est = gestor.obtenerEstadisticas(equipo);

        System.out.println("\n--- Estadísticas de " + equipo + " ---");
        System.out.println("Victorias: " + est.getVictorias());
        System.out.println("Derrotas: " + est.getDerrotas());
        System.out.println("Empates: " + est.getEmpates());
        System.out.println("Goles a favor: " + est.getGolesAFavor());
    }
}
