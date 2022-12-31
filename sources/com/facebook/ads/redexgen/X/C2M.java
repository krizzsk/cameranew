package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.2M  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2M {
    public static C2M A05;
    public static byte[] A06;
    public static String[] A07 = {"JAgQ2spdQpH8xKgxtQcQLLz6sgGCkpe2", "SMfU9IuS4ycu6Y2ZHRBSqn3aWPXKMTOT", "55l84Ag1V6wgeVOPN73gijnv7nIwTIEx", "eOq258YlCb1TEbA", "VJMc46I8NXWnx7x8GW3WGk3ASQlYYFHT", "LoC5Exa7K60en74lmCNTJxDot4v0o8bM", "KRpLxkqJYlgWqGJZ48eoA1wpDd5KWG89", "Gt8Vn0C4eF81I9TsnyjdaH21jMiVX3Ky"};
    public static final Object A08;
    public final Context A00;
    public final Handler A01;
    public final HashMap<BroadcastReceiver, ArrayList<C2L>> A04 = new HashMap<>();
    public final HashMap<String, ArrayList<C2L>> A03 = new HashMap<>();
    public final ArrayList<C2K> A02 = new ArrayList<>();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 80);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{-116, -116, -78, -43, -40, -32, -47, -34, -116, -48, -43, -48, -116, -38, -37, -32, -116, -39, -51, -32, -49, -44, -90, -116, -111, -111, -73, -38, -35, -27, -42, -29, -111, -34, -46, -27, -44, -39, -42, -43, -110, -111, -111, -34, -46, -27, -44, -39, -82, -95, -23, -102, -23, -32, -102, -29, -24, -18, -33, -24, -18, -102, 126, -47, -63, -58, -61, -53, -61, 126, -88, -54, -37, -48, -42, -43, -121, -45, -48, -38, -37, -95, -121, 27, 62, 50, 48, 59, 17, 65, 62, 48, 51, 50, 48, 66, 67, 28, 48, 61, 48, 54, 52, 65, -51, -31, -12, -29, -24, -23, -18, -25, -96, -31, -25, -31, -23, -18, -13, -12, -96, -26, -23, -20, -12, -27, -14, -96, -80, -61, -47, -51, -54, -44, -57, -52, -59, 126, -46, -41, -50, -61, 126, -19, -17, 0, -11, -5, -6, -3, -5, 14, -1, 1, 9, 12, 19, 9, 6, 25, 6, 29, 34, 25, 14, -53, -60, -63, -60, -59, -51, -60, 118, -56, -69, -73, -55, -59, -60};
    }

    static {
        A03();
        A08 = new Object();
    }

    public C2M(Context context) {
        this.A00 = context;
        final Looper mainLooper = context.getMainLooper();
        this.A01 = new Handler(mainLooper) { // from class: com.facebook.ads.redexgen.X.2J
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    C2M.this.A02();
                }
            }
        };
    }

    public static C2M A00(Context context) {
        C2M c2m;
        synchronized (A08) {
            if (A05 == null) {
                A05 = new C2M(context.getApplicationContext());
            }
            c2m = A05;
        }
        return c2m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C2K[] c2kArr;
        while (true) {
            synchronized (this.A04) {
                int size = this.A02.size();
                if (size > 0) {
                    c2kArr = new C2K[size];
                    this.A02.toArray(c2kArr);
                    this.A02.clear();
                } else {
                    return;
                }
            }
            for (C2K c2k : c2kArr) {
                int size2 = c2k.A01.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    C2L c2l = c2k.A01.get(i2);
                    if (!c2l.A01) {
                        c2l.A02.onReceive(this.A00, c2k.A00);
                    }
                }
            }
        }
    }

    public final void A05(BroadcastReceiver broadcastReceiver) {
        synchronized (this.A04) {
            ArrayList<C2L> remove = this.A04.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                C2L c2l = remove.get(size);
                c2l.A01 = true;
                for (int i2 = 0; i2 < c2l.A03.countActions(); i2++) {
                    String action = c2l.A03.getAction(i2);
                    ArrayList<C2L> arrayList = this.A03.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C2L c2l2 = arrayList.get(size2);
                            if (c2l2.A02 == broadcastReceiver) {
                                c2l2.A01 = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.A03.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final void A06(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            C2L c2l = new C2L(intentFilter, broadcastReceiver);
            ArrayList<C2L> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c2l);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<C2L> arrayList2 = this.A03.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.A03.put(action, arrayList2);
                }
                arrayList2.add(c2l);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0146, code lost:
        if (r10 != (-2)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0149, code lost:
        if (r10 == (-1)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0158, code lost:
        if (r10 != (-2)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015b, code lost:
        r11 = A01(161, 4, 89);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0165, code lost:
        r11 = A01(157, 4, 85);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0184, code lost:
        r11 = A01(165, 14, 6);
     */
    /* JADX WARN: Incorrect condition in loop: B:64:0x01b9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A07(android.content.Intent r23) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2M.A07(android.content.Intent):boolean");
    }
}
