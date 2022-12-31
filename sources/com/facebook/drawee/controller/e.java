package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: ForwardingControllerListener.java */
@ThreadSafe
/* loaded from: classes.dex */
public class e<INFO> implements c<INFO> {
    private final List<c<? super INFO>> a = new ArrayList(2);

    private synchronized void i(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // com.facebook.drawee.controller.c
    public void a(String str, @Nullable INFO info) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                c<? super INFO> cVar = this.a.get(i2);
                if (cVar != null) {
                    cVar.a(str, info);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onIntermediateImageSet", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void b(String str, Throwable th) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                c<? super INFO> cVar = this.a.get(i2);
                if (cVar != null) {
                    cVar.b(str, th);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onFailure", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void c(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                c<? super INFO> cVar = this.a.get(i2);
                if (cVar != null) {
                    cVar.c(str);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onRelease", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void d(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                c<? super INFO> cVar = this.a.get(i2);
                if (cVar != null) {
                    cVar.d(str, info, animatable);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onFinalImageSet", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public synchronized void e(String str, Object obj) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                c<? super INFO> cVar = this.a.get(i2);
                if (cVar != null) {
                    cVar.e(str, obj);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onSubmit", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void f(String str, Throwable th) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                c<? super INFO> cVar = this.a.get(i2);
                if (cVar != null) {
                    cVar.f(str, th);
                }
            } catch (Exception e2) {
                i("InternalListener exception in onIntermediateImageFailed", e2);
            }
        }
    }

    public synchronized void g(c<? super INFO> cVar) {
        this.a.add(cVar);
    }

    public synchronized void h() {
        this.a.clear();
    }
}
