package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: assets/audience_network.dex */
public abstract class VA implements FN {
    public InterfaceC1278Wo A00;
    public AbstractC0733Ao A01;
    public Object A02;
    public final ArrayList<FM> A04 = new ArrayList<>(1);
    public final FY A03 = new FY();

    public abstract void A02();

    public abstract void A03(InterfaceC1278Wo interfaceC1278Wo, boolean z);

    public final FY A00(@Nullable FL fl) {
        return this.A03.A02(0, fl, 0L);
    }

    public final void A01(AbstractC0733Ao abstractC0733Ao, @Nullable Object obj) {
        this.A01 = abstractC0733Ao;
        this.A02 = obj;
        Iterator<FM> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().AC6(this, abstractC0733Ao, obj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final void A3B(Handler handler, InterfaceC0837Fb interfaceC0837Fb) {
        this.A03.A07(handler, interfaceC0837Fb);
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final void AD1(InterfaceC1278Wo interfaceC1278Wo, boolean z, FM fm) {
        InterfaceC1278Wo interfaceC1278Wo2 = this.A00;
        I6.A03(interfaceC1278Wo2 == null || interfaceC1278Wo2 == interfaceC1278Wo);
        this.A04.add(fm);
        if (this.A00 == null) {
            this.A00 = interfaceC1278Wo;
            A03(interfaceC1278Wo, z);
            return;
        }
        AbstractC0733Ao abstractC0733Ao = this.A01;
        if (abstractC0733Ao == null) {
            return;
        }
        fm.AC6(this, abstractC0733Ao, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final void ADZ(FM fm) {
        this.A04.remove(fm);
        if (this.A04.isEmpty()) {
            this.A00 = null;
            this.A01 = null;
            this.A02 = null;
            A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final void ADb(InterfaceC0837Fb interfaceC0837Fb) {
        this.A03.A0D(interfaceC0837Fb);
    }
}
