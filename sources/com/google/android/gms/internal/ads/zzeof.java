package com.google.android.gms.internal.ads;

import java.util.ListIterator;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeof implements ListIterator<String> {
    private final /* synthetic */ int zzhzx;
    private ListIterator<String> zzivc;
    private final /* synthetic */ zzeog zzivd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeof(zzeog zzeogVar, int i2) {
        zzelv zzelvVar;
        this.zzivd = zzeogVar;
        this.zzhzx = i2;
        zzelvVar = zzeogVar.zzive;
        this.zzivc = zzelvVar.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzivc.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzivc.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzivc.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzivc.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzivc.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzivc.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
