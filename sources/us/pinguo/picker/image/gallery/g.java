package us.pinguo.picker.image.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.pinguo.album.a;
import com.pinguo.album.data.utils.d;
import com.pinguo.camera360.gallery.data.LocalBlobCacheService;
import us.pinguo.foundation.utils.n0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCacheRequest.java */
/* loaded from: classes5.dex */
public abstract class g implements a.b<Bitmap> {
    protected Context a;
    protected String b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f11698d;

    /* renamed from: f  reason: collision with root package name */
    protected int f11700f = 0;

    /* renamed from: e  reason: collision with root package name */
    protected float f11699e = m.f11716g / n0.i();

    public g(Context context, String str, int i2, int i3) {
        this.a = context;
        this.b = str;
        this.c = i2;
        this.f11698d = i3;
    }

    protected Bitmap b(Bitmap bitmap, a.c cVar, LocalBlobCacheService localBlobCacheService) {
        Bitmap j2;
        int i2 = this.c;
        if (i2 == 2) {
            j2 = com.pinguo.album.data.utils.b.h(bitmap, this.f11698d, true);
        } else if (i2 == 3) {
            int i3 = this.f11698d;
            float f2 = this.f11699e;
            j2 = com.pinguo.album.data.utils.b.k(bitmap, i3, (int) (i3 * f2), f2, this.f11700f, true);
            us.pinguo.common.log.a.s("resizeSameRadioAndCropCenter decode orig bitmap " + j2.getWidth() + "/" + j2.getHeight(), new Object[0]);
        } else {
            j2 = com.pinguo.album.data.utils.b.j(bitmap, this.f11698d, true);
        }
        if (cVar.isCancelled()) {
            return null;
        }
        byte[] a = com.pinguo.album.data.utils.b.a(j2);
        if (cVar.isCancelled()) {
            return null;
        }
        localBlobCacheService.d(this.b, this.c, a);
        return j2;
    }

    public abstract Bitmap c(a.c cVar, int i2);

    @Override // com.pinguo.album.a.b
    /* renamed from: d */
    public Bitmap a(a.c cVar) {
        boolean a;
        Bitmap b;
        if (cVar.isCancelled()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append(",");
        int i2 = this.c;
        sb.append(i2 == 1 ? "THUMB" : i2 == 2 ? "MICROTHUMB" : "?");
        String sb2 = sb.toString();
        LocalBlobCacheService c = com.pinguo.album.e.e().c();
        d.b b2 = m.e().b();
        try {
            int i3 = this.c;
            if (i3 == 5) {
                a = c.a(this.b, 1, b2);
                if (a) {
                    this.c = 1;
                    this.f11698d = m.i(1);
                } else {
                    boolean a2 = c.a(this.b, 4, b2);
                    this.c = 4;
                    this.f11698d = m.i(4);
                    a = a2;
                }
            } else {
                a = c.a(this.b, i3, b2);
            }
            if (cVar.isCancelled()) {
                return null;
            }
            if (a) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                if (com.pinguo.album.common.a.a) {
                    b = com.pinguo.album.data.utils.a.f(cVar, b2.a, b2.b, b2.c, options);
                } else {
                    b = com.pinguo.album.data.utils.a.b(cVar, b2.a, b2.b, b2.c, options);
                }
                if (b == null && !cVar.isCancelled()) {
                    us.pinguo.common.log.a.s("decode cached failed " + sb2, new Object[0]);
                }
                return b;
            }
            m.e().c(b2);
            Bitmap c2 = c(cVar, this.c);
            if (cVar.isCancelled()) {
                return null;
            }
            if (c2 == null) {
                us.pinguo.common.log.a.s("decode orig failed " + sb2, new Object[0]);
                return null;
            }
            return b(c2, cVar, c);
        } finally {
            m.e().c(b2);
        }
    }
}
