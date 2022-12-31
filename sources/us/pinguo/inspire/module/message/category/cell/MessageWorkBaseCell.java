package us.pinguo.inspire.module.message.category.cell;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Calendar;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.util.p;
import us.pinguo.inspire.util.s;
import us.pinguo.ui.uilview.GifImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public abstract class MessageWorkBaseCell extends us.pinguo.widget.common.cell.recycler.b<InspireMsg, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
    private int thumbnailSize;

    public MessageWorkBaseCell(InspireMsg inspireMsg) {
        super(inspireMsg);
        this.thumbnailSize = us.pinguo.foundation.t.b.a.a(Inspire.a(), 70.0f);
    }

    private void onBindEmotion(us.pinguo.widget.common.cell.recycler.c cVar) {
        GifImageView gifImageView = (GifImageView) cVar.getView(R.id.giv_emoticon_message_comment_cell);
        T t = this.mData;
        if (t != 0 && ((InspireMsg) t).data != null && ((InspireMsg) t).data.emoticon != null) {
            gifImageView.setVisibility(0);
            us.pinguo.inspire.util.emoticon.i.d(gifImageView, ((InspireMsg) this.mData).data.emoticon);
            return;
        }
        gifImageView.setVisibility(8);
    }

    private void onBindImgs(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        if (t != 0 && ((InspireMsg) t).data != null && !k.a(((InspireMsg) t).data.imgs)) {
            cVar.show(R.id.ll_imgs_message_comment_cell);
            int size = ((InspireMsg) this.mData).data.imgs.size();
            if (size > 0) {
                cVar.show(R.id.piv_first_pic_message_comment_cell);
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_first_pic_message_comment_cell, ((InspireMsg) this.mData).data.imgs.get(0).picUrl);
            } else {
                cVar.hide(R.id.piv_first_pic_message_comment_cell);
            }
            if (size > 1) {
                cVar.show(R.id.piv_second_pic_message_comment_cell);
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_second_pic_message_comment_cell, ((InspireMsg) this.mData).data.imgs.get(1).picUrl);
            } else {
                cVar.hide(R.id.piv_second_pic_message_comment_cell);
            }
            if (size > 2) {
                cVar.show(R.id.piv_third_pic_message_comment_cell);
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_third_pic_message_comment_cell, ((InspireMsg) this.mData).data.imgs.get(2).picUrl);
            } else {
                cVar.hide(R.id.piv_third_pic_message_comment_cell);
            }
            if (size > 3) {
                cVar.show(R.id.fl_forth_pic_message_comment_cell);
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_forth_pic_message_comment_cell, ((InspireMsg) this.mData).data.imgs.get(3).picUrl);
            } else {
                cVar.hide(R.id.fl_forth_pic_message_comment_cell);
            }
            if (size > 4) {
                cVar.show(R.id.v_cover_forth_pic_message_comment_cell);
                cVar.show(R.id.tv_count_pic_message_comment_cell);
                cVar.setText(R.id.tv_count_pic_message_comment_cell, String.format("+%d", Integer.valueOf(size - 3)));
                return;
            }
            cVar.hide(R.id.v_cover_forth_pic_message_comment_cell);
            cVar.hide(R.id.tv_count_pic_message_comment_cell);
            return;
        }
        cVar.hide(R.id.ll_imgs_message_comment_cell);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.message_comment_cell, viewGroup);
    }

    protected abstract void onBindOtherViews(us.pinguo.widget.common.cell.recycler.c cVar);

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        int i2;
        if (this.mData != 0) {
            PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.piv_sender_message_comment_cell);
            portraitImageView.setUserType(0);
            portraitImageView.setMark(0);
            cVar.setOnClickListener(R.id.ll_container_message_comment_cell, this);
            T t = this.mData;
            if (((InspireMsg) t).sender != null) {
                portraitImageView.setUserType(((InspireMsg) t).sender.type);
                portraitImageView.setMark(((InspireMsg) this.mData).sender.mark);
                T t2 = this.mData;
                if (((InspireMsg) t2).sender.name != null) {
                    cVar.setText(R.id.tv_sender_message_comment_cell, ((InspireMsg) t2).sender.name);
                    portraitImageView.setUserId(((InspireMsg) this.mData).sender.userId);
                    if (!TextUtils.isEmpty(((InspireMsg) this.mData).sender.avatar)) {
                        us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_sender_message_comment_cell, ((InspireMsg) this.mData).sender.avatar);
                    }
                }
            }
            TextView textView = (TextView) cVar.getView(R.id.tv_date_and_loc_message_comment_cell);
            if (((InspireMsg) this.mData).timeline != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                textView.setText(p.f(Inspire.a(), ((long) ((InspireMsg) this.mData).timeline) * 1000, Calendar.getInstance().getTimeInMillis()));
            }
            cVar.hide(R.id.iv_media_type_message_comment_cell);
            T t3 = this.mData;
            if (((InspireMsg) t3).data != null) {
                if (!TextUtils.isEmpty(((InspireMsg) t3).data.from)) {
                    String charSequence = textView.getText().toString();
                    if (!charSequence.isEmpty()) {
                        textView.setText(charSequence + " / " + ((InspireMsg) this.mData).data.from);
                    } else {
                        textView.setText(((InspireMsg) this.mData).data.from);
                    }
                }
                TextView textView2 = (TextView) cVar.getView(R.id.tv_content_message_comment_cell);
                T t4 = this.mData;
                if (((InspireMsg) t4).data.wStat == -1) {
                    textView2.setText(R.string.work_is_deleted);
                    textView2.setBackgroundResource(R.drawable.message_delete);
                    textView2.setTextColor(textView2.getResources().getColor(us.pinguo.ui.R.color.text_primary));
                } else if (((InspireMsg) t4).data.stat == -1) {
                    textView2.setText(R.string.comment_deleted);
                    textView2.setBackgroundResource(R.drawable.message_delete);
                    textView2.setTextColor(textView2.getResources().getColor(us.pinguo.ui.R.color.text_primary));
                } else {
                    textView2.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
                    textView2.setText("");
                    textView2.setTextColor(textView2.getResources().getColor(us.pinguo.ui.R.color.text_deeper));
                    us.pinguo.inspire.widget.j.b.f(textView2, ((InspireMsg) this.mData).data.content, us.pinguo.inspire.widget.j.b.f11361e);
                }
                if (TextUtils.isEmpty(textView2.getText().toString())) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                }
                PhotoImageView photoImageView = (PhotoImageView) cVar.getView(R.id.piv_photo_message_comment_cell);
                cVar.hide(R.id.iv_media_type_message_comment_cell);
                int a = s.a(((InspireMsg) this.mData).data.picNum);
                if (a != 0) {
                    cVar.show(R.id.iv_media_type_message_comment_cell);
                    cVar.setImageResource(R.id.iv_media_type_message_comment_cell, a);
                } else {
                    cVar.hide(R.id.iv_media_type_message_comment_cell);
                }
                if ("photo".equals(((InspireMsg) this.mData).data.media) && !TextUtils.isEmpty(((InspireMsg) this.mData).data.url)) {
                    us.pinguo.inspire.cell.recycler.f.d(cVar, R.id.piv_photo_message_comment_cell, ((InspireMsg) this.mData).data.url, 70, 70);
                } else if ("video".equals(((InspireMsg) this.mData).data.media) && !TextUtils.isEmpty(((InspireMsg) this.mData).data.url)) {
                    cVar.show(R.id.iv_media_type_message_comment_cell);
                    cVar.setImageResource(R.id.iv_media_type_message_comment_cell, R.drawable.video_icon);
                    int a2 = us.pinguo.foundation.t.b.a.a(cVar.itemView.getContext(), 70.0f);
                    T t5 = this.mData;
                    if (((InspireMsg) t5).data.width == 0 || ((InspireMsg) t5).data.height == 0) {
                        i2 = a2;
                    } else if (((InspireMsg) t5).data.height > ((InspireMsg) t5).data.width) {
                        i2 = (((InspireMsg) t5).data.height * a2) / ((InspireMsg) t5).data.width;
                    } else {
                        i2 = a2;
                        a2 = (((InspireMsg) t5).data.width * a2) / ((InspireMsg) t5).data.height;
                    }
                    photoImageView.setSize(a2, a2);
                    photoImageView.setImageSize(a2, i2);
                    if (!((InspireMsg) this.mData).data.url.contains("?vframe")) {
                        T t6 = this.mData;
                        String str = ((InspireMsg) t6).data.url;
                        int i3 = ((InspireMsg) t6).data.width;
                        int i4 = ((InspireMsg) t6).data.height;
                        int i5 = this.thumbnailSize;
                        photoImageView.setVideoImageUrl(str, i3, i4, i5, i5);
                    } else {
                        photoImageView.setVideoThumbnailUri(((InspireMsg) this.mData).data.url);
                    }
                }
            }
            onBindEmotion(cVar);
            onBindImgs(cVar);
            onBindOtherViews(cVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        T t = this.mData;
        if (t != 0 && ((InspireMsg) t).data != null && ((InspireMsg) t).data.wStat == -1) {
            j0.c(R.string.work_is_deleted);
        } else if (t == 0 || ((InspireMsg) t).data == null || ((InspireMsg) t).sender == null || TextUtils.isEmpty(((InspireMsg) t).data.mid) || TextUtils.isEmpty(((InspireMsg) this.mData).sender.userId)) {
        } else {
            Context context = view.getContext();
            T t2 = this.mData;
            FeedsList.enterDetailPage(context, ((InspireMsg) t2).data.mid, ((InspireMsg) t2).data.tid, null, "from_message", null, null);
        }
    }
}
