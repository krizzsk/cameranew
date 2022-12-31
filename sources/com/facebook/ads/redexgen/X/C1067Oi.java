package com.facebook.ads.redexgen.X;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Oi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1067Oi extends WebChromeClient {
    public static byte[] A01;
    public final /* synthetic */ C1072On A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 107);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-41, -44, -39, -48, -71, -32, -40, -51, -48, -35, 83, 75, 89, 89, 71, 77, 75, 68, 64, 70, 67, 52, 54, 26, 53};
    }

    public C1067Oi(C1072On c1072On) {
        this.A00 = c1072On;
    }

    public /* synthetic */ C1067Oi(C1072On c1072On, S5 s5) {
        this(c1072On);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        C0937Jb c0937Jb;
        C1062Ob c1062Ob;
        XT xt;
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A00(10, 7, 123), consoleMessage.message());
                jSONObject.put(A00(0, 10, 0), consoleMessage.lineNumber());
                jSONObject.put(A00(17, 8, 102), consoleMessage.sourceId());
            } catch (JSONException unused) {
            }
            String jSONObject2 = jSONObject.toString();
            c0937Jb = this.A00.A0A;
            c0937Jb.A02(EnumC0936Ja.A0N, null);
            c1062Ob = this.A00.A0C;
            c1062Ob.A04(C06808m.A0u, jSONObject2);
            xt = this.A00.A08;
            xt.A0D().A4x(jSONObject2);
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
