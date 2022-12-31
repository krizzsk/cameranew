package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzenf extends zzejs {
    private final zzenh zzitr;
    private zzejw zzits = zzbki();
    private final /* synthetic */ zzeng zzitt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzenf(zzeng zzengVar) {
        this.zzitt = zzengVar;
        this.zzitr = new zzenh(zzengVar, null);
    }

    private final zzejw zzbki() {
        if (this.zzitr.hasNext()) {
            return (zzejw) ((zzejy) this.zzitr.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzits != null;
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final byte nextByte() {
        zzejw zzejwVar = this.zzits;
        if (zzejwVar != null) {
            byte nextByte = zzejwVar.nextByte();
            if (!this.zzits.hasNext()) {
                this.zzits = zzbki();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
