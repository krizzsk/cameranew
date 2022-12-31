package us.pinguo.bigdata.task;

import android.app.Application;
import com.google.gson.e;
import us.pinguo.bigdata.config.BDConfigManager;
import us.pinguo.bigdata.config.BDServerConfig;
import us.pinguo.bigdata.config.BDServerData;
import us.pinguo.bigdata.network.model.BDNetworkResult;
import us.pinguo.bigdata.task.basic.IBDTask;
/* compiled from: UpdateConfigTask.java */
/* loaded from: classes3.dex */
public class a implements IBDTask {
    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void destroy() {
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void execute() {
        BDServerConfig bDServerConfig;
        Application application = us.pinguo.bigdata.a.a;
        if (application == null) {
            return;
        }
        String P = us.pinguo.bigdata.f.a.P(application);
        BDConfigManager.instance().updateLocalConfig();
        BDNetworkResult c = us.pinguo.bigdata.d.a.g().c(P);
        if (c != null) {
            if (c.isSuccess()) {
                String result = c.getResult();
                if (result == null) {
                    return;
                }
                try {
                    us.pinguo.common.log.a.d("bdsdk2", "update config success resp: " + result, new Object[0]);
                    BDServerData bDServerData = (BDServerData) new e().j(result, BDServerData.class);
                    if (bDServerData == null || bDServerData.status != 200 || (bDServerConfig = bDServerData.data) == null) {
                        return;
                    }
                    BDConfigManager.instance().updateServerConfig(bDServerConfig);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            us.pinguo.common.log.a.g("bdsdk2", "update config error code: " + c.getErrorCode() + " " + c.getErrorMsg(), new Object[0]);
        }
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public Object getOrigin() {
        return null;
    }
}
