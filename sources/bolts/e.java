package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* compiled from: Task.java */
/* loaded from: classes.dex */
public class e<TResult> {

    /* renamed from: l  reason: collision with root package name */
    private static volatile d f18l;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private TResult f19d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f20e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21f;

    /* renamed from: g  reason: collision with root package name */
    private g f22g;

    /* renamed from: i  reason: collision with root package name */
    public static final ExecutorService f15i = bolts.b.a();

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f16j = bolts.b.b();

    /* renamed from: k  reason: collision with root package name */
    public static final Executor f17k = bolts.a.c();
    private static e<?> m = new e<>((Object) null);
    private static e<Boolean> n = new e<>(Boolean.TRUE);
    private static e<Boolean> o = new e<>(Boolean.FALSE);
    private final Object a = new Object();

    /* renamed from: h  reason: collision with root package name */
    private List<bolts.d<TResult, Void>> f23h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public class a implements bolts.d<TResult, Void> {
        final /* synthetic */ f a;
        final /* synthetic */ bolts.d b;
        final /* synthetic */ Executor c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ bolts.c f24d;

        a(e eVar, f fVar, bolts.d dVar, Executor executor, bolts.c cVar) {
            this.a = fVar;
            this.b = dVar;
            this.c = executor;
        }

        @Override // bolts.d
        /* renamed from: b */
        public Void a(e<TResult> eVar) {
            e.d(this.a, this.b, eVar, this.c, this.f24d);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ bolts.c a;
        final /* synthetic */ f b;
        final /* synthetic */ bolts.d c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f25d;

        b(bolts.c cVar, f fVar, bolts.d dVar, e eVar) {
            this.b = fVar;
            this.c = dVar;
            this.f25d = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            bolts.c cVar = this.a;
            if (cVar == null) {
                try {
                    this.b.d(this.c.a(this.f25d));
                    return;
                } catch (CancellationException unused) {
                    this.b.b();
                    return;
                } catch (Exception e2) {
                    this.b.c(e2);
                    return;
                }
            }
            cVar.a();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        final /* synthetic */ bolts.c a;
        final /* synthetic */ f b;
        final /* synthetic */ Callable c;

        c(bolts.c cVar, f fVar, Callable callable) {
            this.b = fVar;
            this.c = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            bolts.c cVar = this.a;
            if (cVar == null) {
                try {
                    this.b.d(this.c.call());
                    return;
                } catch (CancellationException unused) {
                    this.b.b();
                    return;
                } catch (Exception e2) {
                    this.b.c(e2);
                    return;
                }
            }
            cVar.a();
            throw null;
        }
    }

    /* compiled from: Task.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        new e(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
    }

    public static <TResult> e<TResult> b(Callable<TResult> callable, Executor executor) {
        return c(callable, executor, null);
    }

    public static <TResult> e<TResult> c(Callable<TResult> callable, Executor executor, bolts.c cVar) {
        f fVar = new f();
        try {
            executor.execute(new c(cVar, fVar, callable));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
        return fVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(f<TContinuationResult> fVar, bolts.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, bolts.c cVar) {
        try {
            executor.execute(new b(cVar, fVar, dVar, eVar));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
    }

    public static <TResult> e<TResult> g(Exception exc) {
        f fVar = new f();
        fVar.c(exc);
        return fVar.a();
    }

    public static <TResult> e<TResult> h(TResult tresult) {
        if (tresult == null) {
            return (e<TResult>) m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (e<TResult>) n : (e<TResult>) o;
        }
        f fVar = new f();
        fVar.d(tresult);
        return fVar.a();
    }

    public static d k() {
        return f18l;
    }

    private void o() {
        synchronized (this.a) {
            for (bolts.d<TResult, Void> dVar : this.f23h) {
                try {
                    dVar.a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f23h = null;
        }
    }

    public <TContinuationResult> e<TContinuationResult> e(bolts.d<TResult, TContinuationResult> dVar) {
        return f(dVar, f16j, null);
    }

    public <TContinuationResult> e<TContinuationResult> f(bolts.d<TResult, TContinuationResult> dVar, Executor executor, bolts.c cVar) {
        boolean m2;
        f fVar = new f();
        synchronized (this.a) {
            m2 = m();
            if (!m2) {
                this.f23h.add(new a(this, fVar, dVar, executor, cVar));
            }
        }
        if (m2) {
            d(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public Exception i() {
        Exception exc;
        synchronized (this.a) {
            if (this.f20e != null) {
                this.f21f = true;
                g gVar = this.f22g;
                if (gVar != null) {
                    gVar.a();
                    this.f22g = null;
                }
            }
            exc = this.f20e;
        }
        return exc;
    }

    public TResult j() {
        TResult tresult;
        synchronized (this.a) {
            tresult = this.f19d;
        }
        return tresult;
    }

    public boolean l() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    public boolean n() {
        boolean z;
        synchronized (this.a) {
            z = i() != null;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.c = true;
            this.a.notifyAll();
            o();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(Exception exc) {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.f20e = exc;
            this.f21f = false;
            this.a.notifyAll();
            o();
            if (!this.f21f && k() != null) {
                this.f22g = new g(this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(TResult tresult) {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.f19d = tresult;
            this.a.notifyAll();
            o();
            return true;
        }
    }

    private e(TResult tresult) {
        r(tresult);
    }

    private e(boolean z) {
        if (z) {
            p();
        } else {
            r(null);
        }
    }
}
