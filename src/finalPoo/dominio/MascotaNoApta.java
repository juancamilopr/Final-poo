package finalPoo.dominio;

public class MascotaNoApta extends Mascota{
    public MascotaNoApta(String nombre, String sexo, int edad, boolean esterilizado) {
        super(nombre, sexo, edad, esterilizado);
    }

    @Override
    public String toString() {
        return "Nombre:" + getNombre() + ", sexo" + getSexo() + ", edad:" + getEdad() + ", necesita esterilizacion" + isEsterilizado() + ". Es una mascota no apta";
    }
}
