package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.sequences.i;
import kotlin.u;
/* compiled from: ViewGroup.kt */
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        s.h(viewGroup, "<this>");
        s.h(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, l<? super View, u> action) {
        s.h(viewGroup, "<this>");
        s.h(action, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            s.g(childAt, "getChildAt(index)");
            action.invoke(childAt);
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, p<? super Integer, ? super View, u> action) {
        s.h(viewGroup, "<this>");
        s.h(action, "action");
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            Integer valueOf = Integer.valueOf(i2);
            View childAt = viewGroup.getChildAt(i2);
            s.g(childAt, "getChildAt(index)");
            action.invoke(valueOf, childAt);
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    public static final View get(ViewGroup viewGroup, int i2) {
        s.h(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
    }

    public static final kotlin.sequences.e<View> getChildren(final ViewGroup viewGroup) {
        s.h(viewGroup, "<this>");
        return new kotlin.sequences.e<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // kotlin.sequences.e
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final kotlin.sequences.e<View> getDescendants(ViewGroup viewGroup) {
        kotlin.sequences.e<View> b;
        s.h(viewGroup, "<this>");
        b = i.b(new ViewGroupKt$descendants$1(viewGroup, null));
        return b;
    }

    public static final int getSize(ViewGroup viewGroup) {
        s.h(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        s.h(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        s.h(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        s.h(viewGroup, "<this>");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        s.h(viewGroup, "<this>");
        s.h(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        s.h(viewGroup, "<this>");
        s.h(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        s.h(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        s.h(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        s.h(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        s.h(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        s.h(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
