package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.i;
/* compiled from: AuthFailureError.java */
/* loaded from: classes.dex */
public class a extends VAdError {
    private Intent a;

    public a() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public a(i iVar) {
        super(iVar);
    }
}
