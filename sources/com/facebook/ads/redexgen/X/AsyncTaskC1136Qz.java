package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.Qz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class AsyncTaskC1136Qz extends AsyncTask<String, Void, R0> {
    public static byte[] A05;
    public static String[] A06 = {"iMGBqiSHm2uYyOurEO", "JHkNge3qKUrOixxb", "Efd0ZU7p6XsOViiGEn9FTnCEMV0phXsZ", "Qqux8MYyckh5CceEy", "ksejtLtP", "6qwv67", "yXEFufBpuo", "JuPO8KFa"};
    public static final String A07;
    public static final Set<String> A08;
    public C8J A00;
    public InterfaceC1115Qe A01;
    public InterfaceC1135Qy A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 90);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{48, 0, 3, 57, 33, 22, 22, 11, 22, 68, 11, 20, 1, 10, Draft_75.CR, 10, 3, 68, 17, 22, 8, 94, 68, 122, 117, 122, 119, 116, 124, 44, 55, 46, 46};
    }

    static {
        A04();
        A07 = AsyncTaskC1136Qz.class.getSimpleName();
        A08 = new HashSet();
        A08.add(A01(0, 1, 73));
        A08.add(A01(29, 4, 24));
    }

    public AsyncTaskC1136Qz(C8J c8j) {
        this(c8j, null, null);
    }

    public AsyncTaskC1136Qz(C8J c8j, Map<String, String> map) {
        this(c8j, map, null);
    }

    public AsyncTaskC1136Qz(C8J c8j, @Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
        this.A00 = c8j;
        Map<String, String> postData = map != null ? new HashMap<>(map) : null;
        this.A03 = postData;
        Map<String, String> extraData = map2 != null ? new HashMap<>(map2) : null;
        this.A04 = extraData;
    }

    private final R0 A00(String... strArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A08.contains(str)) {
                String A02 = A02(str);
                if (this.A03 != null && !this.A03.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        String url = entry.getValue();
                        A02 = A03(A02, entry.getKey(), url);
                    }
                }
                int i2 = 1;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 > 2) {
                        return null;
                    }
                    if (A06(A02)) {
                        return new R0(this.A01);
                    }
                    i2 = i3;
                }
            }
            return null;
        } catch (Throwable th) {
            if (A06[6].length() != 31) {
                A06[6] = "dO3qGWbyMuVAZQTwO1X30zVxIjEEo";
                C0974Kn.A00(th, this);
                return null;
            }
            throw new RuntimeException();
        }
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 65), C0988Le.A01(this.A00.A02().A5f()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String A01 = A01(3, 1, 92);
        if (str.contains(A01)) {
            A01 = A01(1, 1, 124);
        }
        return str + A01 + str2 + A01(2, 1, 100) + URLEncoder.encode(str3);
    }

    private final void A05(R0 r0) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            if (this.A02 != null) {
                this.A02.AD6(r0);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private boolean A06(String str) {
        InterfaceC1115Qe ACs;
        InterfaceC1116Qf A00 = C1134Qx.A00(this.A00);
        try {
            if (this.A04 == null || this.A04.size() == 0) {
                ACs = A00.ACs(str, new C1130Qt());
            } else {
                C1130Qt c1130Qt = new C1130Qt();
                c1130Qt.A05(this.A04);
                ACs = A00.ACt(str, c1130Qt.A08());
            }
            this.A01 = ACs;
        } catch (Exception e2) {
            String str2 = A07;
            Log.e(str2, A01(4, 19, 62) + str, e2);
        }
        InterfaceC1115Qe interfaceC1115Qe = this.A01;
        return interfaceC1115Qe != null && interfaceC1115Qe.A7U() == 200;
    }

    public final void A07(InterfaceC1135Qy interfaceC1135Qy) {
        this.A02 = interfaceC1135Qy;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ R0 doInBackground(String[] strArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        InterfaceC1135Qy interfaceC1135Qy = this.A02;
        if (interfaceC1135Qy != null) {
            interfaceC1135Qy.AD4();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(R0 r0) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A05(r0);
        } catch (Throwable th) {
            if (A06[3].length() != 17) {
                throw new RuntimeException();
            }
            A06[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
            C0974Kn.A00(th, this);
        }
    }
}
