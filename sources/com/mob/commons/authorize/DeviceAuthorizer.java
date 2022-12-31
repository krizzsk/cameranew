package com.mob.commons.authorize;

import android.text.TextUtils;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class DeviceAuthorizer implements PublicMemberKeeper {
    static String a;
    private static HashSet<String> b = new HashSet<>();
    private static Object c = new Object();

    public static synchronized String authorize(final MobProduct mobProduct) {
        synchronized (DeviceAuthorizer.class) {
            boolean z = false;
            boolean z2 = true;
            if (mobProduct != null) {
                MobProductCollector.registerProduct(mobProduct);
                z = !b.contains(mobProduct.getProductTag());
                if (z) {
                    b.add(mobProduct.getProductTag());
                }
            }
            if (TextUtils.isEmpty(a)) {
                a = new a().a(true, true);
            } else {
                z2 = z;
            }
            if (TextUtils.isEmpty(a)) {
                String b2 = b(mobProduct, null);
                a = b2;
                if (TextUtils.isEmpty(b2)) {
                    return new a().a();
                }
                return a;
            }
            if (z2) {
                new Thread() { // from class: com.mob.commons.authorize.DeviceAuthorizer.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            String b3 = DeviceAuthorizer.b(MobProduct.this, DeviceAuthorizer.a);
                            if (TextUtils.isEmpty(b3)) {
                                return;
                            }
                            DeviceAuthorizer.a = b3;
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                        }
                    }
                }.start();
            }
            return a;
        }
    }

    public static String authorizeForOnce() {
        if (b.G()) {
            return null;
        }
        String str = a;
        return str != null ? str : new a().a(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(MobProduct mobProduct, String str) {
        synchronized (c) {
            a aVar = new a();
            com.mob.commons.a.b();
            if (!b.F() && b.g()) {
                return aVar.a(mobProduct, str);
            }
            return aVar.a(false, true);
        }
    }
}
