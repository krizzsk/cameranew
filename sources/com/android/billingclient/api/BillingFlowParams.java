package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.zzb;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class BillingFlowParams {
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    public static final String EXTRA_PARAM_KEY_OLD_SKUS = "skusToReplace";
    public static final String EXTRA_PARAM_KEY_OLD_SKU_PURCHASE_TOKEN = "oldSkuPurchaseToken";
    public static final String EXTRA_PARAM_KEY_REPLACE_SKUS_PRORATION_MODE = "prorationMode";
    public static final String EXTRA_PARAM_KEY_VR = "vr";
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private int zzf;
    private ArrayList<SkuDetails> zzg;
    private boolean zzh;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private String zza;
        private String zzb;
        private String zzc;
        private String zzd;
        private int zze;
        private ArrayList<SkuDetails> zzf;
        private boolean zzg;

        private Builder() {
            this.zze = 0;
        }

        public BillingFlowParams build() {
            ArrayList<SkuDetails> arrayList = this.zzf;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList<SkuDetails> arrayList2 = this.zzf;
                int size = arrayList2.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    SkuDetails skuDetails = arrayList2.get(i3);
                    i3++;
                    if (skuDetails == null) {
                        throw new IllegalArgumentException("SKU cannot be null.");
                    }
                }
                if (this.zzf.size() > 1) {
                    SkuDetails skuDetails2 = this.zzf.get(0);
                    String type = skuDetails2.getType();
                    ArrayList<SkuDetails> arrayList3 = this.zzf;
                    int size2 = arrayList3.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        SkuDetails skuDetails3 = arrayList3.get(i4);
                        i4++;
                        if (!type.equals(skuDetails3.getType())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String zza = skuDetails2.zza();
                    if (TextUtils.isEmpty(zza)) {
                        ArrayList<SkuDetails> arrayList4 = this.zzf;
                        int size3 = arrayList4.size();
                        while (i2 < size3) {
                            SkuDetails skuDetails4 = arrayList4.get(i2);
                            i2++;
                            if (!TextUtils.isEmpty(skuDetails4.zza())) {
                                throw new IllegalArgumentException("All SKUs must have the same package name.");
                            }
                        }
                    } else {
                        ArrayList<SkuDetails> arrayList5 = this.zzf;
                        int size4 = arrayList5.size();
                        while (i2 < size4) {
                            SkuDetails skuDetails5 = arrayList5.get(i2);
                            i2++;
                            if (!zza.equals(skuDetails5.zza())) {
                                throw new IllegalArgumentException("All SKUs must have the same package name.");
                            }
                        }
                    }
                }
                BillingFlowParams billingFlowParams = new BillingFlowParams();
                billingFlowParams.zza = null;
                billingFlowParams.zzb = this.zza;
                billingFlowParams.zze = this.zzd;
                billingFlowParams.zzc = this.zzb;
                billingFlowParams.zzd = this.zzc;
                billingFlowParams.zzf = this.zze;
                billingFlowParams.zzg = this.zzf;
                billingFlowParams.zzh = this.zzg;
                return billingFlowParams;
            }
            throw new IllegalArgumentException("SkuDetails must be provided.");
        }

        public Builder setObfuscatedAccountId(@NonNull String str) {
            this.zza = str;
            return this;
        }

        public Builder setObfuscatedProfileId(@NonNull String str) {
            this.zzd = str;
            return this;
        }

        public Builder setOldSku(@NonNull String str, @NonNull String str2) {
            this.zzb = str;
            this.zzc = str2;
            return this;
        }

        public Builder setReplaceSkusProrationMode(int i2) {
            this.zze = i2;
            return this;
        }

        public Builder setSkuDetails(@NonNull SkuDetails skuDetails) {
            ArrayList<SkuDetails> arrayList = new ArrayList<>();
            arrayList.add(skuDetails);
            this.zzf = arrayList;
            return this;
        }

        public Builder setVrPurchaseFlow(boolean z) {
            this.zzg = z;
            return this;
        }
    }

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ProrationMode {
        public static final int DEFERRED = 4;
        public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
        public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
        public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
        public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;
    }

    private BillingFlowParams() {
        this.zzf = 0;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Nullable
    public String getOldSku() {
        return this.zzc;
    }

    @Nullable
    public String getOldSkuPurchaseToken() {
        return this.zzd;
    }

    public int getReplaceSkusProrationMode() {
        return this.zzf;
    }

    @zzb.zza
    public String getSku() {
        return this.zzg.get(0).getSku();
    }

    @zzb.zza
    public SkuDetails getSkuDetails() {
        return this.zzg.get(0);
    }

    @zzb.zza
    public String getSkuType() {
        return this.zzg.get(0).getType();
    }

    public boolean getVrPurchaseFlow() {
        return this.zzh;
    }

    public final ArrayList<SkuDetails> zza() {
        ArrayList<SkuDetails> arrayList = new ArrayList<>();
        arrayList.addAll(this.zzg);
        return arrayList;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc() {
        boolean z;
        ArrayList<SkuDetails> arrayList = this.zzg;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = true;
                break;
            }
            SkuDetails skuDetails = arrayList.get(i2);
            i2++;
            if (skuDetails.zza().isEmpty()) {
                z = false;
                break;
            }
        }
        return (!this.zzh && this.zzb == null && this.zza == null && this.zze == null && this.zzf == 0 && !z) ? false : true;
    }

    @Nullable
    public final String zzd() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zze() {
        return this.zza;
    }
}
