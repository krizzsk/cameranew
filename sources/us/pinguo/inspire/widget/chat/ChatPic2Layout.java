package us.pinguo.inspire.widget.chat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.widget.chat.ChatPicLayout;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChatPic2Layout extends LinearLayout implements View.OnClickListener {
    private us.pinguo.widget.common.cell.recycler.a a;
    private Emoticon b;
    private ChatPicLayout.c c;

    /* renamed from: d  reason: collision with root package name */
    private int f11341d;

    /* renamed from: e  reason: collision with root package name */
    private ChatBottomLayout f11342e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f11343f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f11344g;

    /* renamed from: h  reason: collision with root package name */
    private View f11345h;

    /* renamed from: i  reason: collision with root package name */
    private PhotoImageView f11346i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends RecyclerView.ItemDecoration {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (ChatPic2Layout.this.f11343f.getChildAdapterPosition(view) == 0) {
                int i2 = this.a;
                rect.set(i2, 0, i2, 0);
                return;
            }
            rect.set(0, 0, this.a, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends com.nostra13.universalimageloader.core.k.c {
        final /* synthetic */ Emoticon a;

        b(Emoticon emoticon) {
            this.a = emoticon;
        }

        @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            super.onLoadingComplete(str, view, bitmap);
            ChatPic2Layout.this.r(this.a, ImageLoader.getInstance().m().get(this.a.picUrl).getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c extends d implements View.OnClickListener {
        public c(String str, ChatPic2Layout chatPic2Layout) {
            super(str, chatPic2Layout);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPic2Layout.d, us.pinguo.widget.common.cell.recycler.b
        public int getType() {
            return 1;
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPic2Layout.d, us.pinguo.widget.common.cell.recycler.b
        protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
            cVar.setImageResource(R.id.chat_pic_item_img, R.drawable.chat_pic_add);
            cVar.setVisible(R.id.chat_pic_item_del, 8);
            cVar.itemView.setOnClickListener(this);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPic2Layout.d, android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.o(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class d extends us.pinguo.widget.common.cell.recycler.b<String, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
        ChatPic2Layout a;

        public d(String str, ChatPic2Layout chatPic2Layout) {
            super(str);
            this.a = chatPic2Layout;
        }

        @Override // us.pinguo.widget.common.cell.recycler.b
        public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
            return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_pic_item_layout, viewGroup, false));
        }

        @Override // us.pinguo.widget.common.cell.recycler.b
        public int getType() {
            return 0;
        }

        @Override // us.pinguo.widget.common.cell.recycler.b
        protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
            ((PhotoImageView) cVar.getView(R.id.chat_pic_item_img)).setImageUri(InspirePublishFragment.FILE_HEADER + ((String) this.mData));
            cVar.setVisible(R.id.chat_pic_item_del, 0);
            cVar.setOnClickListener(R.id.chat_pic_item_del, this);
        }

        public void onClick(View view) {
            us.pinguo.widget.common.cell.recycler.a aVar = this.mAdapter;
            if (aVar != null) {
                aVar.remove((us.pinguo.widget.common.cell.recycler.a) this);
            }
            if (this.mAdapter.getItemCount() != 1 || !(this.mAdapter.getItem(0) instanceof c)) {
                this.a.e();
                return;
            }
            this.mAdapter.clear();
            this.a.k();
        }
    }

    public ChatPic2Layout(Context context) {
        super(context);
        this.f11341d = 8;
    }

    private void d(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int f2 = 9 - f();
        if (arrayList.size() > f2) {
            arrayList = new ArrayList<>(arrayList.subList(0, f2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(new d(arrayList.get(i2), this));
        }
        us.pinguo.widget.common.cell.recycler.a aVar = this.a;
        aVar.addAll(aVar.getItemCount() - 1, arrayList2);
        e();
        this.f11343f.setVisibility(0);
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        us.pinguo.widget.common.cell.recycler.a aVar = this.a;
        if (aVar == null || aVar.getItemCount() == 0) {
            return;
        }
        int f2 = f();
        us.pinguo.widget.common.cell.recycler.a aVar2 = this.a;
        boolean z = aVar2.getItem(aVar2.getItemCount() - 1) instanceof c;
        if (f2 >= 9 && z) {
            us.pinguo.widget.common.cell.recycler.a aVar3 = this.a;
            aVar3.remove(aVar3.getItemCount() - 1);
        } else if (f2 <= 0 || f2 >= 9 || z) {
        } else {
            this.a.add(new c(null, this));
        }
    }

    private int f() {
        us.pinguo.widget.common.cell.recycler.a aVar = this.a;
        if (aVar == null || aVar.getItemCount() == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.getItemCount(); i3++) {
            if (this.a.getItem(i3).getType() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private void l() {
        int a2 = us.pinguo.foundation.t.b.a.a(getContext(), 6.0f);
        this.f11343f.setClipChildren(false);
        this.f11343f.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f11343f.addItemDecoration(new a(a2));
        us.pinguo.widget.common.cell.recycler.a aVar = new us.pinguo.widget.common.cell.recycler.a();
        this.a = aVar;
        this.f11343f.setAdapter(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(boolean z, int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("photo_path_list");
            if (!k.a(stringArrayListExtra)) {
                if (z) {
                    d(stringArrayListExtra);
                } else {
                    setPics(stringArrayListExtra);
                }
                setVisibility(0);
                this.f11342e.showSoftInputAfterResume();
            } else if (this.a.getItemCount() == 0) {
                k();
            }
        }
    }

    private void p(Emoticon emoticon) {
        if (!TextUtils.isEmpty(emoticon.pic)) {
            this.f11346i.setLoadingColor(0);
            r(emoticon, emoticon.pic);
        } else if (TextUtils.isEmpty(emoticon.picUrl)) {
        } else {
            this.f11346i.setLoadingColor(0);
            this.f11346i.setSimpleImageLoadingListener(new b(emoticon));
            this.f11346i.setImageUri(emoticon.picUrl);
        }
    }

    private void q(Emoticon emoticon) {
        this.f11346i.setSimpleImageLoadingListener(null);
        if (!TextUtils.isEmpty(emoticon.pic)) {
            this.f11346i.setLoadingColor(0);
            PhotoImageView photoImageView = this.f11346i;
            photoImageView.setImageUri(InspirePublishFragment.FILE_HEADER + emoticon.pic);
        } else if (TextUtils.isEmpty(emoticon.picUrl)) {
        } else {
            this.f11346i.setLoadingColor(getResources().getColor(us.pinguo.ui.R.color.inspire_loading_color));
            this.f11346i.setImageUri(emoticon.picUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Emoticon emoticon, String str) {
        try {
            pl.droidsonroids.gif.c cVar = new pl.droidsonroids.gif.c(str);
            this.f11346i.setImageDrawable(cVar);
            cVar.start();
        } catch (IOException e2) {
            q(emoticon);
            us.pinguo.common.log.a.f(e2);
        }
    }

    private void t(Emoticon emoticon) {
        if (Emoticon.TYPE_GIF.equals(emoticon.type)) {
            p(emoticon);
        } else {
            q(emoticon);
        }
    }

    public Emoticon g() {
        return this.b;
    }

    public String[] h() {
        us.pinguo.widget.common.cell.recycler.a aVar = this.a;
        if (aVar == null || aVar.getItemCount() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.getItemCount(); i2++) {
            d dVar = (d) this.a.getItem(i2);
            if (!(dVar instanceof c)) {
                arrayList.add(dVar.getData());
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public boolean i() {
        us.pinguo.widget.common.cell.recycler.a aVar = this.a;
        return (aVar != null && aVar.getItemCount() > 0) || this.b != null;
    }

    public void j() {
        this.a.clear();
        this.b = null;
        this.f11343f.setVisibility(8);
        this.f11344g.setVisibility(8);
        setVisibility(8);
    }

    public void k() {
        this.a.clear();
        this.f11343f.setVisibility(8);
        if (this.f11344g.getVisibility() == 8) {
            setVisibility(8);
        }
    }

    public void o(final boolean z) {
        this.f11342e.hideSoftInput();
        Intent intent = new Intent();
        intent.setClassName(getContext(), "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_COUNT_LIMIT, 9 - f());
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 5);
        ((InspireRedirectActivity) getContext()).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.widget.chat.b
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                ChatPic2Layout.this.n(z, i2, intent2);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f11345h) {
            this.f11346i.cancelTask();
            this.f11346i.setImageDrawable(null);
            this.b = null;
            this.f11344g.setVisibility(8);
            if (this.f11343f.getVisibility() == 8) {
                setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f11343f = (RecyclerView) findViewById(R.id.chat_bottom_pic_recyclerview);
        this.f11344g = (ViewGroup) findViewById(R.id.chat_bottom_emoticon_layout);
        this.f11345h = findViewById(R.id.chat_bottom_emoticon_delete);
        PhotoImageView photoImageView = (PhotoImageView) findViewById(R.id.chat_bottom_emoticon_large);
        this.f11346i = photoImageView;
        photoImageView.setDisplayer(new us.pinguo.foundation.t.a.d());
        this.f11345h.setOnClickListener(this);
        l();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        ChatPicLayout.c cVar;
        super.onVisibilityChanged(view, i2);
        if (view == this) {
            if (this.f11341d != i2 && (cVar = this.c) != null) {
                us.pinguo.widget.common.cell.recycler.a aVar = this.a;
                cVar.onChatPicChange((aVar != null && aVar.getItemCount() > 0) || this.b != null);
            }
            this.f11341d = i2;
        }
    }

    public void s() {
        int f2 = f();
        if (f2 < 9) {
            o(f2 > 0);
        } else {
            j0.d(getContext().getString(R.string.comment_max_pic_count));
        }
    }

    public void setChatBottomLayout(ChatBottomLayout chatBottomLayout) {
        this.f11342e = chatBottomLayout;
    }

    public void setEmoticon(Emoticon emoticon) {
        this.b = emoticon;
        setVisibility(0);
        this.f11344g.setVisibility(0);
        t(emoticon);
    }

    public void setOnChatPicChange(ChatPicLayout.c cVar) {
        this.c = cVar;
    }

    public void setPics(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(new d(list.get(i2), this));
        }
        arrayList.add(new c(null, this));
        this.a.clear();
        this.a.addAll(arrayList);
        e();
        this.f11343f.setVisibility(0);
        setVisibility(0);
    }

    public ChatPic2Layout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11341d = 8;
    }

    public ChatPic2Layout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11341d = 8;
    }
}
