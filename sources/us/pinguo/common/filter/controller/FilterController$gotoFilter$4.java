package us.pinguo.common.filter.controller;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.manager.FilterRepository;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
/* loaded from: classes4.dex */
public final class FilterController$gotoFilter$4 extends Lambda implements kotlin.jvm.b.l<PackageItem, u> {
    final /* synthetic */ CategoryItem $categoryItem;
    final /* synthetic */ Ref$ObjectRef<FilterItem> $filterItem;
    final /* synthetic */ String $itemId;
    final /* synthetic */ Ref$ObjectRef<PackageItem> $pkgItem;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$gotoFilter$4(FilterController filterController, Ref$ObjectRef<FilterItem> ref$ObjectRef, String str, Ref$ObjectRef<PackageItem> ref$ObjectRef2, CategoryItem categoryItem) {
        super(1);
        this.this$0 = filterController;
        this.$filterItem = ref$ObjectRef;
        this.$itemId = str;
        this.$pkgItem = ref$ObjectRef2;
        this.$categoryItem = categoryItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r6v3, types: [us.pinguo.repository2020.entity.FilterItem, T] */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m76invoke$lambda0(FilterController this$0, Ref$ObjectRef filterItem, String str, Ref$ObjectRef pkgItem, CategoryItem categoryItem) {
        s.h(this$0, "this$0");
        s.h(filterItem, "$filterItem");
        s.h(pkgItem, "$pkgItem");
        FilterController.d1(this$0, false, 1, null);
        FilterRepository.K(FilterRepository.a, false, 1, null);
        if (filterItem.element == 0 && str != null) {
            filterItem.element = this$0.b.z(((PackageItem) pkgItem.element).getPackageId(), str);
        }
        this$0.v0().s(categoryItem, (PackageItem) pkgItem.element, (FilterItem) filterItem.element);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(PackageItem packageItem) {
        invoke2(packageItem);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PackageItem it) {
        s.h(it, "it");
        if (this.this$0.v0().getVisibility() == 0) {
            FilterPanelView v0 = this.this$0.v0();
            final FilterController filterController = this.this$0;
            final Ref$ObjectRef<FilterItem> ref$ObjectRef = this.$filterItem;
            final String str = this.$itemId;
            final Ref$ObjectRef<PackageItem> ref$ObjectRef2 = this.$pkgItem;
            final CategoryItem categoryItem = this.$categoryItem;
            us.pinguo.foundation.ui.c.b(v0, new Runnable() { // from class: us.pinguo.common.filter.controller.i
                @Override // java.lang.Runnable
                public final void run() {
                    FilterController$gotoFilter$4.m76invoke$lambda0(FilterController.this, ref$ObjectRef, str, ref$ObjectRef2, categoryItem);
                }
            });
        }
    }
}
