package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class q implements e.a {
    private final /* synthetic */ BasePendingResult a;
    private final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(r rVar, BasePendingResult basePendingResult) {
        this.b = rVar;
        this.a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.e.a
    public final void a(Status status) {
        Map map;
        map = this.b.a;
        map.remove(this.a);
    }
}
