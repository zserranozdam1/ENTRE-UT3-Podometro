/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona (hombre o mujer)
 * ha dado en una semana. 
 * 
 * @author    - Zuri�e Serrano Zazpe - 
 * 
 */
public class Podometro {
    private final char MUJER = 'M';
    private final char HOMBRE = 'H';
    private final double ZANCADA_HOMBRE = 0.45;
    private final double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;

    private char sexo;
    private double longitudZancada;
    private double altura;
    private String marca;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        sexo = 0;
        longitudZancada = 0;
        altura = 0;
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        if (queSexo == HOMBRE){
            Math.ceil(queAltura*0.45);
        }
        else if (queSexo == MUJER){
            Math.floor(queAltura*0.41);
        }

        /**
         *  Recibe cuatro par�metros que supondremos correctos:
         *  pasos - el n� de pasos caminados
         *  dia - n� de d�a de la semana en que se ha hecho la caminata 
         *  (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
         *  horaInicio � hora de inicio de la caminata
         *  horaFina � hora de fin de la caminata
         *    
         *  A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
         *  y actualizar� el pod�metro adecuadamente  
         *   
         *  (leer enunciado del ejercicio)
         */
        public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) {

        switch (dia){
            case 1: 
            case 2:
            case 3:
            case 4:
            case 5:
            {
                totalPasosLaborales += pasos;
                totalDistanciaSemana += (pasos * longitudZancada / 100000);
                break;
            }
            case SABADO: {
                totalPasosSabado += pasos;
                totalDistanciaFinSemana += (pasos * longitudZancada / 100000);
                break;
            }
            case DOMINGO: {
                totalPasosDomingo += pasos;
                totalDistanciaFinSemana += (pasos * longitudZancada / 100000);
                break;
            }
        }

        int horaInicio = horaInicio / 100;
        int minutoInicio = horaInicio % (horaInicio * 100);
        int horaFin = horaFin / 100;
        int minutoFin = horaFin % (horaFin * 100);

        if (minutoInicio < minutoFin) {
            tiempo += ((horaFin - horaInicio) * 60) + (minutoFin - minutoInicio);
        }
        else if(minutoInicio == minutoFin) {
            tiempo += (horaFin - horaInicio) * 60;
        }
        else {
            tiempo += ((horaFin - horaInicio - 1) * 60) + (minutoFin - minutoInicio);
        }
        if (horaInicio > 20){
            caminatasNoche++;
        }
    }

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("configuraci�n del pod�metro");
        System.out.println("*********************************");
        System.out.println("Altura: " + altura/100 + "mtos");
        if (sexo == MUJER) {
            System.out.println("Sexo: MUJER");
        }
        else {
            System.out.println("Sexo: HOMBRE");
        }
        System.out.println("\nLongitud zancada: " + longitudZancada / 100 + "mtos");
    }    

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
        System.out.println("Estad�sticas");
        System.out.println("*********************************");
        System.out.println("Distancia recorrida toda la semana: " +
            totalDistanciaSemana + "Km");
        System.out.println("Distancia recorrida fin de semana: " +
            totalDistanciaFinSemana + "Km");
        System.out.println("N� pasos d�as laborales: " + 
            totalPasosLaborales);
        System.out.println("N� pasos S�BADO: " +
            totalPasosSabado);
        System.out.println("N� pasos DOMINGO: " +
            totalPasosDomingo);
        System.out.println("N� caminatas realizadas a partir de las 21h.: " +
            caminatasNoche);
        System.out.println("Tiempo total caminado en la semana: " +
            (tiempo / 60) +"h. y " + (tiempo % 60) + "m.");
        System.out.println("D�a/s con m�s pasos caminados: LABORALES");

    }
    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        if (totalPasosSabado > totalPasosDomingo &&
        totalPasosSabado > totalPasosLaborales){
            return "S�BADO";
        }

        if (totalPasosDomingo > totalPasosSabado && 
        totalPasosDomingo > totalPasosLaborales){
            return "DOMINGO";
        }

        if (totalPasosLaborales > totalPasosSabado &&
        totalPasosLaborales > totalPasosDomingo){
            return "LABORABLES";
        }
    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        sexo = MUJER;
        longitudZancada = 0;
        altura = 0;

        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;

        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }
}
