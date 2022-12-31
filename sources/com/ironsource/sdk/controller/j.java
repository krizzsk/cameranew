package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.ISNEnums$ControllerType;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: IronSourceController.java */
/* loaded from: classes2.dex */
public interface j {
    void a();

    void b(JSONObject jSONObject);

    void c(String str, d.e.d.n.h.c cVar);

    void d(String str, String str2, Map<String, String> map, d.e.d.n.e eVar);

    void destroy();

    void e(String str, String str2, d.e.d.n.e eVar);

    void f(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.c cVar);

    ISNEnums$ControllerType getType();

    boolean h(String str);

    void i(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.b bVar2);

    void j(JSONObject jSONObject, d.e.d.n.h.d dVar);

    void k(Context context);

    void m(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar);

    void n(Map<String, String> map, d.e.d.n.h.b bVar);

    void o(Context context);

    void p(JSONObject jSONObject, d.e.d.n.h.b bVar);

    void q(Map<String, String> map, d.e.d.n.e eVar);

    void r(JSONObject jSONObject, d.e.d.n.h.c cVar);

    void setCommunicationWithAdView(ISNAdView iSNAdView);

    void t(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar);

    @Deprecated
    void u();

    void v();

    void x(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.d dVar);
}
