public class Processo implements Cloneable{

    String nameProcess;
    int timeExecution;
    int priority;
    int timeInterruption;
    int timeThatInterrupts;
    boolean interrompido;
    int tempoTota;
    int lastRun;

    public Processo(String nameProcess, int timeExecution, int priority, int timeInterruption, int timeThatInterrupts,
            boolean interrompido, int tempoTota, int lastRun) {
        this.nameProcess = nameProcess;
        this.timeExecution = timeExecution;
        this.priority = priority;
        this.timeInterruption = timeInterruption;
        this.timeThatInterrupts = timeThatInterrupts;
        this.interrompido = interrompido;
        this.tempoTota = tempoTota;
        this.lastRun = lastRun;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
     }


    public int getLastRun() {
        return lastRun;
    }


    public void setLastRun(int lastRun) {
        this.lastRun = lastRun;
    }


    public int getTempoTota() {
        return tempoTota;
    }


    public void setTempoTota(int tempoTota) {
        this.tempoTota = tempoTota;
    }


    @Override
    public String toString() {
        return "Processo [nameProcess=" + nameProcess + ", timeExecution=" + timeExecution + ", priority=" + priority
                + ", timeEnterruption=" + timeInterruption + "timeThatInterrupts" + timeThatInterrupts + "]";
    }


    public String getNameProcess() {
        return nameProcess;
    }
    public void setNameProcess(String nameProcess) {
        this.nameProcess = nameProcess;
    }
    public int getTimeExecution() {
        return timeExecution;
    }
    public void setTimeExecution(int timeExecution) {
        this.timeExecution = timeExecution;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getTimeInterruption() {
        return timeInterruption;
    }
    public void setTimeInterruption(int timeEnterruption) {
        this.timeInterruption = timeEnterruption;
    }


    public int getTimeThatInterrupts() {
        return timeThatInterrupts;
    }


    public void setTimeThatInterrupts(int timeThatInterrupts) {
        this.timeThatInterrupts = timeThatInterrupts;
    }

    public boolean getisInterrompido() {
        return interrompido;
    }


    public void setInterrompido(boolean interrompido) {
        this.interrompido = interrompido;
    }

}
