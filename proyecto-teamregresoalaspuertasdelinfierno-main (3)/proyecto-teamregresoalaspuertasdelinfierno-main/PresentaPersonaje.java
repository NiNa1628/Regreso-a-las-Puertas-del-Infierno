import greenfoot.*;  // Importar las clases de Greenfoot
import java.util.List;
import java.util.Arrays;
import java.io.File;

/**
 * Clase que presenta a los personajes (Actores) del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class PresentaPersonaje extends World 
{   
    private RestableceImagenPersonaje per;
    private int cant;
    private List<String> actores;
    private boolean ultimaImagen = false;

    /**
     * Constructor de la clase Presentacion
     */
    public PresentaPersonaje() 
    {
        super(600, 700, 1); 

        per = new RestableceImagenPersonaje();
        cant = 0;
        actores = Arrays.asList("a1.png", "a2.png", "a3.png", "a4.png", "a5.png",
        "a6.png", "a7.png");
        addObject(per, getWidth(), getHeight());
        per.setLocation(300, 350);
        actualizarImagen();

        SiguientePersonaje sigPCP = new SiguientePersonaje(this);
        addObject(sigPCP, getWidth() - 50, getHeight() /2);
        sigPCP.setLocation(500, 500);
    }

    /**
     *  Se encarga de pasar a la siguiente imagen de la presentacion. 
     */
    public void siguienteImagen() {
        if(!ultimaImagen){
            cant = (cant + 1) % actores.size(); // Avanzar al siguiente �ndice, con bucle
            actualizarImagen();
        }
    }
    
    /**
     * Regresa la cantidad de imagenes que hay en el arreglo.
     * @return imagenes.size() tamanio del arreglo.
     */
    public int cantImagenes()
    {
        return actores.size();
    }

    /**
     * Actualiza la imagen mostrada en la presentacion.
     */
    private void actualizarImagen() 
    {
        if (cant < cantImagenes()) {
            per.establecerImagen2(actores.get(cant));
        }else{
            ultimaImagen = true;
        }
        if(cant == 6 && !ultimaImagen)
        {
            CambiaMundo cambiaM = new CambiaMundo("Personajes");
            cambiaM.setImage("Play.png");
            addObject(cambiaM, getWidth() - 50, getHeight() /2);
            cambiaM.setLocation(300, 500);
        }
    }
}
