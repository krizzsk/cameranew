package us.pinguo.repository2020.manager;

import android.text.TextUtils;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.s;
import kotlin.text.Regex;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.foundation.utils.o0;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import us.pinguo.repository2020.entity.FilterDetailData;
import us.pinguo.repository2020.entity.FilterDetailResponse;
import us.pinguo.repository2020.q;
/* compiled from: FilterInstallManager.kt */
/* loaded from: classes6.dex */
public final class FilterInstallManager {
    private final a a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11905d;

    /* compiled from: FilterInstallManager.kt */
    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* compiled from: FilterInstallManager.kt */
    /* loaded from: classes6.dex */
    public static final class b implements us.pinguo.repository2020.network.b<FilterDetailResponse> {
        final /* synthetic */ q a;
        final /* synthetic */ FilterInstallManager b;

        b(q qVar, FilterInstallManager filterInstallManager) {
            this.a = qVar;
            this.b = filterInstallManager;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
            if ((!(r0.length == 0)) == true) goto L4;
         */
        @Override // us.pinguo.repository2020.network.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSuccess(us.pinguo.repository2020.entity.FilterDetailResponse r4) {
            /*
                r3 = this;
                java.lang.String r0 = "response"
                kotlin.jvm.internal.s.h(r4, r0)
                us.pinguo.repository2020.entity.FilterDetailData[] r0 = r4.getData()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto Lf
            Ld:
                r1 = 0
                goto L18
            Lf:
                int r0 = r0.length
                if (r0 != 0) goto L14
                r0 = 1
                goto L15
            L14:
                r0 = 0
            L15:
                r0 = r0 ^ r1
                if (r0 != r1) goto Ld
            L18:
                if (r1 != 0) goto L26
                us.pinguo.repository2020.q r4 = r3.a
                us.pinguo.repository2020.q$a r0 = us.pinguo.repository2020.q.b
                int r0 = r0.d()
                r4.i(r0)
                goto L3a
            L26:
                us.pinguo.repository2020.q r0 = r3.a
                r1 = 20
                r0.j(r1)
                us.pinguo.repository2020.manager.FilterInstallManager r0 = r3.b
                us.pinguo.repository2020.entity.FilterDetailData[] r4 = r4.getData()
                r4 = r4[r2]
                us.pinguo.repository2020.q r1 = r3.a
                us.pinguo.repository2020.manager.FilterInstallManager.b(r0, r4, r1)
            L3a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.b.onSuccess(us.pinguo.repository2020.entity.FilterDetailResponse):void");
        }

        @Override // us.pinguo.repository2020.network.b
        public void onError(int i2, String errMsg) {
            s.h(errMsg, "errMsg");
            this.a.i(q.b.b());
        }
    }

    public FilterInstallManager(a installWatcher) {
        s.h(installWatcher, "installWatcher");
        this.a = installWatcher;
        this.b = 31457280;
        this.c = 1;
        this.f11905d = 11;
        new m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0223  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(us.pinguo.repository2020.entity.FilterDetailData r30, java.io.File r31, int r32, us.pinguo.repository2020.entity.PackageItem r33, kotlin.coroutines.Continuation<? super kotlin.u> r34) {
        /*
            Method dump skipped, instructions count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.A(us.pinguo.repository2020.entity.FilterDetailData, java.io.File, int, us.pinguo.repository2020.entity.PackageItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(us.pinguo.repository2020.entity.FilterDetailData r29, java.lang.String r30, java.lang.String r31, us.pinguo.repository2020.entity.PackageItem r32, kotlin.coroutines.Continuation<? super kotlin.u> r33) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.B(us.pinguo.repository2020.entity.FilterDetailData, java.lang.String, java.lang.String, us.pinguo.repository2020.entity.PackageItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((long) this.b) <= o0.d(us.pinguo.foundation.e.b()).a(new File(str).getParent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(int r32, java.lang.String r33, java.lang.String r34, java.io.File r35, java.lang.String r36, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.database.filter.FilterParamsTable> r37) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.l(int, java.lang.String, java.lang.String, java.io.File, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(FilterDetailData filterDetailData, q qVar) {
        kotlinx.coroutines.j.d(n0.a(z0.b()), null, null, new FilterInstallManager$downloadFilterFiles$1(filterDetailData, qVar, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r15, java.lang.String r16, us.pinguo.repository2020.q r17, kotlin.coroutines.Continuation<? super java.lang.Boolean> r18) {
        /*
            r14 = this;
            r1 = r16
            r4 = r17
            kotlin.coroutines.SafeContinuation r6 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r18)
            r6.<init>(r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L28
            kotlin.Result$a r0 = kotlin.Result.Companion
            r0 = 1
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            java.lang.Object r0 = kotlin.Result.m41constructorimpl(r0)
            r6.resumeWith(r0)
        L26:
            r7 = r14
            goto L84
        L28:
            android.content.Context r0 = us.pinguo.foundation.e.b()
            boolean r0 = us.pinguo.util.q.f(r0)
            r2 = 0
            if (r0 != 0) goto L4a
            us.pinguo.repository2020.q$a r0 = us.pinguo.repository2020.q.b
            int r0 = r0.b()
            r4.i(r0)
            kotlin.Result$a r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            java.lang.Object r0 = kotlin.Result.m41constructorimpl(r0)
            r6.resumeWith(r0)
            goto L26
        L4a:
            r7 = r14
            boolean r0 = r14.k(r1)
            if (r0 != 0) goto L68
            us.pinguo.repository2020.q$a r0 = us.pinguo.repository2020.q.b
            int r0 = r0.c()
            r4.i(r0)
            kotlin.Result$a r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            java.lang.Object r0 = kotlin.Result.m41constructorimpl(r0)
            r6.resumeWith(r0)
            goto L84
        L68:
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.z0.b()
            kotlinx.coroutines.m0 r8 = kotlinx.coroutines.n0.a(r0)
            r9 = 0
            r10 = 0
            us.pinguo.repository2020.manager.FilterInstallManager$executeDownLoad$2$1 r11 = new us.pinguo.repository2020.manager.FilterInstallManager$executeDownLoad$2$1
            r5 = 0
            r0 = r11
            r1 = r16
            r2 = r15
            r3 = r6
            r4 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r12 = 3
            r13 = 0
            kotlinx.coroutines.j.d(r8, r9, r10, r11, r12, r13)
        L84:
            java.lang.Object r0 = r6.getOrThrow()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L91
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r18)
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.n(java.lang.String, java.lang.String, us.pinguo.repository2020.q, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long o() {
        long currentTimeMillis = System.currentTimeMillis();
        List<FilterPackageTable> a2 = us.pinguo.repository2020.database.a.a().x().a();
        if (a2.isEmpty()) {
            return currentTimeMillis;
        }
        long sort = a2.get(0).getSort();
        return currentTimeMillis > sort ? currentTimeMillis : currentTimeMillis + sort;
    }

    private final int p(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = Pattern.compile("[1-9][0-9]*").matcher(str);
        if (matcher.find()) {
            Integer valueOf = Integer.valueOf(matcher.group());
            s.g(valueOf, "{\n            Integer.va…atcher.group())\n        }");
            return valueOf.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(us.pinguo.repository2020.entity.FilterDetailData r11, us.pinguo.repository2020.q r12, kotlin.coroutines.Continuation<? super kotlin.u> r13) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.r(us.pinguo.repository2020.entity.FilterDetailData, us.pinguo.repository2020.q, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean s(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("\\bv[0-9]+\\b").matcher(str).matches();
    }

    private final String u(String str) {
        return new Regex("isPremultiplied=1").replace(str, "isPremultiplied=0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(us.pinguo.repository2020.entity.FilterDetailData r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.v(us.pinguo.repository2020.entity.FilterDetailData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(2:17|18))(3:22|23|(1:25)(1:26))|19|(1:21)|12|13))|29|6|7|(0)(0)|19|(0)|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        r11.printStackTrace();
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(us.pinguo.repository2020.entity.FilterDetailData r11, java.lang.String r12, java.lang.String r13, us.pinguo.repository2020.entity.PackageItem r14, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof us.pinguo.repository2020.manager.FilterInstallManager$writeDatabase$1
            if (r0 == 0) goto L13
            r0 = r15
            us.pinguo.repository2020.manager.FilterInstallManager$writeDatabase$1 r0 = (us.pinguo.repository2020.manager.FilterInstallManager$writeDatabase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.FilterInstallManager$writeDatabase$1 r0 = new us.pinguo.repository2020.manager.FilterInstallManager$writeDatabase$1
            r0.<init>(r10, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L47
            if (r1 == r9) goto L36
            if (r1 != r8) goto L2e
            kotlin.j.b(r15)     // Catch: java.lang.Exception -> L2c
            goto L74
        L2c:
            r11 = move-exception
            goto L70
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            java.lang.Object r11 = r0.L$2
            r14 = r11
            us.pinguo.repository2020.entity.PackageItem r14 = (us.pinguo.repository2020.entity.PackageItem) r14
            java.lang.Object r11 = r0.L$1
            us.pinguo.repository2020.entity.FilterDetailData r11 = (us.pinguo.repository2020.entity.FilterDetailData) r11
            java.lang.Object r12 = r0.L$0
            us.pinguo.repository2020.manager.FilterInstallManager r12 = (us.pinguo.repository2020.manager.FilterInstallManager) r12
            kotlin.j.b(r15)     // Catch: java.lang.Exception -> L2c
            goto L60
        L47:
            kotlin.j.b(r15)
            r0.L$0 = r10     // Catch: java.lang.Exception -> L2c
            r0.L$1 = r11     // Catch: java.lang.Exception -> L2c
            r0.L$2 = r14     // Catch: java.lang.Exception -> L2c
            r0.label = r9     // Catch: java.lang.Exception -> L2c
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r0
            java.lang.Object r12 = r1.B(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L2c
            if (r12 != r7) goto L5f
            return r7
        L5f:
            r12 = r10
        L60:
            r13 = 0
            r0.L$0 = r13     // Catch: java.lang.Exception -> L2c
            r0.L$1 = r13     // Catch: java.lang.Exception -> L2c
            r0.L$2 = r13     // Catch: java.lang.Exception -> L2c
            r0.label = r8     // Catch: java.lang.Exception -> L2c
            java.lang.Object r11 = r12.z(r11, r14, r0)     // Catch: java.lang.Exception -> L2c
            if (r11 != r7) goto L74
            return r7
        L70:
            r11.printStackTrace()
            r9 = 0
        L74:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.w(us.pinguo.repository2020.entity.FilterDetailData, java.lang.String, java.lang.String, us.pinguo.repository2020.entity.PackageItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0122 -> B:39:0x0125). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(us.pinguo.repository2020.entity.FilterDetailData r23, java.io.File r24, kotlin.coroutines.Continuation<? super kotlin.u> r25) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.x(us.pinguo.repository2020.entity.FilterDetailData, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(FilterInstallManager this$0, File file) {
        s.h(this$0, "this$0");
        if (file.isDirectory()) {
            String name = file.getName();
            s.g(name, "childFile.name");
            if (this$0.s(name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01f4 -> B:75:0x01f5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x01f7 -> B:77:0x01f9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(us.pinguo.repository2020.entity.FilterDetailData r20, us.pinguo.repository2020.entity.PackageItem r21, kotlin.coroutines.Continuation<? super kotlin.u> r22) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager.z(us.pinguo.repository2020.entity.FilterDetailData, us.pinguo.repository2020.entity.PackageItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void q(q listener) {
        s.h(listener, "listener");
        listener.k();
        us.pinguo.repository2020.network.a.a.a(listener.h().getPackageId(), new b(listener, this));
    }
}
