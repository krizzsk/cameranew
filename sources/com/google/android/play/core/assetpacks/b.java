package com.google.android.play.core.assetpacks;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes2.dex */
public interface b {
    void a(@NonNull d dVar);

    com.google.android.play.core.tasks.d<Integer> b(@NonNull Activity activity);

    com.google.android.play.core.tasks.d<e> c(List<String> list);

    @Nullable
    a d(@NonNull String str);

    void e(@NonNull d dVar);

    com.google.android.play.core.tasks.d<Void> f(@NonNull String str);

    e g(@NonNull List<String> list);

    com.google.android.play.core.tasks.d<e> h(List<String> list);
}
