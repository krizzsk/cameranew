package com.facebook.ads.redexgen.X;

import android.bluetooth.BluetoothAdapter;
/* renamed from: com.facebook.ads.redexgen.X.Zg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1348Zg implements InterfaceC06356k {
    public final /* synthetic */ C1345Zd A00;

    public C1348Zg(C1345Zd c1345Zd) {
        this.A00 = c1345Zd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        BluetoothAdapter bluetoothAdapter;
        BluetoothAdapter bluetoothAdapter2;
        bluetoothAdapter = this.A00.A00;
        if (bluetoothAdapter != null) {
            C1345Zd c1345Zd = this.A00;
            bluetoothAdapter2 = c1345Zd.A00;
            return c1345Zd.A08(bluetoothAdapter2.getName());
        }
        return this.A00.A07(EnumC06466v.A06);
    }
}
