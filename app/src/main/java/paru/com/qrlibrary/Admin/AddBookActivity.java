package paru.com.qrlibrary.Admin;

import androidx.appcompat.app.AppCompatActivity;
import paru.com.qrlibrary.Models.books;
import paru.com.qrlibrary.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.FirebaseDatabase;




public class AddBookActivity extends AppCompatActivity {

    FirebaseDatabase database;
    EditText bookname,author,edition,isbn,copies;
    TextView bk,au,ed,is,cop;
    String Bookname,Author,Edition,Isbn;
    int Copies;
    Button addbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        database = FirebaseDatabase.getInstance("https://qr-library-2d499-default-rtdb.firebaseio.com/");

        bookname = findViewById(R.id.bookname);
        author = findViewById(R.id.author);
        edition=findViewById(R.id.edition);
        isbn = findViewById(R.id.isbn);
        copies = findViewById(R.id.copies);

        bk =findViewById(R.id.bk);
        au = findViewById(R.id.aut);
        ed = findViewById(R.id.edi);
        is = findViewById(R.id.isb);
        cop = findViewById(R.id.copi);

        addbook = findViewById(R.id.addbookbutton);
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   assign();
                    clear();
                   addBook();
                    Toast.makeText(AddBookActivity.this, "Book Added ",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void assign()
    {
        Bookname = bookname.getText().toString();
        Author = author.getText().toString();
        Edition = edition.getText().toString();
        Isbn = isbn.getText().toString();
        Copies = Integer.parseInt((copies.getText().toString().trim()));

    }

    public void addBook()
    {
        books book = new books();
        book.setName(Bookname);
        book.setAuthor(Author);
        book.setEdition(Edition);
        book.setIsbn(Isbn);
        book.setCopies(Copies);
        database.getReference().child("books").child(book.getIsbn()).setValue(book);
    }

    public void clear() {

        bookname.setText("");
        author.setText("");
        edition.setText("");
        isbn.setText("");
        copies.setText("");
    }
}