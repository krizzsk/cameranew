package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: assets/audience_network.dex */
public class OR extends AnimatorListenerAdapter {
    public static String[] A02 = {"R9x3aA0CxKnsz3as3yTNo", "wj3", "QXJ1VvuxLHED1mtMWLYdqrUglWa9lzRq", "lkNOeAB6Ljcfoc1GYo9neKrfDLaf7fDy", "DjE9g1oV3RhQW9", "kuoJdNjNcIUcz8fbOu7oHrt", "PXWkVVH6OcZLxwrP3oXHVUdgM2dUbdjZ", "8PrLrYluZp2AIaWhf9UgS"};
    public final /* synthetic */ SK A00;
    public final /* synthetic */ boolean A01;

    public OR(SK sk, boolean z) {
        this.A00 = sk;
        this.A01 = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        OU ou;
        C1175Sm c1175Sm;
        C1175Sm c1175Sm2;
        super.onAnimationEnd(animator);
        ou = this.A00.A0F;
        ou.setTranslationY(0.0f);
        this.A00.A0H();
        if (this.A01) {
            return;
        }
        c1175Sm = this.A00.A0D;
        if (c1175Sm != null) {
            SK sk = this.A00;
            String[] strArr = A02;
            if (strArr[2].charAt(23) != strArr[6].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "czZD1KZ4paLzcRsa7FTotpjgHmPZqDaL";
            strArr2[6] = "ekjCDFK0XFV5sAsD0BjD76lgNibQF4SI";
            c1175Sm2 = sk.A0D;
            c1175Sm2.destroy();
        }
    }
}
