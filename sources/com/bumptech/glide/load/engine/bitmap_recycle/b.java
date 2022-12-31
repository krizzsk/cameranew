package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.h;
import java.util.Queue;
/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class b<T extends h> {
    private final Queue<T> a = com.bumptech.glide.l.h.c(20);

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public T b() {
        T poll = this.a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
