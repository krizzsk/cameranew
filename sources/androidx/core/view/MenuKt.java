package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem item) {
        s.h(menu, "<this>");
        s.h(item, "item");
        int size = menu.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (s.c(menu.getItem(i2), item)) {
                    return true;
                }
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, l<? super MenuItem, u> action) {
        s.h(menu, "<this>");
        s.h(action, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            MenuItem item = menu.getItem(i2);
            s.g(item, "getItem(index)");
            action.invoke(item);
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final void forEachIndexed(Menu menu, p<? super Integer, ? super MenuItem, u> action) {
        s.h(menu, "<this>");
        s.h(action, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            Integer valueOf = Integer.valueOf(i2);
            MenuItem item = menu.getItem(i2);
            s.g(item, "getItem(index)");
            action.invoke(valueOf, item);
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }

    public static final MenuItem get(Menu menu, int i2) {
        s.h(menu, "<this>");
        MenuItem item = menu.getItem(i2);
        s.g(item, "getItem(index)");
        return item;
    }

    public static final kotlin.sequences.e<MenuItem> getChildren(final Menu menu) {
        s.h(menu, "<this>");
        return new kotlin.sequences.e<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.e
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        s.h(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        s.h(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        s.h(menu, "<this>");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        s.h(menu, "<this>");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem item) {
        s.h(menu, "<this>");
        s.h(item, "item");
        menu.removeItem(item.getItemId());
    }
}
