package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.PaintMaterial;
/* compiled from: MaterialDataManager.kt */
/* loaded from: classes6.dex */
final class MaterialDataManager$downloadAndInstallMaterial$1 extends Lambda implements p<Boolean, PaintMaterial, u> {
    final /* synthetic */ q<Boolean, PaintMaterial, String, u> $downloadAction;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialDataManager.kt */
    /* renamed from: us.pinguo.repository2020.manager.MaterialDataManager$downloadAndInstallMaterial$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends Lambda implements q<Boolean, PaintMaterial, String, u> {
        final /* synthetic */ q<Boolean, PaintMaterial, String, u> $downloadAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar) {
            super(3);
            this.$downloadAction = qVar;
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ u invoke(Boolean bool, PaintMaterial paintMaterial, String str) {
            invoke(bool.booleanValue(), paintMaterial, str);
            return u.a;
        }

        public final void invoke(boolean z, PaintMaterial installMaterial, String message) {
            ObservableField<MaterialInstallState> installState;
            ObservableField<MaterialInstallState> installState2;
            s.h(installMaterial, "installMaterial");
            s.h(message, "message");
            if (z) {
                PaintMaterial paintMaterial = MaterialDataManager.a.e().get(installMaterial.getPid());
                if (paintMaterial != null && (installState2 = paintMaterial.getInstallState()) != null) {
                    installState2.set(MaterialInstallState.STATE_INSTALLED);
                }
            } else {
                PaintMaterial paintMaterial2 = MaterialDataManager.a.e().get(installMaterial.getPid());
                if (paintMaterial2 != null && (installState = paintMaterial2.getInstallState()) != null) {
                    installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                }
            }
            this.$downloadAction.invoke(Boolean.valueOf(z), installMaterial, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MaterialDataManager$downloadAndInstallMaterial$1(q<? super Boolean, ? super PaintMaterial, ? super String, u> qVar) {
        super(2);
        this.$downloadAction = qVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, PaintMaterial paintMaterial) {
        invoke(bool.booleanValue(), paintMaterial);
        return u.a;
    }

    public final void invoke(boolean z, PaintMaterial downloadMaterial) {
        ObservableField<MaterialInstallState> installState;
        s.h(downloadMaterial, "downloadMaterial");
        if (z) {
            MaterialInstallManager.a.b(downloadMaterial, new AnonymousClass1(this.$downloadAction));
            return;
        }
        PaintMaterial paintMaterial = MaterialDataManager.a.e().get(downloadMaterial.getPid());
        if (paintMaterial == null || (installState = paintMaterial.getInstallState()) == null) {
            return;
        }
        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
    }
}
