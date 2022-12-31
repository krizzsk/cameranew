package us.pinguo.inspire.widget.fresco;

import android.graphics.drawable.Animatable;
import androidx.annotation.Nullable;
/* compiled from: DeliveryControllerListener.java */
/* loaded from: classes9.dex */
public class d<INFO> implements com.facebook.drawee.controller.c<INFO> {
    private com.facebook.drawee.controller.c<INFO> a;

    public d(com.facebook.drawee.controller.c<INFO> cVar) {
        this.a = cVar;
    }

    @Override // com.facebook.drawee.controller.c
    public void a(String str, @Nullable INFO info) {
        com.facebook.drawee.controller.c<INFO> cVar = this.a;
        if (cVar != null) {
            cVar.a(str, info);
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void b(String str, Throwable th) {
        com.facebook.drawee.controller.c<INFO> cVar = this.a;
        if (cVar != null) {
            cVar.b(str, th);
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void c(String str) {
        com.facebook.drawee.controller.c<INFO> cVar = this.a;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void d(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        com.facebook.drawee.controller.c<INFO> cVar = this.a;
        if (cVar != null) {
            cVar.d(str, info, animatable);
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void e(String str, Object obj) {
        com.facebook.drawee.controller.c<INFO> cVar = this.a;
        if (cVar != null) {
            cVar.e(str, obj);
        }
    }

    @Override // com.facebook.drawee.controller.c
    public void f(String str, Throwable th) {
        com.facebook.drawee.controller.c<INFO> cVar = this.a;
        if (cVar != null) {
            cVar.f(str, th);
        }
    }
}
