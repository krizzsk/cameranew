package us.pinguo.bigdata.task;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import us.pinguo.bigdata.f.f;
import us.pinguo.bigdata.task.basic.IBDTask;
/* loaded from: classes3.dex */
public class CopyLegacyFilesTask implements IBDTask {
    private final Context a;

    public CopyLegacyFilesTask(Context context) {
        this.a = context;
    }

    private void a(File file) {
        File file2 = new File(f.a(this.a));
        if (!file2.exists() && !file2.mkdirs()) {
            us.pinguo.common.log.a.g("CopyLegacyFilesTask", "create complete folder failed", new Object[0]);
        }
        try {
            file.renameTo(File.createTempFile("log_", null, file2));
        } catch (IOException e2) {
            us.pinguo.common.log.a.g("CopyLegacyFilesTask", "copy legacy file to complete folder failed", new Object[0]);
            e2.printStackTrace();
        }
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void destroy() {
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public void execute() {
        File[] listFiles;
        for (File file : new File(this.a.getFilesDir().getAbsolutePath()).listFiles()) {
            if (file.getName().endsWith(".log") && !file.getName().equals(f.c())) {
                a(file);
            }
        }
    }

    @Override // us.pinguo.bigdata.task.basic.IBDTask
    public Object getOrigin() {
        return null;
    }
}
