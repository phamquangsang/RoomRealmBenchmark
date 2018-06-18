package sample.pham.sang.roomrealmbenchmark;

import android.app.Application;
import android.arch.persistence.room.Room;

import io.realm.Realm;

public class BenchMarkApp extends Application {

    public static FeedDb sFeedDb;
    @Override
    public void onCreate() {
        super.onCreate();
        sFeedDb = Room.databaseBuilder(this, FeedDb.class, "feed.db").fallbackToDestructiveMigration().build();
        Realm.init(this);
    }
}
