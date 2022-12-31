package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.Map;
import javax.annotation.Nullable;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public abstract class ii extends bz {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.bz
    @Nullable
    public Object a(bn bnVar) {
        bnVar.s();
        return null;
    }

    @Override // com.tapjoy.internal.ca
    public final String b() {
        return "POST";
    }

    @Override // com.tapjoy.internal.ca
    public final String d() {
        return HttpRequest.CONTENT_TYPE_JSON;
    }

    @Override // com.tapjoy.internal.ca
    public Map e() {
        Map e2 = super.e();
        gz a = gz.a();
        e2.put("sdk_ver", a.m + "/Android");
        e2.put(TapjoyConstants.TJC_API_KEY, a.f7601l);
        if (gw.a) {
            e2.put("debug", Boolean.TRUE);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.ca
    public Object f() {
        try {
            return super.f();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
