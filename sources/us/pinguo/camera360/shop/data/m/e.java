package us.pinguo.camera360.shop.data.m;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: UnityLruCache.kt */
/* loaded from: classes4.dex */
public class e {
    private final LinkedList<String> a;
    private int b;
    private final ReentrantReadWriteLock c = new ReentrantReadWriteLock();

    public e(int i2) {
        if (i2 > 0) {
            this.b = i2;
            this.a = new LinkedList<>();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final boolean a(String key) {
        s.h(key, "key");
        ReentrantReadWriteLock.ReadLock readLock = this.c.readLock();
        readLock.lock();
        try {
            return this.a.contains(key);
        } finally {
            readLock.unlock();
        }
    }

    public void b(String str) {
        throw null;
    }

    public List<String> c() {
        throw null;
    }

    public final void d(String key) {
        s.h(key, "key");
        ReentrantReadWriteLock reentrantReadWriteLock = this.c;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (this.a.contains(key)) {
                this.a.remove(key);
            }
            this.a.add(key);
            for (int i4 = 0; i4 < readHoldCount; i4++) {
                readLock.lock();
            }
            writeLock.unlock();
            List<String> c = c();
            while (true) {
                String str = null;
                ReentrantReadWriteLock reentrantReadWriteLock2 = this.c;
                readLock = reentrantReadWriteLock2.readLock();
                readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
                for (int i5 = 0; i5 < readHoldCount; i5++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock2.writeLock();
                writeLock.lock();
                try {
                    if (this.a.size() <= this.b) {
                        break;
                    }
                    Iterator<String> it = this.a.iterator();
                    s.g(it, "list.iterator()");
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        s.g(next, "itor.next()");
                        String str2 = next;
                        if (!c.contains(str2)) {
                            it.remove();
                            str = str2;
                            break;
                        }
                    }
                    u uVar = u.a;
                    for (int i6 = 0; i6 < readHoldCount; i6++) {
                        readLock.lock();
                    }
                    writeLock.unlock();
                    if (str != null) {
                        b(str);
                    }
                } finally {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                }
            }
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }
}
