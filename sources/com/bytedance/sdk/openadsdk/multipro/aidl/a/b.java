package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;
/* compiled from: CommonDialogListenerManagerImpl.java */
/* loaded from: classes.dex */
public class b extends a {
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> a = new HashMap<>();
    private static volatile b b;

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastDialogListener(String str, int i2) throws RemoteException {
        RemoteCallbackList<ICommonDialogListener> remove = a.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i3 = 0; i3 < beginBroadcast; i3++) {
            ICommonDialogListener broadcastItem = remove.getBroadcastItem(i3);
            if (broadcastItem != null) {
                if (i2 == 1) {
                    broadcastItem.onDialogBtnYes();
                } else if (i2 == 2) {
                    broadcastItem.onDialogBtnNo();
                } else if (i2 != 3) {
                    broadcastItem.onDialogCancel();
                } else {
                    broadcastItem.onDialogCancel();
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
        if (iCommonDialogListener == null) {
            return;
        }
        RemoteCallbackList<ICommonDialogListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonDialogListener);
        a.put(str, remoteCallbackList);
    }
}
