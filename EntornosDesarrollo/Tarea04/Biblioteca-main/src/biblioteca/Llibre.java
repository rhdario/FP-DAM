package biblioteca; // 1. Mover clases al paquete biblioteca (Declaración del paquete)

public class Llibre {
    private String titol; // 4. Encapsular atributos (Atributo privado)
    private String autor; // 4. Encapsular atributos (Atributo privado)
    private int exemplars; // 4. Encapsular atributos (Atributo privado)
    private float preu; // 4. Encapsular atributos (Atributo privado)

    public Llibre(String titol, String autor, int exemplars, float preu) {
        this.titol = titol;
        this.autor = autor;
        this.exemplars = exemplars;
        this.preu = preu;
    }

    public void prestarLlibre(int quantitat) throws Exception {
        if (getExemplars() >= quantitat) {
            setExemplars(getExemplars() - quantitat);
            System.out.println("S'han prestat " + quantitat + " exemplars.");
        } else {
            throw new Exception("No hi ha prou exemplars disponibles.");
        }
    }

    public void retornarLlibre(int quantitat) {
        setExemplars(getExemplars() + quantitat);
        System.out.println("S'han retornat " + quantitat + " exemplars.");
    }

    public void mostrarDades() {
        System.out.println("Títol: " + getTitol());
        System.out.println("Autor: " + getAutor());
        System.out.println("Exemplars: " + getExemplars());
        System.out.println("Preu: " + getPreu() + " €");
    }

    /**
     * @return the titol
     */
    public String getTitol() { // 4. Encapsular atributos (Getter generado)
        return titol;
    }

    /**
     * @param titol the titol to set
     */
    public void setTitol(String titol) { // 4. Encapsular atributos (Setter generado)
        this.titol = titol;
    }

    /**
     * @return the autor
     */
    public String getAutor() { // 4. Encapsular atributos (Getter generado)
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) { // 4. Encapsular atributos (Setter generado)
        this.autor = autor;
    }

    /**
     * @return the exemplars
     */
    public int getExemplars() { // 4. Encapsular atributos (Getter generado)
        return exemplars;
    }

    /**
     * @param exemplars the exemplars to set
     */
    public void setExemplars(int exemplars) { // 4. Encapsular atributos (Setter generado)
        this.exemplars = exemplars;
    }

    /**
     * @return the preu
     */
    public float getPreu() { // 4. Encapsular atributos (Getter generado)
        return preu;
    }

    /**
     * @param preu the preu to set
     */
    public void setPreu(float preu) { // 4. Encapsular atributos (Setter generado)
        this.preu = preu;
    }
}
