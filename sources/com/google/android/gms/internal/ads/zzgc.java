package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgc extends zzgn {
    private static final Object zzaba = new Object();
    private static volatile String zzabe;

    public zzgc(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabb.zzac(ExifInterface.LONGITUDE_EAST);
        if (zzabe == null) {
            synchronized (zzaba) {
                if (zzabe == null) {
                    zzabe = (String) this.zzabl.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabb) {
            this.zzabb.zzac(zzabe);
        }
    }
}
