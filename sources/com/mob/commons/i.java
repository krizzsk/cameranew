package com.mob.commons;

import android.net.Uri;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
/* compiled from: ServerConfig.java */
/* loaded from: classes2.dex */
public class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerConfig.java */
    /* renamed from: com.mob.commons.i$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InternationalDomain.values().length];
            a = iArr;
            try {
                iArr[InternationalDomain.JP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InternationalDomain.US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static String a() {
        try {
            DeviceHelper.getInstance(MobSDK.getContext()).isPackageInstalled(j.a(17));
            MobSDK.checkV6();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return b("api-fc.dutils.com");
    }

    public static String b() {
        try {
            DeviceHelper.getInstance(MobSDK.getContext()).isPackageInstalled(j.a(17));
            MobSDK.checkV6();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return b("api-fd.dutils.com");
    }

    public static String c(String str) {
        Uri parse;
        String scheme;
        String str2;
        try {
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        boolean checkForceHttps = MobSDK.checkForceHttps();
        if (checkForceHttps || (Build.VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
            str = str.trim();
            if (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) && (parse = Uri.parse(str.trim())) != null && (scheme = parse.getScheme()) != null && scheme.equals("http")) {
                String host = parse.getHost();
                String path = parse.getPath();
                String query = parse.getQuery();
                String str3 = "";
                if (host != null) {
                    int port = parse.getPort();
                    StringBuilder sb = new StringBuilder();
                    sb.append(host);
                    if (port > 0 && port != 80) {
                        str2 = ":" + port;
                        sb.append(str2);
                        host = sb.toString();
                        if (!checkForceHttps && Build.VERSION.SDK_INT >= 24 && ((Boolean) ReflectHelper.invokeInstanceMethod(NetworkSecurityPolicy.getInstance(), "isCleartextTrafficPermitted", host)).booleanValue()) {
                            return str;
                        }
                    }
                    str2 = "";
                    sb.append(str2);
                    host = sb.toString();
                    if (!checkForceHttps) {
                        return str;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Constants.HTTPS_PROTOCOL_PREFIX);
                sb2.append(host);
                if (path == null) {
                    path = "";
                }
                sb2.append(path);
                if (query != null) {
                    str3 = "?" + query;
                }
                sb2.append(str3);
                return sb2.toString();
            }
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        if (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX)) {
            str = str.replace(Constants.HTTP_PROTOCOL_PREFIX, "");
        }
        if (str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            str = str.replace(Constants.HTTPS_PROTOCOL_PREFIX, "");
        }
        int i2 = AnonymousClass1.a[MobSDK.getDomain().ordinal()];
        if (i2 == 1) {
            str2 = "jp";
        } else if (i2 == 2) {
            str2 = "us";
        }
        if (TextUtils.isEmpty(str2)) {
            return c(Constants.HTTP_PROTOCOL_PREFIX + str);
        }
        if (str.startsWith(str2 + ".")) {
            return c(Constants.HTTP_PROTOCOL_PREFIX + str);
        }
        return c(Constants.HTTP_PROTOCOL_PREFIX + str2 + "." + str);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        if (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX)) {
            str = str.replace(Constants.HTTP_PROTOCOL_PREFIX, "");
        }
        if (str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            str = str.replace(Constants.HTTPS_PROTOCOL_PREFIX, "");
        }
        if (MobSDK.checkV6()) {
            str2 = "v6";
        } else {
            int i2 = AnonymousClass1.a[MobSDK.getDomain().ordinal()];
            if (i2 == 1) {
                str2 = "jp";
            } else if (i2 == 2) {
                str2 = "us";
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return c(Constants.HTTP_PROTOCOL_PREFIX + str);
        }
        if (str.startsWith(str2 + ".")) {
            return c(Constants.HTTP_PROTOCOL_PREFIX + str);
        }
        return c(Constants.HTTP_PROTOCOL_PREFIX + str2 + "." + str);
    }
}
