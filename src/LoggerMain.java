import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LoggerMain {
    private static final Logger log = new Logger("c:/logs/LoggerMain.log");

    private static final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread started " + Thread.currentThread().getId());
            long start = System.currentTimeMillis();
            while (start + 10000 > System.currentTimeMillis()) {
                log.write(Logger.Status.INFO, "Запись в лог");
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(1L));
                } catch (InterruptedException e) {
                }
            }
        }
    };

    public static void main(String[] args) throws InterruptedException, IOException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }

        log.printLogToConsole();
    }

    private static class Logger {
        private final String fileName;
        private final Path path;
        private final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("HH:mm:ss");
            }
        };

        private Logger(String fileName) {
            this.fileName = fileName;
            this.path = Paths.get(this.fileName);
            try {
                Files.deleteIfExists(this.path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void write(Status status, String s) {
            String str = df.get().format(new Date()) + " " + status.toString() + " " + Thread.currentThread().getId() + ": " + s + "\n";
            write(str);
        }
        private synchronized void write(String str){
            try {
                Files.write(path, str.getBytes("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void printLogToConsole() throws IOException {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }


        }

        private enum Status {
            WARN, INFO, TRACE, CRITICAL
        }
    }
}
