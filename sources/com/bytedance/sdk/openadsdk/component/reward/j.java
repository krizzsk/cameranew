package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.o;
import com.facebook.AccessToken;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: TTRewardVideoAdImpl.java */
/* loaded from: classes.dex */
class j implements TTRewardVideoAd {
    private final Context a;
    private final com.bytedance.sdk.openadsdk.core.d.h b;
    private final AdSlot c;

    /* renamed from: d  reason: collision with root package name */
    private TTRewardVideoAd.RewardAdInteractionListener f1471d;

    /* renamed from: e  reason: collision with root package name */
    private d.a.a.a.a.a.b f1472e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1474g;

    /* renamed from: h  reason: collision with root package name */
    private String f1475h;

    /* renamed from: i  reason: collision with root package name */
    private String f1476i;

    /* renamed from: k  reason: collision with root package name */
    private String f1478k;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1473f = true;

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f1477j = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.a = context;
        this.b = hVar;
        this.c = adSlot;
        if (getInteractionType() == 4) {
            this.f1472e = d.a.a.a.a.a.c.a(context, hVar, "rewarded_video");
        }
        this.f1474g = false;
        this.f1478k = com.bytedance.sdk.openadsdk.utils.h.a(hVar.hashCode() + hVar.Z().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar == null) {
            return -1;
        }
        if (hVar.r() && this.b.c() == 1) {
            return 2;
        }
        return (this.b.r() && this.b.c() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f1471d = rewardAdInteractionListener;
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f1473f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            o.e("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (this.f1477j.get()) {
                return;
            }
            this.f1477j.set(true);
            com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
            if (hVar == null || hVar.v() == null) {
                return;
            }
            Context context = activity == null ? this.a : activity;
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            if (this.b.u() != null) {
                intent = new Intent(context, TTRewardExpressVideoActivity.class);
            } else {
                intent = new Intent(context, TTRewardVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            }
            intent.putExtra("reward_name", this.c.getRewardName());
            intent.putExtra("reward_amount", this.c.getRewardAmount());
            intent.putExtra("media_extra", this.c.getMediaExtra());
            intent.putExtra(AccessToken.USER_ID_KEY, this.c.getUserID());
            intent.putExtra("show_download_bar", this.f1473f);
            intent.putExtra("orientation", this.c.getOrientation());
            if (!TextUtils.isEmpty(this.f1476i)) {
                intent.putExtra("rit_scene", this.f1476i);
            }
            if (this.f1474g) {
                intent.putExtra("video_cache_url", this.f1475h);
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.Z().toString());
                intent.putExtra("multi_process_meta_md5", this.f1478k);
            } else {
                s.a().g();
                s.a().a(this.b);
                s.a().a(this.f1471d);
                s.a().a(this.f1472e);
                this.f1471d = null;
            }
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.1
                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    o.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                }
            });
            if (TextUtils.isEmpty(this.b.M())) {
                return;
            }
            try {
                String optString = new JSONObject(this.b.M()).optString("rit", null);
                AdSlot b = g.a(this.a).b(optString);
                g.a(this.a).a(optString);
                if (b != null) {
                    if (this.f1474g && !TextUtils.isEmpty(this.f1475h)) {
                        g.a(this.a).b(b);
                    } else {
                        g.a(this.a).a(b);
                    }
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        o.e("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
        throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
    }

    public void a(String str) {
        if (this.f1477j.get()) {
            return;
        }
        this.f1474g = true;
        this.f1475h = str;
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.j.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.this.a);
                    if (i2 == 0 && j.this.f1471d != null) {
                        o.b("MultiProcess", "start registerRewardVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.b bVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.b(j.this.f1471d);
                        IListenerManager asInterface = IListenerManager.Stub.asInterface(a.a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(j.this.f1478k, bVar);
                                o.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            o.e("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.f1476i = str;
        } else {
            this.f1476i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }
}
