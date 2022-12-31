package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.c;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes2.dex */
public class FakeReviewManager implements c {
    private final Context a;
    private ReviewInfo b;

    public FakeReviewManager(Context context) {
        this.a = context;
    }

    @Override // com.google.android.play.core.review.c
    @NonNull
    public d<ReviewInfo> a() {
        Context context = this.a;
        Intent intent = new Intent();
        VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent, 0);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent, 0, broadcast);
        ReviewInfo b = ReviewInfo.b(broadcast);
        this.b = b;
        return f.b(b);
    }

    @Override // com.google.android.play.core.review.c
    @NonNull
    public d<Void> b(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        return reviewInfo != this.b ? f.a(new a()) : f.b(null);
    }
}
