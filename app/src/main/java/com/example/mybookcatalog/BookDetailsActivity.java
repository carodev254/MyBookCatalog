package com.example.mybookcatalog;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Book book = (Book) getIntent().getSerializableExtra("book");

        if (book != null) {
            setTitle(""); // Title is shown in the card below

            ImageView imageView = findViewById(R.id.detailAuthorPhoto);
            TextView textViewTitle = findViewById(R.id.detailTitle);
            TextView textViewAuthor = findViewById(R.id.detailAuthor);
            TextView textViewGenre = findViewById(R.id.detailGenre);
            TextView textViewDescription = findViewById(R.id.detailDescription);

            imageView.setImageResource(book.getImageResId());
            textViewTitle.setText(book.getTitle());
            textViewAuthor.setText(getString(R.string.author_prefix, book.getAuthor()));
            textViewGenre.setText(getString(R.string.genre_prefix, book.getGenre()));
            textViewDescription.setText(book.getDescription());
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
