package com.growingio.android.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.VisibleForTesting;
/* loaded from: classes2.dex */
public class PermissionUtil {
    private static final int FLAG_ACCESS_NETWORK_STATE = 2;
    private static final int FLAG_EXTERNAL_STORAGE = 4;
    private static final int FLAG_INTERNET = 1;
    private static final int FLAG_READ_PHONE_STATE = 8;
    private static final String TAG = "GIO.permission";
    private static PermissionUtil s_Instance;
    private final PackageManager mPackageManager;
    private final String mPackageName;
    private int mPermissionFlags = 0;

    @VisibleForTesting
    PermissionUtil(PackageManager packageManager, String str) {
        this.mPackageManager = packageManager;
        this.mPackageName = str;
    }

    public static boolean checkReadPhoneStatePermission() {
        return s_Instance.checkPermission("android.permission.READ_PHONE_STATE", 8);
    }

    public static boolean hasAccessNetworkStatePermission() {
        return s_Instance.checkPermission("android.permission.ACCESS_NETWORK_STATE", 2);
    }

    public static boolean hasInternetPermission() {
        return s_Instance.checkPermission("android.permission.INTERNET", 1);
    }

    public static boolean hasWriteExternalPermission() {
        return s_Instance.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", 4);
    }

    public static void init(Context context) {
        s_Instance = new PermissionUtil(context.getPackageManager(), context.getPackageName());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025 A[RETURN] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean checkPermission(java.lang.String r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.mPermissionFlags
            r0 = r0 & r6
            r1 = 1
            if (r0 == 0) goto L7
            return r1
        L7:
            r0 = 0
            android.content.pm.PackageManager r2 = r4.mPackageManager     // Catch: java.lang.Throwable -> L14
            java.lang.String r3 = r4.mPackageName     // Catch: java.lang.Throwable -> L14
            int r5 = r2.checkPermission(r5, r3)     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L1c
            r5 = 1
            goto L1d
        L14:
            r5 = move-exception
            java.lang.String r2 = "GIO.permission"
            java.lang.String r3 = "checkPermission failed: "
            com.growingio.android.sdk.utils.LogUtil.d(r2, r3, r5)
        L1c:
            r5 = 0
        L1d:
            if (r5 == 0) goto L25
            int r5 = r4.mPermissionFlags
            r5 = r5 | r6
            r4.mPermissionFlags = r5
            return r1
        L25:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.utils.PermissionUtil.checkPermission(java.lang.String, int):boolean");
    }
}
