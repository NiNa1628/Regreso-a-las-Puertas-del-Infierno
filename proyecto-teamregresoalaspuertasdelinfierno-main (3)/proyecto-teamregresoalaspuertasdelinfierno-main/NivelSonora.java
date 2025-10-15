import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase NivelSonora es el escenario del segundo nivel del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class NivelSonora extends World
{
    private int expAcumulada;
    private GreenfootSound theme;
    private boolean nivelTerminado;
    private Jugador jugador;
    private Puerta puerta;
    
    /**
     * Constructor para la clase NivelSonora.
     */
    public NivelSonora()
    {    
        // Crea el mundo con medidas de 600x700 de 1x1 píxeles.
        super(600, 700, 1);
        this.nivelTerminado=false;
        
        //Jugador
        jugador = new Jugador(35,15,75);
        addObject(jugador,30,90);
        
        this.theme= new GreenfootSound("paranoid8bit.mp3");
        prepare();
    }
    
    /**
     * Guarda el escenario del Nivel Sinaloa, tomando en cuenta las rocas, agua 
     * y cactus como obstaculos.
     */
    private void prepare()
    {        
        //Enemigos        
        Jefe jefe = new Jefe("NivelSonora");
        addObject(jefe,550,90);
        Cartel cartel1 = new Cartel();
        addObject(cartel1,150,90);
        Cartel cartel = new Cartel();
        addObject(cartel,210,390);
        Cartel cartel2 = new Cartel();
        addObject(cartel2,270,510);
        Cartel cartel3 = new Cartel();
        addObject(cartel3,510,390);
        
        //Items/ventajas
        VidaUp vida1= new VidaUp();
        addObject(vida1,570,450);
        VidaUp vida2= new VidaUp();
        addObject(vida2,270,390);
        ArmorUp armor1= new ArmorUp();
        addObject(armor1,30,570);
        ArmorUp armor2= new ArmorUp();
        addObject(armor2,570,570);
        Municion mun1 = new Municion();
        addObject(mun1,450,270);
        Municion mun2 = new Municion();
        addObject(mun2,30,330);
        
        //Paredes y decoraciones
        //Cactus
        DesertWall cactus= new DesertWall();
        addObject(cactus,30,30);
        DesertWall cactus1= new DesertWall();
        addObject(cactus1,90,30);
        DesertWall cactus3= new DesertWall();
        addObject(cactus3,150,30);
        DesertWall cactus4= new DesertWall();
        addObject(cactus4,30,150);
        DesertWall cactus5= new DesertWall();
        addObject(cactus5,30,210);
        DesertWall cactus6= new DesertWall();
        addObject(cactus6,30,270);
        DesertWall cactus7= new DesertWall();
        addObject(cactus7,30,510);
        DesertWall cactus8= new DesertWall();
        addObject(cactus8,90,510);
        DesertWall cactus9= new DesertWall();
        addObject(cactus9,210,450);
        DesertWall cactus10= new DesertWall();
        addObject(cactus10,270,450);
        DesertWall cactus11= new DesertWall();
        addObject(cactus11,330,450);
        DesertWall cactus12= new DesertWall();
        addObject(cactus12,510,330);
        DesertWall cactus13= new DesertWall();
        addObject(cactus13,510,270);
        DesertWall cactus14= new DesertWall();
        addObject(cactus14,510,210);
        DesertWall cactus15= new DesertWall();
        addObject(cactus15,510,510);
        DesertWall cactus16= new DesertWall();
        addObject(cactus16,570,510);
        DesertWall cactus17= new DesertWall();
        addObject(cactus17,510,450);
        DesertWall cactus18= new DesertWall();
        addObject(cactus18,330,390);
        
        //Piedras
        RockWall rock= new RockWall();
        addObject(rock,210,30);
        RockWall rock1= new RockWall();
        addObject(rock1,210,90);
        RockWall rock2= new RockWall();
        addObject(rock2,210,150);
        RockWall rock3= new RockWall();
        addObject(rock3,150,150);
        RockWall rock4= new RockWall();
        addObject(rock4,150,210);
        RockWall rock5= new RockWall();
        addObject(rock5,150,270);
        RockWall rock7= new RockWall();
        addObject(rock7,150,330);
        RockWall rock8= new RockWall();
        addObject(rock8,210,330);
        RockWall rock9= new RockWall();
        addObject(rock9,270,330);
        RockWall rock10= new RockWall();
        addObject(rock10,330,330);
        RockWall rock11= new RockWall();
        addObject(rock11,390,330);
        RockWall rock12= new RockWall();
        addObject(rock12,390,210);
        RockWall rock13= new RockWall();
        addObject(rock13,390,270);
        RockWall rock14= new RockWall();
        addObject(rock14,390,150);
        RockWall rock15= new RockWall();
        addObject(rock15,330,150);
        RockWall rock16= new RockWall();
        addObject(rock16,330,90);
        RockWall rock17= new RockWall();
        addObject(rock17,330,30);
        
        //Agua
        WaterWall water= new WaterWall();
        addObject(water,270,30);
        WaterWall water1= new WaterWall();
        addObject(water1,270,90);
        WaterWall water2= new WaterWall();
        addObject(water2,270,150);
        WaterWall water3= new WaterWall();
        addObject(water3,270,210);
        WaterWall water4= new WaterWall();
        addObject(water4,210,210);
        WaterWall water5= new WaterWall();
        addObject(water5,210,270);
        WaterWall water6= new WaterWall();
        addObject(water6,270,270);
        WaterWall water7= new WaterWall();
        addObject(water7,330,210);
        WaterWall water8= new WaterWall();
        addObject(water8,330,270);
         
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
        if(jugador.getExpAcum() >= 600){
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
     * Crea la puerta que enlaza entre NivelSonora a NivelBajaC.
     */
    public void creaPuerta()
    {
        puerta = new Puerta();
        addObject(puerta,570,30);
        theme.stop();
        WinScreen win = new WinScreen();
        CambiaMundo boton = new CambiaMundo("BajaC");
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
        CambiaMundo boton = new CambiaMundo("Sonora");
        boton.setImage("Restart.png");
        addObject(boton,500,500);
    }
}
