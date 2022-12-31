package bolts;
/* compiled from: TaskCompletionSource.java */
/* loaded from: classes.dex */
public class f<TResult> {
    private final e<TResult> a = new e<>();

    public e<TResult> a() {
        return this.a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(TResult tresult) {
        if (!g(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.a.p();
    }

    public boolean f(Exception exc) {
        return this.a.q(exc);
    }

    public boolean g(TResult tresult) {
        return this.a.r(tresult);
    }
}
