package com.bytedance.sdk.openadsdk.h.f;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.f;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: VideoCachePreloader.java */
/* loaded from: classes.dex */
public class a {
    public static final boolean a = o.c();
    private HashMap<String, Boolean> b;
    private C0062a c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoCachePreloader.java */
    /* loaded from: classes.dex */
    public static class b {
        private static final a a = new a();
    }

    public static a a() {
        return b.a;
    }

    private static c c() {
        c cVar;
        c cVar2 = null;
        if (com.bytedance.sdk.openadsdk.h.g.a.d()) {
            File file = new File(com.bytedance.sdk.openadsdk.h.g.a.a(com.bytedance.sdk.openadsdk.h.g.a.b(), "cache").getPath());
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                cVar = new c(file);
            } catch (IOException e2) {
                e = e2;
            }
            try {
                cVar.a(104857600L);
                return cVar;
            } catch (IOException e3) {
                e = e3;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return null;
    }

    public boolean b() {
        if (this.c != null) {
            return true;
        }
        c c = c();
        if (c == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.a().d();
        try {
            C0062a c0062a = new C0062a();
            this.c = c0062a;
            c0062a.start();
            e.a(c, com.bytedance.sdk.openadsdk.core.o.a());
            d.c().a(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private a() {
        this.b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.h.f.b bVar) {
        if (b()) {
            this.c.a(bVar);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoCachePreloader.java */
    /* renamed from: com.bytedance.sdk.openadsdk.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0062a extends Thread {

        /* renamed from: d  reason: collision with root package name */
        private final Queue<C0063a> f2053d = new ArrayBlockingQueue(10);
        private Queue<C0063a> b = new LinkedBlockingQueue();
        private boolean c = true;

        /* renamed from: e  reason: collision with root package name */
        private Queue<C0063a> f2054e = new LinkedBlockingQueue();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: VideoCachePreloader.java */
        /* renamed from: com.bytedance.sdk.openadsdk.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0063a {
            public int a;
            public String b;
            public String[] c;

            /* renamed from: d  reason: collision with root package name */
            public int f2055d;

            /* renamed from: e  reason: collision with root package name */
            public String f2056e;

            /* renamed from: f  reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.h.f.b f2057f;

            public C0063a() {
            }
        }

        public C0062a() {
        }

        private C0063a a(int i2, com.bytedance.sdk.openadsdk.h.f.b bVar) {
            b();
            o.b("VideoCachePreloader", "pool: " + this.f2053d.size());
            C0063a poll = this.f2053d.poll();
            if (poll == null) {
                poll = new C0063a();
            }
            poll.a = i2;
            poll.f2057f = bVar;
            return poll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0063a c0063a) {
            b();
            this.f2054e.add(c0063a);
            notify();
        }

        private void c(C0063a c0063a) {
            a();
            if (c0063a == null) {
                return;
            }
            this.b.offer(c0063a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String[] strArr;
            while (this.c) {
                synchronized (this) {
                    if (!this.f2054e.isEmpty()) {
                        c();
                    }
                    while (!this.b.isEmpty()) {
                        C0063a poll = this.b.poll();
                        if (poll != null) {
                            int i2 = poll.a;
                            if (i2 == 0) {
                                String[] strArr2 = poll.c;
                                if (strArr2 != null && strArr2.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : poll.c) {
                                        if (com.bytedance.sdk.openadsdk.h.g.d.a(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    d.c().a(false, !TextUtils.isEmpty(poll.f2056e), poll.f2055d, poll.b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                }
                            } else if (i2 == 1) {
                                d.c().a(poll.b);
                            } else if (i2 == 2) {
                                d.c().d();
                            } else if (i2 == 3) {
                                d.c().d();
                                if (e.c() != null) {
                                    e.c().a();
                                }
                                if (e.b() != null) {
                                    e.b().a();
                                }
                            } else if (i2 == 4) {
                                d.c().d();
                                this.c = false;
                            }
                            a(poll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            a();
            while (true) {
                C0063a poll = this.f2054e.poll();
                if (poll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.h.f.b bVar = poll.f2057f;
                String str = bVar.a;
                poll.b = str;
                poll.c = new String[]{str};
                poll.f2055d = bVar.b;
                String str2 = bVar.c;
                poll.f2056e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    poll.b = poll.f2057f.c;
                }
                poll.f2057f = null;
                c(poll);
            }
        }

        private void a(C0063a c0063a) {
            a();
            c0063a.c = null;
            c0063a.b = null;
            c0063a.a = -1;
            c0063a.f2057f = null;
            this.f2053d.offer(c0063a);
        }

        public void a(com.bytedance.sdk.openadsdk.h.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.h.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.c);
        return f.a().a(false, z, z ? bVar.c : bVar.a, bVar.a);
    }
}
