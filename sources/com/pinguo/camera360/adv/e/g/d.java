package com.pinguo.camera360.adv.e.g;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.k.b.a;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.Interface.AdvStaticsticInterface;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.foundation.statistics.h;
import vStudio.Android.Camera360.R;
/* compiled from: EditResultNormalNativeLayout.java */
/* loaded from: classes3.dex */
public class d extends com.pinguo.camera360.adv.e.c.b {

    /* compiled from: EditResultNormalNativeLayout.java */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            ViewGroup viewGroup = ((us.pinguo.admobvista.d.a) d.this).a;
            viewGroup.setVisibility(4);
            VdsAgent.onSetViewVisibility(viewGroup, 4);
        }
    }

    public d(Activity activity, us.pinguo.advsdk.a.b bVar, ViewGroup viewGroup) {
        super(activity, bVar, viewGroup);
    }

    @Override // com.pinguo.camera360.adv.e.c.c, us.pinguo.admobvista.d.a
    public void a() {
        super.a();
        h.a.Z("cpc_ad", ((us.pinguo.advsdk.a.b) this.f6164l).f(), "show");
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public int g() {
        if (((us.pinguo.advsdk.a.b) this.f6164l).h() == null) {
            return 0;
        }
        return R.layout.edit_result_adv_content;
    }

    @Override // com.pinguo.camera360.adv.e.c.b
    public void q() {
        super.q();
        Activity activity = this.b;
        if (activity instanceof PGEditResultActivity2) {
            ((PGEditResultActivity2) activity).setAdvToBottom();
        }
        View findViewById = this.f6163k.findViewById(R.id.close_button);
        if (findViewById != null) {
            findViewById.setOnClickListener(new a());
        }
    }

    @Override // com.pinguo.camera360.adv.e.c.b
    public void r() {
        super.r();
        a.c.a();
        AdvStaticsticInterface GetStaticInterface = AdvStaticsticManager.GetInstance().GetStaticInterface();
        String str = InspireStaticeConfig.EDIT_RESULT_DISPLAY;
        GetStaticInterface.ReportBDNoKey(str, "null+" + ((us.pinguo.advsdk.a.b) this.f6164l).g());
        AdvStaticsticInterface GetStaticInterface2 = AdvStaticsticManager.GetInstance().GetStaticInterface();
        String str2 = InspireStaticeConfig.EDIT_RESULT_DISPLAY;
        GetStaticInterface2.ReportU(str2, "null+" + ((us.pinguo.advsdk.a.b) this.f6164l).g());
    }
}
