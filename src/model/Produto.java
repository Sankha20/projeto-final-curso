package model;

/**
 *
 * @author Rodrigo
 */
public class Produto {
    int id;
    String album;
    String compositor;
    String midia;
    String genero;
    double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
     public Object[] formatoTabela() {
        return new Object[]{
            getId(),
            getAlbum(),
            getCompositor(),
            getMidia(),
            getGenero(),
            getPreco(),
        };
    }    
}
