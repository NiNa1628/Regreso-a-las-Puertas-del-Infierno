import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase PantallaCreditos presenta los créditos del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class PantallaCreditos extends World
{
    /**
     * Constructor para la clase Inicio.
     */
    public PantallaCreditos()
    {   
        // Crea el mundo con medidas de 600x700 de 1x1 pixeles.
        super(600, 700, 1); 
        prepare();
    }
    
    /**
    * Guarda el escenario del PantallaCreditos.
    */
    public void prepare()
    {
        CambiaMundo boton= new CambiaMundo("MenuDeInicio");
        boton.setImage("Play.png");
        addObject(boton,350,635);
    }
}
