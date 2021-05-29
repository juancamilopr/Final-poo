package finalPoo.dominio;

public class MascotaApta extends Mascota implements Operable {

    public MascotaApta(String nombre, String sexo, int edad, boolean esterilizado) {
        super(nombre, sexo, edad, esterilizado);
    }

    @Override
    public void operar() {
        this.setEsterilizado(false);
    }

    @Override
    public String toString() {
        return "Nombre:" + getNombre() + ", sexo" + getSexo() + ", edad:" + getEdad() + ", necesita esterilizacion" + isEsterilizado() + ". Es una mascota apta";
    }
}
