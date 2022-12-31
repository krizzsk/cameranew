package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzekj implements zzend {
    private int tag;
    private final zzekc zzimz;
    private int zzina;
    private int zzinb = 0;

    private zzekj(zzekc zzekcVar) {
        zzekc zzekcVar2 = (zzekc) zzeld.zza(zzekcVar, "input");
        this.zzimz = zzekcVar2;
        zzekcVar2.zzimo = this;
    }

    public static zzekj zza(zzekc zzekcVar) {
        zzekj zzekjVar = zzekcVar.zzimo;
        return zzekjVar != null ? zzekjVar : new zzekj(zzekcVar);
    }

    private final <T> T zzc(zzenj<T> zzenjVar, zzeko zzekoVar) throws IOException {
        zzekc zzekcVar;
        int zzbhb = this.zzimz.zzbhb();
        zzekc zzekcVar2 = this.zzimz;
        if (zzekcVar2.zziml < zzekcVar2.zzimm) {
            int zzgf = zzekcVar2.zzgf(zzbhb);
            T newInstance = zzenjVar.newInstance();
            this.zzimz.zziml++;
            zzenjVar.zza(newInstance, this, zzekoVar);
            zzenjVar.zzak(newInstance);
            this.zzimz.zzgd(0);
            zzekcVar.zziml--;
            this.zzimz.zzgg(zzgf);
            return newInstance;
        }
        throw new zzelo("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzenj<T> zzenjVar, zzeko zzekoVar) throws IOException {
        int i2 = this.zzina;
        this.zzina = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzenjVar.newInstance();
            zzenjVar.zza(newInstance, this, zzekoVar);
            zzenjVar.zzak(newInstance);
            if (this.tag == this.zzina) {
                return newInstance;
            }
            throw zzelo.zzbjh();
        } finally {
            this.zzina = i2;
        }
    }

    private final void zzgn(int i2) throws IOException {
        if ((this.tag & 7) != i2) {
            throw zzelo.zzbjf();
        }
    }

    private static void zzgo(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzelo.zzbjh();
        }
    }

    private static void zzgp(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzelo.zzbjh();
        }
    }

    private final void zzgq(int i2) throws IOException {
        if (this.zzimz.zzbhj() != i2) {
            throw zzelo.zzbja();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final double readDouble() throws IOException {
        zzgn(1);
        return this.zzimz.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final float readFloat() throws IOException {
        zzgn(5);
        return this.zzimz.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final String readString() throws IOException {
        zzgn(2);
        return this.zzimz.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzaa(List<Integer> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhf());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhf());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhf()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhf()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzab(List<Long> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzemcVar.zzfr(this.zzimz.zzbhg());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzemcVar.zzfr(this.zzimz.zzbhg());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.zzimz.zzbhg()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Long.valueOf(this.zzimz.zzbhg()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final <T> T zzb(zzenj<T> zzenjVar, zzeko zzekoVar) throws IOException {
        zzgn(3);
        return (T) zzd(zzenjVar, zzekoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final long zzbgt() throws IOException {
        zzgn(0);
        return this.zzimz.zzbgt();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final long zzbgu() throws IOException {
        zzgn(0);
        return this.zzimz.zzbgu();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbgv() throws IOException {
        zzgn(0);
        return this.zzimz.zzbgv();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final long zzbgw() throws IOException {
        zzgn(1);
        return this.zzimz.zzbgw();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbgx() throws IOException {
        zzgn(5);
        return this.zzimz.zzbgx();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final boolean zzbgy() throws IOException {
        zzgn(0);
        return this.zzimz.zzbgy();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final String zzbgz() throws IOException {
        zzgn(2);
        return this.zzimz.zzbgz();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final zzejr zzbha() throws IOException {
        zzgn(2);
        return this.zzimz.zzbha();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbhb() throws IOException {
        zzgn(0);
        return this.zzimz.zzbhb();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbhc() throws IOException {
        zzgn(0);
        return this.zzimz.zzbhc();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbhd() throws IOException {
        zzgn(5);
        return this.zzimz.zzbhd();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final long zzbhe() throws IOException {
        zzgn(1);
        return this.zzimz.zzbhe();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbhf() throws IOException {
        zzgn(0);
        return this.zzimz.zzbhf();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final long zzbhg() throws IOException {
        zzgn(0);
        return this.zzimz.zzbhg();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final int zzbhq() throws IOException {
        int i2 = this.zzinb;
        if (i2 != 0) {
            this.tag = i2;
            this.zzinb = 0;
        } else {
            this.tag = this.zzimz.zzbgs();
        }
        int i3 = this.tag;
        if (i3 == 0 || i3 == this.zzina) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final boolean zzbhr() throws IOException {
        int i2;
        if (this.zzimz.zzbhi() || (i2 = this.tag) == this.zzina) {
            return false;
        }
        return this.zzimz.zzge(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzm(List<Double> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzekm) {
            zzekm zzekmVar = (zzekm) list;
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    zzekmVar.zze(this.zzimz.readDouble());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhb = this.zzimz.zzbhb();
                zzgo(zzbhb);
                int zzbhj = this.zzimz.zzbhj() + zzbhb;
                do {
                    zzekmVar.zze(this.zzimz.readDouble());
                } while (this.zzimz.zzbhj() < zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 1) {
            do {
                list.add(Double.valueOf(this.zzimz.readDouble()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhb2 = this.zzimz.zzbhb();
            zzgo(zzbhb2);
            int zzbhj2 = this.zzimz.zzbhj() + zzbhb2;
            do {
                list.add(Double.valueOf(this.zzimz.readDouble()));
            } while (this.zzimz.zzbhj() < zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzn(List<Float> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzela) {
            zzela zzelaVar = (zzela) list;
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbhb = this.zzimz.zzbhb();
                zzgp(zzbhb);
                int zzbhj = this.zzimz.zzbhj() + zzbhb;
                do {
                    zzelaVar.zzh(this.zzimz.readFloat());
                } while (this.zzimz.zzbhj() < zzbhj);
                return;
            } else if (i2 == 5) {
                do {
                    zzelaVar.zzh(this.zzimz.readFloat());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 2) {
            int zzbhb2 = this.zzimz.zzbhb();
            zzgp(zzbhb2);
            int zzbhj2 = this.zzimz.zzbhj() + zzbhb2;
            do {
                list.add(Float.valueOf(this.zzimz.readFloat()));
            } while (this.zzimz.zzbhj() < zzbhj2);
        } else if (i3 == 5) {
            do {
                list.add(Float.valueOf(this.zzimz.readFloat()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzo(List<Long> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzemcVar.zzfr(this.zzimz.zzbgt());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzemcVar.zzfr(this.zzimz.zzbgt());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.zzimz.zzbgt()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Long.valueOf(this.zzimz.zzbgt()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzp(List<Long> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzemcVar.zzfr(this.zzimz.zzbgu());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzemcVar.zzfr(this.zzimz.zzbgu());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.zzimz.zzbgu()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Long.valueOf(this.zzimz.zzbgu()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzq(List<Integer> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzeleVar.zzhh(this.zzimz.zzbgv());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzeleVar.zzhh(this.zzimz.zzbgv());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.zzimz.zzbgv()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Integer.valueOf(this.zzimz.zzbgv()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzr(List<Long> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    zzemcVar.zzfr(this.zzimz.zzbgw());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhb = this.zzimz.zzbhb();
                zzgo(zzbhb);
                int zzbhj = this.zzimz.zzbhj() + zzbhb;
                do {
                    zzemcVar.zzfr(this.zzimz.zzbgw());
                } while (this.zzimz.zzbhj() < zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 1) {
            do {
                list.add(Long.valueOf(this.zzimz.zzbgw()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhb2 = this.zzimz.zzbhb();
            zzgo(zzbhb2);
            int zzbhj2 = this.zzimz.zzbhj() + zzbhb2;
            do {
                list.add(Long.valueOf(this.zzimz.zzbgw()));
            } while (this.zzimz.zzbhj() < zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzs(List<Integer> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbhb = this.zzimz.zzbhb();
                zzgp(zzbhb);
                int zzbhj = this.zzimz.zzbhj() + zzbhb;
                do {
                    zzeleVar.zzhh(this.zzimz.zzbgx());
                } while (this.zzimz.zzbhj() < zzbhj);
                return;
            } else if (i2 == 5) {
                do {
                    zzeleVar.zzhh(this.zzimz.zzbgx());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 2) {
            int zzbhb2 = this.zzimz.zzbhb();
            zzgp(zzbhb2);
            int zzbhj2 = this.zzimz.zzbhj() + zzbhb2;
            do {
                list.add(Integer.valueOf(this.zzimz.zzbgx()));
            } while (this.zzimz.zzbhj() < zzbhj2);
        } else if (i3 == 5) {
            do {
                list.add(Integer.valueOf(this.zzimz.zzbgx()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzt(List<Boolean> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzejp) {
            zzejp zzejpVar = (zzejp) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzejpVar.addBoolean(this.zzimz.zzbgy());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzejpVar.addBoolean(this.zzimz.zzbgy());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Boolean.valueOf(this.zzimz.zzbgy()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Boolean.valueOf(this.zzimz.zzbgy()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzu(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzv(List<zzejr> list) throws IOException {
        int zzbgs;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzbha());
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
            return;
        }
        throw zzelo.zzbjf();
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzw(List<Integer> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhb());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhb());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhb()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhb()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzx(List<Integer> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhc());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhj = this.zzimz.zzbhj() + this.zzimz.zzbhb();
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhc());
                } while (this.zzimz.zzbhj() < zzbhj);
                zzgq(zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhc()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhj2 = this.zzimz.zzbhj() + this.zzimz.zzbhb();
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhc()));
            } while (this.zzimz.zzbhj() < zzbhj2);
            zzgq(zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzy(List<Integer> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzele) {
            zzele zzeleVar = (zzele) list;
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbhb = this.zzimz.zzbhb();
                zzgp(zzbhb);
                int zzbhj = this.zzimz.zzbhj() + zzbhb;
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhd());
                } while (this.zzimz.zzbhj() < zzbhj);
                return;
            } else if (i2 == 5) {
                do {
                    zzeleVar.zzhh(this.zzimz.zzbhd());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 2) {
            int zzbhb2 = this.zzimz.zzbhb();
            zzgp(zzbhb2);
            int zzbhj2 = this.zzimz.zzbhj() + zzbhb2;
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhd()));
            } while (this.zzimz.zzbhj() < zzbhj2);
        } else if (i3 == 5) {
            do {
                list.add(Integer.valueOf(this.zzimz.zzbhd()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final void zzz(List<Long> list) throws IOException {
        int zzbgs;
        int zzbgs2;
        if (list instanceof zzemc) {
            zzemc zzemcVar = (zzemc) list;
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    zzemcVar.zzfr(this.zzimz.zzbhe());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            } else if (i2 == 2) {
                int zzbhb = this.zzimz.zzbhb();
                zzgo(zzbhb);
                int zzbhj = this.zzimz.zzbhj() + zzbhb;
                do {
                    zzemcVar.zzfr(this.zzimz.zzbhe());
                } while (this.zzimz.zzbhj() < zzbhj);
                return;
            } else {
                throw zzelo.zzbjf();
            }
        }
        int i3 = this.tag & 7;
        if (i3 == 1) {
            do {
                list.add(Long.valueOf(this.zzimz.zzbhe()));
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
        } else if (i3 == 2) {
            int zzbhb2 = this.zzimz.zzbhb();
            zzgo(zzbhb2);
            int zzbhj2 = this.zzimz.zzbhj() + zzbhb2;
            do {
                list.add(Long.valueOf(this.zzimz.zzbhe()));
            } while (this.zzimz.zzbhj() < zzbhj2);
        } else {
            throw zzelo.zzbjf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzend
    public final <T> T zza(zzenj<T> zzenjVar, zzeko zzekoVar) throws IOException {
        zzgn(2);
        return (T) zzc(zzenjVar, zzekoVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzend
    public final <T> void zzb(List<T> list, zzenj<T> zzenjVar, zzeko zzekoVar) throws IOException {
        int zzbgs;
        int i2 = this.tag;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzd(zzenjVar, zzekoVar));
                if (this.zzimz.zzbhi() || this.zzinb != 0) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == i2);
            this.zzinb = zzbgs;
            return;
        }
        throw zzelo.zzbjf();
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzbgs;
        int zzbgs2;
        if ((this.tag & 7) == 2) {
            if ((list instanceof zzelv) && !z) {
                zzelv zzelvVar = (zzelv) list;
                do {
                    zzelvVar.zzak(zzbha());
                    if (this.zzimz.zzbhi()) {
                        return;
                    }
                    zzbgs2 = this.zzimz.zzbgs();
                } while (zzbgs2 == this.tag);
                this.zzinb = zzbgs2;
                return;
            }
            do {
                list.add(z ? zzbgz() : readString());
                if (this.zzimz.zzbhi()) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == this.tag);
            this.zzinb = zzbgs;
            return;
        }
        throw zzelo.zzbjf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzend
    public final <T> void zza(List<T> list, zzenj<T> zzenjVar, zzeko zzekoVar) throws IOException {
        int zzbgs;
        int i2 = this.tag;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzc(zzenjVar, zzekoVar));
                if (this.zzimz.zzbhi() || this.zzinb != 0) {
                    return;
                }
                zzbgs = this.zzimz.zzbgs();
            } while (zzbgs == i2);
            this.zzinb = zzbgs;
            return;
        }
        throw zzelo.zzbjf();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.zzemf<K, V> r9, com.google.android.gms.internal.ads.zzeko r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzgn(r0)
            com.google.android.gms.internal.ads.zzekc r1 = r7.zzimz
            int r1 = r1.zzbhb()
            com.google.android.gms.internal.ads.zzekc r2 = r7.zzimz
            int r1 = r2.zzgf(r1)
            K r2 = r9.zzisl
            V r3 = r9.zzclv
        L14:
            int r4 = r7.zzbhq()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.ads.zzekc r5 = r7.zzimz     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzbhi()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzbhr()     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.ads.zzelo r4 = new com.google.android.gms.internal.ads.zzelo     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.ads.zzeos r4 = r9.zzism     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzclv     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.ads.zzeos r4 = r9.zzisk     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.ads.zzeln -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzbhr()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.ads.zzelo r8 = new com.google.android.gms.internal.ads.zzelo     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.ads.zzekc r8 = r7.zzimz
            r8.zzgg(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzekc r9 = r7.zzimz
            r9.zzgg(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekj.zza(java.util.Map, com.google.android.gms.internal.ads.zzemf, com.google.android.gms.internal.ads.zzeko):void");
    }

    private final Object zza(zzeos zzeosVar, Class<?> cls, zzeko zzekoVar) throws IOException {
        switch (zzeki.zzimy[zzeosVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbgy());
            case 2:
                return zzbha();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbhc());
            case 5:
                return Integer.valueOf(zzbgx());
            case 6:
                return Long.valueOf(zzbgw());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbgv());
            case 9:
                return Long.valueOf(zzbgu());
            case 10:
                zzgn(2);
                return zzc(zzenc.zzbkf().zzh(cls), zzekoVar);
            case 11:
                return Integer.valueOf(zzbhd());
            case 12:
                return Long.valueOf(zzbhe());
            case 13:
                return Integer.valueOf(zzbhf());
            case 14:
                return Long.valueOf(zzbhg());
            case 15:
                return zzbgz();
            case 16:
                return Integer.valueOf(zzbhb());
            case 17:
                return Long.valueOf(zzbgt());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
