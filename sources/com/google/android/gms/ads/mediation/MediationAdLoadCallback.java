package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT> {
    void onFailure(@NonNull AdError adError);

    @Deprecated
    void onFailure(String str);

    MediationAdCallbackT onSuccess(MediationAdT mediationadt);
}
