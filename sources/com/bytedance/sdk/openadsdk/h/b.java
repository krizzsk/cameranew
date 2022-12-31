package com.bytedance.sdk.openadsdk.h;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.h;
import com.bytedance.sdk.openadsdk.h.i;
import com.bytedance.sdk.openadsdk.h.l;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadTask.java */
/* loaded from: classes.dex */
public class b extends com.bytedance.sdk.openadsdk.h.a {
    final Object m;
    final Object n;
    private final int o;
    private final InterfaceC0061b p;
    private volatile h.a q;
    private volatile com.bytedance.sdk.openadsdk.h.c.b r;

    /* compiled from: DownloadTask.java */
    /* renamed from: com.bytedance.sdk.openadsdk.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.f2012d, aVar.f2013e);
        this.o = aVar.f2015g;
        this.p = aVar.f2017i;
        this.m = this;
        this.f1995g = aVar.a;
        this.f1996h = aVar.b;
        this.f1994f = aVar.f2014f;
        this.f1998j = aVar.c;
        this.f1997i = aVar.f2016h;
        this.n = aVar.f2018j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0187, code lost:
        r13 = com.bytedance.sdk.openadsdk.h.e.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0189, code lost:
        if (r13 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018b, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + r5 + ", max: " + r12.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ab, code lost:
        com.bytedance.sdk.openadsdk.h.g.d.a(r6.d());
        r4.a();
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01b8, code lost:
        if (r13 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ba, code lost:
        android.util.Log.w("TAG_PROXY_DownloadTask", "cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c6, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cb, code lost:
        if (com.bytedance.sdk.openadsdk.h.e.c == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cd, code lost:
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d4, code lost:
        com.bytedance.sdk.openadsdk.h.g.d.a(r6.d());
        r4.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01de, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.bytedance.sdk.openadsdk.h.l.a r13) throws java.io.IOException, com.bytedance.sdk.openadsdk.h.h.a, com.bytedance.sdk.openadsdk.h.c.a, com.bytedance.sdk.openadsdk.h.c.b, com.bytedance.sdk.adnet.err.VAdError {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.b.a(com.bytedance.sdk.openadsdk.h.l$a):void");
    }

    private boolean j() throws com.bytedance.sdk.openadsdk.h.c.a, VAdError {
        while (this.f1998j.a()) {
            e();
            l.a b = this.f1998j.b();
            try {
                a(b);
                return true;
            } catch (com.bytedance.sdk.openadsdk.h.c.b e2) {
                this.r = e2;
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.h.c.c e3) {
                b.a();
                a(Boolean.valueOf(g()), this.f1995g, e3);
            } catch (h.a e4) {
                this.q = e4;
                a(Boolean.valueOf(g()), this.f1995g, e4);
                return false;
            } catch (IOException e5) {
                if (e5 instanceof SocketTimeoutException) {
                    b.b();
                }
                if (b()) {
                    if (e.c) {
                        if ("Canceled".equalsIgnoreCase(e5.getMessage())) {
                            Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                        } else {
                            Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e5));
                        }
                    }
                } else {
                    a(Boolean.valueOf(g()), this.f1995g, e5);
                }
            } catch (Throwable th) {
                if (e.c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                }
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h.a h() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.h.c.b i() {
        return this.r;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.f1996h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bytedance.sdk.adnet.err.a e2) {
            e2.printStackTrace();
        } catch (VAdError e3) {
            e3.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.h.c.a e4) {
            if (e.c) {
                Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
            }
        } catch (Throwable th) {
            if (e.c) {
                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
            }
        }
        this.f1992d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.a.b(this.f1996h);
        InterfaceC0061b interfaceC0061b = this.p;
        if (interfaceC0061b != null) {
            interfaceC0061b.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadTask.java */
    /* loaded from: classes.dex */
    public static final class a {
        String a;
        String b;
        l c;

        /* renamed from: d  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.h.a.a f2012d;

        /* renamed from: e  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.h.b.c f2013e;

        /* renamed from: f  reason: collision with root package name */
        List<i.b> f2014f;

        /* renamed from: g  reason: collision with root package name */
        int f2015g;

        /* renamed from: h  reason: collision with root package name */
        i f2016h;

        /* renamed from: i  reason: collision with root package name */
        InterfaceC0061b f2017i;

        /* renamed from: j  reason: collision with root package name */
        Object f2018j;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(l lVar) {
            if (lVar != null) {
                this.c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(com.bytedance.sdk.openadsdk.h.a.a aVar) {
            if (aVar != null) {
                this.f2012d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
            if (cVar != null) {
                this.f2013e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(List<i.b> list) {
            this.f2014f = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(int i2) {
            this.f2015g = i2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(InterfaceC0061b interfaceC0061b) {
            this.f2017i = interfaceC0061b;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(i iVar) {
            this.f2016h = iVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(Object obj) {
            this.f2018j = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a() {
            if (this.f2012d != null && this.f2013e != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && this.c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
