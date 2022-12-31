package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Ze  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1346Ze implements InterfaceC06416q {
    public static byte[] A06;
    public static String[] A07 = {"KDgd6MNQp", "zljFFu", "VjilcxnSKsnTmReAVmpDdy6aJMg5f7s6", "M9UxMwGxDbbJlDHBhdVrbnElbrcIb6xK", "Ta0jv7L5NWawm2KziAACyDWzZYF122Ra", "gHFWFjUMy", "XbHlXA", "YSRve52qNSnKNw3HKqPQ6WGg63dcEGZy"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final String A05;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 56);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-95, -96, 17, 8, 7, -72, -24, -38, -21, -20, 25};
    }

    static {
        A02();
    }

    @SuppressLint({"MissingPermission"})
    public C1346Ze(BluetoothDevice bluetoothDevice) {
        this.A05 = bluetoothDevice.getName();
        this.A03 = bluetoothDevice.getBondState();
        if (Build.VERSION.SDK_INT >= 18) {
            this.A04 = bluetoothDevice.getType();
        } else {
            this.A04 = -1;
        }
        this.A00 = bluetoothDevice.getBluetoothClass().getDeviceClass();
        this.A01 = bluetoothDevice.getBluetoothClass().getMajorDeviceClass();
        this.A02 = A00(bluetoothDevice.getBluetoothClass());
    }

    public static int A00(BluetoothClass bluetoothClass) {
        int i2 = 0;
        for (int i3 = 0; i3 < 31; i3++) {
            String[] strArr = A07;
            if (strArr[4].charAt(13) == strArr[2].charAt(13)) {
                throw new RuntimeException();
            }
            A07[7] = "ZZNppqHA2hsJ2mypaqhwEDmNkJueeDWX";
            if (bluetoothClass.hasService(1 << i3)) {
                i2 |= 1 << i3;
            }
        }
        return i2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06416q
    public final boolean A8K(Object obj) {
        C1346Ze c1346Ze = (C1346Ze) obj;
        if (((this.A05 == null && c1346Ze.A05 == null) || this.A05.equals(c1346Ze.A05)) && this.A03 == c1346Ze.A03 && this.A04 == c1346Ze.A04 && this.A00 == c1346Ze.A00) {
            int i2 = this.A01;
            if (A07[3].charAt(27) != 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[5] = "lCz1bJjVX";
            strArr[0] = "UsNKRzwfX";
            if (i2 == c1346Ze.A01 && this.A02 == c1346Ze.A02) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06416q
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final int AEd() {
        return (this.A05 != null ? A01(5, 1, 18).length() + this.A05.length() : 0) + A01(8, 2, 64).length() + 4 + A01(10, 1, 109).length() + 4 + A01(0, 2, 5).length() + 4 + A01(2, 3, 108).length() + 4 + A01(6, 2, 61).length() + 4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06416q
    public final JSONObject AEy() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A01(5, 1, 18), this.A05);
        jSONObject.put(A01(8, 2, 64), this.A03);
        jSONObject.put(A01(10, 1, 109), this.A04);
        jSONObject.put(A01(0, 2, 5), this.A00);
        jSONObject.put(A01(2, 3, 108), this.A01);
        jSONObject.put(A01(6, 2, 61), this.A02);
        return jSONObject;
    }
}
