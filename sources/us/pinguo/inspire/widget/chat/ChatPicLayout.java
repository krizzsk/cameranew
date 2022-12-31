package us.pinguo.inspire.widget.chat;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rockerhieu.emoji.model.Emoticon;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChatPicLayout extends RecyclerView {
    private us.pinguo.widget.common.cell.recycler.a a;
    private Emoticon b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private int f11347d;

    /* renamed from: e  reason: collision with root package name */
    private ChatBottomLayout f11348e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends d implements View.OnClickListener {
        public a(String str, ChatPicLayout chatPicLayout) {
            super(str, chatPicLayout);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, us.pinguo.widget.common.cell.recycler.b
        public int getType() {
            return 1;
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, us.pinguo.widget.common.cell.recycler.b
        protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
            cVar.setImageResource(R.id.chat_pic_item_img, R.drawable.chat_pic_add);
            cVar.setVisible(R.id.chat_pic_item_del, 8);
            cVar.itemView.setOnClickListener(this);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.j(true);
        }
    }

    /* loaded from: classes9.dex */
    private static class b extends d implements View.OnClickListener {
        private Emoticon b;

        public b(Emoticon emoticon, ChatPicLayout chatPicLayout) {
            super(null, chatPicLayout);
            this.b = emoticon;
        }

        public void a(Emoticon emoticon) {
            this.b = emoticon;
            us.pinguo.widget.common.cell.recycler.c cVar = this.mViewHolder;
            if (cVar != null) {
                onBindViewHolder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.widget.common.cell.recycler.b
        public us.pinguo.widget.common.cell.recycler.c createHolderByLayout(int i2, ViewGroup viewGroup) {
            return super.createHolderByLayout(i2, viewGroup);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, us.pinguo.widget.common.cell.recycler.b
        public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
            return createHolderByLayout(R.layout.chat_emoticon_item_layout, viewGroup);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, us.pinguo.widget.common.cell.recycler.b
        public int getType() {
            return 2;
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, us.pinguo.widget.common.cell.recycler.b
        protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
            String str;
            if (TextUtils.isEmpty(this.b.cover)) {
                str = this.b.coverUrl;
            } else {
                str = InspirePublishFragment.FILE_HEADER + this.b.cover;
            }
            f.c(cVar, R.id.chat_pic_item_img, str);
            cVar.setVisible(R.id.chat_pic_item_del, 0);
            cVar.setOnClickListener(R.id.chat_pic_item_del, this);
        }

        @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.d, android.view.View.OnClickListener
        public void onClick(View view) {
            us.pinguo.widget.common.cell.recycler.a aVar = this.mAdapter;
            if (aVar != null) {
                aVar.remove((us.pinguo.widget.common.cell.recycler.a) this);
            }
            if (this.mAdapter.getItemCount() == 1 && (this.mAdapter.getItem(0) instanceof a)) {
                this.mAdapter.clear();
                this.a.g();
            }
            this.a.b = null;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void onChatPicChange(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class d extends us.pinguo.widget.common.cell.recycler.b<String, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
        ChatPicLayout a;

        public d(String str, ChatPicLayout chatPicLayout) {
            super(str);
            this.a = chatPicLayout;
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
            f.c(cVar, R.id.chat_pic_item_img, InspirePublishFragment.FILE_HEADER + ((String) this.mData));
            cVar.setVisible(R.id.chat_pic_item_del, 0);
            cVar.setOnClickListener(R.id.chat_pic_item_del, this);
        }

        public void onClick(View view) {
            us.pinguo.widget.common.cell.recycler.a aVar = this.mAdapter;
            if (aVar != null) {
                aVar.remove((us.pinguo.widget.common.cell.recycler.a) this);
            }
            if (this.mAdapter.getItemCount() != 1 || !(this.mAdapter.getItem(0) instanceof a)) {
                this.a.e();
                return;
            }
            this.mAdapter.clear();
            this.a.g();
        }
    }

    public ChatPicLayout(Context context) {
        super(context);
        this.f11347d = 8;
        init();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        us.pinguo.widget.common.cell.recycler.a aVar = this.a;
        if (aVar == null || aVar.getItemCount() == 0) {
            return;
        }
        int f2 = f();
        us.pinguo.widget.common.cell.recycler.a aVar2 = this.a;
        boolean z = aVar2.getItem(aVar2.getItemCount() - 1) instanceof a;
        if (f2 >= 9 && z) {
            us.pinguo.widget.common.cell.recycler.a aVar3 = this.a;
            aVar3.remove(aVar3.getItemCount() - 1);
        } else if (f2 <= 0 || f2 >= 9 || z) {
        } else {
            this.a.add(new a(null, this));
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(boolean z, int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("photo_path_list");
            if (!k.a(stringArrayListExtra)) {
                if (z) {
                    d(stringArrayListExtra);
                } else {
                    setPics(stringArrayListExtra);
                }
                setVisibility(0);
                this.f11348e.showSoftInputAfterResume();
            } else if (this.a.getItemCount() == 0) {
                g();
            }
        }
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        us.pinguo.widget.common.cell.recycler.a aVar = new us.pinguo.widget.common.cell.recycler.a();
        this.a = aVar;
        setAdapter(aVar);
    }

    public void g() {
        this.b = null;
        this.a.clear();
        setVisibility(8);
    }

    public void j(final boolean z) {
        Intent intent = new Intent();
        intent.setClassName(getContext(), "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_COUNT_LIMIT, 9 - f());
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 5);
        ((InspireRedirectActivity) getContext()).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.widget.chat.c
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                ChatPicLayout.this.i(z, i2, intent2);
            }
        });
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        c cVar;
        super.onVisibilityChanged(view, i2);
        if (view == this) {
            if (this.f11347d != i2 && (cVar = this.c) != null) {
                us.pinguo.widget.common.cell.recycler.a aVar = this.a;
                cVar.onChatPicChange(aVar != null && aVar.getItemCount() > 0);
            }
            this.f11347d = i2;
        }
    }

    public void setChatBottomLayout(ChatBottomLayout chatBottomLayout) {
        this.f11348e = chatBottomLayout;
    }

    public void setEmoticon(Emoticon emoticon) {
        if (this.a.getItem(0) instanceof b) {
            this.b = emoticon;
            ((b) this.a.getItem(0)).a(emoticon);
            return;
        }
        this.b = emoticon;
        this.a.add(0, new b(emoticon, this));
        if (this.a.getItemCount() == 1) {
            this.a.add(new a(null, this));
        }
        setVisibility(0);
    }

    public void setOnChatPicChange(c cVar) {
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
        if (this.b != null) {
            this.a.addAll(1, arrayList);
        } else {
            arrayList.add(new a(null, this));
            this.a.set(arrayList);
        }
        e();
    }

    public ChatPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11347d = 8;
        init();
    }

    public ChatPicLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11347d = 8;
        init();
    }
}
