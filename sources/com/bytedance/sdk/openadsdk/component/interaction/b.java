package com.bytedance.sdk.openadsdk.component.interaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import com.growingio.android.sdk.autoburry.VdsAgent;
import d.a.a.a.a.a.c;
import java.util.Map;
/* compiled from: TTInteractionAdImpl.java */
/* loaded from: classes.dex */
class b implements TTInteractionAd {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f1442i;
    private final Context a;
    private final h b;
    private Dialog c;

    /* renamed from: d  reason: collision with root package name */
    private TTInteractionAd.AdInteractionListener f1443d;

    /* renamed from: e  reason: collision with root package name */
    private d.a.a.a.a.a.b f1444e;

    /* renamed from: f  reason: collision with root package name */
    private k f1445f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f1446g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f1447h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, h hVar) {
        this.a = context;
        this.b = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        h hVar = this.b;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.b;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        this.f1443d = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    @MainThread
    public void showInteractionAd(Activity activity) {
        if (activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f1442i) {
                return;
            }
            f1442i = true;
            Dialog dialog = this.c;
            dialog.show();
            VdsAgent.showDialog(dialog);
            return;
        }
        throw new IllegalStateException("can't not running in child thread >>> TTInteractionAd.showInteractionAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int b = this.b.B().get(0).b();
        d.a(this.a).g().a(this.b.B().get(0).a(), new d.InterfaceC0041d() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.5
            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
            public void a(d.c cVar, boolean z) {
                if (cVar == null || cVar.a() == null) {
                    if (b.this.f1445f != null) {
                        b.this.f1445f.b();
                        return;
                    }
                    return;
                }
                b.this.f1447h.setImageBitmap(cVar.a());
                if (b.this.f1445f != null) {
                    b.this.f1445f.a();
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                if (b.this.f1445f != null) {
                    b.this.f1445f.b();
                }
            }
        }, b, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        f1442i = false;
        this.c.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.a, this.b, "interaction", 3);
        aVar.a(this.f1447h);
        aVar.b(this.f1446g);
        aVar.a(this.f1444e);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i2) {
                if (b.this.f1443d != null) {
                    b.this.f1443d.onAdClicked();
                }
                if (i2 == 2 || i2 == 3 || i2 == 5) {
                    b.this.d();
                    if (b.this.f1443d != null) {
                        b.this.f1443d.onAdDismiss();
                    }
                }
            }
        });
        this.f1447h.setOnClickListener(aVar);
        this.f1447h.setOnTouchListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull k kVar) {
        this.f1445f = kVar;
        com.bytedance.sdk.openadsdk.c.d.a(this.b);
        if (getInteractionType() == 4) {
            this.f1444e = c.a(this.a, this.b, "interaction");
        }
        a();
    }

    private void a() {
        if (this.c == null) {
            com.bytedance.sdk.openadsdk.core.m mVar = new com.bytedance.sdk.openadsdk.core.m(this.a);
            this.c = mVar;
            mVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (b.this.c.isShowing()) {
                        com.bytedance.sdk.openadsdk.c.d.a(b.this.a, b.this.b, "interaction", (Map<String, Object>) null);
                        if (b.this.f1443d != null) {
                            b.this.f1443d.onAdShow();
                        }
                        if (b.this.b.R()) {
                            ab.a(b.this.b, b.this.f1447h);
                        }
                    }
                }
            });
            this.c.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            ((com.bytedance.sdk.openadsdk.core.m) this.c).a(false, new m.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.3
                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.f1447h = imageView;
                    b.this.f1446g = imageView2;
                    b.this.b();
                    b.this.c();
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(View view) {
                    b.this.d();
                    com.bytedance.sdk.openadsdk.c.d.a(b.this.a, b.this.b, "interaction");
                    if (b.this.f1443d != null) {
                        b.this.f1443d.onAdDismiss();
                    }
                    o.b("TTInteractionAdImpl", "dislike事件发出");
                }
            });
        }
    }
}
