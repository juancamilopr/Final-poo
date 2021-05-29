package finalPoo.app;

import finalPoo.dominio.Veterinaria;

public class AppClinicaVeterinaria {
    public static void main(String[] args) {
        Veterinaria veterinaria = new Veterinaria();

        System.out.println(veterinaria.revisarMascota("luna", "hembra", 20));
        System.out.println(veterinaria.revisarMascota("niña", "hembra", 25));
        System.out.println(veterinaria.revisarMascota("kiara", "hembra", 21));
        System.out.println(veterinaria.revisarMascota("tobby", "macho", 30));
        System.out.println(veterinaria.revisarMascota("aquiles", "macho", 45));
        System.out.println(veterinaria.revisarMascota("piolin", "macho", 26));

        System.out.println("\n");
        System.out.println("Las mascotas aptas para operarse son:");
        System.out.println(veterinaria.getPacientesAOperar());

        System.out.println("\n");
        System.out.println("Los que pueden operarse o no son:");
        veterinaria.operarPacientes();



    }
}
