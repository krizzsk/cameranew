package us.pinguo.foundation.r;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
/* compiled from: RxBus.java */
/* loaded from: classes4.dex */
public class d {
    private static ReadWriteLock b;
    private static Lock c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile d f11040d;
    private final Subject a = new SerializedSubject(PublishSubject.create());

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        b = reentrantReadWriteLock;
        c = reentrantReadWriteLock.readLock();
        b.writeLock();
    }

    public static d a() {
        c.lock();
        d dVar = f11040d;
        if (f11040d == null) {
            synchronized (d.class) {
                dVar = f11040d;
                if (f11040d == null) {
                    dVar = new d();
                    f11040d = dVar;
                }
            }
        }
        c.unlock();
        return dVar;
    }

    public void b(Object obj) {
        this.a.onNext(obj);
    }

    public <T> Observable<T> c(Class<T> cls) {
        return (Observable<T>) this.a.ofType(cls);
    }
}
