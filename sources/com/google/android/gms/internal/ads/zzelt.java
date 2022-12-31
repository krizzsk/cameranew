package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public class zzelt {
    private static final zzeko zziln = zzeko.zzbhw();
    private zzejr zzirv;
    private volatile zzemo zzirw;
    private volatile zzejr zzirx;

    private final zzemo zzm(zzemo zzemoVar) {
        if (this.zzirw == null) {
            synchronized (this) {
                if (this.zzirw == null) {
                    try {
                        this.zzirw = zzemoVar;
                        this.zzirx = zzejr.zzilz;
                    } catch (zzelo unused) {
                        this.zzirw = zzemoVar;
                        this.zzirx = zzejr.zzilz;
                    }
                }
            }
        }
        return this.zzirw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzelt) {
            zzelt zzeltVar = (zzelt) obj;
            zzemo zzemoVar = this.zzirw;
            zzemo zzemoVar2 = zzeltVar.zzirw;
            if (zzemoVar == null && zzemoVar2 == null) {
                return zzbfz().equals(zzeltVar.zzbfz());
            }
            if (zzemoVar == null || zzemoVar2 == null) {
                if (zzemoVar != null) {
                    return zzemoVar.equals(zzeltVar.zzm(zzemoVar.zzbiq()));
                }
                return zzm(zzemoVar2.zzbiq()).equals(zzemoVar2);
            }
            return zzemoVar.equals(zzemoVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public final zzejr zzbfz() {
        if (this.zzirx != null) {
            return this.zzirx;
        }
        synchronized (this) {
            if (this.zzirx != null) {
                return this.zzirx;
            }
            if (this.zzirw == null) {
                this.zzirx = zzejr.zzilz;
            } else {
                this.zzirx = this.zzirw.zzbfz();
            }
            return this.zzirx;
        }
    }

    public final int zzbik() {
        if (this.zzirx != null) {
            return this.zzirx.size();
        }
        if (this.zzirw != null) {
            return this.zzirw.zzbik();
        }
        return 0;
    }

    public final zzemo zzn(zzemo zzemoVar) {
        zzemo zzemoVar2 = this.zzirw;
        this.zzirv = null;
        this.zzirx = null;
        this.zzirw = zzemoVar;
        return zzemoVar2;
    }
}
