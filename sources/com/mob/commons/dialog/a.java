package com.mob.commons.dialog;

import com.mob.OperationCallback;
import com.mob.commons.MobProduct;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
/* compiled from: AuthDialogManager.java */
/* loaded from: classes2.dex */
public class a {
    private static a a;
    private MobProduct b;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(MobProduct mobProduct, InternalPolicyUi internalPolicyUi, OperationCallback<Boolean> operationCallback) {
        try {
            MobLog.getInstance().d("canIContinueBusiness()", new Object[0]);
            this.b = mobProduct;
            boolean c = com.mob.commons.a.c();
            NLog mobLog = MobLog.getInstance();
            mobLog.d("====> ppNece: " + c, new Object[0]);
            if (!c) {
                if (operationCallback != null) {
                    operationCallback.onComplete(Boolean.TRUE);
                    return;
                }
                return;
            }
            boolean d2 = com.mob.commons.a.d();
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d("====> ppGrtd: " + d2, new Object[0]);
            if (d2) {
                if (operationCallback != null) {
                    operationCallback.onComplete(Boolean.TRUE);
                }
            } else if (operationCallback != null) {
                operationCallback.onComplete(Boolean.FALSE);
            }
        } catch (Throwable th) {
            MobLog.getInstance().e(th);
            if (operationCallback != null) {
                operationCallback.onFailure(th);
            }
        }
    }
}
