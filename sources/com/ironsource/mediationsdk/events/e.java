package com.ironsource.mediationsdk.events;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: OutcomeEventsFormatter.java */
/* loaded from: classes2.dex */
class e extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i2) {
        this.b = i2;
    }

    @Override // com.ironsource.mediationsdk.events.a
    public String c(ArrayList<d.e.b.b> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.a = new JSONObject();
        } else {
            this.a = jSONObject;
        }
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
        return a(jSONArray);
    }

    @Override // com.ironsource.mediationsdk.events.a
    public String d() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";
    }

    @Override // com.ironsource.mediationsdk.events.a
    public String g() {
        return "outcome";
    }
}
