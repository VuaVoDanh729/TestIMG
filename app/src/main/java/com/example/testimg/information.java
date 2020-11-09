package com.example.testimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class information extends AppCompatActivity {

    ImageView avatar;
    EditText inputName;
    private static int possIMG = 0;

    ArrayList<Integer> listImg;
    ImageView buttonLeft, buttonRight;
    Player[] playerInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().hide();
        setUp();
    }



    // Lấy thông tin Player tương ứng để display lên màn hình
    private void settingScreenInformation(Player player) {
        inputName.setText(player.getName());
        avatar.setImageResource(player.getImgId());
        possIMG = player.getPositionImgInList();
    }

    void setUp() {
        avatar = findViewById(R.id.avatar);
        inputName = findViewById(R.id.name);
        listImg = getListAvatar();
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonRight = findViewById(R.id.buttonRight);
        buttonLeft.setImageResource(listImg.get(possIMG));
        avatar.setImageResource(listImg.get(possIMG + 1));
        buttonRight.setImageResource(listImg.get(possIMG + 2));

    }

    // Lấy List IDsouce các ảnh. Tên ảnh được lưu trong values/String.xml
    private ArrayList<Integer> getListAvatar() {
        ArrayList<Integer> listAvt = new ArrayList<>();
        String[] imgAvt = getResources().getStringArray(R.array.list_name);
        for (int i = 0; i < imgAvt.length; i++) {
            int idImg = getResources().getIdentifier(imgAvt[i], "drawable", getPackageName());
            listAvt.add(idImg);
        }
        return listAvt;
    }

    void setImage(ImageView view, int possition, char x){

    }
    public void onClickSave(View view) {
        // Phía trên, lưu thông tin qua sự kiện click vào Radio -> nếu player đổi thông tin mà không click vào radio thì Infor sẽ khoongn đc lưu
        // trước khi Save, lấy thoongtin màn hình hiện tại lưu vào Player  tương ứng

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("player1", playerInfor[0]);
        intent.putExtra("player2", playerInfor[1]);
        startActivity(intent);
    }


    public void imgNextOnclick(View view) {
        possIMG =possIMG== listImg.size()?0: possIMG+1;
    }

    public void imgPreOnclick(View view) {
        possIMG = possIMG==0?listImg.size() -1: possIMG-1;
    }
}