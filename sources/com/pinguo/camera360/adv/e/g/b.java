package com.pinguo.camera360.adv.e.g;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.generic.RoundingParams;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.k.b.a;
import org.slf4j.Marker;
import us.pinguo.admobvista.StaticsAdv.AdvItemStatistic;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.Interface.AdvStaticsticInterface;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.e;
import us.pinguo.foundation.statistics.h;
import vStudio.Android.Camera360.R;
/* compiled from: EditResultBrandNativeLayout.java */
/* loaded from: classes3.dex */
public class b extends com.pinguo.camera360.adv.e.c.a {
    private boolean n;

    public b(Activity activity, AdvItem advItem, ViewGroup viewGroup) {
        super(activity, advItem, viewGroup);
        this.n = false;
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c, us.pinguo.admobvista.d.a
    public void a() {
        if ("tpl_image_single".equals(((AdvItem) this.f6164l).templateId)) {
            this.n = true;
        }
        View findViewById = this.f6163k.findViewById(R.id.adv_top);
        if (this.n) {
            findViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(findViewById, 8);
            TextView textView = this.f6159g;
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        }
        super.a();
        h.a.Z("brand_banner", ((AdvItem) this.f6164l).advId, "show");
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public int g() {
        return R.layout.edit_result_adv;
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void j() {
        if (this.n) {
            this.f6157e.setAspectRatio(1.5f);
        } else {
            this.f6157e.setAspectRatio(1.9138756f);
        }
        super.j();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void k() {
        if (this.f6160h == null || this.n) {
            return;
        }
        super.n();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void l() {
        if (this.f6161i == null) {
            return;
        }
        this.f6161i.e().E(RoundingParams.a(3.0f));
        super.l();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void n() {
        if (this.f6159g == null || this.n) {
            return;
        }
        super.n();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void o() {
        if (this.f6158f == null || this.n) {
            return;
        }
        super.o();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        super.onClick(view);
        h.a.Z("brand_banner", ((AdvItem) this.f6164l).advId, "click");
    }

    @Override // com.pinguo.camera360.adv.e.c.a
    public void r() {
        b();
        a.c.a();
        AdvStaticsticInterface GetStaticInterface = AdvStaticsticManager.GetInstance().GetStaticInterface();
        String str = InspireStaticeConfig.EDIT_RESULT_DISPLAY;
        GetStaticInterface.ReportBDNoKey(str, ((AdvItem) this.f6164l).advId + Marker.ANY_NON_NULL_MARKER + ((AdvItem) this.f6164l).imageUrl);
        AdvStaticsticInterface GetStaticInterface2 = AdvStaticsticManager.GetInstance().GetStaticInterface();
        String str2 = InspireStaticeConfig.EDIT_RESULT_DISPLAY;
        GetStaticInterface2.ReportU(str2, ((AdvItem) this.f6164l).advId + Marker.ANY_NON_NULL_MARKER + ((AdvItem) this.f6164l).imageUrl);
        AdvItemStatistic advItemStatistic = new AdvItemStatistic(e.b(), IADStatisticBase.PAGE_EDIT_RESULT_PAGE, IADStatisticBase.POS_NATIVE_LARGE_CARD, false, IADStatisticBase.UNIT_ID_RESULT_BANNER);
        advItemStatistic.setAdvItem((AdvItem) this.f6164l);
        advItemStatistic.ShowStatistics();
    }
}
