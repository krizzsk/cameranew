package androidx.fragment.app;

import android.os.Bundle;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Fragment.kt */
/* loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String requestKey) {
        s.h(fragment, "<this>");
        s.h(requestKey, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String requestKey) {
        s.h(fragment, "<this>");
        s.h(requestKey, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(Fragment fragment, String requestKey, Bundle result) {
        s.h(fragment, "<this>");
        s.h(requestKey, "requestKey");
        s.h(result, "result");
        fragment.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(Fragment fragment, String requestKey, final p<? super String, ? super Bundle, u> listener) {
        s.h(fragment, "<this>");
        s.h(requestKey, "requestKey");
        s.h(listener, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(requestKey, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.c
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                FragmentKt.m9setFragmentResultListener$lambda0(p.this, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setFragmentResultListener$lambda-0  reason: not valid java name */
    public static final void m9setFragmentResultListener$lambda0(p tmp0, String p0, Bundle p1) {
        s.h(tmp0, "$tmp0");
        s.h(p0, "p0");
        s.h(p1, "p1");
        tmp0.invoke(p0, p1);
    }
}
