package com.pinguo.camera360.gallery.data;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import com.pinguo.album.a;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
/* compiled from: MediaItem.java */
/* loaded from: classes3.dex */
public abstract class w extends x {

    /* renamed from: g  reason: collision with root package name */
    public static int f6388g = BaseApplication.d().getResources().getDimensionPixelSize(R.dimen.album_set_slot_height);

    /* renamed from: d  reason: collision with root package name */
    public static int f6385d = com.pinguo.album.data.utils.e.f();

    /* renamed from: e  reason: collision with root package name */
    public static int f6386e = com.pinguo.album.data.utils.e.e();

    /* renamed from: f  reason: collision with root package name */
    public static int f6387f = com.pinguo.album.data.utils.e.d();

    /* renamed from: h  reason: collision with root package name */
    private static final com.pinguo.album.data.utils.d f6389h = new com.pinguo.album.data.utils.d(4, 122880);

    public w(Path path, long j2) {
        super(path, j2);
    }

    public static com.pinguo.album.data.utils.d m() {
        return f6389h;
    }

    public static int v(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return f6386e;
                }
                if (i2 == 5) {
                    return -1;
                }
                throw new RuntimeException("should only request thumb/microthumb from cache");
            }
            return f6387f;
        }
        return f6385d;
    }

    public abstract a.b<Bitmap> A(int i2);

    public abstract a.b<BitmapRegionDecoder> B();

    public void C(boolean z) {
    }

    public abstract boolean k();

    public abstract boolean l();

    public long n() {
        return 0L;
    }

    public String o() {
        return null;
    }

    public int p() {
        return t();
    }

    public abstract int q();

    public long r() {
        return -1L;
    }

    public abstract String s();

    public int t() {
        return 0;
    }

    public com.pinguo.album.opengles.s u() {
        return null;
    }

    public abstract int w();

    public boolean x() {
        return false;
    }

    public abstract boolean y();

    public abstract a.b<Bitmap> z(int i2);
}
