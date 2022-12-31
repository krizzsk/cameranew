package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.utils.n;
/* compiled from: MaterialDownloadManager.kt */
/* loaded from: classes6.dex */
public final class MaterialDownloadManager {
    public static final MaterialDownloadManager a = new MaterialDownloadManager();

    private MaterialDownloadManager() {
    }

    public final void a(final PaintMaterial material, final p<? super Boolean, ? super PaintMaterial, u> completeAction) {
        s.h(material, "material");
        s.h(completeAction, "completeAction");
        String down_url = material.getDown_url();
        final String pid = material.getPid();
        if (!(down_url == null || down_url.length() == 0)) {
            if (!(pid == null || pid.length() == 0)) {
                n nVar = n.a;
                String b = nVar.b(pid);
                final String f2 = nVar.f(pid);
                final IDownloadTask create = PGDownloadManger.Companion.getInstance().create(down_url, b, false, 0);
                create.setForceReDownload(true);
                us.pinguo.util.l.j(b);
                create.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.MaterialDownloadManager$downloadMaterialAsync$1
                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onComplete(IDownloadTask task) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        String path = IDownloadTask.this.getPath();
                        if (path != null) {
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new MaterialDownloadManager$downloadMaterialAsync$1$onComplete$1(f2, path, completeAction, material, null), 3, null);
                            return;
                        }
                        PaintMaterial paintMaterial = MaterialDataManager.a.e().get(pid);
                        if (paintMaterial != null && (installState = paintMaterial.getInstallState()) != null) {
                            installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                        }
                        completeAction.invoke(Boolean.FALSE, material);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onError(IDownloadTask task, int i2) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        PaintMaterial paintMaterial = MaterialDataManager.a.e().get(pid);
                        if (paintMaterial == null || (installState = paintMaterial.getInstallState()) == null) {
                            return;
                        }
                        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onPause(IDownloadTask task) {
                        s.h(task, "task");
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
                        ObservableInt downloadProgress;
                        s.h(task, "task");
                        int soFarBytes = (IDownloadTask.this.getSoFarBytes() * 100) / IDownloadTask.this.getTotalBytes();
                        PaintMaterial paintMaterial = MaterialDataManager.a.e().get(pid);
                        if (paintMaterial != null && (downloadProgress = paintMaterial.getDownloadProgress()) != null) {
                            downloadProgress.set(soFarBytes);
                        }
                        us.pinguo.common.log.a.e("Material Downloading: " + soFarBytes + '%', new Object[0]);
                    }
                });
                create.start();
                return;
            }
        }
        completeAction.invoke(Boolean.FALSE, material);
    }
}
