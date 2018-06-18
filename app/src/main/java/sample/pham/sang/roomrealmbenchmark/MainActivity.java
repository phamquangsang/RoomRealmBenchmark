package sample.pham.sang.roomrealmbenchmark;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class MainActivity extends AppCompatActivity implements FeedFragment.OnListFragmentInteractionListener,
        FeedRealmFragment.OnListFragmentInteractionListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FeedRealmFragment realmFragment = FeedRealmFragment.newInstance(1);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, realmFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    generateRealmDb();
                    generateDb();
                    return true;
                case R.id.navigation_notifications:
                    FeedFragment feedFragment = FeedFragment.newInstance(1, true);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, feedFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void generateDb() {
        List<Feed> feeds = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Feed feed = new Feed();
            feed.setFeedId(String.valueOf(i));
            feed.setContent("SOLID Single Responsibility, Open Close, Liskov, SOLID Single Responsibility, Open Close, Liskov, kkk");


            List<Photo> photos = new ArrayList<>();
            photos.add(new Photo("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new Photo("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new Photo("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new Photo("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new Photo("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new Photo("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            feed.setPhotos(photos);
            feeds.add(feed);
        }
        AppExecutors.getInstance().diskIO().execute(()->{
            Trace.beginSection("room saving 100 feeds");
            BenchMarkApp.sFeedDb.feedDao().insertFeeds(feeds);
            Trace.endSection();
            Log.i("MainActivity", "insertFeeds succeed");
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void generateRealmDb(){
        List<FeedRealm> feeds = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            FeedRealm feed = new FeedRealm();
            feed.setFeedId(String.valueOf(i));
            feed.setContent("SOLID Single Responsibility, Open Close, Liskov, SOLID Single Responsibility, Open Close, Liskov, kkk");


            RealmList<PhotoRealm> photos = new RealmList<>();
            photos.add(new PhotoRealm("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new PhotoRealm("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new PhotoRealm("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new PhotoRealm("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new PhotoRealm("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            photos.add(new PhotoRealm("https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg",
                    "https://academy-stg-assets.s3.amazonaws.com/wall/user_50/32bTogWIn0R1xiSmZ1vM1523588835014.jpg", 640, 480));
            feed.setPhotos(photos);
            feeds.add(feed);
        }
        AppExecutors.getInstance().diskIO().execute(() -> {
            Realm realm = Realm.getDefaultInstance();
            Trace.beginSection("realm saving 100 feeds");
            realm.beginTransaction();
            realm.copyToRealm(feeds); // Persist unmanaged objects
            realm.commitTransaction();
            Trace.endSection();
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    @Override
    public void onListFragmentInteraction(Feed item) {

    }

    @Override
    public void onListFragmentInteraction(FeedRealm item) {

    }
}
