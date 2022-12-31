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
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.f;
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
import com.growingio.android.sdk.autoburry.VdsAgent;
import d.a.a.a.a.a.b;
import java.io.File;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aP;
    FrameLayout aQ;
    long aR;
    b aS;
    Handler aU;
    String aT = "rewarded_video";
    boolean aV = false;
    boolean aW = false;

    private void f(boolean z) {
        if (this.f1337f != null && !this.V.get()) {
            this.f1337f.setShowSkip(z);
            this.f1337f.setShowSound(z);
            if (this.v.X()) {
                this.f1337f.setShowDislike(z);
            } else {
                this.f1337f.setShowDislike(false);
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
    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity
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
        o.e("TTRewardExpressVideoActivity", "onGetCurrentPlayTime mVideoCurrent:" + this.aR);
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

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public void O() {
        super.O();
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public boolean a(long j2, boolean z) {
        FrameLayout videoFrameLayout = this.aP.getVideoFrameLayout();
        this.aQ = videoFrameLayout;
        if (this.F == null) {
            this.F = new f(this.f1339h, videoFrameLayout, this.v);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("dynamic_show_type", Integer.valueOf(this.aP.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        this.F.a(hashMap);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j3, int i2) {
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                tTRewardExpressVideoActivity.aW = true;
                tTRewardExpressVideoActivity.R();
                TTRewardExpressVideoActivity.this.r();
                TTRewardExpressVideoActivity.this.aY = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.P();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j3, int i2) {
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardExpressVideoActivity.this.d("onVideoError");
                } else {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardExpressVideoActivity.this.aZ;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onVideoError();
                    }
                }
                if (TTRewardExpressVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTRewardExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                TTRewardExpressVideoActivity.this.r();
                TTRewardExpressVideoActivity.this.aV = true;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 1);
                TTRewardExpressVideoActivity.this.a("rewarded_video", hashMap2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTRewardExpressVideoActivity.this.r();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardExpressVideoActivity.this.a("rewarded_video", hashMap2);
                c cVar = TTRewardExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j3, long j4) {
                c cVar;
                TopProxyLayout topProxyLayout;
                TopProxyLayout topProxyLayout2;
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTRewardExpressVideoActivity.this.aR = j3;
                int i2 = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(TTRewardExpressVideoActivity.this.U)).f1638g;
                if (j4 > 0 && ((float) (100 * j3)) / Float.valueOf((float) j4).floatValue() >= i2) {
                    TTRewardExpressVideoActivity.this.P();
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                long j5 = j3 / 1000;
                tTRewardExpressVideoActivity.R = (int) (tTRewardExpressVideoActivity.H() - j5);
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = TTRewardExpressVideoActivity.this;
                int i3 = tTRewardExpressVideoActivity2.R;
                if (i3 >= 0 && (topProxyLayout2 = tTRewardExpressVideoActivity2.f1337f) != null) {
                    topProxyLayout2.a(String.valueOf(i3), (CharSequence) null);
                }
                int i4 = (int) j5;
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = TTRewardExpressVideoActivity.this;
                int i5 = tTRewardExpressVideoActivity3.T;
                boolean z2 = false;
                if (i5 != -1 && i4 == i5 && !tTRewardExpressVideoActivity3.ba.get()) {
                    RelativeLayout relativeLayout = TTRewardExpressVideoActivity.this.f1338g;
                    relativeLayout.setVisibility(0);
                    VdsAgent.onSetViewVisibility(relativeLayout, 0);
                    TTRewardExpressVideoActivity.this.ba.set(true);
                    TTRewardExpressVideoActivity.this.p();
                }
                int g2 = com.bytedance.sdk.openadsdk.core.o.h().g(String.valueOf(TTRewardExpressVideoActivity.this.U));
                if (TTRewardExpressVideoActivity.this.aP.m() && g2 != -1 && g2 >= 0) {
                    z2 = true;
                }
                if (z2 && i4 >= g2) {
                    if (!TTRewardExpressVideoActivity.this.X.getAndSet(true) && (topProxyLayout = TTRewardExpressVideoActivity.this.f1337f) != null) {
                        topProxyLayout.setShowSkip(true);
                    }
                    TopProxyLayout topProxyLayout3 = TTRewardExpressVideoActivity.this.f1337f;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.a((CharSequence) null, TTBaseVideoActivity.a);
                        TTRewardExpressVideoActivity.this.f1337f.setSkipEnable(true);
                    }
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity4.R <= 0) {
                    tTRewardExpressVideoActivity4.r();
                }
                if (!TTRewardExpressVideoActivity.this.ab.get() || (cVar = TTRewardExpressVideoActivity.this.F) == null || cVar.t() == null || !TTRewardExpressVideoActivity.this.F.t().g()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.F.h();
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
        message.arg1 = 1;
        this.K.sendMessageDelayed(message, 5000L);
        boolean a = this.F.a(str, this.v.J(), this.aQ.getWidth(), this.aQ.getHeight(), null, this.v.M(), j2, this.Q);
        if (a && !z) {
            d.a(this.f1339h, this.v, "rewarded_video", hashMap);
            O();
            this.aX = (int) (System.currentTimeMillis() / 1000);
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
                o.e("TTRewardExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (i2 == 3) {
            try {
                if (t()) {
                    this.F.j();
                }
            } catch (Throwable th2) {
                o.e("TTRewardExpressVideoActivity", "onPause throw Exception :" + th2.getMessage());
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
    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
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
        this.aU.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TTRewardExpressVideoActivity.this.r();
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
    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
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
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.3
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
        e eVar = new e(context, hVar, str, ab.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                super.a(view, i2, i3, i4, i5);
                TTRewardExpressVideoActivity.this.a(view, i2, i3, i4, i5);
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
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, hVar, str2, ab.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                super.a(view, i2, i3, i4, i5);
                TTRewardExpressVideoActivity.this.a(view, i2, i3, i4, i5);
            }
        };
        dVar.a(nativeExpressView);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("rit_scene", this.af);
            dVar.a(hashMap2);
        }
        dVar.a(this.aS);
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
