package us.pinguo.repository2020.entity;

import androidx.databinding.ObservableField;
import kotlin.jvm.internal.o;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public final class MaterialColor extends SelfDefMakeupMaterial implements NoProguard {
    private final String cid;

    public /* synthetic */ MaterialColor(String str, String str2, String str3, Long l2, Long l3, Integer num, int i2, o oVar) {
        this(str, str2, str3, l2, l3, (i2 & 32) != 0 ? null : num);
    }

    public final String getCid() {
        return this.cid;
    }

    @Override // us.pinguo.repository2020.entity.Material
    public ObservableField<MaterialInstallState> getInstallState() {
        return new ObservableField<>(MaterialInstallState.STATE_INSTALLED);
    }

    @Override // us.pinguo.repository2020.entity.Material
    public void setInstallState(ObservableField<MaterialInstallState> observableField) {
    }

    public MaterialColor(String str, String str2, String str3, Long l2, Long l3, Integer num) {
        super(str, str2, str3, null, l3, l2, num, 8, null);
        this.cid = str;
    }
}
