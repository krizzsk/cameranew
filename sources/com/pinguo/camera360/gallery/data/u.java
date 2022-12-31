package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pinguo.album.a;
import com.pinguo.camera360.gallery.util.GalleryDeleteUtil;
import java.io.File;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.utils.p0;
/* compiled from: LocalVideo.java */
/* loaded from: classes3.dex */
public class u extends t {
    static final String[] v = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "date_added", "date_modified", "_data", TypedValues.TransitionType.S_DURATION, "bucket_id", "_size", "resolution"};
    private final Application t;
    public int u;

    /* compiled from: LocalVideo.java */
    /* loaded from: classes3.dex */
    public static class a extends q {

        /* renamed from: f  reason: collision with root package name */
        private String f6384f;

        public a(Application application, Path path, int i2, String str) {
            super(application, str, i2, w.v(i2));
            this.f6384f = str;
        }

        @Override // com.pinguo.camera360.gallery.data.q
        protected Bitmap b(Bitmap bitmap, a.c cVar, LocalBlobCacheService localBlobCacheService) {
            Bitmap j2;
            int i2 = this.b;
            if (i2 == 2) {
                Bitmap j3 = com.pinguo.album.data.utils.b.j(bitmap, w.v(1), true);
                localBlobCacheService.d(this.a, 1, com.pinguo.album.data.utils.b.a(j3));
                j2 = com.pinguo.album.data.utils.b.h(j3, this.c, true);
            } else if (i2 == 3) {
                int i3 = this.c;
                float f2 = this.f6373d;
                j2 = com.pinguo.album.data.utils.b.k(bitmap, i3, (int) (i3 * f2), f2, this.f6374e, true);
                us.pinguo.common.log.a.s("resizeSameRadioAndCropCenter decode orig bitmap " + j2.getWidth() + "/" + j2.getHeight(), new Object[0]);
            } else {
                j2 = com.pinguo.album.data.utils.b.j(bitmap, this.c, true);
            }
            if (cVar.isCancelled()) {
                return null;
            }
            byte[] a = com.pinguo.album.data.utils.b.a(j2);
            if (cVar.isCancelled()) {
                return null;
            }
            localBlobCacheService.d(this.a, this.b, a);
            return this.b != 2 ? BitmapFactory.decodeByteArray(a, 0, a.length) : j2;
        }

        @Override // com.pinguo.camera360.gallery.data.q
        public Bitmap c(a.c cVar, int i2) {
            Bitmap e2 = com.pinguo.album.data.utils.b.e(this.f6384f);
            if (e2 == null || cVar.isCancelled()) {
                return null;
            }
            return e2;
        }
    }

    public u(Application application, Path path, Cursor cursor) {
        super(path, x.j());
        this.t = application;
        H(cursor);
    }

    private void H(Cursor cursor) {
        this.f6380i = cursor.getInt(0);
        this.f6381j = cursor.getString(1);
        this.f6382k = cursor.getString(2);
        this.m = cursor.getDouble(3);
        this.n = cursor.getDouble(4);
        this.o = cursor.getLong(5);
        cursor.getLong(6);
        cursor.getLong(7);
        this.p = cursor.getString(8);
        this.u = cursor.getInt(9) / 1000;
        this.q = cursor.getInt(10);
        this.f6383l = cursor.getLong(11);
        I(cursor.getString(12));
    }

    private void I(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(120)) == -1) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            int parseInt2 = Integer.parseInt(str.substring(indexOf + 1));
            this.r = parseInt;
            this.s = parseInt2;
        } catch (Throwable th) {
            us.pinguo.common.log.a.t(th);
        }
    }

    private static String J(int i2) {
        if (i2 <= 0) {
            return "00:00";
        }
        int i3 = i2 / 60;
        if (i3 < 60) {
            return K(i3) + ":" + K(i2 % 60);
        }
        int i4 = i3 / 60;
        if (i4 > 99) {
            return "99:59:59";
        }
        int i5 = i3 % 60;
        return K(i4) + ":" + K(i5) + ":" + K((i2 - (i4 * 3600)) - (i5 * 60));
    }

    private static String K(int i2) {
        if (i2 >= 0 && i2 < 10) {
            return "0" + Integer.toString(i2);
        }
        return "" + i2;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<Bitmap> A(int i2) {
        return new a(this.t, g(), i2, this.p);
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<BitmapRegionDecoder> B() {
        throw new UnsupportedOperationException("Cannot regquest a large image to a local video!");
    }

    public int F() {
        String str;
        if (this.u > 0 || (str = this.p) == null || !str.contains("/C360VID_")) {
            return this.u;
        }
        return 6;
    }

    public String G() {
        String str;
        return (this.u > 0 || (str = this.p) == null || !str.contains("/C360VID_")) ? J(this.u) : "00:06";
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void c(boolean z) {
        com.pinguo.album.j.c.a();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        us.pinguo.common.log.a.k("delete id = " + this.f6380i, new Object[0]);
        if (p0.b(this)) {
            GalleryDeleteUtil.a.g(true, Integer.valueOf(this.f6380i));
        } else {
            this.t.getContentResolver().delete(uri, "_id=?", new String[]{String.valueOf(this.f6380i)});
        }
    }

    @Override // com.pinguo.camera360.gallery.data.t, com.pinguo.camera360.gallery.data.x
    public v e() {
        v e2 = super.e();
        if (this.u > 0) {
            e2.a(8, com.pinguo.album.j.c.f(com.pinguo.album.e.e().b(), this.u));
        }
        return e2;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public int f() {
        return 4;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean k() {
        return false;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean l() {
        return new File(this.p).exists();
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int q() {
        return this.s;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int w() {
        return this.r;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean y() {
        return true;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<Bitmap> z(int i2) {
        return new a(this.t, g(), i2, this.p);
    }

    public u(Application application, Path path) {
        super(path, x.j());
        this.t = application;
        Cursor query = application.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, v, "datetaken=?", new String[]{String.valueOf(path.g())}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    us.pinguo.common.log.a.k("LocalVideo start loop", new Object[0]);
                    H(query);
                    return;
                }
                throw new RuntimeException("cannot find data for: " + path);
            } finally {
                query.close();
            }
        }
        throw new RuntimeException("cannot get cursor for: " + path);
    }
}
