package com.pinguo.camera360.adv.e.g;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.k.b.a;
import org.slf4j.Marker;
import us.pinguo.admobvista.StaticsAdv.AdvItemStatistic;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.Interface.AdvStaticsticInterface;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.common.widget.FunctionItemAnimDraweeView;
import us.pinguo.foundation.e;
import us.pinguo.foundation.statistics.h;
import vStudio.Android.Camera360.R;
/* compiled from: EditResultAttrNativeLayout.java */
/* loaded from: classes3.dex */
public class a extends com.pinguo.camera360.adv.e.c.a {
    public a(Activity activity, AdvItem advItem, ViewGroup viewGroup) {
        super(activity, advItem, viewGroup);
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c, us.pinguo.admobvista.d.a
    public void a() {
        super.a();
        if (((AdvItem) this.f6164l).advType.equals(AdvConstants.ADV_TYPE_ATTRIBUTE)) {
            h.a.Z("attribution_banner", ((AdvItem) this.f6164l).advId, "show");
        } else if (((AdvItem) this.f6164l).advType.equals(AdvConstants.ADV_TYPE_OPERATION)) {
            h.a.Z("op_banner", ((AdvItem) this.f6164l).advId, "show");
        }
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public int g() {
        return R.layout.edit_result_attr_adv;
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void j() {
        if (((AdvItem) this.f6164l).imageUrl.endsWith(".webp")) {
            ((FunctionItemAnimDraweeView) this.f6157e).setImagePath(((AdvItem) this.f6164l).downloadedFilePath);
        } else {
            ((FunctionItemAnimDraweeView) this.f6157e).setImageURI(((AdvItem) this.f6164l).imageUrl);
        }
        this.f6163k.setOnClickListener(this);
        q();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void k() {
        super.n();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void l() {
        super.l();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void n() {
        super.n();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, com.pinguo.camera360.adv.e.c.c
    public void o() {
        super.o();
    }

    @Override // com.pinguo.camera360.adv.e.c.a, android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        super.onClick(view);
        if (((AdvItem) this.f6164l).advType.equals(AdvConstants.ADV_TYPE_ATTRIBUTE)) {
            h.a.Z("attribution_banner", ((AdvItem) this.f6164l).advId, "click");
        } else if (((AdvItem) this.f6164l).advType.equals(AdvConstants.ADV_TYPE_OPERATION)) {
            h.a.Z("op_banner", ((AdvItem) this.f6164l).advId, "click");
        }
    }

    @Override // com.pinguo.camera360.adv.e.c.a
    public void q() {
        super.q();
        Activity activity = this.b;
        if (activity instanceof PGEditResultActivity2) {
            ((PGEditResultActivity2) activity).setAdvToBottom();
        }
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
