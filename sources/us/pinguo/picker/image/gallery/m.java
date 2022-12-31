package us.pinguo.picker.image.gallery;

import com.pinguo.album.R;
/* compiled from: MediaItem.java */
/* loaded from: classes5.dex */
public abstract class m extends n {

    /* renamed from: g  reason: collision with root package name */
    public static int f11716g = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.album_set_slot_height);

    /* renamed from: d  reason: collision with root package name */
    public static int f11713d = com.pinguo.album.data.utils.e.f();

    /* renamed from: e  reason: collision with root package name */
    public static int f11714e = com.pinguo.album.data.utils.e.e();

    /* renamed from: f  reason: collision with root package name */
    public static int f11715f = com.pinguo.album.data.utils.e.d();

    /* renamed from: h  reason: collision with root package name */
    private static final com.pinguo.album.data.utils.d f11717h = new com.pinguo.album.data.utils.d(4, 122880);

    public m(Path path, long j2) {
        super(path, j2);
    }

    public static com.pinguo.album.data.utils.d e() {
        return f11717h;
    }

    public static int i(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return f11714e;
                }
                if (i2 == 5) {
                    return -1;
                }
                throw new RuntimeException("should only request thumb/microthumb from cache");
            }
            return f11715f;
        }
        return f11713d;
    }

    public String f() {
        return null;
    }

    public abstract int g();

    public int h() {
        return 0;
    }

    public abstract int j();
}
