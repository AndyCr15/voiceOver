package com.androidandyuk.voiceover;

import android.support.v7.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    private static final String TAG = "MainActivity";

    private AdView mAdView;

    MediaPlayer mediaPlayer;

    int[] ana = {R.raw.ana_justicedelivered, R.raw.ana_noscppeneeded, R.raw.ana_areyouscared, R.raw.ana_needsomeone, R.raw.ana_youknownothing, R.raw.ana_damn, R.raw.ana_imwatchingout,
            R.raw.ana_childrenbehave, R.raw.ana_everyonedies, R.raw.ana_ittakesawomantoknow, R.raw.ana_justicerainsfromabove, R.raw.ana_motherknowsbest, R.raw.ana_whatareyouthinking,
            R.raw.ana_witnessme, R.raw.ana_learnfromthepain, R.raw.ana_themooninwinter, R.raw.ana_theghostwatches};
    int[] bastion = {R.raw.bastion_booboodoodedoo, R.raw.bastion_cherrchirrchirr, R.raw.bastion_dadaweee, R.raw.bastion_dundunboopboop, R.raw.bastion_dweetdweetdweet,
            R.raw.bastion_heehoohoo, R.raw.bastion_whoovweeeee, R.raw.bastion_wwwooooo, R.raw.bastion_beeple, R.raw.bastion_bweeeeeeee, R.raw.bastion_shshsh, R.raw.bastion_zwee,
            R.raw.bastion_dweedoohoo, R.raw.bastion_woopdoowoodunwoop, R.raw.bastion_dweeweewoh, R.raw.bastion_zwheeahwheedoowoo};
    int[] soldier = {R.raw.soldier_armyofone, R.raw.soldier_getoffmylawn, R.raw.soldier_ididntstartthiswar, R.raw.soldier_knockknock, R.raw.soldier_notgettinganyyounger, R.raw.soldier_notonmywatch,
            R.raw.soldier_oldsoldiers, R.raw.soldier_smellslikevictory, R.raw.soldier_stayfrosty, R.raw.soldier_stillgotit, R.raw.soldier_thatssirtoyou, R.raw.soldier_theroostercrows,
            R.raw.soldier_whatareyoulookingat, R.raw.soldier_whateveryousay, R.raw.soldier_youdidntmakethecut, R.raw.soldier_youretheotherone, R.raw.soldier_youwantamedal};
    int[] symmetra = {R.raw.symmetra_afrighteningthought, R.raw.symmetra_everythingbydesign, R.raw.symmetra_exquisite, R.raw.symmetra_goodfortune, R.raw.symmetra_hardworkanddedication,
            R.raw.symmetra_howunsightly, R.raw.symmetra_idontthinkso, R.raw.symmetra_imadeyousomething, R.raw.symmetra_impressive, R.raw.symmetra_kindlyadjust, R.raw.symmetra_perfectharmony,
            R.raw.symmetra_precisely, R.raw.symmetra_putyouinyourplace, R.raw.symmetra_suchalackofimagination, R.raw.symmetra_takenunderadvisement, R.raw.symmetra_welcoemtomyreality,
            R.raw.symmetra_whydoyoustruggle};
    int[] mei = {R.raw.mei_1, R.raw.mei_2, R.raw.mei_3, R.raw.mei_4, R.raw.mei_5, R.raw.mei_6, R.raw.mei_7, R.raw.mei_8, R.raw.mei_9, R.raw.mei_10, R.raw.mei_11, R.raw.mei_12,
            R.raw.mei_13, R.raw.mei_14, R.raw.mei_15, R.raw.mei_16, R.raw.mei_17, R.raw.mei_18};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void playSound(View view) {
        String tag = view.getTag().toString();
        Log.i("Play Sound", "Tag " + tag);
        switch (tag) {
            case "ana":
                playRandom(ana);
                break;
            case "bastion":
                playRandom(bastion);
                break;
            case "soldier":
                playRandom(soldier);
                break;
            case "symmetra":
                playRandom(symmetra);
                break;
            case "mei":
                playRandom(mei);
                break;
        }

    }

    public void playRandom(int[] sounds) {

        Random rand = new Random();
        int rndm = rand.nextInt(sounds.length);
        Log.i("playRandomSound", "Number " + rndm);
        mediaPlayer = MediaPlayer.create(this, sounds[rndm]);
        mediaPlayer.start();
    }
}

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
