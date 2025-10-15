import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Inicio es el escenario del principal que da la bienvenida al videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Inicio extends World
{

    /**
     * Constructor para la clase Inicio.
     */
    public Inicio()
    {    
        // Crea el mundo con medidas de 600x700 de 1x1 píxeles.
        super(600, 700, 1); 
        prepare();
    }
    /**
    * Guarda el escenario del Inicio.
    */
    public void prepare()
    {
        CambiaMundo boton= new CambiaMundo("Inicio");
        boton.setImage("Play.png");
        addObject(boton,500,550);
        CambiaACreditos boton2 = new CambiaACreditos("PantallaCreditos");
        addObject(boton2, 300, 550);
    }
}
