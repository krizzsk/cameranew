package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfq extends zzgn {
    private static zzgq<String> zzaax = new zzgq<>();
    private final Context zzaav;

    public zzfq(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3, Context context) {
        super(zzfcVar, str, str2, zzbVar, i2, 29);
        this.zzaav = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabb.zzaf(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zzas = zzaax.zzas(this.zzaav.getPackageName());
        if (zzas.get() == null) {
            synchronized (zzas) {
                if (zzas.get() == null) {
                    zzas.set((String) this.zzabl.invoke(null, this.zzaav));
                }
            }
        }
        String str = zzas.get();
        synchronized (this.zzabb) {
            this.zzabb.zzaf(zzcy.zza(str.getBytes(), true));
        }
    }
}
