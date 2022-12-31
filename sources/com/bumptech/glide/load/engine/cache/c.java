package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {
    private final Map<com.bumptech.glide.load.b, b> a = new HashMap();
    private final C0032c b = new C0032c();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class b {
        final Lock a;
        int b;

        private b() {
            this.a = new ReentrantLock();
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0032c {
        private final Queue<b> a;

        private C0032c() {
            this.a = new ArrayDeque();
        }

        b a() {
            b poll;
            synchronized (this.a) {
                poll = this.a.poll();
            }
            return poll == null ? new b() : poll;
        }

        void b(b bVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.load.b bVar) {
        b bVar2;
        synchronized (this) {
            bVar2 = this.a.get(bVar);
            if (bVar2 == null) {
                bVar2 = this.b.a();
                this.a.put(bVar, bVar2);
            }
            bVar2.b++;
        }
        bVar2.a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.bumptech.glide.load.b bVar) {
        b bVar2;
        int i2;
        synchronized (this) {
            bVar2 = this.a.get(bVar);
            if (bVar2 != null && (i2 = bVar2.b) > 0) {
                int i3 = i2 - 1;
                bVar2.b = i3;
                if (i3 == 0) {
                    b remove = this.a.remove(bVar);
                    if (remove.equals(bVar2)) {
                        this.b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar2 + ", but actually removed: " + remove + ", key: " + bVar);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(bVar);
            sb.append(", interestedThreads: ");
            sb.append(bVar2 == null ? 0 : bVar2.b);
            throw new IllegalArgumentException(sb.toString());
        }
        bVar2.a.unlock();
    }
}
