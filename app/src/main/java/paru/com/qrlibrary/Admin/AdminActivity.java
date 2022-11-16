package paru.com.qrlibrary.Admin;

import androidx.appcompat.app.AppCompatActivity;
import paru.com.qrlibrary.MainActivity;
import paru.com.qrlibrary.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    TextView admincon;
    Button us,bk,add,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        admincon = findViewById(R.id.admincontrols);
        us = findViewById(R.id.usersButton);
        bk = findViewById(R.id.booksButton);
        add = findViewById(R.id.addbook);
        logout = findViewById(R.id.logout);

        us.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent =new Intent (AdminActivity.this, AdminActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        bk.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent =new Intent (AdminActivity.this, BooksActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        add.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent =new Intent (AdminActivity.this, AddBookActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        logout.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent =new Intent (AdminActivity.this, MainActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

    }
}