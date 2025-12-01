public class EstadisticasEquipo {
    private int victorias;
    private int derrotas;
    private int empates;
    private int golesAFavor;

    public void sumarVictoria() {
        victorias++;
    }

    public void sumarDerrota() {
        derrotas++;
    }

    public void sumarEmpate() {
        empates++;
    }

    public void sumarGoles(int goles) {
        golesAFavor += goles;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }
}
