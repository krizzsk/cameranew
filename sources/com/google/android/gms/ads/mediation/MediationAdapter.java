package com.google.android.gms.ads.mediation;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zza {
        private int a;

        public final Bundle zzaes() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.a);
            return bundle;
        }

        public final zza zzdv(int i2) {
            this.a = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
