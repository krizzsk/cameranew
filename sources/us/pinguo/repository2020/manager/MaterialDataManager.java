package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.b.q;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.s;
import us.pinguo.repository2020.u;
/* compiled from: MaterialDataManager.kt */
/* loaded from: classes6.dex */
public final class MaterialDataManager {
    private static final boolean b;
    public static final MaterialDataManager a = new MaterialDataManager();
    private static final s c = new s();

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, PaintMaterial> f11920d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static u<MaterialResponse<Mosaic>> f11921e = new u<>(null);

    /* renamed from: f  reason: collision with root package name */
    private static u<MaterialResponse<Graffiti>> f11922f = new u<>(null);

    /* renamed from: g  reason: collision with root package name */
    private static final String f11923g = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_mosaic.json";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11924h = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_graffiti.json";

    static {
        Locale locale = Locale.getDefault();
        b = kotlin.jvm.internal.s.c("zh", locale.getLanguage()) && kotlin.jvm.internal.s.c("CN", locale.getCountry());
    }

    private MaterialDataManager() {
    }

    public final void a(PaintMaterial material, q<? super Boolean, ? super PaintMaterial, ? super String, kotlin.u> downloadAction) {
        ObservableField<MaterialInstallState> installState;
        kotlin.jvm.internal.s.h(material, "material");
        kotlin.jvm.internal.s.h(downloadAction, "downloadAction");
        PaintMaterial paintMaterial = f11920d.get(material.getPid());
        if (paintMaterial != null && (installState = paintMaterial.getInstallState()) != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        MaterialDownloadManager.a.a(material, new MaterialDataManager$downloadAndInstallMaterial$1(downloadAction));
    }

    public final u<MaterialResponse<Graffiti>> b() {
        return f11922f;
    }

    public final String c() {
        return f11924h;
    }

    public final s d() {
        return c;
    }

    public final HashMap<String, PaintMaterial> e() {
        return f11920d;
    }

    public final u<MaterialResponse<Mosaic>> f() {
        return f11921e;
    }

    public final String g() {
        return f11923g;
    }

    public final boolean h() {
        return b;
    }

    public final void i() {
        c.b();
    }
}
