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
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: TTFullScreenVideoAdImpl.java */
/* loaded from: classes.dex */
class i implements TTFullScreenVideoAd {
    private final Context a;
    private final com.bytedance.sdk.openadsdk.core.d.h b;
    private final AdSlot c;

    /* renamed from: d  reason: collision with root package name */
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f1462d;

    /* renamed from: e  reason: collision with root package name */
    private d.a.a.a.a.a.b f1463e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1465g;

    /* renamed from: h  reason: collision with root package name */
    private String f1466h;

    /* renamed from: i  reason: collision with root package name */
    private String f1467i;

    /* renamed from: l  reason: collision with root package name */
    private String f1470l;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1464f = true;

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f1468j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private boolean f1469k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
        this.a = context;
        this.b = hVar;
        this.c = adSlot;
        if (getInteractionType() == 4) {
            this.f1463e = d.a.a.a.a.a.c.a(context, hVar, "fullscreen_interstitial_ad");
        }
        this.f1465g = false;
        this.f1470l = com.bytedance.sdk.openadsdk.utils.h.a(hVar.hashCode() + hVar.Z().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar == null) {
            return -1;
        }
        if (hVar.r() && this.b.c() == 1) {
            return 2;
        }
        return (this.b.r() && this.b.c() == 0) ? 1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar == null) {
            return -1;
        }
        return hVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar != null) {
            return hVar.T();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f1462d = fullScreenVideoAdInteractionListener;
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.f1464f = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            o.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (this.f1468j.get()) {
                return;
            }
            this.f1468j.set(true);
            com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
            if (hVar == null || hVar.v() == null) {
                return;
            }
            Context context = activity == null ? this.a : activity;
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            if (this.b.u() != null) {
                intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
            } else {
                intent = new Intent(context, TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            }
            intent.putExtra("show_download_bar", this.f1464f);
            intent.putExtra("orientation", this.c.getOrientation());
            intent.putExtra("is_verity_playable", this.f1469k);
            if (!TextUtils.isEmpty(this.f1467i)) {
                intent.putExtra("rit_scene", this.f1467i);
            }
            if (this.f1465g) {
                intent.putExtra("video_cache_url", this.f1466h);
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.Z().toString());
                intent.putExtra("multi_process_meta_md5", this.f1470l);
            } else {
                s.a().g();
                s.a().a(this.b);
                s.a().a(this.f1462d);
                s.a().a(this.f1463e);
                this.f1462d = null;
            }
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.i.1
                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a() {
                    if (i.this.f1469k) {
                        try {
                            com.bytedance.sdk.openadsdk.f.a.a().a(i.this.b.v().i());
                        } catch (Throwable unused) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.b.a
                public void a(Throwable th) {
                    o.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                    if (i.this.f1469k) {
                        try {
                            com.bytedance.sdk.openadsdk.f.a.a().a(i.this.b.v().i(), -1, th != null ? th.getMessage() : "playable tool error open");
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            if (TextUtils.isEmpty(this.b.M())) {
                return;
            }
            try {
                String optString = new JSONObject(this.b.M()).optString("rit", null);
                AdSlot b = c.a(this.a).b(optString);
                c.a(this.a).a(optString);
                if (b != null) {
                    if (this.f1465g && !TextUtils.isEmpty(this.f1466h)) {
                        c.a(this.a).b(b);
                    } else {
                        c.a(this.a).a(b);
                    }
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        o.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
        throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
    }

    public void a(boolean z) {
        this.f1469k = z;
    }

    public void a(String str) {
        if (this.f1468j.get()) {
            return;
        }
        this.f1465g = true;
        this.f1466h = str;
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.i.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(i.this.a);
                    if (i2 == 1 && i.this.f1462d != null) {
                        o.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.a aVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(i.this.f1462d);
                        IListenerManager asInterface = IListenerManager.Stub.asInterface(a.a(1));
                        if (asInterface != null) {
                            try {
                                asInterface.registerFullVideoListener(i.this.f1470l, aVar);
                                o.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            o.e("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.f1467i = str;
        } else {
            this.f1467i = ritScenes.getScenesName();
        }
        showFullScreenVideoAd(activity);
    }
}
