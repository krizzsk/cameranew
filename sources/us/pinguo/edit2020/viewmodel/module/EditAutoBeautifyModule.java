package us.pinguo.edit2020.viewmodel.module;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditAutoBeautifyModule.kt */
/* loaded from: classes4.dex */
public final class EditAutoBeautifyModule {
    private List<us.pinguo.edit2020.bean.c> a;

    public EditAutoBeautifyModule(EditRender render) {
        s.h(render, "render");
    }

    public final List<us.pinguo.edit2020.bean.c> a() {
        List<us.pinguo.edit2020.bean.c> list = this.a;
        if (list != null) {
            return list;
        }
        Resources resources = us.pinguo.foundation.e.b().getResources();
        ArrayList arrayList = new ArrayList();
        String string = resources.getString(R.string.edit_beauty);
        s.g(string, "resources.getString(R.string.edit_beauty)");
        us.pinguo.edit2020.bean.c cVar = new us.pinguo.edit2020.bean.c("beauty", string, R.drawable.icon_beauty_autobeauty_beauty, false, 50, false);
        UnityEditCaller.AutoBeauty autoBeauty = UnityEditCaller.AutoBeauty.INSTANCE;
        cVar.l(new EditAutoBeautifyModule$getAutoBeautifyFunctions$1(autoBeauty));
        arrayList.add(cVar);
        String string2 = resources.getString(R.string.edit_shape);
        s.g(string2, "resources.getString(R.string.edit_shape)");
        us.pinguo.edit2020.bean.c cVar2 = new us.pinguo.edit2020.bean.c("body", string2, R.drawable.icon_beauty_autobeauty_shape, false, 0, false);
        cVar2.l(new EditAutoBeautifyModule$getAutoBeautifyFunctions$2(autoBeauty));
        arrayList.add(cVar2);
        String string3 = resources.getString(R.string.edit_make_up);
        s.g(string3, "resources.getString(R.string.edit_make_up)");
        us.pinguo.edit2020.bean.c cVar3 = new us.pinguo.edit2020.bean.c("makeup", string3, R.drawable.icon_beauty_autobeauty_makeup, true, 0, false);
        cVar3.l(new EditAutoBeautifyModule$getAutoBeautifyFunctions$3(autoBeauty));
        arrayList.add(cVar3);
        this.a = arrayList;
        return arrayList;
    }

    public final String[] b() {
        String string = us.pinguo.foundation.e.b().getResources().getString(R.string.main_menu_beauty_onebtbeauty);
        s.g(string, "getAppContext().resource…_menu_beauty_onebtbeauty)");
        return new String[]{string};
    }

    public final void c() {
        List<us.pinguo.edit2020.bean.c> list = this.a;
        if (list == null) {
            return;
        }
        for (us.pinguo.edit2020.bean.c cVar : list) {
            cVar.k(cVar.h());
            cVar.j(false);
        }
    }
}
