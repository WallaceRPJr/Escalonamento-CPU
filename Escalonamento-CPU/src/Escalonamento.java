import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Escalonamento {
    static int qtdeProcess;

    static boolean runner = true;
    static int aux = -1;
    static long tempoinicia;
    static long alltime;
    static long fim;

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        String nameProcess;
        int timeExecution;
        int timeEnterruption;
        int timeThatInterrupts;
        int priority;

        ArrayList<Processo> listProcess = new ArrayList<>();

        
         System.out.println("= Digite a quantidade de processos =");
         qtdeProcess = in.nextInt();
          
          for (int i = 1; i <= qtdeProcess; i++) {
          
          nameProcess = "P" + i;
          
          System.out.println("= Digite o tempo do processo " + nameProcess + " =");
          timeExecution = in.nextInt();
          
          System.out.println("= Digite a sua prioridade " + nameProcess + " =");
          priority = in.nextInt();
          
          System.out.println("= Digite o tempo de interrupção " + nameProcess + " =");
          System.out.println("Se caso nao tenha digite 0");
          timeEnterruption = in.nextInt();
          
          System.out.println("= Digite o momento da interrupção " + nameProcess +
          " =");
          timeThatInterrupts = in.nextInt();
          

         listProcess.add(new Processo(nameProcess, timeExecution, priority,
         timeEnterruption, timeThatInterrupts,
        false, 100, 0));
        }
        System.out.println("---------------------------------" + "\n" + "");
        

       /*  listProcess.add(new Processo("P1", 10, 0, 6, 4,
                false, 0, 0));

                
        listProcess.add(new Processo("P2", 3, 2, 2, 2,
                false, 0, 0)); */

        ArrayList<Processo> listProcessAux = new ArrayList<>();

        for (Processo p : listProcess)
            listProcessAux.add((Processo) p.clone());

        System.out.println("#####################################");
        System.out.println("### FCFS ###");
        System.out.println("");
        alltime = System.currentTimeMillis();
        FCFS(listProcessAux);

        listProcessAux = new ArrayList<>();
        for (Processo p : listProcess)
            listProcessAux.add((Processo) p.clone());

        System.out.println("#####################################");
        System.out.println("### SJF ###");
        System.out.println("");
        alltime = System.currentTimeMillis();
        SJF(listProcessAux);

        listProcessAux = new ArrayList<>();
        for (Processo p : listProcess)
            listProcessAux.add((Processo) p.clone());

        System.out.println("#####################################");
        System.out.println("### Dulling ###");
        System.out.println("");
        alltime = System.currentTimeMillis();
        Dulling(listProcessAux);

        listProcessAux = new ArrayList<>();
        for (Processo p : listProcess)
            listProcessAux.add((Processo) p.clone());

        System.out.println("#####################################");
        System.out.println("### RR ###");
        System.out.println("");
        alltime = System.currentTimeMillis();
        RR(listProcessAux);

    }

    private static void RR(ArrayList<Processo> i) throws InterruptedException {

        do {
            aux = 0;
            for (Processo x : i) {
                if (!x.getisInterrompido()) {
                    System.out.println("Executando " + x.getNameProcess());
                    System.out.println("Tempo: " + 1);
                    System.out.println("---------------------------------" + "\n" + "");
                    Thread.sleep(1000);
                    x.setTimeExecution(x.getTimeExecution() - 1);
                    x.setTempoTota(x.getTempoTota() + 1);
                    if (x.getTempoTota() == x.getTimeThatInterrupts()) {
                        x.setInterrompido(true);
                        fim = System.currentTimeMillis();
                        x.setLastRun(((int) fim - (int) alltime) / 1000);
                    }
                }
                if (x.getisInterrompido()) {
                    fim = System.currentTimeMillis();
                    if (((int) fim - (int) alltime) / 1000 >= x.getLastRun() + x.getTimeInterruption()) {
                        System.out.println("Executando " + x.getNameProcess());
                        System.out.println("Tempo: " + 1);
                        System.out.println("---------------------------------" + "\n" + "");
                        Thread.sleep(1000);
                        x.setTimeExecution(x.getTimeExecution() - 1);
                        x.setTempoTota(x.getTempoTota() + 1);
                    } else
                        aux++;

                }

                if (aux == i.size()) {
                    System.out.println(" == Sem processos para executar ==");
                    System.out.println("");
                    Thread.sleep(1000);
                }
            }

            for (int h = i.size() - 1; h >= 0; h--) {
                if (i.get(h).getTimeExecution() == 0) {
                    i.remove(h);
                }
            }

        } while (!i.isEmpty());
    }

    private static void Dulling(ArrayList<Processo> i) throws InterruptedException {
        ArrayList<Processo> filaProce = new ArrayList<>();
        do {

            i.sort(Comparator.comparing(Processo::getPriority));
            aux = 0;
            for (Processo x : i) {
                x = executar(x);
                filaProce.add(x);
            }

            if (aux == i.size()) {
                System.out.println(" == Sem processos para executar ==");
                System.out.println("");
                Thread.sleep(1000);
            }

            i.clear();

            for (int k = filaProce.size() - 1; k >= 0; k--) {
                if (filaProce.get(k).getTimeExecution() == 0) {
                    filaProce.remove(filaProce.get(k));
                } else
                    i.add(filaProce.get(k));
            }

        } while (!i.isEmpty());
    }

    private static void SJF(ArrayList<Processo> i) throws InterruptedException {
        ArrayList<Processo> filaProce = new ArrayList<>();
        do {

            i.sort(Comparator.comparing(Processo::getTimeExecution));
            aux = 0;
            for (Processo x : i) {
                x = executar(x);
                filaProce.add(x);
            }

            if (aux == i.size()) {
                System.out.println(" == Sem processos para executar ==");
                System.out.println("");
                Thread.sleep(1000);
            }

            i.clear();

            for (int k = filaProce.size() - 1; k >= 0; k--) {
                if (filaProce.get(k).getTimeExecution() == 0) {
                    filaProce.remove(filaProce.get(k));
                } else
                    i.add(filaProce.get(k));
            }

        } while (!i.isEmpty());
    }

    public static void FCFS(ArrayList<Processo> i) throws InterruptedException {

        ArrayList<Processo> filaProcess = new ArrayList<>();
        do {
            aux = 0;
            for (Processo x : i) {
                x = executar(x);
                filaProcess.add(x);
            }

            if (aux == i.size()) {
                System.out.println(" == Sem processos para executar ==");
                System.out.println("");
                Thread.sleep(1000);
            }

            i.clear();

            for (int k = filaProcess.size() - 1; k >= 0; k--) {
                if (filaProcess.get(k).getTimeExecution() == 0) {
                    filaProcess.remove(filaProcess.get(k));
                } else
                    i.add(filaProcess.get(k));
            }

        } while (!i.isEmpty());
    }

    public static Processo executar(Processo x) throws InterruptedException {
        if (x.getTimeInterruption() == 0) {

            System.out.println("Executando " + x.getNameProcess());
            System.out.println("Tempo: " + x.getTimeExecution());
            System.out.println("---------------------------------" + "\n" + "");
            Thread.sleep(x.getTimeExecution() * 1000);
            x.setTimeExecution(0);
            return x;

        }
        if (!x.getisInterrompido() && x.getTimeExecution() != 0) {
            System.out.println("Executando " + x.getNameProcess());
            System.out.println("Tempo: " + x.getTimeThatInterrupts());
            System.out.println("---------------------------------" + "\n" + "");
            Thread.sleep(x.getTimeThatInterrupts() * 1000);
            fim = System.currentTimeMillis();
            x.setLastRun(((int) fim - (int) alltime) / 1000);
            x.setInterrompido(true);
            return x;
        }
        if (x.getisInterrompido() && x.getTimeExecution() != 0) {

            fim = System.currentTimeMillis();

            if (((int) fim - (int) alltime) / 1000 >= x.getLastRun() + x.getTimeInterruption()) {
                System.out.println("Executando " + x.getNameProcess());
                System.out.println("Tempo: " + (x.getTimeExecution() - x.getTimeThatInterrupts()));
                System.out.println("---------------------------------" + "\n" + "");
                Thread.sleep((x.getTimeExecution() - x.getTimeThatInterrupts()) * 1000);

                x.setTimeExecution(0);
                return x;

            } else {
                aux++;
                return x;
            }
        }
        return x;
    }
}
