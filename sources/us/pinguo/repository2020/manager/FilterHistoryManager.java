package us.pinguo.repository2020.manager;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.repository2020.entity.FilterEntry;
/* compiled from: FilterHistoryManager.kt */
/* loaded from: classes6.dex */
public final class FilterHistoryManager {
    public static final FilterHistoryManager a = new FilterHistoryManager();

    private FilterHistoryManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str) {
        if (s.c(str, "history_position_edit")) {
            Object obj = SPUtils.get(us.pinguo.foundation.e.b(), "edit_first_time", 0L);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
            if (((Long) obj).longValue() == 0) {
                SPUtils.put(us.pinguo.foundation.e.b(), "edit_first_time", Long.valueOf(System.currentTimeMillis()));
            }
            SPUtils.put(us.pinguo.foundation.e.b(), "edit_last_time", Long.valueOf(System.currentTimeMillis()));
        } else if (s.c(str, "history_position_camera")) {
            Object obj2 = SPUtils.get(us.pinguo.foundation.e.b(), "camera_first_time", 0L);
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            if (((Long) obj2).longValue() == 0) {
                SPUtils.put(us.pinguo.foundation.e.b(), "camera_first_time", Long.valueOf(System.currentTimeMillis()));
            }
            SPUtils.put(us.pinguo.foundation.e.b(), "camera_last_time", Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String str, FilterEntry filterEntry) {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterHistoryManager$updateDB$1(str, filterEntry, null), 3, null);
    }

    public final void c(String position, List<FilterEntry> filterEntry) {
        s.h(position, "position");
        s.h(filterEntry, "filterEntry");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterHistoryManager$addRecord$2(filterEntry, position, null), 3, null);
    }

    public final void d(String position, FilterEntry filterEntry) {
        s.h(position, "position");
        s.h(filterEntry, "filterEntry");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new FilterHistoryManager$addRecord$1(position, filterEntry, null), 3, null);
    }
}
