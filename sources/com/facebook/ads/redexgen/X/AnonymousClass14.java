package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Serializable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.14  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass14 extends BroadcastReceiver {
    public static byte[] A03;
    public static String[] A04 = {"X1IVw5mZrPwWgp59pDL9aLZ3Fov3W2Wm", "N1AsLxATz8LfRIPBbwS0prqi9bKFNGwZ", "KvfN8PD7zJtQDsMeVTqT5dRzLvhiPQFs", "CwJ4sBopjGul5sxVyPsrv7O0APgi12j8", "riYYfsMk5nddhbnpPSj9znzkTr5bDpPf", "Be1xHvNUMQ0R9QZ", "t7JwnvsmbbV8km6q46", "oSYhwD14tF3vT8zAS1lFRiV2H2FAfEUD"};
    public Context A00;
    public AA A01;
    public boolean A02 = false;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{25, 3, 15, Draft_75.CR, 78, 6, 1, 3, 5, 2, 15, 15, 11, 78, 1, 4, 19, 78, 9, 14, 20, 5, 18, 19, 20, 9, 20, 9, 1, 12, 78, 4, 9, 19, 16, 12, 1, 25, 5, 4, 19, 31, 29, 94, 22, 17, 19, 21, 18, 31, 31, 27, 94, 17, 20, 3, 94, 25, 30, 4, 21, 2, 3, 4, 25, 4, 25, 17, 28, 94, 20, 25, 3, 0, 28, 17, 9, 21, 20, 74, 18, 1, 18, 25, 3, 81, 68, 83, 71, 78, 83, 76, 98, 85, 64, 98, 77, 72, 66, 74, 83, 70, 81, 69, 76, 81, 78, 96, 87, 66, 96, 79, 74, 64, 72, 25, 45, 50, 63, 62, 52, 18, 53, 47, 62, 41, 40, 47, 50, 47, 58, 55, 30, 45, 62, 53, 47, 2, 29, 16, 17, 27, 61, 26, 0, 17, 6, 7, 0, 29, 0, 21, 24, 49, 2, 17, 26, 0, 78};
    }

    static {
        A01();
    }

    public AnonymousClass14(AA aa, Context context) {
        this.A01 = aa;
        this.A00 = context;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(40, 40, 17) + this.A01.getUniqueId());
        intentFilter.addAction(A00(137, 22, 21) + this.A01.getUniqueId());
        intentFilter.addAction(A00(100, 16, 66) + this.A01.getUniqueId());
        C2M.A00(this.A00).A06(this, intentFilter);
    }

    public final void A03() {
        try {
            C2M.A00(this.A00).A05(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(A00(0, 1, 66));
        if (split.length != 2 || !split[1].equals(this.A01.getUniqueId())) {
            return;
        }
        if (split[0].equals(A00(1, 39, 1))) {
            if (this.A01.getListener() != null) {
                this.A01.getListener().AAT();
                this.A01.getListener().ACc();
                return;
            }
            return;
        }
        String str = split[0];
        if (A04[2].charAt(17) != 'T') {
            throw new RuntimeException();
        }
        A04[7] = "czH1g8WXqBVBzZgoSLVA20jYFFcQLh15";
        if (str.equals(A00(116, 21, 58))) {
            Serializable serializableExtra = intent.getSerializableExtra(A00(80, 5, 22));
            if (serializableExtra instanceof C0966Ke) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().AAZ();
                    this.A01.getListener().ACc();
                }
                if (this.A02) {
                    this.A01.A0Y(1);
                } else {
                    this.A01.A0Y(((C0966Ke) serializableExtra).A01());
                }
                this.A01.setVisibility(0);
                this.A01.A0b(EnumC1094Pj.A05, 1);
            } else if (serializableExtra instanceof M0) {
                if (this.A01.getListener() == null) {
                    return;
                }
                InterfaceC1012Mc listener = this.A01.getListener();
                if (A04[4].charAt(15) != 'p') {
                    throw new RuntimeException();
                }
                A04[0] = "WizhEabCQfIhxCPZxjxQrLo8096TZ2te";
                listener.AAd();
            } else if (serializableExtra instanceof LQ) {
                if (this.A01.getListener() == null) {
                    return;
                }
                this.A01.getListener().AAe();
            } else if (serializableExtra instanceof C06687v) {
                if (this.A01.getListener() != null) {
                    this.A01.getListener().AA9();
                }
                this.A02 = true;
            } else if (serializableExtra instanceof C0977Kr) {
                if (this.A01.getListener() != null) {
                    InterfaceC1012Mc listener2 = this.A01.getListener();
                    if (A04[5].length() != 15) {
                        A04[5] = "OhpiyJuLhpOH2Z5";
                        listener2.ABW();
                    } else {
                        A04[1] = "rjxpcIZarLCWG40Y5u8euDt94bevKfNO";
                        listener2.ABW();
                    }
                }
                this.A02 = false;
            } else if (!(serializableExtra instanceof C06677u) || this.A01.getListener() == null) {
            } else {
                this.A01.getListener().onPause();
            }
        } else if (!split[0].equals(A00(85, 15, 64))) {
        } else {
            this.A01.A0l();
        }
    }
}
