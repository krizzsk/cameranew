package com.facebook.imagepipeline.core;

import com.facebook.common.references.SharedReference;
import com.facebook.common.references.a;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Nullable;
/* compiled from: CloseableReferenceFactory.java */
/* loaded from: classes.dex */
public class a {
    private final a.c a;

    /* compiled from: CloseableReferenceFactory.java */
    /* renamed from: com.facebook.imagepipeline.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0098a implements a.c {
        final /* synthetic */ com.facebook.imagepipeline.b.a a;

        C0098a(a aVar, com.facebook.imagepipeline.b.a aVar2) {
            this.a = aVar2;
        }

        @Override // com.facebook.common.references.a.c
        public void a(SharedReference<Object> sharedReference, @Nullable Throwable th) {
            this.a.a(sharedReference, th);
            Object f2 = sharedReference.f();
            com.facebook.common.logging.a.z("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), f2 != null ? f2.getClass().getName() : "<value is null>", a.d(th));
        }

        @Override // com.facebook.common.references.a.c
        public boolean b() {
            return this.a.b();
        }
    }

    public a(com.facebook.imagepipeline.b.a aVar) {
        this.a = new C0098a(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(@Nullable Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public <U extends Closeable> com.facebook.common.references.a<U> b(U u) {
        return com.facebook.common.references.a.S(u, this.a);
    }

    public <T> com.facebook.common.references.a<T> c(T t, com.facebook.common.references.h<T> hVar) {
        return com.facebook.common.references.a.U(t, hVar, this.a);
    }
}
