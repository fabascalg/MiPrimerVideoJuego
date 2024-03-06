/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package piedrapapeltijerabrain;

import java.util.Scanner;

/**
 *
 * @author Fernando Abascal González
 */
public class MiPrimerVideoJuego {

    /**
     * Método principal del juego.
     * Se desarrolla integramente en este método, solo se hacen 
     * llamadas puntuales a métodos externos para representar las
     * jugadas en forma gráfica por consola.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * Variable int acumula jugadas ganadas.
         */
        int chiquipuntos = 0;
        /**
         * Variable instancia de Scanner para entrar la respuesta del jugador
         * por la entrada por defecto en consola.
         */
        Scanner sc = new Scanner(System.in);
        /**
         * Variable String almacena jugada del jugador.
         */
        String opcionJugador = "";
        /**
         * Variable String almacena jugada de la IA.
         */
        String opcionBot = "";
        /**
         * Variable int resultado del enfrentamiento en cada jugada
         */
        int exitoEnProposito = 1;
        /**
         * Variable long almacena momento inicial del juego en milisegundos.
         */
        long inicio = System.currentTimeMillis();
        /**
         * Bucle for para hacer cinco jugadas
         */
        for (int i = 0; i < 5; i++) {
            /**
             * Variable int almacena decisión de la IA de pedir al jugador ganar
             * o perder Se usa un pseudoaleatorio generado con el método
             * random() de Math (valor desde 0.0 hasta justo por debajo de 1.0),
             * se limita a dos posible y se agrega 1 con lo se obtendrá un
             * número entre 1 y 2.
             */
            int proposito = (int) Math.floor(Math.random() * 2) + 1;
            /**
             * Mensaje por consola pidiendo al jugador ganar o perder.
             */
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }
            /**
             * Variable int almacena jugada de la IA obtenida de forma
             * pseudoaleatoria.
             */
            int j = (int) Math.floor(Math.random() * 3) + 1;
            /**
             * Se almacena la opción que corresponda a la jugada de la IA. Se
             * muestra lo que la máquina ha jugado. Se dibuja en caracteres
             * ASCII por consola según la jugada.
             *
             * ----------- 1 es tijera 2 es papel 3 es piedra -----------
             *
             */
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();
            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();
            }
            /**
             * Bucle do, con condición al final, con lo que siempre se ejecutará
             * al menos una vez.
             */
            do {
                /**
                 * Muestra mensaje para avisar al jugador de que debe escribir
                 * su jugada.
                 */
                System.out.println("Introduce tu jugada");
                /**
                 * Se captura la respuesta del jugador y se almacena en la
                 * variable.
                 */
                opcionJugador = sc.nextLine();
                /**
                 * En caso de que ambas jugadas sean igual, se avisa y se
                 * reinicia el ciclo del do actual.
                 */
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
                /**
                 * He cambiado la comparación con == por equals ya que se trata
                 * de tipo String y el editor me hacia esta recomendación.
                 */
            } while (opcionBot.equals(opcionJugador));

            /**
             * Ahora se comparan las jugadas y se asigna a la variable
             * exitoEnProposito un 1 en caso de haber ganado la jugada del
             * juegador a la IA y un -1 en caso de haber perdido.
             */
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }
            /**
             * Ahora se evalua si se pidió ganar o perder, en caso de haber
             * pedido perder, se multiplica el resultado por -1 con lo que se
             * niega el resultado.
             */
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }
            /**
             * En caso de haber ganado el jugador, se incrementa el contador de
             * aciertos.
             */
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }
        /**
         * Variable long almacena momento en que finaliza el juego.
         */
        long fin = System.currentTimeMillis();
        /**
         * Variable double almacena haciendo casting la diferencia entre tiempo
         * final e inicial dividida entre 1000.
         */
        double tiempo = (double) ((fin - inicio) / 1000);
        /**
         * Se muestra un mensaje con el tiempo calculado.
         */
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        /**
         * Variable int almacena los errores calculando estos a partir de restar
         * al número de jugadas la cantidad de aciertos.
         */
        int nFallos = 5 - chiquipuntos;
        /**
         * Mensaje mostrando la posible penalización. Aquí la IA aplica
         * multiplicar por 5 el número de fallos.
         */
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        /**
         * Variable double almacena el tiempo final aplicando la penalización
         * prevista por la IA.
         */
        double tiempoFinal = tiempo + nFallos * 5;
        /**
         * Último mensaje con el tiempo ya el incremento por castigo previsto
         * por la IA en caso de haber fallos.
         */
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
    }

    /**
     * Método tijera imprime en caracteres ASCII un gráfico que representa a la
     * tijera.
     */
    public static void tijera() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " __________)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }

    /**
     * Método papel imprime en caracteres ASCII un gráfico que representa al
     * papel.
     */
    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " _______)\n"
                + " _______)\n"
                + "---.__________)");
    }

    /**
     * Método piedra imprime en caracteres ASCII un gráfico que representa a la
     * piedra.
     */
    public static void piedra() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)\n"
                + " (_____)\n"
                + " (_____)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}
