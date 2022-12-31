package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.animation.g;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionStrategy.java */
/* loaded from: classes2.dex */
public interface f {
    void a();

    void b();

    boolean c();

    void d();

    @AnimatorRes
    int e();

    void f(@Nullable g gVar);

    AnimatorSet g();

    List<Animator.AnimatorListener> h();

    void i(@Nullable ExtendedFloatingActionButton.j jVar);

    void onAnimationStart(Animator animator);
}
