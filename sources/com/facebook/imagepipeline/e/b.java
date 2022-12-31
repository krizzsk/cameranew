package com.facebook.imagepipeline.e;

import com.facebook.imagepipeline.producers.o0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: ForwardingRequestListener2.java */
/* loaded from: classes.dex */
public class b implements d {
    private final List<d> a;

    public b(Set<d> set) {
        this.a = new ArrayList(set.size());
        for (d dVar : set) {
            if (dVar != null) {
                this.a.add(dVar);
            }
        }
    }

    private void l(String str, Throwable th) {
        com.facebook.common.logging.a.i("ForwardingRequestListener2", str, th);
    }

    @Override // com.facebook.imagepipeline.e.d
    public void a(o0 o0Var) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).a(o0Var);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void b(o0 o0Var, String str, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).b(o0Var, str, z);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void c(o0 o0Var, String str, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).c(o0Var, str, map);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void d(o0 o0Var, String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).d(o0Var, str);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.e.d
    public void e(o0 o0Var) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).e(o0Var);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public boolean f(o0 o0Var, String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.a.get(i2).f(o0Var, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.e.d
    public void g(o0 o0Var) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).g(o0Var);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void h(o0 o0Var, String str, String str2) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).h(o0Var, str, str2);
            } catch (Exception e2) {
                l("InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.e.d
    public void i(o0 o0Var, Throwable th) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).i(o0Var, th);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void j(o0 o0Var, String str, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).j(o0Var, str, map);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.q0
    public void k(o0 o0Var, String str, Throwable th, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).k(o0Var, str, th, map);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }
}
