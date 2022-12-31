package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxj<E> extends zzdxb<E> {
    private int zzahx;
    @NullableDecl
    private Object[] zzhya;

    public zzdxj() {
        super(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdxa zza(Iterator it) {
        zzdwl.checkNotNull(it);
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdxb, com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdxa zzaa(Object obj) {
        zzdwl.checkNotNull(obj);
        if (this.zzhya != null) {
            int zzer = zzdxg.zzer(this.size);
            Object[] objArr = this.zzhya;
            if (zzer <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzep = zzdwz.zzep(hashCode);
                while (true) {
                    int i2 = zzep & length;
                    Object[] objArr2 = this.zzhya;
                    Object obj2 = objArr2[i2];
                    if (obj2 == null) {
                        objArr2[i2] = obj;
                        this.zzahx += hashCode;
                        super.zzaa(obj);
                        break;
                    } else if (obj2.equals(obj)) {
                        break;
                    } else {
                        zzep = i2 + 1;
                    }
                }
                return this;
            }
        }
        this.zzhya = null;
        super.zzaa(obj);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdxb
    public final /* synthetic */ zzdxb zzab(Object obj) {
        return (zzdxj) zzaa(obj);
    }

    public final zzdxg<E> zzazs() {
        zzdxg<E> zza;
        boolean zzw;
        int i2 = this.size;
        if (i2 != 0) {
            if (i2 != 1) {
                if (this.zzhya == null || zzdxg.zzer(i2) != this.zzhya.length) {
                    zza = zzdxg.zza(this.size, this.zzhxo);
                    this.size = zza.size();
                } else {
                    zzw = zzdxg.zzw(this.size, this.zzhxo.length);
                    Object[] copyOf = zzw ? Arrays.copyOf(this.zzhxo, this.size) : this.zzhxo;
                    int i3 = this.zzahx;
                    Object[] objArr = this.zzhya;
                    zza = new zzdxx<>(copyOf, i3, objArr, objArr.length - 1, this.size);
                }
                this.zzhxp = true;
                this.zzhya = null;
                return zza;
            }
            return zzdxg.zzad(this.zzhxo[0]);
        }
        return zzdxx.zzhyn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdxb, com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdxa zzg(Iterable iterable) {
        zzdwl.checkNotNull(iterable);
        if (this.zzhya != null) {
            for (Object obj : iterable) {
                zzaa(obj);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxj(int i2) {
        super(i2);
        this.zzhya = new Object[zzdxg.zzer(i2)];
    }
}
