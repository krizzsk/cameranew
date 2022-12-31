package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;
import com.rockerhieu.emoji.R;
import com.rockerhieu.emoji.model.DelEmoticon;
import com.rockerhieu.emoji.model.Emoticon;
import com.rockerhieu.emoji.model.EmoticonPkg;
import com.rockerhieu.emoji.model.NullEmoticon;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class ExpressionPagerView extends LinearLayout {
    private Context a;
    private ExpressionTabLayout b;
    private ViewPager c;

    /* renamed from: d  reason: collision with root package name */
    private ExpressionPointLayout f7101d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<d> f7102e;

    /* renamed from: f  reason: collision with root package name */
    private com.rockerhieu.emoji.expression.c f7103f;

    /* renamed from: g  reason: collision with root package name */
    private List<View> f7104g;

    /* renamed from: h  reason: collision with root package name */
    private com.rockerhieu.emoji.expression.d f7105h;

    /* loaded from: classes9.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            e eVar = (e) ExpressionPagerView.this.f7103f.a(i2).getTag();
            ExpressionPagerView.this.b.d(eVar.a);
            if (eVar.c == 0) {
                ExpressionPagerView.this.f7101d.setVisibility(8);
                return;
            }
            ExpressionPagerView.this.f7101d.setVisibility(0);
            ExpressionPagerView.this.f7101d.a(eVar.b, eVar.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements AdapterView.OnItemClickListener {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Emoticon emoticon;
            if (ExpressionPagerView.this.f7105h == null || (emoticon = (Emoticon) this.a.get(i2)) == null || (emoticon instanceof NullEmoticon)) {
                return;
            }
            ExpressionPagerView.this.f7105h.onEmoticonClick(emoticon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements View.OnTouchListener {
        final /* synthetic */ GridView a;
        final /* synthetic */ com.rockerhieu.emoji.expression.b b;

        c(ExpressionPagerView expressionPagerView, GridView gridView, com.rockerhieu.emoji.expression.b bVar) {
            this.a = gridView;
            this.b = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int pointToPosition = this.a.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            return pointToPosition != -1 && this.b.getItem(pointToPosition) == null;
        }
    }

    public ExpressionPagerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7102e = new ArrayList<>();
    }

    private GridView g(List<Emoticon> list, FaceSize faceSize, boolean z) {
        ExpressionGridView expressionGridView = new ExpressionGridView(this, this.a) { // from class: com.rockerhieu.emoji.expression.ExpressionPagerView.2
            @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
            protected void onMeasure(int i2, int i3) {
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            }
        };
        expressionGridView.setBackgroundColor(getResources().getColor(R.color.expression_bg));
        expressionGridView.setPadding(faceSize.f7115j, faceSize.f7113h, faceSize.f7116k, faceSize.f7114i);
        expressionGridView.setNumColumns(faceSize.c);
        expressionGridView.setColumnWidth(faceSize.a);
        expressionGridView.setVerticalSpacing(faceSize.f7112g);
        expressionGridView.setHorizontalSpacing(faceSize.f7111f);
        expressionGridView.setStretchMode(2);
        try {
            Method method = expressionGridView.getClass().getMethod("setOverScrollMode", Integer.TYPE);
            method.setAccessible(true);
            method.invoke(expressionGridView, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.rockerhieu.emoji.expression.b bVar = new com.rockerhieu.emoji.expression.b(this.a, list, faceSize);
        expressionGridView.setAdapter((ListAdapter) bVar);
        expressionGridView.setSelector(new ColorDrawable(0));
        expressionGridView.setOnItemClickListener(new b(list));
        expressionGridView.setOnTouchListener(new c(this, expressionGridView, bVar));
        return expressionGridView;
    }

    private ArrayList<List<Emoticon>> h(d dVar) {
        int size;
        dVar.b.e((this.c.getMeasuredWidth() - this.c.getPaddingRight()) - this.c.getPaddingLeft(), (this.c.getMeasuredHeight() - this.c.getPaddingTop()) - this.c.getPaddingBottom());
        FaceSize faceSize = dVar.b;
        int i2 = faceSize.c;
        int i3 = faceSize.b;
        List list = dVar.c.emoticons;
        if (list == null) {
            list = new ArrayList();
        }
        ArrayList<List<Emoticon>> arrayList = new ArrayList<>();
        if (dVar.a != 0) {
            int i4 = (i2 * i3) - 1;
            size = list.size() / i4;
            if (list.size() % i4 == 0) {
                size--;
            }
        } else {
            int i5 = i2 * i3;
            size = list.size() / i5;
            if (list.size() % i5 > 0) {
                size++;
            }
        }
        if (dVar.a != 0) {
            size++;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = i2 * i3;
            ArrayList arrayList2 = new ArrayList(i8);
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    break;
                }
                if (dVar.a != 0 && i9 == i8 - 1) {
                    arrayList2.add(new DelEmoticon(dVar.a));
                    break;
                }
                if (i6 >= list.size()) {
                    arrayList2.add(new NullEmoticon());
                } else {
                    arrayList2.add((Emoticon) list.get(i6));
                }
                i6++;
                i9++;
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private void i(d dVar) {
        this.f7104g.add(dVar.f7106d);
        e eVar = new e(0, this.b.c(), 1);
        eVar.f7118d = dVar.c;
        dVar.f7106d.setTag(eVar);
        ExpressionTabLayout expressionTabLayout = this.b;
        EmoticonPkg emoticonPkg = dVar.c;
        expressionTabLayout.a(emoticonPkg.pkgBgUnSelected, emoticonPkg.pkgBgSelected);
        this.f7103f.notifyDataSetChanged();
    }

    private void j(d dVar) {
        ArrayList<List<Emoticon>> h2 = h(dVar);
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= h2.size()) {
                break;
            }
            List<Emoticon> list = h2.get(i2);
            FaceSize faceSize = dVar.b;
            if (dVar.a == 0) {
                z = false;
            }
            GridView g2 = g(list, faceSize, z);
            g2.setTag(new e(i2, this.b.c(), h2.size()));
            this.f7104g.add(g2);
            i2++;
        }
        if (h2.size() == 0) {
            GridView g3 = g(new ArrayList(), dVar.b, dVar.a != 0);
            g3.setTag(new e(0, this.b.c(), 1));
            this.f7104g.add(g3);
        }
        if (this.b.c() == 0) {
            this.f7101d.a(0, h2.size());
        }
        ExpressionTabLayout expressionTabLayout = this.b;
        EmoticonPkg emoticonPkg = dVar.c;
        expressionTabLayout.a(emoticonPkg.pkgBgUnSelected, emoticonPkg.pkgBgSelected);
        this.f7103f.notifyDataSetChanged();
    }

    public void e(EmoticonPkg emoticonPkg, View view) {
        this.f7102e.add(new d(this, emoticonPkg, view));
    }

    public void f(EmoticonPkg emoticonPkg, int i2, FaceSize faceSize) {
        this.f7102e.add(new d(this, emoticonPkg, faceSize, i2));
    }

    public void k(EmoticonPkg emoticonPkg, int i2, FaceSize faceSize) {
        String str;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f7104g.size()) {
                i3 = -1;
                break;
            }
            EmoticonPkg emoticonPkg2 = ((e) this.f7104g.get(i3).getTag()).f7118d;
            if (emoticonPkg2 != null && (str = emoticonPkg.pkgId) != null && str.equals(emoticonPkg2.pkgId)) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            return;
        }
        d dVar = new d(this, emoticonPkg, faceSize, i2);
        ArrayList<List<Emoticon>> h2 = h(dVar);
        this.f7104g.remove(i3);
        int i4 = i3;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= h2.size()) {
                break;
            }
            List<Emoticon> list = h2.get(i5);
            FaceSize faceSize2 = dVar.b;
            if (dVar.a == 0) {
                z = false;
            }
            GridView g2 = g(list, faceSize2, z);
            g2.setTag(new e(i5, i3, h2.size()));
            this.f7104g.add(i4, g2);
            i5++;
            i4++;
        }
        if (h2.size() == 0) {
            GridView g3 = g(new ArrayList(), dVar.b, dVar.a != 0);
            g3.setTag(new e(0, i3, 1));
            this.f7104g.add(i3, g3);
        }
        if (this.b.c() == 0) {
            this.f7101d.a(0, h2.size());
        }
        this.f7103f.notifyDataSetChanged();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<d> it = this.f7102e.iterator();
        while (it.hasNext()) {
            d next = it.next();
            EmoticonPkg emoticonPkg = next.c;
            if (emoticonPkg != null) {
                if (emoticonPkg.isOnline == 0) {
                    j(next);
                } else {
                    i(next);
                }
            }
        }
        this.f7102e.clear();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setWillNotDraw(false);
        this.a = getContext();
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.expression_layout, (ViewGroup) this, true);
        this.c = (ViewPager) inflate.findViewById(R.id.expression_viewpager);
        this.b = (ExpressionTabLayout) inflate.findViewById(R.id.expression_tab_layout);
        this.f7101d = (ExpressionPointLayout) inflate.findViewById(R.id.expression_points);
        this.b.e(this.c);
        ArrayList arrayList = new ArrayList();
        this.f7104g = arrayList;
        com.rockerhieu.emoji.expression.c cVar = new com.rockerhieu.emoji.expression.c(arrayList);
        this.f7103f = cVar;
        this.c.setAdapter(cVar);
        this.c.setOffscreenPageLimit(3);
        this.c.setOnPageChangeListener(new a());
    }

    public void setOnEmoticonClickListener(com.rockerhieu.emoji.expression.d dVar) {
        this.f7105h = dVar;
    }

    public ExpressionPagerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7102e = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d {
        int a;
        FaceSize b;
        EmoticonPkg c;

        /* renamed from: d  reason: collision with root package name */
        View f7106d;

        public d(ExpressionPagerView expressionPagerView, EmoticonPkg emoticonPkg, FaceSize faceSize, int i2) {
            this.c = emoticonPkg;
            this.b = faceSize;
            this.a = i2;
        }

        public d(ExpressionPagerView expressionPagerView, EmoticonPkg emoticonPkg, View view) {
            this.c = emoticonPkg;
            this.f7106d = view;
        }
    }
}
