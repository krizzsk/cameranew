package com.facebook.drawee.b;

import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: SettableDraweeHierarchy.java */
@ThreadSafe
/* loaded from: classes.dex */
public interface c extends b {
    void a(Throwable th);

    void b(Throwable th);

    void c(float f2, boolean z);

    void e(Drawable drawable, float f2, boolean z);

    void f(Drawable drawable);

    void reset();
}
