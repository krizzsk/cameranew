package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.tencent.bugly.BuglyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: TTBannerExpressAdImpl.java */
/* loaded from: classes.dex */
public class b extends l implements ad.a {
    TTDislikeDialogAbstract a;
    private a b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private h f1526d;

    /* renamed from: f  reason: collision with root package name */
    private AdSlot f1527f;

    /* renamed from: g  reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f1528g;

    /* renamed from: h  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f1529h;

    /* renamed from: i  reason: collision with root package name */
    private d.a.a.a.a.a.b f1530i;

    /* renamed from: j  reason: collision with root package name */
    private ad f1531j;

    /* renamed from: k  reason: collision with root package name */
    private int f1532k;

    /* renamed from: l  reason: collision with root package name */
    private TTAdDislike.DislikeInteractionCallback f1533l;
    private Context m;
    private String n = "banner_ad";

    public b(Context context, h hVar, AdSlot adSlot) {
        this.c = context;
        this.f1526d = hVar;
        this.f1527f = adSlot;
        a aVar = new a(context, hVar, adSlot);
        this.b = aVar;
        b(aVar.c(), this.f1526d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        h hVar = this.f1526d;
        if (hVar == null) {
            return null;
        }
        return hVar.O();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        h hVar = this.f1526d;
        if (hVar == null) {
            return -1;
        }
        return hVar.N();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        h hVar = this.f1526d;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f1526d;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.b.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.f1533l = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            o.b("dialog is null, please check");
            return;
        }
        this.a = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f1526d);
        a aVar = this.b;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.b.c().setOuterDislike(tTDislikeDialogAbstract);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f1528g = expressAdInteractionListener;
        this.b.a(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.n = "slide_banner_ad";
        b(this.b.c(), this.f1526d);
        this.b.a(1000);
        if (i2 < 30000) {
            i2 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.f1532k = i2;
        this.f1531j = new ad(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ad adVar = this.f1531j;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
        }
    }

    private void c() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.c).a(this.f1527f, 1, null, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a(List<h> list) {
                h hVar = list == null ? null : list.get(0);
                b.this.b.a(hVar, b.this.f1527f);
                b.this.b(hVar);
                b.this.b.e();
                b.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a() {
                b.this.a();
            }
        }, 5000);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f1529h == null) {
            this.f1529h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f1526d);
        }
        this.m = activity;
        this.f1529h.setDislikeInteractionCallback(dislikeInteractionCallback);
        a aVar = this.b;
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.b.c().setDislike(this.f1529h);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f1528g = adInteractionListener;
        this.b.a(adInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull h hVar) {
        if (this.b.d() == null || !this.b.f()) {
            return;
        }
        a(this.b.d(), hVar);
        b(this.b.d(), hVar);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b(@NonNull final NativeExpressView nativeExpressView, @NonNull final h hVar) {
        if (nativeExpressView == null || hVar == null) {
            return;
        }
        this.f1526d = hVar;
        this.f1530i = a(hVar);
        nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                nativeExpressView2.l();
                BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                bannerExpressBackupView.a(b.this.f1526d, nativeExpressView2, b.this.f1530i);
                bannerExpressBackupView.setDislikeInner(b.this.f1529h);
                bannerExpressBackupView.setDislikeOuter(b.this.a);
                return true;
            }
        });
        d.a(hVar);
        EmptyView a = a(nativeExpressView);
        if (a == null) {
            a = new EmptyView(this.c, nativeExpressView);
            nativeExpressView.addView(a);
        }
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (z) {
                    b.this.a();
                    o.b("TTBannerExpressAd", "获得焦点，开始计时");
                    return;
                }
                o.b("TTBannerExpressAd", "失去焦点，停止计时");
                b.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                o.b("TTBannerExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(nativeExpressView.m() ? 1 : 0));
                d.a(b.this.c, hVar, b.this.n, hashMap);
                if (b.this.f1528g != null) {
                    b.this.f1528g.onAdShow(view, hVar.x());
                }
                if (hVar.R()) {
                    ab.a(hVar, view);
                }
                b.this.a();
                if (!b.this.f1730e.getAndSet(true) && b.this.b != null && b.this.b.c() != null) {
                    ac.a(b.this.c, b.this.f1526d, b.this.n, b.this.b.c().getWebView());
                }
                if (b.this.b == null || b.this.b.c() == null) {
                    return;
                }
                b.this.b.c().i();
                b.this.b.c().g();
            }
        });
        e eVar = new e(this.c, hVar, this.n, 2);
        eVar.a(nativeExpressView);
        eVar.a(this.f1530i);
        nativeExpressView.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.c, hVar, this.n, 2);
        dVar.a(nativeExpressView);
        dVar.a(this.f1530i);
        nativeExpressView.setClickCreativeListener(dVar);
        a.setNeedCheckingShow(true);
    }

    private d.a.a.a.a.a.b a(h hVar) {
        if (hVar.x() == 4) {
            return d.a.a.a.a.a.c.a(this.c, hVar, this.n);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ad adVar = this.f1531j;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
            this.f1531j.sendEmptyMessageDelayed(112201, this.f1532k);
        }
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull h hVar) {
        if (nativeExpressView == null || hVar == null) {
            return;
        }
        if (this.f1533l != null) {
            this.f1529h.a(hVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f1529h);
            }
        }
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.a;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(hVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.a);
            }
        }
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

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what == 112201) {
            c();
        }
    }
}
