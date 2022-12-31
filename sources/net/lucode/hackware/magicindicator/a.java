package net.lucode.hackware.magicindicator;

import android.annotation.TargetApi;
import java.util.List;
/* compiled from: FragmentContainerHelper.java */
@TargetApi(11)
/* loaded from: classes3.dex */
public class a {
    public static net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a a(List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> list, int i2) {
        net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a aVar;
        if (i2 >= 0 && i2 <= list.size() - 1) {
            return list.get(i2);
        }
        net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a aVar2 = new net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a();
        if (i2 < 0) {
            aVar = list.get(0);
        } else {
            i2 = (i2 - list.size()) + 1;
            aVar = list.get(list.size() - 1);
        }
        aVar2.a = aVar.a + (aVar.b() * i2);
        aVar2.b = aVar.b;
        aVar2.c = aVar.c + (aVar.b() * i2);
        aVar2.f8894d = aVar.f8894d;
        aVar2.f8895e = aVar.f8895e + (aVar.b() * i2);
        aVar2.f8896f = aVar.f8896f;
        aVar2.f8897g = aVar.f8897g + (i2 * aVar.b());
        aVar2.f8898h = aVar.f8898h;
        return aVar2;
    }
}
