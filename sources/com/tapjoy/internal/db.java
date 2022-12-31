package com.tapjoy.internal;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class db {
    private final boolean a = false;
    private final Float b = null;
    private final boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private final da f7362d;

    private db(da daVar) {
        this.f7362d = daVar;
    }

    public static db a(da daVar) {
        Cdo.a(daVar, "Position is null");
        return new db(daVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.a);
            if (this.a) {
                jSONObject.put("skipOffset", this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put("position", this.f7362d);
        } catch (JSONException e2) {
            dn.a("VastProperties: JSON error", e2);
        }
        return jSONObject;
    }
}
