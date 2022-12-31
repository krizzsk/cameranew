package androidx.fragment.app;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: FragmentManager.kt */
/* loaded from: classes.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z, l<? super FragmentTransaction, u> body) {
        s.h(fragmentManager, "<this>");
        s.h(body, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z, l body, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        s.h(fragmentManager, "<this>");
        s.h(body, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z, l<? super FragmentTransaction, u> body) {
        s.h(fragmentManager, "<this>");
        s.h(body, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z, l body, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        s.h(fragmentManager, "<this>");
        s.h(body, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z, boolean z2, l<? super FragmentTransaction, u> body) {
        s.h(fragmentManager, "<this>");
        s.h(body, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            if (z2) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z, boolean z2, l body, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        s.h(fragmentManager, "<this>");
        s.h(body, "body");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        s.g(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            if (z2) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
