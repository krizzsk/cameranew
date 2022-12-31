package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzia {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzgv zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zzgu zzguVar = new zzgu(bArr, 0, 0, false, null);
        try {
            zzguVar.zza(0);
            zze = zzguVar;
        } catch (zzic e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzb(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static boolean zzc(byte[] bArr) {
        return zzkn.zza(bArr);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zze(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int zzf(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        int zzh = zzh(length, bArr, 0, length);
        if (zzh == 0) {
            return 1;
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzi(Object obj, Object obj2) {
        return ((zzix) obj).zzbG().zzau((zzix) obj2).zzaD();
    }
}
