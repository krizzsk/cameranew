package com.google.android.gms.internal.ads;

import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmt implements Runnable {
    private final /* synthetic */ zzms zzbdl;
    private final /* synthetic */ zzmy zzbem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmt(zzms zzmsVar, zzmy zzmyVar) {
        this.zzbdl = zzmsVar;
        this.zzbem = zzmyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.zzbem.release();
        sparseArray = this.zzbdl.zzbdx;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray2 = this.zzbdl.zzbdx;
            ((zznm) sparseArray2.valueAt(i2)).disable();
        }
    }
}
