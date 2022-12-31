package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.android.billingclient.api.Purchase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public abstract class BillingClient {

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BillingResponseCode {
        public static final int BILLING_UNAVAILABLE = 3;
        public static final int DEVELOPER_ERROR = 5;
        public static final int ERROR = 6;
        public static final int FEATURE_NOT_SUPPORTED = -2;
        public static final int ITEM_ALREADY_OWNED = 7;
        public static final int ITEM_NOT_OWNED = 8;
        public static final int ITEM_UNAVAILABLE = 4;
        public static final int OK = 0;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_TIMEOUT = -3;
        public static final int SERVICE_UNAVAILABLE = 2;
        public static final int USER_CANCELED = 1;
    }

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zza;
        private final Context zzb;
        private PurchasesUpdatedListener zzc;

        private Builder(Context context) {
            this.zzb = context;
        }

        @UiThread
        public final BillingClient build() {
            Context context = this.zzb;
            if (context != null) {
                PurchasesUpdatedListener purchasesUpdatedListener = this.zzc;
                if (purchasesUpdatedListener != null) {
                    boolean z = this.zza;
                    if (z) {
                        return new BillingClientImpl(null, z, context, purchasesUpdatedListener);
                    }
                    throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        @UiThread
        public final Builder enablePendingPurchases() {
            this.zza = true;
            return this;
        }

        @UiThread
        public final Builder setListener(@NonNull PurchasesUpdatedListener purchasesUpdatedListener) {
            this.zzc = purchasesUpdatedListener;
            return this;
        }
    }

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FeatureType {
        public static final String IN_APP_ITEMS_ON_VR = "inAppItemsOnVr";
        public static final String PRICE_CHANGE_CONFIRMATION = "priceChangeConfirmation";
        public static final String SUBSCRIPTIONS = "subscriptions";
        public static final String SUBSCRIPTIONS_ON_VR = "subscriptionsOnVr";
        public static final String SUBSCRIPTIONS_UPDATE = "subscriptionsUpdate";
    }

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SkuType {
        public static final String INAPP = "inapp";
        public static final String SUBS = "subs";
    }

    @UiThread
    public static Builder newBuilder(@NonNull Context context) {
        return new Builder(context);
    }

    public abstract void acknowledgePurchase(@NonNull AcknowledgePurchaseParams acknowledgePurchaseParams, @NonNull AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener);

    public abstract void consumeAsync(@NonNull ConsumeParams consumeParams, @NonNull ConsumeResponseListener consumeResponseListener);

    @UiThread
    public abstract void endConnection();

    @UiThread
    public abstract BillingResult isFeatureSupported(@NonNull String str);

    @UiThread
    public abstract boolean isReady();

    @UiThread
    public abstract BillingResult launchBillingFlow(@NonNull Activity activity, @NonNull BillingFlowParams billingFlowParams);

    @UiThread
    public abstract void launchPriceChangeConfirmationFlow(@NonNull Activity activity, @NonNull PriceChangeFlowParams priceChangeFlowParams, @NonNull PriceChangeConfirmationListener priceChangeConfirmationListener);

    public abstract void queryPurchaseHistoryAsync(@NonNull String str, @NonNull PurchaseHistoryResponseListener purchaseHistoryResponseListener);

    public abstract Purchase.PurchasesResult queryPurchases(@NonNull String str);

    public abstract void querySkuDetailsAsync(@NonNull SkuDetailsParams skuDetailsParams, @NonNull SkuDetailsResponseListener skuDetailsResponseListener);

    @UiThread
    public abstract void startConnection(@NonNull BillingClientStateListener billingClientStateListener);
}
