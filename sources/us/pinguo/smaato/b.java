package us.pinguo.smaato;

import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGSmaatoNative.java */
/* loaded from: classes6.dex */
public class b extends us.pinguo.advsdk.a.b {
    private us.pinguo.smaatoapi.b a;
    private AdsItem b;
    private us.pinguo.advsdk.bean.b c;

    /* compiled from: PGSmaatoNative.java */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            b.this.a.j();
        }
    }

    public b(AdsItem adsItem, us.pinguo.smaatoapi.b bVar, us.pinguo.advsdk.bean.b bVar2) {
        this.b = adsItem;
        this.c = bVar2;
        this.a = bVar;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return this.b;
    }

    @Override // us.pinguo.advsdk.a.b
    public String b() {
        return this.a.b();
    }

    @Override // us.pinguo.advsdk.a.b
    public String c() {
        return this.a.h();
    }

    @Override // us.pinguo.advsdk.a.b
    public String d() {
        AdsItem adsItem = this.b;
        return adsItem != null ? adsItem.displayFormat : "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        return this.a.e();
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        return this.a.g();
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return this.a;
    }

    @Override // us.pinguo.advsdk.a.b
    public String j() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String k() {
        return this.a.i();
    }

    @Override // us.pinguo.advsdk.a.b
    public int l() {
        return 35;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        return this.c.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void o(View view, List<View> list, ViewGroup viewGroup) {
        super.o(view, list, viewGroup);
        this.a.l();
        View findViewWithTag = view.findViewWithTag("adv_btn");
        if (findViewWithTag != null) {
            findViewWithTag.setOnClickListener(new a());
        }
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }
}
