package finalPoo.dominio;

public class MascotaEsterilizada extends Mascota{

    public MascotaEsterilizada(String nombre, String sexo, int edad, boolean esterilizado) {
        super(nombre, sexo, edad, esterilizado);
    }

    @Override
    public String toString() {
        return "Nombre:" + getNombre() + ", sexo" + getSexo() + ", edad:" + getEdad() + ", necesita esterilizacion" + isEsterilizado() + ". Es una mascota esterilizada";
    }
}
