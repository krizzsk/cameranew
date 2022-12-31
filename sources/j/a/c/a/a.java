package j.a.c.a;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import j.a.c.b.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import us.pinguo.common.network.HttpRequestBase;
/* compiled from: ApiAsyncTaskBase.java */
/* loaded from: classes.dex */
public abstract class a<V> implements j.a.c.b.b<V> {
    protected Context mContext;
    protected HttpRequestBase mHttpRequest;
    protected RequestFuture<V> mHttpRequestFuture = RequestFuture.newFuture();

    /* compiled from: ApiAsyncTaskBase.java */
    /* renamed from: j.a.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0313a extends d<V> {
        C0313a() {
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            a.this.mHttpRequestFuture.onErrorResponse(new VolleyError(exc));
        }

        @Override // j.a.c.b.d
        public void onSuccess(V v) {
            a.this.mHttpRequestFuture.onResponse(v);
        }
    }

    /* compiled from: ApiAsyncTaskBase.java */
    /* loaded from: classes.dex */
    class b extends d<V> {
        b() {
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            a.this.mHttpRequestFuture.onErrorResponse(new VolleyError(exc));
        }

        @Override // j.a.c.b.d
        public void onSuccess(V v) {
            a.this.mHttpRequestFuture.onResponse(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        this.mContext = context;
    }

    public static RetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy(15000, 0, 0.0f);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.mHttpRequestFuture.cancel(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void execute(HttpRequestBase httpRequestBase) {
        HttpRequestBase httpRequestBase2 = this.mHttpRequest;
        if (httpRequestBase2 != null && httpRequestBase2 != httpRequestBase) {
            httpRequestBase2.cancel();
        }
        this.mHttpRequest = httpRequestBase;
        this.mHttpRequestFuture.setRequest(httpRequestBase);
        this.mHttpRequest.setRetryPolicy(getRetryPolicy());
        this.mHttpRequest.execute();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        get(new C0313a());
        return this.mHttpRequestFuture.get();
    }

    @Override // j.a.c.b.b
    public abstract void get(d<V> dVar);

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mHttpRequestFuture.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mHttpRequestFuture.isDone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postError(d<V> dVar, Exception exc) {
        if (dVar != null) {
            dVar.onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postResponse(d<V> dVar, V v) {
        if (dVar != null) {
            dVar.onSuccess(v);
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        get(new b());
        return this.mHttpRequestFuture.get(j2, timeUnit);
    }
}
