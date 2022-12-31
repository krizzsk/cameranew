package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzenh implements Iterator<zzejy> {
    private final ArrayDeque<zzeng> zziua;
    private zzejy zziub;

    private zzenh(zzejr zzejrVar) {
        zzejr zzejrVar2;
        if (zzejrVar instanceof zzeng) {
            zzeng zzengVar = (zzeng) zzejrVar;
            ArrayDeque<zzeng> arrayDeque = new ArrayDeque<>(zzengVar.zzbgm());
            this.zziua = arrayDeque;
            arrayDeque.push(zzengVar);
            zzejrVar2 = zzengVar.zzitw;
            this.zziub = zzal(zzejrVar2);
            return;
        }
        this.zziua = null;
        this.zziub = (zzejy) zzejrVar;
    }

    private final zzejy zzal(zzejr zzejrVar) {
        while (zzejrVar instanceof zzeng) {
            zzeng zzengVar = (zzeng) zzejrVar;
            this.zziua.push(zzengVar);
            zzejrVar = zzengVar.zzitw;
        }
        return (zzejy) zzejrVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zziub != null;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzejy next() {
        zzejy zzejyVar;
        zzejr zzejrVar;
        zzejy zzejyVar2 = this.zziub;
        if (zzejyVar2 != null) {
            do {
                ArrayDeque<zzeng> arrayDeque = this.zziua;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    zzejyVar = null;
                    break;
                }
                zzejrVar = this.zziua.pop().zzitx;
                zzejyVar = zzal(zzejrVar);
            } while (zzejyVar.isEmpty());
            this.zziub = zzejyVar;
            return zzejyVar2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzenh(zzejr zzejrVar, zzenf zzenfVar) {
        this(zzejrVar);
    }
}
