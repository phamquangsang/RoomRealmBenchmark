package sample.pham.sang.roomrealmbenchmark;

import android.arch.persistence.room.TypeConverter;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AppConverters {
    public static Gson gson = new Gson();

    @TypeConverter
    public static Long dateToLong(Date date){
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Date longToDate(Long dateAsLong){
        return dateAsLong == null ? null : new Date(dateAsLong);
    }

    @TypeConverter
    public static String listStringToString(List<String> list){
        return TextUtils.join(",",list);
    }

    @TypeConverter
    public static List<String> stringBackToList(String lists){
        return Arrays.asList(TextUtils.split(lists, ","));
    }

    @TypeConverter
    public static String listPhotosToJson(List<Photo> photos){
        return gson.toJson(photos);
    }

    @TypeConverter
    public static List<Photo> jsonToListPhoto(String photosJson){
        return gson.fromJson(photosJson, new TypeToken<List<Photo>>(){}.getType());
    }
}
