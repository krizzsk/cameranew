package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
/* renamed from: com.facebook.ads.redexgen.X.d4  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1549d4 extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public static String[] A02 = {"CdCLIQRd", "Gozok8EGiq89CC7S8QZsNr", "pl5lQHAXyLio1ost", "M44cRouQCRL7K0vypo2P04DU", "Y2GzUIW8g3L", "Bs9wehYqNd3BdGUVOwkaAN", "ajmsB695tQiR2xtfKUGvlSwazulcZzs7", "Sy9bhDNhoUd7kDt0yrvFBLns12VVbk64"};
    public final /* synthetic */ String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = (copyOfRange[i5] - i4) - 47;
            if (A02[6].charAt(27) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "CuQnTMvQt2iEBPylhK7T15";
            strArr[1] = "FSZFy24WJ9CShZHmahty6u";
            copyOfRange[i5] = (byte) i6;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A02[6].charAt(27) != 'c') {
            throw new RuntimeException();
        }
        A02[3] = "LuOw";
        A01 = new byte[]{-99, -87, -100, -88, -84, -100, -91, -102, -80, -106, -102, -104, -89, -89, -96, -91, -98};
    }

    static {
        A02();
    }

    public C1549d4(String str) {
        this.A00 = str;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean A0I;
        try {
            C04910u.A04.await();
            synchronized (C04910u.A00) {
                Iterator<String> keys = C04910u.A00.A03().keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    A0I = C04910u.A0I(this.A00);
                    if (A0I) {
                        C04910u.A0B((C1M) C04910u.A00.A03().get(next), next, next.equals(this.A00));
                    }
                }
                C04910u.A00.A04();
                C04910u.A09();
            }
        } catch (InterruptedException e2) {
            C04910u.A01.A06().A8q(A00(0, 17, 8), C06808m.A10, new C06818n(e2));
        } catch (JSONException e3) {
            C04910u.A07();
            C04910u.A01.A06().A8q(A00(0, 17, 8), C06808m.A0z, new C06818n(e3));
        }
    }
}
