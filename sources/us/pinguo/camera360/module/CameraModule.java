package us.pinguo.camera360.module;

import android.app.Application;
import android.os.Looper;
import com.facebook.imagepipeline.core.i;
import java.util.HashSet;
import us.pinguo.admobvista.AdvPGManager;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advsdk.PgAdvConstants$Mode;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.edit.sdk.core.PGEditCoreAPI;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.interaction.DestinationMessage;
import us.pinguo.interaction.a0;
import us.pinguo.interaction.b0;
import us.pinguo.interaction.c0;
import us.pinguo.interaction.d0;
import us.pinguo.interaction.e0;
import us.pinguo.interaction.f0;
import us.pinguo.interaction.g0;
import us.pinguo.interaction.y;
import us.pinguo.interaction.z;
import us.pinguo.librouter.application.BaseApplication;
/* loaded from: classes3.dex */
public class CameraModule extends us.pinguo.librouter.module.camera.d {
    public boolean initAdvModule = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a() {
        if (us.pinguo.foundation.j.e().i("launch_count", 0) == 0) {
            us.pinguo.foundation.j.e().q("launch_count", 1);
        }
        return false;
    }

    private void initCamera2020() {
        us.pinguo.vip.proxy.b.a.g(new s());
    }

    private static void initGoto() {
        AppGoto appGoto = AppGoto.getInstance();
        appGoto.a(new us.pinguo.interaction.x());
        appGoto.a(new us.pinguo.interaction.r());
        appGoto.a(new us.pinguo.interaction.q());
        appGoto.a(new us.pinguo.interaction.g());
        appGoto.a(new e0());
        appGoto.a(new us.pinguo.interaction.u());
        appGoto.a(new a0());
        appGoto.a(new us.pinguo.interaction.s());
        appGoto.a(new c0());
        appGoto.a(new us.pinguo.interaction.p());
        appGoto.a(new us.pinguo.interaction.m());
        appGoto.a(new y());
        appGoto.a(new f0());
        appGoto.a(new us.pinguo.interaction.k());
        appGoto.a(new us.pinguo.interaction.t());
        appGoto.a(new b0());
        appGoto.a(new us.pinguo.interaction.v());
        appGoto.a(new us.pinguo.interaction.i());
        appGoto.a(new us.pinguo.interaction.w());
        appGoto.a(new us.pinguo.interaction.l());
        appGoto.a(new DestinationMessage());
        appGoto.a(new us.pinguo.interaction.h());
        appGoto.a(new us.pinguo.interaction.n());
        appGoto.a(new d0());
        appGoto.a(new us.pinguo.interaction.j());
        appGoto.a(new us.pinguo.interaction.o());
        appGoto.a(new z());
        appGoto.a(new us.pinguo.interaction.f());
        appGoto.a(new us.pinguo.interaction.e());
        appGoto.a(new us.pinguo.edit2020.model.editgoto.a());
        appGoto.a(new g0());
    }

    private void updateAdvData() {
        if (System.currentTimeMillis() - ((Long) com.pinguo.camera360.adv.f.c.a(BaseApplication.d(), "adv_data_last_update_time", 0L)).longValue() <= 7200000) {
            return;
        }
        AdvConfigManager.getInstance().forceUpdate(false);
        com.pinguo.camera360.adv.f.c.b(BaseApplication.d(), "adv_data_last_update_time", Long.valueOf(System.currentTimeMillis()));
    }

    @Override // us.pinguo.librouter.module.camera.d
    public void initAdvModule(Application application) {
        if ((!us.pinguo.user.util.n.i() || us.pinguo.foundation.j.e().i("key_version_code", -1) >= 10) && !this.initAdvModule) {
            this.initAdvModule = true;
            try {
                com.pinguo.camera360.adv.BroadCastManager.a.a(application);
            } catch (Throwable unused) {
            }
            com.pinguo.camera360.adv.c cVar = new com.pinguo.camera360.adv.c();
            AdvConfigManager.getInstance().init(application, cVar, new t());
            updateAdvData();
            PgAdvManager.getInstance().x(cVar);
            AdvPGManager.getInstance().initSDK(BaseApplication.e(), us.pinguo.foundation.d.f10985d ? PgAdvConstants$Mode.MODE_QA : PgAdvConstants$Mode.MODE_RELEASE, us.pinguo.foundation.utils.i.a(), us.pinguo.bigdata.f.a.w(us.pinguo.util.v.a()));
        }
    }

    @Override // us.pinguo.librouter.c.b
    public void initInAllProcess(Application application) {
    }

    @Override // us.pinguo.librouter.c.b
    public void initInMainProcess(Application application) {
        us.pinguo.camera360.shop.data.show.u.b().o(true, true);
        if (us.pinguo.foundation.d.f10985d) {
            HashSet hashSet = new HashSet();
            i.b J = com.facebook.imagepipeline.core.i.J(application);
            J.L(hashSet);
            com.facebook.drawee.backends.pipeline.c.d(application, J.K());
            com.facebook.common.logging.a.n(2);
        } else {
            com.facebook.drawee.backends.pipeline.c.c(application);
        }
        initGoto();
        com.pinguo.album.e.e().d();
        com.pinguo.album.j.c.k(application);
        PGEditCoreAPI.c(application.getApplicationContext());
        Looper.myQueue().addIdleHandler(a.a);
        initCamera2020();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.librouter.c.a
    public us.pinguo.librouter.module.camera.c initInterface() {
        return new r();
    }
}
