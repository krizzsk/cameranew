package us.pinguo.picker.image.gallery;

import android.app.Application;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: LocalVideo.java */
/* loaded from: classes5.dex */
public class l extends k {
    static final String[] n = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "date_added", "date_modified", "_data", TypedValues.TransitionType.S_DURATION, "bucket_id", "_size", "resolution"};

    public l(Application application, Path path, Cursor cursor) {
        super(path, n.d());
        k(cursor);
    }

    private void k(Cursor cursor) {
        this.f11709i = cursor.getInt(0);
        cursor.getString(1);
        cursor.getString(2);
        cursor.getDouble(3);
        cursor.getDouble(4);
        this.f11710j = cursor.getLong(5);
        cursor.getLong(6);
        cursor.getLong(7);
        this.f11711k = cursor.getString(8);
        int i2 = cursor.getInt(9) / 1000;
        cursor.getInt(10);
        cursor.getLong(11);
        l(cursor.getString(12));
    }

    private void l(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(120)) == -1) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            int parseInt2 = Integer.parseInt(str.substring(indexOf + 1));
            this.f11712l = parseInt;
            this.m = parseInt2;
        } catch (Throwable th) {
            us.pinguo.common.log.a.t(th);
        }
    }

    @Override // us.pinguo.picker.image.gallery.m
    public int g() {
        return this.m;
    }

    @Override // us.pinguo.picker.image.gallery.m
    public int j() {
        return this.f11712l;
    }
}
