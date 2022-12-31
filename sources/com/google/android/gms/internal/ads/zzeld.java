package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeld {
    public static final byte[] zzimf;
    private static final ByteBuffer zzira;
    private static final zzekc zzirb;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzimf = bArr;
        zzira = ByteBuffer.wrap(bArr);
        zzirb = zzekc.zzb(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int zzbt(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zze(Object obj, Object obj2) {
        return ((zzemo) obj).zzbio().zzf((zzemo) obj2).zzbiv();
    }

    public static int zzfq(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzk(zzemo zzemoVar) {
        if (zzemoVar instanceof zzejj) {
            zzejj zzejjVar = (zzejj) zzemoVar;
            return false;
        }
        return false;
    }

    public static boolean zzx(byte[] bArr) {
        return zzeok.zzx(bArr);
    }

    public static String zzy(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }
}
