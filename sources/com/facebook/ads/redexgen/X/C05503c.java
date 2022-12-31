package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.sync.SyncModifiableBundle;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* renamed from: com.facebook.ads.redexgen.X.3c  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05503c implements GC, R9 {
    public static byte[] A0A;
    public static String[] A0B = {"5Oiv1GLvIq7zEHzIHOTPzi3kaYzi9CKu", "OYJ8Vha7o3AKqeq5fQgjy4YAYzCEKBrH", "4fHxCa0vWIAizdOtLSYViH6HX8wZM136", "7SeobKfCaIBp1RCtBr0PVzHsRPnznuT1", "fOxTiSwrZex6", "3vZIMeafrjOpHP1eiyT8MHuy7IIJRNdQ", "XI5vdZH0G6FndxBvW8fNBqRq2FpLqBJ1", "pJZH6qXQIaEu24ksEJ9XliOUqsc1pAkZ"};
    public final C8J A00;
    public final C8Y A01;
    public final InterfaceC1116Qf A02;
    public final RA A03;
    public final RI A04;
    public final RJ A05;
    public final String A06;
    public final Map<R5, GG> A09 = new HashMap();
    public final Map<R5, C4E> A08 = new HashMap();
    public final List<RN> A07 = new ArrayList();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0A = new byte[]{101, -82, -72, 101, -73, -86, -72, -71, -73, -82, -88, -71, -86, -87, 115, 101, -104, -80, -82, -75, -75, -82, -77, -84, 101, -72, -66, -77, -88, -48, -1, -1, -81, -8, -3, -81, -15, -16, -14, -6, -10, 1, -2, 4, -3, -13, -67, -54, -24, -11, -11, -10, -5, -89, -22, -7, -20, -24, -5, -20, -89, -6, -20, -7, -3, -20, -7, -89, -23, -4, -11, -21, -13, -20, -89, -2, -16, -5, -17, -89, -11, -10, -11, -76, -6, -20, -7, -3, -20, -7, -89, -10, -2, -11, -20, -21, -89, -23, -4, -11, -21, -13, -20, -89, -48, -53, -85, -56, -37, -56, -121, -41, -39, -42, -54, -52, -38, -38, -48, -43, -50, -121, -42, -41, -37, -48, -42, -43, -121, -49, -12, -4, -25, -14, -17, -22, -90, -8, -21, -20, -8, -21, -7, -18, -90, -6, -17, -13, -21, -64, -90, -85, -22, -79, -56, -38, -125, -42, -56, -43, -39, -56, -43, -112, -46, -38, -47, -56, -57, -125, -59, -40, -47, -57, -49, -56, -125, -58, -43, -56, -60, -41, -56, -57, -99, -125, -120, -42, -101, -63, -74, -85, -80, -70, -73, -74, -79, -62, -87, -68, -79, -73, -74, 104, -70, -83, -71, -67, -83, -69, -68, 104, -68, -73, 104, 109, -69, -126, 82, 109, -69, -88, -50, -61, -72, -67, -57, -60, -61, -66, -49, -74, -55, -66, -60, -61, 117, -57, -70, -56, -59, -60, -61, -56, -70, -113, 95, 122, -56, 114, -104, -115, -126, -121, -111, -114, -115, -120, -103, Byte.MIN_VALUE, -109, -120, -114, -115, 63, -111, -108, -115, 63, -123, Byte.MIN_VALUE, -120, -117, -124, -125, 90, 63, -123, -114, -111, -126, -120, -115, -122, 63, -120, -115, 63, 68, -125, 63, -110, -124, -126, -114, -115, -125, -110, -103, -84, -91, -101, -93, -100, -86, -107, -95, -96, -90, -105, -86, -90, -122, -125, -106, -125, -89, -86, -81, -88, -90, -77, -79, -77, -86, -81, -75, -39, -54, -30, -43, -40, -54, -51, -90, -45, -58, -57, -45, -58, -44, -55, -40, -53, -41, -37, -53, -39, -38, -34, -47, -33, -36, -37, -38, -33, -47, -59, -73, -60, -56, -73, -60, -95, -55, -64, -73, -74, -108, -57, -64, -74, -66, -73, -107, -60, -73, -77, -58, -73, -74, -19, -13, -24, -35, -30, -20, -23, -24, -29, -12, -37, -18, -29, -23, -24, -64, -29, -24, -29, -19, -30, -33, -34, -44, -38, -49, -60, -55, -45, -48, -49, -54, -37, -62, -43, -54, -48, -49, -76, -43, -62, -45, -43, -58, -59, -73, -92, -75, -86, -88, -73, -94, -75, -88, -87, -75, -88, -74, -85, -94, -74};
    }

    static {
        A05();
    }

    public C05503c(C8J c8j, C8Y c8y, InterfaceC1116Qf interfaceC1116Qf, String str, RJ rj, RI ri, R8 r8) {
        this.A00 = c8j;
        this.A01 = c8y;
        this.A02 = interfaceC1116Qf;
        this.A06 = str;
        this.A05 = rj;
        this.A04 = ri;
        this.A03 = r8.A4A(this);
    }

    public static int A00(JSONObject jSONObject) throws JSONException {
        int i2 = jSONObject.getJSONObject(A01(335, 7, 80)).getInt(A01(426, 16, 50));
        if (i2 > 0) {
            return i2;
        }
        throw new JSONException(String.format(Locale.US, A01(129, 24, 117), Integer.valueOf(i2)));
    }

    private Set<RM> A02(JSONObject responseObject) throws JSONException {
        HashSet hashSet = new HashSet();
        JSONObject jSONObject = responseObject.getJSONObject(A01(349, 8, 91));
        JSONObject jSONObject2 = responseObject.getJSONObject(A01(298, 7, 38));
        for (final GG gg : this.A09.values()) {
            int i2 = RL.A01[RR.A00(jSONObject.getString(gg.A6h().A03())).ordinal()];
            if (i2 == 1) {
                final JSONObject jSONObject3 = jSONObject2.getJSONObject(gg.A6h().A03()).getJSONObject(A01(312, 4, 17));
                final JSONObject optJSONObject = jSONObject2.getJSONObject(gg.A6h().A03()).optJSONObject(A01(TypedValues.AttributesType.TYPE_PATH_ROTATE, 11, 48));
                hashSet.add(new G7(gg, jSONObject3, optJSONObject) { // from class: com.facebook.ads.redexgen.X.3f
                    public final JSONObject A00;
                    @Nullable
                    public final JSONObject A01;

                    {
                        RR rr = RR.A03;
                        this.A00 = jSONObject3;
                        this.A01 = optJSONObject;
                    }

                    @Override // com.facebook.ads.redexgen.X.G7, com.facebook.ads.redexgen.X.RM
                    public final void A3M(Map<R4, RR> map, Map<GD, RE> map2) {
                        super.A00.A05(this.A00, this.A01);
                        super.A3M(map, map2);
                    }
                });
            } else if (i2 == 2) {
                hashSet.add(new G7(gg) { // from class: com.facebook.ads.redexgen.X.3e
                    {
                        RR rr = RR.A04;
                    }
                });
            } else {
                throw new AssertionError();
            }
        }
        for (final C4E c4e : this.A08.values()) {
            int i3 = RL.A00[RE.A00(jSONObject.getString(c4e.A6h().A03())).ordinal()];
            if (i3 == 1) {
                hashSet.add(new G8(c4e) { // from class: com.facebook.ads.redexgen.X.3y
                    {
                        RE re = RE.A04;
                    }
                });
            } else if (i3 == 2) {
                hashSet.add(new G8(c4e) { // from class: com.facebook.ads.redexgen.X.3d
                    {
                        RE re = RE.A05;
                    }

                    @Override // com.facebook.ads.redexgen.X.G8, com.facebook.ads.redexgen.X.RM
                    public final void A3M(Map<R4, RR> map, Map<GD, RE> map2) {
                        this.A01.A06();
                        super.A3M(map, map2);
                    }
                });
            } else {
                throw new AssertionError();
            }
        }
        return hashSet;
    }

    private JSONObject A03(Map<R4, RQ> map, Map<GD, RD> map2, Map<GD, JSONObject> map3, Map<GD, JSONObject> map4) throws JSONException {
        String A01;
        JSONObject bundleData = new JSONObject();
        for (Map.Entry<R4, RQ> entry : map.entrySet()) {
            bundleData.put(entry.getKey().A6h().A03(), entry.getValue().A02());
        }
        for (Map.Entry<GD, RD> entry2 : map2.entrySet()) {
            bundleData.put(entry2.getKey().A6h().A03(), entry2.getValue().A02());
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<Map.Entry<R4, RQ>> it = map.entrySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            A01 = A01(TypedValues.AttributesType.TYPE_PATH_ROTATE, 11, 48);
            if (!hasNext) {
                break;
            }
            Map.Entry<R4, RQ> next = it.next();
            if (next.getValue() == RQ.A04) {
                JSONObject jSONObject2 = new JSONObject();
                R4 key = next.getKey();
                jSONObject.put(key.A6h().A03(), jSONObject2);
                R4 bundle = next.getKey();
                if (bundle.A6h().A04()) {
                    jSONObject2.put(A01, key.A6c());
                } else {
                    jSONObject2.put(A01, JSONObject.NULL);
                }
                jSONObject.put(key.A6h().A03(), jSONObject2);
            }
        }
        for (Map.Entry<GD, RD> entry3 : map2.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            GD key2 = entry3.getKey();
            R4 bundle2 = entry3.getKey();
            jSONObject3.put(A01, map4.get(bundle2));
            if (entry3.getValue() == RD.A05) {
                jSONObject3.put(A01(312, 4, 17), map3.get(key2));
                jSONObject.put(key2.A6h().A03(), jSONObject3);
            } else {
                String A03 = key2.A6h().A03();
                String[] strArr = A0B;
                if (strArr[1].charAt(20) == strArr[6].charAt(20)) {
                    throw new RuntimeException();
                }
                A0B[5] = "j6hI8A69HBwx3QyEu85lNgwu8aXeWQ7U";
                jSONObject.put(A03, jSONObject3);
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        for (Map.Entry<String, String> entry4 : this.A05.A6T().entrySet()) {
            if (entry4.getValue() != null) {
                jSONObject4.put(entry4.getKey(), entry4.getValue());
            }
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(A01(342, 7, 85), bundleData);
        jSONObject5.put(A01(298, 7, 38), jSONObject);
        jSONObject5.put(A01(305, 7, 33), jSONObject4);
        return jSONObject5;
    }

    private void A04() throws Throwable {
        Map<R4, RQ> hashMap = new HashMap<>();
        Map<GD, RD> hashMap2 = new HashMap<>();
        Map<GD, JSONObject> hashMap3 = new HashMap<>();
        Map<GD, JSONObject> hashMap4 = new HashMap<>();
        synchronized (this) {
            for (R4 r4 : this.A09.values()) {
                if (r4.A8U()) {
                    hashMap.put(r4, RQ.A04);
                } else {
                    hashMap.put(r4, RQ.A03);
                }
            }
            AtomicReference<JSONObject> atomicReference = new AtomicReference<>();
            AtomicReference<JSONObject> atomicReference2 = new AtomicReference<>();
            for (C4E c4e : this.A08.values()) {
                if (c4e.A8U()) {
                    if (c4e.A07(atomicReference, atomicReference2)) {
                        hashMap2.put(c4e, RD.A05);
                        hashMap3.put(c4e, atomicReference.get());
                    } else {
                        hashMap2.put(c4e, RD.A04);
                    }
                    hashMap4.put(c4e, atomicReference2.get());
                }
            }
            Iterator<RN> it = this.A07.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NullPointerException(A01(DeeplinkCallback.ERROR_LINK_NOT_EXIST, 22, 80));
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference<Throwable> failureContainer = new AtomicReference<>();
        AtomicReference atomicReference3 = new AtomicReference();
        JSONObject A03 = A03(hashMap, hashMap2, hashMap3, hashMap4);
        String.format(Locale.US, A01(188, 33, 55), this.A06, A03.toString(2));
        InterfaceC1116Qf interfaceC1116Qf = this.A02;
        String str = this.A06;
        interfaceC1116Qf.ACu(str, (A01(327, 8, 88) + URLEncoder.encode(A03.toString())).getBytes(), new GA(this, failureContainer, atomicReference3, countDownLatch));
        while (countDownLatch.getCount() > 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (atomicReference3.get() == null) {
                JSONObject syncRequest = (JSONObject) failureContainer.get();
                Set<RM> A02 = A02(syncRequest);
                Map<SyncModifiableBundle, JSONObject> clientBundleFingerprint = new HashMap<>();
                HashMap hashMap5 = new HashMap();
                for (RM response : A02) {
                    response.A3M(clientBundleFingerprint, hashMap5);
                }
                this.A03.A5P(A00((JSONObject) failureContainer.get()));
                Iterator<RN> it2 = this.A07.iterator();
                if (it2.hasNext()) {
                    it2.next();
                    throw new NullPointerException(A01(381, 23, 105));
                }
            } else {
                throw ((Throwable) atomicReference3.get());
            }
        }
    }

    public static void A06(String str, AtomicReference<JSONObject> atomicReference, AtomicReference<Throwable> atomicReference2) {
        String.format(Locale.US, A01(221, 28, 68), str);
        try {
            atomicReference.set((JSONObject) new JSONTokener(str).nextValue());
        } catch (ClassCastException | JSONException e2) {
            atomicReference2.set(e2);
        }
    }

    private synchronized void A08(Throwable th) {
        Iterator<RN> it = this.A07.iterator();
        if (it.hasNext()) {
            it.next();
            new HashMap();
            new HashMap();
            throw new NullPointerException(A01(381, 23, 105));
        }
    }

    @Override // com.facebook.ads.redexgen.X.GC
    public final synchronized R4 A4M(R5 r5) {
        if (r5.A02() == R7.A03) {
            if (this.A09.containsKey(r5)) {
                return this.A09.get(r5);
            }
            GG gg = new GG(r5);
            this.A09.put(r5, gg);
            Iterator<RN> it = this.A07.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NullPointerException(A01(357, 24, 65));
            }
            String.format(Locale.US, A01(153, 35, 82), r5);
            return gg;
        }
        throw new IllegalArgumentException(A01(47, 59, 118));
    }

    @Override // com.facebook.ads.redexgen.X.GC, com.facebook.ads.redexgen.X.C8P
    public final void A5R() {
        this.A03.A5Q();
    }

    @Override // com.facebook.ads.redexgen.X.R9
    @SuppressLint({"CatchGeneralException"})
    public final void AE2() {
        if (this.A01.A8V()) {
            String str = A01(106, 23, 86) + this.A01.A6G().A07() + A01(0, 29, 52);
            A08(new RP());
            return;
        }
        try {
            if (!JD.A1I(this.A00) || this.A00.A02().A8N()) {
                A04();
                return;
            }
            throw new IllegalStateException(A01(29, 18, 126));
        } catch (Throwable th) {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            int A01 = this.A04.A01();
            if (A0B[5].charAt(3) != 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[2] = "JEtZyGAVdUTB5WRsJGoBqRot3n7K2sjz";
            strArr[3] = "em0I48mZsoEuthzWerVnjSUWeJS3cW5z";
            objArr[0] = Integer.valueOf(A01);
            String.format(locale, A01(249, 49, 14), objArr);
            A08(th);
            this.A03.A5P(this.A04.A01());
        }
    }
}
