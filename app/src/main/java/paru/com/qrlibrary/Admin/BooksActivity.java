package paru.com.qrlibrary.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import paru.com.qrlibrary.Models.books;
import paru.com.qrlibrary.R;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

public class BooksActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        recyclerView = findViewById(R.id.recycview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<books> options =
                new FirebaseRecyclerOptions.Builder<books>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), books.class)
                        .build();

    }
}