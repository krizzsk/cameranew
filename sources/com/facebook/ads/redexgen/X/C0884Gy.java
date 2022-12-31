package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* renamed from: com.facebook.ads.redexgen.X.Gy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0884Gy {
    public static byte[] A01;
    public static String[] A02 = {"BH2zNHpX", "Dnuq9wFIL2", "vBkvmD9EAd5t9FTNthVuCuoibAfWrGUa", "Nhu3hv03L3KjBzyMucsPwsjdroL1", "9TVwE8RhMB8DaYr8DWqJ6OPYy1", "9JupfOkL4WUcaojH", "ecCz7RACP0dYyLgy5uflHn", "VPA8JBGLf77hbCQNqSGQ8FIxNIe4WZlE"};
    public static final Pattern A03;
    public static final Pattern A04;
    public final StringBuilder A00 = new StringBuilder();

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 88);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{116, 22, 48, 76, 56, 55, 79, 91, 77, 94, 76, 56, 55, 79, 77, 66, 54, 42, 35, 4, 28, 11, 6, 3, 14, 74, 11, 6, 3, Draft_75.CR, 4, 7, 15, 4, 30, 74, 28, 11, 6, 31, 15, 80, 74, 106, 77, 85, 66, 79, 74, 71, 3, 66, 77, 64, 75, 76, 81, 3, 85, 66, 79, 86, 70, 25, 3, 42, 18, 16, 9, 9, 16, 23, 30, 89, 27, 24, 29, 89, 26, 12, 28, 89, 10, 28, Draft_75.CR, Draft_75.CR, 16, 23, 30, 67, 89, 118, 78, 76, 85, 85, 76, 75, 66, 5, 70, 80, 64, 5, 82, 76, 81, 77, 5, 71, 68, 65, 5, 77, 64, 68, 65, 64, 87, 31, 5, 22, 45, 40, 45, 44, 52, 45, 99, 32, 54, 38, 99, 48, 38, 55, 55, 42, 45, 36, 99, 51, 1, 6, 18, 16, 16, 39, 17, 1, 52, 5, 22, 23, 1, 22, 36, 95, 35, 81, 34, 59, 77, 57, 54, 78, 76, 57, 22, 78, 72, 72, 91, 57, 22, 78, 77, 57, 54, 78, 76, 77, 75, 79, 76, 90, 65, 41, 36, 33, 47, 38, 120, 116, 105, 82, 18, 19, 21, 30, 4, 21, 2, 91, 80, 90, 103, 116, 99, 56, 54, 63, 62, 35, 56, 63, 54, 113, 36, 63, 34, 36, 33, 33, 62, 35, 37, 52, 53, 113, 52, 63, 37, 56, 37, 40, 107, 113, 118, 119, 33, 44, 35, 42, 44, 37, 38, 52, 23, 18, 21, 30, 49, 41, 74, 78, 67, 67, 75, 66, 7, 11, 26, 25, 11, 20, 8, 18, 15, 18, 20, 21, 67, 88, 86, 89, 69, 109, 119, 100, 123, 121, 126, 107, 120, 126, 99, 52};
    }

    static {
        A05();
        A03 = Pattern.compile(A03(161, 26, 61));
        A04 = Pattern.compile(A03(3, 12, 60));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A00(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(A03(197, 6, 40))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals(A03(254, 6, 127))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                boolean equals = str.equals(A03(203, 3, 102));
                if (A02[3].length() != 10) {
                    A02[5] = "MJ40TcK0DidUTvS4";
                    if (equals) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                } else {
                    throw new RuntimeException();
                }
            case 109757538:
                if (str.equals(A03(281, 5, 82))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c == 1 || c == 2) {
                return 1;
            }
            if (c != 3) {
                Log.w(A03(141, 15, 60), A03(43, 22, 123) + str);
                return Integer.MIN_VALUE;
            }
            return 2;
        }
        return 0;
    }

    public static int A01(String str, int i2) {
        int indexOf = str.indexOf(62, i2);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layout.Alignment A02(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(A03(197, 6, 40))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals(A03(254, 6, 127))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (str.equals(A03(203, 3, 102))) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (str.equals(A03(IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 4, 24))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals(A03(272, 5, 105))) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (str.equals(A03(281, 5, 82))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (c == 2 || c == 3) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (c != 4 && c != 5) {
            Log.w(A03(141, 15, 60), A03(18, 25, 50) + str);
            return null;
        }
        return Layout.Alignment.ALIGN_OPPOSITE;
    }

    public static String A04(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return C0923Il.A0m(trim, A03(156, 5, 39))[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
        if (r4 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        r5.setSpan(new android.text.style.StrikethroughSpan(), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
        if (r6.A0P() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        r5.setSpan(new android.text.style.UnderlineSpan(), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r6.A0N() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        r5.setSpan(new android.text.style.ForegroundColorSpan(r6.A06()), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
        r4 = r6.A0M();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
        if (com.facebook.ads.redexgen.X.C0884Gy.A02[2].charAt(8) == 'y') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        com.facebook.ads.redexgen.X.C0884Gy.A02[3] = "V2wLbBmXpgkEOhtSXmoT1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (r4 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
        r5.setSpan(new android.text.style.BackgroundColorSpan(r6.A05()), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
        r4 = r6.A0H();
        r2 = com.facebook.ads.redexgen.X.C0884Gy.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
        if (r2[0].length() == r2[6].length()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b3, code lost:
        com.facebook.ads.redexgen.X.C0884Gy.A02[3] = "i3U";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
        r5.setSpan(new android.text.style.TypefaceSpan(r6.A0H()), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cc, code lost:
        if (r6.A0A() == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
        r5.setSpan(new android.text.style.AlignmentSpan.Standard(r6.A0A()), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00da, code lost:
        r1 = r6.A07();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00df, code lost:
        if (r1 == 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e2, code lost:
        if (r1 == 2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e5, code lost:
        if (r1 == 3) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e7, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
        r5.setSpan(new android.text.style.RelativeSizeSpan(r6.A04() / 100.0f), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f8, code lost:
        r5.setSpan(new android.text.style.RelativeSizeSpan(r6.A04()), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0105, code lost:
        r5.setSpan(new android.text.style.AbsoluteSizeSpan((int) r6.A04(), true), r7, r8, 33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0113, code lost:
        r2 = com.facebook.ads.redexgen.X.C0884Gy.A02;
        r2[0] = "Zhb0mUGg";
        r2[6] = "DqzbmkeRFCAudTa8qvbD1E";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011f, code lost:
        if (r4 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012a, code lost:
        if (r4 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0133, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A06(android.text.SpannableStringBuilder r5, com.facebook.ads.redexgen.X.C0879Gt r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0884Gy.A06(android.text.SpannableStringBuilder, com.facebook.ads.redexgen.X.Gt, int, int):void");
    }

    public static void A07(String str, SpannableStringBuilder spannableStringBuilder) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == 3309) {
            if (str.equals(A03(206, 2, 88))) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 3464) {
            if (str.equals(A03(252, 2, 5))) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 96708) {
            if (hashCode == 3374865 && str.equals(A03(260, 4, 49))) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals(A03(192, 3, 65))) {
                c = 3;
            }
            c = 65535;
        }
        if (c == 0) {
            spannableStringBuilder.append('<');
        } else if (c == 1) {
            spannableStringBuilder.append('>');
        } else if (c == 2) {
            spannableStringBuilder.append(' ');
        } else if (c != 3) {
            Log.w(A03(141, 15, 60), A03(209, 31, 9) + str + A03(16, 2, 85));
        } else {
            spannableStringBuilder.append('&');
        }
    }

    public static void A08(String str, C0881Gv c0881Gv) {
        String A032 = A03(141, 15, 60);
        Matcher matcher = A04.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if (A03(248, 4, 35).equals(group)) {
                    A09(group2, c0881Gv);
                } else if (A03(187, 5, 16).equals(group)) {
                    c0881Gv.A0B(A02(group2));
                } else if (A03(264, 8, 35).equals(group)) {
                    A0A(group2, c0881Gv);
                } else if (A03(277, 4, 70).equals(group)) {
                    c0881Gv.A05(C0885Gz.A00(group2));
                } else {
                    Log.w(A032, A03(121, 20, 27) + group + A03(15, 1, 32) + group2);
                }
            } catch (NumberFormatException unused) {
                Log.w(A032, A03(65, 26, 33) + matcher.group());
            }
        }
    }

    public static void A09(String str, C0881Gv c0881Gv) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            c0881Gv.A06(A00(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            c0881Gv.A06(Integer.MIN_VALUE);
        }
        if (str.endsWith(A03(2, 1, 77))) {
            c0881Gv.A03(C0885Gz.A00(str)).A07(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        C0881Gv A032 = c0881Gv.A03(parseInt);
        String[] strArr = A02;
        if (strArr[0].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "nfwpqDM6";
        strArr2[6] = "ldPC0GHiWge259aJMdVkFd";
        A032.A07(1);
    }

    public static void A0A(String str, C0881Gv c0881Gv) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            c0881Gv.A08(A00(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            c0881Gv.A08(Integer.MIN_VALUE);
        }
        c0881Gv.A04(C0885Gz.A00(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124 A[LOOP:0: B:51:0x0122->B:52:0x0124, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A0B(java.lang.String r11, com.facebook.ads.redexgen.X.C0882Gw r12, android.text.SpannableStringBuilder r13, java.util.List<com.facebook.ads.redexgen.X.C0879Gt> r14, java.util.List<com.facebook.ads.redexgen.X.C0883Gx> r15) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0884Gy.A0B(java.lang.String, com.facebook.ads.redexgen.X.Gw, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    public static void A0C(String str, String str2, C0881Gv c0881Gv, List<C0879Gt> list) {
        C0882Gw startTag;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                int indexOf = str2.indexOf(59, i2 + 1);
                int indexOf2 = str2.indexOf(32, i2 + 1);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    int entityEndIndex = i2 + 1;
                    A07(str2.substring(entityEndIndex, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) A03(1, 1, 110));
                    }
                    i2 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                    i2++;
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i3 = i2 + 1;
                int length = str2.length();
                if (A02[3].length() == 10) {
                    throw new RuntimeException();
                }
                A02[7] = "huABVhch9erSIKd70DjqaQjDgv4JUQcV";
                if (i3 >= length) {
                    i2++;
                } else {
                    int i4 = i2;
                    boolean z = str2.charAt(i4 + 1) == '/';
                    i2 = A01(str2, i4 + 1);
                    boolean z2 = str2.charAt(i2 + (-2)) == '/';
                    String substring = str2.substring((z ? 2 : 1) + i4, z2 ? i2 - 2 : i2 - 1);
                    String tagName = A04(substring);
                    if (tagName != null && A0E(tagName)) {
                        if (z) {
                            do {
                                boolean isEmpty = arrayDeque.isEmpty();
                                String fullTagExpression = A02[5];
                                if (fullTagExpression.length() != 16) {
                                    String[] strArr = A02;
                                    strArr[0] = "eUUkvlij";
                                    strArr[6] = "fkUA9DE8mZusd0jqihcBtc";
                                    if (isEmpty) {
                                        break;
                                    }
                                    startTag = (C0882Gw) arrayDeque.pop();
                                    A0B(str, startTag, spannableStringBuilder, list, arrayList);
                                } else {
                                    A02[7] = "xjA9LPEJe2T86ajW2mUni2naxM9TfZ4G";
                                    if (isEmpty) {
                                        break;
                                    }
                                    startTag = (C0882Gw) arrayDeque.pop();
                                    A0B(str, startTag, spannableStringBuilder, list, arrayList);
                                }
                            } while (!startTag.A01.equals(tagName));
                        } else if (!z2) {
                            arrayDeque.push(C0882Gw.A01(substring, spannableStringBuilder.length()));
                        }
                    }
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            A0B(str, (C0882Gw) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        A0B(str, C0882Gw.A00(), spannableStringBuilder, list, arrayList);
        c0881Gv.A0C(spannableStringBuilder);
    }

    public static void A0D(List<C0879Gt> list, String str, C0882Gw c0882Gw, List<C0883Gx> list2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0879Gt c0879Gt = list.get(i2);
            int A09 = c0879Gt.A09(str, c0882Gw.A01, c0882Gw.A03, c0882Gw.A02);
            if (A09 > 0) {
                list2.add(new C0883Gx(A09, c0879Gt));
            }
        }
        Collections.sort(list2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0026 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0E(java.lang.String r10) {
        /*
            int r1 = r10.hashCode()
            r0 = 98
            r9 = 0
            r7 = 5
            r6 = 4
            r5 = 3
            r4 = 2
            r3 = 1
            if (r1 == r0) goto L9f
            r0 = 99
            if (r1 == r0) goto L8e
            r0 = 105(0x69, float:1.47E-43)
            if (r1 == r0) goto L64
            r0 = 3314158(0x3291ee, float:4.644125E-39)
            if (r1 == r0) goto L53
            r0 = 117(0x75, float:1.64E-43)
            if (r1 == r0) goto L42
            r0 = 118(0x76, float:1.65E-43)
            if (r1 == r0) goto L31
        L23:
            r0 = -1
        L24:
            if (r0 == 0) goto Lb1
            if (r0 == r3) goto Lb1
            if (r0 == r4) goto Lb1
            if (r0 == r5) goto Lb1
            if (r0 == r6) goto Lb1
            if (r0 == r7) goto Lb1
            return r9
        L31:
            r2 = 287(0x11f, float:4.02E-43)
            r1 = 1
            r0 = 26
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 5
            goto L24
        L42:
            r2 = 286(0x11e, float:4.01E-43)
            r1 = 1
            r0 = 78
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 4
            goto L24
        L53:
            r2 = 240(0xf0, float:3.36E-43)
            r1 = 4
            r0 = 21
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 3
            goto L24
        L64:
            r2 = 208(0xd0, float:2.91E-43)
            r1 = 1
            r0 = 82
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r8 = r10.equals(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0884Gy.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 10
            if (r1 == r0) goto Lb2
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0884Gy.A02
            java.lang.String r1 = "tlO5iwEB"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "pEnQwZlkHTTTq7cfdXWDKW"
            r0 = 6
            r2[r0] = r1
            if (r8 == 0) goto L23
            r0 = 2
            goto L24
        L8e:
            r2 = 196(0xc4, float:2.75E-43)
            r1 = 1
            r0 = 41
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 1
            goto L24
        L9f:
            r2 = 195(0xc3, float:2.73E-43)
            r1 = 1
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 0
            goto L24
        Lb1:
            return r3
        Lb2:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0884Gy.A0E(java.lang.String):boolean");
    }

    public static boolean A0F(String str, Matcher matcher, IV iv, C0881Gv c0881Gv, StringBuilder sb, List<C0879Gt> list) {
        try {
            c0881Gv.A0A(C0885Gz.A01(matcher.group(1))).A09(C0885Gz.A01(matcher.group(2)));
            A08(matcher.group(3), c0881Gv);
            sb.setLength(0);
            while (true) {
                String A0P = iv.A0P();
                if (!TextUtils.isEmpty(A0P)) {
                    if (sb.length() > 0) {
                        sb.append(A03(0, 1, 38));
                    }
                    sb.append(A0P.trim());
                } else {
                    A0C(str, sb.toString(), c0881Gv, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(A03(141, 15, 60), A03(91, 30, 125) + matcher.group());
            return false;
        }
    }

    public final boolean A0G(IV iv, C0881Gv c0881Gv, List<C0879Gt> list) {
        String A0P = iv.A0P();
        if (A0P == null) {
            return false;
        }
        Matcher matcher = A03.matcher(A0P);
        if (matcher.matches()) {
            return A0F(null, matcher, iv, c0881Gv, this.A00, list);
        }
        String A0P2 = iv.A0P();
        if (A0P2 == null) {
            return false;
        }
        Matcher matcher2 = A03.matcher(A0P2);
        if (matcher2.matches()) {
            return A0F(A0P.trim(), matcher2, iv, c0881Gv, this.A00, list);
        }
        return false;
    }
}
