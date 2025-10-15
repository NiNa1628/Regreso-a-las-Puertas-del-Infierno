import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase RestableceImagenPersonaje establece la nueva imagen en la pantalla PresentaHistoria.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class RestableceImagenHistoria extends Actor
{
    private String nombreImagenActual;
    
    public void establecerImagen(String nombre) 
    {
        GreenfootImage imagen = new GreenfootImage(nombre);
        int ancho = 600;
        int altura = 400;
        imagen.scale(ancho, altura);
        setImage(imagen);
        nombreImagenActual = nombre;
    }
}
