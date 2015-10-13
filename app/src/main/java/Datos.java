/**
 * Created by Javier on 07/10/15.
 */
public class Datos
{
    private int categoria;
    private String frase;

    public Datos(int categoria, String frase)
    {
        this.categoria = categoria;
        this.frase = frase;
    }

    public void setCategoria(int categoria)
    {
        this.categoria = categoria;
    }

    public void setFrase(String frase)
    {
        this.frase = frase;
    }

    public int getCategoria()
    {
        return categoria;
    }

    public String getFrase()
    {
        return frase;
    }
}