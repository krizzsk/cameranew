package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.StrictMode;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.78  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass78 {
    @Nullable
    public static String A00;
    public static byte[] A01;
    public static String[] A02 = {"ezGqyoPIPKHN83WiKVVevBWkG3P1qDlE", "bHUhqeCZStL3hoLiFuX7aDXMTtUO4SRK", "6mH", "l35BhcLqTpkfPgrTHobWQpDf1vW4Njv0", "2S1uYpKXPbyDBdggYjHCHIIoGx5rp2pm", "U07LIPTAxvw3Yt20DQWphksDXSc1ydWN", "nWa8vBGdC70OTVh7jsXfRaHUkJPGOS0P", "NNhGFPrdPRblbbvf05CBiQrYmSBt33Cu"};

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 15);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{117, 96, 98, 40, 109, 86, 91, 74, 15, 110, 93, 93, 78, 86, 15, 70, 92, 15, 65, 90, 67, 67, 87, 81, 4, 2, 47};
    }

    static {
        A0A();
        A00 = null;
    }

    public static float A00(float f2) {
        return new BigDecimal(f2).setScale(3, RoundingMode.HALF_UP).floatValue();
    }

    public static long A01() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String[] strArr = A02;
        if (strArr[5].charAt(11) != strArr[1].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "oi1AWXaprIq3DsGdE2VtVNFOHzfK44CR";
        strArr2[1] = "VDiC0kXnWwp3KFPy20II1epcnqCnwjCl";
        return elapsedRealtime;
    }

    public static long A02(long j2) {
        return j2 - (j2 % PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    }

    @SuppressLint({"CatchGeneralException"})
    public static EnumC06366l A03(@Nullable String str) {
        JSONObject bdObject;
        String A06 = A06(24, 2, 121);
        if (str == null || str.isEmpty()) {
            return EnumC06366l.A04;
        }
        try {
            bdObject = new JSONObject(str).getJSONObject(A06(22, 2, 58));
        } catch (Throwable unused) {
        }
        if (bdObject == null) {
            return EnumC06366l.A04;
        }
        if (bdObject.has(A06)) {
            return EnumC06366l.A00(bdObject.getInt(A06));
        }
        return EnumC06366l.A04;
    }

    public static C1298Xi A04(String str, Throwable th) {
        if (th instanceof NullPointerException) {
            return new C1298Xi(A01(), new C06486x(str), new C06476w(EnumC06466v.A07));
        }
        boolean z = th instanceof SecurityException;
        if (A02[3].charAt(27) != 'P') {
            A02[7] = "UmchuACFheILBJlaih7XmvNlXQtm6iWO";
            if (z) {
                return new C1298Xi(A01(), new C06486x(str), new C06476w(EnumC06466v.A06));
            }
            if (!(th instanceof UnsupportedOperationException)) {
                boolean z2 = th instanceof NoSuchAlgorithmException;
                if (A02[0].charAt(9) != 'T') {
                    A02[3] = "x60dR1TMPSfTuY8uuU5k4CgjQFfD2Ly1";
                    if (!z2) {
                        return new C1298Xi(A01(), new C06486x(str), new C06476w(th));
                    }
                }
            }
            return new C1298Xi(A01(), new C06486x(str), new C06476w(EnumC06466v.A05));
        }
        throw new RuntimeException();
    }

    @SuppressLint({"BadMethodUse-java.util.UUID.randomUUID"})
    public static String A05() {
        if (A00 == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                A00 = UUID.randomUUID().toString();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return A00;
    }

    @Nullable
    @SuppressLint({"EmptyCatchBlock"})
    public static String A07(String str) {
        String A06 = A06(26, 1, 84);
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(A06)) {
                str2 = Integer.toString(jSONObject.getInt(A06));
                return str2;
            }
            return null;
        } catch (JSONException unused) {
            return str2;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0015 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A08(byte[] r7, com.facebook.ads.redexgen.X.AnonymousClass77 r8) throws java.security.NoSuchAlgorithmException {
        /*
            if (r7 == 0) goto L3c
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            java.lang.String r0 = r8.A02()
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)
            byte[] r5 = r0.digest(r7)
            r4 = 0
        L14:
            int r0 = r5.length
            if (r4 >= r0) goto L37
            r0 = 1
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r1 = 0
            r0 = r5[r4]
            r0 = r0 & 255(0xff, float:3.57E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r1] = r0
            r2 = 0
            r1 = 4
            r0 = 95
            java.lang.String r0 = A06(r2, r1, r0)
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r6.append(r0)
            int r4 = r4 + 1
            goto L14
        L37:
            java.lang.String r0 = r6.toString()
            return r0
        L3c:
            r2 = 4
            r1 = 18
            r0 = 32
            java.lang.String r1 = A06(r2, r1, r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass78.A08(byte[], com.facebook.ads.redexgen.X.77):java.lang.String");
    }

    public static Map<String, String> A09(AnonymousClass61 anonymousClass61) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnonymousClass69.A04.A02(), A05());
        hashMap.put(AnonymousClass69.A0A.A02(), Long.toString(TimeUnit.SECONDS.toMillis(anonymousClass61.A0T())));
        hashMap.put(AnonymousClass69.A06.A02(), Long.toString(C06376m.A00()));
        hashMap.put(AnonymousClass69.A07.A02(), Integer.toString(anonymousClass61.A0S()));
        hashMap.put(AnonymousClass69.A09.A02(), Integer.toString(anonymousClass61.A0V()));
        hashMap.put(AnonymousClass69.A05.A02(), Integer.toString(anonymousClass61.A0R()));
        hashMap.put(AnonymousClass69.A08.A02(), A07(anonymousClass61.A0h()));
        return hashMap;
    }

    public static void A0B(AnonymousClass61 anonymousClass61, String str, @Nullable String str2) {
        C6A A0X = anonymousClass61.A0X();
        if (A0X == null) {
            return;
        }
        A0X.A91(AnonymousClass67.A05.A02(), str, A09(anonymousClass61), str2, null, null, null);
    }

    public static boolean A0C() {
        int i2 = Build.VERSION.SDK_INT;
        if (A02[6].charAt(4) != 'v') {
            throw new RuntimeException();
        }
        A02[4] = "tyMFX1CpOJYUV0MeMpbopAmdAMzcot7c";
        return i2 >= 29;
    }

    public static boolean A0D() {
        ActivityManager.RunningAppProcessInfo appProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(appProcessInfo);
        return appProcessInfo.importance != 100;
    }

    public static boolean A0E(EnumC06366l enumC06366l) {
        int reputationTierValue = enumC06366l.A03();
        return reputationTierValue == EnumC06366l.A05.A03() || reputationTierValue == EnumC06366l.A07.A03() || reputationTierValue == EnumC06366l.A06.A03();
    }

    public static boolean A0F(@Nullable String str, @Nullable String str2) {
        if (str != null || str2 != null) {
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        } else if (A02[2].length() != 3) {
            throw new RuntimeException();
        } else {
            String[] strArr = A02;
            strArr[5] = "CRUhUvJCPqF3o50vaOZhXgSSPBMouYyY";
            strArr[1] = "Hcx4PZUYJ7P3vk50CiSuOhi8dLkBnJKe";
            return true;
        }
    }
}
