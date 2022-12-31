package com.pinguo.camera360.homepage;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import java.util.ArrayList;
import java.util.Comparator;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageViewModel.kt */
/* loaded from: classes3.dex */
public final class p0 extends AndroidViewModel {
    private boolean a;
    private boolean b;
    private final n0 c;

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Integer.valueOf(((i0) t).e()), Integer.valueOf(((i0) t2).e()));
            return a;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Integer.valueOf(((AdvItem) t).entryPos), Integer.valueOf(((AdvItem) t2).entryPos));
            return a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(Application app) {
        super(app);
        kotlin.jvm.internal.s.h(app, "app");
        this.c = new n0("74e9e34397164b4d84eb4f9d24f18ff2", "8beec15ed46842378dd5f77232eabc73", "9095296d7be349efb8f5bd4ba4df30fd");
    }

    private final boolean f(String str) {
        if (kotlin.jvm.internal.s.c(AdvConstants.ADV_TYPE_BRAND, str) || kotlin.jvm.internal.s.c(AdvConstants.ADV_TYPE_PINGUO, str)) {
            return true;
        }
        return kotlin.jvm.internal.s.c("defaultAdv", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.pinguo.camera360.homepage.i0> a() {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.p0.a():java.util.List");
    }

    public final ArrayList<f0> b() {
        ArrayList<f0> f2;
        ArrayList<f0> f3;
        ArrayList<f0> arrayList = new ArrayList<>();
        ArrayList<AdvItem> a2 = this.c.a("74e9e34397164b4d84eb4f9d24f18ff2");
        if (a2 == null) {
            f3 = kotlin.collections.u.f(this.c.b());
            return f3;
        }
        for (AdvItem advItem : a2) {
            Object obj = advItem.downloadedIconPath;
            if (obj == null) {
                obj = Integer.valueOf((int) R.drawable.home_banner_default);
            }
            String interactionUri = advItem.interactionUri;
            kotlin.jvm.internal.s.g(interactionUri, "interactionUri");
            String advId = advItem.advId;
            kotlin.jvm.internal.s.g(advId, "advId");
            String advType = advItem.advType;
            kotlin.jvm.internal.s.g(advType, "advType");
            arrayList.add(new f0(obj, interactionUri, advId, advType, new us.pinguo.foundation.interaction.d(advItem.interactionUri, advItem.advType, Integer.valueOf(advItem.advProvider), advItem.mvId, Boolean.valueOf(advItem.forceInnerBrowser)), advItem));
        }
        if (arrayList.isEmpty()) {
            f2 = kotlin.collections.u.f(this.c.b());
            return f2;
        }
        return arrayList;
    }

    public final f0 c() {
        return this.c.b();
    }

    public final boolean d() {
        return this.a;
    }

    public final j0 e() {
        AdvItem h2 = this.c.h("9095296d7be349efb8f5bd4ba4df30fd");
        if (h2 == null) {
            return this.c.d();
        }
        String str = h2.topNavMenuImg;
        boolean z = false;
        Object topNavMenuImgPath = str == null || str.length() == 0 ? Integer.valueOf((int) R.drawable.ic_user_profile) : AdvConfigManager.getInstance().getDownFilePath(h2.topNavMenuImg);
        String str2 = h2.topNavLogoImg;
        Object topNavLogoImgPath = str2 == null || str2.length() == 0 ? Integer.valueOf((int) R.drawable.ic_c360_logo) : AdvConfigManager.getInstance().getDownFilePath(h2.topNavLogoImg);
        String str3 = h2.topNavVipImg;
        Object topNavVipImgPath = str3 == null || str3.length() == 0 ? Integer.valueOf((int) R.drawable.ic_home_vip) : AdvConfigManager.getInstance().getDownFilePath(h2.topNavVipImg);
        String str4 = h2.bottomLeftIconBgUrl;
        String downFilePath = str4 == null || str4.length() == 0 ? null : AdvConfigManager.getInstance().getDownFilePath(h2.bottomLeftIconBgUrl);
        String str5 = h2.bottomLeftIconUrl;
        String downFilePath2 = str5 == null || str5.length() == 0 ? null : AdvConfigManager.getInstance().getDownFilePath(h2.bottomLeftIconUrl);
        String str6 = h2.bottomRightIconBgUrl;
        String downFilePath3 = str6 == null || str6.length() == 0 ? null : AdvConfigManager.getInstance().getDownFilePath(h2.bottomRightIconBgUrl);
        String str7 = h2.bottomRightIconUrl;
        String downFilePath4 = (str7 == null || str7.length() == 0) ? true : true ? null : AdvConfigManager.getInstance().getDownFilePath(h2.bottomRightIconUrl);
        String str8 = h2.bottomLeftType;
        h0 h0Var = new h0(str8 == null ? "0" : str8, downFilePath, downFilePath2, h2.bottomLeftIconBgColor, h2.bottomLeftIconTextColor);
        String str9 = h2.bottomRightType;
        h0 h0Var2 = new h0(str9 == null ? "0" : str9, downFilePath3, downFilePath4, h2.bottomRightIconBgColor, h2.bottomRightIconTextColor);
        kotlin.jvm.internal.s.g(topNavMenuImgPath, "topNavMenuImgPath");
        kotlin.jvm.internal.s.g(topNavLogoImgPath, "topNavLogoImgPath");
        kotlin.jvm.internal.s.g(topNavVipImgPath, "topNavVipImgPath");
        return new j0(topNavMenuImgPath, topNavLogoImgPath, topNavVipImgPath, h0Var, h0Var2, h2.bgColor, h2.bgColor1, h2.downloadedFilePath, h2.bgType);
    }

    public final boolean g() {
        return this.b;
    }

    public final void h(boolean z) {
        this.b = z;
    }

    public final void i(boolean z) {
        this.a = z;
    }
}
