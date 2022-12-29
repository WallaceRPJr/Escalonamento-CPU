public class Processo {

    String nameProcess;
    int timeExecution;
    int priority;
    int timeInterruption;
    int timeThatInterrupts;


    public Processo(String nameProcess, int timeExecution, int priority, int timeEnterruption, int timeThatInterrupts) {
        this.nameProcess = nameProcess;
        this.timeExecution = timeExecution;
        this.priority = priority;
        this.timeInterruption = timeEnterruption;
        this.timeThatInterrupts = timeThatInterrupts;
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

}
