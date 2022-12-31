package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.io;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class gv extends hg {

    /* renamed from: h  reason: collision with root package name */
    private static final String f7584h = "gv";

    /* renamed from: i  reason: collision with root package name */
    private static gv f7585i;
    final String a;
    final hr b;

    /* renamed from: j  reason: collision with root package name */
    private final gz f7586j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7587k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7588l;
    private long m;
    private Context n;
    private io o;
    private Activity p;
    private ha q;
    private Handler r;
    private Runnable s;

    public gv(gz gzVar, String str, hr hrVar, Context context) {
        this.f7586j = gzVar;
        this.a = str;
        this.b = hrVar;
        this.n = context;
    }

    public static void a() {
        gv gvVar = f7585i;
        if (gvVar != null) {
            Runnable runnable = new Runnable() { // from class: com.tapjoy.internal.gv.1
                @Override // java.lang.Runnable
                public final void run() {
                    gv.a(gv.this);
                }
            };
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null && mainLooper.getThread() == Thread.currentThread()) {
                runnable.run();
            } else {
                u.a().post(runnable);
            }
        }
    }

    @Override // com.tapjoy.internal.hg
    public final boolean c() {
        hx hxVar;
        Iterator it = this.b.a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Iterator it2 = ((ia) it.next()).c.iterator();
            while (it2.hasNext()) {
                hz hzVar = (hz) it2.next();
                hx hxVar2 = hzVar.f7665l;
                if ((hxVar2 != null && !hxVar2.a()) || ((hxVar = hzVar.m) != null && !hxVar.a())) {
                    z = false;
                    continue;
                    break;
                }
            }
            z = true;
            continue;
            if (!z) {
                return false;
            }
        }
        return z;
    }

    @Override // com.tapjoy.internal.hg
    public final void b() {
        Iterator it = this.b.a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ia) it.next()).c.iterator();
            while (it2.hasNext()) {
                hz hzVar = (hz) it2.next();
                hx hxVar = hzVar.f7665l;
                if (hxVar != null) {
                    hxVar.b();
                }
                hx hxVar2 = hzVar.m;
                if (hxVar2 != null) {
                    hxVar2.b();
                }
            }
        }
    }

    @Override // com.tapjoy.internal.hg
    public final void a(ha haVar, fw fwVar) {
        this.q = haVar;
        Activity a = gr.a();
        this.p = a;
        if (a != null && !a.isFinishing()) {
            try {
                a(this.p, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a2 = a.a(this.n);
        this.p = a2;
        if (a2 != null && !a2.isFinishing()) {
            try {
                a(this.p, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused2) {
            }
        }
        gw.b("Failed to show the content for \"{}\". No usable activity found.", this.a);
        haVar.a(this.a, this.f7614f, null);
    }

    private void a(final Activity activity, final ha haVar, fw fwVar) {
        if (this.f7587k) {
            TapjoyLog.e(f7584h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.f7587k = true;
        this.f7588l = true;
        f7585i = this;
        this.f7615g = fwVar.a;
        this.o = new io(activity, this.b, new io.a() { // from class: com.tapjoy.internal.gv.2
            @Override // com.tapjoy.internal.io.a
            public final void a(hz hzVar) {
                fv fvVar;
                fm fmVar;
                fq fqVar = gv.this.f7615g;
                if ((fqVar instanceof fv) && (fvVar = (fv) fqVar) != null && (fmVar = fvVar.c) != null) {
                    fmVar.a();
                }
                gv.this.f7586j.a(gv.this.b.b, hzVar.f7664k);
                if (!jq.c(hzVar.f7661h)) {
                    gv.this.f7613e.a(activity, hzVar.f7661h, jq.b(hzVar.f7662i));
                    gv.this.f7612d = true;
                } else if (!jq.c(hzVar.f7660g)) {
                    hg.a(activity, hzVar.f7660g);
                }
                haVar.a(gv.this.a, null);
                if (hzVar.f7663j) {
                    gv.a(gv.this);
                }
            }

            @Override // com.tapjoy.internal.io.a
            public final void a() {
                gv.a(gv.this);
            }
        });
        Window window = activity.getWindow();
        io ioVar = this.o;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Window.Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView(ioVar, layoutParams);
        window.setCallback(callback);
        this.m = SystemClock.elapsedRealtime();
        this.f7586j.a(this.b.b);
        fwVar.a();
        fq fqVar = this.f7615g;
        if (fqVar != null) {
            fqVar.b();
        }
        haVar.c(this.a);
        if (this.b.c > 0.0f) {
            this.r = new Handler(Looper.getMainLooper());
            Runnable runnable = new Runnable() { // from class: com.tapjoy.internal.gv.3
                @Override // java.lang.Runnable
                public final void run() {
                    gv.a(gv.this);
                }
            };
            this.s = runnable;
            this.r.postDelayed(runnable, this.b.c * 1000.0f);
        }
    }

    static /* synthetic */ void a(gv gvVar) {
        ha haVar;
        if (gvVar.f7588l) {
            gvVar.f7588l = false;
            Handler handler = gvVar.r;
            if (handler != null) {
                handler.removeCallbacks(gvVar.s);
                gvVar.s = null;
                gvVar.r = null;
            }
            if (f7585i == gvVar) {
                f7585i = null;
            }
            gvVar.f7586j.a(gvVar.b.b, SystemClock.elapsedRealtime() - gvVar.m);
            if (!gvVar.f7612d && (haVar = gvVar.q) != null) {
                haVar.a(gvVar.a, gvVar.f7614f, null);
                gvVar.q = null;
            }
            ViewGroup viewGroup = (ViewGroup) gvVar.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(gvVar.o);
            }
            gvVar.o = null;
            Activity activity = gvVar.p;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            gvVar.p = null;
        }
    }
}
