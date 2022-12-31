package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.p;
/* loaded from: classes2.dex */
public final class h {
    private static final com.google.android.play.core.internal.j c = new com.google.android.play.core.internal.j("ReviewService");
    final t<com.google.android.play.core.internal.c> a;
    private final String b;

    public h(Context context) {
        this.b = context.getPackageName();
        this.a = new t<>(context, c, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), f.a);
    }

    public final com.google.android.play.core.tasks.d<ReviewInfo> a() {
        c.f("requestInAppReview (%s)", this.b);
        p pVar = new p();
        this.a.c(new g(this, pVar, pVar));
        return pVar.a();
    }
}
