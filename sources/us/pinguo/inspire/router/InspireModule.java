package us.pinguo.inspire.router;

import android.app.Application;
import android.os.Build;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.module.profile.FlowerLoader;
import us.pinguo.librouter.module.inspire.d;
import us.pinguo.user.s0;
import us.pinguo.user.util.l;
/* loaded from: classes9.dex */
public class InspireModule extends us.pinguo.librouter.module.inspire.a {
    @Override // us.pinguo.librouter.c.b
    public void initInAllProcess(Application application) {
    }

    @Override // us.pinguo.librouter.c.b
    public void initInMainProcess(Application application) {
        f.g(new l());
        if (Build.VERSION.SDK_INT >= 23) {
            application.registerActivityLifecycleCallbacks(new b());
        }
        if (s0.getInstance().e()) {
            FlowerLoader flowerLoader = FlowerLoader.INSTANCE;
            flowerLoader.refreshUserProfileForFlowerAndAccountH5();
            flowerLoader.refreshGiftList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.librouter.c.a
    public d initInterface() {
        return new a();
    }
}
