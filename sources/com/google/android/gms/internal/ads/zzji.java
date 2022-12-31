package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzji {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final void setFlags(int i2) {
        this.flags = i2;
    }

    public final void zzaa(int i2) {
        this.flags |= Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzab(int i2) {
        return (this.flags & i2) == i2;
    }

    public final boolean zzgh() {
        return zzab(Integer.MIN_VALUE);
    }

    public final boolean zzgi() {
        return zzab(4);
    }

    public final boolean zzgj() {
        return zzab(1);
    }
}
