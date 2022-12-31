package us.pinguo.foundation;

import android.app.Activity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
/* compiled from: CriticalStepRecorder.java */
/* loaded from: classes4.dex */
public class c {
    private static final Queue<String> a = new ArrayDeque();
    private static final Queue<String> b = new ArrayDeque();
    private static final Queue<String> c = new ArrayDeque();

    public static synchronized Map<String, String> a() {
        LinkedHashMap linkedHashMap;
        synchronized (c.class) {
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("Page", b(a));
            linkedHashMap.put("Process", b(c));
            linkedHashMap.put(TypedValues.MotionType.NAME, b(b));
            linkedHashMap.put("End", "T:" + (System.currentTimeMillis() % 1000000));
        }
        return linkedHashMap;
    }

    private static synchronized String b(Queue<String> queue) {
        synchronized (c.class) {
            try {
                if (queue.size() == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (String str : queue) {
                    sb.append(str);
                    sb.append("->");
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static synchronized void c(String str) {
        synchronized (c.class) {
            try {
                Queue<String> queue = b;
                if (queue.size() == 30) {
                    us.pinguo.common.log.a.c("poll:" + queue.poll(), new Object[0]);
                }
                String str2 = str + ":" + (System.currentTimeMillis() % 1000000);
                us.pinguo.common.log.a.c("motionStep:" + str2, new Object[0]);
                queue.offer(str2);
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void d(Activity activity, String str) {
        synchronized (c.class) {
            try {
                Queue<String> queue = a;
                if (queue.size() == 30) {
                    us.pinguo.common.log.a.c("poll:" + queue.poll(), new Object[0]);
                }
                String str2 = activity.getClass().getSimpleName().substring(0, 2) + ":" + str.substring(0, 2) + ":" + (System.currentTimeMillis() % 1000000);
                us.pinguo.common.log.a.c("pageStep:" + str2, new Object[0]);
                queue.offer(str2);
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void e(String str) {
        Queue<String> queue;
        synchronized (c.class) {
            try {
                if (b.size() == 30) {
                    us.pinguo.common.log.a.c("poll:" + queue.poll(), new Object[0]);
                }
                String str2 = str + ":" + (System.currentTimeMillis() % 1000000);
                us.pinguo.common.log.a.c("processStep:" + str2, new Object[0]);
                c.offer(str2);
            } catch (Exception unused) {
            }
        }
    }
}
