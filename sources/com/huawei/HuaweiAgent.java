package com.huawei;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import com.adjust.sdk.Constants;
/* loaded from: classes2.dex */
public final class HuaweiAgent {
    private static final HuaweiAgent INSTANCE = new HuaweiAgent();
    public static final String appId = "1002590";
    public static final String cpId = "900086000000011988";
    public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmYOhn32XtSXxoYeouwLme0bAQi3TgZ7A/P68Y0ZlAWuCpF5F31teODZf6n0An0dtn/tgF0JTxi4drRNNa6tvX6I8jVbq7uSowplTjBJEaf3FDKvNfCX/CTuE2SBaGTFOgnrlhPllzi2MaUqTFRYD7nxcrP3AH6sdMU8dTqsa8i+2PPddnf/HM/sNT62ofCuLEr8zbOaqPdoC7nGzHFrU9WrtAgGrkzWUw2n946lLWfSAKPF4+ClwenF6rU8EIEH8sW6uNSyXFPOPJxAWJN88apb/ExiXMtau7d74TiblTCusbwJP6jTJJGHzwDWLMMTWQ4FW2c7GLRnQYSmyNOuB+QIDAQAB";
    private boolean hasInit = false;

    private HuaweiAgent() {
    }

    public static HuaweiAgent get() {
        return INSTANCE;
    }

    public static boolean isHuaweiPhone() {
        String str = Build.BRAND;
        return "honor".equalsIgnoreCase(str) || Constants.REFERRER_API_HUAWEI.equalsIgnoreCase(str);
    }

    public static boolean isHuaweiSupport() {
        return false;
    }

    public void connectAndUpdate(Activity activity) {
    }

    public boolean init(Application application) {
        return false;
    }

    public void signIn(Activity activity, HmsLoginCallBack hmsLoginCallBack) {
        hmsLoginCallBack.onLoginSuccess(null);
    }
}
