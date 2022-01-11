package ru.gb.switchtheme;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.SQLInput;

public class Storage implements Parcelable {   // comment for pull request
    private String display1 = "";
    private String display2 = "";
    public Storage() {
        this.display1 = display1;
        this.display2 = display2;
    }

    protected Storage(Parcel in) {
        display1 = in.readString();
        display2 = in.readString();
    }

    public static final Creator<Storage> CREATOR = new Creator<Storage>() {
        @Override
        public Storage createFromParcel(Parcel in) {
            return new Storage(in);
        }

        @Override
        public Storage[] newArray(int size) {
            return new Storage[size];
        }
    };

    public String getDisplay1() {
        return display1;
    }

    public void setDisplay1(String display1) {
        this.display1 = display1;
    }

    public String getDisplay2() {
        return display2;
    }

    public void setDisplay2(String display2) {
        this.display2 = display2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(display1);
        parcel.writeString(display2);
    }
}
