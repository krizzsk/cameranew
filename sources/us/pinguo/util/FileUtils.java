package us.pinguo.util;

import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
/* compiled from: FileUtils.kt */
/* loaded from: classes6.dex */
public final class FileUtils {
    public static final FileUtils a = new FileUtils();

    private FileUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.io.File r11, java.io.File r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.a(java.io.File, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072 A[PHI: r8 
      PHI: (r8v8 java.lang.Object) = (r8v7 java.lang.Object), (r8v1 java.lang.Object) binds: [B:25:0x006f, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileUtils$copyDir$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileUtils$copyDir$1 r0 = (us.pinguo.util.FileUtils$copyDir$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$copyDir$1 r0 = new us.pinguo.util.FileUtils$copyDir$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.j.b(r8)
            goto L72
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r6 = r0.L$0
            java.io.File r6 = (java.io.File) r6
            kotlin.j.b(r8)
            goto L64
        L3f:
            java.lang.Object r6 = r0.L$0
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            goto L56
        L48:
            kotlin.j.b(r8)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r(r6, r0)
            if (r8 != r1) goto L56
            return r1
        L56:
            r6 = r8
            java.io.File r6 = (java.io.File) r6
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r(r7, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            java.io.File r8 = (java.io.File) r8
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = a(r6, r8, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.b(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(java.io.File r7, java.io.File r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            boolean r0 = r9 instanceof us.pinguo.util.FileUtils$copyFile$1
            if (r0 == 0) goto L13
            r0 = r9
            us.pinguo.util.FileUtils$copyFile$1 r0 = (us.pinguo.util.FileUtils$copyFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$copyFile$1 r0 = new us.pinguo.util.FileUtils$copyFile$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$0
            java.io.BufferedInputStream r7 = (java.io.BufferedInputStream) r7
            kotlin.j.b(r9)     // Catch: java.lang.Throwable -> L32
            goto Lb5
        L32:
            r8 = move-exception
            goto Lbf
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.io.File r8 = (java.io.File) r8
            java.lang.Object r7 = r0.L$0
            java.io.File r7 = (java.io.File) r7
            kotlin.j.b(r9)
            goto L8d
        L4a:
            kotlin.j.b(r9)
            if (r7 == 0) goto Lcc
            if (r8 != 0) goto L53
            goto Lcc
        L53:
            boolean r9 = kotlin.jvm.internal.s.c(r7, r8)
            if (r9 == 0) goto L5e
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        L5e:
            boolean r9 = r7.exists()
            if (r9 == 0) goto Lc7
            boolean r9 = r7.isFile()
            if (r9 != 0) goto L6b
            goto Lc7
        L6b:
            boolean r9 = r8.exists()
            if (r9 == 0) goto L7c
            boolean r9 = r8.delete()
            if (r9 != 0) goto L7c
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        L7c:
            java.io.File r9 = r8.getParentFile()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = e(r9, r0)
            if (r9 != r1) goto L8d
            return r1
        L8d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L9a
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        L9a:
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r7)
            r9.<init>(r2)
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Lbd
            r7 = 0
            r0.L$1 = r7     // Catch: java.lang.Throwable -> Lbd
            r0.label = r3     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r7 = us.pinguo.util.FileIOUtils.k(r8, r9, r0)     // Catch: java.lang.Throwable -> Lbd
            if (r7 != r1) goto Lb2
            return r1
        Lb2:
            r6 = r9
            r9 = r7
            r7 = r6
        Lb5:
            java.io.Closeable[] r8 = new java.io.Closeable[r4]
            r8[r5] = r7
            us.pinguo.util.f.a(r8)
            return r9
        Lbd:
            r8 = move-exception
            r7 = r9
        Lbf:
            java.io.Closeable[] r9 = new java.io.Closeable[r4]
            r9[r5] = r7
            us.pinguo.util.f.a(r9)
            throw r8
        Lc7:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        Lcc:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.c(java.io.File, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072 A[PHI: r8 
      PHI: (r8v8 java.lang.Object) = (r8v7 java.lang.Object), (r8v1 java.lang.Object) binds: [B:25:0x006f, B:13:0x002b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileUtils$copyFile$2
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileUtils$copyFile$2 r0 = (us.pinguo.util.FileUtils$copyFile$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$copyFile$2 r0 = new us.pinguo.util.FileUtils$copyFile$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.j.b(r8)
            goto L72
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r6 = r0.L$0
            java.io.File r6 = (java.io.File) r6
            kotlin.j.b(r8)
            goto L64
        L3f:
            java.lang.Object r6 = r0.L$0
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            goto L56
        L48:
            kotlin.j.b(r8)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r(r6, r0)
            if (r8 != r1) goto L56
            return r1
        L56:
            r6 = r8
            java.io.File r6 = (java.io.File) r6
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r(r7, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            java.io.File r8 = (java.io.File) r8
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = c(r6, r8, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.d(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object e(File file, Continuation<? super Boolean> continuation) {
        boolean z;
        if (file != null) {
            if (file.exists() ? file.isDirectory() : file.mkdirs()) {
                z = true;
                return Boxing.boxBoolean(z);
            }
        }
        z = false;
        return Boxing.boxBoolean(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[PHI: r6 
      PHI: (r6v6 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:20:0x004c, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$createOrExistsDir$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$createOrExistsDir$1 r0 = (us.pinguo.util.FileUtils$createOrExistsDir$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$createOrExistsDir$1 r0 = new us.pinguo.util.FileUtils$createOrExistsDir$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r6)
            goto L4f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.j.b(r6)
            goto L44
        L38:
            kotlin.j.b(r6)
            r0.label = r4
            java.lang.Object r6 = r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r0.label = r3
            java.lang.Object r6 = e(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.f(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(java.io.File r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$createOrExistsFile$2
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$createOrExistsFile$2 r0 = (us.pinguo.util.FileUtils$createOrExistsFile$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$createOrExistsFile$2 r0 = new us.pinguo.util.FileUtils$createOrExistsFile$2
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.io.File r5 = (java.io.File) r5
            kotlin.j.b(r6)
            goto L5e
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.j.b(r6)
            if (r5 != 0) goto L40
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r5
        L40:
            boolean r6 = r5.exists()
            if (r6 == 0) goto L4f
            boolean r5 = r5.isFile()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        L4f:
            java.io.File r6 = r5.getParentFile()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = e(r6, r0)
            if (r6 != r1) goto L5e
            return r1
        L5e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L6b
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r5
        L6b:
            boolean r4 = r5.createNewFile()     // Catch: java.io.IOException -> L70
            goto L74
        L70:
            r5 = move-exception
            r5.printStackTrace()
        L74:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.g(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[PHI: r6 
      PHI: (r6v6 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:20:0x004c, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$createOrExistsFile$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$createOrExistsFile$1 r0 = (us.pinguo.util.FileUtils$createOrExistsFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$createOrExistsFile$1 r0 = new us.pinguo.util.FileUtils$createOrExistsFile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r6)
            goto L4f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.j.b(r6)
            goto L44
        L38:
            kotlin.j.b(r6)
            r0.label = r4
            java.lang.Object r6 = r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r0.label = r3
            java.lang.Object r6 = g(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.h(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(java.io.File r4, java.io.FileFilter r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$deleteFile$4
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$deleteFile$4 r0 = (us.pinguo.util.FileUtils$deleteFile$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$deleteFile$4 r0 = new us.pinguo.util.FileUtils$deleteFile$4
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.io.File r4 = (java.io.File) r4
            kotlin.j.b(r6)
            goto L57
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.j.b(r6)
            r6 = 0
            if (r4 == 0) goto L78
            boolean r2 = r4.exists()
            if (r2 != 0) goto L42
            goto L78
        L42:
            boolean r2 = r4.isDirectory()
            if (r2 == 0) goto L65
            java.io.File[] r5 = r4.listFiles(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = m(r5, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            r4.delete()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r4
        L65:
            boolean r5 = r5.accept(r4)
            if (r5 == 0) goto L72
            boolean r4 = r4.delete()
            if (r4 == 0) goto L72
            goto L73
        L72:
            r3 = 0
        L73:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L78:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.i(java.io.File, java.io.FileFilter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(java.io.File r4, kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            boolean r0 = r5 instanceof us.pinguo.util.FileUtils$deleteFile$2
            if (r0 == 0) goto L13
            r0 = r5
            us.pinguo.util.FileUtils$deleteFile$2 r0 = (us.pinguo.util.FileUtils$deleteFile$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$deleteFile$2 r0 = new us.pinguo.util.FileUtils$deleteFile$2
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.io.File r4 = (java.io.File) r4
            kotlin.j.b(r5)
            goto L56
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.j.b(r5)
            if (r4 == 0) goto L68
            boolean r5 = r4.exists()
            if (r5 != 0) goto L41
            goto L68
        L41:
            boolean r5 = r4.isDirectory()
            if (r5 == 0) goto L5f
            java.io.File[] r5 = r4.listFiles()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = m(r5, r0)
            if (r5 != r1) goto L56
            return r1
        L56:
            boolean r4 = r4.delete()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L5f:
            boolean r4 = r4.delete()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L68:
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.j(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[PHI: r7 
      PHI: (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:20:0x0056, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(java.lang.String r5, java.io.FileFilter r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof us.pinguo.util.FileUtils$deleteFile$3
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.util.FileUtils$deleteFile$3 r0 = (us.pinguo.util.FileUtils$deleteFile$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$deleteFile$3 r0 = new us.pinguo.util.FileUtils$deleteFile$3
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r7)
            goto L59
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.io.FileFilter r6 = (java.io.FileFilter) r6
            kotlin.j.b(r7)
            goto L4b
        L3d:
            kotlin.j.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r(r5, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.io.File r7 = (java.io.File) r7
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = i(r7, r6, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.k(java.lang.String, java.io.FileFilter, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[PHI: r6 
      PHI: (r6v6 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:20:0x004c, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$deleteFile$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$deleteFile$1 r0 = (us.pinguo.util.FileUtils$deleteFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$deleteFile$1 r0 = new us.pinguo.util.FileUtils$deleteFile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r6)
            goto L4f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.j.b(r6)
            goto L44
        L38:
            kotlin.j.b(r6)
            r0.label = r4
            java.lang.Object r6 = r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r0.label = r3
            java.lang.Object r6 = j(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.l(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0055 -> B:34:0x006b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x005f -> B:31:0x0062). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(java.io.File[] r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$deleteFile$5
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$deleteFile$5 r0 = (us.pinguo.util.FileUtils$deleteFile$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$deleteFile$5 r0 = new us.pinguo.util.FileUtils$deleteFile$5
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r5 = r0.L$0
            java.util.Iterator r5 = (java.util.Iterator) r5
            kotlin.j.b(r6)
            goto L62
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.j.b(r6)
            if (r5 == 0) goto L72
            int r6 = r5.length
            if (r6 != 0) goto L40
            r6 = 1
            goto L41
        L40:
            r6 = 0
        L41:
            if (r6 == 0) goto L44
            goto L72
        L44:
            java.util.Iterator r5 = kotlin.jvm.internal.h.a(r5)
        L48:
            r6 = 1
        L49:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L6d
            java.lang.Object r2 = r5.next()
            java.io.File r2 = (java.io.File) r2
            if (r6 == 0) goto L6b
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = j(r2, r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L6b
            goto L48
        L6b:
            r6 = 0
            goto L49
        L6d:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r5
        L72:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.m(java.io.File[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object n(File file, Continuation<? super Boolean> continuation) {
        if (file == null) {
            return Boxing.boxBoolean(false);
        }
        if (file.exists()) {
            return Boxing.boxBoolean(file.isDirectory());
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[PHI: r6 
      PHI: (r6v6 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:20:0x004c, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$dirExists$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$dirExists$1 r0 = (us.pinguo.util.FileUtils$dirExists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$dirExists$1 r0 = new us.pinguo.util.FileUtils$dirExists$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r6)
            goto L4f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.j.b(r6)
            goto L44
        L38:
            kotlin.j.b(r6)
            r0.label = r4
            java.lang.Object r6 = r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r0.label = r3
            java.lang.Object r6 = n(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.o(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object p(File file, Continuation<? super Boolean> continuation) {
        if (file == null) {
            return Boxing.boxBoolean(false);
        }
        if (file.exists()) {
            return Boxing.boxBoolean(file.isFile());
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[PHI: r6 
      PHI: (r6v6 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:20:0x004c, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileUtils$fileExists$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileUtils$fileExists$1 r0 = (us.pinguo.util.FileUtils$fileExists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileUtils$fileExists$1 r0 = new us.pinguo.util.FileUtils$fileExists$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r6)
            goto L4f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.j.b(r6)
            goto L44
        L38:
            kotlin.j.b(r6)
            r0.label = r4
            java.lang.Object r6 = r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r0.label = r3
            java.lang.Object r6 = p(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileUtils.q(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object r(String str, Continuation<? super File> continuation) {
        if (a.s(str)) {
            return null;
        }
        return new File(str);
    }

    private final boolean s(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }
}
