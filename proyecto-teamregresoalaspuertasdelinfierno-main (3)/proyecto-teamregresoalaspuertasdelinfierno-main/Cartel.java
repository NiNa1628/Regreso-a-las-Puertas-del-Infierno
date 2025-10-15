import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * La clase Cartel es un un grupo de personas que evitaran que el Jugador intente 
 * llegar con el Jefe y matarlo.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Cartel extends Enemigo
{
    private boolean estaVivo;
    private int cantidad;
    private int velocidad = 1;
    private int impactos;
    private int delayDisparos=60;

    /**
     * Constructor de las clase Cartel
     * @param ubicacion ubicacion del Cartel.
     */
    public Cartel()
    {
        this.impactos = 0;
        this.estaVivo=true;
        getImage().scale(getImage().getWidth()/4,getImage().getHeight()/4);
    }

    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        move();
        disparar();
    }

    /**
     * Controla el movimiento de la bala en el mundo
     */
    public void move()
    {
        Random rand = new Random();
        int randomDirection = rand.nextInt(4) + 1;
        // Utilizamos un switch para determinar la direcci�n del movimiento
        switch (randomDirection) {
            case 1:
                // Mueve hacia arriba
                setLocation(getX(), getY() - velocidad);
                if(hitWalls() | tocaBorde()) {
                    setLocation(getX(), getY() + velocidad);
                }
                break;
            case 2:
                // Mueve hacia abajo
                setLocation(getX(), getY() + velocidad);
                if(hitWalls() | tocaBorde()) {
                    setLocation(getX(), getY() - velocidad);
                }
                break;
            case 3:
                // Mueve hacia la izquierda
                setLocation(getX() - velocidad, getY());
                if(hitWalls() | tocaBorde()) {
                    setLocation(getX() + velocidad, getY());
                }
                break;
            case 4:
                // Mueve hacia la derecha
                setLocation(getX() + velocidad, getY());
                if(hitWalls() | tocaBorde()) {
                    setLocation(getX() - velocidad, getY());
                }
                break;
            default:
                // Manejar un caso no esperado (opcional)
                break; 
        }
    }
    
    /**
     * Regresa el n�mero de impactos de cada actor de Cartel.
     * @return impactos es la cantidad de impactos recibida.
     */
    public int getImpactos()
    {
        return impactos;
    }
    
    /**
     * Controla la vida de cada actor de Cartel.
     * @return impactos es la cantidad de impactos que recibi�.
     */
    public int recibirImpacto()
    {
        impactos++;
        if(impactos >= 10){
            Greenfoot.playSound("muerte_enemigo.wav");
            getWorld().removeObject(this);
            this.estaVivo=false;
        
        }
        return this.impactos;        
    }
    
    /**
     * Crea la(s) bala(s) con las cuales se har� la simulaci�n del da�o a
     * otro personaje en el escenario.
     */
    public void disparar()
    {
        delayDisparos-=2;
        if(delayDisparos==0)
        {
            World world = getWorld();
            BalaEnemiga bala = new BalaEnemiga(0,1);
            bala.turn(180);
            world.addObject(bala, getX()-25, getY());
            delayDisparos=60;
        }
    }
}
