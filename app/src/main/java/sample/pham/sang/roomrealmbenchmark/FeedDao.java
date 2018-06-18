package sample.pham.sang.roomrealmbenchmark;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public abstract class FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Feed... feeds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertFeeds(List<Feed> feeds);

    @Query("Select * from feeds")
    public abstract LiveData<List<Feed>> loadAll();
}
