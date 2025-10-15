import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase SiguientePConocePer se utilizara como boton para cambiar entre las vinietas
 * conocer la historia del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class SiguientePersonaje extends Actor
{
    private PresentaPersonaje world;
    
    /**
     * Constructor para la clase SiguientePersonaje
     */
    public SiguientePersonaje(PresentaPersonaje world)
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
