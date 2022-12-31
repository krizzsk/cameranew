package com.ironsource.mediationsdk;

import android.app.Activity;
/* loaded from: classes2.dex */
public abstract class IronSource {

    /* loaded from: classes2.dex */
    public enum AD_UNIT {
        REWARDED_VIDEO("rewardedVideo"),
        INTERSTITIAL("interstitial"),
        OFFERWALL("offerwall"),
        BANNER("banner");
        
        private String mValue;

        AD_UNIT(String str) {
            this.mValue = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }

    public static void a(Activity activity, String str, AD_UNIT... ad_unitArr) {
        IronSourceObject.getInstance().D(activity, str, false, null, ad_unitArr);
    }

    public static boolean b() {
        return IronSourceObject.getInstance().M();
    }

    public static void c() {
        IronSourceObject.getInstance().Q();
    }

    public static void d(com.ironsource.mediationsdk.n0.l lVar) {
        IronSourceObject.getInstance().Y(lVar);
    }

    public static void e(String str) {
        IronSourceObject.getInstance().b0(str);
    }
}
