package com.ninep.discordlite;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends Activity {
    private static final String DISCORD_URL = "https://discord.com/app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private void showHome() {
        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER);
        page.setPadding(28, 32, 28, 32);
        page.setBackgroundColor(Color.rgb(25, 26, 31));

        TextView logo = new TextView(this);
        logo.setText("9p");
        logo.setTextColor(Color.WHITE);
        logo.setTextSize(44);
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(null, 1);

        TextView title = new TextView(this);
        title.setText("9p Discord Lite");
        title.setTextColor(Color.WHITE);
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 12, 0, 8);
        title.setTypeface(null, 1);

        TextView description = new TextView(this);
        description.setText("แอปเปิด Discord เวอร์ชันเว็บผ่านเบราว์เซอร์ที่ปลอดภัย\nเข้าสู่ระบบด้วยบัญชี Discord ของคุณได้ตามปกติ");
        description.setTextColor(Color.LTGRAY);
        description.setTextSize(14);
        description.setGravity(Gravity.CENTER);
        description.setPadding(0, 0, 0, 28);

        Button open = new Button(this);
        open.setText("เปิด Discord");
        open.setAllCaps(false);
        open.setOnClickListener(v -> openDiscord());

        page.addView(logo, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        page.addView(title, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        page.addView(description, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        page.addView(open, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView footer = new TextView(this);
        footer.setText("ไม่ใช่แอปทางการของ Discord • ไม่เก็บรหัสผ่านหรือโทเคน");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(11);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 28, 0, 0);
        page.addView(footer);

        setContentView(page);
    }

    private void openDiscord() {
        // Open the official Discord app if it is installed.
        try {
            Intent discord = getPackageManager().getLaunchIntentForPackage("com.discord");
            if (discord != null) {
                startActivity(discord);
                return;
            }
        } catch (Exception ignored) { }

        // Otherwise open Discord Web in a secure browser tab.
        try {
            CustomTabsIntent tabs = new CustomTabsIntent.Builder()
                    .setShowTitle(true)
                    .build();
            tabs.launchUrl(this, Uri.parse(DISCORD_URL));
        } catch (Exception e) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(DISCORD_URL)));
            } catch (Exception ignored) {
                Toast.makeText(this, "ไม่พบแอป Discord หรือเบราว์เซอร์", Toast.LENGTH_LONG).show();
            }
        }
    }
}
