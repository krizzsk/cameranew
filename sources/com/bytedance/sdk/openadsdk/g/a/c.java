package com.bytedance.sdk.openadsdk.g.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.o;
/* compiled from: GifRequest.java */
/* loaded from: classes.dex */
public class c extends Request<byte[]> {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f1979i = new Object();
    private final Object c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    private a f1980d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap.Config f1981e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1982f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1983g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView.ScaleType f1984h;

    /* compiled from: GifRequest.java */
    /* loaded from: classes.dex */
    public interface a extends m.a<byte[]> {
        void a(String str, byte[] bArr);
    }

    public c(String str, a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.c = new Object();
        setRetryPolicy(new e(1000, 2, 2.0f));
        this.f1980d = aVar;
        this.f1981e = config;
        this.f1982f = i2;
        this.f1983g = i3;
        this.f1984h = scaleType;
        setShouldCache(false);
    }

    private m<byte[]> b(i iVar) {
        Bitmap decodeByteArray;
        final byte[] bArr = iVar.b;
        String a2 = com.bytedance.sdk.openadsdk.g.a.a.a().a(getUrl(), this.f1982f, this.f1983g, this.f1984h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                com.bytedance.sdk.openadsdk.g.a.a.a().a(a2, bArr);
                if (this.f1980d != null) {
                    this.b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f1980d != null) {
                                c.this.f1980d.a(c.this.getUrl(), bArr);
                            }
                        }
                    });
                }
                return m.a(bArr, com.bytedance.sdk.adnet.d.b.a(iVar));
            } catch (Exception unused) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f1982f == 0 && this.f1983g == 0) {
            options.inPreferredConfig = this.f1981e;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a3 = a(this.f1982f, this.f1983g, i2, i3, this.f1984h);
            int a4 = a(this.f1983g, this.f1982f, i3, i2, this.f1984h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a3, a4);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a3 || decodeByteArray.getHeight() > a4)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a3, a4, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray == null) {
            return m.a(new com.bytedance.sdk.adnet.err.e(iVar));
        }
        final byte[] b = d.b(decodeByteArray);
        com.bytedance.sdk.openadsdk.g.a.a.a().a(a2, b);
        if (this.f1980d != null) {
            this.b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f1980d != null) {
                        c.this.f1980d.a(c.this.getUrl(), b);
                    }
                }
            });
        }
        return m.a(b, com.bytedance.sdk.adnet.d.b.a(iVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.f1980d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        } else if (i2 == 0) {
            return (int) (i4 * (i3 / i5));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d2 = i5 / i4;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = i3;
                return ((double) i2) * d2 < d3 ? (int) (d3 / d2) : i2;
            }
            double d4 = i3;
            return ((double) i2) * d2 > d4 ? (int) (d4 / d2) : i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<byte[]> a(i iVar) {
        m<byte[]> b;
        synchronized (f1979i) {
            try {
                try {
                    b = b(iVar);
                } catch (OutOfMemoryError e2) {
                    o.c("GifRequest", "Caught OOM for byte image", e2);
                    return m.a(new com.bytedance.sdk.adnet.err.e(e2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<byte[]> mVar) {
        a aVar;
        synchronized (this.c) {
            aVar = this.f1980d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @VisibleForTesting
    static int a(int i2, int i3, int i4, int i5) {
        double min = Math.min(i2 / i4, i3 / i5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
