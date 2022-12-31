package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.monitor.connection.HttpConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* renamed from: com.facebook.ads.redexgen.X.cy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1543cy implements InterfaceC04800i, InterfaceC04840n {
    public static byte[] A0e;
    public static String[] A0f = {"OTBhn", "woE0GsYsDC", "jJJsRhZ6eh", "RbmDZKGZyk", "MbYnCV2deeCvNEpfUSPgn7RvJuamywdV", "va4Mi1JJiq4w08mNkhVxy34L1bzftr4W", "QQZqW8pW387BdDH3gcXSwYVoWAeaIxNz", "E72k8"};
    public static final String A0g;
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A05;
    public int A07;
    public int A08;
    public long A09;
    public Uri A0A;
    public EnumC04790h A0B;
    public AnonymousClass11 A0C;
    public AnonymousClass16 A0D;
    public XT A0E;
    @Nullable
    public JT A0F;
    public InterfaceC0952Jq A0G;
    public C0953Jr A0H;
    public C0953Jr A0I;
    public C0953Jr A0J;
    public C0954Js A0K;
    public EnumC0958Jw A0L;
    public String A0M;
    public String A0N;
    @Nullable
    public String A0O;
    public String A0P;
    public String A0Q;
    public String A0R;
    public String A0S;
    public Collection<String> A0T;
    public List<C1198Tj> A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public HashMap<String, String> A0U = new HashMap<>();
    public int A06 = 200;
    public int A02 = -1;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0e, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 106);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0e = new byte[]{124, 89, 126, 85, 82, 84, 94, 88, 78, 95, 122, Byte.MAX_VALUE, 110, 106, 123, 108, 62, Byte.MAX_VALUE, 114, 108, 123, Byte.MAX_VALUE, 122, 103, 62, 114, 113, Byte.MAX_VALUE, 122, 123, 122, 62, 122, Byte.MAX_VALUE, 106, Byte.MAX_VALUE, 106, 94, 79, 66, 78, 69, 72, 78, 11, 101, 78, 95, 92, 68, 89, 64, 11, 103, 68, 74, 79, 78, 79, 43, 4, 1, 11, 3, 72, 0, 9, 24, 24, Draft_75.CR, 6, Draft_75.CR, 12, 72, 7, 6, 72, 4, 7, 11, 3, 27, 11, 26, Draft_75.CR, Draft_75.CR, 6, 72, 9, 12, 96, 79, 74, 64, 72, 3, 79, 76, 68, 68, 70, 71, 16, 39, 39, 58, 39, 117, 48, 45, 48, 54, 32, 33, 60, 59, 50, 117, 52, 54, 33, 60, 58, 59, 106, 81, 94, 93, 83, 90, 31, 75, 80, 31, 79, 94, 77, 76, 90, 31, 92, 94, 77, 80, 74, 76, 90, 83, 31, 91, 94, 75, 94, 17, 34, 39, 28, 32, 43, 44, 42, 32, 38, 48, 28, 42, 32, 44, 45, 85, 80, 107, 87, 92, 91, 93, 87, 81, 71, 107, 88, 93, 90, 95, 107, 65, 70, 88, 93, 88, 99, 72, 78, 93, 82, 79, 80, 93, 72, 85, 83, 82, 3, 6, 20, 7, 16, 22, 11, 17, 7, 16, 61, 12, 3, 15, 7, 73, 70, 119, 68, 71, 79, 71, 119, 92, 81, 88, 77, 0, Draft_75.CR, 6, 27, 29, 31, 18, 18, 33, 10, 17, 33, 31, 29, 10, 23, 17, 16, 50, 48, 35, 53, 50, 63, 37, 79, 77, 94, 72, 69, 66, 72, 62, 60, 47, 50, 40, 46, 56, 49, 18, 30, 31, 5, 16, 24, 31, 20, 3, 46, 7, 24, 20, 6, 16, 19, 24, 29, 24, 5, 8, 46, 18, 25, 20, 18, 26, 46, 24, 31, 5, 20, 3, 7, 16, 29, 6, 10, 11, 17, 4, 12, 11, 0, 23, 58, 19, 12, 0, 18, 4, 7, 12, 9, 12, 17, 28, 58, 0, 11, 4, 7, 9, 0, 1, 7, 16, 36, 37, 52, 37, 35, 52, 41, 47, 46, 31, 51, 52, 50, 41, 46, 39, 51, 123, 112, Byte.MAX_VALUE, 124, 114, 123, 65, 109, 112, Byte.MAX_VALUE, 110, 109, 118, 113, 106, 65, 114, 113, 121, 18, 25, 22, 21, 27, 18, 40, 1, 30, 18, 0, 40, 27, 24, 16, 39, 44, 33, 48, 59, 50, 54, 39, 38, 29, 33, 50, 47, 33, 37, 38, 35, 24, 36, 40, 42, 42, 38, 41, 35, 79, 66, 70, 67, 75, 78, 73, 66, 69, 79, 67, 66, 102, 98, 110, 104, 106, 25, 30, 6, 17, 28, 25, 20, 17, 4, 25, 31, 30, 47, 18, 21, 24, 17, 6, 25, 31, 2, 71, 66, 69, 64, 116, 79, 78, 88, 72, 89, 66, 91, 95, 66, 68, 69, 31, 14, 29, 28, 6, 1, 8, 75, 90, 78, 72, 94, 100, 79, 73, 90, 85, 72, 87, 90, 79, 82, 84, 85, 73, 85, 88, 64, 102, 77, 75, 88, 87, 74, 85, 88, 77, 80, 86, 87, 73, 75, 86, 84, 86, 77, 92, 93, 102, 77, 75, 88, 87, 74, 85, 88, 77, 80, 86, 87, 0, 23, 3, 7, 23, 1, 6, 45, 27, 22, 110, 115, 124, 109, 110, 117, 114, 105, 54, 43, 36, 53, 54, 45, 42, 49, 26, 38, 42, 40, 53, 55, 32, 54, 54, 26, 52, 48, 36, 41, 44, 49, 60, 4, 25, 22, 7, 4, 31, 24, 3, 40, 27, 24, 16, 40, 19, 18, 27, 22, 14, 40, 4, 18, 20, 24, 25, 19, 112, 108, 96, 106, 98, 111, 92, 96, 108, 109, 119, 102, 123, 119, 5, 6, 25, 24, 5, 25, 4, 19, 18, 41, 2, 4, 23, 24, 5, 26, 23, 2, 31, 25, 24, 39, 32, 53, 38, 11, 38, 53, 32, 61, 58, 51, 34, 36, 51, 37, 56, 37, 61, 52, 42, 55, 42, 50, 59, 72, 78, 88, 89, 98, 79, 88, 77, 82, 79, 73, 98, 72, 79, 81, 121, 102, 107, 106, 96, 80, 110, 122, 123, 96, Byte.MAX_VALUE, 99, 110, 118, 80, 106, 97, 110, 109, 99, 106, 107, 12, 19, 30, 31, 21, 37, 23, 10, 30, 36, 59, 54, 55, 61, Draft_75.CR, 34, 32, 55, 62, 61, 51, 54, Draft_75.CR, 33, 59, 40, 55, Draft_75.CR, 48, 43, 38, 55, 33, 107, 116, 121, 120, 114, 66, 104, 111, 113, 59, 36, 40, 58, 105, 118, 122, 104, 126, 125, 118, 115, 118, 107, 102, 64, 124, 119, 122, 124, 116, 64, 118, 113, 118, 107, 118, 126, 115, 64, 123, 122, 115, 126, 102, 87, 72, 68, 86, 64, 67, 72, 77, 72, 85, 88, 126, 66, 73, 68, 66, 74, 126, 72, 79, 85, 68, 83, 87, 64, 77};
    }

    static {
        A05();
        A0g = C1543cy.class.getSimpleName();
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        String A01 = A01(732, 4, 39);
        if (map.containsKey(A01)) {
            hashMap.put(A01, map.get(A01));
        }
        String A012 = A01(536, 8, 119);
        if (map.containsKey(A012)) {
            hashMap.put(A012, map.get(A012));
        }
        return hashMap;
    }

    private void A04() {
        if (!this.A0a) {
            JT jt = this.A0F;
            if (A0f[2].length() != 10) {
                throw new RuntimeException();
            }
            A0f[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
            if (jt != null) {
                jt.ACv(this.A0Q);
            }
            this.A0a = true;
        }
    }

    private void A06(XT xt, JSONObject jSONObject, JT jt, String str, int i2, int i3) {
        this.A0d = true;
        this.A0E = xt;
        this.A0F = jt;
        this.A02 = i2;
        this.A01 = i3;
        A08(jSONObject, str);
    }

    private void A07(Map<String, String> map, Map<String, String> map2) {
        try {
            Map<String, String> urlParams = A03(map);
            new Handler().postDelayed(new C1544cz(this, map2, urlParams), this.A05 * 1000);
        } catch (Exception unused) {
        }
    }

    private void A08(JSONObject jSONObject, String str) {
        if (!this.A0X) {
            if (jSONObject == null) {
                return;
            }
            LN.A02(this.A0E, A01(36, 23, 65));
            this.A0N = str;
            this.A0P = jSONObject.optString(A01(526, 10, 24));
            this.A00 = jSONObject.optInt(A01(217, 12, 66), 0);
            this.A0O = jSONObject.optString(A01(387, 13, 40));
            String A02 = C0988Le.A02(jSONObject, A01(400, 12, 45));
            this.A0A = TextUtils.isEmpty(A02) ? null : Uri.parse(A02);
            String[] strArr = new String[12];
            strArr[0] = A01(202, 15, 8);
            strArr[1] = A01(648, 5, 52);
            strArr[2] = A01(VideoEdit2Activity.MIN_SCALED_SIZE, 8, 59);
            strArr[3] = A01(DeeplinkCallback.ERROR_URL_FORMAT_ERROR, 8, 77);
            strArr[4] = A01(229, 4, 8);
            strArr[5] = A01(594, 14, 105);
            String[] strArr2 = A0f;
            if (strArr2[1].length() == strArr2[3].length()) {
                String[] strArr3 = A0f;
                strArr3[0] = "EgjH3";
                strArr3[7] = "aXmwT";
                strArr[6] = A01(450, 16, 65);
                strArr[7] = A01(TypedValues.MotionType.TYPE_DRAW_PATH, 21, 28);
                strArr[8] = A01(188, 14, 86);
                strArr[9] = A01(TypedValues.PositionType.TYPE_PERCENT_X, 20, 83);
                strArr[10] = A01(490, 16, 83);
                strArr[11] = A01(473, 17, 81);
                for (String str2 : strArr) {
                    HashMap<String, String> hashMap = this.A0U;
                    String key = C0988Le.A02(jSONObject, str2);
                    hashMap.put(str2, key);
                    if (A0f[4].charAt(15) == 'f') {
                        A0f[5] = "eWhcqXkmKwACVp6tQL5WW3qntxITuvc7";
                    }
                }
                String A01 = A01(233, 14, 20);
                String A022 = C0988Le.A02(jSONObject, A01);
                if (!TextUtils.isEmpty(A022)) {
                    HashMap<String, String> hashMap2 = this.A0U;
                    if (A0f[6].charAt(13) != 'D') {
                        A0f[6] = "fJLCRXTMzJxf7DhTFL7Dp6MTDwlQmm1t";
                        hashMap2.put(A01, A022);
                    } else {
                        A0f[2] = "EZfL37EHMq";
                        hashMap2.put(A01, A022);
                    }
                }
                this.A0D = C1526ch.A02(jSONObject, this.A0E);
                String callToAction = A01(TypedValues.CycleType.TYPE_EASING, 4, 70);
                this.A0I = C0953Jr.A00(jSONObject.optJSONObject(callToAction));
                String callToAction2 = A01(TypedValues.CycleType.TYPE_WAVE_OFFSET, 5, 101);
                this.A0J = C0953Jr.A00(jSONObject.optJSONObject(callToAction2));
                String callToAction3 = A01(629, 11, 62);
                this.A0K = C0954Js.A00(jSONObject.optJSONObject(callToAction3));
                String callToAction4 = A01(653, 15, 87);
                this.A0Q = C0988Le.A02(jSONObject, callToAction4);
                String callToAction5 = A01(372, 15, 29);
                this.A0b = jSONObject.optBoolean(callToAction5);
                String callToAction6 = A01(353, 19, 116);
                this.A0c = jSONObject.optBoolean(callToAction6);
                String callToAction7 = A01(569, 25, 29);
                this.A05 = jSONObject.optInt(callToAction7, 4);
                String callToAction8 = A01(544, 25, 47);
                this.A04 = jSONObject.optInt(callToAction8, 0);
                String callToAction9 = A01(736, 31, 117);
                this.A07 = jSONObject.optInt(callToAction9, 0);
                String callToAction10 = A01(767, 26, 75);
                this.A08 = jSONObject.optInt(callToAction10, 1000);
                String callToAction11 = A01(154, 15, 41);
                JSONObject optJSONObject = jSONObject.optJSONObject(callToAction11);
                if (optJSONObject != null) {
                    this.A0H = C0953Jr.A00(optJSONObject);
                }
                String callToAction12 = A01(169, 19, 94);
                this.A0M = C0988Le.A02(jSONObject, callToAction12);
                String callToAction13 = A01(HttpConnection.HTTP_TOO_MANY_REQUESTS, 21, 26);
                this.A0B = EnumC04790h.A00(jSONObject.optString(callToAction13));
                JSONArray jSONArray = null;
                try {
                    String callToAction14 = A01(336, 17, 42);
                    jSONArray = new JSONArray(jSONObject.optString(callToAction14));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.A0T = C04810j.A01(jSONArray);
                String callToAction15 = A01(723, 9, 119);
                this.A0S = C0988Le.A02(jSONObject, callToAction15);
                String callToAction16 = A01(699, 24, 56);
                this.A09 = jSONObject.optLong(callToAction16, -1L);
                String callToAction17 = A01(690, 9, 16);
                this.A0R = C0988Le.A02(jSONObject, callToAction17);
                String A012 = A01(668, 22, 101);
                if (!jSONObject.has(A012)) {
                    this.A0L = EnumC0958Jw.A03;
                } else {
                    this.A0L = jSONObject.optBoolean(A012) ? EnumC0958Jw.A05 : EnumC0958Jw.A04;
                }
                String callToAction18 = A01(305, 29, 15);
                this.A0W = jSONObject.optBoolean(callToAction18);
                String callToAction19 = A01(269, 36, 27);
                this.A03 = jSONObject.optInt(callToAction19, 100);
                try {
                    String callToAction20 = A01(261, 8, 55);
                    JSONArray optJSONArray = jSONObject.optJSONArray(callToAction20);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            C1543cy c1543cy = new C1543cy();
                            c1543cy.A06(this.A0E, optJSONArray.getJSONObject(i2), this.A0F, this.A0N, i2, length);
                            arrayList.add(new C1198Tj(this.A0E, c1543cy, (AnonymousClass95) null, this.A0G));
                        }
                        this.A0V = arrayList;
                    }
                } catch (JSONException e3) {
                    this.A0E.A06().A8q(A01(466, 7, 5), C06808m.A1x, new C06818n(e3));
                    Log.e(A0g, A01(124, 30, 85), e3);
                }
                this.A0X = true;
                this.A0Y = A09();
                return;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException(A01(9, 27, 116));
    }

    private boolean A09() {
        if (((!this.A0d && !TextUtils.isEmpty(this.A0U.get(A01(202, 15, 8)))) || (!TextUtils.isEmpty(this.A0U.get(A01(648, 5, 52))) && this.A0d)) && (this.A0I != null || this.A0d)) {
            C0953Jr c0953Jr = this.A0J;
            if (A0f[2].length() != 10) {
                throw new RuntimeException();
            }
            A0f[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            if (c0953Jr != null || A75() == AdPlacementType.NATIVE_BANNER) {
                return true;
            }
        }
        return false;
    }

    public final int A0A() {
        return this.A00;
    }

    public final int A0B() {
        return this.A01;
    }

    public final int A0C() {
        return this.A02;
    }

    public final int A0D() {
        return this.A03;
    }

    public final int A0E() {
        int i2 = this.A04;
        if (i2 < 0 || i2 > 100) {
            return 0;
        }
        return i2;
    }

    public final int A0F() {
        return this.A06;
    }

    public final int A0G() {
        return this.A07;
    }

    public final int A0H() {
        return this.A08;
    }

    public final AnonymousClass16 A0I() {
        return this.A0D;
    }

    public final C0953Jr A0J() {
        if (!A0h()) {
            return null;
        }
        return this.A0H;
    }

    public final C0953Jr A0K() {
        if (!A0h()) {
            return null;
        }
        return this.A0J;
    }

    public final C0953Jr A0L() {
        if (!A0h()) {
            return null;
        }
        return this.A0I;
    }

    public final C0954Js A0M() {
        if (!A0h()) {
            return null;
        }
        A04();
        return this.A0K;
    }

    public final EnumC0958Jw A0N() {
        if (!A0h()) {
            return EnumC0958Jw.A03;
        }
        return this.A0L;
    }

    public final Long A0O() {
        if (!A0h()) {
            return -1L;
        }
        return Long.valueOf(this.A09);
    }

    public final String A0P() {
        if (!A0h()) {
            return null;
        }
        A04();
        return C1001Lr.A01(this.A0U.get(A01(229, 4, 8)));
    }

    public final String A0Q() {
        if (!A0h()) {
            return null;
        }
        return this.A0M;
    }

    public final String A0R() {
        if (A0h()) {
            return A01(0, 9, 87);
        }
        if (A0f[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        A0f[4] = "6LnlrboEXfVkWbJfSSNj7sObvXF9GrkL";
        return null;
    }

    public final String A0S() {
        return this.A0P;
    }

    public final String A0T() {
        if (!A0h()) {
            return null;
        }
        return this.A0R;
    }

    public final String A0U() {
        if (!A0h()) {
            return null;
        }
        return this.A0S;
    }

    @Nullable
    public final String A0V(String str) {
        if (!A0h()) {
            return null;
        }
        A04();
        return this.A0U.get(str);
    }

    public final List<C1198Tj> A0W() {
        if (!A0h()) {
            return null;
        }
        return this.A0V;
    }

    public final void A0X() {
        Iterator<C1198Tj> it;
        List<C1198Tj> list = this.A0V;
        if (list == null) {
            return;
        }
        boolean isEmpty = list.isEmpty();
        if (A0f[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        A0f[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
        if (!isEmpty) {
            List<C1198Tj> list2 = this.A0V;
            if (A0f[2].length() != 10) {
                it = list2.iterator();
            } else {
                A0f[2] = "wGXHpE1nya";
                it = list2.iterator();
            }
            while (true) {
                boolean hasNext = it.hasNext();
                if (A0f[2].length() != 10) {
                    A0f[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                    if (!hasNext) {
                        return;
                    }
                } else {
                    A0f[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                    if (!hasNext) {
                        return;
                    }
                }
                C1198Tj internalNativeAd = it.next();
                internalNativeAd.unregisterView();
            }
        }
    }

    public final void A0Y(AnonymousClass11 anonymousClass11) {
        this.A0C = anonymousClass11;
    }

    public final void A0Z(XT xt, AnonymousClass11 anonymousClass11, JT jt, C05121p c05121p, InterfaceC0952Jq interfaceC0952Jq) {
        int i2;
        this.A0E = xt;
        this.A0C = anonymousClass11;
        this.A0F = jt;
        this.A0G = interfaceC0952Jq;
        JSONObject A03 = c05121p.A03();
        AnonymousClass95 A01 = c05121p.A01();
        if (A01 != null) {
            i2 = A01.A06();
        } else {
            i2 = 200;
        }
        this.A06 = i2;
        A08(A03, C0988Le.A02(A03, A01(334, 2, 14)));
        if (C04810j.A03(xt, this, jt)) {
            xt.A0D().A3z();
            anonymousClass11.ABP(this, K3.A00(AdErrorType.NO_FILL));
        } else if (anonymousClass11 != null) {
            anonymousClass11.ABM(this);
        }
    }

    public final void A0a(Map<String, String> urlParams) {
        if (!A0h()) {
            return;
        }
        if (JD.A1H(this.A0E) && M6.A03(urlParams)) {
            String str = A0g;
            if (A0f[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            A0f[6] = "D3JUlaax70Z19DqZX7Vx94n8SobUQcIP";
            Log.e(str, A01(59, 31, 2));
            return;
        }
        HashMap hashMap = new HashMap();
        if (urlParams != null) {
            hashMap.putAll(urlParams);
        }
        LN.A02(this.A0E, A01(90, 12, 73));
        AnonymousClass11 anonymousClass11 = this.A0C;
        if (anonymousClass11 != null) {
            anonymousClass11.ABL(this);
        }
        if (this.A0d) {
            hashMap.put(A01(254, 7, 70), String.valueOf(this.A02));
            hashMap.put(A01(247, 7, 59), String.valueOf(this.A01));
        }
        AbstractC04770f adAction = C04780g.A00(this.A0E, this.A0F, this.A0N, this.A0A, hashMap);
        if (adAction != null) {
            try {
                adAction.A0B();
            } catch (Exception e2) {
                Log.e(A0g, A01(102, 22, 63), e2);
            }
        }
    }

    public final void A0b(Map<String, String> map) {
        JT jt = this.A0F;
        if (jt != null) {
            jt.A8m(this.A0N, map);
        }
    }

    public final void A0c(Map<String, String> map) {
        if (A0h() && !this.A0Z) {
            AnonymousClass11 anonymousClass11 = this.A0C;
            if (anonymousClass11 != null) {
                anonymousClass11.ABN(this);
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.A0d) {
                hashMap.put(A01(254, 7, 70), String.valueOf(this.A02));
                hashMap.put(A01(247, 7, 59), String.valueOf(this.A01));
            }
            if (!TextUtils.isEmpty(A61()) && this.A0F != null) {
                if (!this.A0d) {
                    this.A0E.A0D().A2Y();
                    AnonymousClass26.A00(this.A0O);
                }
                this.A0F.A8v(A61(), hashMap);
            }
            if (A0k() || A0l()) {
                A07(map, hashMap);
            }
            this.A0Z = true;
        }
    }

    public final void A0d(Map<String, String> map) {
        JT jt = this.A0F;
        if (jt != null) {
            jt.A9D(this.A0N, map);
        }
    }

    public final void A0e(Map<String, String> map) {
        JT jt = this.A0F;
        if (jt != null) {
            jt.A9E(this.A0N, map);
        }
    }

    public final boolean A0f() {
        return true;
    }

    public final boolean A0g() {
        return A0h() && this.A0A != null;
    }

    public final boolean A0h() {
        return this.A0X && this.A0Y;
    }

    public final boolean A0i() {
        return this.A0W;
    }

    public final boolean A0j() {
        return this.A0d;
    }

    public final boolean A0k() {
        if (JD.A0x(this.A0E) && A0h()) {
            boolean z = this.A0b;
            if (A0f[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            A0f[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0l() {
        if (JD.A0x(this.A0E) && A0h()) {
            boolean z = this.A0c;
            String[] strArr = A0f;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0f[2] = "qputmJyOXU";
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04800i
    public final String A61() {
        return this.A0N;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04800i
    public final Collection<String> A6K() {
        return this.A0T;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04800i
    public final EnumC04790h A6l() {
        return this.A0B;
    }

    public AdPlacementType A75() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC04840n
    public final void onDestroy() {
    }
}
