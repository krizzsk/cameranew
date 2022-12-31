package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: assets/audience_network.dex */
public final class Z0 extends C06266b {
    public static byte[] A00;
    public static String[] A01 = {"y8Nq67FtAwLOnhnq1UqleBVuRpU5lwEq", "kKy3QSHCMFgMLI4jLKgpj6Ml3G5G", "CtFK8Pc2dFCHV68GnB3BGsunpwsbXZLI", "F24bvZCYxJ", "TOSHYJ1lEJvd7RJrf6C3asPns89jgyAB", "1i4XZgSUiEitKg1uirtbWyvJYEy72451", "xxTjtjFBsKHKUg72VLV3KyKqm", "tv2qbFeBoe5tOdCVBoBS0k7Q0eg7h6FY"};
    public static final String A02;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 55);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{73, 91, 95, 74, 41, 75, 14, 119, 106, 102, 109, 97, 118, 12, 47, 24, 24, 5, 24, 74, 8, 31, 3, 6, 14, 3, 4, Draft_75.CR, 74, 12, 3, 6, 15, 74, 37, 8, 0, 15, 9, 30, 47, 30, Draft_75.CR, 12, 26, 95, 58, 17, 9, 95, 41, 30, Draft_75.CR, 22, 30, 29, 19, 26};
    }

    static {
        A09();
        A02 = Z0.class.getSimpleName();
    }

    public Z0(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC06506z A02(HashMap<String, Z1> hashMap) {
        return new C1292Xc(SystemClock.elapsedRealtime(), A02(), hashMap, EnumC06496y.A0C);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException", "BadMethodUse-android.util.Log.e"})
    public static File A03(String str) {
        try {
            String substring = str.substring(0, str.lastIndexOf(File.separator));
            String fileName = str.substring(str.lastIndexOf(File.separator) + 1);
            return new File(substring, fileName);
        } catch (Exception e2) {
            Log.e(A02, A05(14, 26, 93), e2);
            return null;
        }
    }

    public static String A06(String str) {
        if (((str.hashCode() == 902502675 && str.equals(A05(6, 8, 5))) ? (char) 0 : (char) 65535) != 0) {
            String A05 = A05(0, 0, 28);
            if (A01[0].charAt(3) != 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "jdgM3VinY7vKBuJQR961ULiFKj7S";
            strArr[3] = "O0JYmDhqre";
            return A05;
        }
        return Environment.getExternalStorageDirectory().toString();
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static String A07(String regex) {
        String A05 = A05(0, 6, 66);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(A05).matcher(regex);
        while (matcher.find()) {
            String matchedPattern = matcher.group();
            matcher.appendReplacement(stringBuffer, A06(matchedPattern));
        }
        matcher.appendTail(stringBuffer);
        String regex2 = stringBuffer.toString();
        try {
            regex2 = new File(regex2).getCanonicalPath();
            return regex2;
        } catch (IOException e2) {
            Log.e(A02, A05(40, 18, 72), e2);
            return regex2;
        }
    }

    public final InterfaceC06356k A0G(List<C06346j> list) {
        return new Z2(this, list);
    }
}
