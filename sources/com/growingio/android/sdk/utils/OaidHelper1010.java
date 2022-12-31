package com.growingio.android.sdk.utils;

import android.content.Context;
import android.util.Log;
import androidx.work.WorkRequest;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.supplier.IdSupplier;
/* loaded from: classes2.dex */
public class OaidHelper1010 implements IIdentifierListener {
    private static final String TAG = "GIO.oaid";
    private volatile boolean complete = false;
    private String oaid;

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        if (z && idSupplier != null) {
            try {
                this.oaid = idSupplier.getOAID();
            } catch (Throwable th) {
                Log.e(TAG, "getOAID failed: ", th);
            }
        }
        synchronized (this) {
            this.complete = true;
            notifyAll();
        }
    }

    public String getOaid(Context context) {
        try {
            int InitSdk = MdidSdkHelper.InitSdk(context, true, (IIdentifierListener) this);
            switch (InitSdk) {
                case 1008611:
                case 1008612:
                case 1008613:
                case 1008615:
                    Log.e(TAG, "MdidSdkHelper.InitSdk failed, and returnCode: " + InitSdk);
                    return null;
                case 1008614:
                default:
                    if (this.complete) {
                        return this.oaid;
                    }
                    synchronized (this) {
                        if (this.complete) {
                            return this.oaid;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        while (!this.complete) {
                            try {
                                wait(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            if (!this.complete && System.currentTimeMillis() - currentTimeMillis > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                                return this.oaid;
                            }
                        }
                        return this.oaid;
                    }
            }
        } catch (Throwable th) {
            Log.e(TAG, "InitSdkError: ", th);
            return null;
        }
    }
}
