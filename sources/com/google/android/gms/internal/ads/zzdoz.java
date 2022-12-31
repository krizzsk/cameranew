package com.google.android.gms.internal.ads;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdoz {
    private final int maxEntries;
    private final int zzhmv;
    private final LinkedList<zzdpm<?>> zzhmu = new LinkedList<>();
    private final zzdqc zzhmw = new zzdqc();

    public zzdoz(int i2, int i3) {
        this.maxEntries = i2;
        this.zzhmv = i3;
    }

    private final void zzavu() {
        while (!this.zzhmu.isEmpty()) {
            if (!(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis() - this.zzhmu.getFirst().zzhoj >= ((long) this.zzhmv))) {
                return;
            }
            this.zzhmw.zzawp();
            this.zzhmu.remove();
        }
    }

    public final long getCreationTimeMillis() {
        return this.zzhmw.getCreationTimeMillis();
    }

    public final int size() {
        zzavu();
        return this.zzhmu.size();
    }

    public final zzdpm<?> zzavp() {
        this.zzhmw.zzawn();
        zzavu();
        if (this.zzhmu.isEmpty()) {
            return null;
        }
        zzdpm<?> remove = this.zzhmu.remove();
        if (remove != null) {
            this.zzhmw.zzawo();
        }
        return remove;
    }

    public final long zzavq() {
        return this.zzhmw.zzavq();
    }

    public final int zzavr() {
        return this.zzhmw.zzavr();
    }

    public final String zzavs() {
        return this.zzhmw.zzawd();
    }

    public final zzdqb zzavt() {
        return this.zzhmw.zzawq();
    }

    public final boolean zzb(zzdpm<?> zzdpmVar) {
        this.zzhmw.zzawn();
        zzavu();
        if (this.zzhmu.size() == this.maxEntries) {
            return false;
        }
        this.zzhmu.add(zzdpmVar);
        return true;
    }
}
