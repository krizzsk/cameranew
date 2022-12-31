package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: TTNativeExpressAdImpl.java */
/* loaded from: classes.dex */
public class k extends l {
    protected NativeExpressView a;
    protected final Context b;
    protected com.bytedance.sdk.openadsdk.core.d.h c;

    /* renamed from: d  reason: collision with root package name */
    protected String f1724d = "embeded_ad";

    /* renamed from: f  reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f1725f;

    /* renamed from: g  reason: collision with root package name */
    private TTAdDislike.DislikeInteractionCallback f1726g;

    /* renamed from: h  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f1727h;

    /* renamed from: i  reason: collision with root package name */
    private TTDislikeDialogAbstract f1728i;

    /* renamed from: j  reason: collision with root package name */
    private d.a.a.a.a.a.b f1729j;

    public k(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.b = context;
        this.c = hVar;
        a(context, hVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.c;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.c;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.c;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.c;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.f1726g = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            o.b("dialog is null, please check");
            return;
        }
        this.f1728i = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f1725f = expressAdInteractionListener;
        this.a.setExpressInteractionListener(expressAdInteractionListener);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, hVar, adSlot, this.f1724d);
        this.a = nativeExpressView;
        a(nativeExpressView, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f1725f = adInteractionListener;
        this.a.setExpressInteractionListener(adInteractionListener);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f1727h == null) {
            this.f1727h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.c);
        }
        this.f1727h.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f1727h);
        }
    }

    private d.a.a.a.a.a.b a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar.x() == 4) {
            return d.a.a.a.a.a.c.a(this.b, hVar, this.f1724d);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.c = hVar;
        nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                nativeExpressView2.l();
                h hVar2 = new h(nativeExpressView2.getContext());
                k kVar = k.this;
                hVar2.a(kVar.c, nativeExpressView2, kVar.f1729j);
                hVar2.setDislikeInner(k.this.f1727h);
                hVar2.setDislikeOuter(k.this.f1728i);
                return true;
            }
        });
        this.f1729j = a(hVar);
        com.bytedance.sdk.openadsdk.c.d.a(hVar);
        EmptyView a = a(nativeExpressView);
        if (a == null) {
            a = new EmptyView(this.b, nativeExpressView);
            nativeExpressView.addView(a);
        }
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                k kVar;
                NativeExpressView nativeExpressView2;
                o.b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(k.this.a.m() ? 1 : 0));
                k kVar2 = k.this;
                com.bytedance.sdk.openadsdk.c.d.a(kVar2.b, hVar, kVar2.f1724d, hashMap);
                if (k.this.f1725f != null) {
                    k.this.f1725f.onAdShow(view, hVar.x());
                }
                if (hVar.R()) {
                    ab.a(hVar, view);
                }
                if (!k.this.f1730e.getAndSet(true) && (nativeExpressView2 = (kVar = k.this).a) != null) {
                    ac.a(kVar.b, kVar.c, kVar.f1724d, nativeExpressView2.getWebView());
                }
                NativeExpressView nativeExpressView3 = k.this.a;
                if (nativeExpressView3 != null) {
                    nativeExpressView3.i();
                    k.this.a.g();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }
        });
        Context context = this.b;
        String str = this.f1724d;
        e eVar = new e(context, hVar, str, ab.a(str));
        eVar.a(nativeExpressView);
        eVar.a(this.f1729j);
        eVar.a(this);
        this.a.setClickListener(eVar);
        Context context2 = this.b;
        String str2 = this.f1724d;
        d dVar = new d(context2, hVar, str2, ab.a(str2));
        dVar.a(nativeExpressView);
        dVar.a(this.f1729j);
        dVar.a(this);
        this.a.setClickCreativeListener(dVar);
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
}
