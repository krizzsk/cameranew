package com.tapjoy.internal;

import android.graphics.Rect;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes3.dex */
public final class hs {

    /* renamed from: h  reason: collision with root package name */
    public static final bi f7633h = new bi() { // from class: com.tapjoy.internal.hs.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            Rect rect = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            ho hoVar = null;
            String str4 = "";
            boolean z = false;
            while (bnVar.j()) {
                String l2 = bnVar.l();
                if ("region".equals(l2)) {
                    rect = (Rect) bj.b.a(bnVar);
                } else if (FirebaseAnalytics.Param.VALUE.equals(l2)) {
                    str = bnVar.m();
                } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l2)) {
                    z = bnVar.n();
                } else if ("url".equals(l2)) {
                    str4 = bnVar.m();
                } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l2)) {
                    str2 = bnVar.b();
                } else if ("ad_content".equals(l2)) {
                    str3 = bnVar.b();
                } else if (ho.a(l2)) {
                    hoVar = ho.a(l2, bnVar);
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hs(rect, str, z, str4, str2, str3, hoVar);
        }
    };
    public final Rect a;
    public final String b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7634d;

    /* renamed from: e  reason: collision with root package name */
    public String f7635e;

    /* renamed from: f  reason: collision with root package name */
    public String f7636f;

    /* renamed from: g  reason: collision with root package name */
    public final gl f7637g;

    hs(Rect rect, String str, boolean z, String str2, String str3, String str4, gl glVar) {
        this.a = rect;
        this.b = str;
        this.c = z;
        this.f7634d = str2;
        this.f7635e = str3;
        this.f7636f = str4;
        this.f7637g = glVar;
    }
}
