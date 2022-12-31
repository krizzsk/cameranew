package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.a;
/* loaded from: classes2.dex */
abstract class zzj extends a.AbstractC0164a<Status> {
    public zzj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ g createFailedResult(Status status) {
        return status;
    }
}
