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
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.utils.n;
import us.pinguo.util.FileUtils;
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager$downloadBlurMaterial$1", f = "BackgroundBlurDataManager.kt", i = {0, 0}, l = {398}, m = "invokeSuspend", n = {"materialUnzipPath", "materialTask"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
final class BackgroundBlurDataManager$downloadBlurMaterial$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ BackgroundBlurMaterial $blurMaterial;
    final /* synthetic */ p<Boolean, BackgroundBlurMaterial, u> $completeAction;
    final /* synthetic */ String $downLoadUrl;
    final /* synthetic */ String $pid;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundBlurDataManager$downloadBlurMaterial$1(BackgroundBlurMaterial backgroundBlurMaterial, String str, p<? super Boolean, ? super BackgroundBlurMaterial, u> pVar, String str2, Continuation<? super BackgroundBlurDataManager$downloadBlurMaterial$1> continuation) {
        super(2, continuation);
        this.$blurMaterial = backgroundBlurMaterial;
        this.$downLoadUrl = str;
        this.$completeAction = pVar;
        this.$pid = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurDataManager$downloadBlurMaterial$1(this.$blurMaterial, this.$downLoadUrl, this.$completeAction, this.$pid, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundBlurDataManager$downloadBlurMaterial$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        IDownloadTask iDownloadTask;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            n nVar = n.a;
            String b = nVar.b(this.$blurMaterial.getPid());
            String f2 = nVar.f(this.$blurMaterial.getPid());
            IDownloadTask create = PGDownloadManger.Companion.getInstance().create(this.$downLoadUrl, b, false, 0);
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
                us.pinguo.common.log.a.e("删除BlurMaterial package失败", new Object[0]);
                this.$completeAction.invoke(Boxing.boxBoolean(false), this.$blurMaterial);
                final String str2 = str;
                final String str3 = this.$pid;
                final p<Boolean, BackgroundBlurMaterial, u> pVar = this.$completeAction;
                final BackgroundBlurMaterial backgroundBlurMaterial = this.$blurMaterial;
                final IDownloadTask iDownloadTask2 = iDownloadTask;
                iDownloadTask.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.BackgroundBlurDataManager$downloadBlurMaterial$1.1
                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onComplete(IDownloadTask task) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        String path = IDownloadTask.this.getPath();
                        if (path != null) {
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1(str2, path, pVar, backgroundBlurMaterial, null), 3, null);
                            return;
                        }
                        BackgroundBlurMaterial backgroundBlurMaterial2 = BackgroundBlurDataManager.a.k().get(str3);
                        if (backgroundBlurMaterial2 != null && (installState = backgroundBlurMaterial2.getInstallState()) != null) {
                            installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                        }
                        pVar.invoke(Boolean.FALSE, backgroundBlurMaterial);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onError(IDownloadTask task, int i3) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        HashMap<String, BackgroundBlurMaterial> k2 = BackgroundBlurDataManager.a.k();
                        String pid = backgroundBlurMaterial.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        BackgroundBlurMaterial backgroundBlurMaterial2 = k2.get(pid);
                        if (backgroundBlurMaterial2 == null || (installState = backgroundBlurMaterial2.getInstallState()) == null) {
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
                        HashMap<String, BackgroundBlurMaterial> k2 = BackgroundBlurDataManager.a.k();
                        String pid = backgroundBlurMaterial.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        BackgroundBlurMaterial backgroundBlurMaterial2 = k2.get(pid);
                        if (backgroundBlurMaterial2 != null && (downloadProgress = backgroundBlurMaterial2.getDownloadProgress()) != null) {
                            downloadProgress.set(soFarBytes);
                        }
                        us.pinguo.common.log.a.e("BackgroundBlurMaterial Downloading: " + soFarBytes + '%', new Object[0]);
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
                us.pinguo.common.log.a.e("删除BlurMaterial package失败", new Object[0]);
                this.$completeAction.invoke(Boxing.boxBoolean(false), this.$blurMaterial);
                final String str22 = str;
                final String str32 = this.$pid;
                final p<? super Boolean, ? super BackgroundBlurMaterial, u> pVar2 = this.$completeAction;
                final BackgroundBlurMaterial backgroundBlurMaterial2 = this.$blurMaterial;
                final IDownloadTask iDownloadTask22 = iDownloadTask;
                iDownloadTask.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.BackgroundBlurDataManager$downloadBlurMaterial$1.1
                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onComplete(IDownloadTask task) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        String path = IDownloadTask.this.getPath();
                        if (path != null) {
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1(str22, path, pVar2, backgroundBlurMaterial2, null), 3, null);
                            return;
                        }
                        BackgroundBlurMaterial backgroundBlurMaterial22 = BackgroundBlurDataManager.a.k().get(str32);
                        if (backgroundBlurMaterial22 != null && (installState = backgroundBlurMaterial22.getInstallState()) != null) {
                            installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                        }
                        pVar2.invoke(Boolean.FALSE, backgroundBlurMaterial2);
                    }

                    @Override // us.pinguo.common.pgdownloader.download.DownloadListener
                    public void onError(IDownloadTask task, int i3) {
                        ObservableField<MaterialInstallState> installState;
                        s.h(task, "task");
                        HashMap<String, BackgroundBlurMaterial> k2 = BackgroundBlurDataManager.a.k();
                        String pid = backgroundBlurMaterial2.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        BackgroundBlurMaterial backgroundBlurMaterial22 = k2.get(pid);
                        if (backgroundBlurMaterial22 == null || (installState = backgroundBlurMaterial22.getInstallState()) == null) {
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
                        HashMap<String, BackgroundBlurMaterial> k2 = BackgroundBlurDataManager.a.k();
                        String pid = backgroundBlurMaterial2.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        BackgroundBlurMaterial backgroundBlurMaterial22 = k2.get(pid);
                        if (backgroundBlurMaterial22 != null && (downloadProgress = backgroundBlurMaterial22.getDownloadProgress()) != null) {
                            downloadProgress.set(soFarBytes);
                        }
                        us.pinguo.common.log.a.e("BackgroundBlurMaterial Downloading: " + soFarBytes + '%', new Object[0]);
                    }
                });
                iDownloadTask.start();
                return u.a;
            }
        }
        final String str222 = str;
        final String str322 = this.$pid;
        final p<? super Boolean, ? super BackgroundBlurMaterial, u> pVar22 = this.$completeAction;
        final BackgroundBlurMaterial backgroundBlurMaterial22 = this.$blurMaterial;
        final IDownloadTask iDownloadTask222 = iDownloadTask;
        iDownloadTask.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.manager.BackgroundBlurDataManager$downloadBlurMaterial$1.1
            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onComplete(IDownloadTask task) {
                ObservableField<MaterialInstallState> installState;
                s.h(task, "task");
                String path = IDownloadTask.this.getPath();
                if (path != null) {
                    kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$downloadBlurMaterial$1$1$onComplete$1(str222, path, pVar22, backgroundBlurMaterial22, null), 3, null);
                    return;
                }
                BackgroundBlurMaterial backgroundBlurMaterial222 = BackgroundBlurDataManager.a.k().get(str322);
                if (backgroundBlurMaterial222 != null && (installState = backgroundBlurMaterial222.getInstallState()) != null) {
                    installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                }
                pVar22.invoke(Boolean.FALSE, backgroundBlurMaterial22);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onError(IDownloadTask task, int i3) {
                ObservableField<MaterialInstallState> installState;
                s.h(task, "task");
                HashMap<String, BackgroundBlurMaterial> k2 = BackgroundBlurDataManager.a.k();
                String pid = backgroundBlurMaterial22.getPid();
                if (pid == null) {
                    pid = "";
                }
                BackgroundBlurMaterial backgroundBlurMaterial222 = k2.get(pid);
                if (backgroundBlurMaterial222 == null || (installState = backgroundBlurMaterial222.getInstallState()) == null) {
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
                HashMap<String, BackgroundBlurMaterial> k2 = BackgroundBlurDataManager.a.k();
                String pid = backgroundBlurMaterial22.getPid();
                if (pid == null) {
                    pid = "";
                }
                BackgroundBlurMaterial backgroundBlurMaterial222 = k2.get(pid);
                if (backgroundBlurMaterial222 != null && (downloadProgress = backgroundBlurMaterial222.getDownloadProgress()) != null) {
                    downloadProgress.set(soFarBytes);
                }
                us.pinguo.common.log.a.e("BackgroundBlurMaterial Downloading: " + soFarBytes + '%', new Object[0]);
            }
        });
        iDownloadTask.start();
        return u.a;
    }
}
