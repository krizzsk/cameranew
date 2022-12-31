package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzeob<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b, int i2, zzejr zzejrVar);

    abstract void zza(B b, int i2, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t, zzeoy zzeoyVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzend zzendVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b, zzend zzendVar) throws IOException {
        int tag = zzendVar.getTag();
        int i2 = tag >>> 3;
        int i3 = tag & 7;
        if (i3 == 0) {
            zza((zzeob<T, B>) b, i2, zzendVar.zzbgu());
            return true;
        } else if (i3 == 1) {
            zzb(b, i2, zzendVar.zzbgw());
            return true;
        } else if (i3 == 2) {
            zza((zzeob<T, B>) b, i2, zzendVar.zzbha());
            return true;
        } else if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5) {
                    zzc(b, i2, zzendVar.zzbgx());
                    return true;
                }
                throw zzelo.zzbjf();
            }
            return false;
        } else {
            B zzbky = zzbky();
            int i4 = 4 | (i2 << 3);
            while (zzendVar.zzbhq() != Integer.MAX_VALUE && zza((zzeob<T, B>) zzbky, zzendVar)) {
            }
            if (i4 == zzendVar.getTag()) {
                zza((zzeob<T, B>) b, i2, (int) zzaq(zzbky));
                return true;
            }
            throw zzelo.zzbje();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzak(Object obj);

    abstract T zzaq(B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzau(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzay(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzaz(Object obj);

    abstract void zzb(B b, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzba(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzbky();

    abstract void zzc(B b, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(T t, zzeoy zzeoyVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzi(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzj(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzk(T t, T t2);
}
