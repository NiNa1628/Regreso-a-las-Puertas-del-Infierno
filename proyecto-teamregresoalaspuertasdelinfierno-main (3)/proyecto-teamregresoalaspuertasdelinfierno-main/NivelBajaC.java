import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase NivelBajaC es el escenario del tercer nivel del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class NivelBajaC extends World
{
    private int expAcumulada;
    private GreenfootSound theme;
    private boolean nivelTerminado;
    private Jugador jugador;
    private Puerta puerta;
    
    /**
     * Constructor para la clase NivelBajaC.
     */
    public NivelBajaC()
    {    
        // Crea el mundo con medidas de 600x700 de 1x1 pixeles.
        super(600, 700, 1);
        this.nivelTerminado=false;
        
        //Jugador
        jugador = new Jugador(35,15,75);
        addObject(jugador,30,570);
        
        this.theme= new GreenfootSound("thetrooper8bit.mp3");
        prepare();
    }
    
    /**
    * Guarda el escenario del Nivel Baja California, tomando en cuenta las palmeras, 
    * agua y piedras como obstaculos.
    */
    private void prepare()
    {
        //Enemigos
        Jefe jefe = new Jefe("NivelBajaC");
        addObject(jefe,570,60);
        Cartel cartel1 = new Cartel();
        addObject(cartel1,150,90);
        Cartel cartel = new Cartel();
        addObject(cartel,300,390);
        Cartel cartel2 = new Cartel();
        addObject(cartel2,450,570);
        Cartel cartel3 = new Cartel();
        addObject(cartel3,390,270);
        Cartel cartel4 = new Cartel();
        addObject(cartel4, 510,150);
        
        //Items/ventajas
        VidaUp vida1= new VidaUp();
        addObject(vida1,330,210);
        VidaUp vida2= new VidaUp();
        addObject(vida2,90,150);
        ArmorUp armor1= new ArmorUp();
        addObject(armor1,330,510);
        ArmorUp armor2= new ArmorUp();
        addObject(armor2,450,210);
        Municion mun1 = new Municion();
        addObject(mun1,510,570);
        Municion mun2 = new Municion();
        addObject(mun2,270,90);
        
        //Paredes y decoraciones
        //Palmeras
        BeachWall beachWall = new BeachWall();
        addObject(beachWall,570,150);
        BeachWall beachWall1 = new BeachWall();
        addObject(beachWall1,510,210);
        BeachWall beachWall2 = new BeachWall();
        addObject(beachWall2,450,270);
        BeachWall beachWall3 = new BeachWall();
        addObject(beachWall3,450,330);
        BeachWall beachWall4 = new BeachWall();
        addObject(beachWall4,450,390);
        BeachWall beachWall5 = new BeachWall();
        addObject(beachWall5,510,450);
        BeachWall beachWall6 = new BeachWall();
        addObject(beachWall6,510,510);
        BeachWall beachWall7 = new BeachWall();
        addObject(beachWall7,570,570);
        
        //Piedras
        RockWall rock= new RockWall();
        addObject(rock,30,150);
        RockWall rock1= new RockWall();
        addObject(rock1,90,210);
        RockWall rock2= new RockWall();
        addObject(rock2,90,450);
        RockWall rock3= new RockWall();
        addObject(rock3,150,390);
        RockWall rock5= new RockWall();
        addObject(rock5,150,270);
        RockWall rock6= new RockWall();
        addObject(rock6,30,510);
        RockWall rock4= new RockWall();
        addObject(rock4,210,330);
        RockWall rock9= new RockWall();
        addObject(rock9,210,510);
        RockWall rock10= new RockWall();
        addObject(rock10,270,450);
        RockWall rock7= new RockWall();
        addObject(rock7,330,450);
        RockWall rock8= new RockWall();
        addObject(rock8,390,510);
        RockWall rock11= new RockWall();
        addObject(rock11,270,210);
        RockWall rock12= new RockWall();
        addObject(rock12,390,210);
        RockWall rock13= new RockWall();
        addObject(rock13,210,150);
        RockWall rock14= new RockWall();
        addObject(rock14,210,90);
        RockWall rock15= new RockWall();
        addObject(rock15,210,30);
        RockWall rock16= new RockWall();
        addObject(rock16,330,90);
        
        //Agua
        WaterWall water= new WaterWall();
        addObject(water,30,210);
        WaterWall water1= new WaterWall();
        addObject(water1,30,270);
        WaterWall water2= new WaterWall();
        addObject(water2,30,330);
        WaterWall water3= new WaterWall();
        addObject(water3,30,390);
        WaterWall water4= new WaterWall();
        addObject(water4,90,270);
        WaterWall water5= new WaterWall();
        addObject(water5,90,330);
        WaterWall water6= new WaterWall();
        addObject(water6,90,390);
        WaterWall water7= new WaterWall();
        addObject(water7,30,450);
        WaterWall water8= new WaterWall();
        addObject(water8,150,330);
        WaterWall water9= new WaterWall();
        addObject(water9,570,210);
        WaterWall water10= new WaterWall();
        addObject(water10,570,270);
        WaterWall water11= new WaterWall();
        addObject(water11,570,330);
        WaterWall water12= new WaterWall();
        addObject(water12,570,390);
        WaterWall water13= new WaterWall();
        addObject(water13,570,450);
        WaterWall water14= new WaterWall();
        addObject(water14,570,510);
        WaterWall water15= new WaterWall();
        addObject(water15,510,270);
        WaterWall water16= new WaterWall();
        addObject(water16,510,330);
        WaterWall water17= new WaterWall();
        addObject(water17,510,390);
 
        //Creacion de la barra de estado
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
        if(jugador.getExpAcum() >= 700){
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
     * Crea la puerta que enlaza entre NivelBajaC a NivelChihuahua.
     */
    public void creaPuerta()
    {
        puerta = new Puerta();
        addObject(puerta,570,30);
        theme.stop();
        WinScreen win = new WinScreen();
        CambiaMundo boton = new CambiaMundo("Chihuahua");
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
        CambiaMundo boton = new CambiaMundo("BajaC");
        boton.setImage("Restart.png");
        addObject(boton,500,500);     
    }
}
