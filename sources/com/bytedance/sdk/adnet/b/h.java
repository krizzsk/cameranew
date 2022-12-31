package com.bytedance.sdk.adnet.b;

import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.m;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;
/* compiled from: JsonStringRequest.java */
/* loaded from: classes.dex */
public class h extends g<String> {
    public h(int i2, String str, @Nullable JSONObject jSONObject, @Nullable m.a<String> aVar) {
        super(i2, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    public m<String> a(com.bytedance.sdk.adnet.core.i iVar) {
        try {
            return m.a(new String(iVar.b, com.bytedance.sdk.adnet.d.b.a(iVar.c, "utf-8")), com.bytedance.sdk.adnet.d.b.a(iVar));
        } catch (UnsupportedEncodingException e2) {
            return m.a(new com.bytedance.sdk.adnet.err.e(e2));
        }
    }
}
