package com.pinguo.camera360.gallery.data;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pinguo.album.a;
import com.pinguo.album.data.download.PGImageDownloader;
import com.pinguo.album.data.utils.d;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.pinguo.camera360.gallery.data.s;
import com.pinguo.camera360.gallery.temps.SandBox;
import com.pinguo.camera360.gallery.util.GalleryDeleteUtil;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.utils.p0;
import vStudio.Android.Camera360.R;
/* compiled from: BigAlbumImage.java */
/* loaded from: classes3.dex */
public class h extends w {
    public static final String[] w = {"_id", BigAlbumStore.PhotoColumns.LOCAL_PATH, BigAlbumStore.PhotoColumns.CLOUD_RESOURCE_ID, "createDate", "width", "height", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, BigAlbumStore.PhotoColumns.MIME_TYPE, BigAlbumStore.PhotoColumns.IS_FAV, BigAlbumStore.PhotoColumns.SIZE, "orientation", BigAlbumStore.PhotoColumns.PROJECT_STATE, BigAlbumStore.PhotoColumns.JSON_EXPAND, BigAlbumStore.PhotoColumns.FAV_TIME};
    public static final String[] x = {"_id", "createDate"};

    /* renamed from: i  reason: collision with root package name */
    private final Application f6357i;

    /* renamed from: j  reason: collision with root package name */
    public int f6358j;

    /* renamed from: k  reason: collision with root package name */
    public String f6359k;

    /* renamed from: l  reason: collision with root package name */
    public String f6360l;
    public long m;
    public int n;
    public int o;
    public String p;
    public double q;
    public double r;
    public boolean s;
    public int t;
    public String u;
    public String v;

    /* compiled from: BigAlbumImage.java */
    /* loaded from: classes3.dex */
    class a extends q {
        a(h hVar, Application application, String str, int i2, int i3) {
            super(application, str, i2, i3);
        }

        @Override // com.pinguo.camera360.gallery.data.q
        public Bitmap c(a.c cVar, int i2) {
            return null;
        }
    }

    /* compiled from: BigAlbumImage.java */
    /* loaded from: classes3.dex */
    public class b extends q {

        /* renamed from: f  reason: collision with root package name */
        String f6361f;

        public b(h hVar, Application application, String str, int i2, String str2) {
            super(application, str, i2, w.v(i2));
            this.f6361f = str2;
        }

        @Override // com.pinguo.camera360.gallery.data.q
        public Bitmap c(a.c cVar, int i2) {
            String str;
            InputStream inputStream;
            Bitmap b;
            int v = w.v(i2);
            if (i2 == 2) {
                str = this.f6361f + "w/" + v + "/h/" + v;
            } else {
                str = this.f6361f + "w/" + v;
            }
            try {
                inputStream = new PGImageDownloader(com.pinguo.album.e.e().b()).b(str, null);
            } catch (IOException e2) {
                us.pinguo.common.log.a.k(" [fail]:" + this.f6361f + e2.toString(), new Object[0]);
                com.pinguo.album.j.a.f(null);
                inputStream = null;
            }
            if (inputStream == null || cVar.isCancelled()) {
                return null;
            }
            d.b b2 = w.m().b();
            try {
                b2.a(cVar, inputStream);
                if (cVar.isCancelled()) {
                    return null;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                if (com.pinguo.album.common.a.a) {
                    b = com.pinguo.album.data.utils.a.f(cVar, b2.a, b2.b, b2.c, options);
                } else {
                    b = com.pinguo.album.data.utils.a.b(cVar, b2.a, b2.b, b2.c, options);
                }
                if (b == null && !cVar.isCancelled()) {
                    us.pinguo.common.log.a.s("decode cached failed", new Object[0]);
                }
                w.m().c(b2);
                return b;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } finally {
                w.m().c(b2);
            }
        }

        @Override // com.pinguo.camera360.gallery.data.q, com.pinguo.album.a.b
        /* renamed from: d */
        public Bitmap a(a.c cVar) {
            cVar.b(2);
            return super.a(cVar);
        }
    }

    /* compiled from: BigAlbumImage.java */
    /* loaded from: classes3.dex */
    public static class c implements a.b<BitmapRegionDecoder> {
        String a;

        public c(String str) {
            this.a = str;
        }

        @Override // com.pinguo.album.a.b
        @SuppressLint({"NewApi"})
        /* renamed from: b */
        public BitmapRegionDecoder a(a.c cVar) {
            return com.pinguo.album.data.utils.a.a(cVar, this.a, false);
        }
    }

    /* compiled from: BigAlbumImage.java */
    /* loaded from: classes3.dex */
    public static class d implements a.b<Bitmap> {
        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public Bitmap a(a.c cVar) {
            return ((BitmapDrawable) com.pinguo.album.e.e().b().getResources().getDrawable(R.drawable.album_default_photo)).getBitmap();
        }
    }

    /* compiled from: BigAlbumImage.java */
    /* loaded from: classes3.dex */
    public static class e implements a.b<Bitmap> {
        private String a;
        private int b;

        e(String str, int i2) {
            this.a = str;
            this.b = i2;
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public Bitmap a(a.c cVar) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            return com.pinguo.album.data.utils.a.e(cVar, this.a, options, w.v(this.b), this.b);
        }
    }

    public h(Application application, Path path, Cursor cursor) {
        super(path, x.j());
        this.q = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.r = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f6357i = application;
        D(cursor);
    }

    private void D(Cursor cursor) {
        this.f6358j = cursor.getInt(0);
        this.f6359k = cursor.getString(1);
        this.f6360l = cursor.getString(2);
        this.m = cursor.getLong(3);
        this.n = cursor.getInt(4);
        this.o = cursor.getInt(5);
        this.q = cursor.getDouble(6);
        this.r = cursor.getDouble(7);
        this.p = cursor.getString(8);
        cursor.getLong(10);
        this.t = cursor.getInt(11);
        this.s = cursor.getInt(9) == 1;
        String string = cursor.getString(12);
        this.u = string;
        if (!TextUtils.isEmpty(string)) {
            this.t = 0;
        }
        this.v = cursor.getString(13);
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<Bitmap> A(int i2) {
        String b2;
        String str = this.u;
        if (str != null && str.equals("editing")) {
            if (i2 == 1) {
                b2 = SandBox.b(SandBox.ProjectFileType.share, this.m);
            } else {
                b2 = SandBox.b(SandBox.ProjectFileType.thumb, this.m);
            }
            return new e(b2, i2);
        } else if (!TextUtils.isEmpty(this.f6359k)) {
            String str2 = "";
            String str3 = this.v;
            if (str3 != null && str3.length() > 0) {
                try {
                    long optLong = new JSONObject(this.v).optLong("cet", 0L);
                    if (optLong > 0) {
                        str2 = String.valueOf(optLong);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Application application = this.f6357i;
            s.a aVar = new s.a(application, this.f6359k + str2, i2, this.f6359k);
            aVar.e(this.t);
            return aVar;
        } else if (!TextUtils.isEmpty(this.f6360l)) {
            Application application2 = this.f6357i;
            String str4 = this.f6360l;
            return new b(this, application2, str4, i2, str4);
        } else {
            CrashReport.postCatchedException(new Exception("requestImage error width = " + this.n + " height = " + this.o));
            return new d();
        }
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<BitmapRegionDecoder> B() {
        if (Build.VERSION.SDK_INT < 10 || TextUtils.isEmpty(this.f6359k)) {
            return null;
        }
        return new c(this.f6359k);
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public void C(boolean z) {
        if (this.s == z) {
            return;
        }
        this.s = z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(BigAlbumStore.PhotoColumns.IS_FAV, Integer.valueOf(this.s ? 1 : 0));
        contentValues.put(BigAlbumStore.PhotoColumns.FAV_TIME, Long.valueOf(System.currentTimeMillis()));
        BigAlbumManager.instance().updatePhoto(this.f6358j, contentValues, true);
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public void c(boolean z) {
        if (p0.b(this)) {
            GalleryDeleteUtil.a.h(this.f6359k, false);
        } else if (this.b.h() == 1205) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.f6358j));
            BigAlbumManager.instance().deletePhotoFromGallery(this.b.b(), arrayList);
        } else {
            com.pinguo.camera360.gallery.temps.a.a(n(), o());
            BigAlbumManager.instance().deletePhoto(this.f6358j);
        }
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public int f() {
        return 2;
    }

    @Override // com.pinguo.camera360.gallery.data.x
    public int h() {
        int i2 = (Build.VERSION.SDK_INT < 10 || TextUtils.isEmpty(this.f6359k)) ? 1581 : 1645;
        if (com.pinguo.album.data.utils.b.g(this.p) && !TextUtils.isEmpty(this.f6359k)) {
            i2 |= 2;
        }
        return com.pinguo.album.j.c.l(this.q, this.r) ? i2 | 16 : i2;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean k() {
        return false;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean l() {
        if (TextUtils.isEmpty(this.f6359k)) {
            return true;
        }
        return new File(this.f6359k).exists();
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public long n() {
        return this.m;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public String o() {
        return this.f6359k;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int q() {
        return this.o;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public long r() {
        return this.f6358j;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public String s() {
        return this.p;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int t() {
        int i2 = this.t;
        while (i2 < 0) {
            i2 += BaseBlurEffect.ROTATION_360;
        }
        int i3 = i2 % BaseBlurEffect.ROTATION_360;
        int i4 = i3 % 90;
        if (i4 != 0) {
            if (i4 > 45) {
                return ((i3 + 90) - i4) % BaseBlurEffect.ROTATION_360;
            }
            return (i3 - i4) % BaseBlurEffect.ROTATION_360;
        }
        return i3;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public int w() {
        return this.n;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean x() {
        return this.s;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public boolean y() {
        return false;
    }

    @Override // com.pinguo.camera360.gallery.data.w
    public a.b<Bitmap> z(int i2) {
        String b2;
        String str = this.u;
        if (str != null && str.equals("editing")) {
            if (i2 == 1) {
                b2 = SandBox.b(SandBox.ProjectFileType.share, this.m);
            } else {
                b2 = SandBox.b(SandBox.ProjectFileType.thumb, this.m);
            }
            return new e(b2, i2);
        } else if (!TextUtils.isEmpty(this.f6359k)) {
            String str2 = "";
            String str3 = this.v;
            if (str3 != null && str3.length() > 0) {
                try {
                    long optLong = new JSONObject(this.v).optLong("cet", 0L);
                    if (optLong > 0) {
                        str2 = String.valueOf(optLong);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Application application = this.f6357i;
            s.a aVar = new s.a(application, this.f6359k + str2, i2, this.f6359k);
            aVar.e(this.t);
            return aVar;
        } else if (!TextUtils.isEmpty(this.f6360l)) {
            return new a(this, this.f6357i, this.f6360l, i2, w.v(i2));
        } else {
            CrashReport.postCatchedException(new Exception("requestCachedImage error width = " + this.n + " height = " + this.o));
            return new d();
        }
    }

    public h(Application application, Path path) {
        super(path, x.j());
        this.q = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.r = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f6357i = application;
        Cursor queryPhoto = BigAlbumManager.instance().queryPhoto(w, "_id = ?", new String[]{path.f()}, null, null, null);
        if (queryPhoto != null) {
            try {
                if (queryPhoto.moveToNext()) {
                    D(queryPhoto);
                    return;
                }
                throw new RuntimeException("cannot find data for: " + path.f());
            } finally {
                queryPhoto.close();
            }
        }
        throw new RuntimeException("cannot get cursor for: " + path.f());
    }
}
