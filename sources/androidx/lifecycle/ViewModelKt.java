package androidx.lifecycle;

import kotlin.jvm.internal.s;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.z0;
/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final m0 getViewModelScope(ViewModel viewModel) {
        s.h(viewModel, "<this>");
        m0 m0Var = (m0) viewModel.getTag(JOB_KEY);
        if (m0Var != null) {
            return m0Var;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(s2.b(null, 1, null).plus(z0.c().z())));
        s.g(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (m0) tagIfAbsent;
    }
}
