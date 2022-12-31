package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.p;
/* loaded from: classes2.dex */
public final class e implements c {
    private final h a;
    private final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar) {
        this.a = hVar;
    }

    @Override // com.google.android.play.core.review.c
    @NonNull
    public final com.google.android.play.core.tasks.d<ReviewInfo> a() {
        return this.a.a();
    }

    @Override // com.google.android.play.core.review.c
    @NonNull
    public final com.google.android.play.core.tasks.d<Void> b(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.a());
        p pVar = new p();
        intent.putExtra("result_receiver", new b(this.b, pVar));
        activity.startActivity(intent);
        return pVar.a();
    }
}
