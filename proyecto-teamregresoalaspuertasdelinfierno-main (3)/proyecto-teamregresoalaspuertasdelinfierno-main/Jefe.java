
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Jefe es el lider mayor del Cartel con el que peleara el Jugador para poder pasar de nivel.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Jefe extends Enemigo
{
    public static boolean estaVivo;
    private int impactos;
    public String nombre;
    
    /**
     * Constructor de la clase Jefe.
     * @param nombreMundo nombre de la ciudad donde se encuentra el enfrentamiento.
     */
    public Jefe(String nombreMundo)
    {
        this.impactos = 0;
        this.estaVivo=true;
        this.nombre = nombreMundo;
        switch(nombreMundo){
            case "NivelSinaloa":
                setImage("DonPedro.png");
                getImage().scale(getImage().getWidth()/7,getImage().getHeight()/7);
            break;
            case "NivelSonora":
                setImage("Jefe.png");
                getImage().scale(getImage().getWidth()/8,getImage().getHeight()/8);
            break;
            case "NivelBajaC":
                setImage("Arellano.png");
                getImage().scale(getImage().getWidth()/8,getImage().getHeight()/8);
            break;
            case "NivelChihuahua":
                setImage("Guero.png");
                getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
            break;
            case "NivelGuatemala":
                setImage("Jefe.png");
                getImage().scale(getImage().getWidth()/9,getImage().getHeight()/9);
            break;
        }
    }
    
    /**
     * Controla la vida del Jefe.
     * @return impactos es la cantidad de impactos que recibio.
     */
    public int recibirImpacto()
    {
        impactos++;
        if(impactos >= 15){
            Greenfoot.playSound("muerte_jefe.mp3");
            getWorld().removeObject(this);
            this.estaVivo=false;
        }
        return impactos;
    }
    
    /**
     * Regresa el numero de impactos de cada actor de Cartel.
     * @return impactos es la cantidad de impactos recibida.
     */
    public int getImpactos()
    {
        return impactos;
    }
    
    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        disparar();
    }
    
    /**
     * Crea la(s) bala(s) con las cuales se hara la simulacion del danio a
     * otro personaje en el escenario.
     */
    public void disparar()
    {
        int num = Greenfoot.getRandomNumber(100);
        if(num>=98)
        {
            World world = getWorld();
            BalaEnemiga bala = new BalaEnemiga(0,1);
            bala.turn(180);
            world.addObject(bala, getX()-25, getY());
            BalaEnemiga bala1 = new BalaEnemiga(0,1);
            bala1.turn(180);
            world.addObject(bala1, getX()-25, getY()+15);
            BalaEnemiga bala2 = new BalaEnemiga(0,1);
            bala2.turn(180);
            world.addObject(bala2, getX()-25, getY()-15);
        }
    }
}
