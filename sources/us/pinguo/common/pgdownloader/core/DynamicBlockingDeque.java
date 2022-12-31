package us.pinguo.common.pgdownloader.core;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: DynamicBlockingDeque.kt */
/* loaded from: classes4.dex */
public final class DynamicBlockingDeque<E> extends LinkedBlockingDeque<E> {
    private final AtomicBoolean mOfferToFirst = new AtomicBoolean();

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
    public boolean offer(E e2) {
        if (this.mOfferToFirst.get()) {
            return offerFirst(e2);
        }
        return offerLast(e2);
    }

    public final void setOfferToFirst(boolean z) {
        this.mOfferToFirst.set(z);
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }
}
