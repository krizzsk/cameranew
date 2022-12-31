package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public interface DateSelector<S> extends Parcelable {
    @NonNull
    Collection<Long> A();

    @Nullable
    S N();

    void O(long j2);

    @StyleRes
    int d(Context context);

    @NonNull
    String e(Context context);

    @NonNull
    Collection<Pair<Long, Long>> v();

    @NonNull
    View w(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull i<S> iVar);

    boolean z();
}
