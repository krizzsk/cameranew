package com.pinguo.camera360;

import androidx.core.content.ContextCompat;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import j.a.f.i;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.user.u0;
/* loaded from: classes3.dex */
public class DataCollectUtils implements NoProguard {
    public static void disableDataCollect() {
        d.a = true;
        CameraBusinessSettingModel.v().L(false);
        us.pinguo.librouter.b.b.b().getInterface().d(false);
        us.pinguo.bigdata.a.m(false);
        CameraBusinessSettingModel.v().E("key_disable_data_collect", true);
        try {
            u0.o = true;
            i iVar = i.a;
            iVar.d(false);
            iVar.c(false);
            d.b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void enableDataCollect() {
        d.a = false;
        int checkSelfPermission = ContextCompat.checkSelfPermission(ActivityRecorder.getInstance().d(), "android.permission.ACCESS_FINE_LOCATION");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(e.b(), "android.permission.ACCESS_COARSE_LOCATION");
        if (checkSelfPermission == 0 && checkSelfPermission2 != 0) {
            us.pinguo.librouter.b.b.b().getInterface().d(true);
        }
        us.pinguo.bigdata.a.m(true);
        CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
        try {
            u0.o = false;
            i iVar = i.a;
            iVar.d(true);
            iVar.c(true);
            d.c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
