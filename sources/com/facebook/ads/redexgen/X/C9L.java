package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* renamed from: com.facebook.ads.redexgen.X.9L  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9L {
    public static String A00;
    public static byte[] A01;
    public static String[] A02 = {"Qr1EFu0kx1tI01867m6ODqfSZ9SwtWDI", "3TYgkAWbIjP9kMvunjr7VwfmqgOZ7ZQ4", "kyx9q1x7DLL5BxK3faNs604Sw4dxbCMr", "cJW9lkVABx2P1Kp63XktrUnlRFV2zQAL", "nhxLXaLaMxGTsXNVJcvnwyCHZZV2RS3H", "y9xLyKazRl3zNBUnfIZmAOMjGK0AXhl4", "DTEqb4TbXnNBCaxA5atVnYK0pSb9DMUi", "fZvghiN"};
    public static final AtomicBoolean A03;
    public static final AtomicReference<String> A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A01 = new byte[]{76, 55, 42, 46, 45, 34, 67, 45, 25, 8, 5, 9, 2, 15, 9, 34, 9, 24, 27, 3, 30, 7, 42, 3, 30, 45, 2, 8, 30, 3, 5, 8, 87, 42, 46, 63, 34, 67, 71, 87, 42, 46, 45, 58, 67, 81, 44, 40, 40, 60, 69, 101, 24, 28, 18, 29, 113, 30, 99, 103, 118, 115, 10, 39, 8, 2, 20, 9, 15, 2, 16, 20, 23, 20, 121, 72, 76, 88, 93, 33, 17, 8, 30, 15, 20, Draft_75.CR, Draft_75.CR, 9, 50, 55, 50, 51, 43, 50, 38, 49, 61, 63, 124, 52, 51, 49, 55, 48, 61, 61, 57, 124, 51, 54, 33, 124, 59, 60, 38, 55, 32, 60, 51, 62, 124, 39, 51, 62, 60, 55, 60, 43, 48, 58, 59, 39, 39, 35, 125, 50, 52, 54, 61, 39, 60, 58, 44, 59, 22, 40, 46, 44, 39, 61, 50, 52, 34, 53, 24, 38, 32, 34, 41, 51, 24, 43, 38, 52, 51, 24, 53, 34, 33, 53, 34, 52, 47, 85, 71, 64, 125, 84, 75, 71, 85};
    }

    static {
        A08();
        A00 = A00(87, 7, 79);
        A03 = new AtomicBoolean();
        A04 = new AtomicReference<>();
    }

    @TargetApi(17)
    @VisibleForTesting
    public static String A01(C8J c8j) {
        return WebSettings.getDefaultUserAgent(c8j);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A02(final C8J c8j) {
        FutureTask futureTask = new FutureTask(new Callable<String>() { // from class: com.facebook.ads.redexgen.X.9K
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: A00 */
            public final String call() {
                AtomicReference atomicReference;
                AtomicReference atomicReference2;
                atomicReference = C9L.A04;
                String str = (String) atomicReference.get();
                if (str != null) {
                    return str;
                }
                WebView webView = new WebView(C8J.this.getApplicationContext());
                webView.setWebViewClient(new WebViewClient() { // from class: com.facebook.ads.redexgen.X.9J
                    @Override // android.webkit.WebViewClient
                    @RequiresApi(api = 26)
                    public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                        AbstractC1045Nk.A02(C06808m.A2U);
                        return true;
                    }
                });
                String userAgentString = webView.getSettings().getUserAgentString();
                webView.destroy();
                if (userAgentString != null) {
                    atomicReference2 = C9L.A04;
                    atomicReference2.set(userAgentString);
                }
                return userAgentString;
            }
        });
        for (int i2 = 0; i2 < 3; i2++) {
            M1.A00(futureTask);
            try {
                return (String) futureTask.get();
            } catch (Throwable th) {
                A09(c8j, th);
                SystemClock.sleep(500L);
            }
        }
        return null;
    }

    public static String A03(C8J c8j, C06908w c06908w) {
        String A06 = c06908w.A06();
        if (TextUtils.isEmpty(A06)) {
            boolean andSet = A03.getAndSet(true);
            String[] strArr = A02;
            if (strArr[4].charAt(26) != strArr[3].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "SlGltdwaGCQXXY2U2bjZ1NfeES9SOW6r";
            strArr2[0] = "AnJMWH4pc3dV3Xqon1tLsffrk7nZCcYt";
            if (!andSet) {
                c8j.A06().A8q(A00(123, 7, 74), C06808m.A1N, new C06818n(A00(80, 7, 82)));
            }
        }
        return A06;
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A04(C8J c8j, boolean z) {
        if (c8j == null) {
            return A00;
        }
        if (z) {
            return System.getProperty(A00(130, 10, 64));
        }
        String str = A04.get();
        if (str != null) {
            return str;
        }
        long A012 = JC.A01(c8j);
        String A002 = A00(150, 23, 84);
        String A003 = A00(InspirePublishFragment.MAX_DESC_COUNT, 10, 90);
        String A004 = A00(95, 28, 65);
        if (A012 > 0) {
            SharedPreferences sharedPreferences = c8j.getSharedPreferences(ProcessUtils.getProcessSpecificName(A004, c8j), 0);
            String string = sharedPreferences.getString(A003, null);
            long j2 = sharedPreferences.getLong(A002, 0L);
            if (!TextUtils.isEmpty(string) && System.currentTimeMillis() - j2 < A012) {
                A04.set(string);
                return string;
            }
        }
        String str2 = null;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                str2 = A01(c8j);
                A04.set(str2);
            } catch (Throwable th) {
                A09(c8j, th);
            }
        }
        if (str2 == null) {
            str2 = A02(c8j);
        }
        if (str2 == null) {
            String userAgentString = A00;
            return userAgentString;
        }
        int i2 = (A012 > 0L ? 1 : (A012 == 0L ? 0 : -1));
        String[] strArr = A02;
        if (strArr[4].charAt(26) != strArr[3].charAt(26)) {
            throw new RuntimeException();
        }
        A02[7] = "Kvz6zSF";
        if (i2 > 0) {
            String userAgentString2 = ProcessUtils.getProcessSpecificName(A004, c8j);
            SharedPreferences sharedPreferences2 = c8j.getSharedPreferences(userAgentString2, 0);
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            String userAgentString3 = A04.get();
            edit.putString(A003, userAgentString3).apply();
            sharedPreferences2.edit().putLong(A002, System.currentTimeMillis()).apply();
        }
        return str2;
    }

    public static String A05(C06908w c06908w, C8J c8j) {
        if (JC.A04(c8j)) {
            return A00(70, 5, 69) + A03(c8j, c06908w) + A00(39, 6, 127) + c06908w.A05() + A00(45, 6, 121) + c06908w.A03() + A00(38, 1, 111);
        }
        return A00(0, 0, 40);
    }

    public static String A06(C06908w c06908w, C8J c8j, boolean z) {
        return A04(c8j, z) + A00(0, 38, 127) + A00(63, 7, 117) + A00(57, 6, 54) + C06908w.A03 + A00(38, 1, 111) + A05(c06908w, c8j) + A00(75, 5, 29) + c8j.A03().A7f() + A00(51, 6, 77) + Locale.getDefault().toString() + A00(94, 1, 104);
    }

    public static void A09(C8J c8j, Throwable th) {
        c8j.A06().A8q(A00(173, 8, 49), C06808m.A2T, new C06818n(th));
    }
}
