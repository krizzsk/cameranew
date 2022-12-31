package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: StatsEventThread.java */
/* loaded from: classes.dex */
public class o extends g<c.a> {

    /* renamed from: l  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p<a> f1418l;

    public o(String str, String str2, e eVar, com.bytedance.sdk.openadsdk.core.p pVar, g.b bVar, g.a aVar) {
        super(str, str2, eVar, pVar, bVar, aVar);
        this.f1418l = com.bytedance.sdk.openadsdk.core.o.f();
    }

    @Override // com.bytedance.sdk.openadsdk.c.g
    public h a(List<c.a> list) {
        if (this.f1418l == null) {
            this.f1418l = com.bytedance.sdk.openadsdk.core.o.f();
        }
        if (list == null || list.size() == 0 || !com.bytedance.sdk.openadsdk.core.g.g.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (c.a aVar : list) {
                jSONArray.put(aVar.b);
            }
            jSONObject.put("stats_list", jSONArray);
        } catch (Exception unused) {
        }
        return this.f1418l.b(jSONObject);
    }
}
