package com.androidandyuk.voiceover;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    public static FirebaseDatabase database;
    public static DatabaseReference myRef;

    private static final String TAG = "MainActivity";

    private AdView mAdView;

    MediaPlayer mediaPlayer;

    int[] ana = {R.raw.ana_justicedelivered, R.raw.ana_noscppeneeded, R.raw.ana_areyouscared, R.raw.ana_needsomeone, R.raw.ana_youknownothing, R.raw.ana_damn, R.raw.ana_imwatchingout,
            R.raw.ana_childrenbehave, R.raw.ana_everyonedies, R.raw.ana_ittakesawomantoknow, R.raw.ana_justicerainsfromabove, R.raw.ana_motherknowsbest, R.raw.ana_whatareyouthinking,
            R.raw.ana_witnessme, R.raw.ana_learnfromthepain, R.raw.ana_themooninwinter, R.raw.ana_theghostwatches, R.raw.ana18, R.raw.ana19};
    int[] bastion = {R.raw.bastion_booboodoodedoo, R.raw.bastion_cherrchirrchirr, R.raw.bastion_dadaweee, R.raw.bastion_dundunboopboop, R.raw.bastion_dweetdweetdweet,
            R.raw.bastion_heehoohoo, R.raw.bastion_whoovweeeee, R.raw.bastion_wwwooooo, R.raw.bastion_beeple, R.raw.bastion_bweeeeeeee, R.raw.bastion_shshsh, R.raw.bastion_zwee,
            R.raw.bastion_dweedoohoo, R.raw.bastion_woopdoowoodunwoop, R.raw.bastion_dweeweewoh, R.raw.bastion_zwheeahwheedoowoo, R.raw.bastion17, R.raw.bastion18};
    int[] dva = {R.raw.dva1, R.raw.dva2, R.raw.dva3, R.raw.dva4, R.raw.dva5, R.raw.dva6, R.raw.dva7, R.raw.dva8, R.raw.dva9, R.raw.dva10, R.raw.dva11, R.raw.dva12,
            R.raw.dva13, R.raw.dva14, R.raw.dva15, R.raw.dva16, R.raw.dva17, R.raw.dva18, R.raw.dva19};
    int[] doomfist = {R.raw.doomfist1, R.raw.doomfist2, R.raw.doomfist3, R.raw.doomfist4, R.raw.doomfist5, R.raw.doomfist6, R.raw.doomfist7, R.raw.doomfist8, R.raw.doomfist9, R.raw.doomfist10, R.raw.doomfist11};
    int[] genji = {R.raw.genji1, R.raw.genji2, R.raw.genji3, R.raw.genji4, R.raw.genji5, R.raw.genji6, R.raw.genji7, R.raw.genji8, R.raw.genji9, R.raw.genji10, R.raw.genji11, R.raw.genji12,
            R.raw.genji13, R.raw.genji14, R.raw.genji15, R.raw.genji16, R.raw.genji17, R.raw.genji18, R.raw.genji19};
    int[] hanzo = {R.raw.hanzo1, R.raw.hanzo2, R.raw.hanzo3, R.raw.hanzo4, R.raw.hanzo5, R.raw.hanzo6, R.raw.hanzo7, R.raw.hanzo8, R.raw.hanzo9, R.raw.hanzo10, R.raw.hanzo11, R.raw.hanzo12,
            R.raw.hanzo13, R.raw.hanzo14, R.raw.hanzo15, R.raw.hanzo16, R.raw.hanzo17, R.raw.hanzo18, R.raw.hanzo19};
    int[] junkrat = {R.raw.junkrat1, R.raw.junkrat2, R.raw.junkrat3, R.raw.junkrat4, R.raw.junkrat5, R.raw.junkrat6, R.raw.junkrat7, R.raw.junkrat8, R.raw.junkrat9, R.raw.junkrat10, R.raw.junkrat11, R.raw.junkrat12,
            R.raw.junkrat13, R.raw.junkrat14, R.raw.junkrat15, R.raw.junkrat16, R.raw.junkrat17, R.raw.junkrat18, R.raw.junkrat19};
    int[] lucio = {R.raw.lucio1, R.raw.lucio2, R.raw.lucio3, R.raw.lucio4, R.raw.lucio5, R.raw.lucio6, R.raw.lucio7, R.raw.lucio8, R.raw.lucio9, R.raw.lucio10, R.raw.lucio11, R.raw.lucio12,
            R.raw.lucio13, R.raw.lucio14, R.raw.lucio15, R.raw.lucio16, R.raw.lucio17, R.raw.lucio18};
    int[] mccree = {R.raw.mccree1, R.raw.mccree2, R.raw.mccree3, R.raw.mccree4, R.raw.mccree5, R.raw.mccree6, R.raw.mccree7, R.raw.mccree8, R.raw.mccree9, R.raw.mccree10, R.raw.mccree11, R.raw.mccree12,
            R.raw.mccree13, R.raw.mccree14, R.raw.mccree15, R.raw.mccree16, R.raw.mccree17, R.raw.mccree18, R.raw.mccree19};
    int[] mei = {R.raw.mei_1, R.raw.mei_2, R.raw.mei_3, R.raw.mei_4, R.raw.mei_5, R.raw.mei_6, R.raw.mei_7, R.raw.mei_8, R.raw.mei_9, R.raw.mei_10, R.raw.mei_11, R.raw.mei_12,
            R.raw.mei_13, R.raw.mei_14, R.raw.mei_15, R.raw.mei_16, R.raw.mei_17, R.raw.mei_18};
    int[] mercy = {R.raw.mercy1, R.raw.mercy2, R.raw.mercy3, R.raw.mercy4, R.raw.mercy5, R.raw.mercy6, R.raw.mercy7, R.raw.mercy8, R.raw.mercy9, R.raw.mercy10, R.raw.mercy11, R.raw.mercy12,
            R.raw.mercy13, R.raw.mercy14, R.raw.mercy15, R.raw.mercy16, R.raw.mercy17, R.raw.mercy18};
    int[] orisa = {R.raw.orisa1, R.raw.orisa2, R.raw.orisa3, R.raw.orisa4, R.raw.orisa5, R.raw.orisa6, R.raw.orisa7, R.raw.orisa8, R.raw.orisa9, R.raw.orisa10, R.raw.orisa11, R.raw.orisa12,
            R.raw.orisa13, R.raw.orisa14, R.raw.orisa15};
    int[] pharah = {R.raw.pharah1, R.raw.pharah2, R.raw.pharah3, R.raw.pharah4, R.raw.pharah5, R.raw.pharah6, R.raw.pharah7, R.raw.pharah8, R.raw.pharah9, R.raw.pharah10, R.raw.pharah11, R.raw.pharah12,
            R.raw.pharah13, R.raw.pharah14, R.raw.pharah15, R.raw.pharah16, R.raw.pharah17, R.raw.pharah18};
    int[] reaper = {R.raw.reaper1, R.raw.reaper2, R.raw.reaper3, R.raw.reaper4, R.raw.reaper5, R.raw.reaper6, R.raw.reaper7, R.raw.reaper8, R.raw.reaper9, R.raw.reaper10, R.raw.reaper11, R.raw.reaper12,
            R.raw.reaper13, R.raw.reaper14, R.raw.reaper15, R.raw.reaper16, R.raw.reaper17, R.raw.reaper18, R.raw.reaper19};
    int[] reinhardt = {R.raw.reinhardt1, R.raw.reinhardt2, R.raw.reinhardt3, R.raw.reinhardt4, R.raw.reinhardt5, R.raw.reinhardt6, R.raw.reinhardt7, R.raw.reinhardt8, R.raw.reinhardt9, R.raw.reinhardt10, R.raw.reinhardt11, R.raw.reinhardt12,
            R.raw.reinhardt13, R.raw.reinhardt14, R.raw.reinhardt15, R.raw.reinhardt16, R.raw.reinhardt17, R.raw.reinhardt18, R.raw.reinhardt19};
    int[] roadhog = {R.raw.roadhog1, R.raw.roadhog2, R.raw.roadhog3, R.raw.roadhog4, R.raw.roadhog5, R.raw.roadhog6, R.raw.roadhog7, R.raw.roadhog8, R.raw.roadhog9, R.raw.roadhog10, R.raw.roadhog11, R.raw.roadhog12,
            R.raw.roadhog13, R.raw.roadhog14, R.raw.roadhog15, R.raw.roadhog16, R.raw.roadhog17, R.raw.roadhog18};
    int[] soldier = {R.raw.soldier_armyofone, R.raw.soldier_getoffmylawn, R.raw.soldier_ididntstartthiswar, R.raw.soldier_knockknock, R.raw.soldier_notgettinganyyounger, R.raw.soldier_notonmywatch,
            R.raw.soldier_oldsoldiers, R.raw.soldier_smellslikevictory, R.raw.soldier_stayfrosty, R.raw.soldier_stillgotit, R.raw.soldier_thatssirtoyou, R.raw.soldier_theroostercrows,
            R.raw.soldier_whatareyoulookingat, R.raw.soldier_whateveryousay, R.raw.soldier_youdidntmakethecut, R.raw.soldier_youretheotherone, R.raw.soldier_youwantamedal, R.raw.soldier18};
    int[] sombra = {R.raw.sombra1, R.raw.sombra2, R.raw.sombra3, R.raw.sombra4, R.raw.sombra5, R.raw.sombra6, R.raw.sombra7, R.raw.sombra8, R.raw.sombra9, R.raw.sombra10, R.raw.sombra11, R.raw.sombra12,
            R.raw.sombra13, R.raw.sombra14, R.raw.sombra15, R.raw.sombra16, R.raw.sombra17};
    int[] symmetra = {R.raw.symmetra_afrighteningthought, R.raw.symmetra_everythingbydesign, R.raw.symmetra_exquisite, R.raw.symmetra_goodfortune, R.raw.symmetra_hardworkanddedication,
            R.raw.symmetra_howunsightly, R.raw.symmetra_idontthinkso, R.raw.symmetra_imadeyousomething, R.raw.symmetra_impressive, R.raw.symmetra_kindlyadjust, R.raw.symmetra_perfectharmony,
            R.raw.symmetra_precisely, R.raw.symmetra_putyouinyourplace, R.raw.symmetra_suchalackofimagination, R.raw.symmetra_takenunderadvisement, R.raw.symmetra_welcoemtomyreality,
            R.raw.symmetra_whydoyoustruggle, R.raw.symmerta18};
    int[] torbjorn = {R.raw.torbjorn1, R.raw.torbjorn2, R.raw.torbjorn3, R.raw.torbjorn4, R.raw.torbjorn5, R.raw.torbjorn6, R.raw.torbjorn7, R.raw.torbjorn8, R.raw.torbjorn9, R.raw.torbjorn10, R.raw.torbjorn11, R.raw.torbjorn12,
            R.raw.torbjorn13, R.raw.torbjorn14, R.raw.torbjorn15, R.raw.torbjorn16, R.raw.torbjorn17, R.raw.torbjorn18};
    int[] tracer = {R.raw.tracer1, R.raw.tracer2, R.raw.tracer3, R.raw.tracer4, R.raw.tracer5, R.raw.tracer6, R.raw.tracer7, R.raw.tracer8, R.raw.tracer9, R.raw.tracer10, R.raw.tracer11, R.raw.tracer12,
            R.raw.tracer13, R.raw.tracer14, R.raw.tracer15, R.raw.tracer16, R.raw.tracer17, R.raw.tracer18, R.raw.tracer19};
    int[] widowmaker = {R.raw.widowmaker1, R.raw.widowmaker2, R.raw.widowmaker3, R.raw.widowmaker4, R.raw.widowmaker5, R.raw.widowmaker6, R.raw.widowmaker7, R.raw.widowmaker8, R.raw.widowmaker9, R.raw.widowmaker10, R.raw.widowmaker11, R.raw.widowmaker12,
            R.raw.widowmaker13, R.raw.widowmaker14, R.raw.widowmaker15, R.raw.widowmaker16, R.raw.widowmaker17, R.raw.widowmaker18, R.raw.widowmaker19};
    int[] winston = {R.raw.winston1, R.raw.winston2, R.raw.winston3, R.raw.winston4, R.raw.winston5, R.raw.winston6, R.raw.winston7, R.raw.winston8, R.raw.winston9, R.raw.winston10, R.raw.winston11, R.raw.winston12,
            R.raw.winston13, R.raw.winston14, R.raw.winston15, R.raw.winston16, R.raw.winston17, R.raw.winston18, R.raw.winston19};
    int[] zarya = {R.raw.zarya1, R.raw.zarya2, R.raw.zarya3, R.raw.zarya4, R.raw.zarya5, R.raw.zarya6, R.raw.zarya7, R.raw.zarya8, R.raw.zarya9, R.raw.zarya10, R.raw.zarya11, R.raw.zarya12,
            R.raw.zarya13, R.raw.zarya14, R.raw.zarya15, R.raw.zarya16, R.raw.zarya17, R.raw.zarya18, R.raw.zarya19};
    int[] zenyatta = {R.raw.zenyatta1, R.raw.zenyatta2, R.raw.zenyatta3, R.raw.zenyatta4, R.raw.zenyatta5, R.raw.zenyatta6, R.raw.zenyatta7, R.raw.zenyatta8, R.raw.zenyatta9, R.raw.zenyatta10, R.raw.zenyatta11, R.raw.zenyatta12,
            R.raw.zenyatta13, R.raw.zenyatta14, R.raw.zenyatta15, R.raw.zenyatta16, R.raw.zenyatta17, R.raw.zenyatta18};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void playSound(View view) {
        String tag = view.getTag().toString();
        Log.i("Play Sound", "Tag " + tag);

        DatabaseReference thisRef = myRef.child(tag);

        thisRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                if (mutableData.getValue() == null) {
                    mutableData.setValue(1);
                } else {
                    int count = mutableData.getValue(Integer.class);
                    mutableData.setValue(count + 1);
                }
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean success, DataSnapshot dataSnapshot) {
                // Analyse databaseError for any error during increment
            }
        });

        switch (tag) {
            case "ana":
                playRandom(ana);
                break;
            case "bastion":
                playRandom(bastion);
                break;
            case "dva":
                playRandom(dva);
                break;
            case "doomfist":
                playRandom(doomfist);
                break;
            case "genji":
                playRandom(genji);
                break;
            case "hanzo":
                playRandom(hanzo);
                break;
            case "junkrat":
                playRandom(junkrat);
                break;
            case "lucio":
                playRandom(lucio);
                break;
            case "mccree":
                playRandom(mccree);
                break;
            case "mei":
                playRandom(mei);
                break;
            case "mercy":
                playRandom(mercy);
                break;
            case "orisa":
                playRandom(orisa);
                break;
            case "pharah":
                playRandom(pharah);
                break;
            case "reaper":
                playRandom(reaper);
                break;
            case "reinhardt":
                playRandom(reinhardt);
                break;
            case "roadhog":
                playRandom(roadhog);
                break;
            case "soldier":
                playRandom(soldier);
                break;
            case "sombra":
                playRandom(sombra);
                break;
            case "symmetra":
                playRandom(symmetra);
                break;
            case "torbjorn":
                playRandom(torbjorn);
                break;
            case "tracer":
                playRandom(tracer);
                break;
            case "widowmaker":
                playRandom(widowmaker);
                break;
            case "winston":
                playRandom(winston);
                break;
            case "zarya":
                playRandom(zarya);
                break;
            case "zenyatta":
                playRandom(zenyatta);
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
