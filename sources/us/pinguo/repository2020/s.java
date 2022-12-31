package us.pinguo.repository2020;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import com.pinguo.lib.GsonUtilKt;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.utils.m0;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.manager.MaterialDataManager;
import us.pinguo.repository2020.manager.MaterialInstallManager;
import us.pinguo.repository2020.network.HttpBaseResponse;
/* compiled from: MaterialDataRepository.kt */
/* loaded from: classes6.dex */
public final class s {
    private final String a = kotlin.jvm.internal.s.q(us.pinguo.foundation.e.b().getFilesDir().getAbsolutePath(), File.separator);
    private final ArrayList<Mosaic> b = new ArrayList<>();

    /* compiled from: MaterialDataRepository.kt */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<Mosaic>>> {
        a() {
        }
    }

    public final ArrayList<Mosaic> a() {
        return this.b;
    }

    public final void b() {
        List<Graffiti> packages;
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        boolean b = us.pinguo.repository2020.utils.o.b(oVar, "is_material_ready", false, null, 4, null);
        boolean b2 = us.pinguo.repository2020.utils.o.b(oVar, "is_graffiti_ready2", false, null, 4, null);
        if (!b) {
            File file = new File(this.a);
            if (file.exists()) {
                file.delete();
            }
            String q = kotlin.jvm.internal.s.q(this.a, "mosaic.zip");
            us.pinguo.repository2020.utils.f fVar = us.pinguo.repository2020.utils.f.a;
            Context b3 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b3, "getAppContext()");
            if (fVar.a(b3, "builtin_data/mosaic/mosaic.zip", q)) {
                try {
                    m0.c(q, us.pinguo.repository2020.utils.n.a.g(""));
                    us.pinguo.repository2020.utils.o.n(oVar, "is_material_ready", true, null, 4, null);
                } catch (Exception unused) {
                    us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "is_material_ready", false, null, 4, null);
                }
            }
        }
        if (!b2) {
            File file2 = new File(this.a);
            if (file2.exists()) {
                file2.delete();
            }
            String q2 = kotlin.jvm.internal.s.q(this.a, "graffiti.zip");
            us.pinguo.repository2020.utils.f fVar2 = us.pinguo.repository2020.utils.f.a;
            Context b4 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b4, "getAppContext()");
            if (fVar2.a(b4, "builtin_data/graffiti/graffiti.zip", q2)) {
                try {
                    m0.c(q2, us.pinguo.repository2020.utils.n.a.g(""));
                    us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "is_graffiti_ready2", true, null, 4, null);
                } catch (Exception unused2) {
                    us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "is_graffiti_ready2", false, null, 4, null);
                }
            }
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(us.pinguo.foundation.e.b().getAssets().open("builtin_data/mosaic/default_mosaic.json", 3)));
        Type type = new a().getType();
        inputStreamReader.close();
        List<Mosaic> packages2 = ((MaterialResponse) ((HttpBaseResponse) GsonUtilKt.getCachedGson().i(inputStreamReader, type)).getData()).getPackages();
        this.b.clear();
        if (!(packages2 == null || packages2.isEmpty())) {
            for (Mosaic mosaic : packages2) {
                mosaic.setSelected(new ObservableBoolean(false));
                mosaic.setInstallState(new ObservableField<>(MaterialInstallState.STATE_INSTALLED));
                MaterialInstallManager.c(MaterialInstallManager.a, mosaic, null, 2, null);
                a().add(mosaic);
            }
        }
        MaterialResponse<Graffiti> value = MaterialDataManager.a.b().getValue();
        if (value == null || (packages = value.getPackages()) == null || packages.size() <= 3) {
            return;
        }
        MaterialInstallManager materialInstallManager = MaterialInstallManager.a;
        MaterialInstallManager.c(materialInstallManager, packages.get(0), null, 2, null);
        MaterialInstallManager.c(materialInstallManager, packages.get(1), null, 2, null);
        MaterialInstallManager.c(materialInstallManager, packages.get(2), null, 2, null);
        MaterialInstallManager.c(materialInstallManager, packages.get(3), null, 2, null);
    }
}
