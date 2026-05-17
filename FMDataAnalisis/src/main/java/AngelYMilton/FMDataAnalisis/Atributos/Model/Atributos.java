package AngelYMilton.FMDataAnalisis.Atributos.Model;

import AngelYMilton.FMDataAnalisis.Jugador.Model.Jugador;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Atributos del jugador")
@Getter
@Setter
public class Atributos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Fisicos
    private int Aceleracion;
    private int Agilidad;
    private int AlcanceDeSalto;
    private int Equilibrio;
    private int Fuerza;
    private int RecuperacionFisica;
    private int Resistencia;
    private int Velocidad;
    // Mental
    private int Agresividad;
    private int Anticipacion;
    private int Colocacion;
    private int Concentracion;
    private int Decisiones;
    private int Desmarques;
    private int Determinacion;
    private int JuegoEnEquipo;
    private int Liderazgo;
    private int Sacrificio;
    private int Serenidad;
    private int Talento;
    private int Valentia;
    private int Vision;
    // Tecnico
    private int Cabeceo;
    private int Centro;
    private int Entradas;
    private int Marcaje;
    private int Pases;
    private int Penaltis;
    private int Regate;
    private int Remate;
    private int SaquesDeEsquina;
    private int SaquesLargos;
    private int Tecnica;
    private int TirosLejanos;
    private int TirosLibres;

    @OneToOne
    @JoinColumn(name = "jugador_id", nullable = false, unique = true)
    private Jugador jugador;

    public Atributos() {
    }
}
