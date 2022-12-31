package us.pinguo.inspire.module.contact.cell;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.inspire.module.attention.AttentionItemCell;
import us.pinguo.inspire.module.contact.entry.AddressBookFriend;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.ui.uilview.CircleImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AddressBookItemCell extends us.pinguo.inspire.cell.recycler.e<AddressBookFriend, ItemHolder> {
    private static final String TAG = "AddressBookItemCell";

    /* loaded from: classes9.dex */
    public static class ItemHolder extends us.pinguo.widget.common.cell.recycler.c {
        public TextView addressName;
        public CircleImageView avatar;
        public AttentionButton mAttentionButton;
        public TextView userName;

        public ItemHolder(View view) {
            super(view);
            this.avatar = (CircleImageView) view.findViewById(R.id.piv_portrait_include_user);
            this.userName = (TextView) view.findViewById(R.id.tv_nickname_include_user);
            this.addressName = (TextView) view.findViewById(R.id.tv_second_line_include_user);
            this.mAttentionButton = (AttentionButton) view.findViewById(R.id.ab_attention_include_user);
        }
    }

    public AddressBookItemCell(AddressBookFriend addressBookFriend) {
        super(addressBookFriend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        T t = this.mData;
        if (((AddressBookFriend) t).user == null || TextUtils.isEmpty(((AddressBookFriend) t).user.userId)) {
            return;
        }
        AttentionItemCell.intentToGuestProfile(view, ((AddressBookFriend) this.mData).user.userId);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public ItemHolder createViewHolder(ViewGroup viewGroup) {
        return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_book_item_layout, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(ItemHolder itemHolder) {
        itemHolder.hide(R.id.tv_third_line_include_user);
        T t = this.mData;
        if (((AddressBookFriend) t).user != null) {
            itemHolder.avatar.setImageUri(((AddressBookFriend) t).user.avatar);
            itemHolder.userName.setText(((AddressBookFriend) this.mData).user.nickname);
            AttentionButton attentionButton = itemHolder.mAttentionButton;
            T t2 = this.mData;
            attentionButton.k(((AddressBookFriend) t2).user, false, ((AddressBookFriend) t2).user.userId, this);
        }
        itemHolder.addressName.setText(String.format(itemHolder.addressName.getContext().getString(R.string.address_book_name_head), ((AddressBookFriend) this.mData).name));
        itemHolder.avatar.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.cell.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBookItemCell.this.b(view);
            }
        });
    }
}
