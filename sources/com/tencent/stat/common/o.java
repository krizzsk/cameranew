package com.tencent.stat.common;

import java.io.File;
/* loaded from: classes3.dex */
class o {
    private static int a = -1;

    public static boolean a() {
        int i2 = a;
        if (i2 == 1) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i3 = 0; i3 < 6; i3++) {
            try {
                if (new File(strArr[i3] + "su").exists()) {
                    a = 1;
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        a = 0;
        return false;
    }
}
