package com.bytedance.sdk.openadsdk.core.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.growingio.android.sdk.autoburry.VdsAgent;
import d.a.a.a.a.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: TTInteractionExpressAdImpl.java */
/* loaded from: classes.dex */
public class b extends l {
    a a;
    private NativeExpressView b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private h f1539d;

    /* renamed from: f  reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f1540f;

    /* renamed from: g  reason: collision with root package name */
    private TTNativeExpressAd.AdInteractionListener f1541g;

    /* renamed from: h  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f1542h;

    /* renamed from: i  reason: collision with root package name */
    private d.a.a.a.a.a.b f1543i;

    /* renamed from: j  reason: collision with root package name */
    private Dialog f1544j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f1545k;

    /* renamed from: l  reason: collision with root package name */
    private String f1546l = "interaction";

    public b(Context context, h hVar, AdSlot adSlot) {
        this.c = context;
        this.f1539d = hVar;
        NativeExpressView nativeExpressView = new NativeExpressView(context, hVar, adSlot, this.f1546l);
        this.b = nativeExpressView;
        a(nativeExpressView, this.f1539d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        h hVar = this.f1539d;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        h hVar = this.f1539d;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        h hVar = this.f1539d;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f1539d;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.b.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            o.b("dialog is null, please check");
            return;
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.f1539d);
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f1540f = expressAdInteractionListener;
        this.b.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(@NonNull Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            o.b("can't invoke in child thread TTInteractionExpressAd.showInteractionAd");
        } else {
            a(activity);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f1542h == null) {
            this.f1542h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f1539d);
        }
        this.f1542h.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f1542h);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f1541g = adInteractionListener;
        this.f1540f = adInteractionListener;
        this.b.setExpressInteractionListener(adInteractionListener);
    }

    private d.a.a.a.a.a.b a(h hVar) {
        if (hVar.x() == 4) {
            return c.a(this.c, hVar, this.f1546l);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull final h hVar) {
        this.f1539d = hVar;
        this.b.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.c.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                b.this.b.l();
                b.this.a = new a(nativeExpressView2.getContext());
                b bVar = b.this;
                bVar.a.a(bVar.f1539d, b.this.b, b.this.f1543i);
                return true;
            }
        });
        this.f1543i = a(hVar);
        d.a(hVar);
        EmptyView a = a(nativeExpressView);
        if (a == null) {
            a = new EmptyView(this.c, nativeExpressView);
            nativeExpressView.addView(a);
        }
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                o.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                o.b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(b.this.b.m() ? 1 : 0));
                d.a(b.this.c, hVar, b.this.f1546l, hashMap);
                if (b.this.f1540f != null) {
                    b.this.f1540f.onAdShow(view, hVar.x());
                }
                if (hVar.R()) {
                    ab.a(hVar, view);
                }
                if (!b.this.f1730e.getAndSet(true) && b.this.b != null) {
                    ac.a(b.this.c, b.this.f1539d, b.this.f1546l, b.this.b.getWebView());
                }
                if (b.this.b != null) {
                    b.this.b.i();
                    b.this.b.g();
                }
            }
        });
        e eVar = new e(this.c, hVar, this.f1546l, 3);
        eVar.a(nativeExpressView);
        eVar.a(this.f1543i);
        this.b.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.c, hVar, this.f1546l, 3);
        dVar.a(nativeExpressView);
        dVar.a(this.f1543i);
        dVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.3
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i2) {
                if (i2 == 2 || i2 == 3 || i2 == 5) {
                    b.this.a();
                }
            }
        });
        this.b.setClickCreativeListener(dVar);
        a.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    private void a(Activity activity) {
        if (this.f1544j == null) {
            m mVar = new m(activity);
            this.f1544j = mVar;
            mVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.c.b.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            ((m) this.f1544j).a(true, new m.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.5
                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.f1545k = frameLayout;
                    b.this.f1545k.addView(b.this.b, new FrameLayout.LayoutParams(-1, -1));
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(View view) {
                    b.this.a();
                    d.a(b.this.c, b.this.f1539d, "interaction");
                    if (b.this.f1541g != null) {
                        b.this.f1541g.onAdDismiss();
                    }
                    o.b("TTInteractionExpressAd", "dislike事件发出");
                }
            });
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this.f1544j);
        }
        if (this.f1544j.isShowing()) {
            return;
        }
        Dialog dialog = this.f1544j;
        dialog.show();
        VdsAgent.showDialog(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Dialog dialog = this.f1544j;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
