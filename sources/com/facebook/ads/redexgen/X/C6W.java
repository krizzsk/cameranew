package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.6W  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6W {
    public static final String A08 = C6W.class.getSimpleName();
    public final int A00;
    public final Context A01;
    public final AnonymousClass61 A02;
    public final C6I A03;
    public final C1406ac A04;
    public final C1405ab A05;
    public final C1404aa A06;
    public final AnonymousClass73 A07;

    /* JADX WARN: Type inference failed for: r2v0, types: [com.facebook.ads.redexgen.X.6Z] */
    public C6W(final Context context, final AnonymousClass61 anonymousClass61) {
        final C06256a c06256a = new C06256a(new C06276c(context, anonymousClass61));
        ?? r2 = new Object(context, c06256a, anonymousClass61) { // from class: com.facebook.ads.redexgen.X.6Z
            public static byte[] A07;
            public static String[] A08 = {"Nj4TqS4QnuHXli7th2heksSDMg2Z", "RSouwChKZWzGhunCWCHEu7HkA4YX3nJn", "5fVToSkDBkuydhS3BZw", "o644y0JXIVns0cvIXh4fs0HcxxzuSHU9", "L6wIWC4w0dKe6dclyvwc8pXUf7KK", "NV8kH7O4XMciCHnyYHa8lR80N34PEowy", "S6E1x33SpjjOrFFRELF", "CEXaqd5N8FzuUquPi7vxqko1f9a5yOv1"};
            public int A00;
            public final AnonymousClass61 A01;
            public final C1406ac A02;
            public final C1405ab A03;
            public final C1404aa A04;
            public final C06256a A05;
            public final AnonymousClass73 A06;

            public static String A02(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 75);
                }
                return new String(copyOfRange);
            }

            public static void A04() {
                A07 = new byte[]{-31, 4};
            }

            static {
                A04();
            }

            {
                this.A03 = new C1405ab(context, anonymousClass61);
                this.A04 = new C1404aa(context, anonymousClass61);
                this.A02 = new C1406ac(context, anonymousClass61);
                this.A06 = new AnonymousClass73(context, anonymousClass61);
                this.A05 = c06256a;
                this.A01 = anonymousClass61;
                A05();
            }

            @Nullable
            public static C06346j A00(int i2, String str, int i3, int i4) {
                if (i2 != 10300) {
                    if (i2 == 10920) {
                        return A01(str, i3, i4, EnumC06336i.A03);
                    }
                    if (i2 != 10940 && i2 != 10941) {
                        switch (i2) {
                            case 10943:
                            case 10944:
                            case 10945:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                return A01(str, i3, i4, EnumC06336i.A04);
            }

            @Nullable
            public static C06346j A01(String str, int i2, int i3, EnumC06336i enumC06336i) {
                int i4 = C6Y.A00[enumC06336i.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return new C06346j(str, i2, i3);
                }
                return new C06346j(Integer.valueOf(Integer.parseInt(str)), i2, i3);
            }

            @Nullable
            private List<C06346j> A03(int i2) throws JSONException {
                ArrayList arrayList = new ArrayList();
                Map<Integer, String> A0i = this.A01.A0i();
                if (A0i == null || A0i.isEmpty() || !A0i.containsKey(Integer.valueOf(i2))) {
                    return arrayList;
                }
                JSONObject jSONObject = new JSONObject(A0i.get(Integer.valueOf(i2)));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray != null && jSONArray.length() == 2) {
                        int i3 = jSONArray.getInt(0);
                        int minApiLevel = jSONArray.getInt(1);
                        arrayList.add(A00(i2, next, i3, minApiLevel));
                    }
                }
                return arrayList;
            }

            @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
            private final void A05() {
                String A02 = A02(1, 1, 69);
                try {
                    JSONObject jSONObject = new JSONObject(this.A01.A0h());
                    Integer valueOf = jSONObject.has(A02) ? Integer.valueOf(jSONObject.getInt(A02)) : null;
                    if (valueOf == null) {
                        return;
                    }
                    this.A00 = valueOf.intValue();
                    this.A06.A06(this.A00);
                    A06(jSONObject.getJSONArray(A02(0, 1, 51)));
                } catch (Throwable th) {
                    C6D.A03(th);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
                if (r4.containsKey(r8) == false) goto L35;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00b5, code lost:
                if (r9 == false) goto L36;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
                if (r9 == false) goto L48;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
                r0 = r10.A05.A01(r6, r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
                r1 = new com.facebook.ads.redexgen.X.C06326h(r6, r5, r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
                if (r5.contains(com.facebook.ads.redexgen.X.EnumC06396o.A07) == false) goto L42;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
                r10.A06.A07(r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00d7, code lost:
                if (r5.contains(com.facebook.ads.redexgen.X.EnumC06396o.A0B) == false) goto L46;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
                r10.A03.A03(r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
                r0 = r4.get(java.lang.Integer.valueOf(r6));
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00fb, code lost:
                if (r4.containsKey(r8) == false) goto L35;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00fe, code lost:
                r10.A04.A02(r1);
             */
            @android.annotation.SuppressLint({"BadMethodUse-android.util.Log.e"})
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private void A06(org.json.JSONArray r11) throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 262
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6Z.A06(org.json.JSONArray):void");
            }

            private final boolean A07(EnumSet<EnumC06396o> enumSet) {
                return (enumSet.contains(this.A01.A0a()) && enumSet.contains(EnumC06396o.A05) && enumSet.contains(EnumC06396o.A06) && !enumSet.contains(EnumC06396o.A0A)) ? false : true;
            }

            public final int A08() {
                return this.A00;
            }

            public final C1406ac A09() {
                return this.A02;
            }

            public final C1405ab A0A() {
                return this.A03;
            }

            public final C1404aa A0B() {
                return this.A04;
            }

            public final AnonymousClass73 A0C() {
                return this.A06;
            }
        };
        this.A01 = context;
        this.A05 = r2.A0A();
        this.A06 = r2.A0B();
        this.A04 = r2.A09();
        this.A00 = r2.A08();
        this.A02 = anonymousClass61;
        this.A03 = new C6I();
        this.A03.A01(this.A04);
        this.A07 = r2.A0C();
        this.A07.A05();
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public static JSONObject A00() {
        JSONObject jsonSignalObject = new JSONObject();
        Map<Integer, AnonymousClass66<AbstractC06506z>> A03 = C06376m.A01().A03();
        if (A03 == null || A03.isEmpty()) {
            return jsonSignalObject;
        }
        try {
            for (Integer num : A03.keySet()) {
                List<AbstractC06506z> A032 = A03.get(num).A03();
                JSONArray jSONArray = new JSONArray();
                for (AbstractC06506z abstractC06506z : A032) {
                    jSONArray.put(abstractC06506z.A09(true));
                }
                jsonSignalObject.put(num.toString(), jSONArray);
            }
        } catch (Throwable th) {
            C6D.A03(th);
        }
        return jsonSignalObject;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    private void A01(String str, EnumC06366l enumC06366l, EnumC06406p enumC06406p) {
        C6B A0Y = this.A02.A0Y();
        if (A0Y != null) {
            int sessionEndTime = (int) (System.currentTimeMillis() / 1000);
            A0Y.A9A(AnonymousClass78.A05(), str, this.A00, enumC06366l.A03(), sessionEndTime, A00(), enumC06406p);
        }
        AnonymousClass78.A0B(this.A02, AnonymousClass68.A07.A02(), str);
    }

    public final void A02() {
        this.A03.A00();
    }

    public final void A03(EnumC06366l enumC06366l) {
        this.A04.A03(enumC06366l, this.A01);
    }

    public final void A04(EnumC06386n enumC06386n, EnumC06366l enumC06366l, @Nullable String str) {
        A05(enumC06386n, enumC06366l, str, EnumC06406p.A04);
    }

    public final void A05(EnumC06386n enumC06386n, EnumC06366l enumC06366l, @Nullable String str, EnumC06406p enumC06406p) {
        this.A05.A04(enumC06366l);
        if (enumC06386n == EnumC06386n.A02) {
            this.A06.A03(enumC06366l);
            if (str != null) {
                A01(str, enumC06366l, enumC06406p);
            }
        }
    }

    public final boolean A06() {
        List<C06326h> A02 = this.A05.A02();
        return (A02 == null || A02.isEmpty()) ? false : true;
    }
}
