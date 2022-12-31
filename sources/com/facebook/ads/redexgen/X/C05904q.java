package com.facebook.ads.redexgen.X;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* renamed from: com.facebook.ads.redexgen.X.4q  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05904q {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 3);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{Draft_75.CR, 72, 85, 89, 39, 107, 108, 123, 108, 106, 123, 108, 107, 65, -43, -31, -33, -96, -40, -45, -43, -41, -44, -31, -31, -35, -96, -45, -42, -27};
    }

    @Nullable
    private String A00() {
        StackTraceElement[] stackTrace;
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            if (stackTraceElement.getClassName().startsWith(A01(14, 16, 111))) {
                return stackTraceElement.toString();
            }
        }
        return null;
    }

    private Map<Thread, StackTraceElement[]> A02() {
        final Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() { // from class: com.facebook.ads.redexgen.X.4p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00 */
            public final int compare(Thread thread2, Thread thread3) {
                if (thread2 == thread3) {
                    return 0;
                }
                Thread thread4 = thread;
                if (thread2 == thread4) {
                    return -1;
                }
                if (thread3 == thread4) {
                    return 1;
                }
                return thread3.getName().compareTo(thread2.getName());
            }
        });
        Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
        treeMap.putAll(stackTraces);
        return treeMap;
    }

    public final String A04() {
        StackTraceElement[] value;
        StringBuilder sb = new StringBuilder();
        sb.append(A01(1, 13, 4));
        sb.append(A00());
        String A01 = A01(0, 1, 0);
        sb.append(A01);
        for (Map.Entry<Thread, StackTraceElement[]> entry : A02().entrySet()) {
            Thread thread = entry.getKey();
            sb.append(thread.getName());
            sb.append(A01);
            for (StackTraceElement element : entry.getValue()) {
                sb.append('\t');
                sb.append(element.toString());
                sb.append(A01);
            }
        }
        return sb.toString();
    }

    public final boolean A05() {
        return A00() != null;
    }
}
