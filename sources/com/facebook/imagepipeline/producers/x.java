package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.producers.j0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.common.network.HttpRequest;
/* compiled from: HttpUrlConnectionNetworkFetcher.java */
/* loaded from: classes.dex */
public class x extends com.facebook.imagepipeline.producers.c<c> {
    private int a;
    @Nullable
    private String b;
    @Nullable
    private final Map<String, String> c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f2994d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.common.time.b f2995e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ c a;
        final /* synthetic */ j0.a b;

        a(c cVar, j0.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.j(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* loaded from: classes.dex */
    public class b extends e {
        final /* synthetic */ Future a;
        final /* synthetic */ j0.a b;

        b(x xVar, Future future, j0.a aVar) {
            this.a = future;
            this.b = aVar;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            if (this.a.cancel(false)) {
                this.b.a();
            }
        }
    }

    /* compiled from: HttpUrlConnectionNetworkFetcher.java */
    /* loaded from: classes.dex */
    public static class c extends w {

        /* renamed from: f  reason: collision with root package name */
        private long f2996f;

        /* renamed from: g  reason: collision with root package name */
        private long f2997g;

        /* renamed from: h  reason: collision with root package name */
        private long f2998h;

        public c(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
            super(lVar, o0Var);
        }
    }

    public x(int i2) {
        this(null, null, RealtimeSinceBootClock.get());
        this.a = i2;
    }

    private HttpURLConnection g(Uri uri, int i2) throws IOException {
        HttpURLConnection o = o(uri);
        String str = this.b;
        if (str != null) {
            o.setRequestProperty(HttpRequest.HEADER_USER_AGENT, str);
        }
        Map<String, String> map = this.c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                o.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        o.setConnectTimeout(this.a);
        int responseCode = o.getResponseCode();
        if (m(responseCode)) {
            return o;
        }
        if (l(responseCode)) {
            String headerField = o.getHeaderField(HttpRequest.HEADER_LOCATION);
            o.disconnect();
            Uri parse = headerField == null ? null : Uri.parse(headerField);
            String scheme = uri.getScheme();
            if (i2 > 0 && parse != null && !com.facebook.common.internal.g.a(parse.getScheme(), scheme)) {
                return g(parse, i2 - 1);
            }
            throw new IOException(i2 == 0 ? h("URL %s follows too many redirects", uri.toString()) : h("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        o.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
    }

    private static String h(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    private static boolean l(int i2) {
        if (i2 == 307 || i2 == 308) {
            return true;
        }
        switch (i2) {
            case IjkMediaCodecInfo.RANK_SECURE /* 300 */:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    private static boolean m(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @VisibleForTesting
    static HttpURLConnection o(Uri uri) throws IOException {
        return (HttpURLConnection) com.facebook.common.util.d.o(uri).openConnection();
    }

    @Override // com.facebook.imagepipeline.producers.j0
    /* renamed from: f */
    public c e(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        return new c(lVar, o0Var);
    }

    @Override // com.facebook.imagepipeline.producers.j0
    /* renamed from: i */
    public void a(c cVar, j0.a aVar) {
        cVar.f2996f = this.f2995e.now();
        cVar.b().c(new b(this, this.f2994d.submit(new a(cVar, aVar)), aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void j(com.facebook.imagepipeline.producers.x.c r5, com.facebook.imagepipeline.producers.j0.a r6) {
        /*
            r4 = this;
            r0 = 0
            android.net.Uri r1 = r5.g()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2c
            r2 = 5
            java.net.HttpURLConnection r1 = r4.g(r1, r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2c
            com.facebook.common.time.b r2 = r4.f2995e     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3e
            long r2 = r2.now()     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3e
            com.facebook.imagepipeline.producers.x.c.l(r5, r2)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3e
            if (r1 == 0) goto L1d
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3e
            r5 = -1
            r6.b(r0, r5)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3e
        L1d:
            if (r0 == 0) goto L24
            r0.close()     // Catch: java.io.IOException -> L23
            goto L24
        L23:
        L24:
            if (r1 == 0) goto L3d
            goto L3a
        L27:
            r5 = move-exception
            goto L2e
        L29:
            r5 = move-exception
            r1 = r0
            goto L3f
        L2c:
            r5 = move-exception
            r1 = r0
        L2e:
            r6.onFailure(r5)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.io.IOException -> L37
            goto L38
        L37:
        L38:
            if (r1 == 0) goto L3d
        L3a:
            r1.disconnect()
        L3d:
            return
        L3e:
            r5 = move-exception
        L3f:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.io.IOException -> L45
            goto L46
        L45:
        L46:
            if (r1 == 0) goto L4b
            r1.disconnect()
        L4b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.x.j(com.facebook.imagepipeline.producers.x$c, com.facebook.imagepipeline.producers.j0$a):void");
    }

    @Override // com.facebook.imagepipeline.producers.j0
    /* renamed from: k */
    public Map<String, String> d(c cVar, int i2) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(cVar.f2997g - cVar.f2996f));
        hashMap.put("fetch_time", Long.toString(cVar.f2998h - cVar.f2997g));
        hashMap.put("total_time", Long.toString(cVar.f2998h - cVar.f2996f));
        hashMap.put("image_size", Integer.toString(i2));
        return hashMap;
    }

    @Override // com.facebook.imagepipeline.producers.j0
    /* renamed from: n */
    public void b(c cVar, int i2) {
        cVar.f2998h = this.f2995e.now();
    }

    @VisibleForTesting
    x(@Nullable String str, @Nullable Map<String, String> map, com.facebook.common.time.b bVar) {
        this.f2994d = Executors.newFixedThreadPool(3);
        this.f2995e = bVar;
        this.c = map;
        this.b = str;
    }
}
