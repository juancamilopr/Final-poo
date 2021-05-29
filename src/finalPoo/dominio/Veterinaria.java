package finalPoo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Veterinaria {
    public String nombre;
    private ArrayList<Mascota> mascotas;

    public Veterinaria(){
        this.mascotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public Mascota revisarMascota(String nombre, String sexo, int edad){
        boolean necesitaEsterilizacion;

        if(sexo.toLowerCase().contains("macho") && edad > 12){     //   1 año = 12 meses
            necesitaEsterilizacion = true;
            MascotaApta mascotaApta = new MascotaApta(nombre,sexo, edad, necesitaEsterilizacion);
            this.mascotas.add(mascotaApta);
            return mascotaApta;
        }
        else if(sexo.toLowerCase().contains("hembra") && edad > 18){
            necesitaEsterilizacion = true;
            MascotaApta mascotaApta = new MascotaApta(nombre,sexo,edad,necesitaEsterilizacion);
            this.mascotas.add(mascotaApta);
            return mascotaApta;
        }

        else{
            necesitaEsterilizacion = false;
            MascotaNoApta mascotaNoApta = new MascotaNoApta(nombre,sexo,edad, necesitaEsterilizacion);
            this.mascotas.add(mascotaNoApta);
            return mascotaNoApta;


        }
    }

    public void operarPacientes(){
        getMascotas().forEach(mascota ->{
            boolean sePuedeOperar = mascotas.stream().anyMatch(j -> j.isEsterilizado() == mascota.isEsterilizado());
            boolean tipoDeSexo = mascota.getSexo().toLowerCase().contains("macho");
            boolean tipoDeSexo2 = mascota.getSexo().toLowerCase().contains("hembra");

            if(mascota instanceof MascotaApta && sePuedeOperar && mascota.getEdad() > 12 && tipoDeSexo == true){
                ((MascotaApta) mascota).operar();
                System.out.println("La mascota:" + getNombre() + "de sexo:" + mascota.getSexo() + "con edad de:" + mascota.getEdad() + "meses. Ha sido esterilizada");
            }

            else if(mascota instanceof MascotaApta && sePuedeOperar && mascota.getEdad() > 18 && tipoDeSexo2 == true){
                ((MascotaApta) mascota).operar();
                System.out.println("La mascota:" + getNombre() + "de sexo:" + mascota.getSexo() + "con edad de:" + mascota.getEdad() + "meses. Ha sido esterilizada");
            }

            else if(mascota.getEdad() <= 12 && tipoDeSexo == true) {
                ((MascotaApta) mascota).operar();
                System.out.println("La mascota:" + getNombre() + "de sexo:" + mascota.getSexo() + "con edad de:" + mascota.getEdad() + "meses. No se puede esterilizar por su edad");
            }

            else if(mascota.getEdad() <= 18 && tipoDeSexo2 == true) {
                ((MascotaApta) mascota).operar();
                System.out.println("La mascota:" + getNombre() + "de sexo:" + mascota.getSexo() + "con edad de:" + mascota.getEdad() + "meses. No se puede esterilizar por su edad");

                //Si la mascota ya esta esterilizada no tiene sentido que la vallan a operar xd , asi que lo omiti
            }
        });
    }

    public List<MascotaApta> getPacientesAOperar(){

        List<MascotaApta> mascotaAptas = new ArrayList<>();
        getMascotas().forEach(mascota ->{
            boolean sePuedeOperar1 = mascotas.stream().anyMatch(Mascota::isEsterilizado);
            if(mascota instanceof MascotaApta && sePuedeOperar1 == true){
                mascotaAptas.add((MascotaApta) mascota);
            }
        });
        return mascotaAptas;
    }
}
