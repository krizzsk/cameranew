package us.pinguo.util;

import java.io.File;
import java.io.InputStream;
import kotlin.coroutines.Continuation;
/* compiled from: FileIOUtils.kt */
/* loaded from: classes6.dex */
public final class FileIOUtils {
    public static final FileIOUtils a = new FileIOUtils();
    private static final String b = System.getProperty("line.separator");

    private FileIOUtils() {
    }

    private final boolean a(String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.io.File r9, kotlin.coroutines.Continuation<? super byte[]> r10) {
        /*
            boolean r0 = r10 instanceof us.pinguo.util.FileIOUtils$readFile2Bytes$2
            if (r0 == 0) goto L13
            r0 = r10
            us.pinguo.util.FileIOUtils$readFile2Bytes$2 r0 = (us.pinguo.util.FileIOUtils$readFile2Bytes$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$readFile2Bytes$2 r0 = new us.pinguo.util.FileIOUtils$readFile2Bytes$2
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r9 = r0.L$0
            java.io.File r9 = (java.io.File) r9
            kotlin.j.b(r10)
            goto L43
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.j.b(r10)
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = us.pinguo.util.FileUtils.p(r9, r0)
            if (r10 != r1) goto L43
            return r1
        L43:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r0 = 0
            if (r10 != 0) goto L4d
            return r0
        L4d:
            r10 = 2
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L89
            kotlin.jvm.internal.s.e(r9)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L89
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L89
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L81
            r9.<init>()     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L81
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L99
        L60:
            int r6 = r2.read(r5, r1, r4)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L99
            r7 = -1
            if (r6 == r7) goto L6a
            r9.write(r5, r1, r6)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L99
        L6a:
            if (r6 != r7) goto L60
            byte[] r0 = r9.toByteArray()     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L99
            java.io.Closeable[] r10 = new java.io.Closeable[r10]
            r10[r1] = r2
            r10[r3] = r9
            us.pinguo.util.f.a(r10)
            return r0
        L7a:
            r4 = move-exception
            goto L8c
        L7c:
            r9 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L9a
        L81:
            r4 = move-exception
            r9 = r0
            goto L8c
        L84:
            r9 = move-exception
            r2 = r0
            r0 = r9
            r9 = r2
            goto L9a
        L89:
            r4 = move-exception
            r9 = r0
            r2 = r9
        L8c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L99
            java.io.Closeable[] r10 = new java.io.Closeable[r10]
            r10[r1] = r2
            r10[r3] = r9
            us.pinguo.util.f.a(r10)
            return r0
        L99:
            r0 = move-exception
        L9a:
            java.io.Closeable[] r10 = new java.io.Closeable[r10]
            r10[r1] = r2
            r10[r3] = r9
            us.pinguo.util.f.a(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.b(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
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
    public static final java.lang.Object c(java.lang.String r5, kotlin.coroutines.Continuation<? super byte[]> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileIOUtils$readFile2Bytes$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileIOUtils$readFile2Bytes$1 r0 = (us.pinguo.util.FileIOUtils$readFile2Bytes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$readFile2Bytes$1 r0 = new us.pinguo.util.FileIOUtils$readFile2Bytes$1
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
            java.lang.Object r6 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r0.label = r3
            java.lang.Object r6 = b(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.c(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(java.io.File r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileIOUtils$readFile2String$4
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileIOUtils$readFile2String$4 r0 = (us.pinguo.util.FileIOUtils$readFile2String$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$readFile2String$4 r0 = new us.pinguo.util.FileIOUtils$readFile2String$4
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            java.io.File r6 = (java.io.File) r6
            kotlin.j.b(r8)
            goto L4a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.j.b(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = us.pinguo.util.FileUtils.p(r6, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r0 = 0
            if (r8 != 0) goto L54
            return r0
        L54:
            r8 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r1.<init>()     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            us.pinguo.util.FileIOUtils r2 = us.pinguo.util.FileIOUtils.a     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            boolean r2 = r2.a(r7)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            if (r2 == 0) goto L75
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            kotlin.jvm.internal.s.e(r6)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r4.<init>(r6)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r7.<init>(r2)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            goto L8b
        L75:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            kotlin.jvm.internal.s.e(r6)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            kotlin.jvm.internal.s.e(r7)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r4.<init>(r5, r7)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r7 = r2
        L8b:
            java.lang.String r6 = r7.readLine()     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
            if (r6 == 0) goto La4
            r1.append(r6)     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
        L94:
            java.lang.String r6 = r7.readLine()     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
            if (r6 == 0) goto La2
            java.lang.String r2 = us.pinguo.util.FileIOUtils.b     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
            r1.append(r2)     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
            r1.append(r6)     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
        La2:
            if (r6 != 0) goto L94
        La4:
            java.lang.String r6 = r1.toString()     // Catch: java.io.IOException -> Lb0 java.lang.Throwable -> Lc1
            java.io.Closeable[] r0 = new java.io.Closeable[r3]
            r0[r8] = r7
            us.pinguo.util.f.a(r0)
            return r6
        Lb0:
            r6 = move-exception
            goto Lb6
        Lb2:
            r6 = move-exception
            goto Lc3
        Lb4:
            r6 = move-exception
            r7 = r0
        Lb6:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Lc1
            java.io.Closeable[] r6 = new java.io.Closeable[r3]
            r6[r8] = r7
            us.pinguo.util.f.a(r6)
            return r0
        Lc1:
            r6 = move-exception
            r0 = r7
        Lc3:
            java.io.Closeable[] r7 = new java.io.Closeable[r3]
            r7[r8] = r0
            us.pinguo.util.f.a(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.d(java.io.File, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object e(File file, Continuation<? super String> continuation) {
        return d(file, null, continuation);
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
    public static final java.lang.Object f(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            boolean r0 = r7 instanceof us.pinguo.util.FileIOUtils$readFile2String$2
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.util.FileIOUtils$readFile2String$2 r0 = (us.pinguo.util.FileIOUtils$readFile2String$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$readFile2String$2 r0 = new us.pinguo.util.FileIOUtils$readFile2String$2
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
            java.lang.String r6 = (java.lang.String) r6
            kotlin.j.b(r7)
            goto L4b
        L3d:
            kotlin.j.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.io.File r7 = (java.io.File) r7
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = d(r7, r6, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.f(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[PHI: r6 
      PHI: (r6v6 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:20:0x004d, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            boolean r0 = r6 instanceof us.pinguo.util.FileIOUtils$readFile2String$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.util.FileIOUtils$readFile2String$1 r0 = (us.pinguo.util.FileIOUtils$readFile2String$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$readFile2String$1 r0 = new us.pinguo.util.FileIOUtils$readFile2String$1
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
            goto L50
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
            java.lang.Object r6 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.io.File r6 = (java.io.File) r6
            r5 = 0
            r0.label = r3
            java.lang.Object r6 = d(r6, r5, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.g(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(java.io.File r5, byte[] r6, boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileIOUtils$writeFileFromBytes$4
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileIOUtils$writeFileFromBytes$4 r0 = (us.pinguo.util.FileIOUtils$writeFileFromBytes$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromBytes$4 r0 = new us.pinguo.util.FileIOUtils$writeFileFromBytes$4
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            boolean r7 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            java.io.File r5 = (java.io.File) r5
            kotlin.j.b(r8)
            goto L51
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.j.b(r8)
            if (r6 == 0) goto L9c
            r0.L$0 = r5
            r0.L$1 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.g(r5, r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L5a
            goto L9c
        L5a:
            r8 = 0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84
            kotlin.jvm.internal.s.e(r5)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84
            if (r7 == 0) goto L66
            r7 = 1
            goto L67
        L66:
            r7 = 0
        L67:
            r1.<init>(r5, r7)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84
            r0.write(r6)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7f
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Throwable -> L7c java.io.IOException -> L7f
            java.io.Closeable[] r6 = new java.io.Closeable[r4]
            r6[r3] = r0
            us.pinguo.util.f.a(r6)
            return r5
        L7c:
            r5 = move-exception
            r8 = r0
            goto L94
        L7f:
            r5 = move-exception
            r8 = r0
            goto L85
        L82:
            r5 = move-exception
            goto L94
        L84:
            r5 = move-exception
        L85:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L82
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch: java.lang.Throwable -> L82
            java.io.Closeable[] r6 = new java.io.Closeable[r4]
            r6[r3] = r8
            us.pinguo.util.f.a(r6)
            return r5
        L94:
            java.io.Closeable[] r6 = new java.io.Closeable[r4]
            r6[r3] = r8
            us.pinguo.util.f.a(r6)
            throw r5
        L9c:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.h(java.io.File, byte[], boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[PHI: r7 
      PHI: (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:20:0x0057, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(java.lang.String r5, byte[] r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof us.pinguo.util.FileIOUtils$writeFileFromBytes$1
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.util.FileIOUtils$writeFileFromBytes$1 r0 = (us.pinguo.util.FileIOUtils$writeFileFromBytes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromBytes$1 r0 = new us.pinguo.util.FileIOUtils$writeFileFromBytes$1
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
            goto L5a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            byte[] r6 = (byte[]) r6
            kotlin.j.b(r7)
            goto L4b
        L3d:
            kotlin.j.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.io.File r7 = (java.io.File) r7
            r5 = 0
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = h(r7, r6, r5, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.i(java.lang.String, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[PHI: r8 
      PHI: (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:20:0x005a, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(java.lang.String r5, byte[] r6, boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileIOUtils$writeFileFromBytes$2
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileIOUtils$writeFileFromBytes$2 r0 = (us.pinguo.util.FileIOUtils$writeFileFromBytes$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromBytes$2 r0 = new us.pinguo.util.FileIOUtils$writeFileFromBytes$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r8)
            goto L5d
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            boolean r7 = r0.Z$0
            java.lang.Object r5 = r0.L$0
            r6 = r5
            byte[] r6 = (byte[]) r6
            kotlin.j.b(r8)
            goto L4f
        L3f:
            kotlin.j.b(r8)
            r0.L$0 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            java.io.File r8 = (java.io.File) r8
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = h(r8, r6, r7, r0)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.j(java.lang.String, byte[], boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object k(File file, InputStream inputStream, Continuation<? super Boolean> continuation) {
        return l(file, inputStream, false, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(java.io.File r4, java.io.InputStream r5, boolean r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof us.pinguo.util.FileIOUtils$writeFileFromStream$4
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.util.FileIOUtils$writeFileFromStream$4 r0 = (us.pinguo.util.FileIOUtils$writeFileFromStream$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromStream$4 r0 = new us.pinguo.util.FileIOUtils$writeFileFromStream$4
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r6 = r0.Z$0
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.io.InputStream r5 = (java.io.InputStream) r5
            java.lang.Object r4 = r0.L$0
            java.io.File r4 = (java.io.File) r4
            kotlin.j.b(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.j.b(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r7 = us.pinguo.util.FileUtils.g(r4, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r0 = 0
            if (r7 == 0) goto La6
            if (r5 != 0) goto L5a
            goto La6
        L5a:
            r7 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            if (r6 == 0) goto L63
            r6 = 1
            goto L64
        L63:
            r6 = 0
        L64:
            r2.<init>(r4, r6)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r4]     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
        L6e:
            int r7 = r5.read(r6, r0, r4)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
            r2 = -1
            if (r7 == r2) goto L78
            r1.write(r6, r0, r7)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
        L78:
            if (r7 != r2) goto L6e
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L89
            java.io.Closeable[] r5 = new java.io.Closeable[r3]
            r5[r0] = r1
            us.pinguo.util.f.a(r5)
            return r4
        L86:
            r4 = move-exception
            r7 = r1
            goto L9e
        L89:
            r4 = move-exception
            r7 = r1
            goto L8f
        L8c:
            r4 = move-exception
            goto L9e
        L8e:
            r4 = move-exception
        L8f:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L8c
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch: java.lang.Throwable -> L8c
            java.io.Closeable[] r5 = new java.io.Closeable[r3]
            r5[r0] = r7
            us.pinguo.util.f.a(r5)
            return r4
        L9e:
            java.io.Closeable[] r5 = new java.io.Closeable[r3]
            r5[r0] = r7
            us.pinguo.util.f.a(r5)
            throw r4
        La6:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.l(java.io.File, java.io.InputStream, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[PHI: r7 
      PHI: (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:20:0x0057, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(java.lang.String r5, java.io.InputStream r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof us.pinguo.util.FileIOUtils$writeFileFromStream$1
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.util.FileIOUtils$writeFileFromStream$1 r0 = (us.pinguo.util.FileIOUtils$writeFileFromStream$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromStream$1 r0 = new us.pinguo.util.FileIOUtils$writeFileFromStream$1
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
            goto L5a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.io.InputStream r6 = (java.io.InputStream) r6
            kotlin.j.b(r7)
            goto L4b
        L3d:
            kotlin.j.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.io.File r7 = (java.io.File) r7
            r5 = 0
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = l(r7, r6, r5, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.m(java.lang.String, java.io.InputStream, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[PHI: r8 
      PHI: (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:20:0x005a, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n(java.lang.String r5, java.io.InputStream r6, boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileIOUtils$writeFileFromStream$2
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileIOUtils$writeFileFromStream$2 r0 = (us.pinguo.util.FileIOUtils$writeFileFromStream$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromStream$2 r0 = new us.pinguo.util.FileIOUtils$writeFileFromStream$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r8)
            goto L5d
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            boolean r7 = r0.Z$0
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.io.InputStream r6 = (java.io.InputStream) r6
            kotlin.j.b(r8)
            goto L4f
        L3f:
            kotlin.j.b(r8)
            r0.L$0 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            java.io.File r8 = (java.io.File) r8
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = l(r8, r6, r7, r0)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.n(java.lang.String, java.io.InputStream, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object o(File file, String str, Continuation<? super Boolean> continuation) {
        return p(file, str, false, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(java.io.File r5, java.lang.String r6, boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileIOUtils$writeFileFromString$4
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileIOUtils$writeFileFromString$4 r0 = (us.pinguo.util.FileIOUtils$writeFileFromString$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromString$4 r0 = new us.pinguo.util.FileIOUtils$writeFileFromString$4
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            boolean r7 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            java.io.File r5 = (java.io.File) r5
            kotlin.j.b(r8)
            goto L54
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.j.b(r8)
            if (r5 == 0) goto La0
            if (r6 != 0) goto L45
            goto La0
        L45:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.g(r5, r0)
            if (r8 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L61
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L61:
            r8 = 0
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L88
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L88
            if (r7 == 0) goto L6a
            r7 = 1
            goto L6b
        L6a:
            r7 = 0
        L6b:
            r1.<init>(r5, r7)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L88
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L86 java.io.IOException -> L88
            r0.write(r6)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L83
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L83
            java.io.Closeable[] r6 = new java.io.Closeable[r4]
            r6[r3] = r0
            us.pinguo.util.f.a(r6)
            return r5
        L80:
            r5 = move-exception
            r8 = r0
            goto L98
        L83:
            r5 = move-exception
            r8 = r0
            goto L89
        L86:
            r5 = move-exception
            goto L98
        L88:
            r5 = move-exception
        L89:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L86
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch: java.lang.Throwable -> L86
            java.io.Closeable[] r6 = new java.io.Closeable[r4]
            r6[r3] = r8
            us.pinguo.util.f.a(r6)
            return r5
        L98:
            java.io.Closeable[] r6 = new java.io.Closeable[r4]
            r6[r3] = r8
            us.pinguo.util.f.a(r6)
            throw r5
        La0:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.p(java.io.File, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[PHI: r7 
      PHI: (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v1 java.lang.Object) binds: [B:20:0x0057, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof us.pinguo.util.FileIOUtils$writeFileFromString$1
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.util.FileIOUtils$writeFileFromString$1 r0 = (us.pinguo.util.FileIOUtils$writeFileFromString$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromString$1 r0 = new us.pinguo.util.FileIOUtils$writeFileFromString$1
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
            goto L5a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.j.b(r7)
            goto L4b
        L3d:
            kotlin.j.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.io.File r7 = (java.io.File) r7
            r5 = 0
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = p(r7, r6, r5, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.q(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[PHI: r8 
      PHI: (r8v6 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:20:0x005a, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object r(java.lang.String r5, java.lang.String r6, boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof us.pinguo.util.FileIOUtils$writeFileFromString$2
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.util.FileIOUtils$writeFileFromString$2 r0 = (us.pinguo.util.FileIOUtils$writeFileFromString$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.util.FileIOUtils$writeFileFromString$2 r0 = new us.pinguo.util.FileIOUtils$writeFileFromString$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r8)
            goto L5d
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            boolean r7 = r0.Z$0
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.j.b(r8)
            goto L4f
        L3f:
            kotlin.j.b(r8)
            r0.L$0 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.r(r5, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            java.io.File r8 = (java.io.File) r8
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = p(r8, r6, r7, r0)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.util.FileIOUtils.r(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
