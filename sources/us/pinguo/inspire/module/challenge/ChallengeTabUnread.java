package us.pinguo.inspire.module.challenge;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireTaskBulkLoader;
/* compiled from: ChallengeTabUnread.kt */
/* loaded from: classes9.dex */
public final class ChallengeTabUnread {
    public static final ChallengeTabUnread INSTANCE = new ChallengeTabUnread();
    private static OnNewTaskListener listener;

    /* compiled from: ChallengeTabUnread.kt */
    /* loaded from: classes9.dex */
    public interface OnNewTaskListener {
        void onNewTask();
    }

    private ChallengeTabUnread() {
    }

    public final void checkNew(InspireTaskBulkLoader.TaskListResp resp) {
        OnNewTaskListener onNewTaskListener;
        s.h(resp, "resp");
        List<InspireTask> list = resp.items;
        if (list == null || list.size() == 0) {
            return;
        }
        SharedPreferences c = Inspire.c();
        String string = c.getString("new_task_id", "");
        String str = resp.items.get(0).taskId;
        us.pinguo.common.log.a.k("preTaskId:" + ((Object) string) + " curTaskId:" + ((Object) str), new Object[0]);
        if (!TextUtils.isEmpty(string) && !f0.b(string, str)) {
            int i2 = c.getInt("new_task_unread", 0);
            us.pinguo.common.log.a.k(s.q("taskUnRead:", Integer.valueOf(i2)), new Object[0]);
            c.edit().putInt("new_task_unread", i2 < 3 ? i2 + 1 : 3).apply();
            if (i2 > 0 && (onNewTaskListener = listener) != null) {
                onNewTaskListener.onNewTask();
            }
        }
        c.edit().putString("new_task_id", str).apply();
    }

    public final void clearUnread() {
        Inspire.c().edit().putInt("new_task_unread", 0).apply();
    }

    public final OnNewTaskListener getListener() {
        return listener;
    }

    public final int getUnread() {
        return Inspire.c().getInt("new_task_unread", 0);
    }

    public final void setListener(OnNewTaskListener onNewTaskListener) {
        listener = onNewTaskListener;
    }

    public final void setOnNewTaskListener(OnNewTaskListener onNewTaskListener) {
        listener = onNewTaskListener;
    }
}
