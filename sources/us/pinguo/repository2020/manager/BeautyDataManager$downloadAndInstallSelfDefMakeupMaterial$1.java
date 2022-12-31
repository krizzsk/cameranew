package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
/* loaded from: classes6.dex */
public final class BeautyDataManager$downloadAndInstallSelfDefMakeupMaterial$1 extends Lambda implements p<Boolean, SelfDefMakeupMaterial, u> {
    final /* synthetic */ q<Boolean, SelfDefMakeupMaterial, String, u> $downloadAction;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BeautyDataManager.kt */
    /* renamed from: us.pinguo.repository2020.manager.BeautyDataManager$downloadAndInstallSelfDefMakeupMaterial$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends Lambda implements q<Boolean, SelfDefMakeupMaterial, String, u> {
        final /* synthetic */ q<Boolean, SelfDefMakeupMaterial, String, u> $downloadAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(q<? super Boolean, ? super SelfDefMakeupMaterial, ? super String, u> qVar) {
            super(3);
            this.$downloadAction = qVar;
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ u invoke(Boolean bool, SelfDefMakeupMaterial selfDefMakeupMaterial, String str) {
            invoke(bool.booleanValue(), selfDefMakeupMaterial, str);
            return u.a;
        }

        public final void invoke(boolean z, SelfDefMakeupMaterial material, String message) {
            ObservableField<MaterialInstallState> installState;
            ObservableField<MaterialInstallState> installState2;
            s.h(material, "material");
            s.h(message, "message");
            if (z) {
                PaintMaterial paintMaterial = MaterialDataManager.a.e().get(material.getPid());
                if (paintMaterial != null && (installState2 = paintMaterial.getInstallState()) != null) {
                    installState2.set(MaterialInstallState.STATE_INSTALLED);
                }
            } else {
                PaintMaterial paintMaterial2 = MaterialDataManager.a.e().get(material.getPid());
                if (paintMaterial2 != null && (installState = paintMaterial2.getInstallState()) != null) {
                    installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                }
            }
            this.$downloadAction.invoke(Boolean.valueOf(z), material, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BeautyDataManager$downloadAndInstallSelfDefMakeupMaterial$1(q<? super Boolean, ? super SelfDefMakeupMaterial, ? super String, u> qVar) {
        super(2);
        this.$downloadAction = qVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, SelfDefMakeupMaterial selfDefMakeupMaterial) {
        invoke(bool.booleanValue(), selfDefMakeupMaterial);
        return u.a;
    }

    public final void invoke(boolean z, SelfDefMakeupMaterial material) {
        ObservableField<MaterialInstallState> installState;
        s.h(material, "material");
        if (z) {
            BeautyInstallManager.a.b(material, new AnonymousClass1(this.$downloadAction));
            return;
        }
        SelfDefMakeup selfDefMakeup = BeautyDataManager.a.n().get(material.getPid());
        if (selfDefMakeup == null || (installState = selfDefMakeup.getInstallState()) == null) {
            return;
        }
        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
    }
}
