import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Puerta representa el intercambio de niveles en el juego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Puerta extends Actor
{
    private String nivel;
    private String siguienteNivel;
    private boolean entraPuerta=false;
    
    /**
     * Constructor para la clase Puerta el cual tiene un nivel y un siguiente nivel.
     */
    public Puerta()
    {
        getImage().scale(getImage().getWidth()/3,getImage().getHeight()/3);
    }
    
    /**
     * Retorna si el Jugador entra a la Puerta.
     * @return entraPuerta booleano que dice si entro o no.
     */
    public boolean tocaPuerta()
    {   
        return this.entraPuerta;
    }
    
    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        Jugador jugador = (Jugador)getOneIntersectingObject(Jugador.class);
        if(jugador != null)
            entraPuerta=true;
    }    
} 
