package com.android.billingclient.api;

import android.os.Bundle;
import java.util.ArrayList;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
final class zzam {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static BillingResult zza(Bundle bundle, String str, String str2) {
        BillingResult billingResult = zzak.zzl;
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzb.zzb(str, String.format("%s got null owned items list", str2));
            return billingResult;
        }
        int zza = com.google.android.gms.internal.play_billing.zzb.zza(bundle, str);
        BillingResult build = BillingResult.newBuilder().setResponseCode(zza).setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzb(bundle, str)).build();
        if (zza != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzb(str, String.format("%s failed. Response code: %s", str2, Integer.valueOf(zza)));
            return build;
        } else if (bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if (stringArrayList == null) {
                com.google.android.gms.internal.play_billing.zzb.zzb(str, String.format("Bundle returned from %s contains null SKUs list.", str2));
                return billingResult;
            } else if (stringArrayList2 == null) {
                com.google.android.gms.internal.play_billing.zzb.zzb(str, String.format("Bundle returned from %s contains null purchases list.", str2));
                return billingResult;
            } else if (stringArrayList3 == null) {
                com.google.android.gms.internal.play_billing.zzb.zzb(str, String.format("Bundle returned from %s contains null signatures list.", str2));
                return billingResult;
            } else {
                return zzak.zzn;
            }
        } else {
            com.google.android.gms.internal.play_billing.zzb.zzb(str, String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return billingResult;
        }
    }
}
