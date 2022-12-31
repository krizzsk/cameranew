package com.pinguo.camera360.gallery.data;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.os.Build;
import android.provider.MediaStore;
import com.pinguo.album.a;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.pinguo.camera360.gallery.util.GalleryDeleteUtil;
import java.io.File;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.utils.p0;
/* compiled from: LocalImage.java */
/* loaded from: classes3.dex */
public class s extends t {
    public static final String[] v = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "date_added", "date_modified", "_data", "orientation", "bucket_id", "_size", "0", "0"};
    private final Application t;
    public int u;

    /* compiled from: LocalImage.java */
    /* loaded from: classes3.dex */
    public static class a extends q {

        /* renamed from: f  reason: collision with root package name */
        private String f6379f;

        public a(Application application, String str, int i2, String str2) {
            super(application, str, i2, w.v(i2));
            this.f6379f = str2;
        }

        @Override // com.pinguo.camera360.gallery.data.q
        public Bitmap c(a.c cVar, int i2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            return com.pinguo.album.data.utils.a.e(cVar, this.f6379f, options, w.v(i2), i2);
        }
    }

    /* compiled from: LocalImage.java */
    /* loaded from: classes3.dex */
    public static class b implements a.b<BitmapRegionDecoder> {
        String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.pinguo.album.a.b
        @SuppressLint({"NewApi"})
        /* renamed from: b */
        public BitmapRegionDecoder a(a.c cVar) {
            return com.pinguo.album.data.utils.a.a(cVar, this.a, false);
        }
    }

    static {
        G();
    }

    public s(Application application, Path path, Cursor cursor) {
        super(path, x.j());
        this.t = application;
        F(cursor);
    }

    private void F(Cursor cursor) {
        this.f6380i = cursor.getInt(0);
        this.f6381j = cursor.getString(1);
        this.f6382k = cursor.getString(2);
        this.m = cursor.getDouble(3);
        this.n = cursor.getDouble(4);
        this.o = cursor.getLong(5);
        this.p = cursor.getString(8);
        this.q = cursor.getInt(10);
        this.f6383l = cursor.getLong(11);
        this.u = cursor.getInt(9);
        this.r = cursor.getInt(12);
        this.s = cursor.getInt(13);
    }

    @TargetApi(16)
    private static void G() {
        if (us.pinguo.util.c.m) {
            String[] strArr = v;
            strArr[12] = "width";
            strArr[13] = "height";
        }
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<Bitmap> A(int i2) {
        String str = this.p;
        if (str != null && str.length() > 0) {
            this.p = str;
        }
        Application application = this.t;
        String str2 = this.p;
        a aVar = new a(application, str2, i2, str2);
        aVar.e(this.u);
        return aVar;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<BitmapRegionDecoder> B() {
        if (Build.VERSION.SDK_INT >= 10) {
            String str = this.p;
            if (str != null && str.length() > 0) {
                this.p = str;
            }
            return new b(this.p);
        }
        return null;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void c(boolean z) {
        com.pinguo.album.j.c.a();
        if (p0.b(this)) {
            GalleryDeleteUtil.a.g(false, Integer.valueOf(this.f6380i));
            return;
        }
        String str = this.p;
        if (str != null && str.length() > 0) {
            File file = new File(this.p);
            if (file.exists()) {
                file.delete();
            }
        }
        this.t.getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{String.valueOf(this.f6380i)});
        BigAlbumManager.instance().deletePhotoBySystemDbId(this.f6380i);
    }

    @Override // com.pinguo.camera360.gallery.data.t, com.pinguo.camera360.gallery.data.x
    public v e() {
        v e2 = super.e();
        e2.a(7, Integer.valueOf(this.u));
        v.b(e2, this.p);
        return e2;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public int f() {
        return 2;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public int h() {
        int i2 = Build.VERSION.SDK_INT >= 10 ? 1645 : 1581;
        if (com.pinguo.album.data.utils.b.g(this.f6382k)) {
            i2 |= 2;
        }
        return com.pinguo.album.j.c.l(this.m, this.n) ? i2 | 16 : i2;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean k() {
        return false;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean l() {
        if (this.p == null) {
            return false;
        }
        return new File(this.p).exists();
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int q() {
        return this.s;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int t() {
        int i2;
        while (true) {
            i2 = this.u;
            if (i2 >= 0) {
                break;
            }
            this.u = i2 + BaseBlurEffect.ROTATION_360;
        }
        int i3 = i2 % BaseBlurEffect.ROTATION_360;
        this.u = i3;
        if (i3 % 90 != 0) {
            int i4 = i3 % 90;
            if (i4 > 45) {
                this.u = ((i3 + 90) - i4) % BaseBlurEffect.ROTATION_360;
            } else {
                this.u = (i3 - i4) % BaseBlurEffect.ROTATION_360;
            }
        }
        us.pinguo.common.log.a.k("rotation = " + this.u, new Object[0]);
        return this.u;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int w() {
        return this.r;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean y() {
        return false;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<Bitmap> z(int i2) {
        return A(i2);
    }

    public s(Application application, Path path) {
        super(path, x.j());
        this.t = application;
        Cursor query = application.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, v, "datetaken=?", new String[]{String.valueOf(path.g())}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    F(query);
                    return;
                }
                throw new RuntimeException("cannot find data for: " + this.f6380i);
            } finally {
                query.close();
            }
        }
        throw new RuntimeException("cannot get cursor for: " + this.f6380i);
    }
}
