package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import java.util.HashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.repository2020.utils.n;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDownloadManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDownloadManager$downloadSelfDefMakeupAsync$1", f = "BeautyDownloadManager.kt", i = {0, 0}, l = {104}, m = "invokeSuspend", n = {"materialUnzipPath", "materialTask"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class BeautyDownloadManager$downloadSelfDefMakeupAsync$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<Boolean, SelfDefMakeupMaterial, u> $completeAction;
    final /* synthetic */ SelfDefMakeupMaterial $selfDefMakeupMaterial;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BeautyDownloadManager$downloadSelfDefMakeupAsync$1(SelfDefMakeupMaterial selfDefMakeupMaterial, p<? super Boolean, ? super SelfDefMakeupMaterial, u> pVar, Continuation<? super BeautyDownloadManager$downloadSelfDefMakeupAsync$1> continuation) {
        super(2, continuation);
        this.$selfDefMakeupMaterial = selfDefMakeupMaterial;
        this.$completeAction = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDownloadManager$downloadSelfDefMakeupAsync$1(this.$selfDefMakeupMaterial, this.$completeAction, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDownloadManager$downloadSelfDefMakeupAsync$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        final String str;
        final IDownloadTask iDownloadTask;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            n nVar = n.a;
            String b = nVar.b(this.$selfDefMakeupMaterial.getPid());
            String f2 = nVar.f(this.$selfDefMakeupMaterial.getPid());
            PGDownloadManger companion = PGDownloadManger.Companion.getInstance();
            String down_url = this.$selfDefMakeupMaterial.getDown_url();
            s.e(down_url);
            IDownloadTask create = companion.create(down_url, b, false, 0);
            create.setForceReDownload(true);
            try {
                this.L$0 = f2;
                this.L$1 = create;
                this.label = 1;
                if (FileUtils.l(b, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = f2;
                iDownloadTask = create;
            } catch (Exception unused) {
                str = f2;
                iDownloadTask = create;
                us.pinguo.common.log.a.e("删除自定妆package or display失败", new Object[0]);
                this.$completeAction.invoke(Boxing.boxBoolean(false), this.$selfDefMakeupMaterial);
                final SelfDefMakeupMaterial selfDefMakeupMaterial = this.$selfDefMakeupMaterial;
                final p<Boolean, SelfDefMakeupMaterial, u> pVar = this.$completeAction;
                iDownloadTask.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.BeautyDownloadManager$downloadSelfDefMakeupAsync$1.1
                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onComplete(IDownloadTask task) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        String path = IDownloadTask.this.getPath();
                        if (path != null) {
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1(str, path, pVar, selfDefMakeupMaterial, null), 3, null);
                            return;
                        }
                        HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                        String pid = selfDefMakeupMaterial.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        SelfDefMakeup selfDefMakeup = n.get(pid);
                        if (selfDefMakeup != null && (installState = selfDefMakeup.getInstallState()) != null) {
                            installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                        }
                        pVar.invoke(Boolean.FALSE, selfDefMakeupMaterial);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onError(IDownloadTask task, int i3) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                        String pid = selfDefMakeupMaterial.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        SelfDefMakeup selfDefMakeup = n.get(pid);
                        if (selfDefMakeup == null || (installState = selfDefMakeup.getInstallState()) == null) {
                            return;
                        }
                        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onPause(IDownloadTask task) {
                        s.h(task, "task");
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onProgress(IDownloadTask task, int i3, int i4, int i5) {
                        ObservableInt downloadProgress;
                        s.h(task, "task");
                        int soFarBytes = (IDownloadTask.this.getSoFarBytes() * 100) / IDownloadTask.this.getTotalBytes();
                        HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                        String pid = selfDefMakeupMaterial.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        SelfDefMakeup selfDefMakeup = n.get(pid);
                        if (selfDefMakeup != null && (downloadProgress = selfDefMakeup.getDownloadProgress()) != null) {
                            downloadProgress.set(soFarBytes);
                        }
                        us.pinguo.common.log.a.e("Material Downloading: " + soFarBytes + '%', new Object[0]);
                    }
                });
                iDownloadTask.start();
                return u.a;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            iDownloadTask = (IDownloadTask) this.L$1;
            str = (String) this.L$0;
            try {
                kotlin.j.b(obj);
            } catch (Exception unused2) {
                us.pinguo.common.log.a.e("删除自定妆package or display失败", new Object[0]);
                this.$completeAction.invoke(Boxing.boxBoolean(false), this.$selfDefMakeupMaterial);
                final SelfDefMakeupMaterial selfDefMakeupMaterial2 = this.$selfDefMakeupMaterial;
                final p<? super Boolean, ? super SelfDefMakeupMaterial, u> pVar2 = this.$completeAction;
                iDownloadTask.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.BeautyDownloadManager$downloadSelfDefMakeupAsync$1.1
                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onComplete(IDownloadTask task) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        String path = IDownloadTask.this.getPath();
                        if (path != null) {
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1(str, path, pVar2, selfDefMakeupMaterial2, null), 3, null);
                            return;
                        }
                        HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                        String pid = selfDefMakeupMaterial2.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        SelfDefMakeup selfDefMakeup = n.get(pid);
                        if (selfDefMakeup != null && (installState = selfDefMakeup.getInstallState()) != null) {
                            installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                        }
                        pVar2.invoke(Boolean.FALSE, selfDefMakeupMaterial2);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onError(IDownloadTask task, int i3) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                        String pid = selfDefMakeupMaterial2.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        SelfDefMakeup selfDefMakeup = n.get(pid);
                        if (selfDefMakeup == null || (installState = selfDefMakeup.getInstallState()) == null) {
                            return;
                        }
                        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onPause(IDownloadTask task) {
                        s.h(task, "task");
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onProgress(IDownloadTask task, int i3, int i4, int i5) {
                        ObservableInt downloadProgress;
                        s.h(task, "task");
                        int soFarBytes = (IDownloadTask.this.getSoFarBytes() * 100) / IDownloadTask.this.getTotalBytes();
                        HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                        String pid = selfDefMakeupMaterial2.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        SelfDefMakeup selfDefMakeup = n.get(pid);
                        if (selfDefMakeup != null && (downloadProgress = selfDefMakeup.getDownloadProgress()) != null) {
                            downloadProgress.set(soFarBytes);
                        }
                        us.pinguo.common.log.a.e("Material Downloading: " + soFarBytes + '%', new Object[0]);
                    }
                });
                iDownloadTask.start();
                return u.a;
            }
        }
        final SelfDefMakeupMaterial selfDefMakeupMaterial22 = this.$selfDefMakeupMaterial;
        final p<? super Boolean, ? super SelfDefMakeupMaterial, u> pVar22 = this.$completeAction;
        iDownloadTask.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.BeautyDownloadManager$downloadSelfDefMakeupAsync$1.1
            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onComplete(IDownloadTask task) {
                ObservableField<MaterialInstallState> installState;
                s.h(task, "task");
                String path = IDownloadTask.this.getPath();
                if (path != null) {
                    kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDownloadManager$downloadSelfDefMakeupAsync$1$1$onComplete$1(str, path, pVar22, selfDefMakeupMaterial22, null), 3, null);
                    return;
                }
                HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                String pid = selfDefMakeupMaterial22.getPid();
                if (pid == null) {
                    pid = "";
                }
                SelfDefMakeup selfDefMakeup = n.get(pid);
                if (selfDefMakeup != null && (installState = selfDefMakeup.getInstallState()) != null) {
                    installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                }
                pVar22.invoke(Boolean.FALSE, selfDefMakeupMaterial22);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onError(IDownloadTask task, int i3) {
                ObservableField<MaterialInstallState> installState;
                s.h(task, "task");
                HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                String pid = selfDefMakeupMaterial22.getPid();
                if (pid == null) {
                    pid = "";
                }
                SelfDefMakeup selfDefMakeup = n.get(pid);
                if (selfDefMakeup == null || (installState = selfDefMakeup.getInstallState()) == null) {
                    return;
                }
                installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onPause(IDownloadTask task) {
                s.h(task, "task");
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onProgress(IDownloadTask task, int i3, int i4, int i5) {
                ObservableInt downloadProgress;
                s.h(task, "task");
                int soFarBytes = (IDownloadTask.this.getSoFarBytes() * 100) / IDownloadTask.this.getTotalBytes();
                HashMap<String, SelfDefMakeup> n = BeautyDataManager.a.n();
                String pid = selfDefMakeupMaterial22.getPid();
                if (pid == null) {
                    pid = "";
                }
                SelfDefMakeup selfDefMakeup = n.get(pid);
                if (selfDefMakeup != null && (downloadProgress = selfDefMakeup.getDownloadProgress()) != null) {
                    downloadProgress.set(soFarBytes);
                }
                us.pinguo.common.log.a.e("Material Downloading: " + soFarBytes + '%', new Object[0]);
            }
        });
        iDownloadTask.start();
        return u.a;
    }
}
