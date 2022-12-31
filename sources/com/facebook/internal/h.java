package com.facebook.internal;

import android.app.Activity;
import android.util.Log;
import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.List;
/* compiled from: FacebookDialogBase.java */
/* loaded from: classes.dex */
public abstract class h<CONTENT, RESULT> {

    /* renamed from: e  reason: collision with root package name */
    protected static final Object f3050e = new Object();
    private final Activity a;
    private final n b;
    private List<h<CONTENT, RESULT>.a> c;

    /* renamed from: d  reason: collision with root package name */
    private int f3051d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: FacebookDialogBase.java */
    /* loaded from: classes.dex */
    public abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public a(h hVar) {
        }

        /* JADX WARN: Failed to parse method signature: (TCONTENTZ)Z
        jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TCONTENTZ)Z at position 2 ('C'), unexpected: T
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
        	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
        	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
         */
        public abstract boolean a(Object obj, boolean z);

        /* JADX WARN: Failed to parse method signature: (TCONTENT)Lcom/facebook/internal/a;
        jadx.core.utils.exceptions.JadxRuntimeException: Bad name for type variable: CONTENT)Lcom/facebook/internal/a
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:149)
        	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
        	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
        	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
         */
        public abstract com.facebook.internal.a b(Object obj);

        public Object c() {
            return h.f3050e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Activity activity, int i2) {
        y.l(activity, "activity");
        this.a = activity;
        this.b = null;
        this.f3051d = i2;
    }

    private List<h<CONTENT, RESULT>.a> a() {
        if (this.c == null) {
            this.c = g();
        }
        return this.c;
    }

    private com.facebook.internal.a d(CONTENT content, Object obj) {
        boolean z = obj == f3050e;
        com.facebook.internal.a aVar = null;
        Iterator<h<CONTENT, RESULT>.a> it = a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h<CONTENT, RESULT>.a next = it.next();
            if (z || x.b(next.c(), obj)) {
                if (next.a(content, true)) {
                    try {
                        aVar = next.b(content);
                        break;
                    } catch (FacebookException e2) {
                        aVar = e();
                        g.j(aVar, e2);
                    }
                }
            }
        }
        if (aVar == null) {
            com.facebook.internal.a e3 = e();
            g.g(e3);
            return e3;
        }
        return aVar;
    }

    public boolean b(CONTENT content) {
        return c(content, f3050e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(CONTENT content, Object obj) {
        boolean z = obj == f3050e;
        for (h<CONTENT, RESULT>.a aVar : a()) {
            if (z || x.b(aVar.c(), obj)) {
                if (aVar.a(content, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected abstract com.facebook.internal.a e();

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity f() {
        Activity activity = this.a;
        if (activity != null) {
            return activity;
        }
        n nVar = this.b;
        if (nVar != null) {
            return nVar.a();
        }
        return null;
    }

    protected abstract List<h<CONTENT, RESULT>.a> g();

    public int h() {
        return this.f3051d;
    }

    public final void i(com.facebook.d dVar, com.facebook.e<RESULT> eVar) {
        if (dVar instanceof CallbackManagerImpl) {
            j((CallbackManagerImpl) dVar, eVar);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    protected abstract void j(CallbackManagerImpl callbackManagerImpl, com.facebook.e<RESULT> eVar);

    public void k(CONTENT content) {
        l(content, f3050e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(CONTENT content, Object obj) {
        com.facebook.internal.a d2 = d(content, obj);
        if (d2 != null) {
            n nVar = this.b;
            if (nVar != null) {
                g.f(d2, nVar);
                return;
            } else {
                g.e(d2, this.a);
                return;
            }
        }
        Log.e("FacebookDialog", "No code path should ever result in a null appCall");
        if (com.facebook.f.x()) {
            throw new IllegalStateException("No code path should ever result in a null appCall");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.content.Intent r3, int r4) {
        /*
            r2 = this;
            android.app.Activity r0 = r2.a
            java.lang.String r1 = "Failed to find Activity or Fragment to startActivityForResult "
            if (r0 == 0) goto La
            r0.startActivityForResult(r3, r4)
            goto L2f
        La:
            com.facebook.internal.n r0 = r2.b
            if (r0 == 0) goto L30
            android.app.Fragment r0 = r0.b()
            if (r0 == 0) goto L1e
            com.facebook.internal.n r0 = r2.b
            android.app.Fragment r0 = r0.b()
            r0.startActivityForResult(r3, r4)
            goto L2f
        L1e:
            com.facebook.internal.n r0 = r2.b
            androidx.fragment.app.Fragment r0 = r0.c()
            if (r0 == 0) goto L30
            com.facebook.internal.n r0 = r2.b
            androidx.fragment.app.Fragment r0 = r0.c()
            r0.startActivityForResult(r3, r4)
        L2f:
            r1 = 0
        L30:
            if (r1 == 0) goto L40
            com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r4 = 6
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getName()
            com.facebook.internal.r.e(r3, r4, r0, r1)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.h.m(android.content.Intent, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(n nVar, int i2) {
        y.l(nVar, "fragmentWrapper");
        this.b = nVar;
        this.a = null;
        this.f3051d = i2;
        if (nVar.a() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }
}
