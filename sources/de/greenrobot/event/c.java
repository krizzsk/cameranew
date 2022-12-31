package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: EventBus.java */
/* loaded from: classes3.dex */
public class c {
    private static volatile c n;
    private static /* synthetic */ int[] p;

    /* renamed from: l  reason: collision with root package name */
    static ExecutorService f8616l = Executors.newCachedThreadPool();
    public static String m = "Event";
    private static final Map<Class<?>, List<Class<?>>> o = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<List<Object>> f8617d = new a(this);

    /* renamed from: e  reason: collision with root package name */
    private final ThreadLocal<C0308c> f8618e = new b(this);

    /* renamed from: f  reason: collision with root package name */
    private String f8619f = "onEvent";
    private final Map<Class<?>, CopyOnWriteArrayList<k>> a = new HashMap();
    private final Map<Object, List<Class<?>>> b = new HashMap();
    private final Map<Class<?>, Object> c = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private final d f8620g = new d(this, Looper.getMainLooper(), 10);

    /* renamed from: h  reason: collision with root package name */
    private final de.greenrobot.event.b f8621h = new de.greenrobot.event.b(this);

    /* renamed from: i  reason: collision with root package name */
    private final de.greenrobot.event.a f8622i = new de.greenrobot.event.a(this);

    /* renamed from: j  reason: collision with root package name */
    private final j f8623j = new j();

    /* renamed from: k  reason: collision with root package name */
    private boolean f8624k = true;

    /* compiled from: EventBus.java */
    /* loaded from: classes3.dex */
    class a extends ThreadLocal<List<Object>> {
        a(c cVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public List<Object> initialValue() {
            return new ArrayList();
        }
    }

    /* compiled from: EventBus.java */
    /* loaded from: classes3.dex */
    class b extends ThreadLocal<C0308c> {
        b(c cVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public C0308c initialValue() {
            return new C0308c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* renamed from: de.greenrobot.event.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0308c {
        boolean a;

        C0308c() {
        }
    }

    static /* synthetic */ int[] a() {
        int[] iArr = p;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ThreadMode.valuesCustom().length];
        try {
            iArr2[ThreadMode.Async.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ThreadMode.BackgroundThread.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ThreadMode.MainThread.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ThreadMode.PostThread.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        p = iArr2;
        return iArr2;
    }

    static void b(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                b(list, cls.getInterfaces());
            }
        }
    }

    private List<Class<?>> c(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = o;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    b(list, cls2.getInterfaces());
                }
                o.put(cls, list);
            }
        }
        return list;
    }

    public static c d() {
        if (n == null) {
            synchronized (c.class) {
                if (n == null) {
                    n = new c();
                }
            }
        }
        return n;
    }

    private void h(Object obj, boolean z) throws Error {
        CopyOnWriteArrayList<k> copyOnWriteArrayList;
        Class<?> cls = obj.getClass();
        List<Class<?>> c = c(cls);
        int size = c.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> cls2 = c.get(i2);
            synchronized (this) {
                copyOnWriteArrayList = this.a.get(cls2);
            }
            if (copyOnWriteArrayList != null) {
                Iterator<k> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    i(it.next(), obj, z);
                }
                z2 = true;
            }
        }
        if (z2) {
            return;
        }
        String str = m;
        Log.d(str, "No subscripers registered for event " + cls);
        if (cls == e.class || cls == h.class) {
            return;
        }
        g(new e(this, obj));
    }

    private void i(k kVar, Object obj, boolean z) {
        int i2 = a()[kVar.b.b.ordinal()];
        if (i2 == 1) {
            f(kVar, obj);
        } else if (i2 == 2) {
            if (z) {
                f(kVar, obj);
            } else {
                this.f8620g.a(kVar, obj);
            }
        } else if (i2 == 3) {
            if (z) {
                this.f8621h.a(kVar, obj);
            } else {
                f(kVar, obj);
            }
        } else if (i2 == 4) {
            this.f8622i.a(kVar, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + kVar.b.b);
        }
    }

    private void k(Object obj, String str, boolean z) {
        for (i iVar : this.f8623j.a(obj.getClass(), str)) {
            l(obj, iVar, z);
        }
    }

    private void l(Object obj, i iVar, boolean z) {
        Object obj2;
        Class<?> cls = iVar.c;
        CopyOnWriteArrayList<k> copyOnWriteArrayList = this.a.get(cls);
        k kVar = new k(obj, iVar);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else {
            Iterator<k> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().equals(kVar)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        iVar.a.setAccessible(true);
        copyOnWriteArrayList.add(kVar);
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.c) {
                obj2 = this.c.get(cls);
            }
            if (obj2 != null) {
                i(kVar, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void n(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<k> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                if (copyOnWriteArrayList.get(i2).a == obj) {
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(f fVar) {
        Object obj = fVar.a;
        k kVar = fVar.b;
        f.b(fVar);
        f(kVar, obj);
    }

    void f(k kVar, Object obj) throws Error {
        try {
            kVar.b.a.invoke(kVar.a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (obj instanceof h) {
                String str = m;
                Log.e(str, "SubscriberExceptionEvent subscriber " + kVar.a.getClass() + " threw an exception", cause);
                h hVar = (h) obj;
                String str2 = m;
                Log.e(str2, "Initial event " + hVar.b + " caused exception in " + hVar.c, hVar.a);
                return;
            }
            if (this.f8624k) {
                String str3 = m;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + kVar.a.getClass(), cause);
            }
            g(new h(this, cause, obj, kVar.a));
        }
    }

    public void g(Object obj) {
        List<Object> list = this.f8617d.get();
        list.add(obj);
        C0308c c0308c = this.f8618e.get();
        if (c0308c.a) {
            return;
        }
        boolean z = Looper.getMainLooper() == Looper.myLooper();
        c0308c.a = true;
        while (!list.isEmpty()) {
            try {
                h(list.remove(0), z);
            } finally {
                c0308c.a = false;
            }
        }
    }

    public void j(Object obj) {
        k(obj, this.f8619f, false);
    }

    public synchronized void m(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                n(obj, cls);
            }
            this.b.remove(obj);
        } else {
            String str = m;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }
}
