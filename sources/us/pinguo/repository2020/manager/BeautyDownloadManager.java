package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import java.io.File;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.utils.n;
/* compiled from: BeautyDownloadManager.kt */
/* loaded from: classes6.dex */
public final class BeautyDownloadManager {
    public static final BeautyDownloadManager a = new BeautyDownloadManager();

    private BeautyDownloadManager() {
    }

    public final void a(SelfDefMakeupMaterial selfDefMakeupMaterial, p<? super Boolean, ? super SelfDefMakeupMaterial, u> completeAction) {
        s.h(selfDefMakeupMaterial, "selfDefMakeupMaterial");
        s.h(completeAction, "completeAction");
        String down_url = selfDefMakeupMaterial.getDown_url();
        boolean z = false;
        if (!(down_url == null || down_url.length() == 0)) {
            String pid = selfDefMakeupMaterial.getPid();
            if (!((pid == null || pid.length() == 0) ? true : true)) {
                kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDownloadManager$downloadSelfDefMakeupAsync$1(selfDefMakeupMaterial, completeAction, null), 3, null);
                return;
            }
        }
        completeAction.invoke(Boolean.FALSE, selfDefMakeupMaterial);
    }

    public final <T extends MaterialDetail> void b(final T materialDetail, final p<? super Boolean, ? super T, u> completeAction) {
        s.h(materialDetail, "materialDetail");
        s.h(completeAction, "completeAction");
        String display_zip_md5 = materialDetail.getDisplay_zip_md5();
        if (!(display_zip_md5 == null || display_zip_md5.length() == 0)) {
            String package_zip_md5 = materialDetail.getPackage_zip_md5();
            if (!(package_zip_md5 == null || package_zip_md5.length() == 0)) {
                String package_zip = materialDetail.getPackage_zip();
                if (!(package_zip == null || package_zip.length() == 0)) {
                    String display_zip_url = materialDetail.getDisplay_zip_url();
                    if (!(display_zip_url == null || display_zip_url.length() == 0)) {
                        String pid = materialDetail.getPid();
                        if (!(pid == null || pid.length() == 0)) {
                            n nVar = n.a;
                            String b = nVar.b(materialDetail.getPackage_zip_md5());
                            String b2 = nVar.b(materialDetail.getDisplay_zip_md5());
                            String c = nVar.c(materialDetail.getPackage_zip_md5());
                            String str = File.separator;
                            final String q = s.q(c, str);
                            final String q2 = s.q(nVar.c(materialDetail.getDisplay_zip_md5()), str);
                            PGDownloadManger.Companion companion = PGDownloadManger.Companion;
                            IDownloadTask create = companion.getInstance().create(materialDetail.getPackage_zip(), b, false, 0);
                            create.setForceReDownload(true);
                            IDownloadTask create2 = companion.getInstance().create(materialDetail.getDisplay_zip_url(), b2, false, 0);
                            create2.setForceReDownload(true);
                            us.pinguo.repository2020.database.sticker.g gVar = new us.pinguo.repository2020.database.sticker.g(materialDetail.getPid(), create2, create);
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDownloadManager$downloadStyleMakeupAsync$1(b, b2, completeAction, materialDetail, null), 3, null);
                            gVar.g(new us.pinguo.repository2020.database.sticker.a() { // from class: us.pinguo.repository2020.manager.BeautyDownloadManager$downloadStyleMakeupAsync$2
                                @Override // us.pinguo.repository2020.database.sticker.a
                                public void a(String id, IDownloadTask displayTask, IDownloadTask packageTask) {
                                    ObservableField<MaterialInstallState> installState;
                                    s.h(id, "id");
                                    s.h(displayTask, "displayTask");
                                    s.h(packageTask, "packageTask");
                                    String path = packageTask.getPath();
                                    String path2 = displayTask.getPath();
                                    if (path != null && path2 != null) {
                                        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDownloadManager$downloadStyleMakeupAsync$2$onComplete$1(q, q2, path, path2, completeAction, MaterialDetail.this, null), 3, null);
                                        return;
                                    }
                                    StyleMakeup styleMakeup = BeautyDataManager.a.q().get(MaterialDetail.this.getPid());
                                    if (styleMakeup != null && (installState = styleMakeup.getInstallState()) != null) {
                                        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                                    }
                                    completeAction.invoke(Boolean.FALSE, MaterialDetail.this);
                                }

                                @Override // us.pinguo.repository2020.database.sticker.a
                                public void b(String id, IDownloadTask displayTask, IDownloadTask packageTask) {
                                    ObservableInt downloadProgress;
                                    s.h(id, "id");
                                    s.h(displayTask, "displayTask");
                                    s.h(packageTask, "packageTask");
                                    int soFarBytes = ((packageTask.getSoFarBytes() + displayTask.getSoFarBytes()) * 100) / (packageTask.getTotalBytes() + displayTask.getTotalBytes());
                                    StyleMakeup styleMakeup = BeautyDataManager.a.q().get(MaterialDetail.this.getPid());
                                    if (styleMakeup != null && (downloadProgress = styleMakeup.getDownloadProgress()) != null) {
                                        downloadProgress.set(soFarBytes);
                                    }
                                    us.pinguo.common.log.a.e("StyleMakeup Downloading: " + soFarBytes + '%', new Object[0]);
                                }

                                @Override // us.pinguo.repository2020.database.sticker.a
                                public void c(String id, IDownloadTask task, int i2) {
                                    ObservableField<MaterialInstallState> installState;
                                    s.h(id, "id");
                                    s.h(task, "task");
                                    StyleMakeup styleMakeup = BeautyDataManager.a.q().get(MaterialDetail.this.getPid());
                                    if (styleMakeup == null || (installState = styleMakeup.getInstallState()) == null) {
                                        return;
                                    }
                                    installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                                }
                            });
                            gVar.h();
                            return;
                        }
                    }
                }
            }
        }
        completeAction.invoke(Boolean.FALSE, materialDetail);
    }
}
