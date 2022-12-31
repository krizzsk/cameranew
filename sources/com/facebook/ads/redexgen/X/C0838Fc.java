package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import us.pinguo.androidsdk.PGImageSDK;
/* renamed from: com.facebook.ads.redexgen.X.Fc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0838Fc extends AbstractC1554d9 {
    public static byte[] A02;
    public static String[] A03 = {"eZwrQOnpnpQE2xbRo0zNjy7tlobdqdqH", "SFt7WwZUn", "NjRPf9lXQVcUlHZaPZ2tHyzwDKEOZm5m", "vsw9aGbGyLBdbL44W3z8tEYPUFR7w9", "bZApvv", "GYK1wV", "jBSwIULngy0dc0IzE6SbgF9ev3BAFzHy", "9HFC3JFq8"};
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = (copyOfRange[i5] - i4) - 27;
            String[] strArr = A03;
            if (strArr[6].charAt(23) == strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            A03[3] = "uqLwDcTKX4SWJds2FMBMp5QNw2MnWtU";
            copyOfRange[i5] = (byte) i6;
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{106, -105, -105, -108, -105, 69, -107, -122, -105, -104, -114, -109, -116, 69, -122, -107, -107, -104, -114, -103, -118, -124, -119, -122, -103, -122, -124, -97, -89, -86, -93, -94, 94, -78, -83, 94, -83, -82, -93, -84, 94, -85, -97, -80, -87, -93, -78, 94, -77, -80, -86, 120, 94, -29, -27, -5, 8, -2, 12, 9, 3, -2, -108, -95, -105, -91, -94, -100, -105, 97, -100, -95, -89, -104, -95, -89, 97, -108, -106, -89, -100, -94, -95, 97, 118, 116, Byte.MAX_VALUE, Byte.MAX_VALUE, -94, -81, -91, -77, -80, -86, -91, 111, -86, -81, -75, -90, -81, -75, 111, -94, -92, -75, -86, -80, -81, 111, -105, -118, -122, -104, -8, 7, 7, 10, 0, 11, -4, -10, -5, -8, 11, -8, -3, -15, 2, -5, -11, 4, -54, -65, -65, -12, -11, 4, -15, -7, -4, 3, -49, -7, -12, -51, -75, 3, -26, -25, -36, -27, -36, -37, -42, -37, -36, -36, -25, -29, -32, -27, -30, -108, -107, -118, -109, -118, -119, -124, -104, -103, -108, -105, -118, -124, -117, -122, -111, -111, -121, -122, -120, -112, -124, -102, -105, -111, -38, -37, -48, -39, -48, -49, -54, -34, -33, -38, -35, -48, -54, -32, -35, -41, -70, -85, -68, -67, -77, -72, -79, -51, -50, -55, -52, -65, -71, -61, -66, -10, -9, -14, -11, -24, -30, -8, -11, -17, -96, -95, -100, -97, -110, -116, -94, -97, -103, -116, -92, -110, -113, -116, -109, -114, -103, -103, -113, -114, -112, -104, -90, -105, -98, 108, -72, -87, -80, -76, -74, -77, -79, -76, -72, 126};
    }

    static {
        A06();
        A04 = C0838Fc.class.getSimpleName();
    }

    public C0838Fc(XT xt, JT jt, String str, Uri uri, Map<String, String> map, C04830m c04830m, boolean z) {
        super(xt, jt, str, c04830m, z);
        this.A00 = uri;
        this.A01 = map;
    }

    private Intent A00(C04820k c04820k) {
        if (!TextUtils.isEmpty(c04820k.A05()) && C0989Lf.A04(((AbstractC04770f) this).A00, c04820k.A05())) {
            String A032 = c04820k.A03();
            if (!TextUtils.isEmpty(A032) && (A032.startsWith(A03(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 4, 23)) || A032.startsWith(A03(254, 10, 41)))) {
                return new Intent(A03(62, 26, 24), Uri.parse(A032));
            }
            PackageManager packageManager = ((AbstractC04770f) this).A00.getPackageManager();
            if (TextUtils.isEmpty(c04820k.A04()) && TextUtils.isEmpty(A032)) {
                return packageManager.getLaunchIntentForPackage(c04820k.A05());
            }
            Intent A01 = A01(c04820k);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(A01, 65536);
            if (A01.getComponent() == null) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo.packageName.equals(c04820k.A05())) {
                        A01.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                        break;
                    }
                }
            }
            boolean isEmpty = queryIntentActivities.isEmpty();
            String[] strArr = A03;
            if (strArr[5].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "mdy3DwQER";
            strArr2[1] = "z4eGZXaiq";
            if (isEmpty || A01.getComponent() == null) {
                return null;
            }
            return A01;
        }
        return null;
    }

    private Intent A01(C04820k c04820k) {
        Intent intent = new Intent(A03(88, 26, 38));
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        if (!TextUtils.isEmpty(c04820k.A05()) && !TextUtils.isEmpty(c04820k.A04())) {
            intent.setComponent(new ComponentName(c04820k.A05(), c04820k.A04()));
        }
        if (!TextUtils.isEmpty(c04820k.A03())) {
            intent.setData(Uri.parse(c04820k.A03()));
        }
        return intent;
    }

    private final Uri A02() {
        String queryParameter = this.A00.getQueryParameter(A03(219, 9, 104));
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        return Uri.parse(String.format(Locale.US, A03(126, 22, 117), this.A00.getQueryParameter(A03(211, 8, 63))));
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x0045 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.facebook.ads.redexgen.X.C04820k> A04() {
        /*
            r8 = this;
            android.net.Uri r3 = r8.A00
            r2 = 114(0x72, float:1.6E-43)
            r1 = 12
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.String r4 = r3.getQueryParameter(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L25
            r2 = 53
            r1 = 2
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L27
        L25:
            r0 = 0
            return r0
        L27:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L57
            r3.<init>(r4)     // Catch: org.json.JSONException -> L57
            r2 = 55
            r1 = 7
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r0 = A03(r2, r1, r0)     // Catch: org.json.JSONException -> L57
            org.json.JSONArray r2 = r3.optJSONArray(r0)     // Catch: org.json.JSONException -> L57
            if (r2 == 0) goto L7f
            r1 = 0
        L41:
            int r0 = r2.length()     // Catch: org.json.JSONException -> L57
            if (r1 >= r0) goto L7f
            org.json.JSONObject r0 = r2.optJSONObject(r1)     // Catch: org.json.JSONException -> L57
            com.facebook.ads.redexgen.X.0k r0 = com.facebook.ads.redexgen.X.C04820k.A00(r0)     // Catch: org.json.JSONException -> L57
            if (r0 == 0) goto L54
            r7.add(r0)     // Catch: org.json.JSONException -> L57
        L54:
            int r1 = r1 + 1
            goto L41
        L57:
            r6 = move-exception
            com.facebook.ads.redexgen.X.XT r0 = r8.A00
            com.facebook.ads.redexgen.X.8l r5 = r0.A06()
            int r4 = com.facebook.ads.redexgen.X.C06808m.A1r
            com.facebook.ads.redexgen.X.8n r3 = new com.facebook.ads.redexgen.X.8n
            r3.<init>(r6)
            r2 = 204(0xcc, float:2.86E-43)
            r1 = 7
            r0 = 47
            java.lang.String r0 = A03(r2, r1, r0)
            r5.A8q(r0, r4, r3)
            java.lang.String r3 = com.facebook.ads.redexgen.X.C0838Fc.A04
            r2 = 0
            r1 = 26
            r0 = 10
            java.lang.String r0 = A03(r2, r1, r0)
            android.util.Log.w(r3, r0, r6)
        L7f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0838Fc.A04():java.util.List");
    }

    private final List<Intent> A05() {
        List<C04820k> A042 = A04();
        ArrayList arrayList = new ArrayList();
        if (A042 != null) {
            for (C04820k c04820k : A042) {
                Intent intent = A00(c04820k);
                if (intent != null) {
                    arrayList.add(intent);
                }
            }
        }
        return arrayList;
    }

    private boolean A07() {
        boolean result;
        List<Intent> A05 = A05();
        if (A05 == null) {
            return false;
        }
        for (Intent intent : A05) {
            try {
                result = L9.A0B(((AbstractC04770f) this).A00, intent);
            } catch (Exception unused) {
            }
            if (result) {
                return true;
            }
        }
        return false;
    }

    private boolean A08() {
        LI li = new LI();
        try {
            LI.A08(li, ((AbstractC04770f) this).A00, A02(), this.A02);
            return true;
        } catch (Exception unused) {
            String str = A03(26, 27, 35) + this.A00.toString();
            String queryParameter = this.A00.getQueryParameter(A03(228, 22, 18));
            if (queryParameter != null && queryParameter.length() > 0) {
                LI.A08(li, ((AbstractC04770f) this).A00, Uri.parse(queryParameter), this.A02);
                return false;
            }
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04770f
    @Nullable
    public final EnumC04760e A09() {
        EnumC04760e enumC04760e = null;
        String A032 = A03(148, 15, 92);
        if (!A07()) {
            try {
                A032 = A08() ? A03(188, 16, 80) : A03(163, 25, 10);
            } catch (Exception unused) {
                enumC04760e = EnumC04760e.A02;
            }
        }
        this.A01.put(A032, String.valueOf(true));
        return enumC04760e;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1554d9
    public final void A0C() {
        EnumC04760e enumC04760e = null;
        if (((AbstractC1554d9) this).A01) {
            enumC04760e = A09();
        } else {
            this.A01.put(A03(188, 16, 80), String.valueOf(true));
        }
        Map<String, String> map = this.A01;
        if (A03[3].length() == 13) {
            throw new RuntimeException();
        }
        A03[2] = "sgzsFq3t5RzUzGxHOqvhuB7Tq08HlvIk";
        A0D(map, enumC04760e);
    }
}
