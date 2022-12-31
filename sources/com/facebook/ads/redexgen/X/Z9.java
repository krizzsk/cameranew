package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class Z9 extends C06266b {
    public static PackageManager A00;
    public static String[] A01 = {"mMUsySdK", "G1dnExSQKLbMoTCo5d1h1U5A6G7ndhFt", "GiJYkTHpyeTaf3ywPcthUoX2rTVjWFCb", "0A5FUJ9kDHtL7zu8WVVZPRsd6iFGNBV", "Uxf0Oizk", "zpV62zjrrTP1cgdKU18BbBXv", "Pb6NlhKASELFsFyHLiNoj4ENeXMrfTQa", "RrSFtRYH4qZAbHiyxnUErsMfABxwLq"};

    public Z9(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        A00 = context.getPackageManager();
    }

    public static /* synthetic */ PackageManager A01() {
        PackageManager packageManager = A00;
        if (A01[1].charAt(22) != 'k') {
            String[] strArr = A01;
            strArr[7] = "gjUVtXXuXbvsWPZLBaiwFqVTuNtnGy";
            strArr[3] = "aaBFOo2Y3N72goZoHRvUb35kO6Lzp1W";
            return packageManager;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC06506z A03(HashMap<String, ZA> hashMap) {
        return new C1292Xc(SystemClock.elapsedRealtime(), A02(), hashMap, EnumC06496y.A0C);
    }

    public final InterfaceC06356k A0G(List<C06346j> list) {
        return new ZB(this, list);
    }
}
