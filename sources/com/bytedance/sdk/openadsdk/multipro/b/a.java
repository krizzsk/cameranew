package com.bytedance.sdk.openadsdk.multipro.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONObject;
/* compiled from: VideoControllerDataModel.java */
/* loaded from: classes.dex */
public class a {
    public boolean a;
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2093d;

    /* renamed from: e  reason: collision with root package name */
    public long f2094e;

    /* renamed from: f  reason: collision with root package name */
    public long f2095f;

    /* renamed from: g  reason: collision with root package name */
    public long f2096g;

    /* compiled from: VideoControllerDataModel.java */
    /* renamed from: com.bytedance.sdk.openadsdk.multipro.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        a a();
    }

    public a a(boolean z) {
        this.f2093d = z;
        return this;
    }

    public a b(boolean z) {
        this.a = z;
        return this;
    }

    public a c(boolean z) {
        this.b = z;
        return this;
    }

    public a d(boolean z) {
        this.c = z;
        return this;
    }

    public a a(long j2) {
        this.f2094e = j2;
        return this;
    }

    public a b(long j2) {
        this.f2095f = j2;
        return this;
    }

    public a c(long j2) {
        this.f2096g = j2;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.a);
            jSONObject.put("isFromVideoDetailPage", this.b);
            jSONObject.put("isFromDetailPage", this.c);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, this.f2094e);
            jSONObject.put("totalPlayDuration", this.f2095f);
            jSONObject.put("currentPlayPosition", this.f2096g);
            jSONObject.put("isAutoPlay", this.f2093d);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.b(jSONObject.optBoolean("isCompleted"));
        aVar.c(jSONObject.optBoolean("isFromVideoDetailPage"));
        aVar.d(jSONObject.optBoolean("isFromDetailPage"));
        aVar.a(jSONObject.optLong(TypedValues.TransitionType.S_DURATION));
        aVar.b(jSONObject.optLong("totalPlayDuration"));
        aVar.c(jSONObject.optLong("currentPlayPosition"));
        aVar.a(jSONObject.optBoolean("isAutoPlay"));
        return aVar;
    }
}
