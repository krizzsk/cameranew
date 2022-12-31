package com.bytedance.sdk.openadsdk.component.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.component.banner.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.tencent.bugly.BuglyStrategy;
import java.util.Map;
/* compiled from: TTBannerAdImpl.java */
/* loaded from: classes.dex */
public class e implements TTBannerAd, ad.a {
    private final d a;
    private final a b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private ad f1433d;

    /* renamed from: e  reason: collision with root package name */
    private int f1434e;

    /* renamed from: f  reason: collision with root package name */
    private h f1435f;

    /* renamed from: g  reason: collision with root package name */
    private TTBannerAd.AdInteractionListener f1436g;

    /* renamed from: h  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f1437h;

    /* renamed from: i  reason: collision with root package name */
    private final b f1438i;

    /* renamed from: j  reason: collision with root package name */
    private d.a.a.a.a.a.b f1439j;

    /* renamed from: k  reason: collision with root package name */
    private String f1440k = "banner_ad";

    /* renamed from: l  reason: collision with root package name */
    private AdSlot f1441l;

    public e(Context context, a aVar, AdSlot adSlot) {
        this.c = context;
        this.b = aVar;
        this.f1441l = adSlot;
        this.f1435f = aVar.b();
        d dVar = new d(context);
        this.a = dVar;
        this.f1438i = b.a(context);
        a(dVar.b(), aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return null;
        }
        b(dislikeInteractionCallback);
        return this.f1437h;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        h hVar = this.f1435f;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        h hVar = this.f1435f;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        this.f1436g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return;
        }
        a(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f1440k = "slide_banner_ad";
        a(this.a.b(), this.b);
        this.a.a();
        this.a.a(1000);
        if (i2 < 30000) {
            i2 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.f1434e = i2;
        this.f1433d = new ad(Looper.getMainLooper(), this);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f1437h == null) {
            this.f1437h = new com.bytedance.sdk.openadsdk.dislike.b(this.c, this.f1435f);
        }
        this.f1437h.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ad adVar = this.f1433d;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
        }
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b(dislikeInteractionCallback);
        this.a.a(this.f1437h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ad adVar = this.f1433d;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
            this.f1433d.sendEmptyMessageDelayed(1, this.f1434e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    private void a() {
        this.f1438i.a(this.f1441l, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.1
            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a(@NonNull a aVar) {
                e.this.a(aVar);
                e.this.a.e();
                e.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a() {
                e.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull a aVar) {
        if (this.a.c() == null || this.a.f()) {
            return;
        }
        a(this.a.c(), aVar);
    }

    private d.a.a.a.a.a.b a(h hVar) {
        if (hVar.x() == 4) {
            return d.a.a.a.a.a.c.a(this.c, hVar, this.f1440k);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull c cVar, @NonNull a aVar) {
        cVar.a(aVar.a());
        final h b = aVar.b();
        this.f1435f = b;
        this.f1437h = new com.bytedance.sdk.openadsdk.dislike.b(this.c, b);
        cVar.a(b);
        this.f1439j = a(b);
        com.bytedance.sdk.openadsdk.c.d.a(b);
        EmptyView a = a(cVar);
        if (a == null) {
            a = new EmptyView(this.c, cVar);
            cVar.addView(a);
        }
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (z) {
                    e.this.b();
                    o.b("TTBannerAd", "获得焦点，开始计时");
                    return;
                }
                o.b("TTBannerAd", "失去焦点，停止计时");
                e.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                e.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                e.this.b();
                o.b("TTBannerAd", "BANNER SHOW");
                com.bytedance.sdk.openadsdk.c.d.a(e.this.c, b, e.this.f1440k, (Map<String, Object>) null);
                if (e.this.f1436g != null) {
                    e.this.f1436g.onAdShow(view, b.x());
                }
                if (b.R()) {
                    ab.a(b, view);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.c, b, this.f1440k, 2);
        aVar2.a(cVar);
        aVar2.b(this.a.d());
        aVar2.a(this.f1439j);
        aVar2.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.3
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i2) {
                if (e.this.f1436g != null) {
                    e.this.f1436g.onAdClicked(view, i2);
                }
            }
        });
        cVar.setOnClickListener(aVar2);
        cVar.setOnTouchListener(aVar2);
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
