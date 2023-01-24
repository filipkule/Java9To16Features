import java.io.IOException;

public class ProcessorApi {
    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        ProcessHandle.Info info = currentProcess.info();
        System.out.println("Process Id: " + currentProcess.pid());
        System.out.println("Direct children: " + currentProcess.children());
        System.out.println("Class name: " + currentProcess.getClass());
        System.out.println("All processes: " + ProcessHandle.allProcesses());
        System.out.println("Process info: " + info);
        System.out.println("Process command: " + info.command());
        System.out.println("Process arguments: " + info.arguments());
        System.out.println("Is process alive: " + currentProcess.isAlive());
        System.out.println("Process's parent " + currentProcess.parent());


        System.out.println("=============================================================");
        System.out.println("Start notepad using process api");
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        String np = "Not Present";
        Process notepadProcess = null;
        try {
            notepadProcess = pb.start();
            ProcessHandle notepadProcessHandle = notepadProcess.toHandle();
            ProcessHandle.Info notepadInfo = notepadProcess.info();//notepadProcessHandle.info(); also possible
            System.out.printf("Process ID : %s%n", notepadProcess.pid());
            System.out.printf("Command name : %s%n", notepadInfo.command().orElse(np));
            System.out.printf("Command line : %s%n", notepadInfo.commandLine().orElse(np));
            Thread.sleep(2000);
            System.out.println("Wait 2 seconds than kill the process");
            notepadProcess.destroy();//notepadProcessHandle.destroy() also possible
            System.out.println("Is process alive: " + notepadProcessHandle.isAlive());//notepadProcess.isAlive() also possible
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
