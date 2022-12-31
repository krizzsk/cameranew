package us.pinguo.repository2020.abtest;

import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import kotlin.jvm.internal.s;
/* compiled from: VipNoticeABManager.kt */
/* loaded from: classes6.dex */
public final class k {
    public static final k a = new k();

    private k() {
    }

    public final boolean a() {
        return s.c(ABTestManager.a.o(VipHalfScreenController.AB_TEST_GROUP_KEY), "vip_reminder_camera");
    }
}
