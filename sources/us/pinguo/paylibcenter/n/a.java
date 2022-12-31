package us.pinguo.paylibcenter.n;

import android.content.Context;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import us.pinguo.common.network.HttpRequestBase;
/* compiled from: ApiAsyncTaskBase.java */
/* loaded from: classes5.dex */
public abstract class a<V> implements Object<V> {
    protected Context a;
    protected HttpRequestBase b;
    protected RequestFuture<V> c = RequestFuture.newFuture();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApiAsyncTaskBase.java */
    /* renamed from: us.pinguo.paylibcenter.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0422a extends us.pinguo.paylibcenter.n.b<V> {
        C0422a() {
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception exc) {
            a.this.c.onErrorResponse(new VolleyError(exc));
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void b(V v) {
            a.this.c.onResponse(v);
        }
    }

    /* compiled from: ApiAsyncTaskBase.java */
    /* loaded from: classes5.dex */
    class b extends us.pinguo.paylibcenter.n.b<V> {
        b() {
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception exc) {
            a.this.c.onErrorResponse(new VolleyError(exc));
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void b(V v) {
            a.this.c.onResponse(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HttpRequestBase httpRequestBase) {
        HttpRequestBase httpRequestBase2 = this.b;
        if (httpRequestBase2 != null && httpRequestBase2 != httpRequestBase) {
            httpRequestBase2.cancel();
        }
        this.b = httpRequestBase;
        this.c.setRequest(httpRequestBase);
        this.b.execute();
    }

    public abstract void b(us.pinguo.paylibcenter.n.b<V> bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(us.pinguo.paylibcenter.n.b<V> bVar, Exception exc) {
        if (bVar != null) {
            bVar.a(exc);
        }
    }

    public boolean cancel(boolean z) {
        return this.c.cancel(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(us.pinguo.paylibcenter.n.b<V> bVar, V v) {
        if (bVar != null) {
            bVar.b(v);
        }
    }

    public V get() throws InterruptedException, ExecutionException {
        b(new C0422a());
        return this.c.get();
    }

    public boolean isCancelled() {
        return this.c.isCancelled();
    }

    public boolean isDone() {
        return this.c.isDone();
    }

    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        b(new b());
        return this.c.get(j2, timeUnit);
    }
}
