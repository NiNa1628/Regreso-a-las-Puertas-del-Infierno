import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase NivelGuatemala es el escenario del ultimo nivel del videojuego.
 * @author Gonzalez Medina Claudia Karina y Renovato Zapata Oscar Samuel
 */
public class NivelGuatemala extends World
{
    private int expAcumulada = 0;
    private GreenfootSound theme;
    private boolean nivelTerminado;
    private Jugador jugador;
    private Puerta puerta;

    /**
     * Constructor para la clase NivelGuatemala.
     */
    public NivelGuatemala()
    {    
        // Crea el mundo con medidas de 600x700 de 1x1 píxeles.
        super(600, 700, 1);
        this.nivelTerminado=false;
        
        //Jugador
        jugador = new Jugador(35,15,75);
        addObject(jugador,35,500);
        
        this.theme= new GreenfootSound("thetrooper8bit.mp3");
        prepare();
    }
    
    /**
     * Guarda el escenario del Nivel Guatemala, tomando en cuenta los arboles, 
     * rocas y agua como obstaculos.
     */
    public void prepare()
    {      
        //Enemigos
        Jefe jefe = new Jefe( "NivelGuatemala");
        addObject(jefe,311,38);
        Cartel cartel = new Cartel();
        addObject(cartel,466,422);
        Cartel cartel1 = new Cartel();
        addObject(cartel1,330,570);
        Cartel cartel2 = new Cartel();
        addObject(cartel2,150,341);
        Cartel cartel3 = new Cartel();
        addObject(cartel3,230,450);
        Cartel cartel4 = new Cartel();
        addObject(cartel4,487,148);
        Cartel cartel5 = new Cartel();
        addObject(cartel5,570,270);
        Cartel cartel6 = new Cartel();
        addObject(cartel6,250,120);
        
        //Items
        VidaUp vidaUp = new VidaUp();
        addObject(vidaUp,390,570);
        VidaUp vidaUp1 = new VidaUp();
        addObject(vidaUp1,570,390);
        ArmorUp armorUp = new ArmorUp();
        addObject(armorUp,427,279);
        ArmorUp armorUp1 = new ArmorUp();
        addObject(armorUp1,270,450);
        Municion municion = new Municion();
        addObject(municion,91,271);
        Municion municion1 = new Municion();
        addObject(municion1,360,390);

        //Paredes y decoraciones
        //Agua
        WaterWall waterWall2 = new WaterWall();
        addObject(waterWall2,24,183);
        WaterWall waterWall3 = new WaterWall();
        addObject(waterWall3, 24, 233);
        WaterWall waterWall4 = new WaterWall();
        addObject(waterWall4,24,183);
        WaterWall waterWall5 = new WaterWall();
        addObject(waterWall5,24,233);
        WaterWall waterWall6 = new WaterWall();
        addObject(waterWall6, 24, 283);
        WaterWall waterWall7 = new WaterWall();
        addObject(waterWall7,24,333);
        WaterWall waterWall8 = new WaterWall();
        addObject(waterWall8,24,383);
        WaterWall waterWall9 = new WaterWall();
        addObject(waterWall9, 24, 433);
        WaterWall waterWall10 = new WaterWall();
        addObject(waterWall10,533,569);
        WaterWall waterWall11 = new WaterWall();
        addObject(waterWall11,533,519);
        WaterWall waterWall12 = new WaterWall();
        addObject(waterWall12, 483, 540);
        WaterWall waterWall13 = new WaterWall();
        addObject(waterWall13,266,255);
        WaterWall waterWall14 = new WaterWall();
        addObject(waterWall14,316,255);
        WaterWall waterWall15 = new WaterWall();
        addObject(waterWall15, 266, 305);
        WaterWall waterWall16 = new WaterWall();
        addObject(waterWall16, 316, 305);
        WaterWall waterWall17 = new WaterWall();
        addObject(waterWall17,533,30);
        WaterWall waterWall18 = new WaterWall();
        addObject(waterWall18,483,30);
        
        //Rocas
        RockWall rockWall = new RockWall();
        addObject(rockWall, 533, 465);
        RockWall rockWall2 = new RockWall();
        addObject(rockWall2, 470, 490);
        RockWall rockWall3 = new RockWall();
        addObject(rockWall3, 470, 570);
        RockWall rockWall4 = new RockWall();
        addObject(rockWall4, 420, 30);
        RockWall rockWall5 = new RockWall();
        addObject(rockWall5, 463, 80);
        RockWall rockWall6 = new RockWall();
        addObject(rockWall6, 533, 80);
        RockWall rockWall7 = new RockWall();
        addObject(rockWall7,270,380);
        RockWall rockWall8 = new RockWall();
        addObject(rockWall8,210,380);
        RockWall rockWall9 = new RockWall();
        addObject(rockWall9,464,332);

        //Árboles
        Tree tree = new Tree();
        addObject(tree, 70,390);
        Tree tree2 = new Tree();
        addObject(tree2, 54,433);
        Tree tree3 = new Tree();
        addObject(tree3, 54,126);
        Tree tree4 = new Tree();
        addObject(tree4, 70,164);
        Tree tree5 = new Tree();
        addObject(tree5,354,210);
        Tree tree6 = new Tree();
        addObject(tree6,354,256);
        Tree tree7 = new Tree();
        addObject(tree7,224,210);
        Tree tree8 = new Tree();
        addObject(tree8,224,256);
        Tree tree9 = new Tree();
        addObject(tree9,266,196);
        Tree tree10 = new Tree();
        addObject(tree10,310,196);
        Tree tree11 = new Tree();
        addObject(tree11,266,320);
        Tree tree12 = new Tree();
        addObject(tree12,310,320);
        Tree tree13 = new Tree();
        addObject(tree13,224,305);
        Tree tree14 = new Tree();
        addObject(tree14,354,305);
        Tree tree15 = new Tree();
        addObject(tree15,270,510);
        Tree tree16 = new Tree();
        addObject(tree16,220,510);
        Tree tree17 = new Tree();
        addObject(tree17,320,510);
        Tree tree18 = new Tree();
        addObject(tree18,320,460);
        
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
        if(jugador.getExpAcum() >= 900){
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
        addObject(puerta,30,40);
        WinScreen win= new WinScreen();
        CambiaMundo boton = new CambiaMundo("MenuInicio");
        boton.setImage("flecha_Siguiente.png");
        addObject(win,300,300);
        addObject(boton,500,500);
    }

    /**
     * Crea la Pantalla de ganador.
     */
    public void creaPantallaWin()
    {
        theme.stop();
        WinScreen win = new WinScreen();
        CambiaMundo boton = new CambiaMundo("MenuDeInicio");
        boton.setImage("Play.png");
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
        CambiaMundo boton = new CambiaMundo("Guatemala");
        boton.setImage("Restart.png");
        addObject(boton,500,500);      
    }
}
