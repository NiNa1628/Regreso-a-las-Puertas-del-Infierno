import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase NivelSinaloa es el escenario del primer nivel del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class NivelSinaloa extends World
{
    private int expAcumulada = 0;
    private GreenfootSound theme;
    private boolean nivelTerminado;
    private Jugador jugador;
    private Puerta puerta;

    /**
     * Constructor para la clase NivelSinaloa.
     */
    public NivelSinaloa()
    {    
        // Crea el mundo con medidas de 600x700 de 1x1 p�xeles.
        super(600, 700, 1);
        this.nivelTerminado=false;
        
        //Jugador
        jugador = new Jugador(35,15,75);
        addObject(jugador,30,40);
        
        this.theme= new GreenfootSound("thetrooper8bit.mp3");
        prepare();
    }

    /**
     * Guarda el escenario del Nivel Sinaloa, tomando en cuenta las palmeras 
     * como obstaculos.
     */
    private void prepare()
    {
        expAcumulada = jugador.getExpAcum();

        //Enemigos
        Jefe jefe2 = new Jefe("NivelSinaloa");
        addObject(jefe2,480,480);
        Cartel cartel1 = new Cartel();
        addObject(cartel1,90,270);
        Cartel cartel2 = new Cartel();
        addObject(cartel2,270,210);
        //Cartel cartel3 = new Cartel();
        //addObject(cartel3,390, 390);
        Cartel cartel4 = new Cartel();
        addObject(cartel4,510,150);

        //Items/ventajas
        VidaUp vida1= new VidaUp();
        addObject(vida1,150,150);
        VidaUp vida2= new VidaUp();
        addObject(vida2,330,90);
        ArmorUp armor1= new ArmorUp();
        addObject(armor1,150,390);
        ArmorUp armor2= new ArmorUp();
        addObject(armor2,390,330);
        Municion mun1 = new Municion();
        addObject(mun1,510,30);
        Municion mun2 = new Municion();
        addObject(mun2,150,30);

        //Paredes y decoraciones
        //Agua
        WaterWall waterWall = new WaterWall();
        addObject(waterWall,570,90);
        WaterWall waterWall2 = new WaterWall();
        addObject(waterWall2,570,150);
        WaterWall waterWall3 = new WaterWall();
        addObject(waterWall3,570,210);
        WaterWall waterWall4 = new WaterWall();
        addObject(waterWall4,570,270);
        WaterWall waterWall5 = new WaterWall();
        addObject(waterWall5,570,330);
        WaterWall waterWall6 = new WaterWall();
        addObject(waterWall6,570,390);
        WaterWall waterWall7 = new WaterWall();
        addObject(waterWall7,570,450);
        WaterWall waterWall8 = new WaterWall();
        addObject(waterWall8,570,510);
        WaterWall waterWall9 = new WaterWall();
        addObject(waterWall9,570,570);

        //Rocas
        RockWall rockWall = new RockWall();
        addObject(rockWall,510,265);
        RockWall rockWall2 = new RockWall();
        addObject(rockWall2,391,32);
        RockWall rockWall3 = new RockWall();
        addObject(rockWall3,512,331);
        RockWall rockWall4 = new RockWall();
        addObject(rockWall4,509,570);
        RockWall rockWall5 = new RockWall();
        addObject(rockWall5,206,575);
        RockWall rockWall6 = new RockWall();
        addObject(rockWall6,344,277);

        //Palmeras
        BeachWall beachWall6 = new BeachWall();
        addObject(beachWall6,90,30);
        BeachWall beachWall7 = new BeachWall();
        addObject(beachWall7,90,90);
        BeachWall beachWall8 = new BeachWall();
        addObject(beachWall8,90,150);
        BeachWall beachWall17 = new BeachWall();
        addObject(beachWall17,270,330);
        BeachWall beachWall = new BeachWall();
        addObject(beachWall,330,30);
        BeachWall beachWall2 = new BeachWall();
        addObject(beachWall2,390,90);
        BeachWall beachWall4 = new BeachWall();
        addObject(beachWall4,390,210);
        BeachWall beachWall5 = new BeachWall();
        addObject(beachWall5,390,270);
        BeachWall beachWall9 = new BeachWall();
        addObject(beachWall9,90,570);
        BeachWall beachWall10 = new BeachWall();
        addObject(beachWall10,150,570);
        BeachWall beachWall11 = new BeachWall();
        addObject(beachWall11,30,450);
        BeachWall beachWall12 = new BeachWall();
        addObject(beachWall12,90,450);
        BeachWall beachWall13 = new BeachWall();
        addObject(beachWall13,150,450);
        BeachWall beachWall14 = new BeachWall();
        addObject(beachWall14,90,330);
        BeachWall beachWall15 = new BeachWall();
        addObject(beachWall15,150,330);
        BeachWall beachWall16 = new BeachWall();
        addObject(beachWall16,210,330);
        BeachWall beachWall18 = new BeachWall();
        addObject(beachWall18,150,90);
        BeachWall beachWall19 = new BeachWall();
        addObject(beachWall19,210,150);
        BeachWall beachWall20 = new BeachWall();
        addObject(beachWall20,210,90);
        BeachWall beachWall21 = new BeachWall();
        addObject(beachWall21,210,390);
        BeachWall beachWall22 = new BeachWall();
        addObject(beachWall22,210,450);
        BeachWall beachWall23 = new BeachWall();
        addObject(beachWall23,570,30);
        BeachWall beachWall24 = new BeachWall();
        addObject(beachWall24,450,30);
        BeachWall beachWall25 = new BeachWall();
        addObject(beachWall25,330,210);
        BeachWall beachWall26 = new BeachWall();
        addObject(beachWall26,330,330);
        BeachWall beachWall27 = new BeachWall();
        addObject(beachWall27,450,390);
        BeachWall beachWall29 = new BeachWall();
        addObject(beachWall29,510,210);
        BeachWall beachWall30 = new BeachWall();
        addObject(beachWall30,270,570);
        BeachWall beachWall31 = new BeachWall();
        addObject(beachWall31,450,570);

        //Creaci�n de la barra de estado
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
        if(jugador.getExpAcum() >= 500){
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
     * Crea la puerta que enlaza entre NivelSinaloa a NivelSonora.
     */
    public void creaPuerta()
    {
        puerta = new Puerta();
        addObject(puerta,30,510);
        theme.stop();
        WinScreen win = new WinScreen();
        CambiaMundo boton = new CambiaMundo("Sonora");
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
        CambiaMundo boton = new CambiaMundo("Sinaloa");
        boton.setImage("Restart.png");
        addObject(boton,500,500);
    }
}
