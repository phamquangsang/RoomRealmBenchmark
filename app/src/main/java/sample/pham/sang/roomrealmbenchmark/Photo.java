package sample.pham.sang.roomrealmbenchmark;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

public class Photo {

    private String originUrl;   //origin
    private String largeUrl;    //for FHD 1920x1080
    private String mediumUrl;   //for HD 1280x720
    private String smallUrl;    //for qHD 960x540
    private String thumbnailUrl;//for thumbnail 150x150
    private int width;
    private int height;

    public Photo() {
    }

    public Photo(String originUrl, String largeUrl, String smallUrl, String thumbnailUrl, int width, int height) {
        this.originUrl = originUrl;
        this.largeUrl = largeUrl;
        this.smallUrl = smallUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.width = width;
        this.height = height;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (width != photo.width) return false;
        if (height != photo.height) return false;
        if (originUrl != null ? !originUrl.equals(photo.originUrl) : photo.originUrl != null)
            return false;
        if (largeUrl != null ? !largeUrl.equals(photo.largeUrl) : photo.largeUrl != null)
            return false;
        if (mediumUrl != null ? !mediumUrl.equals(photo.mediumUrl) : photo.mediumUrl != null)
            return false;
        if (smallUrl != null ? !smallUrl.equals(photo.smallUrl) : photo.smallUrl != null)
            return false;
        return thumbnailUrl != null ? thumbnailUrl.equals(photo.thumbnailUrl) : photo.thumbnailUrl == null;
    }

    @Override
    public int hashCode() {
        int result = originUrl != null ? originUrl.hashCode() : 0;
        result = 31 * result + (largeUrl != null ? largeUrl.hashCode() : 0);
        result = 31 * result + (mediumUrl != null ? mediumUrl.hashCode() : 0);
        result = 31 * result + (smallUrl != null ? smallUrl.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    protected Photo(Parcel in) {
        this.originUrl = in.readString();
        this.largeUrl = in.readString();
        this.mediumUrl = in.readString();
        this.smallUrl = in.readString();
        this.thumbnailUrl = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
    }


    @Override
    public String toString() {
        return "Photo{" +
                "originUrl='" + originUrl + '\'' +
                ", largeUrl='" + largeUrl + '\'' +
                ", mediumUrl='" + mediumUrl + '\'' +
                ", smallUrl='" + smallUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}