package sample.pham.sang.roomrealmbenchmark;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class FeedRealm extends RealmObject {
    @NonNull
    private String feedId;
    private RealmList<PhotoRealm> photos;
    private int commentCount;
    private int likeCount;
    private boolean isLiked;
    private String content;
    @Nullable
    private Date timeCreated;
    private Date timeUpdated;

    private int status;

    private boolean likeInProgress;

    public FeedRealm() {
    }

    public FeedRealm(@NonNull String feedId, RealmList<PhotoRealm> photos, int commentCount, int likeCount, boolean isLiked, String content, @Nullable Date timeCreated, Date timeUpdated, int status, boolean likeInProgress) {
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

    public List<PhotoRealm> getPhotos() {
        return photos;
    }

    public void setPhotos(RealmList<PhotoRealm> photos) {
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
        StringBuilder builder = new StringBuilder();
        for (PhotoRealm photo :
                photos) {
            builder.append(photo.toString()).append(",");
        }
        return "Feed{" +
                "feedId='" + feedId + '\'' +
                ", photos=" + builder.toString() +
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

