package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* compiled from: EditBottomTabBeautyControllerNew.kt */
/* loaded from: classes4.dex */
final class EditBottomTabBeautyControllerNew$needExitCheck$1 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.bean.i, Boolean> {
    public static final EditBottomTabBeautyControllerNew$needExitCheck$1 INSTANCE = new EditBottomTabBeautyControllerNew$needExitCheck$1();

    EditBottomTabBeautyControllerNew$needExitCheck$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(us.pinguo.edit2020.bean.i it) {
        kotlin.jvm.internal.s.h(it, "it");
        return Boolean.valueOf(it.e() && it.j());
    }
}
