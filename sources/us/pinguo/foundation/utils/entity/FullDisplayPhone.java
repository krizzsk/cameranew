package us.pinguo.foundation.utils.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.d;
/* loaded from: classes4.dex */
public class FullDisplayPhone implements Parcelable {
    private static FullDisplayPhone fullDisplayPhone;
    private List<MobileModel> fullDisplayPhoneList;
    private List<MobileModel> notchPhoneList;
    private static final byte[] lock = new byte[0];
    public static final Parcelable.Creator<FullDisplayPhone> CREATOR = new a();

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<FullDisplayPhone> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FullDisplayPhone createFromParcel(Parcel parcel) {
            return new FullDisplayPhone(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FullDisplayPhone[] newArray(int i2) {
            return new FullDisplayPhone[i2];
        }
    }

    private FullDisplayPhone() {
    }

    public static FullDisplayPhone getInstance() {
        us.pinguo.common.log.a.k("FullDisplayPhone->getInstance->" + Thread.currentThread().getId(), new Object[0]);
        fullDisplayPhone = new FullDisplayPhone();
        ArrayList arrayList = new ArrayList();
        MobileModel mobileModel = new MobileModel();
        mobileModel.g("Vivo");
        mobileModel.l("Vivo X21");
        mobileModel.k("Vivo X21");
        mobileModel.j("feature");
        mobileModel.m(20);
        Clazz clazz = new Clazz();
        clazz.g("android.util.FtFeature");
        clazz.h("isFeatureSupport");
        clazz.f(new Object[]{32});
        mobileModel.h(clazz);
        MobileModel mobileModel2 = new MobileModel();
        mobileModel2.g("Huawei");
        mobileModel2.l("Huawei P20");
        Clazz clazz2 = new Clazz();
        clazz2.g("com.huawei.android.util.HwNotchSizeUtil");
        clazz2.h("hasNotchInScreen");
        clazz2.f(null);
        mobileModel2.h(clazz2);
        MobileModel mobileModel3 = new MobileModel();
        mobileModel3.g("Smartisan");
        mobileModel3.l("Smartisan R1");
        Clazz clazz3 = new Clazz();
        clazz3.g("smartisanos.api.DisplayUtilsSmt");
        clazz3.h("isFeatureSupport");
        clazz3.f(new Object[]{1});
        mobileModel3.h(clazz2);
        MobileModel mobileModel4 = new MobileModel();
        mobileModel4.g("MI");
        mobileModel4.l("Mi 8");
        Clazz clazz4 = new Clazz();
        clazz4.g("android.os.SystemProperties");
        clazz4.h("get");
        clazz4.f(new Object[]{"ro.miui.notch"});
        mobileModel4.h(clazz4);
        MobileModel mobileModel5 = new MobileModel();
        mobileModel5.g("OPPO");
        mobileModel5.l("OPPO R15");
        mobileModel5.j("com.oppo.feature.screen.heteromorphism");
        MobileModel mobileModel6 = new MobileModel();
        mobileModel6.g("OPPO");
        mobileModel6.l("OPPO R15");
        mobileModel6.k("PACM00");
        MobileModel mobileModel7 = new MobileModel();
        mobileModel7.g("SAMSUNG");
        mobileModel7.l("SAMSUNG A8S");
        mobileModel7.k("");
        if (d.f10985d) {
            MobileModel mobileModel8 = new MobileModel();
            mobileModel8.g("HUAWEI");
            mobileModel8.l("HUAWEI nova");
            mobileModel8.k("HUAWEI CAZ-AL10");
            arrayList.add(mobileModel8);
        }
        arrayList.add(mobileModel);
        arrayList.add(mobileModel2);
        arrayList.add(mobileModel3);
        arrayList.add(mobileModel4);
        arrayList.add(mobileModel5);
        arrayList.add(mobileModel6);
        arrayList.add(mobileModel7);
        fullDisplayPhone.b(arrayList);
        return fullDisplayPhone;
    }

    public List<MobileModel> a() {
        return this.notchPhoneList;
    }

    public void b(List<MobileModel> list) {
        this.notchPhoneList = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.fullDisplayPhoneList);
        parcel.writeTypedList(this.notchPhoneList);
    }

    protected FullDisplayPhone(Parcel parcel) {
        Parcelable.Creator<MobileModel> creator = MobileModel.CREATOR;
        this.fullDisplayPhoneList = parcel.createTypedArrayList(creator);
        this.notchPhoneList = parcel.createTypedArrayList(creator);
    }
}
