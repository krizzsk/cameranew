package com.facebook.drawee.b;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: DraweeController.java */
@ThreadSafe
/* loaded from: classes.dex */
public interface a {
    void a();

    void b(@Nullable b bVar);

    void c();

    @Nullable
    b d();

    Animatable e();

    boolean onTouchEvent(MotionEvent motionEvent);
}
