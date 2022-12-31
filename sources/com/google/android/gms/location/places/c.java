package com.google.android.gms.location.places;

import com.google.android.gms.common.data.DataHolder;
@Deprecated
/* loaded from: classes2.dex */
public class c extends com.google.android.gms.common.data.a<b> {
    public c(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.a, com.google.android.gms.common.data.b
    /* renamed from: j */
    public b get(int i2) {
        return new com.google.android.gms.location.places.internal.e(this.mDataHolder, i2);
    }
}
