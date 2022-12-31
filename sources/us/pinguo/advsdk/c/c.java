package us.pinguo.advsdk.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advsdk.a.k;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGNativeRequest.java */
/* loaded from: classes3.dex */
public class c extends us.pinguo.advsdk.a.d<a> {

    /* renamed from: j  reason: collision with root package name */
    a f9048j;

    public c(AdsItem adsItem) {
        super(adsItem);
    }

    private void F(List<AdsItem> list) {
        ArrayList<T> arrayList = this.a;
        if (arrayList != 0) {
            arrayList.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).c()) {
                us.pinguo.advsdk.utils.b.a(q() + "ConstructPGNative mUnit_Id = " + this.f9040h.c);
                l(new a(list.get(i2), this.c, this.f9040h));
            }
        }
    }

    @Override // us.pinguo.advsdk.a.d
    /* renamed from: G */
    public a o() {
        a aVar = (a) super.o();
        if (aVar != null) {
            this.f9048j = aVar;
        }
        return this.f9048j;
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        z(false);
        a o = o();
        if (o != null) {
            x(o);
        } else {
            t("cache is empty");
        }
        return false;
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public void k(Context context, k kVar, us.pinguo.advsdk.bean.b bVar, AdsItem adsItem) {
        super.k(context, kVar, bVar, adsItem);
        ArrayList arrayList = new ArrayList();
        arrayList.add(adsItem);
        F(arrayList);
        z(false);
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        AdsItem adsItem = this.f9034e;
        if (adsItem == null) {
            return 0;
        }
        return adsItem.loadSDK;
    }

    @Override // us.pinguo.advsdk.a.d
    public int p() {
        return 10;
    }
}
