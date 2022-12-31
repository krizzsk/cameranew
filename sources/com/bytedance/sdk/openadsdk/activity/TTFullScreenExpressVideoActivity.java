package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import d.a.a.a.a.a.b;
import java.io.File;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aP;
    FrameLayout aQ;
    long aR;
    b aS;
    Handler aU;
    String aT = "fullscreen_interstitial_ad";
    boolean aV = false;
    boolean aW = false;

    private void f(boolean z) {
        if (this.f1337f != null) {
            if (this.v.r()) {
                if (!this.V.get()) {
                    this.f1337f.setShowSound(z);
                    if (this.v.X()) {
                        this.f1337f.setShowDislike(z);
                    } else {
                        this.f1337f.setShowDislike(false);
                    }
                }
            } else if (!this.V.get()) {
                this.f1337f.setShowSkip(z);
                this.f1337f.setShowSound(z);
                if (this.v.X()) {
                    this.f1337f.setShowDislike(z);
                } else {
                    this.f1337f.setShowDislike(false);
                }
            }
        }
        if (z) {
            ac.a((View) this.f1338g, 0);
            ac.a((View) this.aw, 0);
            return;
        }
        ac.a((View) this.f1338g, 4);
        ac.a((View) this.aw, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity
    public void J() {
        if (this.v == null) {
            finish();
            return;
        }
        this.aG = false;
        super.J();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void K() {
        TopProxyLayout topProxyLayout = this.f1337f;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long L() {
        return this.aR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int M() {
        if (this.aV) {
            return 4;
        }
        if (this.aW) {
            return 5;
        }
        if (u()) {
            return 1;
        }
        if (s()) {
            return 2;
        }
        if (t()) {
        }
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void N() {
        I();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public void O() {
        super.O();
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public boolean a(long j2, boolean z) {
        FrameLayout videoFrameLayout = this.aP.getVideoFrameLayout();
        this.aQ = videoFrameLayout;
        if (this.F == null) {
            this.F = new com.bytedance.sdk.openadsdk.component.reward.b(this.f1339h, videoFrameLayout, this.v);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aP.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.F.a(hashMap);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j3, int i2) {
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.aW = true;
                tTFullScreenExpressVideoActivity.R();
                if (TTFullScreenExpressVideoActivity.this.P()) {
                    TTFullScreenExpressVideoActivity.this.r();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j3, int i2) {
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                if (TTFullScreenExpressVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTFullScreenExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                o.e("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.P()) {
                    TTFullScreenExpressVideoActivity.this.r();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("vbtt_skip_type", 1);
                    TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.aV = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                o.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.P()) {
                    TTFullScreenExpressVideoActivity.this.r();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", hashMap2);
                c cVar = TTFullScreenExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j3, long j4) {
                TopProxyLayout topProxyLayout;
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.aR = j3;
                long j5 = j3 / 1000;
                tTFullScreenExpressVideoActivity.R = (int) (tTFullScreenExpressVideoActivity.H() - j5);
                if (TTFullScreenExpressVideoActivity.this.aP.m()) {
                    TTFullScreenExpressVideoActivity.this.d((int) j5);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = TTFullScreenExpressVideoActivity.this;
                    if (tTFullScreenExpressVideoActivity2.R >= 0 && (topProxyLayout = tTFullScreenExpressVideoActivity2.f1337f) != null) {
                        topProxyLayout.setShowSkip(true);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = TTFullScreenExpressVideoActivity.this;
                        tTFullScreenExpressVideoActivity3.f1337f.a(String.valueOf(tTFullScreenExpressVideoActivity3.R), (CharSequence) null);
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.R <= 0) {
                    o.b("TTFullScreenExpressVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.P()) {
                        TTFullScreenExpressVideoActivity.this.r();
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenExpressVideoActivity.this.ab.get() || TTFullScreenExpressVideoActivity.this.Z.get()) && TTFullScreenExpressVideoActivity.this.s()) {
                    TTFullScreenExpressVideoActivity.this.F.h();
                }
            }
        });
        String h2 = this.v.v() != null ? this.v.v().h() : null;
        if (this.A != null) {
            File file = new File(this.A);
            if (file.exists() && file.length() > 0) {
                h2 = this.A;
                this.C = true;
            }
        }
        String str = h2;
        o.e("wzj", "videoUrl:" + str);
        if (this.F == null) {
            return false;
        }
        Message message = new Message();
        message.what = IjkMediaCodecInfo.RANK_SECURE;
        message.arg1 = 0;
        this.K.sendMessageDelayed(message, 5000L);
        boolean a = this.F.a(str, this.v.J(), this.aQ.getWidth(), this.aQ.getHeight(), null, this.v.M(), j2, this.Q);
        if (a && !z) {
            d.a(this.f1339h, this.v, "fullscreen_interstitial_ad", hashMap);
            O();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void b(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void c(int i2) {
        if (i2 == 1) {
            if (s() || t()) {
                return;
            }
            a(0L, false);
        } else if (i2 == 2) {
            try {
                if (s()) {
                    this.F.h();
                }
            } catch (Throwable th) {
                o.e("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (i2 == 3) {
            try {
                if (t()) {
                    this.F.j();
                }
            } catch (Throwable th2) {
                o.e("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th2.getMessage());
            }
        } else if (i2 != 4) {
            if (i2 != 5 || s() || t()) {
                return;
            }
            a(0L, false);
        } else {
            c cVar = this.F;
            if (cVar != null) {
                cVar.k();
                this.F = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void e() {
        super.e();
        int d2 = ab.d(this.v.M());
        boolean z = this.v.N() == 15;
        float a = a((Activity) this);
        float b = b((Activity) this);
        if (z != (a > b)) {
            float f2 = a + b;
            b = f2 - b;
            a = f2 - b;
        }
        if (ac.b((Activity) this)) {
            int b2 = ac.b(this, ac.i(this));
            if (z) {
                a -= b2;
            } else {
                b -= b2;
            }
        }
        o.e("TTFullScreenExpressVideoActivity", "screen height:" + a + ", width:" + b);
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this, this.v, new AdSlot.Builder().setCodeId(String.valueOf(d2)).setExpressViewAcceptedSize(b, a).build(), this.aT);
        this.aP = fullRewardExpressView;
        fullRewardExpressView.setExpressVideoListenerProxy(this);
        this.aP.setExpressInteractionListener(this);
        a(this.aP, this.v);
        this.aQ = this.aP.getVideoFrameLayout();
        this.r.addView(this.aP, new FrameLayout.LayoutParams(-1, -1));
        l();
        a(this.Q);
        k();
        q();
        j();
        a("reward_endcard");
        o();
        if (h.b(this.v)) {
            this.aG = true;
            this.U = ab.d(this.v.M());
            g();
            r();
            return;
        }
        d(true);
        this.aP.h();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.aU;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        this.aG = true;
        g();
        if (this.aU == null) {
            this.aU = new Handler(Looper.getMainLooper());
        }
        o.b("TTFullScreenExpressVideoActivity", "onRenderFail、、、code:" + i2);
        this.aU.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenExpressVideoActivity.this.r();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        if (this.v.c() == 1 && this.v.r()) {
            return;
        }
        if (this.aP.m()) {
            f(true);
        }
        d(false);
        this.aG = true;
        g();
        if (a(this.z, false)) {
            return;
        }
        r();
        HashMap hashMap = new HashMap();
        hashMap.put("vbtt_skip_type", 1);
        a(this.aT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.aP.m()) {
            f(false);
        }
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
    }

    protected void a(@NonNull NativeExpressView nativeExpressView, @NonNull h hVar) {
        if (nativeExpressView == null || this.v == null) {
            return;
        }
        this.aS = a(hVar);
        d.a(hVar);
        EmptyView a = a((ViewGroup) nativeExpressView);
        if (a == null) {
            a = new EmptyView(this.f1339h, nativeExpressView);
            nativeExpressView.addView(a);
        }
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }
        });
        Context context = this.f1339h;
        String str = this.aT;
        e eVar = new e(context, hVar, str, ab.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                super.a(view, i2, i3, i4, i5);
                TTFullScreenExpressVideoActivity.this.a(view, i2, i3, i4, i5);
            }
        };
        eVar.a(nativeExpressView);
        eVar.a(this.aS);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
            eVar.a(hashMap);
        }
        this.aP.setClickListener(eVar);
        Context context2 = this.f1339h;
        String str2 = this.aT;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, hVar, str2, ab.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                super.a(view, i2, i3, i4, i5);
                TTFullScreenExpressVideoActivity.this.a(view, i2, i3, i4, i5);
            }
        };
        dVar.a(nativeExpressView);
        dVar.a(this.aS);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("rit_scene", this.af);
            dVar.a(hashMap2);
        }
        this.aP.setClickCreativeListener(dVar);
        a.setNeedCheckingShow(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        TopProxyLayout topProxyLayout;
        if (this.Q == z || (topProxyLayout = this.f1337f) == null) {
            return;
        }
        topProxyLayout.b();
    }

    private b a(h hVar) {
        if (hVar.x() == 4) {
            return d.a.a.a.a.a.c.a(this.f1339h, hVar, this.aT);
        }
        return null;
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
