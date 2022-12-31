package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.b;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: WebHelper.java */
/* loaded from: classes.dex */
public class x {
    private static boolean a = false;

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(final Context context, final com.bytedance.sdk.openadsdk.core.d.h hVar, final int i2, @Nullable TTNativeAd tTNativeAd, @Nullable TTNativeExpressAd tTNativeExpressAd, final String str, @Nullable d.a.a.a.a.a.b bVar, final boolean z) {
        String A;
        if (context == null || hVar == null || i2 == -1) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.d.e L = hVar.L();
        if (L != null) {
            A = L.a();
            if (!TextUtils.isEmpty(A)) {
                Uri parse = Uri.parse(L.a());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (ab.a(context, intent)) {
                    if (o.h().c()) {
                        ab.a(hVar, str);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    }
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.x.1
                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            if (o.h().c()) {
                                return;
                            }
                            x.a(context, hVar.A(), hVar, i2, str, z);
                            com.bytedance.sdk.openadsdk.utils.o.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                        }
                    });
                    com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_url_app", null);
                    com.bytedance.sdk.openadsdk.c.k.a().a(hVar, str);
                    return true;
                }
            }
            if (L.c() != 2 || hVar.N() == 5 || hVar.N() == 15) {
                if (L.c() == 1) {
                    A = L.b();
                } else {
                    A = hVar.A();
                }
            } else if (bVar != null) {
                if (!bVar.d()) {
                    if (bVar.c()) {
                        com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
                    return false;
                }
                com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
                return true;
            }
            com.bytedance.sdk.openadsdk.c.d.f(context, hVar, str, "open_fallback_url", null);
        } else {
            A = hVar.A();
        }
        if (!TextUtils.isEmpty(A) || hVar.r()) {
            if (hVar.x() == 2) {
                if (!com.bytedance.sdk.openadsdk.utils.q.a(A)) {
                    return false;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                try {
                    intent2.setData(Uri.parse(A));
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    }
                    com.bytedance.sdk.openadsdk.utils.b.a(context, intent2, null);
                } catch (Exception unused) {
                    return false;
                }
            } else {
                com.bytedance.sdk.openadsdk.utils.b.a(context, a(context, A, hVar, i2, tTNativeAd, tTNativeExpressAd, str, z), null);
                a = false;
            }
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.h hVar, int i2, String str2, boolean z) {
        try {
            context.startActivity(a(context, str, hVar, i2, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.h hVar, int i2, @Nullable TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z) {
        Intent intent;
        if (hVar.r() && (tTNativeAd != null || tTNativeExpressAd != null)) {
            intent = new Intent(context, TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", a(hVar, z));
            if (hVar.v() != null && !TextUtils.isEmpty(hVar.v().i())) {
                String i3 = hVar.v().i();
                if (i3.contains("?")) {
                    str = i3 + "&orientation=portrait";
                } else {
                    str = i3 + "?orientation=portrait";
                }
            }
        } else {
            intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTLandingPageActivity.class) : (hVar.N() != 5 || a) ? new Intent(context, TTLandingPageActivity.class) : new Intent(context, TTVideoLandingPageActivity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("web_title", hVar.G());
        intent.putExtra("sdk_version", 3154);
        intent.putExtra("adid", hVar.J());
        intent.putExtra("log_extra", hVar.M());
        intent.putExtra("icon_url", hVar.y() == null ? null : hVar.y().a());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, hVar.Z().toString());
        } else {
            s.a().g();
            s.a().a(hVar);
        }
        if (hVar.N() == 5) {
            if (tTNativeAd != null) {
                r10 = tTNativeAd instanceof a.InterfaceC0065a ? ((a.InterfaceC0065a) tTNativeAd).a() : null;
                if (r10 != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, r10.a().toString());
                }
            }
            if (tTNativeExpressAd != null && (r10 = tTNativeExpressAd.getVideoModel()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, r10.a().toString());
            }
            if (r10 != null) {
                intent.putExtra("video_is_auto_play", r10.f2093d);
                com.bytedance.sdk.openadsdk.utils.o.c("videoDataModel", "videoDataModel=" + r10.a().toString());
            }
        }
        return intent;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.h hVar, boolean z) {
        return z && hVar != null && hVar.x() == 4 && hVar.r();
    }
}
