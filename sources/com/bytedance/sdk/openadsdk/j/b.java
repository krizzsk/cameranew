package com.bytedance.sdk.openadsdk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.growingio.android.sdk.collection.Constants;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: TrackAdUrlImpl.java */
/* loaded from: classes.dex */
public class b implements com.bytedance.sdk.openadsdk.j.a {
    private final Context a;
    private final g b;
    private final ExecutorService c = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TrackAdUrlImpl.java */
    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        private final f b;

        boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) || str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX));
        }

        private a(f fVar) {
            this.b = fVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            m mVar;
            f fVar;
            if (com.bytedance.sdk.openadsdk.core.g.g.a() && a(this.b.b())) {
                if (this.b.c() == 0) {
                    b.this.b.c(this.b);
                    return null;
                }
                while (true) {
                    if (this.b.c() <= 0 || isCancelled()) {
                        break;
                    }
                    try {
                        if (this.b.c() == 5) {
                            b.this.b.a(this.b);
                        }
                    } catch (Throwable unused) {
                    }
                    if (!q.a(b.this.c())) {
                        break;
                    }
                    String b = this.b.b();
                    i a = i.a();
                    new j(0, b, a).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.g.d.a(b.this.c()).d());
                    try {
                        mVar = a.get();
                    } catch (Throwable unused2) {
                        mVar = null;
                    }
                    if (mVar != null && mVar.a()) {
                        b.this.b.c(this.b);
                        if (o.c()) {
                            o.c("trackurl", "track success : " + this.b.b());
                        }
                    } else {
                        if (o.c()) {
                            o.c("trackurl", "track fail : " + this.b.b());
                        }
                        this.b.a(fVar.c() - 1);
                        if (this.b.c() == 0) {
                            b.this.b.c(this.b);
                            if (o.c()) {
                                o.c("trackurl", "track fail and delete : " + this.b.b());
                            }
                        } else {
                            b.this.b.b(this.b);
                        }
                    }
                }
                return null;
            }
            return null;
        }
    }

    public b(Context context, g gVar) {
        this.a = context;
        this.b = gVar;
    }

    public static com.bytedance.sdk.openadsdk.j.a d() {
        return d.c();
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void b() {
        try {
            this.c.shutdownNow();
        } catch (Throwable unused) {
        }
    }

    public Context c() {
        Context context = this.a;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<f> list) {
        if (com.bytedance.sdk.openadsdk.utils.m.b(list)) {
            for (f fVar : list) {
                new a(fVar).executeOnExecutor(this.c, new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a(List<String> list) {
        if (com.bytedance.sdk.openadsdk.core.g.g.a() && com.bytedance.sdk.openadsdk.utils.m.b(list)) {
            for (String str : list) {
                new a(new f(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str, 5)).executeOnExecutor(this.c, new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a() {
        this.c.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.b.1
            @Override // java.lang.Runnable
            public void run() {
                final List<f> a2 = b.this.b.a();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.b(a2);
                    }
                });
            }
        });
    }
}
