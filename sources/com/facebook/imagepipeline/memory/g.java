package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;
import javax.annotation.Nullable;
/* compiled from: BucketMap.java */
/* loaded from: classes.dex */
public class g<T> {
    protected final SparseArray<b<T>> a = new SparseArray<>();
    @Nullable
    @VisibleForTesting
    b<T> b;
    @Nullable
    @VisibleForTesting
    b<T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BucketMap.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b<I> {
        @Nullable
        b<I> a;
        int b;
        LinkedList<I> c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        b<I> f2856d;

        public String toString() {
            return "LinkedEntry(key: " + this.b + ")";
        }

        private b(@Nullable b<I> bVar, int i2, LinkedList<I> linkedList, @Nullable b<I> bVar2) {
            this.a = bVar;
            this.b = i2;
            this.c = linkedList;
            this.f2856d = bVar2;
        }
    }

    private void b(b<T> bVar) {
        if (bVar == null || !bVar.c.isEmpty()) {
            return;
        }
        d(bVar);
        this.a.remove(bVar.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(b<T> bVar) {
        if (this.b == bVar) {
            return;
        }
        d(bVar);
        b bVar2 = (b<T>) this.b;
        if (bVar2 == null) {
            this.b = bVar;
            this.c = bVar;
            return;
        }
        bVar.f2856d = bVar2;
        bVar2.a = bVar;
        this.b = bVar;
    }

    private synchronized void d(b<T> bVar) {
        b bVar2 = (b<T>) bVar.a;
        b bVar3 = (b<T>) bVar.f2856d;
        if (bVar2 != null) {
            bVar2.f2856d = bVar3;
        }
        if (bVar3 != null) {
            bVar3.a = bVar2;
        }
        bVar.a = null;
        bVar.f2856d = null;
        if (bVar == this.b) {
            this.b = bVar3;
        }
        if (bVar == this.c) {
            this.c = bVar2;
        }
    }

    @Nullable
    public synchronized T a(int i2) {
        b<T> bVar = this.a.get(i2);
        if (bVar == null) {
            return null;
        }
        T pollFirst = bVar.c.pollFirst();
        c(bVar);
        return pollFirst;
    }

    public synchronized void e(int i2, T t) {
        b<T> bVar = this.a.get(i2);
        if (bVar == null) {
            bVar = new b<>(null, i2, new LinkedList(), null);
            this.a.put(i2, bVar);
        }
        bVar.c.addLast(t);
        c(bVar);
    }

    @Nullable
    public synchronized T f() {
        b<T> bVar = this.c;
        if (bVar == null) {
            return null;
        }
        T pollLast = bVar.c.pollLast();
        b(bVar);
        return pollLast;
    }
}
