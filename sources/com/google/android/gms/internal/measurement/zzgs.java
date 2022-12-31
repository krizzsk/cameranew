package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzgs implements Iterable<Byte>, Serializable {
    private static final zzgn zza;
    public static final zzgs zzb = new zzgq(zzia.zzc);
    private static final Comparator<zzgs> zzd;
    private int zzc = 0;

    static {
        zza = zzgd.zza() ? new zzgr(null) : new zzgl(null);
        zzd = new zzgj();
    }

    public static zzgs zzj(byte[] bArr, int i2, int i3) {
        zzn(i2, i2 + i3, bArr.length);
        return new zzgq(zza.zza(bArr, i2, i3));
    }

    public static zzgs zzk(String str) {
        return new zzgq(str.getBytes(zzia.zza));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) < 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Beginning index: ");
                sb.append(i2);
                sb.append(" < 0");
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i3 < i2) {
                StringBuilder sb2 = new StringBuilder(66);
                sb2.append("Beginning index larger than ending index: ");
                sb2.append(i2);
                sb2.append(", ");
                sb2.append(i3);
                throw new IndexOutOfBoundsException(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("End index: ");
                sb3.append(i3);
                sb3.append(" >= ");
                sb3.append(i4);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
        }
        return i5;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzc;
        if (i2 == 0) {
            int zzc = zzc();
            i2 = zzi(zzc, 0, zzc);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzc = i2;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return new zzgi(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        objArr[2] = zzc() <= 50 ? zzju.zza(this) : String.valueOf(zzju.zza(zze(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i2);

    public abstract int zzc();

    public abstract zzgs zze(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(zzgh zzghVar) throws IOException;

    protected abstract String zzg(Charset charset);

    public abstract boolean zzh();

    protected abstract int zzi(int i2, int i3, int i4);

    public final String zzl(Charset charset) {
        return zzc() == 0 ? "" : zzg(charset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzm() {
        return this.zzc;
    }
}
