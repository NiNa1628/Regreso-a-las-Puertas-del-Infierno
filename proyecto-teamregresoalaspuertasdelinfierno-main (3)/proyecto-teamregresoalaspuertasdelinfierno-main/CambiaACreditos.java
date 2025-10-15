import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase CambiaACreditos es el botón que lleva a los creditos del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class CambiaACreditos extends Actor
{
    private String nombreMundo;

    /**
     * Constructor para la clase CambiaMundo
     */
    public CambiaACreditos(String nombreMundo)
    {
        this.nombreMundo=nombreMundo;
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
    }

    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            switch(nombreMundo)
            {
                case "PantallaCreditos":
                    Greenfoot.setWorld(new PantallaCreditos());
            }
        }
    }
}