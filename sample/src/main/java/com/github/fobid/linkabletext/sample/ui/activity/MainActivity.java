package com.github.fobid.linkabletext.sample.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.github.fobid.linkabletext.sample.R;
import com.github.fobid.linkabletext.view.OnLinkClickListener;
import com.github.fobid.linkabletext.widget.LinkableTextView;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements OnLinkClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.a_main);

        LinkableTextView textView = (LinkableTextView) findViewById(android.R.id.text1);
        textView.setHighlightColor(Color.TRANSPARENT);

        String text = "https://github.com/fobidlim/linkable-text-android is #github #repository of linkable-text.\n" +
                "blog.jameslim.kr is my #blog.\n" +
                "You can contact me via #instagram @fobidlim or email.\n" +
                "Here is my email address. fobidlim@gmail.com\n" +
                "And 010-0000-0000 is my phone number.\n" +
                "Thank you.";
        textView.setText(text);
        textView.setOnLinkClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.a_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listview:
                startActivity(new Intent(this, ListViewActivity.class));
                return true;
            case R.id.menu_recyclerview:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                return true;
            default:
                return true;
        }
    }

    @Override
    public void onHashtagClick(String hashtag) {
        Toast.makeText(this, "Clicked hashtag is " + hashtag, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMentionClick(String mention) {
        Toast.makeText(this, "Clicked mention is " + mention, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailAddressClick(String email) {
        Toast.makeText(this, "Clicked email is " + email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWebUrlClick(String url) {
        Toast.makeText(this, "Clicked url is " + url, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPhoneClick(String phone) {
        Toast.makeText(this, "Clicked phone is " + phone, Toast.LENGTH_SHORT).show();
    }
}
