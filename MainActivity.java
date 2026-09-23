package com.gopigeon.v1;

import android.app.*;import android.os.*;import android.graphics.Color;import android.content.*;import android.view.*;import android.widget.*;import java.util.*;

public class MainActivity extends Activity {
 LinearLayout root,body; int blue=Color.rgb(49,92,155); TextView title;
 int dp(float v){return (int)(v*getResources().getDisplayMetrics().density+.5f);} TextView tv(String s,int sp){TextView t=new TextView(this);t.setText(s);t.setTextSize(sp);t.setTextColor(Color.rgb(28,38,55));t.setPadding(dp(4),dp(5),dp(4),dp(5));return t;}
 Button btn(String s){Button b=new Button(this);b.setText(s);b.setAllCaps(false);return b;}
 @Override public void onCreate(Bundle b){super.onCreate(b);showHome();}
 void base(String heading){root=new LinearLayout(this);root.setOrientation(LinearLayout.VERTICAL);root.setBackgroundColor(Color.rgb(247,249,252));
  LinearLayout bar=new LinearLayout(this);bar.setGravity(Gravity.CENTER_VERTICAL);bar.setPadding(dp(16),dp(10),dp(16),dp(10));bar.setBackgroundColor(blue);
  TextView pigeon=tv("🕊️",28); pigeon.setTextColor(Color.WHITE); bar.addView(pigeon,new LinearLayout.LayoutParams(dp(45),dp(55)));
  title=tv(heading,22);title.setTextColor(Color.WHITE);title.setTypeface(null,1);bar.addView(title,new LinearLayout.LayoutParams(0,dp(55),1));
  root.addView(bar); ScrollView sv=new ScrollView(this); body=new LinearLayout(this);body.setOrientation(LinearLayout.VERTICAL);body.setPadding(dp(18),dp(18),dp(18),dp(28));sv.addView(body);root.addView(sv,new LinearLayout.LayoutParams(-1,0,1));setContentView(root); }
 void showHome(){base("Go Pigeon"); TextView sub=tv("बात आपकी, रास्ता हमारा।",18);sub.setPadding(0,0,0,dp(18));body.addView(sub);
  TextView a=tv("🤖  Talk to Pigeon\n\nGo Pigeon AI से सीधे और निजी रूप से बात करें।",18);body.addView(a,new LinearLayout.LayoutParams(-1,dp(145)));Button ba=btn("Talk to Pigeon");body.addView(ba);ba.setOnClickListener(v->showAI());
  TextView f=tv("🕊️  Talk by Pigeon\n\nGo Pigeon को माध्यम बनाकर किसी अनजान मित्र तक अपनी बात पहुँचाएँ और उसका जवाब पाएँ।",18);LinearLayout.LayoutParams fp=new LinearLayout.LayoutParams(-1,dp(165));fp.topMargin=dp(18);body.addView(f,fp);Button bf=btn("Talk by Pigeon");body.addView(bf);bf.setOnClickListener(v->showFriend());
  TextView note=tv("🔒 आपकी पहचान सुरक्षित रखने के लिए V1 में नाम/फोन नंबर दूसरे यूज़र को नहीं दिखाया जाएगा।\n\nV1 लक्ष्य: 10–50 यूज़र। Supabase keys बाद में जोड़ी जाएँगी।",14);note.setPadding(0,dp(22),0,0);body.addView(note); }
 void back(){Button x=btn("← वापस");body.addView(x);x.setOnClickListener(v->showHome());}
 void showAI(){base("Talk to Pigeon");back();body.addView(tv("नमस्ते! मैं Go Pigeon AI हूँ। अपनी बात लिखें।",18));EditText in=new EditText(this);in.setHint("अपनी बात लिखें...");in.setMinLines(4);body.addView(in);Button send=btn("Send");body.addView(send);send.setOnClickListener(v->{String s=in.getText().toString().trim();if(!s.isEmpty()){body.addView(tv("You: "+s,16));body.addView(tv("Go Pigeon: यह V1 UI तैयार है। Supabase/AI जोड़ने के बाद वास्तविक उत्तर आएगा।",16));in.setText("");}});}
 void showFriend(){base("Talk by Pigeon");back();body.addView(tv("अपनी बात लिखें। Go Pigeon इसे अनजान मित्र तक पहुँचाने का माध्यम बनेगा।",18));EditText in=new EditText(this);in.setHint("अपनी बात लिखें...");in.setMinLines(5);body.addView(in);Button send=btn("Send through Go Pigeon");body.addView(send);send.setOnClickListener(v->{String s=in.getText().toString().trim();if(!s.isEmpty()){body.addView(tv("आपका संदेश सुरक्षित रूप से relay होने के लिए तैयार है।",16));body.addView(tv("V1 में Supabase जोड़ने के बाद वास्तविक anonymous replies यहाँ आएँगे।",16));in.setText("");}});}
}
