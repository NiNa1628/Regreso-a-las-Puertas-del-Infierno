import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Jugador es manipulado por el usuario para intentar ganar el juego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class Jugador extends Persona
{
    private int experienciaAcumulada;
    private double puntosDeVida;
    private double puntosDeEscudo;
    private boolean estaVivo;
    private int impactos = 0;
    private double cantidadMunicion;
    private int tipoMunicion;  
    
    /**
     * Constructor para la clase Jugador.
     * @param puntosDeVida la cantidad de vida que contiene el Jugador.
     * @param puntosDeEscudo la cantidad de escudo que tiene para no afectar la vida del Jugador.
     * @param cantidadMunicion la cantidad de balas que tiene para disparar.
     */
    public Jugador(double puntosDeVida, double puntosDeEscudo, double cantidadMunicion)
    {
        this.experienciaAcumulada = 0;
        this.puntosDeVida = puntosDeVida;
        this.puntosDeEscudo = puntosDeEscudo;
        this.cantidadMunicion = cantidadMunicion;
        this.estaVivo=true;
        getImage().scale(getImage().getWidth()/4,getImage().getHeight()/4);
    }
    
    /**
     * Disminuye la cantidad de balas del Jugador.
     * @param menosMun disminuye la cantidad de balas después de disparar.
     */
    public void menosMuniciones(int menosMun)
    {
        this.cantidadMunicion -= menosMun;
    }
    
    /**
     * Incrementa la experiencia acumulada del Jugador.
     * @param exp agrega la cantidad de experiencia después de matar a los Enemigos.
     */
    public void agregaExperiencia(int exp)
    {
        this.experienciaAcumulada += exp;
    }
    
    /**
     * Regresa la Experiencia Acumulada del jugador.
     * @return expAcum la cual es la cantidad de experiencia que tiene.
     */
    public int getExpAcum()
    {
        String txt = String.valueOf(experienciaAcumulada);
        int expAcum = Integer.parseInt(txt);
        return expAcum;
    }
    
    /**
     * Cantidad de Municiones que tiene el Jugador.
     * @return cantidadMunicion cantidad de municiones.
     */
    public double getCantMunicion(){
        return cantidadMunicion;
    }
    
    /**
     * Regresa si está vivo o no.
     * @return estavivo booleando que regresa si está vivo o no.
     */
    public boolean estaVivo(){
        return this.estaVivo;
    }
    
    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        move();
        muestraPuntosDeVida();
        muestraPuntosDeEscudo();
        muestraMuniciones();
        muestraExperienciaAcumulada();
        recuperaVida();
        recuperaEscudo();
        recuperaMunicion();
    }

    /**
    * Muestra los Puntos de Vida del Jugador.
    */
    public void muestraPuntosDeVida()
    {
        String txt= String.valueOf(puntosDeVida);
        World world;
        world=getWorld();
        world.showText(txt,150,635);
    }

    /**
    * Muestra los Puntos que contiene el Escudo.
    */
    public void muestraPuntosDeEscudo()
    {
        String txt= String.valueOf(puntosDeEscudo);
        World world;
        world=getWorld();
        world.showText(txt,250,635);
    }
    
    /**
     * Muestra las municiones.
     */
    public void muestraMuniciones()
    {
        String txt= String.valueOf(cantidadMunicion);
        World world;
        world=getWorld();
        world.showText(txt,350,635);
    }

    /**
    * Muestra la Experiencia Acumulada.
    */
    public void muestraExperienciaAcumulada()
    {
        String txt= String.valueOf(experienciaAcumulada);
        World world;
        world=getWorld();
        world.showText(txt,450,635);
    }

    /**
     * Controla la vida del Jugador.
     */
    public void recibirImpacto()
    {
        if(puntosDeEscudo>0 && puntosDeVida>=0){
            puntosDeEscudo--;
        }else{
            puntosDeVida--;
            if(puntosDeVida <=0){
                World world = getWorld();
                Greenfoot.playSound("muerte_enemigo.wav");
                world.removeObject(this);
                this.estaVivo=false;
            }
        }
    }
    
    /**
     * Regenera vida al jugador al tocar un item especifico.
     */
    public void recuperaVida()
    {
        if(puntosDeVida<50){
            Actor actor = getOneObjectAtOffset( 0, 0, VidaUp.class);
            if(actor != null && actor.getWorld()!=null){
                Greenfoot.playSound("escudo.wav");
                World world;
                world = getWorld();
                puntosDeVida += 15;
                world.removeObject(actor);
            }
        }
    }
    
    /**
     * Regenera escudo al jugador al tocar un item especifico
     */
    public void recuperaEscudo()
    {
        if(puntosDeEscudo < 50){
            Actor actor = getOneObjectAtOffset( 0, 0, ArmorUp.class);
            if(actor != null && actor.getWorld()!=null){
                Greenfoot.playSound("escudo.wav");
                World world;
                world = getWorld();
                puntosDeEscudo = puntosDeEscudo+15;
                world.removeObject(actor);
            }
        }
    }
    
    /**
     * Regenera la cantidad de municiones que tiene el Jugador para seguir atacando a los Enemigos.
     */
    public void recuperaMunicion()
    {
            if(cantidadMunicion < 75){
            Actor actor = getOneObjectAtOffset( 0, 0, Municion.class);
            if(actor != null && actor.getWorld()!=null){
                Greenfoot.playSound("escudo.wav");
                World world = getWorld();
                cantidadMunicion += 25;
                world.removeObject(actor);
            }
        }
    }
}
    