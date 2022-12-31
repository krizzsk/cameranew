package com.google.android.gms.internal.places;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class zzw implements Serializable, Iterable<Byte> {
    public static final zzw zzeg = new zzag(zzbd.zziz);
    private static final zzac zzeh;
    private static final Comparator<zzw> zzej;
    private int zzei = 0;

    static {
        zzeh = zzp.zzy() ? new zzaf(null) : new zzaa(null);
        zzej = new zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & Draft_75.END_OF_FRAME;
    }

    public static zzw zzc(byte[] bArr, int i2, int i3) {
        zzc(i2, i2 + i3, bArr.length);
        return new zzag(zzeh.zzd(bArr, i2, i3));
    }

    public static zzw zzi(String str) {
        return new zzag(str.getBytes(zzbd.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzae zzk(int i2) {
        return new zzae(i2, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzei;
        if (i2 == 0) {
            int size = size();
            i2 = zzb(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzei = i2;
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzv(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzbd.zziz;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public final String zzad() {
        return size() == 0 ? "" : zzb(zzbd.UTF_8);
    }

    public abstract boolean zzae();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzaf() {
        return this.zzei;
    }

    protected abstract int zzb(int i2, int i3, int i4);

    public abstract zzw zzb(int i2, int i3);

    protected abstract String zzb(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(zzt zztVar) throws IOException;

    protected abstract void zzb(byte[] bArr, int i2, int i3, int i4);

    public abstract byte zzi(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzj(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i2, int i3, int i4) {
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
}
