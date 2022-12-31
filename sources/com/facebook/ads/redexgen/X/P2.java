package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public final class P2 {
    public static byte[] A00;
    public static String[] A01 = {"qzld4Qy39Azn7KYrj1sXbPZPr2qv6GgB", "1yyYiWnNu", "Zg1voNH89a01plQdKkVOTIE3hJJ00If9", "AO", "oO", "LhD7lTYtuMCYkgD1PnemOg5ERT23PX0", "YB3LukNHUN2DaV56yaS9yy46zwl6QYin", "pfYbPlfLNAe5pcAyURRpn9lPUi7k7Z7a"};
    public static final String A02;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 105);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        byte[] bArr = {21, 51, 53, 58, 55, -14, 63, 59, 69, 69, -14, 56, 65, 68, -14, 56, 59, 62, 55, -14, 71, 68, 62, 12, -14, -61, -31, -29, -24, -27, -96, -19, -23, -13, -13, -96, -26, -17, -14, -96, -23, -19, -31, -25, -27, -96, -11, -14, -20, -70, -96, 34, 79, 79, 76, 79, -3, 76, 77, 66, 75, 70, 75, 68, -3, 64, 62, 64, 69, 66, 65, -3, 67, 70, 73, 66, -3, 67, 76, 79, -3, 82, 79, 73, 23, -3, -45, -49, -50, 2, -15, -10, -14, -5, -16, -14, -37, -14, 1, 4, -4, -1, -8, -17, -21, -60, -26, -29, -41, -39, -25, -25, -35, -30, -37, -108, -38, -35, -32, -39, -108, -23, -26, -32, -82, -108, -56, -22, -25, -37, -35, -21, -21, -31, -26, -33, -104, -31, -27, -39, -33, -35, -104, -19, -22, -28, -78, -104, -2, 32, 29, 17, 19, 33, 33, 23, 28, 21, -50, 36, 23, 18, 19, 29, -50, 35, 32, 26, -24, -50};
        String[] strArr = A01;
        if (strArr[7].charAt(12) != strArr[2].charAt(12)) {
            throw new RuntimeException();
        }
        A01[1] = "7l6kM9ADseoG9RLfCJpKjz7J";
        A00 = bArr;
    }

    static {
        A04();
        A02 = P2.class.getSimpleName();
    }

    @Nullable
    @RequiresApi(api = 21)
    public static WebResourceResponse A00(XT xt, C7J c7j, WebResourceRequest webResourceRequest, C1084Oz c1084Oz, P1 p1, boolean z) {
        String uri = webResourceRequest.getUrl().toString();
        if (c1084Oz.A06) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            String guessContentTypeFromName = URLConnection.guessContentTypeFromName(uri);
            if (c1084Oz.A02.contains(uri)) {
                String str = A03(105, 21, 11) + uri;
                File A0M = c7j.A0M(uri);
                if (A0M != null) {
                    if (z && uri.equals(c1084Oz.A01)) {
                        return A02(hashMap, guessContentTypeFromName, new C1078Ot(xt.A00(), new FileInputStream(A0M), new S1(p1)));
                    }
                    if (z && uri.equals(c1084Oz.A00)) {
                        return A02(hashMap, guessContentTypeFromName, new C1078Ot(xt.A00(), new FileInputStream(A0M), new S0(p1)));
                    }
                    return A01(hashMap, guessContentTypeFromName, A0M);
                }
                r0 = A03(0, 25, 105) + uri;
            }
            if (c1084Oz.A03.contains(uri)) {
                String str2 = A03(126, 22, 15) + uri;
                File A0N = c7j.A0N(uri);
                if (A0N != null) {
                    return A01(hashMap, guessContentTypeFromName, A0N);
                }
                String str3 = A03(25, 26, 23) + uri;
            }
            if (c1084Oz.A04.contains(uri)) {
                String str4 = A03(148, 22, 69) + uri;
                return C1075Oq.A00(xt, webResourceRequest, webResourceRequest.getUrl(), guessContentTypeFromName, hashMap);
            }
        } catch (IOException e2) {
            Log.e(A03(86, 17, 36), A03(51, 35, 116) + uri, e2);
        }
        return null;
    }

    @RequiresApi(api = 21)
    public static WebResourceResponse A01(HashMap<String, String> hashMap, String str, File file) throws FileNotFoundException {
        return A02(hashMap, str, new FileInputStream(file));
    }

    @RequiresApi(api = 21)
    public static WebResourceResponse A02(HashMap<String, String> hashMap, String str, InputStream inputStream) {
        return new WebResourceResponse(str, null, 200, A03(103, 2, 55), hashMap, inputStream);
    }
}
