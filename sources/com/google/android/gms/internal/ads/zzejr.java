package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.slf4j.Marker;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzejr implements Serializable, Iterable<Byte> {
    public static final zzejr zzilz = new zzekb(zzeld.zzimf);
    private static final zzejx zzima;
    private static final Comparator<zzejr> zzimb;
    private int zzilf = 0;

    static {
        zzima = zzejk.zzbgc() ? new zzekd(null) : new zzejv(null);
        zzimb = new zzejt();
    }

    private static zzejr zza(Iterator<zzejr> it, int i2) {
        if (i2 > 0) {
            if (i2 == 1) {
                return it.next();
            }
            int i3 = i2 >>> 1;
            zzejr zza = zza(it, i3);
            zzejr zza2 = zza(it, i2 - i3);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return zzeng.zza(zza, zza2);
            }
            int size = zza.size();
            int size2 = zza2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append(Marker.ANY_NON_NULL_MARKER);
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzab(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & Draft_75.END_OF_FRAME;
    }

    public static zzeka zzbgl() {
        return new zzeka(128);
    }

    public static zzejr zzf(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i2 = 256;
        while (true) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            zzejr zzi = i3 == 0 ? null : zzi(bArr, 0, i3);
            if (zzi != null) {
                arrayList.add(zzi);
                i2 = Math.min(i2 << 1, 8192);
            } else {
                return zzl(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzejz zzgb(int i2) {
        return new zzejz(i2, null);
    }

    public static zzejr zzhy(String str) {
        return new zzekb(str.getBytes(zzeld.UTF_8));
    }

    public static zzejr zzi(byte[] bArr, int i2, int i3) {
        zzi(i2, i2 + i3, bArr.length);
        return new zzekb(zzima.zzj(bArr, i2, i3));
    }

    public static zzejr zzl(Iterable<zzejr> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            size = 0;
            Iterator<zzejr> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return zzilz;
        }
        return zza(iterable.iterator(), size);
    }

    public static zzejr zzt(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzejr zzu(byte[] bArr) {
        return new zzekb(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzilf;
        if (i2 == 0) {
            int size = size();
            i2 = zzh(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzilf = i2;
        }
        return i2;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzeld.zzimf;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzenx.zzan(this) : String.valueOf(zzenx.zzan(zzaa(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    protected abstract String zza(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(zzejo zzejoVar) throws IOException;

    public abstract zzejr zzaa(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i2, int i3, int i4);

    @Override // java.lang.Iterable
    /* renamed from: zzbgh */
    public zzejw iterator() {
        return new zzejq(this);
    }

    public final String zzbgi() {
        return size() == 0 ? "" : zza(zzeld.UTF_8);
    }

    public abstract boolean zzbgj();

    public abstract zzekc zzbgk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzbgm();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean zzbgn();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzbgo() {
        return this.zzilf;
    }

    public abstract byte zzfz(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzg(int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzga(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzh(int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i2, int i3, int i4) {
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

    @Deprecated
    public final void zza(byte[] bArr, int i2, int i3, int i4) {
        zzi(i2, i2 + i4, size());
        zzi(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            zzb(bArr, i2, i3, i4);
        }
    }
}
