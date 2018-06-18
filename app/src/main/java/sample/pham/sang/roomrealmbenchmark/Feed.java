package sample.pham.sang.roomrealmbenchmark;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;
import java.util.List;

import io.realm.RealmObject;


@Entity(tableName = "feeds")
public class Feed {
    @NonNull @PrimaryKey
    private String feedId;
    @TypeConverters(AppConverters.class)
    private List<Photo> photos;
    private int commentCount;
    private int likeCount;
    private boolean isLiked;
    private String content;
    @Nullable
    private Date timeCreated;
    private Date timeUpdated;

    private int status;

    private boolean likeInProgress;

    public Feed() {
    }

    @Ignore
    public Feed(@NonNull String feedId, List<Photo> photos, int commentCount, int likeCount, boolean isLiked, String content, @Nullable Date timeCreated, Date timeUpdated, int status, boolean likeInProgress) {
        this.feedId = feedId;
        this.photos = photos;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.isLiked = isLiked;
        this.content = content;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
        this.status = status;
        this.likeInProgress = likeInProgress;
    }

    @NonNull
    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(@NonNull String feedId) {
        this.feedId = feedId;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Nullable
    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(@Nullable Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public boolean isLikeInProgress() {
        return likeInProgress;
    }

    public void setLikeInProgress(boolean likeInProgress) {
        this.likeInProgress = likeInProgress;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "feedId='" + feedId + '\'' +
//                ", photos=" + photos +
                ", photos=" + photos.get(0).toString() +
                ", commentCount=" + commentCount +
                ", likeCount=" + likeCount +
                ", isLiked=" + isLiked +
                ", content='" + content + '\'' +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                ", status=" + status +
                ", likeInProgress=" + likeInProgress +
                '}';
    }
}