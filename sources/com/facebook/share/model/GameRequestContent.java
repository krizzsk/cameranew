package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new a();
    private final ActionType actionType;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;

    /* loaded from: classes.dex */
    public enum ActionType {
        SEND,
        ASKFOR,
        TURN
    }

    /* loaded from: classes.dex */
    public enum Filters {
        APP_USERS,
        APP_NON_USERS
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<GameRequestContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GameRequestContent[] newArray(int i2) {
            return new GameRequestContent[i2];
        }
    }

    GameRequestContent(Parcel parcel) {
        this.message = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        this.suggestions = createStringArrayList;
        parcel.readStringList(createStringArrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.message);
        parcel.writeStringList(this.recipients);
        parcel.writeString(this.title);
        parcel.writeString(this.data);
        parcel.writeSerializable(this.actionType);
        parcel.writeString(this.objectId);
        parcel.writeSerializable(this.filters);
        parcel.writeStringList(this.suggestions);
    }
}
