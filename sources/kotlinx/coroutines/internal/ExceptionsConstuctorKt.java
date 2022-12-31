package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class ExceptionsConstuctorKt {
    private static final int a = d(Throwable.class, -1);
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, kotlin.jvm.b.l<Throwable, Throwable>> c = new WeakHashMap<>();

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            return a;
        }
    }

    private static final kotlin.jvm.b.l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && kotlin.jvm.internal.s.c(parameterTypes[0], String.class) && kotlin.jvm.internal.s.c(parameterTypes[1], Throwable.class)) {
                    return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (kotlin.jvm.internal.s.c(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (kotlin.jvm.internal.s.c(cls, String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        }
        return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
    }

    private static final int b(Class<?> cls, int i2) {
        do {
            int i3 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i2;
    }

    static /* synthetic */ int c(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return b(cls, i2);
    }

    private static final int d(Class<?> cls, int i2) {
        Integer m41constructorimpl;
        kotlin.jvm.a.c(cls);
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.m47isFailureimpl(m41constructorimpl)) {
            m41constructorimpl = valueOf;
        }
        return ((Number) m41constructorimpl).intValue();
    }

    public static final <E extends Throwable> E e(E e2) {
        Object m41constructorimpl;
        List D;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e2 instanceof kotlinx.coroutines.g0) {
            try {
                Result.a aVar = Result.Companion;
                m41constructorimpl = Result.m41constructorimpl(((kotlinx.coroutines.g0) e2).createCopy());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
            }
            return (E) (Result.m47isFailureimpl(m41constructorimpl) ? null : m41constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            kotlin.jvm.b.l<Throwable, Throwable> lVar = c.get(e2.getClass());
            if (lVar == null) {
                int i2 = 0;
                if (a != d(e2.getClass(), 0)) {
                    readLock = reentrantReadWriteLock.readLock();
                    readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                    for (int i3 = 0; i3 < readHoldCount; i3++) {
                        readLock.unlock();
                    }
                    writeLock = reentrantReadWriteLock.writeLock();
                    writeLock.lock();
                    try {
                        c.put(e2.getClass(), ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE);
                        kotlin.u uVar = kotlin.u.a;
                        return null;
                    } finally {
                        while (i2 < readHoldCount) {
                            readLock.lock();
                            i2++;
                        }
                        writeLock.unlock();
                    }
                }
                D = kotlin.collections.n.D(e2.getClass().getConstructors(), new a());
                Iterator it = D.iterator();
                kotlin.jvm.b.l<Throwable, Throwable> lVar2 = null;
                while (it.hasNext() && (lVar2 = a((Constructor) it.next())) == null) {
                }
                ReentrantReadWriteLock reentrantReadWriteLock2 = b;
                readLock = reentrantReadWriteLock2.readLock();
                readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
                for (int i4 = 0; i4 < readHoldCount; i4++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock2.writeLock();
                writeLock.lock();
                try {
                    c.put(e2.getClass(), lVar2 == null ? ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE : lVar2);
                    kotlin.u uVar2 = kotlin.u.a;
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                    if (lVar2 == null) {
                        return null;
                    }
                    return (E) lVar2.invoke(e2);
                } finally {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                }
            }
            return (E) lVar.invoke(e2);
        } finally {
            readLock2.unlock();
        }
    }
}
