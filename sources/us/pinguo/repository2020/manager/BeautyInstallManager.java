package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import com.pinguo.lib.GsonUtilKt;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.R;
import us.pinguo.repository2020.database.makeup.MaterialDetailTable;
import us.pinguo.repository2020.entity.BeautyParam;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* compiled from: BeautyInstallManager.kt */
/* loaded from: classes6.dex */
public final class BeautyInstallManager {
    public static final BeautyInstallManager a = new BeautyInstallManager();

    private BeautyInstallManager() {
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
    public final java.lang.Object d(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.manager.BeautyInstallManager$parseDisplayJson$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.manager.BeautyInstallManager$parseDisplayJson$1 r0 = (us.pinguo.repository2020.manager.BeautyInstallManager$parseDisplayJson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.BeautyInstallManager$parseDisplayJson$1 r0 = new us.pinguo.repository2020.manager.BeautyInstallManager$parseDisplayJson$1
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
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r6)
            java.lang.String r6 = "i18n"
            java.lang.Object r5 = r5.opt(r6)
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyInstallManager.d(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b(SelfDefMakeupMaterial material, q<? super Boolean, ? super SelfDefMakeupMaterial, ? super String, u> qVar) {
        s.h(material, "material");
        String string = us.pinguo.foundation.e.b().getString(R.string.text_material_install_failed);
        s.g(string, "getAppContext().getStrin…_material_install_failed)");
        String down_url = material.getDown_url();
        if (!(down_url == null || down_url.length() == 0)) {
            String pid = material.getPid();
            if (!(pid == null || pid.length() == 0)) {
                try {
                    String pid2 = material.getPid();
                    s.e(pid2);
                    us.pinguo.repository2020.database.a.a().z().a(new MaterialDetailTable(pid2, null, null, null, material.getIcon(), 0L, null, null, null, null, null, null, 4078, null));
                    if (material.getInstallState() == null) {
                        material.setInstallState(new ObservableField<>(MaterialInstallState.STATE_INSTALLED));
                    } else {
                        ObservableField<MaterialInstallState> installState = material.getInstallState();
                        if (installState != null) {
                            installState.set(MaterialInstallState.STATE_INSTALLED);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (qVar != null) {
                        qVar.invoke(Boolean.FALSE, material, string);
                    }
                }
                if (qVar != null) {
                    qVar.invoke(Boolean.TRUE, material, "");
                    return;
                }
                return;
            }
        }
        if (qVar != null) {
            qVar.invoke(Boolean.FALSE, material, string);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e2  */
    /* JADX WARN: Type inference failed for: r10v10, types: [us.pinguo.repository2020.entity.MaterialDetail] */
    /* JADX WARN: Type inference failed for: r10v12, types: [us.pinguo.repository2020.entity.MaterialDetail] */
    /* JADX WARN: Type inference failed for: r10v14, types: [us.pinguo.repository2020.entity.MaterialDetail] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r36v0, types: [us.pinguo.repository2020.manager.BeautyInstallManager] */
    /* JADX WARN: Type inference failed for: r6v35, types: [us.pinguo.repository2020.entity.MaterialDetail] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0251 -> B:86:0x0253). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T extends us.pinguo.repository2020.entity.MaterialDetail> java.lang.Object c(T r37, kotlin.jvm.b.q<? super java.lang.Boolean, ? super us.pinguo.repository2020.entity.MaterialDetail, ? super java.lang.String, kotlin.u> r38, kotlin.coroutines.Continuation<? super kotlin.u> r39) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyInstallManager.c(us.pinguo.repository2020.entity.MaterialDetail, kotlin.jvm.b.q, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r7, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.SelfDefMakeupParam> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.repository2020.manager.BeautyInstallManager$parseMakeupIndexJson$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.repository2020.manager.BeautyInstallManager$parseMakeupIndexJson$1 r0 = (us.pinguo.repository2020.manager.BeautyInstallManager$parseMakeupIndexJson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.BeautyInstallManager$parseMakeupIndexJson$1 r0 = new us.pinguo.repository2020.manager.BeautyInstallManager$parseMakeupIndexJson$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.j.b(r8)
            goto L75
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            goto L4b
        L3d:
            kotlin.j.b(r8)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.o(r7, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L54
            return r5
        L54:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = java.io.File.separator
            r8.append(r7)
            java.lang.String r7 = "index.json"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = us.pinguo.util.FileIOUtils.g(r7, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L7a
            return r5
        L7a:
            com.google.gson.e r7 = com.pinguo.lib.GsonUtilKt.getCachedGson()     // Catch: java.lang.Exception -> L88
            java.lang.Class<us.pinguo.repository2020.entity.SelfDefMakeupParam> r0 = us.pinguo.repository2020.entity.SelfDefMakeupParam.class
            java.lang.Object r7 = r7.j(r8, r0)     // Catch: java.lang.Exception -> L88
            us.pinguo.repository2020.entity.SelfDefMakeupParam r7 = (us.pinguo.repository2020.entity.SelfDefMakeupParam) r7     // Catch: java.lang.Exception -> L88
            r5 = r7
            goto L8c
        L88:
            r7 = move-exception
            r7.printStackTrace()
        L8c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyInstallManager.e(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r7, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.StyleMakeupParam> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.repository2020.manager.BeautyInstallManager$parsePackageIndexJson$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.repository2020.manager.BeautyInstallManager$parsePackageIndexJson$1 r0 = (us.pinguo.repository2020.manager.BeautyInstallManager$parsePackageIndexJson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.BeautyInstallManager$parsePackageIndexJson$1 r0 = new us.pinguo.repository2020.manager.BeautyInstallManager$parsePackageIndexJson$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.j.b(r8)
            goto L75
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            goto L4b
        L3d:
            kotlin.j.b(r8)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.o(r7, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L54
            return r5
        L54:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = java.io.File.separator
            r8.append(r7)
            java.lang.String r7 = "index.json"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = us.pinguo.util.FileIOUtils.g(r7, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L7a
            return r5
        L7a:
            com.google.gson.e r7 = com.pinguo.lib.GsonUtilKt.getCachedGson()     // Catch: java.lang.Exception -> L88
            java.lang.Class<us.pinguo.repository2020.entity.StyleMakeupParam> r0 = us.pinguo.repository2020.entity.StyleMakeupParam.class
            java.lang.Object r7 = r7.j(r8, r0)     // Catch: java.lang.Exception -> L88
            us.pinguo.repository2020.entity.StyleMakeupParam r7 = (us.pinguo.repository2020.entity.StyleMakeupParam) r7     // Catch: java.lang.Exception -> L88
            r5 = r7
            goto L8c
        L88:
            r7 = move-exception
            r7.printStackTrace()
        L8c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyInstallManager.f(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final BeautyParam g(String beautyParamString) {
        s.h(beautyParamString, "beautyParamString");
        try {
            return (BeautyParam) GsonUtilKt.getCachedGson().j(beautyParamString, BeautyParam.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
