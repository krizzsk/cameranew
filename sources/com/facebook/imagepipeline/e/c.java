package com.facebook.imagepipeline.e;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: ForwardingRequestListener.java */
/* loaded from: classes.dex */
public class c implements e {
    private final List<e> a;

    public c(Set<e> set) {
        this.a = new ArrayList(set.size());
        for (e eVar : set) {
            if (eVar != null) {
                this.a.add(eVar);
            }
        }
    }

    private void m(String str, Throwable th) {
        com.facebook.common.logging.a.i("ForwardingRequestListener", str, th);
    }

    @Override // com.facebook.imagepipeline.e.e
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).a(imageRequest, obj, str, z);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public void b(String str, String str2) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).b(str, str2);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.e.e
    public void c(ImageRequest imageRequest, String str, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).c(imageRequest, str, z);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public boolean d(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.a.get(i2).d(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public void e(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).e(str, str2, map);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public void f(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).f(str, str2, th, map);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public void g(String str, String str2, @Nullable Map<String, String> map) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).g(str, str2, map);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public void h(String str, String str2, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).h(str, str2, z);
            } catch (Exception e2) {
                m("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.e.e
    public void i(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).i(imageRequest, str, th, z);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.r0
    public void j(String str, String str2, String str3) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).j(str, str2, str3);
            } catch (Exception e2) {
                m("InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.e.e
    public void k(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.a.get(i2).k(str);
            } catch (Exception e2) {
                m("InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    public void l(e eVar) {
        this.a.add(eVar);
    }

    public c(e... eVarArr) {
        this.a = new ArrayList(eVarArr.length);
        for (e eVar : eVarArr) {
            if (eVar != null) {
                this.a.add(eVar);
            }
        }
    }
}
