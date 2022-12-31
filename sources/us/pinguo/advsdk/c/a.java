package us.pinguo.advsdk.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.a.k;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.bean.ButtonBean;
import us.pinguo.advsdk.bean.ImageBean;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.e;
/* compiled from: PGNative.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.advsdk.a.b implements View.OnClickListener {
    private AdsItem a;
    private k b;
    private us.pinguo.advsdk.bean.b c;

    /* renamed from: e  reason: collision with root package name */
    private b.a f9046e;

    /* renamed from: d  reason: collision with root package name */
    private PgAdvConstants$CountMode f9045d = PgAdvConstants$CountMode.NORMAL;

    /* renamed from: f  reason: collision with root package name */
    private long f9047f = 0;

    public a(AdsItem adsItem, k kVar, us.pinguo.advsdk.bean.b bVar) {
        this.a = adsItem;
        this.b = kVar;
        this.c = bVar;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return this.a;
    }

    @Override // us.pinguo.advsdk.a.b
    public String b() {
        ButtonBean buttonBean;
        AdsItem adsItem = this.a;
        if (adsItem == null || (buttonBean = adsItem.button) == null) {
            return null;
        }
        return buttonBean.text;
    }

    @Override // us.pinguo.advsdk.a.b
    public String c() {
        AdsItem adsItem = this.a;
        if (adsItem == null) {
            return null;
        }
        return adsItem.desc;
    }

    @Override // us.pinguo.advsdk.a.b
    public String d() {
        return "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        String str;
        AdsItem adsItem = this.a;
        if (adsItem == null || (str = adsItem.iconUrl) == null) {
            return null;
        }
        return str;
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        AdsItem adsItem = this.a;
        if (adsItem == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        if (!TextUtils.isEmpty(adsItem.offerId)) {
            return this.a.offerId;
        }
        return String.valueOf((String.valueOf(l()) + k() + g() + e()).hashCode());
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        ImageBean imageBean;
        AdsItem adsItem = this.a;
        if (adsItem == null || (imageBean = adsItem.image) == null) {
            return null;
        }
        return imageBean.url;
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return this;
    }

    @Override // us.pinguo.advsdk.a.b
    public String j() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String k() {
        AdsItem adsItem = this.a;
        if (adsItem == null) {
            return null;
        }
        return adsItem.title;
    }

    @Override // us.pinguo.advsdk.a.b
    public int l() {
        AdsItem adsItem = this.a;
        if (adsItem == null) {
            return 0;
        }
        return adsItem.loadSDK;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        us.pinguo.advsdk.bean.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        return bVar.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void o(View view, List<View> list, ViewGroup viewGroup) {
        List<String> list2;
        super.o(view, list, viewGroup);
        if (this.a == null) {
            return;
        }
        view.setOnClickListener(this);
        PgAdvManager.getInstance().i().d();
        AdsItem adsItem = this.a;
        if (adsItem == null || (list2 = adsItem.impression) == null || list2.size() == 0) {
            return;
        }
        new e(view.getContext(), this.a, this).execute();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (System.currentTimeMillis() - this.f9047f < 1000) {
            us.pinguo.advsdk.utils.b.a("click interval too short");
            return;
        }
        b.a aVar = this.f9046e;
        if (aVar != null) {
            aVar.onClick();
        }
        this.f9047f = System.currentTimeMillis();
        Context context = view.getContext();
        new us.pinguo.advsdk.network.c(view.getContext(), this.a, this, this.f9045d).execute();
        k kVar = this.b;
        if (kVar != null) {
            kVar.d(this);
        }
        if (TextUtils.isEmpty(this.a.clickUrl) && TextUtils.isEmpty(this.a.landingUrl)) {
            return;
        }
        new us.pinguo.advsdk.b.a().a(context, this.a);
    }

    @Override // us.pinguo.advsdk.a.b
    public void p(View view, List<View> list, ViewGroup viewGroup, b.a aVar) {
        List<String> list2;
        super.p(view, list, viewGroup, aVar);
        this.f9046e = aVar;
        if (this.a == null) {
            return;
        }
        view.setOnClickListener(this);
        PgAdvManager.getInstance().i().d();
        AdsItem adsItem = this.a;
        if (adsItem == null || (list2 = adsItem.impression) == null || list2.size() == 0) {
            return;
        }
        new e(view.getContext(), this.a, this).execute();
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
        if (view != null) {
            view.setOnClickListener(this);
        }
    }
}
