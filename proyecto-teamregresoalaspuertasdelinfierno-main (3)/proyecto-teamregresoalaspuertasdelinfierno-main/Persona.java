import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;

/**
 * La clase Persona es la superclase de las clases Jugador, Enemigo, Jefe y Cartel. 
 * Los cuales se presentan como actores que interactuan entre si para el 
 * desarrollo del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Persona extends Actor
{
    private String nombre;
    private String arma;
    private int nivelVida;
    private int velocidad = 2;
    private String nombreImagenActual;
    private Jugador jugador;

    /**
     * Constructor para la clase Persona.
     */
    public Persona()
    {
        this.nivelVida = 0;
    }
    
    /**
     * Crea al Jugador para Persona.
     * @param jugador ingresa el Jugador.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Agrega una Arma a Persona por medio de el nombre de esta.
     * @param arma nombre de la arma.
     */
    void agregarArma(String arma)
    {
        this.arma = arma;
    }

    /**
     * Accede a el nivel de vida de Persona.
     * @return regresa el nivel de vida.
     */
    int getNiveldeVida()
    {
        return this.nivelVida;
    }

    /**
     * Modifica el nivel de vida de Persona
     * @param numVida nuevo nivel de vida.
     */
    void setNiveldeVida(int numVida)
    {
        this.nivelVida = numVida;
    }

    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
    }

    /**
     * Crea el movimiento de Persona por medio de las flechas del techado:
     *      W -> arriba
     *      S -> abajo
     *      A -> izquierda
     *      D -> derecha
     *      SPACE -> disparar
     */
    public void move()
    {
        // Verifica si se presiona alguna tecla
        if (Greenfoot.isKeyDown("W")) {
            // Mueve hacia arriba
            setLocation(getX(), getY() - velocidad);
            if(hitWalls() | tocaBorde()){
                setLocation(getX(), getY() + velocidad);
            }
        }
        if (Greenfoot.isKeyDown("S")) {
            // Mueve hacia abajo
            setLocation(getX(), getY() + velocidad);
            if(hitWalls() | tocaBorde()){
                setLocation(getX(), getY() - velocidad);
            }
        }
        if (Greenfoot.isKeyDown("A")) {
            //Mueve hacia la izquierda
            disparaIzquierda();
        }
        if (Greenfoot.isKeyDown("D")) {
            // Mueve hacia la derecha
            disparaDerecha();
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
        }
        else
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
        if(x<25 | x>570 | y<25 | y>570){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Obtiene la imagen actual de Persona.
     * @return getImage la cual es la imagen actual.
     */
    public GreenfootImage obtenerImagenActual()
    {
        return getImage();
    }

    /**
     * Establece la nueva imagen a Persona.
     * @param nombre Nombre de la imagen.
     */
    public void establecerImagen(String nombre)
    {
        GreenfootImage imagen = new GreenfootImage(nombre);
        setImage(imagen);
        imagen.scale(getImage().getWidth() / 4, getImage().getHeight() / 4);
        nombreImagenActual = nombre;
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
     * Permite el disparo al jugador, presione la tecla SPACE y D para disparar a la derecha
     * Ademas se crea la bala en el mundo e inicia su desplazamiento.
     */
    public void disparaDerecha()
    {
        Jugador jugador = getJugadorFromWorld(getWorld());
        if (nombreImagenActual == null || !nombreImagenActual.equals("soldado.png")) {
            establecerImagen("soldado.png");
        }
        setLocation(getX() + velocidad, getY());
        if(hitWalls() | tocaBorde()){
            setLocation(getX()- velocidad, getY());
        }
        if("soldado.png".equals(nombreImagenActual)){
            if("space".equals(Greenfoot.getKey()) && jugador.getCantMunicion()>=0){
                Greenfoot.playSound("disparo.wav");
                World world = getWorld();
                Bala bala = new Bala(180,5);
                world.addObject(bala, getX()+25, getY());
                jugador.menosMuniciones(1);
            }
        }
    }

    /**
     * Permite el disparo al jugador, presione la tecla SPACE y A para disparar a la izquierda
     * Ademas se crea la bala en el mundo e inicia su desplazamiento.
     */
    public void disparaIzquierda()
    {
        Jugador jugador = getJugadorFromWorld(getWorld());
        if (nombreImagenActual == null || !nombreImagenActual.equals("soldado2.png")) {
            establecerImagen("soldado2.png");
        }
        setLocation(getX() - velocidad, getY());
        if(hitWalls() | tocaBorde())
        {
            setLocation(getX() + velocidad, getY());
        }
        if("soldado2.png".equals(nombreImagenActual)){
            if ("space".equals(Greenfoot.getKey()) && jugador.getCantMunicion()>=0){
                Greenfoot.playSound("disparo.wav");
                World world = getWorld();
                Bala bala1 = new Bala(0,5);
                bala1.turn(180);
                world.addObject(bala1, getX()-25, getY());
                jugador.menosMuniciones(1);
            }
        }
    }
}

