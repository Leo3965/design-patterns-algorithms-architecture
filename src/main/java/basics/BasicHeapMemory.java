package basics;

import java.util.Scanner;

public class BasicHeapMemory {

    public static void main(String[] args) {
        criaObjetosDeUmGigaNoHeap();

    }

    // Xmx --> Aumentando tamanho da memoria heap
    // java -Xmx900M .\src\main\java\basics\BasicHeapMemory.java
    // java -Xmx2G .\src\main\java\basics\BasicHeapMemory.java

    // Xms --> Quantidade de memória reservada logo ao início do programa
    // java -Xmx5G -Xms400M .\src\main\java\basics\BasicHeapMemory.java
    private static void criaObjetosDeUmGigaNoHeap() {
        imprimirUsoMemoria();
        byte[] x = new byte[500 * 1024 * 1024];
        imprimirUsoMemoria();

        System.gc(); // Perdindo para que o garbage collector rode
        imprimirUsoMemoria();
    }

    private static void imprimirUsoMemoria() {
        System.out.printf("Máxima: %s%n", emMegaBytes(Runtime.getRuntime().maxMemory()));

        System.out.printf("Total empenhada: %s%n", emMegaBytes(Runtime.getRuntime().totalMemory()));

        System.out.printf("Disponível : %s%n", emMegaBytes(Runtime.getRuntime().freeMemory()));

        long usada = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.printf("Usada : %s%n%n", emMegaBytes(usada));
    }

    private static String emMegaBytes(long bytes) {
        return String.format("%.2fMB", (bytes / 1024d / 1024d));
    }

    static void readName() {
        var scanner = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        var nome = scanner.nextLine();

        System.out.println("nome = " + nome);
    }
    // Roda programa java com tracking de memória
    // java -XX:NativeMemoryTracking=summary .\src\main\java\basics\BasicHeapMemory.java
    // jcmd --> lista processos java
    // jcmd id-processo --> lista comandos para o processo
    // jcmd 12004 VM.native_memory summary -->  mostra um diagnóstico de memória
}




