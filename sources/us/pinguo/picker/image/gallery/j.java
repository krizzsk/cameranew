package us.pinguo.picker.image.gallery;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import com.pinguo.album.a;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: LocalImage.java */
/* loaded from: classes5.dex */
public class j extends k {
    public static final String[] p = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "date_added", "date_modified", "_data", "orientation", "bucket_id", "_size", "0", "0"};
    private final Application n;
    public int o;

    /* compiled from: LocalImage.java */
    /* loaded from: classes5.dex */
    public static class a extends g {

        /* renamed from: g  reason: collision with root package name */
        private String f11708g;

        public a(Context context, String str, int i2, String str2) {
            super(context, str, i2, m.i(i2));
            this.f11708g = str2;
        }

        @Override // us.pinguo.picker.image.gallery.g
        public Bitmap c(a.c cVar, int i2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return com.pinguo.album.data.utils.a.e(cVar, this.f11708g, options, m.i(i2), i2);
        }
    }

    static {
        l();
    }

    public j(Application application, Path path, Cursor cursor) {
        super(path, n.d());
        this.n = application;
        k(cursor);
    }

    private void k(Cursor cursor) {
        this.f11709i = cursor.getInt(0);
        cursor.getString(1);
        cursor.getString(2);
        cursor.getDouble(3);
        cursor.getDouble(4);
        this.f11710j = cursor.getLong(5);
        this.f11711k = cursor.getString(8);
        cursor.getInt(10);
        cursor.getLong(11);
        this.o = cursor.getInt(9);
        this.f11712l = cursor.getInt(12);
        this.m = cursor.getInt(13);
    }

    @TargetApi(16)
    private static void l() {
        if (us.pinguo.util.c.m) {
            String[] strArr = p;
            strArr[12] = "width";
            strArr[13] = "height";
        }
    }

    @Override // us.pinguo.picker.image.gallery.m
    public int g() {
        return this.m;
    }

    @Override // us.pinguo.picker.image.gallery.m
    public int h() {
        int i2;
        while (true) {
            i2 = this.o;
            if (i2 >= 0) {
                break;
            }
            this.o = i2 + BaseBlurEffect.ROTATION_360;
        }
        int i3 = i2 % BaseBlurEffect.ROTATION_360;
        this.o = i3;
        if (i3 % 90 != 0) {
            int i4 = i3 % 90;
            if (i4 > 45) {
                this.o = ((i3 + 90) - i4) % BaseBlurEffect.ROTATION_360;
            } else {
                this.o = (i3 - i4) % BaseBlurEffect.ROTATION_360;
            }
        }
        us.pinguo.common.log.a.k("rotation = " + this.o, new Object[0]);
        return this.o;
    }

    @Override // us.pinguo.picker.image.gallery.m
    public int j() {
        return this.f11712l;
    }

    public j(Application application, Path path) {
        super(path, n.d());
        this.n = application;
        Cursor query = application.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, p, "datetaken=?", new String[]{String.valueOf(path.c())}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    k(query);
                    return;
                }
                throw new RuntimeException("cannot find data for: " + this.f11709i);
            } finally {
                query.close();
            }
        }
        throw new RuntimeException("cannot get cursor for: " + this.f11709i);
    }
}
