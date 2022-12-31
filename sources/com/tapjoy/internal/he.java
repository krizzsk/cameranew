package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.iq;
import java.util.Map;
/* loaded from: classes3.dex */
public class he extends hg {

    /* renamed from: h  reason: collision with root package name */
    private static final String f7607h = "he";

    /* renamed from: i  reason: collision with root package name */
    private static he f7608i;
    final String a;
    final hu b;

    /* renamed from: j  reason: collision with root package name */
    private final gz f7609j;

    /* renamed from: k  reason: collision with root package name */
    private c f7610k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7611l;
    private long m;
    private Context n;
    private boolean o = false;

    public he(gz gzVar, String str, hu huVar, Context context) {
        this.f7609j = gzVar;
        this.a = str;
        this.b = huVar;
        this.n = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c cVar = this.f7610k;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // com.tapjoy.internal.hg
    public final void b() {
        hx hxVar;
        hu huVar = this.b;
        hx hxVar2 = huVar.a;
        if (hxVar2 != null) {
            hxVar2.b();
        }
        hx hxVar3 = huVar.b;
        if (hxVar3 != null) {
            hxVar3.b();
        }
        huVar.c.b();
        hx hxVar4 = huVar.f7643e;
        if (hxVar4 != null) {
            hxVar4.b();
        }
        hx hxVar5 = huVar.f7644f;
        if (hxVar5 != null) {
            hxVar5.b();
        }
        hv hvVar = huVar.m;
        if (hvVar == null || (hxVar = hvVar.a) == null) {
            return;
        }
        hxVar.b();
    }

    @Override // com.tapjoy.internal.hg
    public final boolean c() {
        hx hxVar;
        hx hxVar2;
        hx hxVar3;
        hu huVar = this.b;
        hx hxVar4 = huVar.c;
        if (hxVar4 == null || hxVar4.b == null) {
            return false;
        }
        hv hvVar = huVar.m;
        if (hvVar == null || (hxVar3 = hvVar.a) == null || hxVar3.b != null) {
            hx hxVar5 = huVar.b;
            if (hxVar5 == null || (hxVar2 = huVar.f7644f) == null || hxVar5.b == null || hxVar2.b == null) {
                hx hxVar6 = huVar.a;
                return (hxVar6 == null || (hxVar = huVar.f7643e) == null || hxVar6.b == null || hxVar.b == null) ? false : true;
            }
            return true;
        }
        return false;
    }

    public static void a() {
        he heVar = f7608i;
        if (heVar != null) {
            heVar.e();
        }
    }

    @Override // com.tapjoy.internal.hg
    public final void a(final ha haVar, final fw fwVar) {
        Activity a = a.a(this.n);
        if (a != null && !a.isFinishing()) {
            try {
                a(a, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a2 = gr.a();
        try {
            TJContentActivity.start(gz.a().f7594e, new TJContentActivity.AbstractContentProducer() { // from class: com.tapjoy.internal.he.1
                @Override // com.tapjoy.TJContentActivity.AbstractContentProducer, com.tapjoy.TJContentActivity.ContentProducer
                public final void dismiss(Activity activity) {
                    he.this.e();
                }

                @Override // com.tapjoy.TJContentActivity.ContentProducer
                public final void show(Activity activity) {
                    try {
                        he.this.a(activity, haVar, fwVar);
                    } catch (WindowManager.BadTokenException unused2) {
                        gw.b("Failed to show the content for \"{}\" caused by invalid activity", he.this.a);
                        ha haVar2 = haVar;
                        he heVar = he.this;
                        haVar2.a(heVar.a, heVar.f7614f, null);
                    }
                }
            }, (a2 == null || (a2.getWindow().getAttributes().flags & 1024) == 0) ? false : true);
        } catch (ActivityNotFoundException unused2) {
            if (a2 != null && !a2.isFinishing()) {
                try {
                    a(a2, haVar, fwVar);
                    return;
                } catch (WindowManager.BadTokenException unused3) {
                    gw.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.a);
                    haVar.a(this.a, this.f7614f, null);
                }
            }
            gw.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.a);
            haVar.a(this.a, this.f7614f, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final ha haVar, fw fwVar) {
        if (this.f7611l) {
            TapjoyLog.e(f7607h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.f7611l = true;
        f7608i = this;
        this.f7615g = fwVar.a;
        c cVar = new c(activity);
        this.f7610k = cVar;
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tapjoy.internal.he.2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                haVar.d(he.this.a);
            }
        });
        this.f7610k.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tapjoy.internal.he.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                Map map;
                String obj;
                hi hiVar;
                he unused = he.f7608i = null;
                hg.a(activity, he.this.b.f7645g);
                he.this.f7609j.a(he.this.b.f7649k, SystemClock.elapsedRealtime() - he.this.m);
                he heVar = he.this;
                if (!heVar.f7612d) {
                    haVar.a(heVar.a, heVar.f7614f, heVar.b.f7646h);
                }
                if (he.this.o && (map = he.this.b.f7649k) != null && map.containsKey("action_id") && (obj = he.this.b.f7649k.get("action_id").toString()) != null && obj.length() > 0 && (hiVar = he.this.f7609j.b) != null) {
                    String a = hi.a();
                    String a2 = hiVar.b.a();
                    String a3 = hiVar.a.a();
                    if (a3 == null || !a.equals(a3)) {
                        hiVar.a.a(a);
                        a2 = "";
                    }
                    if (!(a2.length() == 0)) {
                        if (a2.contains(obj)) {
                            obj = a2;
                        } else {
                            obj = a2.concat("," + obj);
                        }
                    }
                    hiVar.b.a(obj);
                }
                Activity activity2 = activity;
                if (activity2 instanceof TJContentActivity) {
                    activity2.finish();
                }
            }
        });
        this.f7610k.setCanceledOnTouchOutside(false);
        ip ipVar = new ip(activity, this.b, new iq(activity, this.b, new iq.a() { // from class: com.tapjoy.internal.he.4
            @Override // com.tapjoy.internal.iq.a
            public final void a() {
                he.this.f7610k.cancel();
            }

            @Override // com.tapjoy.internal.iq.a
            public final void b() {
                he heVar = he.this;
                heVar.o = !heVar.o;
            }

            @Override // com.tapjoy.internal.iq.a
            public final void a(hs hsVar) {
                fu fuVar;
                fm fmVar;
                fq fqVar = he.this.f7615g;
                if ((fqVar instanceof fu) && (fuVar = (fu) fqVar) != null && (fmVar = fuVar.c) != null) {
                    fmVar.a();
                }
                he.this.f7609j.a(he.this.b.f7649k, hsVar.b);
                hg.a(activity, hsVar.f7634d);
                if (!jq.c(hsVar.f7635e)) {
                    he.this.f7613e.a(activity, hsVar.f7635e, jq.b(hsVar.f7636f));
                    he.this.f7612d = true;
                }
                haVar.a(he.this.a, hsVar.f7637g);
                if (hsVar.c) {
                    he.this.f7610k.dismiss();
                }
            }
        }));
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.addView(ipVar, new FrameLayout.LayoutParams(-2, -2, 17));
        this.f7610k.setContentView(frameLayout);
        try {
            this.f7610k.show();
            this.f7610k.getWindow().setLayout(-1, -1);
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                this.f7610k.getWindow().setFlags(1024, 1024);
            }
            this.m = SystemClock.elapsedRealtime();
            this.f7609j.a(this.b.f7649k);
            fwVar.a();
            fq fqVar = this.f7615g;
            if (fqVar != null) {
                fqVar.b();
            }
            haVar.c(this.a);
        } catch (WindowManager.BadTokenException e2) {
            throw e2;
        }
    }

    private static Boolean a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                Object obj = bundle.get("tapjoy:hardwareAccelerated");
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                return null;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
