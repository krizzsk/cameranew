package com.facebook.ads.redexgen.X;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.Zf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1347Zf implements InterfaceC06356k {
    public final /* synthetic */ C1345Zd A00;

    public C1347Zf(C1345Zd c1345Zd) {
        this.A00 = c1345Zd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws Exception {
        BluetoothAdapter bluetoothAdapter;
        BluetoothAdapter bluetoothAdapter2;
        bluetoothAdapter = this.A00.A00;
        if (bluetoothAdapter != null) {
            bluetoothAdapter2 = this.A00.A00;
            ArrayList arrayList = new ArrayList();
            for (BluetoothDevice bluetoothDevice : bluetoothAdapter2.getBondedDevices()) {
                arrayList.add(new C1346Ze(bluetoothDevice));
            }
            return this.A00.A0D(arrayList);
        }
        return this.A00.A07(EnumC06466v.A06);
    }
}
