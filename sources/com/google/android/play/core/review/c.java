package com.google.android.play.core.review;

import android.app.Activity;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public interface c {
    @NonNull
    com.google.android.play.core.tasks.d<ReviewInfo> a();

    @NonNull
    com.google.android.play.core.tasks.d<Void> b(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo);
}
