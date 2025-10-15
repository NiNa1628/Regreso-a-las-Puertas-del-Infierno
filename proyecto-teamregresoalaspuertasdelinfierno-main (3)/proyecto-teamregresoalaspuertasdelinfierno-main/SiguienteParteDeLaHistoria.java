import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Siguiente se utilizara como boton para cambiar entre las vinietas
 * conocer la historia del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class SiguienteParteDeLaHistoria extends Actor
{
    private PresentaHistoria world;
    
    /**
     * Constructor para la clase SiguienteParteDeLaHistoria
     */
    public SiguienteParteDeLaHistoria(PresentaHistoria world)
    {
        this.world = world;
    }
    
    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            world.siguienteImagen();
        }
    }
}
