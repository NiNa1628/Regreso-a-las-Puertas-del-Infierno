import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Bala es clase que crea el danio por parte del Jugador a los Enemigos.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Bala extends Actor
{    
    private int angulo;
    private int velocidad;
    private boolean seElimina;

    /**
     * Constructor para la clase Bala.
     */
    public Bala(int angulo,int velocidad)
    {
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
        this.angulo=angulo;
        this.velocidad=velocidad;
    }  

    /**
     * Constructor sobreecargado.
     */
    public Bala()
    {
        seElimina = false;
    }

    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        if(!seElimina){
            move();
            impactaEnemigo();
        }
    }    

    /**
     * Controla el movimiento de la bala en el mundo.
     */
    private void move() 
    {
        if(!hitWalls() && !tocaBorde()){
            move(velocidad);
        }else{
            World world = getWorld();
            world.removeObject(this);
            seElimina = true;
        }
    }

    /**
     * Maneja las colisiones de las balas con los enemigos en el juego.
     */    
    public void impactaEnemigo()
    {
        if (!seElimina){
            Actor actor = getOneObjectAtOffset(0, 0, Enemigo.class); // Cambiar a Cartel o Jefe según corresponda
            if (actor != null && actor.getWorld() != null) {
                World world = getWorld();
                seElimina = true;
                world.removeObject(this);
                Jugador jugador = getJugadorFromWorld(world);
                if (actor instanceof Cartel) {
                    if(((Cartel) actor).recibirImpacto()==10){
                        jugador.agregaExperiencia(100);
                    }
                } 
                else if (actor instanceof Jefe){
                    if(((Jefe) actor).recibirImpacto()==15){
                        jugador.agregaExperiencia(200);
                    }
                }
            }
        }
    }
    
    /**
     * Regresa donde se encuentra el juagador.
     * @return ((Nivel) world.getJugador(); que es donde está el jugador
     */
    private Jugador getJugadorFromWorld(World world) {
        if (world instanceof NivelBajaC) {
            return ((NivelBajaC) world).getJugador();
        } else if (world instanceof NivelChihuahua) {
            return ((NivelChihuahua) world).getJugador();
        } else if(world instanceof NivelGuatemala) {
            return ((NivelGuatemala) world).getJugador();
        } else if(world instanceof NivelSinaloa) {
            return ((NivelSinaloa) world).getJugador();
        }else if(world instanceof NivelSonora) {
            return ((NivelSonora) world).getJugador();
        }else
            return null;
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
        if(x<10| x>580 | y<25 | y>580){
            return true;
        }else{
            return false;
        }
    }
}
