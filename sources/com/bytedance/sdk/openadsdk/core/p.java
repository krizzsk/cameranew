package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.List;
import org.json.JSONObject;
/* compiled from: NetApi.java */
/* loaded from: classes.dex */
public interface p<T> {

    /* compiled from: NetApi.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, String str);

        void a(com.bytedance.sdk.openadsdk.core.d.a aVar);
    }

    /* compiled from: NetApi.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void a(q.b bVar);
    }

    com.bytedance.sdk.openadsdk.c.h a(List<T> list);

    com.bytedance.sdk.openadsdk.core.d.k a();

    JSONObject a(JSONObject jSONObject);

    void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.i iVar, int i2, a aVar);

    void a(com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list);

    void a(JSONObject jSONObject, b bVar);

    com.bytedance.sdk.openadsdk.c.h b(JSONObject jSONObject);
}
