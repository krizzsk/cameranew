package com.google.android.gms.internal.places;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class zzbd {
    public static final byte[] zziz;
    private static final ByteBuffer zzja;
    private static final zzai zzjb;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zziz = bArr;
        zzja = ByteBuffer.wrap(bArr);
        zzjb = zzai.zzb(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zzb = zzb(length, bArr, 0, length);
        if (zzb == 0) {
            return 1;
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzb(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int zze(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean zze(byte[] bArr) {
        return zzea.zze(bArr);
    }

    public static String zzf(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzg(zzck zzckVar) {
        return false;
    }

    public static int zzl(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzb(Object obj, Object obj2) {
        return ((zzck) obj).zzbk().zzb((zzck) obj2).zzbe();
    }
}
