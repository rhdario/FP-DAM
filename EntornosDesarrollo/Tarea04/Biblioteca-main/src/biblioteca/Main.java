package biblioteca; // 1. Mover clases al paquete biblioteca (Declaración del paquete)


import biblioteca.Llibre;

public class Main {
    public static void main(String[] args) {
        Llibre llibrePrincipal = new Llibre("Tirant lo Blanc", "Joanot Martorell", 10, 19.95f);

        gestionarLlibre(llibrePrincipal, 3, 2);  // 3. Crear método gestionarLlibre (Llamada al método extraído)
    }

    private static void gestionarLlibre(Llibre llibrePrincipal, int quantitatAPrestar, int quantitatARetornar) {// 3. Crear método gestionarLlibre (Método que gestiona las operaciones del libro)
        llibrePrincipal.mostrarDades();
        System.out.println();
        try {
            llibrePrincipal.prestarLlibre(quantitatAPrestar); // 5. Usar parámetro quantitatAPrestar (Cantidad variable de préstamo)
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        llibrePrincipal.retornarLlibre(quantitatARetornar);  // 5. Usar parámetro quantitatARetornar (Cantidad variable de devolución)
        System.out.println();
        llibrePrincipal.mostrarDades();
    }
}
