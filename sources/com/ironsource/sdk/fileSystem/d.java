package com.ironsource.sdk.fileSystem;

import org.json.JSONObject;
/* compiled from: StorageConfigurations.java */
/* loaded from: classes2.dex */
public class d {
    private JSONObject a;

    public d(JSONObject jSONObject) {
        this.a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public boolean a() {
        return this.a.optBoolean("deleteCacheDir", false);
    }

    public boolean b() {
        return this.a.optBoolean("deleteFilesDir", false);
    }

    public boolean c() {
        return this.a.optBoolean("useCacheDir", false);
    }
}
