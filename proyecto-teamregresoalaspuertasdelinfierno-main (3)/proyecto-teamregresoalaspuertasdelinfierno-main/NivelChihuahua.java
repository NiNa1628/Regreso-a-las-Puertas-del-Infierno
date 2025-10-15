import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase NivelChihuahua es el escenario del cuarto nivel del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class NivelChihuahua extends World
{
    private int expAcumulada;
    private GreenfootSound theme;
    private boolean nivelTerminado;
    private Jugador jugador;
    private Persona persona;
    private Puerta puerta;
    
    /**
     * Constructor para la clase NivelChihuahua.
     */
    public NivelChihuahua()
    {    
        // Crea el mundo con medidas de 600x700 de 1x1 píxeles.
        super(600, 700, 1);
        this.nivelTerminado=false;
        
        //Jugador
        jugador = new Jugador(35,15,75);
        addObject(jugador,30,510); 
        
        this.theme= new GreenfootSound("paranoid8bit.mp3");
        prepare();
    }
    
    /**
     * Guarda el escenario del Nivel Baja California, tomando en cuenta las piedras 
     * como obstaculos.
     */
    private void prepare()
    { 
        //Enemigos
        Jefe jefe = new Jefe("NivelChihuahua");
        addObject(jefe,360,100);
        Cartel cartel1 = new Cartel();
        addObject(cartel1,450,150);
        Cartel cartel = new Cartel();
        addObject(cartel,450,270);
        Cartel cartel2 = new Cartel();
        addObject(cartel2,390,330);
        Cartel cartel3 = new Cartel();
        addObject(cartel3,210,450);
        Cartel cartel4 = new Cartel();
        addObject(cartel4,270,570);
        Cartel cartel5 = new Cartel();
        addObject(cartel5,450,510);
        
        //Items/ventajas
        VidaUp vida1= new VidaUp();
        addObject(vida1,270,210);
        VidaUp vida2= new VidaUp();
        addObject(vida2,390,570);
        ArmorUp armor1= new ArmorUp();
        addObject(armor1,30,330);
        ArmorUp armor2= new ArmorUp();
        addObject(armor2,270,390);
        Municion mun1 = new Municion();
        addObject(mun1,510,330);
        Municion mun2 = new Municion();
        addObject(mun2,90,210);
        
        //Paredes y decoraciones
        //Piedras
        RockWall rock= new RockWall();
        addObject(rock,30,150);
        RockWall rock1= new RockWall();
        addObject(rock1,90,90);
        RockWall rock2= new RockWall();
        addObject(rock2,150,30);
        RockWall rock3= new RockWall();
        addObject(rock3,210,30);
        RockWall rock4= new RockWall();
        addObject(rock4,270,30);
        RockWall rock5= new RockWall();
        addObject(rock5,330,30);
        RockWall rock6= new RockWall();
        addObject(rock6,390,30);
        RockWall rock7= new RockWall();
        addObject(rock7,450,90);
        RockWall rock8= new RockWall();
        addObject(rock8,30,210);
        RockWall rock9= new RockWall();
        addObject(rock9,30,270);
        RockWall rock10= new RockWall();
        addObject(rock10,90,330);
        RockWall rock11= new RockWall();
        addObject(rock11,90,390);
        RockWall rock12= new RockWall();
        addObject(rock12,210,390);
        RockWall rock13= new RockWall();
        addObject(rock13,450,390);
        RockWall rock14= new RockWall();
        addObject(rock14,510,150);
        RockWall rock15= new RockWall();
        addObject(rock15,510,210);
        RockWall rock16= new RockWall();
        addObject(rock16,510,270);
        RockWall rock17= new RockWall();
        addObject(rock17,450,330);
        RockWall rock18= new RockWall();
        addObject(rock18,330,390);
        RockWall rock19= new RockWall();
        addObject(rock19,150,210);
        RockWall rock20= new RockWall();
        addObject(rock20,210,210);
        RockWall rock21= new RockWall();
        addObject(rock21,330,210);
        RockWall rock22= new RockWall();
        addObject(rock22,390,210);
        RockWall rock23= new RockWall();
        addObject(rock23,210,510);
        RockWall rock24= new RockWall();
        addObject(rock24,330,570);
        RockWall rock25= new RockWall();
        addObject(rock25,90,450);
        
        //Creación de la barra de estado
        BarBg barBg = new BarBg();
        addObject(barBg,50,650);
        HealthBar healthBar = new HealthBar();
        addObject(healthBar,150,650);
        ArmorBar armorBar = new ArmorBar();
        addObject(armorBar,250,650);
        AmmoBar ammoBar = new AmmoBar();
        addObject(ammoBar,350,650);
        ScoreBar scoreBar = new ScoreBar();
        addObject(scoreBar,450,650);
        BarBg barBg2 = new BarBg();
        addObject(barBg2,550,650);
    }
    
    /**
     * Regresa el Jugador del Nivel.
     * @return jugador que es el jugador del escenario.
     */
    public Jugador getJugador(){
        return jugador;
    }
    
    /**
     * Determina las acciones que ejecutara.
     */
    public void act()
    {
        if(jugador.getExpAcum() >= 800){
            creaPuerta();
            nivelTerminado = true;
        }
        if(!jugador.estaVivo()){
            this.theme.stop();
            limpiaEscenario();
        }
        if(!this.nivelTerminado){
            theme.play();
        } else {
            theme.stop();
        }
    }

    /**
     * Crea la puerta que enlaza entre NivelChihuahua a NivelGuatemala.
     */
    public void creaPuerta()
    {
        puerta = new Puerta();
        addObject(puerta,270,100);
        theme.stop();
        WinScreen win = new WinScreen();
        CambiaMundo boton = new CambiaMundo("Guatemala");
        boton.setImage("flecha_Siguiente.png");
        addObject(win,300,300);
        addObject(boton,500,500);
        nivelTerminado=true;
    }
    
    /**
     * Limpia el mundo cuando el jugador muere.
     */

    public void limpiaEscenario()
    {
        GameOverBackground gameOver= new GameOverBackground();
        GameText gameText= new GameText();
        OverText overText= new OverText();
        addObject(gameOver, 300, 300);
        addObject(gameText,300,250);
        addObject(overText,400,350);
        CambiaMundo boton = new CambiaMundo("Chihuahua");
        boton.setImage("Restart.png");
        addObject(boton,500,500);
    }
}
