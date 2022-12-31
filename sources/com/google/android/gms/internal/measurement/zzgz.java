package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzgz extends zzgh {
    private static final Logger zzb = Logger.getLogger(zzgz.class.getName());
    private static final boolean zzc = zzkh.zza();
    zzha zza;

    private zzgz() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgz(zzgw zzgwVar) {
    }

    public static int zzA(zzgs zzgsVar) {
        int zzc2 = zzgsVar.zzc();
        return zzw(zzc2) + zzc2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzB(zzix zzixVar, zzji zzjiVar) {
        zzgb zzgbVar = (zzgb) zzixVar;
        int zzbq = zzgbVar.zzbq();
        if (zzbq == -1) {
            zzbq = zzjiVar.zze(zzgbVar);
            zzgbVar.zzbr(zzbq);
        }
        return zzw(zzbq) + zzbq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzE(int i2, zzix zzixVar, zzji zzjiVar) {
        int zzw = zzw(i2 << 3);
        int i3 = zzw + zzw;
        zzgb zzgbVar = (zzgb) zzixVar;
        int zzbq = zzgbVar.zzbq();
        if (zzbq == -1) {
            zzbq = zzjiVar.zze(zzgbVar);
            zzgbVar.zzbr(zzbq);
        }
        return i3 + zzbq;
    }

    public static zzgz zzt(byte[] bArr) {
        return new zzgx(bArr, 0, bArr.length);
    }

    public static int zzu(int i2) {
        return zzw(i2 << 3);
    }

    public static int zzv(int i2) {
        if (i2 >= 0) {
            return zzw(i2);
        }
        return 10;
    }

    public static int zzw(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzx(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            j2 >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzkn.zzc(str);
        } catch (zzkl unused) {
            length = str.getBytes(zzia.zza).length;
        }
        return zzw(length) + length;
    }

    public static int zzz(zzif zzifVar) {
        int zza = zzifVar.zza();
        return zzw(zza) + zza;
    }

    public final void zzC() {
        if (zzs() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(String str, zzkl zzklVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzklVar);
        byte[] bytes = str.getBytes(zzia.zza);
        try {
            int length = bytes.length;
            zzl(length);
            zzq(bytes, 0, length);
        } catch (zzgy e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzgy(e3);
        }
    }

    public abstract void zza(int i2, int i3) throws IOException;

    public abstract void zzb(int i2, int i3) throws IOException;

    public abstract void zzc(int i2, int i3) throws IOException;

    public abstract void zzd(int i2, int i3) throws IOException;

    public abstract void zze(int i2, long j2) throws IOException;

    public abstract void zzf(int i2, long j2) throws IOException;

    public abstract void zzg(int i2, boolean z) throws IOException;

    public abstract void zzh(int i2, String str) throws IOException;

    public abstract void zzi(int i2, zzgs zzgsVar) throws IOException;

    public abstract void zzj(byte b) throws IOException;

    public abstract void zzk(int i2) throws IOException;

    public abstract void zzl(int i2) throws IOException;

    public abstract void zzm(int i2) throws IOException;

    public abstract void zzn(long j2) throws IOException;

    public abstract void zzo(long j2) throws IOException;

    public abstract void zzq(byte[] bArr, int i2, int i3) throws IOException;

    public abstract int zzs();
}
