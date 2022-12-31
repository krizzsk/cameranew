package bolts;

import bolts.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnobservedErrorNotifier.java */
/* loaded from: classes.dex */
public class g {
    private e<?> a;

    public g(e<?> eVar) {
        this.a = eVar;
    }

    public void a() {
        this.a = null;
    }

    protected void finalize() throws Throwable {
        e.d k2;
        try {
            e<?> eVar = this.a;
            if (eVar != null && (k2 = e.k()) != null) {
                k2.a(eVar, new UnobservedTaskException(eVar.i()));
            }
        } finally {
            super.finalize();
        }
    }
}
