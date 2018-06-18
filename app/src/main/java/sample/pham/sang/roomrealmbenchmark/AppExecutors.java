package sample.pham.sang.roomrealmbenchmark;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static AppExecutors sAppExecutors;

    public static AppExecutors getInstance(){
        if(sAppExecutors == null){
            sAppExecutors = new AppExecutors();
        }
        return sAppExecutors;
    }

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    private AppExecutors() {
        this(Executors.newSingleThreadExecutor((Runnable r) -> {
            Thread t = new Thread(r);
//            t.setPriority(Process.THREAD_PRIORITY_BACKGROUND);
            return t;
        }), Executors.newFixedThreadPool(3, r -> {
            Thread t = new Thread(r);
//            t.setPriority(Process.THREAD_PRIORITY_BACKGROUND);
            return t;
        }), new MainThreadExecutor());
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}