import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase BalaEnemiga es clase que crea el danio al Jugador por parte de los Enemigos.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class BalaEnemiga extends Actor
{    
    private int angulo;
    private int velocidad;
    private boolean seElimina;

    /**
     * Constructor para la clase BalaEnemiga.
     */
    public BalaEnemiga(int angulo,int velocidad)
    {
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
        this.angulo=angulo;
        this.velocidad=velocidad;
    }

    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        if(!seElimina){
            this.move();
            impactaJugador();
        }
    }    

    /**
     * Controla el movimiento de la bala en el mundo.
     */
    private void move() 
    {
        if(!hitWalls() && !tocaBorde())
        {
            turn(angulo);
            move(velocidad);
        }
        else
        {
            World world = getWorld();
            world.removeObject(this);
            seElimina = true;
        }
    }
    
    /**
     * Constructor sobreecargado.
     */
    public BalaEnemiga()
    {
        seElimina = false;
    }
    
    /**
     * Maneja las colisiones de las balas con los enemigos en el juego.
     */    
    public void impactaJugador()
    {
        if (!seElimina) {
        Actor actor2 = getOneObjectAtOffset(0, 0, Jugador.class);
        if (actor2 != null && actor2.getWorld() != null) {
            World world = getWorld();
            if (actor2 instanceof Jugador) {
                ((Jugador) actor2).recibirImpacto();
            }
            world.removeObject(this);
            seElimina = true;
            }
        }
    }

    /**
     * Agrega colision contra las paredes(palmeras).
     * @return true o false dependiendo de si choca contra BeachWall.
     */
    public boolean hitWalls()
    {
        if(isTouching(MapWall.class)){
            return true;
        }else
            return false;
    }
    
    /**
     * Evita que toque los bordes o sobrepase de ellos.
     * @return true o false dependiendo si sale de los limites.
     */
    public boolean tocaBorde()
    {
        int x=getX();
        int y=getY();
        if(x<10| x>600 | y<25 | y>570){
            return true;
        }else{
            return false;
        }
    }
}
