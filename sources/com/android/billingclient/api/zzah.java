package com.android.billingclient.api;

import java.util.Collections;
import java.util.List;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzah implements AcknowledgePurchaseResponseListener, BillingClientStateListener, ConsumeResponseListener, PriceChangeConfirmationListener, PurchaseHistoryResponseListener, PurchasesUpdatedListener, SkuDetailsResponseListener {
    private final long zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah() {
        this.zza = 0L;
    }

    public static native void nativeOnAcknowledgePurchaseResponse(int i2, String str, long j2);

    public static native void nativeOnBillingServiceDisconnected();

    public static native void nativeOnBillingSetupFinished(int i2, String str, long j2);

    public static native void nativeOnConsumePurchaseResponse(int i2, String str, String str2, long j2);

    public static native void nativeOnPriceChangeConfirmationResult(int i2, String str, long j2);

    public static native void nativeOnPurchaseHistoryResponse(int i2, String str, PurchaseHistoryRecord[] purchaseHistoryRecordArr, long j2);

    public static native void nativeOnPurchasesUpdated(int i2, String str, Purchase[] purchaseArr);

    public static native void nativeOnQueryPurchasesResponse(int i2, String str, Purchase[] purchaseArr, long j2);

    public static native void nativeOnSkuDetailsResponse(int i2, String str, SkuDetails[] skuDetailsArr, long j2);

    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        nativeOnAcknowledgePurchaseResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), this.zza);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        nativeOnBillingServiceDisconnected();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult) {
        nativeOnBillingSetupFinished(billingResult.getResponseCode(), billingResult.getDebugMessage(), this.zza);
    }

    @Override // com.android.billingclient.api.ConsumeResponseListener
    public final void onConsumeResponse(BillingResult billingResult, String str) {
        nativeOnConsumePurchaseResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), str, this.zza);
    }

    @Override // com.android.billingclient.api.PriceChangeConfirmationListener
    public final void onPriceChangeConfirmationResult(BillingResult billingResult) {
        nativeOnPriceChangeConfirmationResult(billingResult.getResponseCode(), billingResult.getDebugMessage(), this.zza);
    }

    @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
    public final void onPurchaseHistoryResponse(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnPurchaseHistoryResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), (PurchaseHistoryRecord[]) list.toArray(new PurchaseHistoryRecord[list.size()]), this.zza);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public final void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnPurchasesUpdated(billingResult.getResponseCode(), billingResult.getDebugMessage(), (Purchase[]) list.toArray(new Purchase[list.size()]));
    }

    @Override // com.android.billingclient.api.SkuDetailsResponseListener
    public final void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnSkuDetailsResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), (SkuDetails[]) list.toArray(new SkuDetails[list.size()]), this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(long j2) {
        this.zza = j2;
    }
}
