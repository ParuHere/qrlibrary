package paru.com.qrlibrary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import paru.com.qrlibrary.Admin.AdminActivity;
import paru.com.qrlibrary.Models.users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button signin;
    private GoogleSignInClient client;
    FirebaseAuth auth;
    FirebaseDatabase database;
    // test Button
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin = findViewById(R.id.signin);
        auth = FirebaseAuth.getInstance();
        // test
        search = findViewById(R.id.search);
        // DATABASE LINK
        database = FirebaseDatabase.getInstance("https://qr-library-2d499-default-rtdb.firebaseio.com/");


        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(this,options);
        signin.setOnClickListener(new View.OnClickListener(){
                                      public void onClick(View v){
                                          Intent i =client.getSignInIntent();
                                          startActivityForResult(i, 123);
                                      }
                                  }
        );

        //test
        search.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent =new Intent (MainActivity.this, AdminActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 123){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account =task.getResult(ApiException.class);
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
                auth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if(task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            users users1 = new users();
                            assert user != null;
                            users1.setUserID(user.getUid());
                            users1.setUsername(user.getDisplayName());
                            users1.setEmail(user.getEmail());
                            users1.setProfilePic(user.getPhotoUrl().toString());
                            database.getReference().child("users").child(user.getUid()).setValue(users1);

                            Intent intent =new Intent (MainActivity.this, Info.class);
                            intent.putExtra("Username",user.getDisplayName());
                            intent.putExtra("ProfilePic",user.getPhotoUrl().toString());
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
            catch(ApiException e){
                e.printStackTrace();
            }
        }



    }
}