package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxq<K, V> extends zzdxh<K, V> {
    private static final zzdxh<Object, Object> zzhyf = new zzdxq(null, new Object[0], 0);
    private final transient int size;
    private final transient Object zzhyg;
    private final transient Object[] zzhyh;

    private zzdxq(Object obj, Object[] objArr, int i2) {
        this.zzhyg = obj;
        this.zzhyh = objArr;
        this.size = i2;
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i2) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i2]);
        String valueOf4 = String.valueOf(objArr[i2 ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cc, code lost:
        r2[r7] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <K, V> com.google.android.gms.internal.ads.zzdxq<K, V> zzc(int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxq.zzc(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzdxq");
    }

    @Override // com.google.android.gms.internal.ads.zzdxh, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzhyg;
        Object[] objArr = this.zzhyh;
        int i2 = this.size;
        if (obj == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzep = zzdwz.zzep(obj.hashCode());
                while (true) {
                    int i3 = zzep & length;
                    int i4 = bArr[i3] & Draft_75.END_OF_FRAME;
                    if (i4 == 255) {
                        return null;
                    }
                    if (objArr[i4].equals(obj)) {
                        return (V) objArr[i4 ^ 1];
                    }
                    zzep = i3 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzep2 = zzdwz.zzep(obj.hashCode());
                while (true) {
                    int i5 = zzep2 & length2;
                    int i6 = sArr[i5] & 65535;
                    if (i6 == 65535) {
                        return null;
                    }
                    if (objArr[i6].equals(obj)) {
                        return (V) objArr[i6 ^ 1];
                    }
                    zzep2 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzep3 = zzdwz.zzep(obj.hashCode());
                while (true) {
                    int i7 = zzep3 & length3;
                    int i8 = iArr[i7];
                    if (i8 == -1) {
                        return null;
                    }
                    if (objArr[i8].equals(obj)) {
                        return (V) objArr[i8 ^ 1];
                    }
                    zzep3 = i7 + 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    final zzdxg<Map.Entry<K, V>> zzazp() {
        return new zzdxt(this, this.zzhyh, 0, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    final zzdxg<K> zzazq() {
        return new zzdxv(this, new zzdxu(this.zzhyh, 0, this.size));
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    final zzdwy<V> zzazr() {
        return new zzdxu(this.zzhyh, 1, this.size);
    }
}
