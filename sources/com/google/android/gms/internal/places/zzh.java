package com.google.android.gms.internal.places;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.places.d;
@Deprecated
/* loaded from: classes2.dex */
public final class zzh extends e<zzi> implements g {
    private final Status zzp;

    public zzh(DataHolder dataHolder) {
        this(dataHolder, d.b(dataHolder.R()));
    }

    @Override // com.google.android.gms.common.api.g
    public final Status getStatus() {
        return this.zzp;
    }

    private zzh(DataHolder dataHolder, Status status) {
        super(dataHolder, zzi.CREATOR);
        q.a(dataHolder == null || dataHolder.R() == status.R());
        this.zzp = status;
    }
}
