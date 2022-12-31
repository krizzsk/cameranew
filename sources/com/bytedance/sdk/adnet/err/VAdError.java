package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.i;
/* loaded from: classes.dex */
public class VAdError extends Exception {
    private long a;
    public final i networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.a;
    }

    public void setNetworkTimeMs(long j2) {
        this.a = j2;
    }

    public VAdError(i iVar) {
        this.networkResponse = iVar;
    }

    public VAdError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VAdError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VAdError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }
}
