package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
/* compiled from: ResultProcessor.java */
/* loaded from: classes.dex */
public abstract class i {
    private com.facebook.e a;

    public i(com.facebook.e eVar) {
        this.a = eVar;
    }

    public void a(com.facebook.internal.a aVar) {
        com.facebook.e eVar = this.a;
        if (eVar != null) {
            eVar.onCancel();
        }
    }

    public void b(com.facebook.internal.a aVar, FacebookException facebookException) {
        com.facebook.e eVar = this.a;
        if (eVar != null) {
            eVar.onError(facebookException);
        }
    }

    public abstract void c(com.facebook.internal.a aVar, Bundle bundle);
}
