package us.pinguo.bigalbum;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import java.util.List;
import us.pinguo.bigalbum.entity.Gallery;
import us.pinguo.bigalbum.entity.Photo;
import us.pinguo.bigalbum.entity.PhotoAddress;
import us.pinguo.bigalbum.entity.PhotoTag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface IBigAlbumModel {
    void addPhotoToGallery(int i2, List<Integer> list);

    void commitMapGallery();

    void deleteGallery(int i2);

    void deletePhoto(int i2);

    void deletePhotoBySystemDbId(int i2);

    void deletePhotoFromGallery(int i2, List<Integer> list);

    Photo[] getFirstFavAndLocalPhoto();

    Gallery getGallery(int i2);

    Photo getGalleryCoverPhoto(int i2);

    Photo getPhoto(int i2);

    List<Photo> getPhotosOrderBy(String str);

    void init(Handler handler);

    void insertGallery(Gallery gallery, List<Integer> list);

    void insertPhoto(Photo photo);

    void insertPhotoAddress(List<PhotoAddress> list);

    void insertPhotoTag(List<PhotoTag> list);

    boolean isAlreadyMapGallery();

    void login(String str, String str2);

    void logout();

    Cursor queryGallery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4);

    Cursor queryPhoto(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4);

    void rollbackMapGallery();

    void scan();

    void syncSystem(boolean z);

    void updateGallery(int i2, ContentValues contentValues);

    void updateGallery(Gallery gallery);

    void updatePhoto(int i2, ContentValues contentValues, boolean z);

    void updatePhoto(ContentValues contentValues, String str, String[] strArr, boolean z);

    void updatePhoto(Photo photo, boolean z);
}
