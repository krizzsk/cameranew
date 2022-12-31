package us.pinguo.common.widget.sample.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.h0;
import kotlin.z.d;
import kotlin.z.j;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.common.widget.R;
import us.pinguo.common.widget.g;
/* compiled from: DecorationTestActivity.kt */
/* loaded from: classes4.dex */
public final class DecorationTestActivity extends AppCompatActivity {
    public Map<Integer, View> a = new LinkedHashMap();

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        d h2;
        d h3;
        d h4;
        d h5;
        d h6;
        d h7;
        super.onCreate(bundle);
        setContentView(R.layout.activity_decoration_test);
        b bVar = new b();
        EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(this, 0, false);
        h2 = j.h(0, 1);
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            ((h0) it).nextInt();
            bVar.e().add(new a(R.drawable.ic_edit_item_test, R.string.test_name));
        }
        g gVar = new g();
        gVar.a(this, bVar.getItemCount(), editFunctionLayoutManager.a(this, bVar.getItemCount()));
        int i2 = R.id.rv1;
        ((RecyclerView) _$_findCachedViewById(i2)).setAdapter(bVar);
        ((RecyclerView) _$_findCachedViewById(i2)).setLayoutManager(editFunctionLayoutManager);
        ((RecyclerView) _$_findCachedViewById(i2)).addItemDecoration(gVar);
        b bVar2 = new b();
        EditFunctionLayoutManager editFunctionLayoutManager2 = new EditFunctionLayoutManager(this, 0, false);
        h3 = j.h(0, 2);
        Iterator<Integer> it2 = h3.iterator();
        while (it2.hasNext()) {
            ((h0) it2).nextInt();
            bVar2.e().add(new a(R.drawable.ic_edit_item_test, R.string.test_name));
        }
        g gVar2 = new g();
        gVar2.a(this, bVar2.getItemCount(), editFunctionLayoutManager2.a(this, bVar2.getItemCount()));
        int i3 = R.id.rv2;
        ((RecyclerView) _$_findCachedViewById(i3)).setAdapter(bVar2);
        ((RecyclerView) _$_findCachedViewById(i3)).setLayoutManager(editFunctionLayoutManager2);
        ((RecyclerView) _$_findCachedViewById(i3)).addItemDecoration(gVar2);
        b bVar3 = new b();
        EditFunctionLayoutManager editFunctionLayoutManager3 = new EditFunctionLayoutManager(this, 0, false);
        h4 = j.h(0, 3);
        Iterator<Integer> it3 = h4.iterator();
        while (it3.hasNext()) {
            ((h0) it3).nextInt();
            bVar3.e().add(new a(R.drawable.ic_edit_item_test, R.string.test_name));
        }
        g gVar3 = new g();
        gVar3.a(this, bVar3.getItemCount(), editFunctionLayoutManager3.a(this, bVar3.getItemCount()));
        int i4 = R.id.rv3;
        ((RecyclerView) _$_findCachedViewById(i4)).setAdapter(bVar3);
        ((RecyclerView) _$_findCachedViewById(i4)).setLayoutManager(editFunctionLayoutManager3);
        ((RecyclerView) _$_findCachedViewById(i4)).addItemDecoration(gVar3);
        b bVar4 = new b();
        EditFunctionLayoutManager editFunctionLayoutManager4 = new EditFunctionLayoutManager(this, 0, false);
        h5 = j.h(0, 4);
        Iterator<Integer> it4 = h5.iterator();
        while (it4.hasNext()) {
            ((h0) it4).nextInt();
            bVar4.e().add(new a(R.drawable.ic_edit_item_test, R.string.test_name));
        }
        g gVar4 = new g();
        gVar4.a(this, bVar4.getItemCount(), editFunctionLayoutManager4.a(this, bVar4.getItemCount()));
        int i5 = R.id.rv4;
        ((RecyclerView) _$_findCachedViewById(i5)).setAdapter(bVar4);
        ((RecyclerView) _$_findCachedViewById(i5)).setLayoutManager(editFunctionLayoutManager4);
        ((RecyclerView) _$_findCachedViewById(i5)).addItemDecoration(gVar4);
        b bVar5 = new b();
        EditFunctionLayoutManager editFunctionLayoutManager5 = new EditFunctionLayoutManager(this, 0, false);
        h6 = j.h(0, 5);
        Iterator<Integer> it5 = h6.iterator();
        while (it5.hasNext()) {
            ((h0) it5).nextInt();
            bVar5.e().add(new a(R.drawable.ic_edit_item_test, R.string.test_name));
        }
        g gVar5 = new g();
        gVar5.a(this, bVar5.getItemCount(), editFunctionLayoutManager5.a(this, bVar5.getItemCount()));
        int i6 = R.id.rv5;
        ((RecyclerView) _$_findCachedViewById(i6)).setAdapter(bVar5);
        ((RecyclerView) _$_findCachedViewById(i6)).setLayoutManager(editFunctionLayoutManager5);
        ((RecyclerView) _$_findCachedViewById(i6)).addItemDecoration(gVar5);
        b bVar6 = new b();
        EditFunctionLayoutManager editFunctionLayoutManager6 = new EditFunctionLayoutManager(this, 0, false);
        h7 = j.h(0, 13);
        Iterator<Integer> it6 = h7.iterator();
        while (it6.hasNext()) {
            ((h0) it6).nextInt();
            bVar6.e().add(new a(R.drawable.ic_edit_item_test, R.string.test_long_name));
        }
        g gVar6 = new g();
        gVar6.a(this, bVar6.getItemCount(), editFunctionLayoutManager6.a(this, bVar6.getItemCount()));
        int i7 = R.id.rv6;
        ((RecyclerView) _$_findCachedViewById(i7)).setAdapter(bVar6);
        ((RecyclerView) _$_findCachedViewById(i7)).setLayoutManager(editFunctionLayoutManager6);
        ((RecyclerView) _$_findCachedViewById(i7)).addItemDecoration(gVar6);
    }
}
