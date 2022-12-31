package com.pinguo.camera360.homepage;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.member.NewPayWallActivity;
import com.pinguo.camera360.vip.VipManager;
import vStudio.Android.Camera360.Conditions;
/* compiled from: PayWallExtension.kt */
/* loaded from: classes3.dex */
public final class s0 {
    private static final void a(Context context, boolean z) {
        Intent intent = new Intent();
        intent.setClass(context, NewPayWallActivity.class);
        intent.putExtra("with_full_text", z);
        context.startActivity(intent);
    }

    public static final void b(FragmentActivity fragmentActivity) {
        kotlin.jvm.internal.s.h(fragmentActivity, "<this>");
        if (!VipManager.a.I() && CameraBusinessSettingModel.v().o() && Conditions.e() && us.pinguo.util.p.a.f()) {
            us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
            if (us.pinguo.repository2020.utils.o.b(oVar, "display_pay_wall", false, null, 4, null)) {
                return;
            }
            us.pinguo.repository2020.utils.o.n(oVar, "display_pay_wall", true, null, 4, null);
            us.pinguo.repository2020.abtest.f.a.d(true);
            a(fragmentActivity, true);
        }
    }
}
