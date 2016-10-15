package com.example.leonwang.demo_google1003.Dtos;


import android.os.Parcel;
import android.os.Parcelable;

public class UserDTO implements Parcelable {

    private int u_Id;
    private String u_Name;
    private String u_Password;
    private String u_Email;
    private int u_IsOnLine;
    private byte[] u_Selfie;
    private String u_Gender;
    private int u_Age;
    private String u_Mobile;

    public UserDTO() {
        this.u_Id = 0;
        this.u_Name = " ";
        this.u_Password = " ";
        this.u_Email = " ";
        this.u_IsOnLine = 2;
        this.u_Selfie = null;
        this.u_Gender = " ";
        this.u_Age = 0;
        this.u_Mobile = " ";
    }

    public void setU_Id(int u_Id) {
        this.u_Id = u_Id;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    public void setU_Email(String u_Email) {
        this.u_Email = u_Email;
    }

    public void setU_IsOnLine(int u_IsOnLine) {
        this.u_IsOnLine = u_IsOnLine;
    }

    public void setU_Selfie(byte[] u_Selfie) {
        this.u_Selfie = u_Selfie;
    }

    public void setU_Gender(String u_Gender) {
        this.u_Gender = u_Gender;
    }

    public void setU_Age(int u_Age) {
        this.u_Age = u_Age;
    }

    public void setU_Mobile(String u_Mobile) {
        this.u_Mobile = u_Mobile;
    }

    public int getU_Id() {
        return this.u_Id;
    }

    public String getU_Name() {
        return u_Name;
    }

    public String getU_Password() {
        return this.u_Password;
    }

    public String getU_Email() {
        return u_Email;
    }

    public int getU_IsOnLine() {
        return u_IsOnLine;
    }

    public byte[] getU_Selfie() {
        return u_Selfie;
    }

    public String getU_Gender() {
        return u_Gender;
    }

    public int getU_Age() {
        return u_Age;
    }

    public String getU_Mobile() {
        return u_Mobile;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(u_Id);
        parcel.writeString(u_Name);
        parcel.writeString(u_Password);
        parcel.writeString(u_Email);
        parcel.writeInt(u_IsOnLine);
        // parcel.writeByteArray(u_Selfie);
        parcel.writeString(u_Gender);
        parcel.writeInt(u_Age);
        parcel.writeString(u_Mobile);
    }

    public static final Parcelable.Creator<UserDTO> CREATOR = new Parcelable.Creator<UserDTO>() {
        // 将Parcel对象反序列化
        public UserDTO createFromParcel(Parcel source) {
            UserDTO createdUser = new UserDTO();
            createdUser.setU_Id(source.readInt());
            createdUser.setU_Name(source.readString());
            createdUser.setU_Password(source.readString());
            createdUser.setU_Email(source.readString());
            createdUser.setU_IsOnLine(source.readInt());

            //createdUser.setU_Selfie(source.readByteArray(u_Selfie));
            createdUser.setU_Gender(source.readString());
            createdUser.setU_Age(source.readInt());
            createdUser.setU_Mobile(source.readString());
            return createdUser;
        }

        public UserDTO[] newArray(int size) {
            return new UserDTO[size];
        }
    };

}
