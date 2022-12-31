package com.tencent.mm.opensdk.diffdev.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
/* loaded from: classes3.dex */
public enum d {
    UUID_EXPIRED(TypedValues.CycleType.TYPE_VISIBILITY),
    UUID_CANCELED(TypedValues.CycleType.TYPE_ALPHA),
    UUID_SCANED(DeeplinkCallback.ERROR_LINK_NOT_EXIST),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(DeeplinkCallback.ERROR_TIMEOUT),
    UUID_ERROR(500);
    
    private int a;

    d(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}
