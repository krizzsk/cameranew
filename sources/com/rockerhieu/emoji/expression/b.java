package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.rockerhieu.emoji.model.DelEmoticon;
import com.rockerhieu.emoji.model.Emoticon;
import com.rockerhieu.emoji.model.NullEmoticon;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: ExpressionGridAdapter.java */
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private Context a;
    private FaceSize b;
    private ArrayList<Emoticon> c;

    public b(Context context, List<Emoticon> list, FaceSize faceSize) {
        ArrayList<Emoticon> arrayList = new ArrayList<>();
        this.c = arrayList;
        this.a = context;
        this.b = faceSize;
        arrayList.addAll(list);
    }

    private void a(Emoticon emoticon, SimpleDraweeView simpleDraweeView) {
        try {
            if (emoticon instanceof DelEmoticon) {
                simpleDraweeView.setActualImageResource(((DelEmoticon) emoticon).delResId);
            } else if (emoticon instanceof NullEmoticon) {
                simpleDraweeView.setImageURI((String) null);
            } else if (!TextUtils.isEmpty(emoticon.cover)) {
                simpleDraweeView.setImageURI(Uri.parse(InspirePublishFragment.FILE_HEADER + emoticon.cover), (Object) null);
            } else if (TextUtils.isEmpty(emoticon.coverUrl)) {
            } else {
                simpleDraweeView.setImageURI(Uri.parse(emoticon.coverUrl));
            }
        } catch (OutOfMemoryError e2) {
            simpleDraweeView.setImageBitmap(null);
            e2.printStackTrace();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.c.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        SimpleDraweeView simpleDraweeView;
        if (view == null) {
            TypedArray obtainStyledAttributes = this.a.getTheme().obtainStyledAttributes(new int[]{16843868});
            simpleDraweeView = new SimpleDraweeView(this.a);
            int i3 = this.b.a;
            simpleDraweeView.setLayoutParams(new AbsListView.LayoutParams(i3, i3));
            simpleDraweeView.setBackground(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        } else {
            simpleDraweeView = (SimpleDraweeView) view;
        }
        a(this.c.get(i2), simpleDraweeView);
        return simpleDraweeView;
    }
}
