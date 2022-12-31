package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
final class f1 {
    private final ConcurrentHashMap<e1, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.b.poll();
            if (poll == null) {
                break;
            }
            this.a.remove(poll);
        }
        List<Throwable> list = this.a.get(new e1(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.a.putIfAbsent(new e1(th, this.b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
