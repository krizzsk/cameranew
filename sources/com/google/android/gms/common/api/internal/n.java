package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.g;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class n extends g.a {
    private final d<Status> a;

    public n(d<Status> dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.gms.common.api.internal.g
    public void N(Status status) {
        this.a.setResult(status);
    }
}
