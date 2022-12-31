package com.ironsource.mediationsdk.events;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IronbeastEventsFormatter.java */
/* loaded from: classes2.dex */
class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i2) {
        this.b = i2;
    }

    @Override // com.ironsource.mediationsdk.events.a
    public String c(ArrayList<d.e.b.b> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            this.a = new JSONObject();
        } else {
            this.a = jSONObject;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<d.e.b.b> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject b = b(it.next());
                    if (b != null) {
                        jSONArray.put(b);
                    }
                }
            }
            jSONObject2.put("table", "super.dwh.mediation_events");
            jSONObject2.put("data", a(jSONArray));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject2.toString();
    }

    @Override // com.ironsource.mediationsdk.events.a
    public String d() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    }

    @Override // com.ironsource.mediationsdk.events.a
    public String g() {
        return "ironbeast";
    }
}
