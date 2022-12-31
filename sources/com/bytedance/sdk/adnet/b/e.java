package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
/* compiled from: ImageRequest.java */
/* loaded from: classes.dex */
public class e extends Request<Bitmap> {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f1187i = new Object();
    private final Object c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    private m.a<Bitmap> f1188d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap.Config f1189e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1190f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1191g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView.ScaleType f1192h;

    public e(String str, m.a<Bitmap> aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.c = new Object();
        setRetryPolicy(new com.bytedance.sdk.adnet.core.e(1000, 2, 2.0f));
        this.f1188d = aVar;
        this.f1189e = config;
        this.f1190f = i2;
        this.f1191g = i3;
        this.f1192h = scaleType;
        setShouldCache(false);
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

    private m<Bitmap> b(com.bytedance.sdk.adnet.core.i iVar) {
        Bitmap decodeByteArray;
        byte[] bArr = iVar.b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f1190f == 0 && this.f1191g == 0) {
            options.inPreferredConfig = this.f1189e;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a = a(this.f1190f, this.f1191g, i2, i3, this.f1192h);
            int a2 = a(this.f1191g, this.f1190f, i3, i2, this.f1192h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a, a2);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a || decodeByteArray.getHeight() > a2)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a, a2, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray == null) {
            return m.a(new com.bytedance.sdk.adnet.err.e(iVar));
        }
        return m.a(decodeByteArray, com.bytedance.sdk.adnet.d.b.a(iVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.f1188d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<Bitmap> a(com.bytedance.sdk.adnet.core.i iVar) {
        m<Bitmap> b;
        synchronized (f1187i) {
            try {
                try {
                    b = b(iVar);
                } catch (OutOfMemoryError e2) {
                    o.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(iVar.b.length), getUrl());
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
    public void a(m<Bitmap> mVar) {
        m.a<Bitmap> aVar;
        synchronized (this.c) {
            aVar = this.f1188d;
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
