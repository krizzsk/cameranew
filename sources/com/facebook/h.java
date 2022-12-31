package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.x;
import java.net.HttpURLConnection;
import java.util.List;
/* compiled from: GraphRequestAsyncTask.java */
/* loaded from: classes.dex */
public class h extends AsyncTask<Void, Void, List<GraphResponse>> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2636d = h.class.getCanonicalName();
    private final HttpURLConnection a;
    private final i b;
    private Exception c;

    public h(i iVar) {
        this(null, iVar);
    }

    protected List<GraphResponse> a(Void... voidArr) {
        try {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return null;
            }
            try {
                HttpURLConnection httpURLConnection = this.a;
                if (httpURLConnection == null) {
                    return this.b.d();
                }
                return GraphRequest.p(httpURLConnection, this.b);
            } catch (Exception e2) {
                this.c = e2;
                return null;
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    protected void b(List<GraphResponse> list) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            super.onPostExecute(list);
            Exception exc = this.c;
            if (exc != null) {
                x.Y(f2636d, String.format("onPostExecute: exception encountered during request: %s", exc.getMessage()));
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ List<GraphResponse> doInBackground(Void[] voidArr) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return a(voidArr);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(List<GraphResponse> list) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            b(list);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Handler handler;
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            super.onPreExecute();
            if (f.x()) {
                x.Y(f2636d, String.format("execute async task: %s", this));
            }
            if (this.b.j() == null) {
                if (Thread.currentThread() instanceof HandlerThread) {
                    handler = new Handler();
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                this.b.q(handler);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.a + ", requests: " + this.b + "}";
    }

    public h(HttpURLConnection httpURLConnection, i iVar) {
        this.b = iVar;
        this.a = httpURLConnection;
    }
}
