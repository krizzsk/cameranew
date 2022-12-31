package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class BillingClientImpl extends BillingClient {
    private int zza;
    private final String zzb;
    private final Handler zzc;
    private zzd zzd;
    private Context zze;
    private Context zzf;
    private com.google.android.gms.internal.play_billing.zza zzg;
    private zza zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private ExecutorService zzr;
    @Nullable
    private String zzs;
    private final ResultReceiver zzt;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static class zzb {
        private final List<PurchaseHistoryRecord> zza;
        private final BillingResult zzb;

        zzb(BillingResult billingResult, @Nullable List<PurchaseHistoryRecord> list) {
            this.zza = list;
            this.zzb = billingResult;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public final BillingResult zza() {
            return this.zzb;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final List<PurchaseHistoryRecord> zzb() {
            return this.zza;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public BillingClientImpl(@Nullable String str, boolean z, @NonNull Context context, @NonNull PurchasesUpdatedListener purchasesUpdatedListener) {
        this(context, z, purchasesUpdatedListener, zza(), null);
    }

    private void initialize(@NonNull Context context, @NonNull PurchasesUpdatedListener purchasesUpdatedListener, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.zzf = applicationContext;
        this.zzd = new zzd(applicationContext, purchasesUpdatedListener);
        this.zze = context;
        this.zzq = z;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, long j2) {
        launchPriceChangeConfirmationFlow(activity, priceChangeFlowParams, new zzah(j2));
    }

    private static String zza() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    private final BillingResult zzb(String str) {
        try {
            if (((Integer) zza(new zzu(this, str), 5000L, (Runnable) null).get(5000L, TimeUnit.MILLISECONDS)).intValue() == 0) {
                return zzak.zzn;
            }
            return zzak.zzi;
        } catch (Exception unused) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Exception while checking if billing is supported; try to reconnect");
            return zzak.zzo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Purchase.PurchasesResult zzc(String str) {
        Bundle zza2;
        String valueOf = String.valueOf(str);
        com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf.length() != 0 ? "Querying owned items, item type: ".concat(valueOf) : new String("Querying owned items, item type: "));
        ArrayList arrayList = new ArrayList();
        Bundle zza3 = com.google.android.gms.internal.play_billing.zzb.zza(this.zzm, this.zzq, this.zzb);
        String str2 = null;
        do {
            try {
                if (this.zzm) {
                    zza2 = this.zzg.zzc(9, this.zzf.getPackageName(), str, str2, zza3);
                } else {
                    zza2 = this.zzg.zza(3, this.zzf.getPackageName(), str, str2);
                }
                BillingResult zza4 = zzam.zza(zza2, "BillingClient", "getPurchase()");
                if (zza4 != zzak.zzn) {
                    return new Purchase.PurchasesResult(zza4, null);
                }
                ArrayList<String> stringArrayList = zza2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zza2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zza2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    String valueOf2 = String.valueOf(stringArrayList.get(i2));
                    com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf2.length() != 0 ? "Sku is owned: ".concat(valueOf2) : new String("Sku is owned: "));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e2) {
                        String valueOf3 = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 48);
                        sb.append("Got an exception trying to decode the purchase: ");
                        sb.append(valueOf3);
                        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
                        return new Purchase.PurchasesResult(zzak.zzl, null);
                    }
                }
                str2 = zza2.getString("INAPP_CONTINUATION_TOKEN");
                String valueOf4 = String.valueOf(str2);
                com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
            } catch (Exception e3) {
                String valueOf5 = String.valueOf(e3);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf5).length() + 57);
                sb2.append("Got exception trying to get purchases: ");
                sb2.append(valueOf5);
                sb2.append("; try to reconnect");
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb2.toString());
                return new Purchase.PurchasesResult(zzak.zzo, null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new Purchase.PurchasesResult(zzak.zzn, arrayList);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzak.zzo);
        } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Please provide a valid purchase token.");
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzak.zzk);
        } else if (!this.zzm) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzak.zzb);
        } else if (zza(new zzo(this, acknowledgePurchaseParams, acknowledgePurchaseResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzt(this, acknowledgePurchaseResponseListener)) == null) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzc());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            consumeResponseListener.onConsumeResponse(zzak.zzo, consumeParams.getPurchaseToken());
        } else if (zza(new zzl(this, consumeParams, consumeResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzk(this, consumeResponseListener, consumeParams)) == null) {
            consumeResponseListener.onConsumeResponse(zzc(), consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        try {
            this.zzd.zzc();
            zza zzaVar = this.zzh;
            if (zzaVar != null) {
                zzaVar.zza();
            }
            if (this.zzh != null && this.zzg != null) {
                com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", "Unbinding from service.");
                this.zzf.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            ExecutorService executorService = this.zzr;
            if (executorService != null) {
                executorService.shutdownNow();
                this.zzr = null;
            }
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("There was an exception while ending connection: ");
            sb.append(valueOf);
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    @NonNull
    public BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            return zzak.zzo;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c = 0;
                    break;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c = 1;
                    break;
                }
                break;
            case 292218239:
                if (str.equals(BillingClient.FeatureType.IN_APP_ITEMS_ON_VR)) {
                    c = 2;
                    break;
                }
                break;
            case 1219490065:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_ON_VR)) {
                    c = 3;
                    break;
                }
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.zzj) {
                    return zzak.zzn;
                }
                return zzak.zzi;
            case 1:
                return this.zzl ? zzak.zzn : zzak.zzi;
            case 2:
                return zzb(BillingClient.SkuType.INAPP);
            case 3:
                return zzb("subs");
            case 4:
                return this.zzi ? zzak.zzn : zzak.zzi;
            default:
                String valueOf = String.valueOf(str);
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", valueOf.length() != 0 ? "Unsupported feature: ".concat(valueOf) : new String("Unsupported feature: "));
                return zzak.zzs;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    @Override // com.android.billingclient.api.BillingClient
    @NonNull
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        long j2;
        Future zza2;
        int i2;
        if (!isReady()) {
            return zza(zzak.zzo);
        }
        ArrayList<SkuDetails> zza3 = billingFlowParams.zza();
        SkuDetails skuDetails = zza3.get(0);
        String type = skuDetails.getType();
        if (type.equals("subs") && !this.zzi) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Current client doesn't support subscriptions.");
            return zza(zzak.zzq);
        }
        boolean z = billingFlowParams.getOldSku() != null;
        if (z && !this.zzj) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Current client doesn't support subscriptions update.");
            return zza(zzak.zzr);
        } else if (billingFlowParams.zzc() && !this.zzk) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Current client doesn't support extra params for buy intent.");
            return zza(zzak.zzh);
        } else {
            String str = "";
            for (int i3 = 0; i3 < zza3.size(); i3++) {
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zza3.get(i3));
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
                sb.append(valueOf);
                sb.append(valueOf2);
                str = sb.toString();
                if (i3 < zza3.size() - 1) {
                    str = String.valueOf(str).concat(", ");
                }
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 41 + String.valueOf(type).length());
            sb2.append("Constructing buy intent for ");
            sb2.append(str);
            sb2.append(", item type: ");
            sb2.append(type);
            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", sb2.toString());
            if (this.zzk) {
                Bundle zza4 = com.google.android.gms.internal.play_billing.zzb.zza(billingFlowParams, this.zzm, this.zzq, this.zzb);
                if (!skuDetails.zzb().isEmpty()) {
                    zza4.putString("skuDetailsToken", skuDetails.zzb());
                }
                if (!TextUtils.isEmpty(skuDetails.zza())) {
                    zza4.putString("skuPackageName", skuDetails.zza());
                }
                if (!TextUtils.isEmpty(this.zzs)) {
                    zza4.putString("accountName", this.zzs);
                }
                if (zza3.size() > 1) {
                    ArrayList<String> arrayList = new ArrayList<>(zza3.size() - 1);
                    for (int i4 = 1; i4 < zza3.size(); i4++) {
                        arrayList.add(zza3.get(i4).getSku());
                    }
                    zza4.putStringArrayList("additionalSkus", arrayList);
                }
                if (this.zzm) {
                    i2 = 9;
                } else {
                    i2 = billingFlowParams.getVrPurchaseFlow() ? 7 : 6;
                }
                zza2 = zza(new zzab(this, i2, skuDetails, type, billingFlowParams, zza4), 5000L, (Runnable) null);
                j2 = 5000;
            } else {
                j2 = 5000;
                if (z) {
                    zza2 = zza(new zzaa(this, billingFlowParams, skuDetails), 5000L, (Runnable) null);
                } else {
                    zza2 = zza(new zzad(this, skuDetails, type), 5000L, (Runnable) null);
                }
            }
            try {
                Bundle bundle = (Bundle) zza2.get(j2, TimeUnit.MILLISECONDS);
                int zza5 = com.google.android.gms.internal.play_billing.zzb.zza(bundle, "BillingClient");
                String zzb2 = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
                if (zza5 != 0) {
                    StringBuilder sb3 = new StringBuilder(52);
                    sb3.append("Unable to buy item, Error response code: ");
                    sb3.append(zza5);
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb3.toString());
                    return zza(BillingResult.newBuilder().setResponseCode(zza5).setDebugMessage(zzb2).build());
                }
                Intent intent = new Intent(activity, ProxyBillingActivity.class);
                intent.putExtra("result_receiver", this.zzt);
                intent.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                activity.startActivity(intent);
                return zzak.zzn;
            } catch (CancellationException | TimeoutException unused) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 68);
                sb4.append("Time out while launching billing flow: ; for sku: ");
                sb4.append(str);
                sb4.append("; try to reconnect");
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb4.toString());
                return zza(zzak.zzp);
            } catch (Exception unused2) {
                StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 69);
                sb5.append("Exception while launching billing flow: ; for sku: ");
                sb5.append(str);
                sb5.append("; try to reconnect");
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb5.toString());
                return zza(zzak.zzo);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzak.zzo, null);
        } else if (zza(new zzn(this, str, purchaseHistoryResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzp(this, purchaseHistoryResponseListener)) == null) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzc(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    @NonNull
    public Purchase.PurchasesResult queryPurchases(String str) {
        if (!isReady()) {
            return new Purchase.PurchasesResult(zzak.zzo, null);
        }
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Please provide a valid SKU type.");
            return new Purchase.PurchasesResult(zzak.zzg, null);
        }
        try {
            return (Purchase.PurchasesResult) zza(new zzac(this, str), 5000L, (Runnable) null).get(5000L, TimeUnit.MILLISECONDS);
        } catch (CancellationException | TimeoutException unused) {
            return new Purchase.PurchasesResult(zzak.zzp, null);
        } catch (Exception unused2) {
            return new Purchase.PurchasesResult(zzak.zzl, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zzo, null);
            return;
        }
        String skuType = skuDetailsParams.getSkuType();
        List<String> skusList = skuDetailsParams.getSkusList();
        String zza2 = skuDetailsParams.zza();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Please fix the input params. SKU type can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zzg, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zzf, null);
        } else if (!this.zzp && zza2 != null) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "The user's client is too old to handle skuPackageName from SkuDetails.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzak.zze, null);
        } else if (zza(new zzg(this, skuType, skusList, zza2, skuDetailsResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzi(this, skuDetailsResponseListener)) == null) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzc(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(@NonNull BillingClientStateListener billingClientStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzn);
            return;
        }
        int i2 = this.zza;
        if (i2 == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Client is already in the process of connecting to billing service.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzd);
        } else if (i2 == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzo);
        } else {
            this.zza = 1;
            this.zzd.zza();
            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", "Starting in-app billing setup.");
            this.zzh = new zza(this, billingClientStateListener, null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if ("com.android.vending".equals(str) && str2 != null) {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zzf.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Connection to Billing service is blocked.");
                } else {
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "The device doesn't have valid Play Store.");
                }
            }
            this.zza = 0;
            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", "Billing service unavailable on device.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzc);
        }
    }

    private BillingClientImpl(Activity activity, boolean z, String str) {
        this(activity.getApplicationContext(), z, new zzah(), str, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, @NonNull PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (!isReady()) {
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzo);
        } else if (priceChangeFlowParams != null && priceChangeFlowParams.getSkuDetails() != null) {
            String sku = priceChangeFlowParams.getSkuDetails().getSku();
            if (sku == null) {
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
                priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzm);
            } else if (!this.zzl) {
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Current client doesn't support price change confirmation flow.");
                priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzi);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("playBillingLibraryVersion", this.zzb);
                bundle.putBoolean("subs_price_change", true);
                try {
                    Bundle bundle2 = (Bundle) zza(new zzv(this, sku, bundle), 5000L, (Runnable) null).get(5000L, TimeUnit.MILLISECONDS);
                    int zza2 = com.google.android.gms.internal.play_billing.zzb.zza(bundle2, "BillingClient");
                    BillingResult build = BillingResult.newBuilder().setResponseCode(zza2).setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzb(bundle2, "BillingClient")).build();
                    if (zza2 != 0) {
                        StringBuilder sb = new StringBuilder(68);
                        sb.append("Unable to launch price change flow, error response code: ");
                        sb.append(zza2);
                        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
                        priceChangeConfirmationListener.onPriceChangeConfirmationResult(build);
                        return;
                    }
                    zzy zzyVar = new zzy(this, this.zzc, priceChangeConfirmationListener);
                    Intent intent = new Intent(activity, ProxyBillingActivity.class);
                    intent.putExtra("SUBS_MANAGEMENT_INTENT", (PendingIntent) bundle2.getParcelable("SUBS_MANAGEMENT_INTENT"));
                    intent.putExtra("result_receiver", zzyVar);
                    activity.startActivity(intent);
                } catch (CancellationException | TimeoutException unused) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(sku).length() + 70);
                    sb2.append("Time out while launching Price Change Flow for sku: ");
                    sb2.append(sku);
                    sb2.append("; try to reconnect");
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb2.toString());
                    priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzp);
                } catch (Exception unused2) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(sku).length() + 78);
                    sb3.append("Exception caught while launching Price Change Flow for sku: ");
                    sb3.append(sku);
                    sb3.append("; try to reconnect");
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb3.toString());
                    priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzo);
                }
            }
        } else {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(zzak.zzm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public final class zza implements ServiceConnection {
        private final Object zzb;
        private boolean zzc;
        private BillingClientStateListener zzd;

        private zza(@NonNull BillingClientStateListener billingClientStateListener) {
            this.zzb = new Object();
            this.zzc = false;
            this.zzd = billingClientStateListener;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", "Billing service connected.");
            BillingClientImpl.this.zzg = com.google.android.gms.internal.play_billing.zzd.zza(iBinder);
            if (BillingClientImpl.this.zza(new zzag(this), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzaf(this)) == null) {
                zza(BillingClientImpl.this.zzc());
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Billing service disconnected.");
            BillingClientImpl.this.zzg = null;
            BillingClientImpl.this.zza = 0;
            synchronized (this.zzb) {
                BillingClientStateListener billingClientStateListener = this.zzd;
                if (billingClientStateListener != null) {
                    billingClientStateListener.onBillingServiceDisconnected();
                }
            }
        }

        final void zza() {
            synchronized (this.zzb) {
                this.zzd = null;
                this.zzc = true;
            }
        }

        /* synthetic */ zza(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzh zzhVar) {
            this(billingClientStateListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(BillingResult billingResult) {
            BillingClientImpl.this.zza(new zzae(this, billingResult));
        }
    }

    private BillingClientImpl(@NonNull Context context, boolean z, @NonNull PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2) {
        this.zza = 0;
        Handler handler = new Handler(Looper.getMainLooper());
        this.zzc = handler;
        this.zzt = new zzh(this, handler);
        this.zzs = str2;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, z);
    }

    private final BillingResult zza(BillingResult billingResult) {
        this.zzd.zzb().onPurchasesUpdated(billingResult, null);
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzb zza(String str) {
        String valueOf = String.valueOf(str);
        com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf.length() != 0 ? "Querying purchase history, item type: ".concat(valueOf) : new String("Querying purchase history, item type: "));
        ArrayList arrayList = new ArrayList();
        Bundle zza2 = com.google.android.gms.internal.play_billing.zzb.zza(this.zzm, this.zzq, this.zzb);
        String str2 = null;
        while (this.zzk) {
            try {
                Bundle zza3 = this.zzg.zza(6, this.zzf.getPackageName(), str, str2, zza2);
                BillingResult zza4 = zzam.zza(zza3, "BillingClient", "getPurchaseHistory()");
                if (zza4 != zzak.zzn) {
                    return new zzb(zza4, null);
                }
                ArrayList<String> stringArrayList = zza3.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zza3.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zza3.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    String valueOf2 = String.valueOf(stringArrayList.get(i2));
                    com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf2.length() != 0 ? "Purchase record found for sku : ".concat(valueOf2) : new String("Purchase record found for sku : "));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e2) {
                        String valueOf3 = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 48);
                        sb.append("Got an exception trying to decode the purchase: ");
                        sb.append(valueOf3);
                        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
                        return new zzb(zzak.zzl, null);
                    }
                }
                str2 = zza3.getString("INAPP_CONTINUATION_TOKEN");
                String valueOf4 = String.valueOf(str2);
                com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
                if (TextUtils.isEmpty(str2)) {
                    return new zzb(zzak.zzn, arrayList);
                }
            } catch (RemoteException e3) {
                String valueOf5 = String.valueOf(e3);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf5).length() + 64);
                sb2.append("Got exception trying to get purchase history: ");
                sb2.append(valueOf5);
                sb2.append("; try to reconnect");
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb2.toString());
                return new zzb(zzak.zzo, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzb(zzak.zzj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle zzb() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(BillingFlowParams.EXTRA_PARAM_KEY_VR, true);
        return bundle;
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        Handler handler = new Handler(Looper.getMainLooper());
        this.zzc = handler;
        this.zzt = new zzh(this, handler);
        this.zzb = str;
    }

    private void startConnection(long j2) {
        startConnection(new zzah(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzc() {
        int i2 = this.zza;
        if (i2 != 0 && i2 != 3) {
            return zzak.zzl;
        }
        return zzak.zzo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final <T> Future<T> zza(@NonNull Callable<T> callable, long j2, @Nullable Runnable runnable) {
        long j3 = (long) (j2 * 0.95d);
        if (this.zzr == null) {
            this.zzr = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza);
        }
        try {
            Future<T> submit = this.zzr.submit(callable);
            this.zzc.postDelayed(new zzs(this, submit, runnable), j3);
            return submit;
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("Async task throws exception ");
            sb.append(valueOf);
            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SkuDetails.zza zza(String str, List<String> list, @Nullable String str2) {
        Bundle zza2;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i2, i3 > size ? size : i3));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzn) {
                    zza2 = this.zzg.zza(10, this.zzf.getPackageName(), str, bundle, com.google.android.gms.internal.play_billing.zzb.zza(this.zzm, this.zzp, this.zzq, this.zzb, str2));
                } else {
                    zza2 = this.zzg.zza(3, this.zzf.getPackageName(), str, bundle);
                }
                if (zza2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "querySkuDetailsAsync got null sku details list");
                    return new SkuDetails.zza(4, "Null sku details list", null);
                } else if (!zza2.containsKey("DETAILS_LIST")) {
                    int zza3 = com.google.android.gms.internal.play_billing.zzb.zza(zza2, "BillingClient");
                    String zzb2 = com.google.android.gms.internal.play_billing.zzb.zzb(zza2, "BillingClient");
                    if (zza3 != 0) {
                        StringBuilder sb = new StringBuilder(50);
                        sb.append("getSkuDetails() failed. Response code: ");
                        sb.append(zza3);
                        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb.toString());
                        return new SkuDetails.zza(zza3, zzb2, arrayList);
                    }
                    com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return new SkuDetails.zza(6, zzb2, arrayList);
                } else {
                    ArrayList<String> stringArrayList = zza2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "querySkuDetailsAsync got null response list");
                        return new SkuDetails.zza(4, "querySkuDetailsAsync got null response list", null);
                    }
                    for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                        try {
                            SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                            String valueOf = String.valueOf(skuDetails);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 17);
                            sb2.append("Got sku details: ");
                            sb2.append(valueOf);
                            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", sb2.toString());
                            arrayList.add(skuDetails);
                        } catch (JSONException unused) {
                            com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                            return new SkuDetails.zza(6, "Error trying to decode SkuDetails.", null);
                        }
                    }
                    i2 = i3;
                }
            } catch (Exception e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb3 = new StringBuilder("querySkuDetailsAsync got a remote exception (try to reconnect).".length() + String.valueOf(valueOf2).length());
                sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                sb3.append(valueOf2);
                com.google.android.gms.internal.play_billing.zzb.zzb("BillingClient", sb3.toString());
                return new SkuDetails.zza(-1, "Service connection is disconnected.", null);
            }
        }
        return new SkuDetails.zza(0, "", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Runnable runnable) {
        if (Thread.interrupted()) {
            return;
        }
        this.zzc.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zza(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        int zzb2;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            String valueOf = String.valueOf(purchaseToken);
            com.google.android.gms.internal.play_billing.zzb.zza("BillingClient", valueOf.length() != 0 ? "Consuming purchase with token: ".concat(valueOf) : new String("Consuming purchase with token: "));
            if (this.zzm) {
                Bundle zzc = this.zzg.zzc(9, this.zzf.getPackageName(), purchaseToken, com.google.android.gms.internal.play_billing.zzb.zza(consumeParams, this.zzm, this.zzb));
                int i2 = zzc.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zzb.zzb(zzc, "BillingClient");
                zzb2 = i2;
            } else {
                zzb2 = this.zzg.zzb(3, this.zzf.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult build = BillingResult.newBuilder().setResponseCode(zzb2).setDebugMessage(str).build();
            if (zzb2 == 0) {
                zza(new zzx(this, consumeResponseListener, build, purchaseToken));
            } else {
                zza(new zzw(this, zzb2, consumeResponseListener, build, purchaseToken));
            }
        } catch (Exception e2) {
            zza(new zzz(this, e2, consumeResponseListener, purchaseToken));
        }
    }
}
