package us.pinguo.inspire.module.comment.cell;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspirePhoto;
import us.pinguo.inspire.module.attention.AttentionItemCell;
import us.pinguo.inspire.module.comment.InspireClickableSpan;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.comment.TranslateLayout;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.module.publish.InspirePublishTask;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.inspire.widget.j.b;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.ui.uilview.GifImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.user.s0;
import us.pinguo.widet.PortraitImageView;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class CommentItemCell extends us.pinguo.widget.common.cell.recycler.b<InspireComment, CommentHolder> implements us.pinguo.user.recycler.a, PhotoGridView.a, View.OnClickListener {
    public static final int TYPE_COMMENT = 1;
    private Context mContext;
    private boolean mFirst;
    private int mItemHeight;
    private OnItemClickListener mOnItemClickListener;
    public int mState;
    private View.OnClickListener onClickSinglePhotoListener;

    /* loaded from: classes9.dex */
    public static class CommentHolder extends us.pinguo.widget.common.cell.recycler.c {
        public PortraitImageView avatar;
        public View commentItem;
        public TextView commentItemTitle;
        public TextView descTv;
        public GifImageView emoticonGiv;
        public View menuIv;
        public TextView nameTv;
        public PhotoGridView photosPgv;
        public PhotoImageView singlePhotoPiv;
        public TextView stateTv;

        public CommentHolder(View view) {
            super(view);
            this.nameTv = (TextView) view.findViewById(R.id.user_name);
            this.descTv = (TextView) view.findViewById(R.id.comment_content);
            this.commentItem = view.findViewById(R.id.comment_item_layout);
            this.avatar = (PortraitImageView) view.findViewById(R.id.comment_item_avatar);
            this.stateTv = (TextView) view.findViewById(R.id.comment_state);
            this.commentItemTitle = (TextView) view.findViewById(R.id.comment_item_title);
            this.emoticonGiv = (GifImageView) view.findViewById(R.id.giv_emoticon_comment_item_layout);
            this.photosPgv = (PhotoGridView) view.findViewById(R.id.pgv_photos_comment_item_layout);
            PhotoImageView photoImageView = (PhotoImageView) view.findViewById(R.id.piv_single_photo_comment_item_layout);
            this.singlePhotoPiv = photoImageView;
            photoImageView.setImgCenterCrop(false);
            this.menuIv = view.findViewById(R.id.iv_menu_comment_item_layout);
        }
    }

    /* loaded from: classes9.dex */
    public interface OnItemClickListener {
        void onItemClick(InspireComment inspireComment);

        void onItemLongClick(InspireComment inspireComment);

        void onItemMenuClick(InspireComment inspireComment);
    }

    public CommentItemCell(InspireComment inspireComment) {
        super(inspireComment);
        this.onClickSinglePhotoListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentItemCell.this.n(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(InspireComment inspireComment, View view) {
        us.pinguo.common.log.a.m("zhouwei", "answer.......", new Object[0]);
        Intent intent = new Intent(view.getContext(), GuestProfileActivity.class);
        intent.putExtra(GuestProfileFragment.USER_ID, inspireComment.receiver.userId);
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(View view, us.pinguo.inspire.widget.j.b bVar, b.C0407b c0407b) {
        Intent intent = new Intent();
        if (f0.b(s0.getInstance().getUserId(), c0407b.a)) {
            intent.setClass(view.getContext(), ProfileActivity.class);
        } else {
            intent.setClass(view.getContext(), GuestProfileActivity.class);
            intent.putExtra(GuestProfileFragment.USER_ID, c0407b.a);
        }
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(InspireComment inspireComment, View view) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(inspireComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(InspireComment inspireComment, View view) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(inspireComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ boolean h(InspireComment inspireComment, View view) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemLongClick(inspireComment);
            return true;
        }
        return true;
    }

    public static SpannableString getAnswerCommentClickSpan(Context context, final InspireComment inspireComment) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentItemCell.a(InspireComment.this, view);
            }
        };
        String string = context.getString(R.string.comment_answer);
        String str = "@" + inspireComment.receiver.nickname;
        SpannableString spannableString = new SpannableString(string + " " + str + " :");
        int length = string.length();
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(str);
        spannableString.setSpan(new InspireClickableSpan(onClickListener, context), length, sb.toString().length() + 1, 33);
        return spannableString;
    }

    private void handleCommentList(CommentHolder commentHolder) {
        final InspireComment inspireComment = (InspireComment) this.mData;
        setStateText(commentHolder);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!inspireComment.isReply) {
            spannableStringBuilder.append((CharSequence) "");
        } else {
            spannableStringBuilder.append((CharSequence) getAnswerCommentClickSpan(this.mContext, inspireComment));
        }
        commentHolder.descTv.setClickable(true);
        commentHolder.descTv.setMovementMethod(LinkMovementMethod.getInstance());
        us.pinguo.inspire.widget.j.b.f(commentHolder.descTv, ((InspireComment) this.mData).content.text, e.a);
        spannableStringBuilder.append(commentHolder.descTv.getText());
        commentHolder.descTv.setText(spannableStringBuilder);
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            commentHolder.descTv.setVisibility(8);
        } else {
            commentHolder.descTv.setVisibility(0);
        }
        commentHolder.nameTv.setText(inspireComment.sender.nickname);
        commentHolder.avatar.setImageUri(inspireComment.sender.avatar, us.pinguo.ui.R.drawable.default_avatar);
        commentHolder.avatar.setUserId(inspireComment.sender.userId);
        commentHolder.avatar.setUserType(inspireComment.sender.type);
        commentHolder.avatar.setMark(inspireComment.sender.mark);
        commentHolder.descTv.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentItemCell.this.d(inspireComment, view);
            }
        });
        commentHolder.commentItem.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentItemCell.this.f(inspireComment, view);
            }
        });
        commentHolder.commentItem.setOnLongClickListener(new View.OnLongClickListener() { // from class: us.pinguo.inspire.module.comment.cell.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return CommentItemCell.this.h(inspireComment, view);
            }
        });
        commentHolder.avatar.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentItemCell.this.j(view);
            }
        });
        commentHolder.menuIv.setOnClickListener(this);
    }

    private void handleDivider(CommentHolder commentHolder) {
        if (this.mFirst) {
            commentHolder.hide(R.id.comment_divider);
        } else {
            commentHolder.show(R.id.comment_divider);
        }
    }

    private void handleEmoticon(CommentHolder commentHolder) {
        T t = this.mData;
        if (((InspireComment) t).content.emoticon != null && !TextUtils.isEmpty(((InspireComment) t).content.emoticon.emoticonId)) {
            commentHolder.emoticonGiv.setVisibility(0);
            us.pinguo.inspire.util.emoticon.i.d(commentHolder.emoticonGiv, ((InspireComment) this.mData).content.emoticon);
            return;
        }
        commentHolder.emoticonGiv.setVisibility(8);
    }

    private void handlePhoto(CommentHolder commentHolder) {
        T t = this.mData;
        if (((InspireComment) t).content != null && !us.pinguo.foundation.utils.k.a(((InspireComment) t).content.imgs)) {
            int i2 = 0;
            if (((InspireComment) this.mData).content.imgs.size() == 1) {
                commentHolder.photosPgv.setVisibility(8);
                commentHolder.singlePhotoPiv.setVisibility(0);
                commentHolder.singlePhotoPiv.setOnClickListener(this.onClickSinglePhotoListener);
                commentHolder.singlePhotoPiv.setImageUri(((InspireComment) this.mData).content.imgs.get(0).picUrl);
                return;
            }
            commentHolder.photosPgv.setVisibility(0);
            commentHolder.singlePhotoPiv.setVisibility(8);
            commentHolder.photosPgv.setOnItemClick(this);
            PhotoGridView.b[] bVarArr = new PhotoGridView.b[((InspireComment) this.mData).content.imgs.size()];
            for (InspirePhoto inspirePhoto : ((InspireComment) this.mData).content.imgs) {
                bVarArr[i2] = new PhotoGridView.b(inspirePhoto.width, inspirePhoto.height, inspirePhoto.picUrl);
                i2++;
            }
            commentHolder.photosPgv.setPhotos(bVarArr, 100);
            return;
        }
        commentHolder.photosPgv.setVisibility(8);
        commentHolder.singlePhotoPiv.setVisibility(8);
    }

    private void handleTranslate(CommentHolder commentHolder) {
        TranslateLayout translateLayout = (TranslateLayout) commentHolder.getView(R.id.translate_layout);
        if (((InspireComment) this.mData).needTranslate()) {
            T t = this.mData;
            if (((InspireComment) t).content != null && !TextUtils.isEmpty(((InspireComment) t).content.text)) {
                translateLayout.reset();
                translateLayout.setVisibility(0);
                T t2 = this.mData;
                translateLayout.initData(((InspireComment) t2).commentId, "comment", ((InspireComment) t2).content == null ? null : ((InspireComment) t2).content.lang);
                int color = translateLayout.getResources().getColor(us.pinguo.ui.R.color.text_white);
                ((TextView) translateLayout.findViewById(R.id.translate_btn)).setTextColor(color);
                ((TextView) translateLayout.findViewById(R.id.translate_content)).setTextColor(color);
            }
        }
        translateLayout.setVisibility(8);
        int color2 = translateLayout.getResources().getColor(us.pinguo.ui.R.color.text_white);
        ((TextView) translateLayout.findViewById(R.id.translate_btn)).setTextColor(color2);
        ((TextView) translateLayout.findViewById(R.id.translate_content)).setTextColor(color2);
    }

    private void handleUploadFailed(CommentHolder commentHolder) {
        commentHolder.stateTv.setText(R.string.comment_failed);
        commentHolder.stateTv.setTextColor(-10053940);
        commentHolder.stateTv.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentItemCell.this.l(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(View view) {
        AttentionItemCell.intentToGuestProfile(view, ((InspireComment) this.mData).sender.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(View view) {
        reUpload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(View view) {
        Bitmap a;
        final PhotoImageView photoImageView = (PhotoImageView) view;
        Bitmap[] bitmapArr = (!(photoImageView.getDrawable() instanceof us.pinguo.foundation.t.a.g) || (a = ((us.pinguo.foundation.t.a.g) photoImageView.getDrawable()).a()) == null) ? null : new Bitmap[]{a};
        Rect rect = new Rect();
        int[] iArr = new int[2];
        photoImageView.getLocationInWindow(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + photoImageView.getWidth(), iArr[1] + photoImageView.getHeight());
        ArrayList arrayList = new ArrayList();
        FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
        fullScreenPhoto.rect = rect;
        InspirePhoto inspirePhoto = ((InspireComment) this.mData).content.imgs.get(0);
        fullScreenPhoto.photo = new InspireFeedPhoto(null, inspirePhoto.picUrl, inspirePhoto.width, inspirePhoto.height);
        arrayList.add(fullScreenPhoto);
        PictureViewPagerDialogFragment.showFullScreenPics(((FragmentActivity) view.getContext()).getSupportFragmentManager(), bitmapArr, arrayList, 0, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.comment.cell.CommentItemCell.2
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i2) {
                Rect rect2 = new Rect();
                int[] iArr2 = new int[2];
                photoImageView.getLocationInWindow(iArr2);
                rect2.set(iArr2[0], iArr2[1], iArr2[0] + photoImageView.getWidth(), iArr2[1] + photoImageView.getHeight());
                return rect2;
            }
        });
    }

    private void reUpload() {
        T t = this.mData;
        if (t == 0 || ((InspireComment) t).publishData == null) {
            return;
        }
        new InspirePublishTask().publishComment(((InspireComment) this.mData).publishData);
    }

    private void setStateText(CommentHolder commentHolder) {
        int i2;
        if (this.mData == 0 || commentHolder == null) {
            return;
        }
        commentHolder.stateTv.setOnClickListener(null);
        String f2 = us.pinguo.inspire.util.p.f(Inspire.a(), ((InspireComment) this.mData).createTime * 1000, System.currentTimeMillis());
        TextView textView = commentHolder.stateTv;
        textView.setTextColor(textView.getResources().getColor(us.pinguo.ui.R.color.text_white));
        if (!TextUtils.isEmpty(((InspireComment) this.mData).clientId) && (i2 = this.mState) != 4) {
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    handleUploadFailed(commentHolder);
                    return;
                } else if (i2 != 3) {
                    return;
                }
            }
            commentHolder.stateTv.setText(R.string.sending);
            return;
        }
        commentHolder.stateTv.setText(f2);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return super.getDiffMode();
    }

    public int getItemHeight() {
        return this.mItemHeight;
    }

    public int getState() {
        return this.mState;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClickListener onItemClickListener;
        if (view.getId() != R.id.iv_menu_comment_item_layout || (onItemClickListener = this.mOnItemClickListener) == null) {
            return;
        }
        onItemClickListener.onItemMenuClick((InspireComment) this.mData);
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView.a
    public void onItemClick(final PhotoGridView photoGridView, int i2) {
        ArrayList arrayList = new ArrayList(((InspireComment) this.mData).content.imgs);
        int size = arrayList.size();
        if (size > 9) {
            size = 9;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            InspirePhoto inspirePhoto = (InspirePhoto) arrayList.get(i3);
            InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto(null, inspirePhoto.picUrl, inspirePhoto.width, inspirePhoto.height);
            FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
            fullScreenPhoto.photo = inspireFeedPhoto;
            fullScreenPhoto.rect = photoGridView.getItemBoundsInWindow(i3);
            arrayList2.add(fullScreenPhoto);
        }
        PictureViewPagerDialogFragment.showFullScreenPics(((FragmentActivity) photoGridView.getContext()).getSupportFragmentManager(), photoGridView.getBitmaps(), arrayList2, i2, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.comment.cell.CommentItemCell.3
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i4) {
                return photoGridView.getItemBoundsInWindow(i4);
            }
        });
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, 0);
        return true;
    }

    public void setFirst(boolean z) {
        this.mFirst = z;
        VH vh = this.mViewHolder;
        if (vh != 0) {
            handleDivider((CommentHolder) vh);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void updateCommentCount() {
    }

    public void updateState(int i2) {
        this.mState = i2;
        setStateText((CommentHolder) this.mViewHolder);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public CommentHolder createViewHolder(ViewGroup viewGroup) {
        return new CommentHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_item_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(CommentHolder commentHolder) {
        this.mContext = commentHolder.avatar.getContext();
        handleDivider(commentHolder);
        handleCommentList(commentHolder);
        handleTranslate(commentHolder);
        handleEmoticon(commentHolder);
        handlePhoto(commentHolder);
        commentHolder.itemView.post(new Runnable() { // from class: us.pinguo.inspire.module.comment.cell.CommentItemCell.1
            @Override // java.lang.Runnable
            public void run() {
                CommentItemCell commentItemCell = CommentItemCell.this;
                VH vh = commentItemCell.mViewHolder;
                if (vh == 0 || ((CommentHolder) vh).itemView == null) {
                    return;
                }
                commentItemCell.mItemHeight = ((CommentHolder) vh).itemView.getHeight();
            }
        });
    }
}
