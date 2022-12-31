package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes2.dex */
public final class zzb {
    public static int zza = Runtime.getRuntime().availableProcessors();

    public static void zza(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void zzb(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    private static Purchase zzc(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return new Purchase(str, str2);
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Got JSONException while parsing purchase data: ");
                sb.append(valueOf);
                zzb("BillingHelper", sb.toString());
                return null;
            }
        }
        zzb("BillingHelper", "Received a bad purchase data.");
        return null;
    }

    public static int zza(Intent intent, String str) {
        return zzb(intent, str).getResponseCode();
    }

    @NonNull
    public static BillingResult zzb(Intent intent, String str) {
        if (intent == null) {
            zzb("BillingHelper", "Got null intent!");
            return BillingResult.newBuilder().setResponseCode(6).setDebugMessage("An internal error occurred.").build();
        }
        return BillingResult.newBuilder().setResponseCode(zza(intent.getExtras(), str)).setDebugMessage(zzb(intent.getExtras(), str)).build();
    }

    public static int zza(Bundle bundle, String str) {
        if (bundle == null) {
            zzb(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zza(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            String valueOf = String.valueOf(obj.getClass().getName());
            zzb(str, valueOf.length() != 0 ? "Unexpected type for bundle response code: ".concat(valueOf) : new String("Unexpected type for bundle response code: "));
            return 6;
        }
    }

    public static List<Purchase> zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList != null && stringArrayList2 != null) {
            for (int i2 = 0; i2 < stringArrayList.size() && i2 < stringArrayList2.size(); i2++) {
                Purchase zzc = zzc(stringArrayList.get(i2), stringArrayList2.get(i2));
                if (zzc != null) {
                    arrayList.add(zzc);
                }
            }
        } else {
            zzb("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
            Purchase zzc2 = zzc(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (zzc2 == null) {
                zzb("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(zzc2);
        }
        return arrayList;
    }

    @NonNull
    public static String zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzb(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zza(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            String valueOf = String.valueOf(obj.getClass().getName());
            zzb(str, valueOf.length() != 0 ? "Unexpected type for debug message: ".concat(valueOf) : new String("Unexpected type for debug message: "));
            return "";
        }
    }

    @NonNull
    public static Bundle zza(BillingFlowParams billingFlowParams, boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (billingFlowParams.getReplaceSkusProrationMode() != 0) {
            bundle.putInt(BillingFlowParams.EXTRA_PARAM_KEY_REPLACE_SKUS_PRORATION_MODE, billingFlowParams.getReplaceSkusProrationMode());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzb())) {
            bundle.putString(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, billingFlowParams.zzb());
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzd())) {
            bundle.putString("obfuscatedProfileId", billingFlowParams.zzd());
        }
        if (billingFlowParams.getVrPurchaseFlow()) {
            bundle.putBoolean(BillingFlowParams.EXTRA_PARAM_KEY_VR, true);
        }
        if (!TextUtils.isEmpty(billingFlowParams.getOldSku())) {
            bundle.putStringArrayList(BillingFlowParams.EXTRA_PARAM_KEY_OLD_SKUS, new ArrayList<>(Arrays.asList(billingFlowParams.getOldSku())));
        }
        if (!TextUtils.isEmpty(billingFlowParams.getOldSkuPurchaseToken())) {
            bundle.putString(BillingFlowParams.EXTRA_PARAM_KEY_OLD_SKU_PURCHASE_TOKEN, billingFlowParams.getOldSkuPurchaseToken());
        }
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    @NonNull
    public static Bundle zza(boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    @NonNull
    public static Bundle zza(boolean z, boolean z2, boolean z3, String str, @Nullable String str2) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        if (z && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z2 && str2 != null) {
            bundle.putString("SKU_PACKAGE_NAME", str2);
        }
        return bundle;
    }

    @NonNull
    public static Bundle zza(ConsumeParams consumeParams, boolean z, String str) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        return bundle;
    }

    @NonNull
    public static Bundle zza(AcknowledgePurchaseParams acknowledgePurchaseParams, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        return bundle;
    }
}
