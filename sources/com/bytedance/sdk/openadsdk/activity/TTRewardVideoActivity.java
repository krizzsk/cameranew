package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.f;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.facebook.AccessToken;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static TTRewardVideoAd.RewardAdInteractionListener aU;
    private p aP;
    private String aQ;
    private int aR;
    private String aS;
    private String aT;
    protected int aX;
    protected int aY;
    protected TTRewardVideoAd.RewardAdInteractionListener aZ;
    private AtomicBoolean aV = new AtomicBoolean(false);
    protected final AtomicBoolean ba = new AtomicBoolean(false);
    String bb = t.a(o.a(), "tt_msgPlayable");
    String bc = t.a(o.a(), "tt_negtiveBtnBtnText");
    String bd = t.a(o.a(), "tt_postiveBtnText");
    String be = t.a(o.a(), "tt_postiveBtnTextPlayable");
    String bf = t.a(o.a(), "tt_reward_msg");

    private void K() {
        this.aP = o.f();
        h hVar = this.v;
        if (hVar == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (hVar.r() && this.v.c() == 1) {
            a(getApplicationContext());
        }
        this.at = 7;
        this.U = ab.d(this.v.M());
        this.Q = o.h().b(this.U);
        this.S = this.v.N();
        this.L = this.v.J();
        this.M = this.v.M();
        this.R = (int) H();
        this.N = 7;
        this.O = 3154;
        l();
        a(this.Q);
        d();
        k();
        q();
        j();
        h();
        m();
        i();
        a("reward_endcard");
        L();
        b("rewarded_video");
        o();
    }

    private void L() {
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view) {
                    VdsAgent.onClick(this, view);
                    TTRewardVideoActivity.this.T();
                    TTRewardVideoActivity.this.U();
                    if (h.b(TTRewardVideoActivity.this.v)) {
                        TTRewardVideoActivity.this.e(true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            });
        }
        TopProxyLayout topProxyLayout = this.f1337f;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    TTRewardVideoActivity.this.T();
                    TTRewardVideoActivity.this.U();
                    h hVar = TTRewardVideoActivity.this.v;
                    if (hVar != null && hVar.r() && TTRewardVideoActivity.this.v.c() == 1) {
                        TTRewardVideoActivity.this.e(true);
                    } else {
                        TTRewardVideoActivity.this.e(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.Q = !tTRewardVideoActivity.Q;
                    com.bytedance.sdk.openadsdk.utils.o.b("TTRewardVideoActivity", "will set is Mute " + TTRewardVideoActivity.this.Q + " mLastVolume=" + TTRewardVideoActivity.this.au.b());
                    TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                    c cVar = tTRewardVideoActivity2.F;
                    if (cVar != null) {
                        cVar.c(tTRewardVideoActivity2.Q);
                    }
                    if (h.a(TTRewardVideoActivity.this.v)) {
                        TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity3.au.a(tTRewardVideoActivity3.Q, true);
                    }
                    TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity4.c(tTRewardVideoActivity4.Q);
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTRewardVideoActivity.this.I();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        c cVar = this.F;
        if (cVar != null) {
            cVar.l();
        }
        a("rewarded_video", FreeSpaceBox.TYPE, (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            hashMap.put("rit_scene", this.af);
        }
        hashMap.put("play_type", Integer.valueOf(ab.a(this.F, this.C)));
        a("rewarded_video", "feed_break", hashMap);
        E();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onSkippedVideo");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onSkippedVideo();
        }
    }

    private void N() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.aQ = intent.getStringExtra("reward_name");
        this.aR = intent.getIntExtra("reward_amount", 0);
        this.aS = intent.getStringExtra("media_extra");
        this.aT = intent.getStringExtra(AccessToken.USER_ID_KEY);
        this.y = intent.getBooleanExtra("show_download_bar", true);
        this.A = intent.getStringExtra("video_cache_url");
        this.B = intent.getIntExtra("orientation", 2);
        this.af = intent.getStringExtra("rit_scene");
    }

    private JSONObject S() {
        JSONObject jSONObject = new JSONObject();
        c cVar = this.F;
        int r = cVar != null ? (int) cVar.r() : 0;
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.aQ);
            jSONObject.put("reward_amount", this.aR);
            jSONObject.put("network", q.c(this.f1339h));
            jSONObject.put("sdk_version", "3.1.5.4");
            int t = this.v.t();
            String str = "unKnow";
            if (t == 2) {
                str = ab.b();
            } else if (t == 1) {
                str = ab.c();
            }
            jSONObject.put("user_agent", str);
            jSONObject.put(JsonMarshaller.EXTRA, new JSONObject(this.M));
            jSONObject.put("media_extra", this.aS);
            jSONObject.put("video_duration", this.v.v().e());
            jSONObject.put("play_start_ts", this.aX);
            jSONObject.put("play_end_ts", this.aY);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, r);
            jSONObject.put(AccessToken.USER_ID_KEY, this.aT);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace(PGTransHeader.CONNECTOR, ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        HashMap hashMap = new HashMap();
        h hVar = this.v;
        if (hVar != null && hVar.c() == 1 && this.v.r()) {
            hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.d(this.f1339h, this.v, "rewarded_video", "click_close", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final boolean z) {
        if (!o.h().e(String.valueOf(this.U))) {
            if (z) {
                finish();
            } else {
                M();
            }
        } else if (this.aV.get()) {
            if (z) {
                finish();
            } else {
                M();
            }
        } else {
            this.ab.set(true);
            c cVar = this.F;
            if (cVar != null) {
                cVar.h();
            }
            if (z) {
                C();
            }
            a aVar = new a(this);
            this.ac = aVar;
            if (z) {
                aVar.a(this.bb).b(this.be).c(this.bc);
            } else {
                aVar.a(this.bf).b(this.bd).c(this.bc);
            }
            this.ac.a(new a.InterfaceC0057a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0057a
                public void a() {
                    c cVar2 = TTRewardVideoActivity.this.F;
                    if (cVar2 != null) {
                        cVar2.j();
                    }
                    if (z) {
                        TTRewardVideoActivity.this.D();
                    }
                    TTRewardVideoActivity.this.ac.dismiss();
                    TTRewardVideoActivity.this.ab.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0057a
                public void b() {
                    TTRewardVideoActivity.this.ac.dismiss();
                    TTRewardVideoActivity.this.ab.set(false);
                    if (!z) {
                        TTRewardVideoActivity.this.M();
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        h hVar = this.v;
        if (hVar == null) {
            finish();
        } else if (hVar.i() == 0) {
            setContentView(t.f(this, "tt_activity_rewardvideo"));
        } else if (this.v.i() == 1) {
            setContentView(t.f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.v.i() == 3) {
            setContentView(t.f(this, "tt_activity_rewardvideo_new_bar_3_style"));
        } else {
            setContentView(t.f(this, "tt_activity_rewardvideo"));
        }
    }

    public void O() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdShow");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        if (this.aV.get()) {
            return;
        }
        this.aV.set(true);
        if (o.h().n(String.valueOf(this.U))) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a("onRewardVerify", true, this.aR, this.aQ);
                return;
            }
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify(true, this.aR, this.aQ);
                return;
            }
            return;
        }
        this.aP.a(S(), new p.b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(int i2, String str) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "");
                    return;
                }
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2 = TTRewardVideoActivity.this.aZ;
                if (rewardAdInteractionListener2 != null) {
                    rewardAdInteractionListener2.onRewardVerify(false, 0, "");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(q.b bVar) {
                int a = bVar.c.a();
                String b = bVar.c.b();
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.a("onRewardVerify", bVar.b, a, b);
                    return;
                }
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2 = TTRewardVideoActivity.this.aZ;
                if (rewardAdInteractionListener2 != null) {
                    rewardAdInteractionListener2.onRewardVerify(bVar.b, a, b);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void Q() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onVideoComplete");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        a(str, false, 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aU = null;
    }

    @Override // android.app.Activity
    public void finish() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdClose");
        } else {
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdClose();
            }
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        N();
        if (a(bundle)) {
            J();
            e();
            K();
            c();
            v();
            z();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("recycleRes");
        }
        if (this.aZ != null) {
            this.aZ = null;
        }
        if (TextUtils.isEmpty(this.A)) {
            g.a(o.a()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ac.a((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aU = this.aZ;
        try {
            h hVar = this.v;
            bundle.putString("material_meta", hVar != null ? hVar.Z().toString() : null);
            bundle.putString("multi_process_meta_md5", this.x);
            c cVar = this.F;
            bundle.putLong("video_current", cVar == null ? this.z : cVar.m());
            bundle.putString("video_cache_url", this.A);
            bundle.putInt("orientation", this.B);
            bundle.putBoolean("is_mute", this.Q);
            bundle.putBoolean("has_show_skip_btn", this.X.get());
            bundle.putString("rit_scene", this.af);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, final int i2, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.a(0).executeRewardVideoCallback(TTRewardVideoActivity.this.x, str, z, i2, str2);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.o.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    private boolean a(Bundle bundle) {
        TopProxyLayout topProxyLayout;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                this.x = intent.getStringExtra("multi_process_meta_md5");
                if (stringExtra != null) {
                    try {
                        this.v = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        com.bytedance.sdk.openadsdk.utils.o.c("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", e2);
                    }
                }
            }
            h hVar = this.v;
            if (hVar != null && hVar.x() == 4) {
                this.G = d.a.a.a.a.a.c.a(this.f1339h, this.v, "rewarded_video");
            }
        } else {
            this.v = s.a().c();
            this.aZ = s.a().d();
            this.G = s.a().f();
            s.a().g();
        }
        if (bundle != null) {
            if (this.aZ == null) {
                this.aZ = aU;
                aU = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.x = bundle.getString("multi_process_meta_md5");
                this.A = bundle.getString("video_cache_url");
                this.B = bundle.getInt("orientation", 2);
                this.Q = bundle.getBoolean("is_mute");
                this.af = bundle.getString("rit_scene");
                this.v = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                this.X.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.X.get() && (topProxyLayout = this.f1337f) != null) {
                    topProxyLayout.setShowSkip(true);
                    this.f1337f.a((CharSequence) null, TTBaseVideoActivity.a);
                    this.f1337f.setSkipEnable(true);
                }
            } catch (Throwable unused) {
            }
            if (this.G == null) {
                this.G = d.a.a.a.a.a.c.a(this.f1339h, this.v, "rewarded_video");
            }
        }
        h hVar2 = this.v;
        if (hVar2 == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = hVar2.i() == 1;
        this.ah = this.v.i() == 3;
        h hVar3 = this.v;
        if (hVar3 != null) {
            hVar3.v();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void e(int i2) {
        if (i2 == 10000) {
            P();
        } else if (i2 == 10001) {
            R();
        }
    }

    public boolean a(long j2, boolean z) {
        HashMap hashMap;
        if (this.F == null) {
            this.F = new f(this.f1339h, this.r, this.v);
        }
        if (TextUtils.isEmpty(this.af)) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.af);
        }
        this.F.a(hashMap);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j3, int i2) {
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTRewardVideoActivity.this.R();
                TTRewardVideoActivity.this.r();
                TTRewardVideoActivity.this.aY = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.P();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j3, int i2) {
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.d("onVideoError");
                } else {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardVideoActivity.this.aZ;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onVideoError();
                    }
                }
                if (TTRewardVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTRewardVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                TTRewardVideoActivity.this.r();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 1);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                TTRewardVideoActivity.this.r();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("vbtt_skip_type", 0);
                TTRewardVideoActivity.this.a("rewarded_video", hashMap2);
                c cVar = TTRewardVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j3, long j4) {
                TopProxyLayout topProxyLayout;
                TopProxyLayout topProxyLayout2;
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(IjkMediaCodecInfo.RANK_SECURE);
                }
                int i2 = o.h().r(String.valueOf(TTRewardVideoActivity.this.U)).f1638g;
                if (j4 > 0 && ((float) (100 * j3)) / Float.valueOf((float) j4).floatValue() >= i2) {
                    TTRewardVideoActivity.this.P();
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j5 = j3 / 1000;
                tTRewardVideoActivity.R = (int) (tTRewardVideoActivity.H() - j5);
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity2.R >= 0 && (topProxyLayout2 = tTRewardVideoActivity2.f1337f) != null) {
                    topProxyLayout2.setShowCountDown(true);
                    TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity3.f1337f.a(String.valueOf(tTRewardVideoActivity3.R), (CharSequence) null);
                }
                int i3 = (int) j5;
                TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                int i4 = tTRewardVideoActivity4.T;
                boolean z2 = false;
                if (i4 != -1 && i3 == i4 && !tTRewardVideoActivity4.ba.get()) {
                    RelativeLayout relativeLayout = TTRewardVideoActivity.this.f1338g;
                    relativeLayout.setVisibility(0);
                    VdsAgent.onSetViewVisibility(relativeLayout, 0);
                    TTRewardVideoActivity.this.ba.set(true);
                    TTRewardVideoActivity.this.p();
                }
                int g2 = o.h().g(String.valueOf(TTRewardVideoActivity.this.U));
                if (g2 != -1 && g2 >= 0) {
                    z2 = true;
                }
                if (z2 && i3 >= g2) {
                    if (!TTRewardVideoActivity.this.X.getAndSet(true) && (topProxyLayout = TTRewardVideoActivity.this.f1337f) != null) {
                        topProxyLayout.setShowSkip(true);
                    }
                    TopProxyLayout topProxyLayout3 = TTRewardVideoActivity.this.f1337f;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.a((CharSequence) null, TTBaseVideoActivity.a);
                        TTRewardVideoActivity.this.f1337f.setSkipEnable(true);
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity5.R <= 0) {
                    tTRewardVideoActivity5.r();
                }
                if ((TTRewardVideoActivity.this.ab.get() || TTRewardVideoActivity.this.Z.get()) && TTRewardVideoActivity.this.s()) {
                    TTRewardVideoActivity.this.F.h();
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
        com.bytedance.sdk.openadsdk.utils.o.e("wzj", "videoUrl:" + str);
        if (this.F == null) {
            return false;
        }
        Message message = new Message();
        message.what = IjkMediaCodecInfo.RANK_SECURE;
        message.arg1 = 1;
        this.K.sendMessageDelayed(message, 5000L);
        boolean a = this.F.a(str, this.v.J(), this.r.getWidth(), this.r.getHeight(), null, this.v.M(), j2, this.Q);
        if (a && !z) {
            d.a(this.f1339h, this.v, "rewarded_video", hashMap);
            O();
            this.aX = (int) (System.currentTimeMillis() / 1000);
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void a(View view, int i2, int i3, int i4, int i5) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }
}
