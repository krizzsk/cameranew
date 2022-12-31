package com.unity3d.splash.services.core.configuration;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.ConditionVariable;
import com.unity3d.splash.UnityAds;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.request.WebRequest;
import com.unity3d.splash.services.core.webview.WebViewApp;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
/* loaded from: classes3.dex */
public class d extends Thread {
    private static d c;
    private b a;
    private boolean b = false;

    /* loaded from: classes3.dex */
    private static abstract class b {
        private b() {
        }

        public abstract b b();
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        private com.unity3d.splash.services.core.configuration.a a;

        public c(com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.a = aVar;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            for (String str : this.a.c()) {
                com.unity3d.splash.services.core.configuration.c b = this.a.b(str);
                if (b != null) {
                    b.b(this.a);
                }
            }
            return null;
        }
    }

    /* renamed from: com.unity3d.splash.services.core.configuration.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0288d extends b {
        private int a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private com.unity3d.splash.services.core.configuration.a f8455d;

        public C0288d(com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.a = 0;
            this.b = 6;
            this.c = 5;
            this.f8455d = aVar;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.i("Unity Ads init: load configuration from " + com.unity3d.splash.services.c.b.b.c());
            try {
                this.f8455d.i();
                return new h(this.f8455d);
            } catch (Exception e2) {
                int i2 = this.a;
                if (i2 < this.b) {
                    int i3 = this.c * 2;
                    this.c = i3;
                    this.a = i2 + 1;
                    return new l(this, i3);
                }
                return new j(e2, this, this.f8455d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends b {
        private com.unity3d.splash.services.core.configuration.a a;
        private String b;

        public e(com.unity3d.splash.services.core.configuration.a aVar, String str) {
            super();
            this.a = aVar;
            this.b = str;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.c("Unity Ads init: creating webapp");
            com.unity3d.splash.services.core.configuration.a aVar = this.a;
            aVar.k(this.b);
            try {
                if (WebViewApp.b(aVar)) {
                    return new c(this.a);
                }
                DeviceLog.f("Unity Ads WebApp creation failed!");
                return new f("create webapp", new Exception("Creation of WebApp failed!"), this.a);
            } catch (IllegalThreadStateException e2) {
                DeviceLog.g("Illegal Thread", e2);
                return new f("create webapp", e2, this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends b {
        String a;
        Exception b;
        protected com.unity3d.splash.services.core.configuration.a c;

        public f(String str, Exception exc, com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.a = str;
            this.b = exc;
            this.c = aVar;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.f("Unity Ads init: halting init in " + this.a + ": " + this.b.getMessage());
            for (String str : this.c.c()) {
                com.unity3d.splash.services.core.configuration.c b = this.c.b(str);
                if (b != null) {
                    b.f(this.c, this.a, this.b.getMessage());
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends b {
        private com.unity3d.splash.services.core.configuration.a a;

        public g(com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.a = aVar;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            for (String str : this.a.c()) {
                com.unity3d.splash.services.core.configuration.c b = this.a.b(str);
                if (b != null && !b.d(this.a)) {
                    return null;
                }
            }
            return new C0288d(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends b {
        private com.unity3d.splash.services.core.configuration.a a;

        public h(com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.a = aVar;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.c("Unity Ads init: check if webapp can be loaded from local cache");
            try {
                byte[] c = com.unity3d.splash.services.c.a.b.c(new File(com.unity3d.splash.services.c.b.b.g()));
                String b = com.unity3d.splash.services.c.a.b.b(c);
                if (b == null || !b.equals(this.a.f())) {
                    UnityAds.c(true);
                    return new i(this.a);
                }
                try {
                    String str = new String(c, "UTF-8");
                    DeviceLog.i("Unity Ads init: webapp loaded from local cache");
                    return new e(this.a, str);
                } catch (UnsupportedEncodingException e2) {
                    return new f("load cache", e2, this.a);
                }
            } catch (IOException e3) {
                DeviceLog.c("Unity Ads init: webapp not found in local cache: " + e3.getMessage());
                return new i(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends b {
        private com.unity3d.splash.services.core.configuration.a a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f8456d;

        public i(com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.b = 0;
            this.c = 6;
            this.f8456d = 5;
            this.a = aVar;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.i("Unity Ads init: loading webapp from " + this.a.g());
            try {
                try {
                    String k2 = new WebRequest(this.a.g(), "GET", null).k();
                    String f2 = this.a.f();
                    if (f2 == null || com.unity3d.splash.services.c.a.b.a(k2).equals(f2)) {
                        if (f2 != null) {
                            com.unity3d.splash.services.c.a.b.g(new File(com.unity3d.splash.services.c.b.b.g()), k2);
                        }
                        return new e(this.a, k2);
                    }
                    return new f("load web", new Exception("Invalid webViewHash"), this.a);
                } catch (Exception e2) {
                    if (this.b < this.c) {
                        int i2 = this.f8456d * 2;
                        this.f8456d = i2;
                        this.b++;
                        return new l(this, i2);
                    }
                    return new j(e2, this, this.a);
                }
            } catch (MalformedURLException e3) {
                DeviceLog.g("Malformed URL", e3);
                return new f("make webrequest", e3, this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends f implements com.unity3d.splash.services.core.connectivity.c {

        /* renamed from: f  reason: collision with root package name */
        private static int f8457f;

        /* renamed from: g  reason: collision with root package name */
        private static long f8458g;

        /* renamed from: d  reason: collision with root package name */
        private b f8459d;

        /* renamed from: e  reason: collision with root package name */
        private ConditionVariable f8460e;

        public j(Exception exc, b bVar, com.unity3d.splash.services.core.configuration.a aVar) {
            super("network error", exc, aVar);
            this.f8459d = bVar;
        }

        private boolean c() {
            return System.currentTimeMillis() - f8458g >= 10000 && f8457f <= 500;
        }

        @Override // com.unity3d.splash.services.core.connectivity.c
        public void a() {
            DeviceLog.c("Unity Ads init got disconnected event");
        }

        @Override // com.unity3d.splash.services.core.configuration.d.f, com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.f("Unity Ads init: network error, waiting for connection events");
            this.f8460e = new ConditionVariable();
            com.unity3d.splash.services.core.connectivity.a.a(this);
            boolean block = this.f8460e.block(600000L);
            com.unity3d.splash.services.core.connectivity.a.f(this);
            return block ? this.f8459d : new f("network error", new Exception("No connected events within the timeout!"), this.c);
        }

        @Override // com.unity3d.splash.services.core.connectivity.c
        public void onConnected() {
            f8457f++;
            DeviceLog.c("Unity Ads init got connected event");
            if (c()) {
                this.f8460e.open();
            }
            if (f8457f > 500) {
                com.unity3d.splash.services.core.connectivity.a.f(this);
            }
            f8458g = System.currentTimeMillis();
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends b {
        private com.unity3d.splash.services.core.configuration.a a;

        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ WebViewApp a;
            final /* synthetic */ ConditionVariable b;

            a(k kVar, WebViewApp webViewApp, ConditionVariable conditionVariable) {
                this.a = webViewApp;
                this.b = conditionVariable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.f().destroy();
                this.a.p(null);
                this.b.open();
            }
        }

        public k(com.unity3d.splash.services.core.configuration.a aVar) {
            super();
            this.a = aVar;
        }

        @TargetApi(14)
        private void c() {
            if (com.unity3d.splash.services.core.api.a.a() != null) {
                if (com.unity3d.splash.services.c.b.a.a() != null) {
                    com.unity3d.splash.services.c.b.a.a().unregisterActivityLifecycleCallbacks(com.unity3d.splash.services.core.api.a.a());
                }
                com.unity3d.splash.services.core.api.a.b(null);
            }
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            boolean z;
            DeviceLog.c("Unity Ads init: starting init");
            ConditionVariable conditionVariable = new ConditionVariable();
            WebViewApp e2 = WebViewApp.e();
            if (e2 != null) {
                e2.o(false);
                e2.n(false);
                if (e2.f() != null) {
                    com.unity3d.splash.services.c.a.b.d(new a(this, e2, conditionVariable));
                    z = conditionVariable.block(10000L);
                } else {
                    z = true;
                }
                if (!z) {
                    return new f("reset webapp", new Exception("Reset failed on opening ConditionVariable"), this.a);
                }
            }
            if (Build.VERSION.SDK_INT > 13) {
                c();
            }
            com.unity3d.splash.services.c.b.b.j(null);
            if (com.unity3d.splash.services.c.b.b.a() == null) {
                return new f("reset webapp", new Exception("Cache directory is NULL"), this.a);
            }
            com.unity3d.splash.services.c.b.b.m(false);
            this.a.j(com.unity3d.splash.services.c.b.b.c());
            for (String str : this.a.c()) {
                com.unity3d.splash.services.core.configuration.c b = this.a.b(str);
                if (b != null) {
                    b.e(this.a);
                }
            }
            return new g(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends b {
        b a;
        int b;

        public l(b bVar, int i2) {
            super();
            this.a = bVar;
            this.b = i2;
        }

        @Override // com.unity3d.splash.services.core.configuration.d.b
        public b b() {
            DeviceLog.c("Unity Ads init: retrying in " + this.b + " seconds");
            try {
                Thread.sleep(this.b * 1000);
            } catch (InterruptedException e2) {
                DeviceLog.g("Init retry interrupted", e2);
            }
            return this.a;
        }
    }

    private d(b bVar) {
        this.a = bVar;
    }

    public static synchronized void a(com.unity3d.splash.services.core.configuration.a aVar) {
        synchronized (d.class) {
            if (c == null) {
                d dVar = new d(new k(aVar));
                c = dVar;
                dVar.setName("UnityAdsInitializeThread");
                c.start();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            b bVar = this.a;
            if (bVar == null || (bVar instanceof c) || this.b) {
                break;
            }
            this.a = bVar.b();
        }
        c = null;
    }
}
