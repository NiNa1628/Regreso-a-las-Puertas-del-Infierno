import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase CambiaMundo se utilizará para cambiar los mundos en el videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class CambiaMundo extends Actor
{
    private String nombreMundo;

    /**
     * Constructor para la clase CambiaMundo
     */
    public CambiaMundo(String nombreMundo)
    {
        this.nombreMundo=nombreMundo;
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
                case "MenuDeInicio":
                    Greenfoot.setWorld(new Inicio());
                case "Inicio":
                    Greenfoot.setWorld(new PresentaHistoria());
                    break;
                case "Presentacion":
                    Greenfoot.setWorld(new PresentaPersonaje());
                  break;
                case "Personajes":
                    Greenfoot.setWorld(new NivelSinaloa());
                    break;
                case "Sinaloa":
                    Greenfoot.setWorld(new NivelSinaloa());
                    break;
                case "Sonora":
                    Greenfoot.setWorld(new NivelSonora());
                    break;
                case "BajaC":
                    Greenfoot.setWorld(new NivelBajaC());
                    break;
                case "Chihuahua":
                    Greenfoot.setWorld(new NivelChihuahua());
                    break;
                case "Guatemala":
                    Greenfoot.setWorld(new NivelGuatemala());
                break; 
            }       
        }
    }
}
