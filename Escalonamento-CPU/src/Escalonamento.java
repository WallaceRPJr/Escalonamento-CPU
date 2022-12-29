import java.util.ArrayList;
import java.util.Scanner;

public class Escalonamento {
        static int qtdeProcess;
        static ArrayList<Processo> listProcess = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);

        
        String nameProcess;
        int timeExecution;
        int timeEnterruption;
        int timeThatInterrupts;
        int priority;

        

        System.out.println("Digite a quantidade de processos:");
        qtdeProcess = in.nextInt();

        for(int i = 1; i <= qtdeProcess; i++){

            nameProcess = "P" + i;
            
            System.out.println("Digite o tempo do processo " + nameProcess + ":" );
            timeExecution = in.nextInt();

            System.out.println("Digite a sua prioridade " + nameProcess + ":" );
            priority = in.nextInt();

            System.out.println("Digite o tempo de interrupção " + nameProcess + ":" );
            System.out.println("Se caso nao tenha digite 0");
            timeEnterruption = in.nextInt();

            System.out.println("Digite o momento da interrupção " + nameProcess + ":" );
            timeThatInterrupts = in.nextInt();

            listProcess.add(new Processo(nameProcess, timeExecution, priority, timeEnterruption, timeThatInterrupts));

            

        }

        FCFS();
        
    }

    public static void FCFS () throws InterruptedException{
        for (int i = 0; i < qtdeProcess; i++){
            
           String nameProcess = listProcess.get(i).getNameProcess();
           System.out.println(" ");
           System.out.println("Executando processo: " + nameProcess);
           System.out.println("Tempo total:" + listProcess.get(i).getTimeExecution());

           for(int j = 0; j <= listProcess.get(i).getTimeExecution(); j++){
                System.out.println("TEMPO: " + j);
                Thread.sleep(1000);

                if(listProcess.get(i).getTimeInterruption() != 0 && listProcess.get(i).getTimeInterruption() == j){
                    System.out.println("    Interrupção");
                    for (int k = 0; k<= listProcess.get(i).getTimeInterruption(); k++){
                        System.out.println("    TEMPO: " + k);
                        Thread.sleep(1000);
                    }
                    System.out.println("    Fim da Interrupção");
                    System.out.println(" ");
                }
           }
        }
    }

}
