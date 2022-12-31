package us.pinguo.bigdata.task;

import android.app.Application;
import us.pinguo.bigdata.config.BDConfigManager;
import us.pinguo.bigdata.network.model.BDNetworkResult;
import us.pinguo.bigdata.task.basic.IBDTask;
/* compiled from: UploadInitTask.java */
/* loaded from: classes3.dex */
public class c implements IBDTask {
    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void destroy() {
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void execute() {
        try {
            Application application = us.pinguo.bigdata.a.a;
            if (application == null) {
                return;
            }
            String z = us.pinguo.bigdata.f.a.z(application);
            BDConfigManager.instance().updateLocalConfig();
            BDNetworkResult c = us.pinguo.bigdata.d.a.g().c(z);
            if (c != null) {
                if (c.isSuccess()) {
                    us.pinguo.common.log.a.d("bdsdk2", "update init post success", new Object[0]);
                } else {
                    us.pinguo.common.log.a.d("bdsdk2", "update init post error msg: " + c.getErrorCode() + " " + c.getErrorMsg(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.g("bdsdk2", "bdPushInit e: " + e2, new Object[0]);
            e2.printStackTrace();
        }
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public Object getOrigin() {
        return null;
    }
}
