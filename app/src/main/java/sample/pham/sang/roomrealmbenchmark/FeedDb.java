package sample.pham.sang.roomrealmbenchmark;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {Feed.class}, version = 1)
@TypeConverters(AppConverters.class)
public abstract class FeedDb extends RoomDatabase {
    public abstract FeedDao feedDao();
}
