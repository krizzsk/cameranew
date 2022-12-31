package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzy extends ResultReceiver {
    private final /* synthetic */ PriceChangeConfirmationListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(BillingClientImpl billingClientImpl, Handler handler, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        super(handler);
        this.zza = priceChangeConfirmationListener;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i2, Bundle bundle) {
        this.zza.onPriceChangeConfirmationResult(BillingResult.newBuilder().setResponseCode(i2).setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient")).build());
    }
}
