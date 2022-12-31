package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.core.h;
import com.facebook.imagepipeline.core.i;
import javax.annotation.Nullable;
/* compiled from: Fresco.java */
/* loaded from: classes.dex */
public class c {
    private static final Class<?> a = c.class;
    private static PipelineDraweeControllerBuilderSupplier b = null;
    private static volatile boolean c = false;

    private c() {
    }

    public static h a() {
        return b().j();
    }

    public static ImagePipelineFactory b() {
        return ImagePipelineFactory.getInstance();
    }

    public static void c(Context context) {
        e(context, null, null);
    }

    public static void d(Context context, @Nullable i iVar) {
        e(context, iVar, null);
    }

    public static void e(Context context, @Nullable i iVar, @Nullable b bVar) {
        f(context, iVar, bVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (com.facebook.imagepipeline.f.b.d() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (com.facebook.imagepipeline.f.b.d() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
        if (com.facebook.imagepipeline.f.b.d() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        if (com.facebook.imagepipeline.f.b.d() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008b, code lost:
        if (com.facebook.imagepipeline.f.b.d() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
        com.facebook.imagepipeline.f.b.b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(android.content.Context r5, @javax.annotation.Nullable com.facebook.imagepipeline.core.i r6, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.b r7, boolean r8) {
        /*
            boolean r0 = com.facebook.imagepipeline.f.b.d()
            if (r0 == 0) goto Lb
            java.lang.String r0 = "Fresco#initialize"
            com.facebook.imagepipeline.f.b.a(r0)
        Lb:
            boolean r0 = com.facebook.drawee.backends.pipeline.c.c
            r1 = 1
            if (r0 == 0) goto L18
            java.lang.Class<?> r0 = com.facebook.drawee.backends.pipeline.c.a
            java.lang.String r2 = "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!"
            com.facebook.common.logging.a.v(r0, r2)
            goto L1a
        L18:
            com.facebook.drawee.backends.pipeline.c.c = r1
        L1a:
            com.facebook.imagepipeline.core.l.b(r8)
            boolean r8 = com.facebook.soloader.n.a.c()
            if (r8 != 0) goto L9b
            boolean r8 = com.facebook.imagepipeline.f.b.d()
            if (r8 == 0) goto L2e
            java.lang.String r8 = "Fresco.initialize->SoLoader.init"
            com.facebook.imagepipeline.f.b.a(r8)
        L2e:
            java.lang.String r8 = "com.facebook.imagepipeline.nativecode.NativeCodeInitializer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            java.lang.String r0 = "init"
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            java.lang.reflect.Method r8 = r8.getMethod(r0, r2)     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            r1[r4] = r5     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            r8.invoke(r0, r1)     // Catch: java.lang.Throwable -> L50 java.lang.NoSuchMethodException -> L52 java.lang.reflect.InvocationTargetException -> L61 java.lang.IllegalAccessException -> L70 java.lang.ClassNotFoundException -> L7f
            boolean r8 = com.facebook.imagepipeline.f.b.d()
            if (r8 == 0) goto L9b
            goto L8d
        L50:
            r5 = move-exception
            goto L91
        L52:
            com.facebook.soloader.n.c r8 = new com.facebook.soloader.n.c     // Catch: java.lang.Throwable -> L50
            r8.<init>()     // Catch: java.lang.Throwable -> L50
            com.facebook.soloader.n.a.b(r8)     // Catch: java.lang.Throwable -> L50
            boolean r8 = com.facebook.imagepipeline.f.b.d()
            if (r8 == 0) goto L9b
            goto L8d
        L61:
            com.facebook.soloader.n.c r8 = new com.facebook.soloader.n.c     // Catch: java.lang.Throwable -> L50
            r8.<init>()     // Catch: java.lang.Throwable -> L50
            com.facebook.soloader.n.a.b(r8)     // Catch: java.lang.Throwable -> L50
            boolean r8 = com.facebook.imagepipeline.f.b.d()
            if (r8 == 0) goto L9b
            goto L8d
        L70:
            com.facebook.soloader.n.c r8 = new com.facebook.soloader.n.c     // Catch: java.lang.Throwable -> L50
            r8.<init>()     // Catch: java.lang.Throwable -> L50
            com.facebook.soloader.n.a.b(r8)     // Catch: java.lang.Throwable -> L50
            boolean r8 = com.facebook.imagepipeline.f.b.d()
            if (r8 == 0) goto L9b
            goto L8d
        L7f:
            com.facebook.soloader.n.c r8 = new com.facebook.soloader.n.c     // Catch: java.lang.Throwable -> L50
            r8.<init>()     // Catch: java.lang.Throwable -> L50
            com.facebook.soloader.n.a.b(r8)     // Catch: java.lang.Throwable -> L50
            boolean r8 = com.facebook.imagepipeline.f.b.d()
            if (r8 == 0) goto L9b
        L8d:
            com.facebook.imagepipeline.f.b.b()
            goto L9b
        L91:
            boolean r6 = com.facebook.imagepipeline.f.b.d()
            if (r6 == 0) goto L9a
            com.facebook.imagepipeline.f.b.b()
        L9a:
            throw r5
        L9b:
            android.content.Context r5 = r5.getApplicationContext()
            if (r6 != 0) goto La5
            com.facebook.imagepipeline.core.ImagePipelineFactory.t(r5)
            goto La8
        La5:
            com.facebook.imagepipeline.core.ImagePipelineFactory.u(r6)
        La8:
            g(r5, r7)
            boolean r5 = com.facebook.imagepipeline.f.b.d()
            if (r5 == 0) goto Lb4
            com.facebook.imagepipeline.f.b.b()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.c.f(android.content.Context, com.facebook.imagepipeline.core.i, com.facebook.drawee.backends.pipeline.b, boolean):void");
    }

    private static void g(Context context, @Nullable b bVar) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("Fresco.initializeDrawee");
        }
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(context, bVar);
        b = pipelineDraweeControllerBuilderSupplier;
        SimpleDraweeView.m(pipelineDraweeControllerBuilderSupplier);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    public static e h() {
        return b.get();
    }
}
