package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* compiled from: OfferwallConfigurations.java */
/* loaded from: classes2.dex */
public class m {
    private ArrayList<n> a = new ArrayList<>();
    private n b;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f5619d;

    public m(d dVar) {
        this.c = dVar;
    }

    public void a(n nVar) {
        if (nVar != null) {
            this.a.add(nVar);
            if (this.b == null) {
                this.b = nVar;
            } else if (nVar.a() == 0) {
                this.b = nVar;
            }
        }
    }

    public String b() {
        JSONObject jSONObject = this.f5619d;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("adapterName"))) ? "SupersonicAds" : this.f5619d.optString("adapterName");
    }

    public d c() {
        return this.c;
    }

    public void d(JSONObject jSONObject) {
        this.f5619d = jSONObject;
    }
}
