import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GestorResultados {

    private List<Partido> partidos = new ArrayList<>();

    // Cargar archivo CSV
    public void cargarCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;
            br.readLine(); // Saltar el encabezado del CSV

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String local = datos[0];
                String visitante = datos[1];
                int golesLocal = Integer.parseInt(datos[2]);
                int golesVisitante = Integer.parseInt(datos[3]);

                partidos.add(new Partido(local, visitante, golesLocal, golesVisitante));
            }

            System.out.println("Archivo CSV cargado correctamente.");

        } catch (Exception e) {
            System.out.println("Error cargando CSV: " + e.getMessage());
        }
    }

    // Obtener estadísticas de un equipo
    public EstadisticasEquipo obtenerEstadisticas(String equipo) {
        EstadisticasEquipo est = new EstadisticasEquipo();

        for (Partido p : partidos) {

            if (p.getEquipoLocal().equalsIgnoreCase(equipo)) {

                est.sumarGoles(p.getGolesLocal());

                if (p.getGolesLocal() > p.getGolesVisitante()) {
                    est.sumarVictoria();
                } else if (p.getGolesLocal() < p.getGolesVisitante()) {
                    est.sumarDerrota();
                } else {
                    est.sumarEmpate();
                }

            } else if (p.getEquipoVisitante().equalsIgnoreCase(equipo)) {

                est.sumarGoles(p.getGolesVisitante());

                if (p.getGolesVisitante() > p.getGolesLocal()) {
                    est.sumarVictoria();
                } else if (p.getGolesVisitante() < p.getGolesLocal()) {
                    est.sumarDerrota();
                } else {
                    est.sumarEmpate();
                }
            }
        }

        return est;
    }
}
