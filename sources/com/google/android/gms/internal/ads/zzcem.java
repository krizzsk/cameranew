package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcem {
    private final Executor executor;
    private final Clock zzbqg;
    private final com.google.android.gms.ads.internal.util.zzay zzghk;

    public zzcem(com.google.android.gms.ads.internal.util.zzay zzayVar, Clock clock, Executor executor) {
        this.zzghk = zzayVar;
        this.zzbqg = clock;
        this.executor = executor;
    }

    public final zzdzw<Bitmap> zza(String str, double d2, boolean z) {
        return zzdzk.zzb(com.google.android.gms.ads.internal.util.zzay.zzeo(str), new zzcel(this, d2, z), this.executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap zza(byte[] bArr, double d2, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d2 * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxv)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zza(bArr, options);
            options.inJustDecodeBounds = false;
            int i2 = options.outWidth * options.outHeight;
            if (i2 > 0) {
                int i3 = i2 - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i3 / ((Integer) zzwr.zzqr().zzd(zzabp.zzcxw)).intValue())) / 2);
            }
        }
        return zza(bArr, options);
    }

    private final Bitmap zza(byte[] bArr, BitmapFactory.Options options) {
        long a = this.zzbqg.a();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long a2 = this.zzbqg.a();
        if (Build.VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j2 = a2 - a;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j2);
            sb.append(" on ui thread: ");
            sb.append(z);
            com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        }
        return decodeByteArray;
    }
}
