package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.Arrays;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: assets/audience_network.dex */
public final class LI {
    public static byte[] A00;
    public static String[] A01 = {"HfGv3264Bq2TQ34NqRtE4P30TXR", "AZVpgJ8fi5FDz5AiC", "FCmmf0GU", "NGZF99o8OEHjBvmOxlLxN", "MEp80XUn5zKurDhCJ73", "hVp2plT6ulDLwck", "CErebgOhZelO8plRL7vU3", "v0a34uu5Y8rm3tpqkSr554RtUBdvL4ru"};

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-47, -17, -4, -75, 2, -82, 1, 2, -17, 0, 2, -82, -49, 3, -14, -9, -13, -4, -15, -13, -36, -13, 2, 5, -3, 0, -7, -49, -15, 2, -9, 4, -9, 2, 7, -68, -82, -37, -17, -7, -13, -82, 1, 3, 0, -13, -82, 2, -10, -17, 2, -82, -9, 2, -75, 1, -82, -9, -4, -82, 7, -3, 3, 0, -82, -49, -4, -14, 0, -3, -9, -14, -37, -17, -4, -9, -12, -13, 1, 2, -68, 6, -5, -6, -82, -12, -9, -6, -13, -68, -15, -19, -20, 32, 15, 20, 16, 25, 14, 16, -7, 16, 31, 34, 26, 29, 22, -26, -13, -28, -26, -24, -7, -18, -5, -18, -7, -2, 24, 37, 27, 41, 38, 32, 27, -27, 32, 37, 43, 28, 37, 43, -27, 24, 26, 43, 32, 38, 37, -27, Draft_75.CR, 0, -4, 14, -60, -47, -57, -43, -46, -52, -57, -111, -52, -47, -41, -56, -47, -41, -111, -58, -60, -41, -56, -54, -46, -43, -36, -111, -91, -75, -78, -70, -74, -92, -91, -81, -88, -32, -16, -19, -11, -15, -29, -16, -45, -48, -54, -23, -14, -17, -21, -12, -6, -38, -11, -15, -21, -12, -82, -70, -72, 121, -84, -71, -81, -67, -70, -76, -81, 121, -83, -67, -70, -62, -66, -80, -67, 121, -84, -69, -69, -73, -76, -82, -84, -65, -76, -70, -71, -86, -76, -81, -56, -44, -46, -109, -58, -45, -55, -41, -44, -50, -55, -109, -37, -54, -45, -55, -50, -45, -52, -47, -35, -37, -100, -44, -49, -47, -45, -48, -35, -35, -39, -100, -39, -49, -30, -49, -36, -49, -30, -15, -28, -32, -13, -28, -34, -19, -28, -10, -34, -13, -32, -31, -86, -90, -11, -18, -5, -15, -7, -14, -1, -31, -10, -6, -14, -70, -58, -58, -62, -73, -61, -61, -65, -119, 126, 126, -65, -69, -80, -56, 125, -74, -66, -66, -74, -69, -76, 125, -78, -66, -68, 126, -62, -61, -66, -63, -76, 126, -80, -65, -65, -62, 126, -34, -22, -22, -26, -23, -62, -74, -57, -64, -70, -55, -64, -68, -79, -55, 126, -73, -65, -65, -73, -68, -75, 126, -77, -65, -67, -47, -60, -64, -46, -81, -44, -53, -64};
    }

    static {
        A03();
    }

    public static Intent A00(Uri uri) {
        Intent intent = new Intent(A02(118, 26, 123), uri);
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    @VisibleForTesting
    public static Intent A01(XT xt, Uri uri) {
        Intent A002 = A00(uri);
        A002.addCategory(A02(IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 33, 39));
        A002.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        A002.putExtra(A02(198, 34, 15), xt.getPackageName());
        A002.putExtra(A02(BaseBlurEffect.ROTATION_270, 14, 67), false);
        if (JD.A1G(xt)) {
            if (A02(284, 2, 8).equals(uri.getScheme())) {
                A002.setPackage(A02(251, 19, 50));
            }
        }
        return A002;
    }

    private void A04(XT xt, Uri uri) {
        L9.A0B(xt, A01(xt, uri));
    }

    private final void A05(XT xt, Uri uri) throws LH {
        if (A0A(xt)) {
            Intent A012 = A01(xt, uri);
            A012.setPackage(A02(232, 19, 41));
            L9.A0B(xt, A012);
            return;
        }
        throw new LH();
    }

    private void A06(XT xt, Uri uri, String str) {
        AdActivityIntent A04 = L9.A04(xt);
        A04.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        A04.putExtra(A02(361, 8, 31), EnumC0965Kd.A02);
        A04.putExtra(A02(177, 10, 66), uri.toString());
        A04.putExtra(A02(187, 11, 74), str);
        A04.putExtra(A02(286, 11, 81), System.currentTimeMillis());
        try {
            L9.A09(xt, A04);
        } catch (ActivityNotFoundException e2) {
            xt.A06().A8q(A02(107, 11, 73), C06808m.A05, new C06818n(e2));
            Log.e(A02(90, 17, 111), A02(0, 90, 82), e2);
        }
    }

    private final void A07(XT xt, Uri uri, String str) {
        boolean A05 = JE.A05(xt);
        if (A09(uri) && A05) {
            A06(xt, uri, str);
            return;
        }
        xt.A0D().A81(A05);
        A04(xt, uri);
    }

    public static void A08(LI li, XT xt, Uri uri, String str) {
        boolean z;
        try {
            if (A09(uri)) {
                if (A02(346, 15, 20).equals(uri.getHost())) {
                    z = true;
                    if (!A02(340, 6, 25).equals(uri.getScheme()) || z) {
                        li.A05(xt, uri);
                        return;
                    } else {
                        li.A07(xt, uri, str);
                        return;
                    }
                }
            }
            li.A05(xt, uri);
            return;
        } catch (LH unused) {
            li.A07(xt, uri, str);
            return;
        }
        z = false;
        if (!A02(340, 6, 25).equals(uri.getScheme())) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (r0.equalsIgnoreCase(r3) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A09(android.net.Uri r5) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r0 = 24
            if (r1 < r0) goto L38
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r3 = r0.isCleartextTrafficPermitted()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.LI.A01
            r0 = 1
            r1 = r2[r0]
            r0 = 4
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L61
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.LI.A01
            java.lang.String r1 = "9DaYNTGnU6m41BFJKxw5hEDOoLHVmNBK"
            r0 = 7
            r2[r0] = r1
            if (r3 != 0) goto L38
            android.security.NetworkSecurityPolicy r1 = android.security.NetworkSecurityPolicy.getInstance()
            java.lang.String r0 = r5.getHost()
            boolean r0 = r1.isCleartextTrafficPermitted(r0)
            if (r0 == 0) goto L5f
        L38:
            r0 = 1
        L39:
            java.lang.String r3 = r5.getScheme()
            if (r0 == 0) goto L4e
            r2 = 297(0x129, float:4.16E-43)
            r1 = 4
            r0 = 22
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L5d
        L4e:
            r2 = 335(0x14f, float:4.7E-43)
            r1 = 5
            r0 = 58
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L5e
        L5d:
            r4 = 1
        L5e:
            return r4
        L5f:
            r0 = 0
            goto L39
        L61:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LI.A09(android.net.Uri):boolean");
    }

    private boolean A0A(XT xt) {
        for (ResolveInfo appInfo : xt.getPackageManager().queryIntentActivities(new Intent(A02(118, 26, 123), Uri.parse(A02(301, 34, 19))), 0)) {
            if (appInfo.activityInfo.applicationInfo.packageName.equals(A02(232, 19, 41))) {
                return true;
            }
        }
        return false;
    }
}
