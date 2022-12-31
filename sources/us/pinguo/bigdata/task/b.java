package us.pinguo.bigdata.task;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import us.pinguo.bigdata.config.BDConfigManager;
import us.pinguo.bigdata.f.f;
import us.pinguo.bigdata.network.model.BDNetworkResult;
import us.pinguo.bigdata.task.basic.IBDTask;
/* compiled from: UploadFileTask.java */
/* loaded from: classes3.dex */
public class b implements IBDTask {
    private int a = 0;
    private boolean b = false;

    private void a(List<String> list) throws FileNotFoundException {
        us.pinguo.common.log.a.d("uploadtask", "---------> doRequest", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        Vector vector = new Vector();
        for (String str : list) {
            vector.add(new FileInputStream(new File(str)));
        }
        SequenceInputStream sequenceInputStream = new SequenceInputStream(vector.elements());
        BDNetworkResult h2 = us.pinguo.bigdata.d.a.g().h(us.pinguo.bigdata.f.a.H(us.pinguo.bigdata.a.a), sequenceInputStream);
        if (h2 != null) {
            if (h2.isSuccess()) {
                us.pinguo.common.log.a.d("uploadtask", "--------------->use time: " + String.valueOf(System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                for (String str2 : list) {
                    us.pinguo.common.log.a.m("uploadtask", "upload file success " + str2, new Object[0]);
                    new File(str2).delete();
                }
                b(true);
                return;
            }
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 < 3) {
                b(true);
            }
            us.pinguo.common.log.a.g("uploadtask", "updload file error code: " + h2.getErrorCode() + " " + h2.getErrorMsg(), new Object[0]);
            return;
        }
        int i3 = this.a + 1;
        this.a = i3;
        if (i3 < 3) {
            b(true);
        }
    }

    private synchronized void b(boolean z) {
        String a;
        if (c(us.pinguo.bigdata.a.a)) {
            try {
                a = f.a(us.pinguo.bigdata.a.a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (a == null) {
                return;
            }
            List<String> a2 = us.pinguo.bigdata.f.d.a(a, "tmp", false);
            if (a2 != null && a2.size() >= 1) {
                List<String> e3 = e(a2);
                if (e3.isEmpty()) {
                    return;
                }
                us.pinguo.common.log.a.m("uploadtask", "batchList:" + e3, new Object[0]);
                a(e3);
            }
        }
    }

    private static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) ? false : true;
    }

    private List<String> e(List<String> list) {
        long num = BDConfigManager.instance().getServerConfig().getNum() * 1024.0f * 3;
        if (num < 30720) {
            num = 30720;
        } else if (num >= 512000) {
            num = 512000;
        }
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        int i2 = 0;
        for (String str : list) {
            File file = new File(str);
            long length = file.length();
            if (length == 0) {
                file.delete();
            } else {
                j2 += length;
                i2++;
                arrayList.add(str);
                if (j2 >= num || i2 >= 10) {
                    break;
                }
            }
        }
        us.pinguo.common.log.a.g("uploadtask", "sum:" + j2, new Object[0]);
        return j2 < 200 ? new ArrayList() : arrayList;
    }

    public void d(boolean z) {
        this.b = z;
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void destroy() {
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void execute() {
        if (us.pinguo.bigdata.a.a == null) {
            return;
        }
        us.pinguo.common.log.a.d("uploadtask", "mIsBatchUpload: " + this.b, new Object[0]);
        us.pinguo.common.log.a.m("uploadtask", "UploadFileTask start", new Object[0]);
        b(this.b);
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public Object getOrigin() {
        return null;
    }
}
