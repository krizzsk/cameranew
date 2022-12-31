package us.pinguo.repository2020.manager;

import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.R;
import us.pinguo.repository2020.entity.MaterialConfig;
import us.pinguo.repository2020.entity.PaintMaterial;
/* compiled from: MaterialInstallManager.kt */
/* loaded from: classes6.dex */
public final class MaterialInstallManager {
    public static final MaterialInstallManager a = new MaterialInstallManager();
    private static final m0 b = n0.a(z0.b());

    /* compiled from: MaterialInstallManager.kt */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.gson.t.a<MaterialConfig> {
        a() {
        }
    }

    private MaterialInstallManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(MaterialInstallManager materialInstallManager, PaintMaterial paintMaterial, q qVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            qVar = null;
        }
        materialInstallManager.b(paintMaterial, qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r5, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.MaterialConfig> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.manager.MaterialInstallManager$parseConfigJson$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.manager.MaterialInstallManager$parseConfigJson$1 r0 = (us.pinguo.repository2020.manager.MaterialInstallManager$parseConfigJson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.MaterialInstallManager$parseConfigJson$1 r0 = new us.pinguo.repository2020.manager.MaterialInstallManager$parseConfigJson$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            r0.label = r3
            java.lang.Object r6 = us.pinguo.util.FileIOUtils.g(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L43
            r5 = 0
            return r5
        L43:
            us.pinguo.repository2020.manager.MaterialInstallManager$a r5 = new us.pinguo.repository2020.manager.MaterialInstallManager$a
            r5.<init>()
            java.lang.reflect.Type r5 = r5.getType()
            com.google.gson.e r0 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Object r5 = r0.k(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.MaterialInstallManager.d(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b(PaintMaterial material, q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar) {
        s.h(material, "material");
        String string = us.pinguo.foundation.e.b().getString(R.string.text_material_install_failed);
        s.g(string, "getAppContext().getStrin…_material_install_failed)");
        String pid = material.getPid();
        String down_url = material.getDown_url();
        boolean z = false;
        if (!(down_url == null || down_url.length() == 0)) {
            if (!((pid == null || pid.length() == 0) ? true : true)) {
                kotlinx.coroutines.l.d(b, null, null, new MaterialInstallManager$installMaterial$1(pid, material, qVar, string, null), 3, null);
                return;
            }
        }
        if (qVar != null) {
            qVar.invoke(Boolean.FALSE, material, string);
        }
    }
}
