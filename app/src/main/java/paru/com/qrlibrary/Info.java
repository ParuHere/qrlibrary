package paru.com.qrlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

public class Info extends AppCompatActivity {

    ImageView imageView;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        imageView = findViewById(R.id.pic);
        textview = findViewById(R.id.info);
        String username = getIntent().getStringExtra("Username");
        String ProfilePic = getIntent().getStringExtra("ProfilePic");
        textview.setText(username);
        Picasso.get().load(ProfilePic).into(imageView);


    }
}