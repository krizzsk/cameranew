package com.pinguo.camera360.adv.e.g;

import android.app.Activity;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
/* compiled from: EditResultMobuuNativeLayout.java */
/* loaded from: classes3.dex */
public class c extends d {
    public c(Activity activity, us.pinguo.advsdk.a.b bVar, ViewGroup viewGroup) {
        super(activity, bVar, viewGroup);
    }

    @Override // com.pinguo.camera360.adv.e.g.d, com.pinguo.camera360.adv.e.c.c, us.pinguo.admobvista.d.a
    public void a() {
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup, 0);
        this.a.removeAllViews();
        ((us.pinguo.advsdk.a.b) this.f6164l).o(this.a, new ArrayList(), this.a);
        r();
    }

    @Override // com.pinguo.camera360.adv.e.g.d, com.pinguo.camera360.adv.e.c.c
    public int g() {
        return 0;
    }
}
