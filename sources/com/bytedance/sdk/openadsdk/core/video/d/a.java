package com.bytedance.sdk.openadsdk.core.video.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: BaseVideoController.java */
/* loaded from: classes.dex */
public abstract class a implements c, d, ad.a {
    private WeakReference<e> C;
    private int D;
    private long K;
    private int M;
    public final WeakReference<Context> a;
    public final h b;
    public long c;

    /* renamed from: h  reason: collision with root package name */
    public long f1797h;

    /* renamed from: i  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.h f1798i;

    /* renamed from: j  reason: collision with root package name */
    private final ViewGroup f1799j;
    private com.bytedance.sdk.openadsdk.core.video.e.d n;
    private c.a o;
    private ArrayList<Runnable> r;
    private boolean s;
    private final boolean t;

    /* renamed from: k  reason: collision with root package name */
    private final ad f1800k = new ad(this);

    /* renamed from: l  reason: collision with root package name */
    private long f1801l = 0;
    private long m = 0;
    private long p = 0;
    private long q = 0;
    private boolean u = false;
    private boolean v = false;
    private boolean w = true;
    private boolean x = false;
    private long y = 0;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;

    /* renamed from: d  reason: collision with root package name */
    protected Map<String, Object> f1793d = null;

    /* renamed from: e  reason: collision with root package name */
    protected long f1794e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected long f1795f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f1796g = false;
    private boolean E = false;
    private boolean F = true;
    private final Runnable G = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                a.this.n.e();
            }
        }
    };
    private final Runnable H = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                a.this.o.a();
            }
        }
    };
    private final Runnable I = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                a aVar = a.this;
                if (aVar.c <= 0) {
                    aVar.n.e();
                }
                a.this.n.f();
            }
            a.this.f1800k.postDelayed(this, 200L);
        }
    };
    private boolean J = false;
    private final BroadcastReceiver L = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                a.this.h();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                a.this.b(context);
            }
        }
    };
    private boolean N = false;

    /* compiled from: BaseVideoController.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.a$6  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.a.values().length];
            a = iArr;
            try {
                iArr[e.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, ViewGroup viewGroup, h hVar) {
        this.M = 1;
        this.M = q.c(context);
        this.f1799j = viewGroup;
        this.a = new WeakReference<>(context);
        this.b = hVar;
        a(context);
        this.D = ab.d(hVar.M());
        this.t = Build.VERSION.SDK_INT >= 17;
    }

    private void C() {
        int v;
        int a = a();
        if (a != 2 && a != 1) {
            v = a == 3 ? o.h().f(String.valueOf(this.D)) : 5;
        } else {
            v = o.h().v() * 1000;
        }
        this.f1800k.removeCallbacks(this.H);
        this.f1800k.postDelayed(this.H, v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        E();
        this.f1800k.postDelayed(this.I, 800L);
    }

    private void E() {
        this.f1800k.removeCallbacks(this.I);
    }

    private boolean F() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void G() {
        ArrayList<Runnable> arrayList = this.r;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.r).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.r.clear();
    }

    private void H() {
        h hVar = this.b;
        if (hVar != null) {
            o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.F(), true, this.b));
        }
    }

    private boolean I() throws Throwable {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar;
        h hVar;
        WeakReference<Context> weakReference = this.a;
        return weakReference == null || weakReference.get() == null || L() == null || (dVar = this.n) == null || dVar.a() == null || (hVar = this.b) == null || hVar.u() != null || this.b.i() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0125 A[Catch: all -> 0x0191, TryCatch #0 {all -> 0x0191, blocks: (B:3:0x0004, B:6:0x0025, B:10:0x0047, B:14:0x005d, B:20:0x0079, B:26:0x00f4, B:33:0x0108, B:35:0x0125, B:37:0x0145, B:39:0x0157, B:41:0x015f, B:45:0x017a, B:47:0x0182, B:42:0x0169, B:44:0x0171, B:48:0x018b, B:31:0x0102, B:18:0x006d), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0157 A[Catch: all -> 0x0191, TryCatch #0 {all -> 0x0191, blocks: (B:3:0x0004, B:6:0x0025, B:10:0x0047, B:14:0x005d, B:20:0x0079, B:26:0x00f4, B:33:0x0108, B:35:0x0125, B:37:0x0145, B:39:0x0157, B:41:0x015f, B:45:0x017a, B:47:0x0182, B:42:0x0169, B:44:0x0171, B:48:0x018b, B:31:0x0102, B:18:0x006d), top: B:53:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void J() {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.d.a.J():void");
    }

    private void K() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar;
        h hVar;
        int[] b;
        try {
            WeakReference<Context> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null && L() != null && (dVar = this.n) != null && dVar.a() != null && (hVar = this.b) != null) {
                boolean z = hVar.N() == 15;
                float f2 = ac.b(o.a())[1];
                MediaPlayer a = this.n.a();
                a(b[0], f2, a.getVideoWidth(), a.getVideoHeight(), z);
                com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "changeSize=end");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("changeVideoSize", "changeSize error", th);
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b L() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar;
        WeakReference<Context> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null || (hVar = this.f1798i) == null) {
            return null;
        }
        return hVar.o();
    }

    private void M() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.c(0);
            this.f1798i.a(false, false);
            this.f1798i.b(false);
            this.f1798i.b();
            this.f1798i.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> A() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.f1793d;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> a = ab.a(this.f1795f, this.b, t());
        if (a != null) {
            for (Map.Entry<String, Object> entry2 : a.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> B() {
        HashMap hashMap = new HashMap();
        Map<String, Object> a = ab.a(this.b, n(), t());
        if (a != null) {
            for (Map.Entry<String, Object> entry : a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> map = this.f1793d;
        if (map != null) {
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    protected abstract int a();

    protected abstract void a(int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0056c interfaceC0056c) {
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
    }

    protected abstract void f();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.e();
            this.f1798i.q();
            this.f1798i.u();
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.a(false, this.p, !this.x);
            D();
        }
        if (this.v || !this.u) {
            return;
        }
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.c();
            this.n = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.g();
        }
        ad adVar = this.f1800k;
        if (adVar != null) {
            adVar.removeCallbacks(this.H);
            this.f1800k.removeCallbacks(this.G);
            this.f1800k.removeCallbacksAndMessages(null);
            E();
        }
        this.o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long m() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        if (t() == null) {
            return 0L;
        }
        return t().n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return 0L;
        }
        return dVar.o() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return 0L;
        }
        return dVar.p() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int q() {
        return com.bytedance.sdk.openadsdk.core.video.f.a.a(this.q, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean s() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.e.d t() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.h u() {
        return this.f1798i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean v() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.E;
    }

    public void x() {
        if (this.v || !this.u) {
            return;
        }
        d();
    }

    public boolean y() {
        return this.n.l();
    }

    public boolean z() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        return dVar != null && dVar.g();
    }

    private void g(boolean z) {
        this.J = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.w = z;
        this.f1798i.c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j2) {
        this.c = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.B = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        a(bVar, view, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.F = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        this.f1797h = o();
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.b();
        }
        if (this.v || !this.u) {
            return;
        }
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.x = z;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void d(long j2) {
        this.p = j2;
        long j3 = this.q;
        if (j3 > j2) {
            j2 = j3;
        }
        this.q = j2;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.a(true, this.p, !this.x);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.b();
            this.f1798i.e();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.f1798i;
        if (hVar2 != null) {
            hVar2.u();
        }
        d(-1L);
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.m();
        }
    }

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = new com.bytedance.sdk.openadsdk.core.video.nativevideo.h(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.b, this);
        this.f1798i = hVar;
        hVar.a(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j2) {
        this.y = j2;
    }

    private void b(int i2) {
        if (F() && this.f1798i != null) {
            this.f1800k.removeCallbacks(this.H);
            this.f1798i.w();
            long currentTimeMillis = System.currentTimeMillis() - this.f1801l;
            this.m = currentTimeMillis;
            c.a aVar = this.o;
            if (aVar != null) {
                aVar.a(currentTimeMillis, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.p, this.c));
            }
            if (ab.b(this.b)) {
                this.f1798i.a(this.b, this.a, true);
            }
            if (!this.v) {
                b();
                this.v = true;
                long j2 = this.c;
                a(j2, j2);
                long j3 = this.c;
                this.p = j3;
                this.q = j3;
            }
            this.B = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    private boolean c(int i2) {
        return this.f1798i.b(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.J) {
            g(false);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
            if (hVar != null) {
                hVar.b(this.f1799j);
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i2, int i3, List<String> list, String str3, long j2, boolean z) {
        com.bytedance.sdk.openadsdk.utils.o.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.o.e("BaseVideoController", "No video info");
            return false;
        }
        this.f1796g = !str.startsWith("http");
        this.x = z;
        if (j2 > 0) {
            this.p = j2;
            long j3 = this.q;
            if (j3 > j2) {
                j2 = j3;
            }
            this.q = j2;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.e();
            this.f1798i.d();
            this.f1798i.c(i2, i3);
            this.f1798i.c(this.f1799j);
        }
        if (this.n == null) {
            this.n = new com.bytedance.sdk.openadsdk.core.video.e.d(this.f1800k);
        }
        this.m = 0L;
        try {
            a(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean d(int i2) {
        h hVar;
        int c = q.c(o.a());
        if (c != 4 && c != 0) {
            h();
            this.z = true;
            this.A = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.f1798i;
            if (hVar2 != null && (hVar = this.b) != null) {
                return hVar2.a(i2, hVar.v());
            }
        } else if (c == 4) {
            this.z = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.f1798i;
            if (hVar3 != null) {
                hVar3.q();
            }
        }
        return true;
    }

    private void b(Runnable runnable) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(runnable);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2) {
        if (this.n != null) {
            E();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        b(bVar, view, false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j2) {
        this.p = j2;
        long j3 = this.q;
        if (j3 > j2) {
            j2 = j3;
        }
        this.q = j2;
    }

    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (F()) {
            g(!this.J);
            if (!(this.a.get() instanceof Activity)) {
                com.bytedance.sdk.openadsdk.utils.o.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.J) {
                a(z ? 8 : 0);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
                if (hVar != null) {
                    hVar.a(this.f1799j);
                    this.f1798i.b(false);
                }
            } else {
                a(1);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.f1798i;
                if (hVar2 != null) {
                    hVar2.b(this.f1799j);
                    this.f1798i.b(false);
                }
            }
            WeakReference<com.bytedance.sdk.openadsdk.core.video.nativevideo.e> weakReference = this.C;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.J);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.f1793d = map;
    }

    private void a(String str) throws Exception {
        if (this.n != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.a = str;
            h hVar = this.b;
            if (hVar != null) {
                if (hVar.v() != null) {
                    aVar.f1784d = this.b.v().k();
                }
                aVar.b = String.valueOf(ab.d(this.b.M()));
            }
            aVar.c = 1;
            this.n.a(aVar);
        }
        this.f1801l = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f1798i.d(8);
        this.f1798i.d(0);
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f1801l = System.currentTimeMillis();
                a.this.f1798i.c(0);
                if (a.this.n == null || a.this.p != 0) {
                    if (a.this.n != null) {
                        a.this.n.a(true, a.this.p, !a.this.x);
                    }
                } else {
                    a.this.n.a(true, 0L, !a.this.x);
                }
                if (a.this.f1800k != null) {
                    a.this.f1800k.postDelayed(a.this.G, 100L);
                }
                a.this.D();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.s = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        int c;
        if (F() && this.M != (c = q.c(context))) {
            if (!this.A) {
                d(2);
            }
            this.M = c;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar) {
        this.C = new WeakReference<>(eVar);
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.f1798i.k() && this.s) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.o = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        if (this.f1798i == null || message == null || (weakReference = this.a) == null || weakReference.get() == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.c = ((Long) message.obj).longValue();
        } else if (i2 == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.p = longValue;
                long j2 = this.q;
                if (j2 <= longValue) {
                    j2 = longValue;
                }
                this.q = j2;
                a(longValue, this.c);
            }
        } else if (i2 == 308) {
            a(308, 0);
        } else if (i2 == 311) {
            h hVar = this.b;
            if (hVar != null && hVar.g() == 0) {
                K();
            } else {
                J();
            }
        } else if (i2 != 314) {
            switch (i2) {
                case 302:
                    b(i2);
                    return;
                case 303:
                    a(message.arg1, message.arg2);
                    this.f1800k.removeCallbacks(this.H);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.f1798i;
                    if (hVar2 != null) {
                        hVar2.w();
                    }
                    c.a aVar = this.o;
                    if (aVar != null) {
                        aVar.b(this.m, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.p, this.c));
                        return;
                    }
                    return;
                case 304:
                    int i3 = message.arg1;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.f1798i;
                    if (hVar3 != null) {
                        if (i3 == 3 || i3 == 702) {
                            hVar3.w();
                            this.f1800k.removeCallbacks(this.H);
                            this.E = false;
                        } else if (i3 == 701) {
                            hVar3.t();
                            C();
                            this.E = true;
                        }
                    }
                    if (this.t && i3 == 3 && !this.u) {
                        this.f1795f = SystemClock.elapsedRealtime() - this.f1794e;
                        c.a aVar2 = this.o;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                        e();
                        H();
                        this.u = true;
                        return;
                    }
                    return;
                case 305:
                    ad adVar = this.f1800k;
                    if (adVar != null) {
                        adVar.removeCallbacks(this.H);
                    }
                    if (!this.t && !this.u) {
                        this.f1795f = SystemClock.elapsedRealtime() - this.f1794e;
                        f();
                        this.u = true;
                    }
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar4 = this.f1798i;
                    if (hVar4 != null) {
                        hVar4.w();
                        return;
                    }
                    return;
                case 306:
                    this.f1800k.removeCallbacks(this.H);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar5 = this.f1798i;
                    if (hVar5 != null) {
                        hVar5.w();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.f1794e = SystemClock.elapsedRealtime();
        }
    }

    private void a(float f2, float f3, float f4, float f5, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "screenWidth=" + f2 + ",screenHeight=" + f3);
            com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "videoHeight=" + f5 + ",videoWidth=" + f4);
            if (f4 <= 0.0f || f5 <= 0.0f) {
                f4 = this.b.v().c();
                f5 = this.b.v().b();
            }
            if (f5 > 0.0f && f4 > 0.0f) {
                if (z) {
                    if (f4 < f5) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                    layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) ((f5 * f2) / f4));
                    layoutParams.addRule(13);
                } else if (f4 > f5) {
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) ((f4 * f3) / f5), (int) f3);
                    layoutParams2.addRule(13);
                    layoutParams = layoutParams2;
                }
                if (L() != null) {
                    if (L() instanceof TextureView) {
                        ((TextureView) L()).setLayoutParams(layoutParams);
                    } else if (L() instanceof SurfaceView) {
                        ((SurfaceView) L()).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.n == null || !F()) {
            return;
        }
        if (this.n.g()) {
            h();
            this.f1798i.b(true, false);
            this.f1798i.c();
        } else if (!this.n.i()) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
            if (hVar != null) {
                hVar.c(this.f1799j);
            }
            d(this.p);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.f1798i;
            if (hVar2 != null) {
                hVar2.b(false, false);
            }
        } else {
            j();
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.f1798i;
            if (hVar3 != null) {
                hVar3.b(false, false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2) {
        if (this.n == null) {
            return;
        }
        D();
        a(this.K, c(i2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2, boolean z) {
        if (F()) {
            long l2 = (((float) (i2 * this.c)) * 1.0f) / t.l(this.a.get(), "tt_video_progress_max");
            if (this.c > 0) {
                this.K = (int) l2;
            } else {
                this.K = 0L;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.f1798i;
            if (hVar != null) {
                hVar.a(this.K);
            }
        }
    }

    private void a(long j2, long j3) {
        this.p = j2;
        this.c = j3;
        this.f1798i.a(j2, j3);
        this.f1798i.a(com.bytedance.sdk.openadsdk.core.video.f.a.a(j2, j3));
        try {
            c.a aVar = this.o;
            if (aVar != null) {
                aVar.a(j2, j3);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.c("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    public void a(int i2) {
        if (F()) {
            boolean z = i2 == 0 || i2 == 8;
            Context context = this.a.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (this.w) {
            h();
        }
        if (z && !this.w && !y()) {
            this.f1798i.b(!z(), false);
            this.f1798i.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null && dVar.g()) {
            this.f1798i.c();
            this.f1798i.b();
            return;
        }
        this.f1798i.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.s = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceHolder);
        G();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.s = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceTexture);
        G();
    }

    private void a(long j2, boolean z) {
        if (this.n == null) {
            return;
        }
        if (z) {
            M();
        }
        this.n.a(j2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(e.a aVar, String str) {
        int i2 = AnonymousClass6.a[aVar.ordinal()];
        if (i2 == 1) {
            h();
        } else if (i2 == 2) {
            a(true);
        } else if (i2 != 3) {
        } else {
            j();
            this.z = false;
            this.A = true;
        }
    }
}
