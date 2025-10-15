import greenfoot.*;  // Importar las clases de Greenfoot
import java.util.List;
import java.util.Arrays;
import java.io.File;

/**
 * Clase que presenta la historia del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class PresentaHistoria extends World 
{   
    private RestableceImagenHistoria pres;
    private int cont;
    private List<String> imagenes;
    private boolean ultimaImagen = false;

    /**
     * Constructor de la clase PresentaHistoria
     */
    public PresentaHistoria() 
    {
        super(600, 700, 1); 

        pres = new RestableceImagenHistoria();
        cont = 0;
        imagenes = Arrays.asList("p1.png", "p2.png", "p3.png", "p4.png", "p5.png",
        "p6.png", "p7.png", "p8.png","p9.png");
        addObject(pres, getWidth(), getHeight());
        pres.setLocation(300, 350);
        actualizarImagen();

        SiguienteParteDeLaHistoria sig = new SiguienteParteDeLaHistoria(this);
        addObject(sig, getWidth() - 50, getHeight() /2);
        sig.setLocation(500, 500);
    }

    /**
     *  Se encarga de pasar a la siguiente imagen de la presentacion de la historia. 
     */
    public void siguienteImagen() {
        if(!ultimaImagen){
            cont = (cont + 1) % imagenes.size(); // Avanzar al siguiente �ndice, con bucle
            actualizarImagen();
        }
    }
    
    /**
     * Regresa la cantidad de imagenes que hay en el arreglo.
     * @return imagenes.size() tamanio del arreglo.
     */
    public int cantImagenes()
    {
        return imagenes.size();
    }

    /**
     * Actualiza la imagen mostrada en la presentacion.
     */
    private void actualizarImagen() 
    {
        if (cont < imagenes.size()) {
            pres.establecerImagen(imagenes.get(cont));
        }else{
            ultimaImagen = true;
        }
        if(cont == 8 && !ultimaImagen)
        {
            CambiaMundo cambiaM = new CambiaMundo("Presentacion");
            cambiaM.setImage("Play.png");
            addObject(cambiaM, getWidth() - 50, getHeight() /2);
            cambiaM.setLocation(300, 500);
        }
    }
}

