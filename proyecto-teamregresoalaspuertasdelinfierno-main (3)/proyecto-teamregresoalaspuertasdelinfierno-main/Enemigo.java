import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Enemigo es superclase de las clases Jefe y Cartel.
 * La clase Enemigo trata de impedir que el Jugador gane cada nivel. 
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Enemigo extends Persona
{
    private String ubicacion;
    private int impactos = 0;

    /**
     * Accede a la ubicacion de Enemigo
     * @return se regresa la ubicacion
     */
    public String getUbicacion()
    {
        return this.ubicacion;
    }

    /**
     * Calcula la experiencia que gana Enemigo al efectuar danio a Jugador
     */
    public int ExperienciaAlEliminar(int exElim)
    {
        int experiencia = 0;
        experiencia += exElim;
        return experiencia;
    }

    /**
     * Se encarga de registrar el impacto recibido por otro Actor.
     */
    public int recibirImpacto()
    {
        impactos++;
        if(impactos >= 30){
            Greenfoot.playSound("muerte_enemigo.wav");
            getWorld().removeObject(this);
        }
        return this.impactos;        
    }
}
